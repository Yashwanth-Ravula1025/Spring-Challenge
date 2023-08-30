package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.Book;
import com.example.springbootdemo.entity.Shelf;
import com.example.springbootdemo.exception.BookNotFoundException;
import com.example.springbootdemo.exception.ShelfNotFoundException;
import com.example.springbootdemo.repository.BookRepository;
import com.example.springbootdemo.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ShelfRepository shelfRepository;

@PostMapping("/addBook")
public ResponseEntity<Book> addBook(@RequestBody Book book) {
    Shelf shelf = shelfRepository.findById(book.getShelfId())
            .orElseThrow(() -> new ShelfNotFoundException("Shelf with id " + book.getShelfId() + " not found"));

    book.setShelf(shelf);
    return ResponseEntity.ok().body(bookRepository.save(book));
}




    @PostMapping("/addShelf")
    public ResponseEntity<Shelf> addShelf(@RequestBody Shelf newShelf) {
        Shelf savedShelf = shelfRepository.save(newShelf);
        return ResponseEntity.ok().body(savedShelf);
    }




    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok().body(bookRepository.findAll());
    }



    @GetMapping("/getBooksByCategory/{category}")
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String category) throws BookNotFoundException {
        return ResponseEntity.ok().body(bookRepository.findByCategory(category));
    }

    @GetMapping("/getBooksByShelf/{shelf_id}")
    public ResponseEntity<List<Book>> getBooksShelf(@PathVariable Long shelf_id) throws BookNotFoundException{
        List<Book> books = bookRepository.findByShelfId(shelf_id);

        if (!books.isEmpty()) {
            return ResponseEntity.ok().body(books);
        }

        return ResponseEntity.notFound().build();
    }

}

package com.example.springbootdemo.repository;

import com.example.springbootdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByCategory(String category);


    List<Book> findByShelfId(Long shelfId);
}
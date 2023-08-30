package com.example.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="BOOKS_TABLE")
public class Book {

    @Column(name="book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name="book_name")
    private String bookName;
    @Column(name="category_name")
    private String category;

    @Column(name="shelfId")

   @JoinColumn(name = "shelfId", referencedColumnName = "shelf_id")
    private Long shelfId;


    public void setShelf(Shelf shelf) {
    }
}


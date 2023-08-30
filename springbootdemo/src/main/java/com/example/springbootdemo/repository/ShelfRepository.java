package com.example.springbootdemo.repository;

import com.example.springbootdemo.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelfRepository extends JpaRepository<Shelf, Long> {

}

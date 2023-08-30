package com.example.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SHELF_TABLE")
public class Shelf {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String shelf_name;



}


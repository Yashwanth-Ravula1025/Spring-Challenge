package com.example.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    @javax.validation.constraints.NotNull
    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "BookName should not be null")
    private String bookName;
    @javax.validation.constraints.NotNull
    @Pattern(regexp = "^[a-zA-Z0-9\\-.,]+$", message = "Category name should not be null")
    private String category;
}


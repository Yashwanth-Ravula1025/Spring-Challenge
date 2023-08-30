package com.example.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShelfDto {
    @Id
    private Long shelf_id;
    @javax.validation.constraints.NotNull
    @Pattern(regexp = "^[a-zA-Z0-9-]+$", message = "ShelfName should not be null")
    private String shelfName;
}

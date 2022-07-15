package com.example.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookInfo {
	private String title;
	private List<Author> authors = new ArrayList<>();
}

package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceivedBook {

	private String isbn;
	private String title;
	private int book_year;
	private double price;
	private String genre;
	private ReceivedBookAuthor[] authors;
	
}

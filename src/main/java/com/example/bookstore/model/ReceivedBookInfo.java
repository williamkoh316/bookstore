package com.example.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReceivedBookInfo {
	private String title;
	private ReceivedBookAuthor[] authors;
}

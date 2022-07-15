package com.example.bookstore.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceivedBookAuthor {
	private String name;
	private Date birthday;
}

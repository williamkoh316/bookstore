package com.example.bookstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "Book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	private String isbn;
	
	private String title;

	@ManyToMany(targetEntity = Author.class, cascade = CascadeType.ALL)
	@JoinTable(
	  name = "book_author", 
	  joinColumns = @JoinColumn(name = "isbn"), 
	  inverseJoinColumns = {@JoinColumn(name = "author_name"),
			  @JoinColumn(name = "author_birthday")})
	@JsonIgnore
	private List<Author> authors = new ArrayList<>();
	
	private int book_year;
	private double price;
	private String genre;
	
	
	public Book(String isbn, String title, int book_year, double price, String genre, List<Author> authors) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.book_year = book_year;
		this.price = price;
		this.genre = genre;
		this.authors.clear();
		this.authors.addAll(authors);
	}

	
	
	
}

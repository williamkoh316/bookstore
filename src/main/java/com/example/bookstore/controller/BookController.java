package com.example.bookstore.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookInfo;
import com.example.bookstore.model.ReceivedBook;
import com.example.bookstore.model.ReceivedBookAuthor;
import com.example.bookstore.model.ReceivedBookInfo;
import com.example.bookstore.service.BookService;

@RestController
public class BookController {

	@Autowired
	private final BookService bookService;

	public BookController (BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping(path = "/addbook")
	public void addBook(@RequestBody ReceivedBook receivedBook) {
		List<Author> authors = new ArrayList<>();
		for(ReceivedBookAuthor a : receivedBook.getAuthors()) {
			authors.add(new Author(a.getName(), a.getBirthday()));
		}
		
		Book book = new Book(receivedBook.getIsbn(), receivedBook.getTitle(), receivedBook.getBook_year(),
				receivedBook.getPrice(), receivedBook.getGenre(), authors);
		bookService.addBook(book);
	}
	
	@PutMapping(path = "/updatebook")
	public void updateBook(@RequestBody ReceivedBook receivedBook) {
		List<Author> authors = new ArrayList<>();
		for(ReceivedBookAuthor a : receivedBook.getAuthors()) {
			authors.add(new Author(a.getName(), a.getBirthday()));
		}
		
		Book book = new Book(receivedBook.getIsbn(), receivedBook.getTitle(), receivedBook.getBook_year(),
				receivedBook.getPrice(), receivedBook.getGenre(), authors);
		bookService.updateBook(book);
	}
	
	@GetMapping(path = "/getbookexample")
	public ReceivedBook getBook() {
		ReceivedBookAuthor a1 = new ReceivedBookAuthor("a1", new Date(System.currentTimeMillis()));
		ReceivedBookAuthor a2 = new ReceivedBookAuthor("a2", new Date(System.currentTimeMillis()));
		ReceivedBookAuthor[] authors = new ReceivedBookAuthor[] {a1,a2};
		ReceivedBook receivedBook = new ReceivedBook("123abc", "hello book", 2022, 12.50, "Fun", authors);
		return receivedBook;
	}
	
	@GetMapping(path = "/getbookinfoexample")
	public ReceivedBookInfo getBookInfo() {
		ReceivedBookAuthor a1 = new ReceivedBookAuthor("a1", new Date(System.currentTimeMillis()));
		ReceivedBookAuthor a2 = new ReceivedBookAuthor("a2", new Date(System.currentTimeMillis()));
		ReceivedBookAuthor[] authors = new ReceivedBookAuthor[] {a1,a2};
		ReceivedBookInfo receivedBookInfo = new ReceivedBookInfo("hello book", authors);
		return receivedBookInfo;
	}
	
	@GetMapping(path = "/getbook")
	public Book getBook(@RequestBody ReceivedBookInfo receivedBookInfo) {
		List<Author> authors = new ArrayList<>();
		for(ReceivedBookAuthor a : receivedBookInfo.getAuthors()) {
			authors.add(new Author(a.getName(), a.getBirthday()));
		}
		return bookService.getBook(new BookInfo(receivedBookInfo.getTitle(), authors));
	}
	
	@DeleteMapping(path= "/deletebook")
	public String deleteBook (@RequestBody ReceivedBookInfo receivedBookInfo) {
		List<Author> authors = new ArrayList<>();
		for(ReceivedBookAuthor a : receivedBookInfo.getAuthors()) {
			authors.add(new Author(a.getName(), a.getBirthday()));
		}
		return bookService.deleteBook(new BookInfo(receivedBookInfo.getTitle(), authors));
	}

}

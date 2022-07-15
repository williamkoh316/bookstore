package com.example.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookInfo;
import com.example.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	public BookService (BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
	public Book getBook(BookInfo bookInfo) {
		List<Book> books = bookRepository.findBookByTitle(bookInfo.getTitle());
		Book book = new Book();

		for(Book b : books) {
			List<Author> authors = new ArrayList<>(b.getAuthors());
			for (Author a : bookInfo.getAuthors()) {
				if (!authors.remove(a)) {
					break;
				}
			}
			if (authors.isEmpty()) {
				book = b;
				break;
			}
		}
		return book;
	}
	
	public String deleteBook (BookInfo bookInfo) {
		Book book = getBook(bookInfo);
		if (book == null || book.getTitle() == null || book.getTitle().isEmpty()) {
			return "Book Not Found";
			
		} else {
			bookRepository.deleteById(book.getIsbn());
			return "Book Deleted";
		}
	}
}

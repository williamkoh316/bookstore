package com.example.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

	List<Book> findBookByTitle(String title);

}

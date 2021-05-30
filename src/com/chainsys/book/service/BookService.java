package com.chainsys.book.service;

import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;

public interface BookService {
	Set<Book> findAll();
	Book findById(int id) throws BookNotFoundException;
	Book findByName(String name) throws BookNotFoundException;

}

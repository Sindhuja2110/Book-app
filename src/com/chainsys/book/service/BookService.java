package com.chainsys.book.service;


import java.util.List;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;


public interface BookService {
	Set<Book> findAll();
	Book findById(int Book_id) throws BookNotFoundException;
	Book findByName(String Book_name) throws BookNotFoundException;
	List<String> findAllName();
	List<Integer> findAllId();
	void save(Book Book);

	void update(Book Book) throws BookNotFoundException;

	void delete(int Book_id) throws BookNotFoundException;
	
	
	
	
	

}

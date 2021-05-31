package com.chainsys.book.service;

import java.time.LocalDate;
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


	Book findByDate(LocalDate PUBLISH_DATE ) throws BookNotFoundException;
	
	
	
	

}

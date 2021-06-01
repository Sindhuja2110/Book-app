package com.chainsys.book.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;


public interface BookDAO {
	Set<Book> findAll();
	Book findById(int BOOK_ID);
	Book findByName(String Book_name);
	List<String> findAllName();
	List<Integer> findAllId();
	void update(Book Book);
	void save(Book Book);
	void delete(int book_id);
	
	
	
}

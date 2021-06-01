package com.chainsys.book.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.chainsys.book.dao.BookDAO;
import com.chainsys.book.dao.BookDAOImpl;
import com.chainsys.book.exception.BookNotFoundException;
import com.chainsys.book.model.Book;



public class BookServiceImpl implements BookService {
	private static BookDAO dao;

	public BookServiceImpl() {
		dao = new BookDAOImpl();
	}

	@Override
	public Set<Book> findAll() {
		return dao.findAll();
	}
	@Override
	public Book findById(int id) throws BookNotFoundException {
		Book Book = dao.findById(id);
		if (Book == null) {
			throw new BookNotFoundException("Book Id Not Found");
		} 
		else {
			return Book;
		}	}

	
	@Override
	public Book findByName(String book_name) throws BookNotFoundException {
		Book Book = dao.findByName(book_name);
		if (Book == null) {
			throw new BookNotFoundException("Book Name Not Found");
		} else {
			return Book;
		}

	}
	@Override
	public List<String> findAllName() {
		return dao.findAllName();
	}
	@Override
	public List<Integer> findAllId() {
		return dao.findAllId();
	}
	@Override
	public void save(Book Book) {
		dao.save(Book);

	}

	@Override
	public void update(Book Book) throws BookNotFoundException {
		Book result = dao.findById(Book.getBook_id());
		if (result == null) {
			throw new BookNotFoundException("Product Id Not Found");
		} else {
			dao.update(Book);
		}

	}

	@Override
	public void delete(int id) throws BookNotFoundException {
		Book Product = dao.findById(id);
		if (Product == null) {
			throw new BookNotFoundException("Product doesn't exist!!");
		} else {
			dao.delete(id);
		}
	}
	
}

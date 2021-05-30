package com.chainsys.book.service;

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
	public Book findByName(String name) throws BookNotFoundException {
		Book Book = dao.findByName(name);
		if (Book == null) {
			throw new BookNotFoundException("Product Name Not Found");
		} else {
			return Book;
		}

	}
}

package com.chainsys.book.test;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.model.Book;
import com.chainsys.book.service.BookService;
import com.chainsys.book.service.BookServiceImpl;



public class BookClient {
	public static void main(String[] args) {

		Set<Book> bookSet;
		BookService service = new BookServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		String name;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
	}
		scanner.close();
}
}


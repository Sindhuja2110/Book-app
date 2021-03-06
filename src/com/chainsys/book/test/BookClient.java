package com.chainsys.book.test;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.book.exception.BookNotFoundException;
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
		List<String> namelist;
		List<Integer> idlist;
		
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Books");
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
		case 2:
			System.out.println("Find the Book By Id");
			System.out.println("Enter the Book Id");
			id = scanner.nextInt();
			try {
				Book book = service.findById(id);
				System.out.println(book);
			} catch (BookNotFoundException e) {
			}
			break;
		case 3:
			System.out.println("Find the Book By Name");
			System.out.println("Enter the Book Name");
			String Book_Name = scanner.next();
			try {
				Book book = service.findByName(Book_Name);
				System.out.println(book);
			} catch (BookNotFoundException e) {
			}
			break;
			
		case 4:
			System.out.println("Find All Book Names");
			namelist = service.findAllName();
			System.out.println(namelist);
			break;
		case 5:
			System.out.println("Find All Book Id");
			idlist = service.findAllId();
			System.out.println(idlist);
			break;
			
		case 6:
			System.out.println("Adding a Product");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Book newProduct = new Book(104, "java", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			bookSet = service.findAll();
			System.out.println(bookSet);
			break;
			
	default:
				break;
				
				}

	
}
}


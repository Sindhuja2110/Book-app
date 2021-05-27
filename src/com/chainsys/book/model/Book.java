package com.chainsys.book.model;

import java.time.LocalDate;

public class Book {
	private int book_id;
	private String name;
	private LocalDate publishDate;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int book_id, String name, LocalDate publishDate) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.publishDate = publishDate;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + book_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (book_id != other.book_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", name=" + name + ", publishDate=" + publishDate + "]";
	}
	

}

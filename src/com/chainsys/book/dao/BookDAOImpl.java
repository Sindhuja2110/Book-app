package com.chainsys.book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.chainsys.book.model.Book;


public class BookDAOImpl implements BookDAO {
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<Book> bookSet;
	private static ArrayList<String> namelist;
	private static ArrayList<Integer> idlist;
	
	public BookDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:DBEBS12", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Book> findAll() {
		try {
			pstmt = con.prepareStatement("select * from book_2612");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				Book Book = new Book(rs.getInt("BOOK_ID"), rs.getString("BOOK_NAME"),
						rs.getDate("PUBLISH_DATE").toLocalDate());
				bookSet.add(Book);
			}
		} catch (SQLException e) {
			e.printStackTrace();}
		return bookSet;
	}	
		
		
		@Override
		public Book findById(int id) {
			Book book = null;
			try {
				pstmt = con.prepareStatement("select * from book_2612 where BOOK_ID=?");
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					book = new Book(rs.getInt("BOOK_ID"), rs.getString("BOOK_NAME"), rs.getDate("PUBLISH_DATE").toLocalDate());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return book;
		}

		@Override
		public Book findByName(String name) {
			Book book = null;
			try {
				pstmt = con.prepareStatement("select * from book_2612 where BOOK_NAME=?");
				pstmt.setString(1, name);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					book = new Book(rs.getInt("BOOK_ID"), rs.getString("BOOK_NAME"), rs.getDate("PUBLISH_DATE").toLocalDate());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return book;
	}
		@Override
		public List<String> findAllName() {
			try {
				pstmt = con.prepareStatement("select BOOK_NAME from book_2612");
				rs = pstmt.executeQuery();
				 namelist = new ArrayList<>();
				while (rs.next()) {
					namelist.add(rs.getString("BOOK_NAME"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return namelist;
		}

		@Override
		public List<Integer> findAllId() {
			try {
				pstmt = con.prepareStatement("select BOOK_ID from book_2612");
				rs = pstmt.executeQuery();
				 idlist = new ArrayList<>();
				while (rs.next()) {
					idlist.add(rs.getInt("BOOK_ID"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return idlist;
		}
		
		@Override
		public void save(Book Book) {
			try {
				pstmt = con.prepareStatement("insert into Book_2612 values(?,?,?)");
				pstmt.setInt(1, Book.getBook_id());
				pstmt.setString(2, Book.getName());
				pstmt.setDate(3, Date.valueOf(Book.getPublishDate()));
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		@Override
		public void update(Book Book) {
			try {
				pstmt = con.prepareStatement("update Book_2612 set book_name=? where book_id=?");
				pstmt.setString(1, Book.getName());
				pstmt.setInt(2, Book.getBook_id());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		@Override
		public void delete(int id) {
			try {
				pstmt = con.prepareStatement("delete Book_2612 where book_id=?");
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			

		}
		
		
		
	}

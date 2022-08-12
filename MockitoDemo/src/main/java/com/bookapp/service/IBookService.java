package com.bookapp.service;
import com.bookapp.model.*;

import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;

public interface IBookService {

	List<Book> getAll() throws BookNotFoundException;
	List<Book> getBYLessPrice(double price);
	Book getbyId(int bookId)throws BookNotFoundException;
	void addBook(Book book);
	String greetMessage();
	
}

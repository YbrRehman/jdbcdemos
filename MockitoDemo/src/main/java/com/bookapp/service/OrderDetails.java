package com.bookapp.service;

import java.util.*;
import java.util.stream.Collectors;

import com.bookapp.model.*;
import com.bookapp.exceptions.BookNotFoundException;

public class OrderDetails {
	IBookService bookService;

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	public List<Book> findByAuthor(String author) throws BookNotFoundException {
		List<Book> books = bookService.getAll();
		if (books == null) {
			return null;
		}
		if (books.isEmpty()) {
			throw new BookNotFoundException();
		}
		return books.stream().filter(book -> book.getAuthor().equals(author))
				.sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())).collect(Collectors.toList());
	}

	public String orderBook(int bookId)throws BookNotFoundException {
		try
		{
			Book book = bookService.getbyId(bookId);
		     if(book==null)
		    	 return "Out of Stock";
		     return "Book ordered";
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "Technical Issue";
	}

	public String addBook(Book book) {
		if(book==null)
			return "book not added";
		bookService.addBook(book);
		return "book added";
	}

	public String showMessage(String name) {
		String result = bookService.greetMessage();
		if (name.startsWith("p"))
			return result.concat(" ").concat(name);
		else
			return "wrong username";
	}
}

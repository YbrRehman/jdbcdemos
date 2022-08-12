package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderTest {
	@Mock
	IBookService bookservice;
	@InjectMocks
	OrderDetails details;
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	 Book book1,book2,book3,book4,book5,book6;
	  List<Book>bookList=null;

	@BeforeEach
	void setUp() throws Exception {
		book1=new Book(1, "java","kathy", 900);
		book2=new Book(2, "spring","kathy", 900);
		book3=new Book(3, "the 5am","robin", 900);
		book4=new Book(4, "jsp","kathy", 900);
		book5=new Book(5, "leadership","robin", 900);
		book6=new Book(6, "secret","rhonde", 900);
		bookList=Arrays.asList(book1,book2,book3,book4,book5,book6);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		details=null;
		bookList=null;
		book1=null;
		book2=null;
		book3=null;
		book4=null;
		book5=null;
		book6=null;
	}

	    @Test@DisplayName("Book test instance")
	    void testOrderDetails()
	    {
	    	doReturn(book1).when(bookservice).getbyId(1);
	    	String actual=details.orderBook(1);
	    	assertEquals("Book ordered", actual);
	    
	    }
	    @Test@DisplayName("Book by Id exception")
	    void testBookIdExceptin() throws BookNotFoundException
	    {
	    	doThrow(new BookNotFoundException("Invalid Id")).when(bookservice).getbyId(20);
	    	String actual=details.orderBook(20);
	    	assertEquals("Technical Issue", actual);
	    
	    }
	    @Test@DisplayName("Book by Id null")
	    void testBookIdNull()
	    {
	    	doReturn(null).when(bookservice).getbyId(10);
	    	String actual=details.orderBook(10);
	    	assertEquals("Out of Stock", actual);
	    
	    }
	    @Test@DisplayName("Book addding")
	    void testBookAdd()
	    {
	    	doNothing().when(bookservice).addBook(book1);
	    	String actual=details.addBook(book1);
	    	assertEquals("book added", actual);
	    
	    }
	    @Test@DisplayName("add book null")
	    void testBookNull()
	    {
	    	//doNothing().when(bookservice).addBook(book1);;
	    	String actual=details.addBook(null);
	    	assertEquals("book not added", actual);
	    
	    }
	    
	    
	    
}

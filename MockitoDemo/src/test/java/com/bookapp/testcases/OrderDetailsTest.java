package com.bookapp.testcases;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderDetailsTest {
	@Mock
	IBookService bookservice;//mock IBookservce
	//create an object of OrderDetails and BokkService
	//equivalent to
	//details=new OrderDetails()
	//ddetails.setBookService(bookService);
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

    void testShowMessage()
    {
    	Mockito.when(bookservice.greetMessage()).thenReturn("great day");
    	//this is the method to be tested
    	String actual=details.showMessage("priya");
    	assertEquals("great day priya", actual);
    	String nactual=details.showMessage("prachi");
    	assertEquals("great day prachi", nactual);

    	
    }
    @Test
    void testAnShowMessage()
    {
    	Mockito.when(bookservice.greetMessage()).thenReturn("great day");
    	//this is the method to be tested
    	String actual=details.showMessage("raj");
    	assertEquals("wrong username", actual);
    	
    }
    @Test@DisplayName("testing by author-return list")
    void testFindBYAuthor()
    {
    	String author="robin";
    	when(bookservice.getAll()).thenReturn(bookList);
    	List<Book> actualbooks=details.findByAuthor(author);
    	List<Book>expectedbooks=Arrays.asList(book5,book3);
    	assertEquals(expectedbooks, actualbooks);
    	
    	
    }
    @Test@DisplayName("testing by author-check exception")
    void testFindByAuthorException()
    {
    	String author="priya";
    	when(bookservice.getAll()).thenThrow(new BookNotFoundException());
    	assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
    	
    	
    }
    @Test@DisplayName("testing by author-Empty List check")
    void testFindByAuthorEmpty()
    {
    	List<Book>emptyList=new ArrayList<Book>();
    	String author="priya";
    	when(bookservice.getAll()).thenReturn(emptyList);
    	assertThrows(BookNotFoundException.class,()->details.findByAuthor(author));
    	
    	
    }
    @Test@DisplayName("testing by author-null check")
    void testFindByAuthorNull()
    {
    	String author="priya";
    	when(bookservice.getAll()).thenReturn(null);
    	List<Book>actualbooks=details.findByAuthor(author);
    	assertNull(actualbooks);
    	
    	
    }
   
}

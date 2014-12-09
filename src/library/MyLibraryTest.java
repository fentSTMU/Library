package library;

import junit.framework.TestCase;

public class MyLibraryTest extends TestCase 
{

	private Person p1;
	private Person p2;
	private Book b1;
	private Book b2;
	private MyLibrary lib;
	
	public void setUp()
	{
		p1 = new Person();
		p2 = new Person();
		b1 = new Book("Short Book");
		b2 = new Book("Long Book");
		lib = new MyLibrary("Test");
		lib.addPerson(p1);
		lib.addBook(b1);
		lib.addBook(b2);
		lib.addPerson(p2);
	}
	
	public void testBook()
	{
		setUp();
		assertEquals("Test",lib.getName());
	}
	public void testSetName() 
	{
		setUp();
		lib.setName("Library");
		assertEquals("Library",lib.getName());
	}

	public void testGetBooks() 
	{
		setUp();
		lib.addBook(b1);
		lib.addBook(b2);
		assertEquals(b1,lib.getBooks().get(0));
		assertEquals(b2,lib.getBooks().get(1));
	}

	public void testAddBook() 
	{
		setUp();
		lib.addBook(b1);
		lib.addBook(b2);
		assertEquals(b2,lib.getBooks().get(1));
	}

	public void testAddPerson() 
	{
		setUp();
		assertEquals(p2,lib.getPeople().get(1));
	}

	public void testRemoveBook() 
	{
		setUp();
		assertEquals(b2,lib.getBooks().get(1));
		lib.removeBook(1);
		assertEquals(-1,lib.getBooks().indexOf(b2));
	}

	public void testRemovePerson() 
	{
		setUp();
		assertEquals(p2,lib.getPeople().get(1));
		lib.removePerson(1);
		assertEquals(-1,lib.getPeople().indexOf(p2));
	}

	public void testGetPeople() 
	{
		setUp();
		assertEquals(p1,lib.getPeople().get(0));
		assertEquals(p2,lib.getPeople().get(1));
	}
	
	public void	testBookCheckout()
	{
		setUp();
		p1.setMaximumBooks(1);
		assertTrue(lib.bookCheckout(b1,p1));
		assertEquals(p1,b1.getBorrower());
		assertFalse(lib.bookCheckout(b2, p1));
		assertFalse(lib.bookCheckout(b1,p2));
		assertEquals(1,p1.getCurrentBooks());
		
	}
	
	public void testBookCheckin()
	{
		setUp();
		assertTrue(lib.bookCheckout(b1,p1));
		assertEquals(p1,b1.getBorrower());
		assertFalse(lib.bookCheckout(b1, p2));
		assertTrue(lib.bookCheckin(b1,p1));
		assertTrue(lib.bookCheckout(b1, p2));
	}
	public void testGetBookCount()
	{
		setUp();
		assertEquals(0,lib.getCountOfBooks(p1));
		lib.bookCheckout(b1, p1);
		assertEquals(1,lib.getCountOfBooks(p1));
		lib.bookCheckout(b2, p1);
		assertEquals(2,lib.getCountOfBooks(p1));
		lib.bookCheckin(b1, p1);
		assertEquals(1,lib.getCountOfBooks(p1));
		lib.bookCheckin(b2, p1);
		assertEquals(0,lib.getCountOfBooks(p1));
	}
	public void testGetAvailableBooks()
	{
		setUp();
		assertEquals(2,lib.getAvailableBooks().size());
		lib.bookCheckout(b1, p1);
		assertEquals(1,lib.getAvailableBooks().size());
		lib.bookCheckout(b2, p1);
		assertEquals(0,lib.getAvailableBooks().size());
		lib.bookCheckin(b1, p1);
		assertEquals(1,lib.getAvailableBooks().size());
		lib.bookCheckin(b2, p1);
		assertEquals(2,lib.getAvailableBooks().size());
	}
}

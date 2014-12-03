package library;

import junit.framework.TestCase;

public class BookTest extends TestCase {

	public void testGetBorrower() {
		Book b = new Book("Testing");
		Person p = new Person();
		p.setName("Fred Flintstone");
		p.setMaximumBooks(6);
		b.setBorrower(p);
		assertEquals(p,b.getBorrower());
	}

	public void testSetTitle() {
		Book b = new Book("Testing");
		b.setTitle("Different");
		assertEquals("Different",b.getTitle());
	}

	public void testSetAuthor() {
		Book b = new Book("Testing");
		b.setAuthor("Writer");
		assertEquals("Writer",b.getAuthor());
	}
	
	public void testToString(){
		MyLibrary lib = new MyLibrary("Test");
		Person p = new Person();
		lib.addPerson(p);
		Book great = new Book("The Great Expectations");
		great.setAuthor("Charles Dickens");
		lib.addBook(great);
		
		assertEquals("The Great Expectations by Charles Dickens; available",great.toString());
		lib.bookCheckout(great, p);
		assertEquals("The Great Expectations by Charles Dickens; unavailable",great.toString());
	}
	
}

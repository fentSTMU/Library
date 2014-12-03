package library;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

	public void testPerson() 
	{
		Person p = new Person();
		assertEquals("unknown name",p.getName());
		assertEquals(3,p.getMaximumBooks());
	}

	public void testSetName() 
	{
		Person p = new Person();
		p.setName("Fred");
		assertEquals("Fred",p.getName());
	}

	public void testSetMaximumBooks() 
	{
		Person p = new Person();
		p.setMaximumBooks(6);
		assertEquals(6,p.getMaximumBooks());
	}
	
	public void testToString()
	{
		Person p = new Person();
		p.setName("Fred Flintstone");
		p.setMaximumBooks(6);
		assertEquals("Fred Flintstone(6 books)",p.toString());
	}

}

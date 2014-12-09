package library;
import java.util.*;
public class MyLibrary 
{
	private String name;
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Person> people = new ArrayList<Person>();
	
	public MyLibrary(String n)
	{
		name = n;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public ArrayList<Book> getBooks() 
	{
		return books;
	}
	
	public void addBook(Book b1)
	{
		books.add(b1);
	}
	
	public void addPerson(Person p1)
	{
		people.add(p1);
	}
	
	public void removeBook(int index)
	{
		books.remove(index);
	}
	
	public void removePerson(int index)
	{
		people.remove(index);
	}
	
	public ArrayList<Person> getPeople() 
	{
		return people;
	}

	public boolean bookCheckout(Book b1, Person p1) 
	{
		if((b1.getBorrower() == null) && (this.getCountOfBooks(p1) < p1.getMaximumBooks()))
		{
			b1.setBorrower(p1);
			p1.setCurrentBooks(p1.getCurrentBooks() + 1);
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean bookCheckin(Book b1, Person p1) 
	{
		if(b1.getBorrower() == p1)
		{
			b1.setBorrower(null);
			p1.setCurrentBooks(p1.getCurrentBooks() - 1);
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getCountOfBooks(Person p1) 
	{
		int bookCount = 0;
		int index = 0;
		ArrayList<Book> allBooks = this.getBooks();
		
		if(allBooks == null)
		{
			return bookCount;
		}
		
		
		for(index = 0; index < allBooks.size(); index++)
		{
			if((allBooks.get(index).getBorrower() != null) && (allBooks.get(index).getBorrower().getName().compareTo(p1.getName()) == 0))
			{
				bookCount++;
			}
		}
		return bookCount;
	}

	public ArrayList<Book> getAvailableBooks() 
	{
		int index = 0;
		ArrayList<Book> allBooks = this.getBooks();
		ArrayList<Book> avlBooks = new ArrayList<Book>();
		
		if(allBooks == null)
		{
			return avlBooks;
		}
		
		
		for(index = 0; index < allBooks.size(); index++)
		{
			if((allBooks.get(index).getBorrower() == null))
			{
				avlBooks.add(allBooks.get(index));
			}
		}
		return avlBooks;
	}

	
	
	
}

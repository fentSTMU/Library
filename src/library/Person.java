package library;

public class Person {
	
	private String name;
	private int maximumBooks;
	private int currentBooks;

	public int getCurrentBooks() 
	{
		return currentBooks;
	}

	public void setCurrentBooks(int currentBooks) 
	{
		this.currentBooks = currentBooks;
	}

	public Person()
	{
		name = "unknown name";
		maximumBooks = 3;
		currentBooks = 0;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getMaximumBooks() 
	{
		return maximumBooks;
	}

	public void setMaximumBooks(int maximumBooks) 
	{
		this.maximumBooks = maximumBooks;
	}
	
	public String toString()
	{
		return "" + name + "(" + maximumBooks + " books)";
	}
	
}

package library;

public class Book 
{

	private String title = "No Title";
	private String author = "No Author";
	private Person borrower = null;
	
	public Book(String title)
	{
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setBorrower(Person p) {
		borrower = p;
		
	}
	public Person getBorrower() {
		// TODO Auto-generated method stub
		return borrower;
	}

	
	public String toString()
	{
		String avail = "unavailable";
		if(this.getBorrower() == null){
			avail = "available";
		}
		return this.getTitle() + " by " + this.getAuthor() + "; " + avail;
	}
	
	
	
	
}

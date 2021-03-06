package com.training.library;

import com.training.exceptions.RangeCheckException;

/**
 * 
 * @author Srivatsan
 * @version 1.0
 */
public class Book {

	private String bookName;
	private String author;
	private double price;
	private int pageCount;
	
	public Book() {
		super();
	
	}
// Declare Rule
	public Book(String bookName, String author, double price, int pageCount)  throws RangeCheckException {
		super();
		this.bookName = bookName;
		this.author = author;
		if(price < 100 || price >10000)
		{
			throw new RangeCheckException("Price Should be 100 - 10000");  // throwing Custom Exception
		}
		else
		{
		     this.price = price;
		}
		this.pageCount = pageCount;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}
// Handle Rule 
	public void setPrice(double price) {
		
		
			if(price<100 ||  price >10000)
			{
				try
				{
						throw new RangeCheckException("Price should be 100 -10000");
				}
				 catch(RangeCheckException e)
				 	{
					System.err.println(e.getMessage());
				}		
			}
			   
		else
		{
		  this.price = price;
		}
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
	public String toString(){
		
		return this.bookName + ":"+ this.author + ":" + this.price + ":" + this.pageCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	
}

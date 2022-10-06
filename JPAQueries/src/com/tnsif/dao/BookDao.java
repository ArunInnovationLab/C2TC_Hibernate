package com.tnsif.dao;

import java.util.List;

import com.tnsif.entities.Book;


public interface BookDao {

	public abstract Book getBookById(int id);
	
	public abstract List<Book> getBookByTitle(String Title); 
	
	public abstract Long getBookCount();
	
	public abstract List<Book> getAuthorBooks(String author);
	
	public abstract List<Book> getAllBooks();
	
	public abstract List<Book> getBookInPriceRange(double low,double high);	
	
}

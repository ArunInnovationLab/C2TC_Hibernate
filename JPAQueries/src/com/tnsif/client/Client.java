package com.tnsif.client;

import com.tnsif.entities.Book;
import com.tnsif.service.BookServiceImpl;

public class Client {

	public static void main(String[] args) {

		BookServiceImpl service = new BookServiceImpl();
		
		System.out.println(service.getBookById(101));
		
		System.out.println("*************************************");
		
		for(Book book:service.getBookByTitle("Java Closures and Lambda")) {
			System.out.println(book);
		}
		
		System.out.println("*************************************");
		
		System.out.println(service.getBookCount());
		
		System.out.println("****************************************");
		
		for(Book b:service.getAuthorBooks("Robert Fischer")){
			System.out.println(b);
		}
		
		System.out.println("**************************************");
		
		for(Book book:service.getAllBooks()) {
			System.out.println(book);
		}
		
		System.out.println("***************************************");
		
		for(Book book:service.getBooksInPriceRange(500, 600)) {
			System.out.println(book);
		}
		
	}
		
}

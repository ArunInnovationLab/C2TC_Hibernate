package com.tnsif.client;

import com.tnsif.service.BookService;
import com.tnsif.service.BookServiceImpl;

public class Client {

	public static void main(String[] args) {

		BookService service = new BookServiceImpl();
		
		//System.out.println(service.getBookById(101));
		
		System.out.println(service.getBookByTitle("Java"));
		
		//System.out.println(service.getBookCount());
	}

}

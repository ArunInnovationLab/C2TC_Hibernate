package com.tnsif.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.tnsif.entities.Book;

public class BookDaoImpl implements BookDao {

	private EntityManager entityManager;
	
	public BookDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Book getBookById(int id) {
		Book book = entityManager.find(Book.class, id);
		return book;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		String qStr = "SELECT books FROM Book books WHERE books.title LIKE: btitle";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("btitle", "%"+title+"%");
		return query.getResultList();
	}

	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(books.id) FROM Book books";
		TypedQuery<Long> query = entityManager.createQuery(qStr, Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBookInPriceRange(double low, double high) {
		// TODO Auto-generated method stub
		return null;
	}

}

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
		String qStr = "SELECT book FROM Book book WHERE book.title LIKE: ptitle";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("ptitle", "%"+title+"%");
		return query.getResultList();
	}

	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(book.id) FROM Book book";
		TypedQuery<Long> query = entityManager.createQuery(qStr, Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		String qStr = "SELECT book FROM Book book WHERE book.author=:pauthor";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("pauthor",author);
		List<Book> bookList= query.getResultList();
		return bookList;
	}

	@Override
	public List<Book> getAllBooks() {
		TypedQuery<Book> query = entityManager.createNamedQuery("getAllBooks", Book.class);
		List<Book> bookList = query.getResultList();
		return bookList;
	}

	@Override
	public List<Book> getBookInPriceRange(double low, double high) {
		String qStr = "SELECT b from Book b WHERE b.price between :low and :high";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		List<Book> bookList = query.getResultList();
		return bookList;
	}

}

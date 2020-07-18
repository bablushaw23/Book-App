package com.bookapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookapp.entity.Book;

@Repository
public class BookDaoImpl implements BookDAO {

	//injecting session factory
	@Autowired
	private SessionFactory sessionFactory;  // should be same as bean id in step 2 inside spring-mvc-crud-demo-servlet.xml
	
	@Override
	public List<Book> getBooks() {
		
		// get current hibernate session
		Session session= sessionFactory.getCurrentSession(); 
		
		// create query
		Query<Book> query=session.createQuery("from Book order by title", Book.class);	// i m selecting from entity Book, not table book
		
		// execute query and get result list
		List<Book> books= query.getResultList();
		
		//return result
		return books;
	}

	@Override
	public void saveBook(Book book) {
		
		// get current session
		Session session= sessionFactory.getCurrentSession();
		//save customer if id not found, else update if id is available in model
		session.saveOrUpdate(book);
		
	}

	@Override
	public Book editBook(String id) {
		// get current session
		Session session= sessionFactory.getCurrentSession();
		
		// fetch book with id
		Book theBook=session.get(Book.class, id);
		return theBook;
		
	}

	@Override
	public void deleteBook(String id) {
		Session session= sessionFactory.getCurrentSession();
		Book book=session.get(Book.class, id);
		session.delete(book);
	}

	@Override
	public List<Book> searchBook(String keyword) {
		// get current hibernate session
		Session session= sessionFactory.getCurrentSession(); 
		
		// create query
		Query<Book> query=session.createQuery(" FROM Book b WHERE title LIKE '%"+keyword+"%' or author LIKE '%"+keyword+"%'", Book.class);	// i m selecting from entity Book, not table book
		
		// execute query and get result list
		List<Book> books= query.getResultList();
		
		//return result
		return books;
	}

}

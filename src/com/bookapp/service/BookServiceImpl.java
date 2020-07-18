package com.bookapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.dao.BookDAO;
import com.bookapp.entity.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	//injecting bookdao
	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	@Override
	public void saveBook(Book book) {
		bookDAO.saveBook(book);
		
	}

	@Override
	public Book getBook(String id) {
		return bookDAO.editBook(id);
	}

	@Override
	public void deleteBook(String id) {
		bookDAO.deleteBook(id);
		
	}

	@Override
	public List<Book> searchBook(String keyword) {
		return bookDAO.searchBook(keyword);
	}

}

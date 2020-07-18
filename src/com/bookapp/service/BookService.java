package com.bookapp.service;

import java.util.List;
import com.bookapp.entity.Book;

public interface BookService {
	
	public List<Book> getBooks();

	public void saveBook(Book book);

	public Book getBook(String id);

	public void deleteBook(String id);

	public List<Book> searchBook(String keyword);

}

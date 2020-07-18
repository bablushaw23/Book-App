package com.bookapp.dao;

import java.util.List;
import com.bookapp.entity.Book;

public interface BookDAO {
	
	public List<Book> getBooks();

	public void saveBook(Book book);

	public Book editBook(String id);

	public void deleteBook(String id);

	public List<Book> searchBook(String keyword);
}

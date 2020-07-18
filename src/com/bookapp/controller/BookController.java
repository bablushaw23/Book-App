package com.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookapp.entity.Book;
import com.bookapp.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	// injecting BookService
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String listController(Model model) {
		
		//get book from service
		List<Book> bookList=bookService.getBooks();
		
		//add book to model
		model.addAttribute("books", bookList);
		return "list-books";
	}
	
	@RequestMapping("/edit")
	public String editBook(@RequestParam("id") String id, Model model)
	{
		// get book from db
		Book book= bookService.getBook(id);
		
		//set book to model
		model.addAttribute("theBook",book);
		
		//open view
		return "edit-form";
	}
	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam("id") String id)
	{
		bookService.deleteBook(id);
		return "redirect:list";
	}
	
	@GetMapping("/search")
	public String searchBook(@RequestParam("keyword")String keyword, Model model)
	{
		//get book from service
		List<Book> bookList=bookService.searchBook(keyword);
		
		//add book to model
		model.addAttribute("result", bookList);
		return "search-result";
	}
	
	@GetMapping("/addbook")
	public String showAddNewBookForm(Model model)
	{
		Book book= new Book();
		model.addAttribute("book",book);
		return "add-new-book-form";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book book)
	{
		bookService.saveBook(book);
		return "redirect:list";
	}
	
	@GetMapping("/addsamplebooks")
	public String addSampleBooks()
	{
		Book book= new Book();
		
		book.setTitle("Art Of War");
		book.setAuthor("Sun Tzu");
		book.setAvailability(true);
		book.setCategory("Inspiration");
		
		bookService.saveBook(book);
		
		return "redirect:list";
	}
}

package com.bookapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@Column(name="id")
	private String id;
	
	@NonNull
	@Column(name="title", nullable=false)
	private String title;
	
	@NonNull
	@Column(name="author", nullable=false)
	private String author;
	
	@Column(name="category")
	private String category;
	
	@Column(name="availability")
	private Boolean availability;
	
	public Book()
	{	
		
	}
	
	public Book(String id, String title, String author, String category, Boolean availability) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.availability = availability;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", availability=" + availability + "]";
	}
	
	
}

	
	
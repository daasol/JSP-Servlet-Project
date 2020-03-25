package com.servlet.dto;

public class BooksDTO {
	int book_id;
	String title;
	String publisher;
	String year;
	int price;
	
	
	public BooksDTO(int book_id, String title, String publisher,String year, int price ){
		this.book_id=book_id;
		this.title=title;
		this.publisher=publisher;
		this.year=year;
		this.price=price;
		
	}


	public int getBook_id() {
		return book_id;
	}


	public String getTitle() {
		return title;
	}


	public String getPublisher() {
		return publisher;
	}


	public String getYear() {
		return year;
	}


	public int getPrice() {
		return price;
	}
}

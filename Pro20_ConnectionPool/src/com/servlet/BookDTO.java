package com.servlet;

public class BookDTO {
	int book_id;
	String title;
	String publisher;
	String year;
	int price;
	
	public BookDTO(int book_id, String title, String publisher,String year, int price ){
		this.book_id=book_id;
		this.title=title;
		this.publisher=publisher;
		this.year=year;
		this.price=price;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}

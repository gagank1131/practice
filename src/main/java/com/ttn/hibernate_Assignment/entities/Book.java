package com.ttn.hibernate_Assignment.entities;

import javax.persistence.*;

@Entity
public class Book {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    
    private  String bookName;
    
    @ManyToOne
    Author author;
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public String getBookName() {
        return bookName;
    }
    
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

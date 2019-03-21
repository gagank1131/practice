package com.ttn.hibernate_Assignment;

import com.ttn.hibernate_Assignment.entities.Author;
import com.ttn.hibernate_Assignment.entities.Book;
import com.ttn.hibernate_Assignment.repositories.AuthorCRUD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {
    public static void main(String[] args) {
        
        AuthorCRUD authorCRUD = new AuthorCRUD();
        
        Book book = new Book();
        book.setBookName("data structures");
        Book book1 = new Book();
        book1.setBookName("computer organisation");
        Book book2 = new Book();
        book2.setBookName("DBMS");
        
        
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        
        
        session.beginTransaction();
        session.save(book);
        session.save(book1);
        session.save(book2);
       Author author1= authorCRUD.createAuthor(session, "arpit", "gupta", 25,12,"shalimar bagh","delhi");
       author1.getBooks().add(book);
       author1.getBooks().add(book1);
       session.save(author1);
        session.getTransaction().commit();
        
        session.beginTransaction();
       Author author2 = authorCRUD.createAuthor(session, "prateek", "nagar", 25,20,"paschim vihar","delhi");
       author2.getBooks().add(book2);
       
       session.save(author2);
        session.getTransaction().commit();
        
        session.beginTransaction();
        authorCRUD.readAuthor(session, 1);
        session.getTransaction().commit();
        
        session.beginTransaction();
        authorCRUD.updateAuthor(session, 1, 21);
        session.getTransaction().commit();
        
//        session.beginTransaction();
//        authorCRUD.deleteAuthor(session, 1);
//        session.getTransaction().commit();
        
    session.close();
        
    }
}

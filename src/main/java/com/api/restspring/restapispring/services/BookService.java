package com.api.restspring.restapispring.services;

 
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.restspring.restapispring.dao.BookRepo;
import com.api.restspring.restapispring.entities.Book;

@Component
public class BookService {
   
    @Autowired
    private BookRepo bookRepo ;
    
    public List<Book> getAllBooks() {
         List<Book> list = (List<Book>) this.bookRepo.findAll();
         return list;
    }

    
    public Book getBookById(int id) {
        Book book = null;
        try{
            book = this.bookRepo.findById(id) ;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
      
        return book;
    }
     
    public Book addBook(Book book) {
        return  bookRepo.save(book);
    }
    // delete book
    public void deleteBook(int id) {
         bookRepo.deleteById(id);
    }


    public void updateBook(Book book, int id) {
        book.setId(id);
        bookRepo.save(book) ;
    }
}

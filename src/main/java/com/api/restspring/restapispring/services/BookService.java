package com.api.restspring.restapispring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.restspring.restapispring.entities.Book;

@Component
public class BookService {
    private static List<Book> list = new ArrayList<>(); 

    static {
        // some java book 
        Book b1 = new Book(1, "Java", "James Gosling");
        Book b2 = new Book(2, "Spring", "Rod Johnson");
        Book b3 = new Book(3, "Hibernate", "Gavin King");
        Book b4 = new Book(4, "Spring Boot New", "Rod Johnson");

        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);


    }
    public List<Book> getAllBooks() {
        return list;
    }

    
    public Book getBookById(int id) {
        Book book = null;
        try{
            book = list.stream().filter(e->e.getId()==id)
            .findFirst().get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
      
        return book;
    }
     
    public Book addBook(Book book) {
        list.add(book);
        return book;
    }
    // delete book
    public void deleteBook(int id) {
        list = list.stream().filter(e->e.getId()!=id)
                    .collect(Collectors.toList());
    }


    public void updateBook(Book book, int id) {
        list = list.stream().map(b->{
            if(b.getId()==id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b; 
        }).collect(Collectors.toList());
    }
}

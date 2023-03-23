package com.api.restspring.restapispring.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.restspring.restapispring.entities.Book;

public interface BookRepo extends CrudRepository<Book,Integer> {
    public Book findById(int id) ;
}

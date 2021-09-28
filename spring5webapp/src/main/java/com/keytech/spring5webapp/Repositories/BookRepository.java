package com.keytech.spring5webapp.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.keytech.spring5webapp.Models.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}

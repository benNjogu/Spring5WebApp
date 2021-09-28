package com.keytech.spring5webapp.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.keytech.spring5webapp.Models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

	
	
}

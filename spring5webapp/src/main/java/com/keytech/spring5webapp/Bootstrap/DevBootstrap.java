package com.keytech.spring5webapp.Bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.keytech.spring5webapp.Models.Author;
import com.keytech.spring5webapp.Models.Book;
import com.keytech.spring5webapp.Repositories.AuthorRepository;
import com.keytech.spring5webapp.Repositories.BookRepository;

@Component //->makes this a spring bean
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	private void initData() {
		
		//Eric
		Author eric = new Author("Eric", "Kinuthia");
		Book ddd = new Book("Domain driven design", "1234", "LongHorn publishers");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "234444", "Jommo Kenyatta Foundation");
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
}

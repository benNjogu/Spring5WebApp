package com.keytech.spring5webapp.Bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.keytech.spring5webapp.Models.Author;
import com.keytech.spring5webapp.Models.Book;
import com.keytech.spring5webapp.Models.Publisher;
import com.keytech.spring5webapp.Repositories.AuthorRepository;
import com.keytech.spring5webapp.Repositories.BookRepository;
import com.keytech.spring5webapp.Repositories.PublisherRepository;

@Component //->makes this a spring bean
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {
		
		//Eric
		Author eric = new Author("Eric", "Kinuthia");
		Book ddd = new Book("Domain driven design", "1234");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "234444");
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		Publisher klb = new Publisher("KLB Publishers", "SomewhereInNairobi78543");
		Book klbPhysics = new Book("KlbPhysics", "67878345787");
		klb.getBooks().add(klbPhysics);
		
		bookRepository.save(klbPhysics);
		publisherRepository.save(klb);
		
		Publisher longHorn = new Publisher("LongHorn Publishers", "SomewhereInNairobi789");
		Book chemBook = new Book("Longhorn Chemistry", "675787");
		longHorn.getBooks().add(chemBook);
		
		bookRepository.save(chemBook);
		publisherRepository.save(longHorn);
		
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}
	
}

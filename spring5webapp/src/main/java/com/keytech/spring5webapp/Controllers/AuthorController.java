package com.keytech.spring5webapp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keytech.spring5webapp.Repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;
	
	
	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}


	@RequestMapping("/author")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors";
		
	}
	
}

package com.keytech.mypersonalspring5project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keytech.mypersonalspring5project.Repositories.ManufacturerRepository;

@Controller
public class ManufacturersController {

	private ManufacturerRepository manufacturerRepository;

	public ManufacturersController(ManufacturerRepository manufacturerRepository) {
		super();
		this.manufacturerRepository = manufacturerRepository;
	}
	
	@RequestMapping("/manufacturers")
	private String getManufacturers(Model model) {
		
		model.addAttribute("manufacturers", manufacturerRepository.findAll());
		
		return "manufacturers";
	}
	
}

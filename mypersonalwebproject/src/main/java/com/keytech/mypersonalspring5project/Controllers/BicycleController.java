package com.keytech.mypersonalspring5project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.keytech.mypersonalspring5project.Repositories.BicycleRepository;

@Controller
public class BicycleController {

	private BicycleRepository bicycleRepository;

	public BicycleController(BicycleRepository bicycleRepository) {
		super();
		this.bicycleRepository = bicycleRepository;
	}

	@RequestMapping("/bicycles")
	private String getBicycles(Model model) {

		model.addAttribute("bicycles", bicycleRepository.findAll());

		return "bicycles";
	}

}

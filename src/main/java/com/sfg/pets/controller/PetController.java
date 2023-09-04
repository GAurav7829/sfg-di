package com.sfg.pets.controller;

import org.springframework.stereotype.Controller;

import com.sfg.pets.PetService;

@Controller
public class PetController {
	
	private final PetService petService;

	public PetController(PetService petService) {
		super();
		this.petService = petService;
	}
	
	public String getPetType() {
		return petService.getPetType();
	}

}

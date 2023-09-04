package com.sfg.pets;

//@Service	// added in GreetingServiceConfig
public class PetServiceFactory {
	public PetService getPetService(String petType) {
		switch (petType) {
		case "cat":
			return new PetServiceImpl();
		default:
			return null;
		}
	}
}

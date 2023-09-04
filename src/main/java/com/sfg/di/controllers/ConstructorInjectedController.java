package com.sfg.di.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.sfg.di.services.GreetingService;

@Controller
public class ConstructorInjectedController {

	private final GreetingService greetingService;

//	@Autowired	// autowired is optional in constructor based dependency injection
	public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	public String getGreeting() {
		return greetingService.sayGreeting();
	}

}

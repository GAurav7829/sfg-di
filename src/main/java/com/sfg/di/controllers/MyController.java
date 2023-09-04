package com.sfg.di.controllers;

import org.springframework.stereotype.Controller;

import com.sfg.di.services.GreetingService;

@Controller
public class MyController {

	private final GreetingService greetingService;

	public MyController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	public String helloWorld() {
		System.out.println("Hello World");
		return greetingService.sayGreeting();
	}
}

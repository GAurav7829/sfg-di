package com.sfg.di.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sfg.di.services.ConstructorGreetingService;

public class SetterInjectedControllerTest {
	
	SetterInjectedController controller;
	
	@BeforeEach
	void setup() {
		controller = new SetterInjectedController();
		controller.setGreetingService(new ConstructorGreetingService());
	}
	
	@Test
	void getGreeting() {
		System.out.println(controller.getGreeting());
	}

}

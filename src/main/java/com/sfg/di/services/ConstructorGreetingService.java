package com.sfg.di.services;

//@Service // define in GreetingServiceConfig
public class ConstructorGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World - constructor";
	}

}

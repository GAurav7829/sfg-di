package com.sfg.di.services;

//@Service
//@Primary	//added in GreetingServiceConfig
public class PrimaryGreetingService implements GreetingService {
	
	@Override
	public String sayGreeting() {
		return "Hello World - primary";
	}

}

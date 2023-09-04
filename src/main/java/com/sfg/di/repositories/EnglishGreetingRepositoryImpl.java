package com.sfg.di.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

	@Override
	public String getGreeting() {
		return "Hello - English Greeting service";
	}
}

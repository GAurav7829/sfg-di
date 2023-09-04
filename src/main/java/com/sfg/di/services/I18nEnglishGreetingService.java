package com.sfg.di.services;

import com.sfg.di.repositories.EnglishGreetingRepository;

//@Profile("EN")
//@Service("i18nService") // added in GreetingServiceConfig
public class I18nEnglishGreetingService implements GreetingService {
	
	private final EnglishGreetingRepository englishGreetingRepository;

	public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
		super();
		this.englishGreetingRepository = englishGreetingRepository;
	}

	@Override
	public String sayGreeting() {
		return "Hello World - EN :: " + englishGreetingRepository.getGreeting();
	}

}

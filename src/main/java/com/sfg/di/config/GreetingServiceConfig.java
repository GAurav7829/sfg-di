package com.sfg.di.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.sfg.di.datasource.FakeDataSource;
import com.sfg.di.repositories.EnglishGreetingRepository;
import com.sfg.di.repositories.EnglishGreetingRepositoryImpl;
import com.sfg.di.services.ConstructorGreetingService;
import com.sfg.di.services.I18nEnglishGreetingService;
import com.sfg.di.services.PrimaryGreetingService;
import com.sfg.pets.PetService;
import com.sfg.pets.PetServiceFactory;

@Configuration
@ImportResource("classpath:sfg-di-config.xml") // can also be added in main class
//@PropertySource("classpath:datasource.properties") //added in application.properties
public class GreetingServiceConfig {
//	@Bean	// added in sfg-di-config.xml
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}

	@Bean
	@Primary
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}

	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}

	@Bean("i18nService") // specify the bean name
	@Profile("EN")
	I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
		return new I18nEnglishGreetingService(englishGreetingRepository);
	}

	@Bean
	PetServiceFactory petServiceFactory() {
		return new PetServiceFactory();
	}

	@Bean
	PetService petService() {
		return petServiceFactory().getPetService("cat"); // passing petType
	}

	@Bean
	FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
			@Value("${guru.password}") String password, @Value("${guru.jdbcUrl}") String url) {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUsername(username);
		fakeDataSource.setPassword(password);
		fakeDataSource.setJdbcUrl(url);
		return fakeDataSource;
	}
}

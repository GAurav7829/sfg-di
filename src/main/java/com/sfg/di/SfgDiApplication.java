package com.sfg.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sfg.di.config.SfgConfiguration;
import com.sfg.di.controllers.ConstructorInjectedController;
import com.sfg.di.controllers.I18nController;
import com.sfg.di.controllers.MyController;
import com.sfg.di.controllers.PropertyInjectedController;
import com.sfg.di.controllers.SetterInjectedController;
import com.sfg.di.datasource.FakeDataSource;
import com.sfg.di.services.PrototypeBean;
import com.sfg.di.services.SingletonBean;
import com.sfg.pets.controller.PetController;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sfg.di", "com.sfg.pets" })
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController"); // spring manage construction of object
		System.out.println("---------PrimaryBean--------------");
		String greetings = myController.helloWorld();
		System.out.println(greetings);

		System.out.println("---------PropertyInjectedController--------------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx
				.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("---------SetterInjectedController--------------");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx
				.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("---------ConstructorInjectedController--------------");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx
				.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("---------Profile--------------");
		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		System.out.println("---------Component Scan--------");
		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.getPetType());
		
		
		System.out.println("-----------Scope----------------");
		SingletonBean singletonBean1 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = (SingletonBean) ctx.getBean("singletonBean");
		System.out.println(singletonBean2.getMyScope());
		PrototypeBean prototypeBean1 = (PrototypeBean) ctx.getBean("prototypeBean");
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = (PrototypeBean) ctx.getBean("prototypeBean");
		System.out.println(prototypeBean2.getMyScope());
		
		System.out.println("-------------FAKE DATASOURCE------------------");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcUrl());
		
		System.out.println("-------------Property Binding------------------");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcUrl());
	}
}

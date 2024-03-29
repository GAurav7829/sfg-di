package com.sfg.di.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {
	
	public PrototypeBean() {
		System.out.println("Creating a prototype bean");
	}
	
	public String getMyScope() {
		return "prototype";
	}
}

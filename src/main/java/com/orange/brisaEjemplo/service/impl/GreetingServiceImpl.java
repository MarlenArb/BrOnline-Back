package com.orange.brisaEjemplo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.brisaEjemplo.service.GreetingService;
import com.orange.brisaEjemplo.util.BrisaProperties;


@Service
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	BrisaProperties brisaProperties;
	
	@Override
	public String hello() {
		return "Hola BRISA";
	}

	@Override
	public String helloProperties() {
		String greeting = brisaProperties.getSaludo();
		return greeting;
	}	
	
	@Override
	public String bye() {
		return "Adios BRISA";
	}

}

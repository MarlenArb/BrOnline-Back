package com.orange.brisaEjemplo.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Component
@PropertySource("classpath:properties/brisa.properties")
@ConfigurationProperties(prefix = "brisa")
@Validated
public class BrisaProperties {

	private String saludo;

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	public String getSaludo() {
		return saludo;
	}
}

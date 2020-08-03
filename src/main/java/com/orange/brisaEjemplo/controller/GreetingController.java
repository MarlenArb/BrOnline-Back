package com.orange.brisaEjemplo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orange.brisaEjemplo.service.GreetingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Api(value = "GreetingController")
@Tag(name = "GreetingController", description = "Controlador del saludo")
@RestController
@RequestMapping("/")
public class GreetingController {

	private Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	private GreetingService greetingService;
	
	
	// http://localhost:8080/brisa/
	@ApiOperation(tags = "GreetingController", value = "Verifica que la aplicacion esta funcionando", notes = "Descripcion detallada...")
	@GetMapping
	public String isAlive() {
		logger.trace("---- GreetingController.isAlive()");
		return "Aplicacion BRISA funcionando correctamente";
	}
	
	// http://localhost:8080/brisa/hello
	@ApiOperation(tags = "GreetingController", value = "Devuelve el saludo hola", notes = "Descripcion detallada...")
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		logger.trace("---- GreetingController.hello()");
		return greetingService.hello();
	}

	// http://localhost:8080/brisa/helloprop
	@ApiOperation(tags = "GreetingController", value = "Devuelve el saludo hola desde un properties", notes = "Descripcion detallada...")
	@RequestMapping(value = "/helloprop", method = RequestMethod.GET)
	public String helloProp() {
		logger.trace("---- GreetingController.helloProp()");
		return greetingService.helloProperties();
	}

	// http://localhost:8080/brisa/bye
	@ApiOperation(tags = "GreetingController", value = "Devuelve el saludo adios", notes = "Descripcion detallada...")
	@RequestMapping(value = "/bye", method = RequestMethod.GET)
	public String bye() {
		logger.trace("---- GreetingController.bye()");
		return greetingService.bye();
	}
}

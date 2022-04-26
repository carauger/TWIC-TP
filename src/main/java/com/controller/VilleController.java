package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VilleController {
	
	@RequestMapping(value="/ville", method=RequestMethod.GET)
	public String get(@RequestParam(required = false, value="codePostal") String codePostal) {
		System.out.println("get");
		return "plop";
	}
	//TODO: se connecter à une bdd, faire des get avec des paramètres 
	//TODO: si on a le temps, faire des post 
}

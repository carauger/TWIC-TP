package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBlo;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBlo villeBlo;
		
	//GET VIDE
    @RequestMapping(value = "/villes", method = RequestMethod.GET)
    @ResponseBody
    public List<Ville> appelVilles() {
		return villeBlo.listerVilles();
    }
    
    //GET AVEC CODE POSTAL
    @GetMapping(value = "/ville", params = "codePostal")
    public List<Ville> trouverParCodePostal(@RequestParam String codePostal) {
		return villeBlo.listerVillesParCodePostal(codePostal);
    }
    
	//POST
	@PostMapping(value = "/ville")
	public void villePost(@RequestBody Ville villeAAjouter) {
		villeBlo.ajouterVille(villeAAjouter);
	}
	
	//PUT
	@PutMapping(value = "/ville")
    public void villePut(@RequestBody Ville villeModifiee, @RequestParam String codeInsee) {
		villeBlo.modifierVille(villeModifiee,codeInsee);
	}
	
	//DELETE
	@DeleteMapping(value = "/ville")
	public void villeDelete(@RequestParam String codeCommune)  {
		villeBlo.supprimerVille(codeCommune);
	}
	
}

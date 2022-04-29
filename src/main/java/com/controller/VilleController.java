package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	/*
	@RequestMapping(value="/ville", method=RequestMethod.GET)
	public String get(@RequestParam(required = false, value="codePostal") String codePostal) {
		System.out.println("get");
		return "plop";
	}*/
	
	//GET
	@RequestMapping(value = "/VilleAfficher", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> villeGet(@RequestParam(required=false, value="codePostal")String codePostal) {
		ArrayList<Ville> liste = new ArrayList<Ville>();
		if (codePostal == null) {
			liste = villeBlo.listerVilles();
		} else {
			liste = villeBlo.listerVillesParCodePostal(codePostal);
		}
		return liste;
	}
	
	//POST
	@RequestMapping(value = "/VilleAjout", method=RequestMethod.POST)
	@ResponseBody
	public void villePost(@RequestParam(required = true, value = "villeAAjouter") Ville villeAAjouter) {
		villeBlo.ajouterVille(villeAAjouter);
	}
	
	//PUT
	@RequestMapping(value = "/VilleModif", method=RequestMethod.PUT)
	@ResponseBody
	public void villePut(@RequestParam Ville villeModifiee)  {
		villeBlo.modifierVille(villeModifiee);
	}
	
	//DELETE
	@RequestMapping(value = "/VilleSupr", method=RequestMethod.DELETE)
	@ResponseBody
	public void villeDelete(@RequestParam(required=true, value="villeASupprimer") Ville villeASupprimer)  {
		villeBlo.supprimerVille(villeASupprimer);
	}
	
}

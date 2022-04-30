package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBlo {

	public ArrayList<Ville> listerVillesParCodePostal(String Code_postal);
	
	public ArrayList<Ville> listerVilles();

	void ajouterVille(Ville ville);
	
	void supprimerVille(String code);
	
	void modifierVille(Ville ville);

}
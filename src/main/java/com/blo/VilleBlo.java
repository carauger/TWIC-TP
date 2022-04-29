package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBlo {

	public ArrayList<Ville> listerVillesParCodePostal(String Code_postal);
	
	public ArrayList<Ville> listerVilles();

	void ajouterVille(Ville ville);
	
	void supprimerVille(Ville ville);
	
	void modifierVille(Ville ville);

}
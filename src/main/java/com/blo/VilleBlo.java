package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBlo {

	public ArrayList<Ville> listerVilles(String Code_postal);

	void ajouterVille(Ville ville);
	
	void supprimerVille(Ville ville);
	
	void modifierVille(Ville ville);

}
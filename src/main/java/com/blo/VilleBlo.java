package com.blo;


import java.util.List;

import com.dto.Ville;

public interface VilleBlo {

	public List<Ville> listerVillesParCodePostal(String Code_postal);
	
	public List<Ville> listerVilles();

	void ajouterVille(Ville ville);
	
	void supprimerVille(String code);
	
	void modifierVille(Ville ville, String code);

}
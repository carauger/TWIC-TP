package com.dao;

import com.dto.Ville;
import java.util.List;

public interface VilleDao {

		public List<Ville> listerVilleParCodePostal(String Code_postal);

		public List<Ville> listerVille();
		
		void modifierVille(Ville ville, String code);

		void ajouterVille(Ville ville);
		
		void supprimerVille(String code);
}

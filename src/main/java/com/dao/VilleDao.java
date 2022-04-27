package com.dao;

import com.dto.Ville;
import java.util.ArrayList;

public interface VilleDao {

		public ArrayList<Ville> listerVilleParCodePostal(String Code_postal);

		public ArrayList<Ville> listerVille();

		void ajouterVille(Ville ville);

}

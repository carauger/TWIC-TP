package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDao;
import com.dto.Ville;

@Service
public class VilleBloImpl implements VilleBlo {

	@Autowired
	private VilleDao villeDao;
	
	public ArrayList<Ville> listerVilles(){
		return villeDao.listerVille();
	}

	public ArrayList<Ville> listerVillesParCodePostal(String codePostal) {
		return villeDao.listerVilleParCodePostal(codePostal);
	}

	public void ajouterVille(Ville ville) {
		villeDao.ajouterVille(ville);
	}

	public void supprimerVille(String code) {
		villeDao.supprimerVille(code);
	}
	
	public void modifierVille(Ville ville) {
		villeDao.modifierVille(ville);
	}
}
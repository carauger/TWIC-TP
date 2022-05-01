package com.blo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDao;
import com.dto.Ville;

@Service
public class VilleBloImpl implements VilleBlo {

	@Autowired
	private VilleDao villeDao;
	
	public List<Ville> listerVilles(){
		return villeDao.listerVille();
	}

	public List<Ville> listerVillesParCodePostal(String codePostal) {
		return villeDao.listerVilleParCodePostal(codePostal);
	}

	public void ajouterVille(Ville ville) {
		villeDao.ajouterVille(ville);
	}

	public void supprimerVille(String code) {
		villeDao.supprimerVille(code);
	}
	
	public void modifierVille(Ville ville, String code) {
		villeDao.modifierVille(ville, code);
	}
}
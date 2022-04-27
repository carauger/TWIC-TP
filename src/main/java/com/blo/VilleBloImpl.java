package com.blo;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.dao.VilleDao;
import com.dto.Ville;

@Service
public class VilleBloImpl implements VilleBlo {

	
	private VilleDao villeDao;
	

	public ArrayList<Ville> listerVilles(String CodePostal) {
		return villeDao.listerVille();
	}

	public void ajouterVille(Ville ville) {
		villeDao.ajouterVille(ville);
	}

	public void supprimerVille(Ville ville) {
		villeDao.supprimerVille(ville);
	}
	
	public void modifierVille(Ville ville) {
		villeDao.modifierVille(ville);
	}
}
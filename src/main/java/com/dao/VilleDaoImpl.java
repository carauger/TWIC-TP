package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfig;
import com.dto.Ville;

@Repository
public class VilleDaoImpl implements VilleDao{
	

	@Override
	public ArrayList<Ville> listerVilleParCodePostal(String codePostal) {
		
		Statement statement;
		ResultSet result;
		
		ArrayList<Ville> villes = new ArrayList<Ville>();
		
		try {
			Connection con = JDBCConfig.openConnection();
			statement = con.createStatement();
			result = statement.executeQuery("SELECT * FROM ville_france WHERE Code_postal =" + codePostal + ";");
			
			while(result.next()) {
				Ville ville = new Ville();
				ville.setCodeCommuneINSEE(result.getString("Code_commune_INSEE"));
				ville.setNomCommune(result.getString("Nom_commune"));
				ville.setCode_postal(result.getString("Code_postal"));
								
				villes.add(ville);
			}
			
			con = JDBCConfig.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return villes;
	}

	@Override
	public ArrayList<Ville> listerVille() {
		Statement statement;
		ResultSet result;
		
		ArrayList<Ville> villes = new ArrayList<Ville>();
		
		try {
			Connection con = JDBCConfig.openConnection();
			statement = con.createStatement();
			result = statement.executeQuery("SELECT * FROM ville_france;");
			
			while (result.next()) {
				Ville ville = new Ville();
				ville.setNomCommune(result.getString("Nom_commune"));
				villes.add(ville);
			}
			
			con = JDBCConfig.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return villes;
	}
	

	@Override
	public void ajouterVille(Ville ville) {
		Statement stm;
		
		try {
			Connection con = JDBCConfig.openConnection();
			stm = con.createStatement();
			stm.executeQuery("INSERT INTO ville_france VALUES("+ ville.getCodeCommuneINSEE() + ","+ ville.getNomCommune() + ","	+ ville.getCodePostal() + ","+ ville.getLibelleAcheminement() + ","+ ville.getLigne5() + ","+ ville.getLatitude() + ","	+ ville.getLongitude() + ");");
			
			con = JDBCConfig.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}


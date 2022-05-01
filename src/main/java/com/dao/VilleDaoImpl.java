package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfig;
import com.dto.Ville;

@Repository
public class VilleDaoImpl implements VilleDao{
	

	@Override
	public List<Ville> listerVilleParCodePostal(String codePostal) {
		
		Statement statement;
		ResultSet result;
		
		List<Ville> villes = new ArrayList<>();
		
		try {
			Connection con = JDBCConfig.openConnection();
			statement = con.createStatement();
			result = statement.executeQuery("SELECT * FROM ville_france WHERE Code_postal =" + codePostal + ";");
			
			while(result.next()) {
				Ville ville = new Ville();
				ville.setNomCommune(result.getString("Nom_commune"));
				ville.setCode_postal(result.getString("Code_postal"));
				ville.setCodeCommuneINSEE(result.getString("Code_commune_INSEE"));
				ville.setLibelleAcheminement(result.getString("Libelle_acheminement"));
				ville.setLatitude(result.getString("Latitude"));
				ville.setLongitude(result.getString("Longitude"));
				ville.setLigne5(result.getString("Ligne_5"));
				villes.add(ville);
			}
			
			con = JDBCConfig.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return villes;
	}

	@Override
	public List<Ville> listerVille() {
		Statement statement;
		ResultSet result;
		
		List<Ville> villes = new ArrayList<>();
		
		try {
			Connection con = JDBCConfig.openConnection();
			statement = con.createStatement();
			result = statement.executeQuery("SELECT * FROM ville_france;");
			
			while (result.next()) {
				Ville ville = new Ville();
				ville.setNomCommune(result.getString("Nom_commune"));
				ville.setCode_postal(result.getString("Code_postal"));
				ville.setCodeCommuneINSEE(result.getString("Code_commune_INSEE"));
				ville.setLibelleAcheminement(result.getString("Libelle_acheminement"));
				ville.setLatitude(result.getString("Latitude"));
				ville.setLongitude(result.getString("Longitude"));
				ville.setLigne5(result.getString("Ligne_5"));
				villes.add(ville);
			}
			
			con = JDBCConfig.closeConnection();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return villes;
	}
	
	@Override
	public void modifierVille(Ville ville, String code) {
		Statement stm;
		try {
			Connection con = JDBCConfig.openConnection();
			stm = con.createStatement();
			stm.executeUpdate("UPDATE ville_france SET Nom_commune=" + ville.getNomCommune() + ", Code_postal="+ ville.getCodePostal() + ", Libelle_acheminement=" + ville.getLibelleAcheminement()+", Ligne_5=" + ville.getLigne5() + ", Latitude=" + ville.getLatitude() + ", Longitude="+ ville.getLongitude() + " WHERE Code_commune_INSEE =" + code + ";");
			con= JDBCConfig.closeConnection();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterVille(Ville ville) {
		Statement stm;
		
		try {
			Connection con = JDBCConfig.openConnection();
			stm = con.createStatement();
			stm.executeUpdate("INSERT INTO ville_france VALUES("+ ville.getCodeCommuneINSEE() + ","+ ville.getNomCommune() + ","	+ ville.getCodePostal() + ","+ ville.getLibelleAcheminement() + ","+ ville.getLigne5() + ","+ ville.getLatitude() + ","	+ ville.getLongitude() + ");");
			
			con = JDBCConfig.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void supprimerVille(String code) {
		Statement stm;
		try {
			Connection con = JDBCConfig.openConnection();
			stm = con.createStatement();
			stm.executeUpdate("DELETE FROM ville_france WHERE Code_postal = "+ code +";");
			
			con = JDBCConfig.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}


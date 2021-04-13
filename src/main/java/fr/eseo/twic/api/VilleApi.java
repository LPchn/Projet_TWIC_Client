package fr.eseo.twic.api;

import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import fr.eseo.twic.modele.Ville;

public interface VilleApi {
	
	public ArrayList<Ville> listeVille();
	Ville getVille(String codeCommune);
	void supprimerVille(String codeCommune);
	public void ajouterVille(HttpServletRequest request) throws MalformedURLException, Exception;
	void modifierVille(String codeCommune, Ville ville) throws Exception;

}

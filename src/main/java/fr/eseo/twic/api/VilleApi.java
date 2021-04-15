package fr.eseo.twic.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import fr.eseo.twic.modele.Ville;

public interface VilleApi {
	
	public List<Ville> listeVille() throws VilleApiException;
	Ville getVille(String codeCommune) throws VilleApiException;
	void supprimerVille(String codeCommune) throws VilleApiException;
	public void ajouterVille(HttpServletRequest request) throws VilleApiException;
	void modifierVille(String codeCommune, Ville ville) throws VilleApiException;

}

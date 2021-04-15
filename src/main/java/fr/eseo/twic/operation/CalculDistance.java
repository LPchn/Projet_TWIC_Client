package fr.eseo.twic.operation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import fr.eseo.twic.api.VilleApi;
import fr.eseo.twic.api.VilleApiException;
import fr.eseo.twic.api.VilleApiImpl;
import fr.eseo.twic.modele.Ville;

public class CalculDistance {
	
	//Attribut
	
	//Constructeur
	
	//Méthode
	
	public double calculDistance(HttpServletRequest request) throws CalculDistanceException {
		
		double distance = 0.0;
		String nomVille1 = request.getParameter("ville1");
		String nomVille2 = request.getParameter("ville2");
		
		if(nomVille1.equals(nomVille2)) {
			throw new CalculDistanceException("Les villes séléctionnées sont les mêmes.");
		}
		
		Ville ville1 = null;
		Ville ville2 = null;
		
		VilleApi villeApi = new VilleApiImpl();
		List<Ville> villes;
		try {
			villes = villeApi.listeVille();
		
		
		for(Ville ville : villes) {
			if (ville.getNom().equals(nomVille1)) {
				ville1 = ville;
			}
			else if(ville.getNom().equals(nomVille2)) {
				ville2 = ville;
			}
		}
		
		if(ville1 != null && ville2!=null) {
		
			double longitude1 = Double.parseDouble(ville1.getLongitude());
			double latitude1 = Double.parseDouble(ville1.getLatitude());
			double longitude2 = Double.parseDouble(ville2.getLongitude());
			double latitude2 = Double.parseDouble(ville2.getLatitude());
			
			double latitude1Radian = Math.toRadians(latitude1);
			double latitude2Radian = Math.toRadians(latitude2);
			
		
			double x = (longitude2-longitude1)*(Math.cos((latitude1Radian+latitude2Radian)/2));		
			double y = latitude2-latitude1;
			double z = Math.sqrt(Math.pow(x, 2)+Math.pow(y,2));
							
			distance = 1.852*60*z;		
			
			distance = Math.round(distance*100.0)/100.0;
		
		}
		
		
		
		} 
		catch (VilleApiException e) {			
			e.printStackTrace();
		}
		return(distance);
	}
}
package fr.eseo.twic.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import fr.eseo.twic.modele.Ville;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Classe qui va se charger de récupérer les informations de l'API.
 * 
 * @author Loïc SIELLET / Louise POUCHAIN
 *
 */
public class VilleApiImpl implements VilleApi {
	
	private static final String LIEN = "http://localhost:8383/ville";
	private static final String ERREUR = "Erreur avec le serveur";
	
	
	/**
	 * Permet de retourner une liste de l'ensemble des villes inscrite dans l'API.
	 * @throws VilleApiException 
	 */
	public ArrayList<Ville> listeVille() throws VilleApiException {
		
		ArrayList<Ville> villes = new ArrayList<>();

		try {

			URL url = new URL(LIEN);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			// conn.setRequestProperty("Accept", "application/json"); //?

			// Lorsqu'on envoie une requête, on reçoit un code de réponse 200.
			// On s'assure donc que la requête fonctionne.
			if (conn.getResponseCode() != 200) {
				throw new VilleApiException(ERREUR);
			}

			// On lit ce que la connexion nous renvoie.
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			/*
			 * Permet de récupérer les données au format JSon. 
			 * On se retrouve avec un tableau JSON.
			 * Il faut récupérer chaque élement de ce tableau.
			 * On récupère ensuite les attributs de cet élément.
			 */
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(br);
			
			for(int i=0;i<=array.size()-1;i++) {
				JSONObject json = (JSONObject) array.get(i);
				String code = (String) json.get("code");
				String nomCommune = (String) json.get("nom");
				String codePostal = (String) json.get("codePostal");
				String libelle = (String) json.get("libelle");
				String ligne = (String) json.get("ligne");
				String latitude = (String) json.get("latitude");
				String longitude = (String) json.get("longitude");
				
				Ville ville = new Ville();
				ville.setCode(code);
				ville.setCodePostal(codePostal);
				ville.setNom(nomCommune);
				ville.setLibelle(libelle);
				ville.setLigne(ligne);
				ville.setLatitude(latitude);
				ville.setLongitude(longitude);
				villes.add(ville);
			}			
			conn.disconnect();
		} 
		catch (IOException|ParseException e) {
			e.printStackTrace();
		}	
		return(villes);
	}
	
	/**
	 * Permet de retourner la ville ayant le code commune "codeCommune".
	 * @throws VilleApiException 
	 */
	public Ville getVille(String codeCommune) throws VilleApiException {
		
		Ville ville = new Ville();

		try {

			URL url = new URL(LIEN);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			// conn.setRequestProperty("Accept", "application/json"); //?

			// Lorsqu'on envoie une requête, on reçoit un code de réponse 200.
			// On s'assure donc que la requête fonctionne.
			if (conn.getResponseCode() != 200) {
				throw new VilleApiException(ERREUR);
			}

			// On lit ce que la connexion nous renvoie.
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			/*
			 * Permet de récupérer les données au format JSon. 
			 * On se retrouve avec un tableau JSON.
			 * Il faut trouver l'element correspondant au code commune codeCommune
			 * On récupère ensuite les attributs de cet élément.
			 */
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(br);
			int i = 0;
			while(ville.getCode() == null) {
				JSONObject json = (JSONObject) array.get(i);
				String code = (String) json.get("code");
				String nomCommune = (String) json.get("nom");
				String codePostal = (String) json.get("codePostal");
				String libelle = (String) json.get("libelle");
				String ligne = (String) json.get("ligne");
				String latitude = (String) json.get("latitude");
				String longitude = (String) json.get("longitude");
				
				if (code.equals(codeCommune)) {
					ville.setCode(code);
					ville.setCodePostal(codePostal);
					ville.setNom(nomCommune);
					ville.setLibelle(libelle);
					ville.setLigne(ligne);
					ville.setLatitude(latitude);
					ville.setLongitude(longitude);
				}
				i++;
			}			
			conn.disconnect();
		} 
		catch (IOException|ParseException e) {
			e.printStackTrace();
		}			
		return(ville);
	}
	
	/**
	 * Permet de supprimer la ville ayant le code commune "codeCommune".
	 * @throws VilleApiException 
	 */
	public void supprimerVille(String codeCommune) throws VilleApiException {
		try {

			URL url = new URL(LIEN + "/" + codeCommune);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			// conn.setRequestProperty("Accept", "application/json"); //?

			// Lorsqu'on envoie une requête, on reçoit un code de réponse 200.
			// On s'assure donc que la requête fonctionne.
			if (conn.getResponseCode() != 200) {
				throw new VilleApiException(ERREUR);
			}

		} 
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Ajoute une ville dans la BDD du serveur.
	 */
	public void ajouterVille(HttpServletRequest request) throws VilleApiException {
		
		try {
			String code = request.getParameter("code");
			String nom = request.getParameter("nom");
			String codePostal = request.getParameter("codePostal");
			String libelle = request.getParameter("libelle");
			String ligne = request.getParameter("ligne");
			String latitude = request.getParameter("latitude");
			String longitude = request.getParameter("longitude");		
			
			String codeJSON = "{ \"code\":\""+code+"\",\"nom\":\""+nom+"\",\"codePostal\":\""+codePostal+"\",\"libelle\":\""+libelle+"\",\"ligne\":\""+ligne+"\",\"latitude\":\""+latitude+"\",\"longitude\":\""+longitude+"\"}";
			
			URL url = new URL(LIEN);		
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			
			
			conn.setRequestProperty("Content-Type", "application/json");
			
			conn.setDoOutput(true);
			OutputStream stream = conn.getOutputStream();
			stream.write(codeJSON.getBytes());
			stream.flush();
			stream.close();		
		
			conn.connect();		
			
			int responseCode = conn.getResponseCode();
			if(responseCode != 200) {
				throw new VilleApiException("Erreur du serveur.");
			}			
		}
		catch (Exception e) {
			throw new VilleApiException("Erreur du serveur.");
		}
	}	

	
	 /* Permet de modifier la ville ayant le code commune "codeCommune".
	 */
	
	public void modifierVille(String codeCommune, Ville ville) throws VilleApiException {
		
		String nom = ville.getNom();
		String codePostal = ville.getCodePostal();
		String libelle = ville.getLibelle();
		String ligne = ville.getLigne();
		String latitude = ville.getLatitude();
		String longitude = ville.getLongitude();

		String codeJSON = "{";
		if (!nom.equals("")) {
			
			if (codeJSON.equals("{")) {
				codeJSON = codeJSON + "\"nom\":\"" + nom + "\"";
			}else {
				codeJSON = codeJSON + ",\"nom\":\"" + nom + "\"";
			}
		}
		if (!codePostal.equals("")) {
			if (codeJSON.equals("{")) {
				codeJSON = codeJSON + "\"codePostal\":\"" + codePostal + "\"";
			}else {
				codeJSON = codeJSON + ",\"codePostal\":\"" + codePostal + "\"";
			}
		}
		if (!libelle.equals("")) {
			if (codeJSON.equals("{")) {
				codeJSON = codeJSON + "\"libelle\":\"" + libelle + "\"";
			}else {
				codeJSON = codeJSON + ",\"libelle\":\"" + libelle + "\"";
			}
		}
		if (!ligne.equals("")) {
			if (codeJSON.equals("{")) {
				codeJSON = codeJSON + "\"ligne\":\"" + ligne + "\"";
			}else {
				codeJSON = codeJSON + ",\"ligne\":\"" + ligne + "\"";
			}
		}
		if (!latitude.equals("")) {
			if (codeJSON.equals("{")) {
				codeJSON = codeJSON + "\"latitude\":\"" + latitude + "\"";
			}else {
				codeJSON = codeJSON + ",\"latitude\":\"" + latitude + "\"";
			}
		}
		if (!longitude.equals("")) {
			if (codeJSON.equals("{")) {
				codeJSON = codeJSON + "\"longitude\":\"" + longitude + "\"";
			}else {
				codeJSON = codeJSON + ",\"longitude\":\"" + longitude + "\"";
			}
		}
		codeJSON = codeJSON + "}";
		
		System.out.println(codeJSON);
		
		try {
			URL url = new URL("http://localhost:8383/ville/" + codeCommune);
			HttpURLConnection connexion = (HttpURLConnection) url.openConnection();
			connexion.setRequestMethod("PUT");
	
	
			connexion.setRequestProperty("Content-Type", "application/json"); //?
	
			connexion.setDoOutput(true);
			OutputStream stream = connexion.getOutputStream();			
			
			stream.write(codeJSON.getBytes());
			stream.flush();
			stream.close();
	
			connexion.connect();
			
			System.out.println(connexion.getResponseCode());
		}
		catch(IOException e) {
			
		}
		
	}
}
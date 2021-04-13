package fr.eseo.twic.meteo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ch.qos.logback.classic.Level;
import fr.eseo.twic.modele.Meteo;
import fr.eseo.twic.modele.Ville;
import jdk.jfr.internal.Logger;

public class MeteoApiImpl implements MeteoApi {

	public Meteo getMeteo(String codeInsee) {
		
		Meteo meteo = null;
		
		try {
			
			String lien = "https://api.meteo-concept.com/api/forecast/daily?token=3e994567e1e0912953647923f13cf59e95ed56866ae9922fa5ff91a234d08b1c&insee="+codeInsee;
			URL url = new URL(lien);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			// conn.setRequestProperty("Accept", "application/json"); //?

			// Lorsqu'on envoie une requête, on reçoit un code de réponse 200.
			// On s'assure donc que la requête fonctionne.
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
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
			JSONObject json = (JSONObject) parser.parse(br);
			
			JSONArray array = (JSONArray) json.get("forecast");			
			
			JSONObject données = (JSONObject) array.get(0);
			
			String temperatureMin = données.get("tmin").toString();				//°C
			String temperatureMax = données.get("tmax").toString();				//°C
			String vent = données.get("wind10m").toString();					//km/h
			String pluie = données.get("rr1").toString();						//mm
			String probabilitePluie = données.get("probarain").toString();		//%
			String temps = données.get("weather").toString();					//indice
			
			meteo = new Meteo(temperatureMin,temperatureMax,vent,pluie,probabilitePluie,temps);
			
			conn.disconnect();
			
			return(meteo);
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ParseException e) {			
			e.printStackTrace();
		}
		return meteo;		
	}
}
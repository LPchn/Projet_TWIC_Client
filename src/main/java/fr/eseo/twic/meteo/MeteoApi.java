package fr.eseo.twic.meteo;

import fr.eseo.twic.modele.Meteo;

public interface MeteoApi {
	
	public Meteo getMeteo(String codeInsee);

}

package fr.eseo.twic.modele;

public class Meteo {

	// Attribut

	private String temperatureMin;
	private String temperatureMax;
	private String vent;
	private String pluie;
	private String probabilitePluie;
	private String temps;
	
	public Meteo(String temperatureMin, String temperatureMax, String vent, String pluie, String probabilitePluie,
			String temps) {
		super();
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.vent = vent;
		this.pluie = pluie;
		this.probabilitePluie = probabilitePluie;
		this.temps = temps;
	}
	public String getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(String temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public String getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(String temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public String getVent() {
		return vent;
	}
	public void setVent(String vent) {
		this.vent = vent;
	}
	public String getPluie() {
		return pluie;
	}
	public void setPluie(String pluie) {
		this.pluie = pluie;
	}
	public String getProbabilitePluie() {
		return probabilitePluie;
	}
	public void setProbabilitePluie(String probabilitePluie) {
		this.probabilitePluie = probabilitePluie;
	}
	public String getTemps() {
		return temps;
	}
	public void setTemps(String temps) {
		this.temps = temps;
	}
}
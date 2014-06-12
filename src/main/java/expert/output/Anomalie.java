package expert.output;

import java.util.Date;

public class Anomalie {

	private double latitude;
	private double longitude;
	private double coefficient;
	private double severite;
	private int nombreMesure;
	private Date date;
	
	/***
	 * Ceci est le constructeur de la classe Anomalie
	 * lors de la creation le coefficient qui représente la probabilité 
	 * de l'existence de l'anomalie égal à 1 de même pour le nombreMesure
	 * qui représente combien de mesure pour la même longitude et l'attitude
	 * @param latitude C'est la latitude de l'anomalie
	 * @param longitude C'est la longitude de l'anomalie
	 * @param severite C'est le degrée du sévérité de l'anomalie
	 * @param date C'est la date de l'anomalie
	 */
	public Anomalie(double latitude,double longitude,double severite,Date date){
		
		this.latitude=latitude;
		this.longitude=longitude;
		this.coefficient=1;
		this.severite=severite;
		this.date=date;
		this.nombreMesure=1;
	}
	
	/***
	 * Cette méthode sert a mettre à jour l'anomalie quand on a 2 anomalies dans la même longitude et latitude 
	 * @param anomalie c'est la nouvelle anomalie détecter 
	 */
	public void updateTrou(Anomalie anomalie){
		
		this.coefficient = (this.coefficient * this.nombreMesure + anomalie.getCoefficient())/(this.nombreMesure+1);
		this.severite = (this.severite * this.nombreMesure + anomalie.getSeverite())/(this.nombreMesure+1);
		this.nombreMesure++;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public double getSeverite() {
		return severite;
	}

	public void setSeverite(double severite) {
		this.severite = severite;
	}

	public int getNombreMesure() {
		return nombreMesure;
	}

	public void setNombreMesure(int nombreMesure) {
		this.nombreMesure = nombreMesure;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Anomalie [latitude = " + latitude + ", longitude = " + longitude
				+ ", coefficient = " + coefficient + ", severite = " + severite
				+ ", nombreMesure = " + nombreMesure + ", date = " + date + "]\n";
	}
		
	
	
}

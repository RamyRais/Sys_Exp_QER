package expert.model;

import java.util.Date;

public class Mesure {
	
	private double latitude;
	private double longitude;
	private int vitesse;
	private int cap;
	private int x;
	private int y;
	private int z;
	private double alpha; 
	private Date  date;

		
		public Mesure(double latitude, double longitude, int vitesse,int cap, int variationX,
				int variationY, int variationZ, Date date){
			this.latitude = latitude;
			this.longitude = longitude;
			this.vitesse = vitesse;
			this.cap = cap;
			this.x = variationX;
			this.y = variationY;
			this.z = variationZ;
			this.date = date;
			this.alpha = Math.acos((double)z/(double)128);
		}
		
		
		public double getAlpha() {
			return alpha;
		}


		public void setAlpha(double alpha) {
			this.alpha = alpha;
		}


		public int getCap() {
			return cap;
		}


		public void setCap(int cap) {
			this.cap = cap;
		}


		public Date getDate() {
			return date;
		}


		public void setDate(Date date) {
			this.date = date;
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
		public int getVitesse() {
			return vitesse;
		}
		public void setVitesse(int vitesse) {
			this.vitesse = vitesse;
		}
		public int getX() {
			return x;
		}
		public void setX(int variationX) {
			this.x = variationX;
		}
		public int getY() {
			return y;
		}
		public void setY(int variationY) {
			this.y = variationY;
		}
		public int getZ() {
			return z;
		}
		public void setZ(int variationZ) {
			this.z = variationZ;
		}


		@Override
		public String toString() {
			return "Mesures [latitude= " + this.latitude + ", longitude= " + this.longitude
					+", cap= "+ this.cap + ", vitesse= " + this.vitesse + ", X= " + this.x
					+ ", Y= " + this.y + ", Z= " + this.z +" alpha= " + this.alpha
					+ ", date= " + this.date + "]\n";
		}

}

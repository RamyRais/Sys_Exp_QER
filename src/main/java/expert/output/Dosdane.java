package expert.output;

import java.util.Date;

public class Dosdane extends Anomalie {

	public Dosdane(double latitude, double longitude, double severite, Date date) {
		
		super(latitude, longitude, severite, date);
	}
	
	@Override
	public String toString() {
		return "DosDane "+ super.toString().substring(9);
	}
}

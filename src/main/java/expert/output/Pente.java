package expert.output;

import java.util.Date;

public class Pente extends Anomalie {

	public Pente(double latitude, double longitude, double severite, Date date) {
		
		super(latitude, longitude, severite, date);
	}
	
	@Override
	public String toString() {
		return "Pente "+ super.toString().substring(9);
	}

}

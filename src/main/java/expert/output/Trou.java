package expert.output;

import java.util.Date;

public class Trou extends Anomalie{

	public Trou(double latitude, double longitude,
			double severite, Date date) {
		
		super(latitude, longitude, severite, date);
	}
	
	@Override
	public String toString() {
		return "Trou "+ super.toString().substring(9);
	}
	
}

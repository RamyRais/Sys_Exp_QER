package expert.output;

import java.util.Date;

public class Virage extends Anomalie {

	public Virage(double latitude, double longitude, double severite, Date date) {
		
		super(latitude, longitude, severite, date);
	}
	
	@Override
	public String toString() {
		return "Virage "+ super.toString().substring(9);
	}
}

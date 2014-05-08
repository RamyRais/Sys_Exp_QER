package expert.model;

import java.util.ArrayList;

public class IntervalleMesure {

	private ArrayList<Mesure> tabMesure ;
	
	public IntervalleMesure(ArrayList<Mesure> tab){
		this.tabMesure = new ArrayList<Mesure>(tab);
	}

	public ArrayList<Mesure> getTabMesure() {
		return tabMesure;
	}

	public void setTabMesure(ArrayList<Mesure> tabMesure) {
		this.tabMesure = tabMesure;
	}

	@Override
	public String toString() {
		return "IntervalleMesure : "+this.tabMesure.toString();
	}
	
}

package expert.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	 
	public static double penteSeuilMin ;
	public static double penteSeuilMoy ;
	public static double penteSeuilMax ;
	public static double trouDiffMin ;
	public static double trouAvantMax ;
	public static double trouSeuilMin ;
	public static double trouSeuilMoy ;
	public static double trouSeuilMax ;
	public static double dosdaneDiffmin ;	
	public static double dosdaneAvantMin ;	
	public static double dosdaneSeuilMin ;
	public static double dosdaneSeuilMoy ;
	public static double dosdaneSeuilMax ;
	
	private Properties prop;
	 
	private static Configuration instance = null;
	
	private Configuration(){
		prop = loadFile();
		penteSeuilMin =   Double.valueOf(prop.getProperty("penteSeuilMin"));
		penteSeuilMoy = Double.valueOf(prop.getProperty("penteSeuilMoy"));
		penteSeuilMax = Double.valueOf(prop.getProperty("penteSeuilMax"));
		trouDiffMin = Double.valueOf(prop.getProperty("trouDiffMin"));
		trouAvantMax = Double.valueOf(prop.getProperty("trouAvantMax"));
		trouSeuilMin = Double.valueOf(prop.getProperty("trouSeuilMin"));
		trouSeuilMoy = Double.valueOf(prop.getProperty("trouSeuilMoy"));
		trouSeuilMax = Double.valueOf(prop.getProperty("trouSeuilMax"));
		dosdaneDiffmin = Double.valueOf(prop.getProperty("dosdaneDiffmin"));
		dosdaneAvantMin = Double.valueOf(prop.getProperty("dosdaneAvantMin"));
		dosdaneSeuilMin = Double.valueOf(prop.getProperty("dosdaneSeuilMin"));
		dosdaneSeuilMoy = Double.valueOf(prop.getProperty("dosdaneSeuilMoy"));
		dosdaneSeuilMax = Double.valueOf(prop.getProperty("dosdaneSeuilMax"));
	}
	
	public static Configuration getInstance(){
		
		if (instance == null){
			instance = new Configuration();
		}
		return instance;
	}
	
	private Properties loadFile(){
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("config.properties"));
		} catch (IOException e) {
		  e.printStackTrace();
		}
		return properties;
	}
	
	public static String toStringa(){
		return "Configuration [ penteSeuilMin = " + penteSeuilMin + " penteSeuilMoy = " + penteSeuilMoy+
				" penteSeuilMax = " + penteSeuilMax + "\ntrouSeuilMin = " + trouSeuilMin + " trouSeuilMoy"+
				trouSeuilMoy + " trouSeuilMax = " + trouSeuilMax + "\ndosdaneSeuilMin = " + dosdaneSeuilMin+
				" dosdaneSeuilMoy = " + dosdaneSeuilMoy + " dosdaneSeuilMax = "+ dosdaneSeuilMin + "]";
	}
	
	
}

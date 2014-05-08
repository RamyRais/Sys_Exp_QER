package expert_database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import expert.model.Mesure;

public class ConvertDBtoClass {

	
		public static ArrayList<Mesure> convert(ResultSet result){
			
			ArrayList<Mesure> mesureArray =null;
			SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd HH:mm:ss");
			
			try{
				mesureArray =  new ArrayList<Mesure>();
				//boucler sur les résultats de la requête
				while (result.next()) {
				
					String datemesure = result.getString(3);//get the date from  
					if(datemesure.length()==5){ // test if it's a day between 1 and 9 then add zero else do nothing
						datemesure = "0"+datemesure; // add the zero so the treatment stay the same 
					}
					String date1 = "20"+datemesure.substring(4,6)+"."
							+datemesure.substring(2,4)+"."+datemesure.substring(0,2); //put the date in the format we want above
					
					String time = result.getString(2);// get the time 
					if(time.length()==5){// test if we have an hour between 1 and 9 we add zero so the treatment still the same 
						time = "0"+time;
					}
					String time1 = time.substring(0,2)+":"+time.substring(2,4)+":"+time.substring(4,6); // put the time in the format we want
					
					Date date = ft.parse(date1+" "+time1);// convert the String in a Date object
					
					//java.sql.Timestamp t = new java.sql.Timestamp(date.getTime()); //convert the Date into an SQL DateTime
					
					// convert lattitude and longitude from a string to double 
					double latitude =Double.valueOf(result.getString(4).substring(0, 2)+"."
							+result.getString(4).substring(2));
					double longitude =Double.valueOf(result.getString(5).substring(0, 2)+"."
							+result.getString(5).substring(2));
					//System.out.println(date.toString()+" "+latitude+" "+longitude);
					//System.out.println(t.toString()+" "+latitude+" "+longitude);
					//System.out.println(Integer.parseInt(result.getString(9),16));
					
					int vitesse = result.getInt(6);
					int cap = result.getInt(7);
					
					int varx = Integer.parseInt(result.getString(8),16);
					varx = (varx > 127) ? varx - 256 : varx ;
					int vary = Integer.parseInt(result.getString(9),16);
					vary = (vary > 127) ? vary - 256 : vary ;
					int varz = Integer.parseInt(result.getString(10),16);
					varz = (varz > 127) ? varz - 256 : varz ;
					
					Mesure M = new Mesure(latitude, longitude, vitesse, cap, varx, vary, varz, date);
					mesureArray.add(M);
					//System.out.println(M.toString());
					
				
			}
			}catch(SQLException e){
				e.printStackTrace();
			}catch(ParseException pe){
				pe.printStackTrace();
				System.out.println("Unparseable using " + ft);
			}
			return mesureArray;
		}
}

package expert.model;

import java.util.ArrayList;

import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import expert.output.Dosdane;
import expert.output.Pente;
import expert.output.Trou;

public class MethodsForWebService {

	StatefulKnowledgeSession ksession = null;
	
	public MethodsForWebService(StatefulKnowledgeSession ksession){
		if(ksession == null){
			throw new IllegalArgumentException("la session passé en argument est null");
		}else{
			this.ksession=ksession;
		}
	}
	
	public ArrayList<Trou> getTrouXY(double longitude,double latitude){
		QueryResults results = ksession.getQueryResults("fetch for a Trou at longit and lat",longitude,latitude);
		ArrayList<Trou> trouList = new ArrayList<Trou>();
		for ( QueryResultsRow row : results ) {
			Trou t = ( Trou ) row.get( "trou" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Trou> getAllTrou(){
		QueryResults results = ksession.getQueryResults("extract all Trou");
		ArrayList<Trou> trouList = new ArrayList<Trou>();
		for ( QueryResultsRow row : results ) {
			Trou t = ( Trou ) row.get( "trou" );
			trouList.add(t);
		}
		return trouList ;
	}

	public ArrayList<Trou> getAllTrouMin(){
		QueryResults results = ksession.getQueryResults("extract Trou minimale");
		ArrayList<Trou> trouList = new ArrayList<Trou>();
		for ( QueryResultsRow row : results ) {
			Trou t = ( Trou ) row.get( "trou" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Trou> getAllTrouMoy(){
		QueryResults results = ksession.getQueryResults("extract Trou moyenne");
		ArrayList<Trou> trouList = new ArrayList<Trou>();
		for ( QueryResultsRow row : results ) {
			Trou t = ( Trou ) row.get( "trou" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Trou> getAllTrouMax(){
		QueryResults results = ksession.getQueryResults("extract Trou maximale");
		ArrayList<Trou> trouList = new ArrayList<Trou>();
		for ( QueryResultsRow row : results ) {
			Trou t = ( Trou ) row.get( "trou" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Dosdane> getDosdaneXY(double longitude,double latitude){
		QueryResults results = ksession.getQueryResults("fetch for a Dosdane at longit and lat",longitude,latitude);
		ArrayList<Dosdane> trouList = new ArrayList<Dosdane>();
		for ( QueryResultsRow row : results ) {
			Dosdane t = ( Dosdane ) row.get( "dosdane" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Dosdane> getAllDosdane(){
		QueryResults results = ksession.getQueryResults("extract all Dosdane");
		ArrayList<Dosdane> trouList = new ArrayList<Dosdane>();
		for ( QueryResultsRow row : results ) {
			Dosdane t = ( Dosdane ) row.get( "dosdane" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Dosdane> getAllDosdaneMin(){
		QueryResults results = ksession.getQueryResults("extract Dosdane minimale");
		ArrayList<Dosdane> trouList = new ArrayList<Dosdane>();
		for ( QueryResultsRow row : results ) {
			Dosdane t = ( Dosdane ) row.get( "dosdane" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Dosdane> getAllDosdaneMoy(){
		QueryResults results = ksession.getQueryResults("extract Dosdane moyenne");
		ArrayList<Dosdane> trouList = new ArrayList<Dosdane>();
		for ( QueryResultsRow row : results ) {
			Dosdane t = ( Dosdane ) row.get( "dosdane" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Dosdane> getAllDosdaneMax(){
		QueryResults results = ksession.getQueryResults("extract Dosdane maximale");
		ArrayList<Dosdane> trouList = new ArrayList<Dosdane>();
		for ( QueryResultsRow row : results ) {
			Dosdane t = ( Dosdane ) row.get( "dosdane" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Pente> getPenteXY(double longitude,double latitude){
		QueryResults results = ksession.getQueryResults("fetch for a Pente at longit and lat",longitude,latitude);
		ArrayList<Pente> trouList = new ArrayList<Pente>();
		for ( QueryResultsRow row : results ) {
			Pente t = ( Pente ) row.get( "pente" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Pente> getAllPente(){
		QueryResults results = ksession.getQueryResults("extract all Pente");
		ArrayList<Pente> trouList = new ArrayList<Pente>();
		for ( QueryResultsRow row : results ) {
			Pente t = ( Pente ) row.get( "pente" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Pente> getAllPenteMin(){
		QueryResults results = ksession.getQueryResults("extract Pente minimale");
		ArrayList<Pente> trouList = new ArrayList<Pente>();
		for ( QueryResultsRow row : results ) {
			Pente t = ( Pente ) row.get( "pente" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Pente> getAllPenteMoy(){
		QueryResults results = ksession.getQueryResults("extract Pente moyenne");
		ArrayList<Pente> trouList = new ArrayList<Pente>();
		for ( QueryResultsRow row : results ) {
			Pente t = ( Pente ) row.get( "pente" );
			trouList.add(t);
		}
		return trouList ;
	}
	
	public ArrayList<Pente> getAllPenteMax(){
		QueryResults results = ksession.getQueryResults("extract Pente maximale");
		ArrayList<Pente> trouList = new ArrayList<Pente>();
		for ( QueryResultsRow row : results ) {
			Pente t = ( Pente ) row.get( "pente" );
			trouList.add(t);
		}
		return trouList ;
	}
}

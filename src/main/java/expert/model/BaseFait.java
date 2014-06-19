package expert.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import org.kie.api.io.ResourceType;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderError;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import sun.font.CreatedFontTracker;
import expert.database.ConvertDBtoClass;
import expert.database.Dbcom;
import expert.output.Pente;
import expert.output.Trou;
import expert.output.Dosdane;

public class BaseFait {
	   
	private static StatefulKnowledgeSession session = null ;
	
	public static StatefulKnowledgeSession getSession(){
		
		if (session == null){
			session = createSession();
		}
		return session;
	}
	
	public static StatefulKnowledgeSession createSession(){
		KnowledgeBase kbase = null;
		StatefulKnowledgeSession ksession= null;
		try {
			kbase = readKnowledgeBase();
			ksession = kbase.newStatefulKnowledgeSession();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ksession;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = Configuration.getInstance();
		//System.out.println(Configuration.toStringa());
		 
		ArrayList<Mesure> a = new ArrayList<Mesure>();
		try{
		
			Connection conn = Dbcom.getInstance();
			Statement stmt = conn.createStatement();
			ResultSet result = Dbcom.resultatRequet(stmt,"Select * from mesure LIMIT 0,1000");
			a = ConvertDBtoClass.convert(result);
			stmt.close();
			conn.close();
			 
		}catch(SQLException e){
			e.printStackTrace();
		}
		
				
		
		try{
			
			
			session = getSession();
		
        for (Mesure interMes : a) {
        	 session.insert(interMes);
		}
        
		session.fireAllRules();
		/*
		System.out.println("***********  PENTE  ****************");
		QueryResults results = session.getQueryResults( "extract all Pente" );
		for ( QueryResultsRow row : results ) {
			Pente p = ( Pente ) row.get( "pente" );
			System.out.print( p );
		}
		System.out.println("\n***********   DOSDANE   ****************");
		results = session.getQueryResults( "extract all Dosdane" );
		for ( QueryResultsRow row : results ) {
			Dosdane d = ( Dosdane ) row.get( "dosdane" );
			System.out.print( d );
		}
		System.out.println("\n***********   TROU   ****************");
		results = session.getQueryResults( "extract all Trou" );
		for ( QueryResultsRow row : results ) {
			Trou t = ( Trou ) row.get( "trou" );
			System.out.print( t );
		}
		*/
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MethodsForWebService m = new MethodsForWebService(session);
		System.out.println("\n***********   DOSDANE MAX  ****************");
		System.out.println(m.getAllDosdaneMax());
		
		System.out.println("\n***********   DOSDANE MOY  ****************");
		System.out.println(m.getAllDosdaneMoy());
		
		System.out.println("\n***********   DOSDANE MIN  ****************");
		System.out.println(m.getAllDosdaneMin());
		
		System.out.println("\n***********   DOSDANEALL  ****************");
		System.out.println(m.getAllDosdane());
		
		System.out.println("\n***********   PENTE MAX  ****************");
		System.out.println(m.getAllPenteMax());
		
		System.out.println("\n***********   PENTE MOY  ****************");
		System.out.println(m.getAllPenteMoy());
		
		System.out.println("\n***********   PENTE MIN  ****************");
		System.out.println(m.getAllPenteMin());
		
		System.out.println("\n***********   PENTE ALL  ****************");
		System.out.println(m.getAllPente());
		
		System.out.println("\n***********   TROU MAX  ****************");
		System.out.println(m.getAllTrouMax());
		
		System.out.println("\n***********   TROU MOY  ****************");
		System.out.println(m.getAllTrouMoy());
		
		System.out.println("\n***********   TROU MIN  ****************");
		System.out.println(m.getAllTrouMin());
		
		System.out.println("\n***********   TROU ALL  ****************");
		System.out.println(m.getAllTrou());
		
		
		System.out.println("c bon youfa");		
	}
	
	private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("expert/Rules/trou.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("expert/Rules/pente.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("expert/Rules/Dosdane.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("expert/Rules/UpdateRules.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

}

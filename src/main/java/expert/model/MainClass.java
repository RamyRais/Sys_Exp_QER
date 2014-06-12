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

import expert.database.ConvertDBtoClass;
import expert.database.Dbcom;
import expert.output.Pente;
import expert.output.Trou;
import expert.output.Dosdane;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = Configuration.getInstance();
		//System.out.println(Configuration.toStringa());
		
		ArrayList<Mesure> a = new ArrayList<Mesure>();
		try{
		
			Connection conn = Dbcom.getInstance();
			Statement stmt = conn.createStatement();
			ResultSet result = Dbcom.resultatRequet(stmt,"Select * from mesure LIMIT 0,500");
			a = ConvertDBtoClass.convert(result);
			stmt.close();
			conn.close();
			 
		}catch(SQLException e){
			e.printStackTrace();
		}
		
				
		
		
		
		KnowledgeBase kbase;
		try {
			kbase = readKnowledgeBase();
		
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        
        for (Mesure interMes : a) {
        	 ksession.insert(interMes);
		}
        
		ksession.fireAllRules();
		
		System.out.println("***********  PENTE  ****************");
		QueryResults results = ksession.getQueryResults( "extract all Pente" );
		for ( QueryResultsRow row : results ) {
			Pente p = ( Pente ) row.get( "pente" );
			System.out.print( p );
		}
		System.out.println("\n***********   DOSDANE   ****************");
		results = ksession.getQueryResults( "extract all Dosdane" );
		for ( QueryResultsRow row : results ) {
			Dosdane d = ( Dosdane ) row.get( "dosdane" );
			System.out.print( d );
		}
		System.out.println("\n***********   TROU   ****************");
		results = ksession.getQueryResults( "extract all Trou" );
		for ( QueryResultsRow row : results ) {
			Trou t = ( Trou ) row.get( "trou" );
			System.out.print( t );
		}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("c bon youfa");		
	}
	
	private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("expert/Rules/trou.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("expert/Rules/pente.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("expert/Rules/Dosdane.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("expert/Rules/FetchForWebService.drl"), ResourceType.DRL);
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

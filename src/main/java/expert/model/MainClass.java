package expert.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import org.kie.api.io.ResourceType;
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
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Mesure> a = new ArrayList<Mesure>();
		try{
		
			Connection conn = Dbcom.getInstance();
			Statement stmt = conn.createStatement();
			ResultSet result = Dbcom.resultatRequet(stmt,"Select * from mesure LIMIT 0,100");
			a = ConvertDBtoClass.convert(result);
			stmt.close();
			conn.close();
			 
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		ArrayList<IntervalleMesure> t = new ArrayList<IntervalleMesure>();
		ArrayList<Mesure> inter = new ArrayList<Mesure>();
		
		
		for(int i = 0;i<a.size();i++){
			
			inter.add(a.get(i));
			if(inter.size()==10){
				
				t.add(new IntervalleMesure(inter));
				inter.clear();
			}
		}
		
		
		HashSet trouList = new HashSet();
		HashSet penteList = new HashSet();
		
		KnowledgeBase kbase;
		try {
			kbase = readKnowledgeBase();
		
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        ksession.setGlobal("trouList", trouList);
        ksession.setGlobal("penteList", penteList);
        for (IntervalleMesure interMes : t) {
        	 ksession.insert(interMes);
		}
        ksession.insert(t.get(1));
		ksession.fireAllRules();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***********TROU****************");
		System.out.println(trouList.toString());
		System.out.println("***********PENTE***************");
		System.out.println(penteList.toString());
		System.out.println("c bon youfa");
		
	}
	
	private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("trou.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("pente.drl"), ResourceType.DRL);
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

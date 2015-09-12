package Ascension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import Ascension.CaseListSorter.SortableCase;


public class AscensionTest {

    public static final void main(String[] args) {
    	printTime("Start");
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ascension-rules");

        	printTime("generate cases");
        	// Make and insert some support cases
        	List<SupportCase> cases = new CaseGenerator().generateCases(10);
        	printTime("done generating cases");
        	
        	// Hard code a case to test
        	addHardCodedTestCase(cases);
        	
        	        	
         	for (SupportCase theCase : cases){
         		System.out.println(theCase);
         		kSession.insert(theCase);
         	}
         	printTime("Cases inserted");

             // Make a SupportGuy
        	SupportGuy gss1 = makeSupportGuy();
        	kSession.insert(gss1);
        	
        	// Make a HashMap to score the cases on
        	HashMap<String, Integer> caseScores = new HashMap<String, Integer>();
        	for (SupportCase aCase: cases){
        		int theKey = aCase.getCaseId();
        		String theKeyString = Integer.toString(theKey);
        		caseScores.put(theKeyString, new Integer(0));
        	}
        	        	
        	kSession.setGlobal("caseScores", caseScores);
        	
            kSession.fireAllRules();
            printTime("Done with rules");

            
            
            List<SortableCase> sortedCases = new CaseListSorter().makeSortedScoreList(caseScores);
            for (SortableCase sortedCase : sortedCases){
            	System.out.println(sortedCase.getCaseId() + " score:" + sortedCase.getScore());
            }

            
         } catch (Throwable t) {
            t.printStackTrace();
        }
    }

	private static SupportGuy makeSupportGuy() {
		List <String> sbrs = new ArrayList<String>();
		List <String> tags = new ArrayList<String>();
		sbrs.add(CaseConstants.FUSE);
		sbrs.add(CaseConstants.EAP);
		tags.add(CaseConstants.WS);
		tags.add(CaseConstants.EJB);
		SupportGuy gss1 = new SupportGuy("Rick", CaseConstants.NA, sbrs, tags);
		System.out.println("\n" + gss1 + "\n");
		return gss1;
	}
    
    private static void addHardCodedTestCase(List<SupportCase> cases) {
    	SupportCase sc = new SupportCase();
    	sc.setAccountName("BIG");
    	sc.setCaseId(123456789);
    	sc.setDescription("Problem");
    	sc.setGeo(CaseConstants.NA);
    	List<String> caseSbrs = new ArrayList<String>();
    	caseSbrs.add(CaseConstants.EAP);
    	sc.setSbrs(caseSbrs);
    	List<String> usertags = new ArrayList<String>();
    	usertags.add(CaseConstants.WS);
    	sc.setTags(usertags);
    	cases.add(sc);		
	}

	private static void printTime(String event){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss");
    	String formattedDate = sdf.format(date);
    	System.out.println("###" + formattedDate + " " + event); // 12/01/2011 4:48:16 PM
    }
    

}

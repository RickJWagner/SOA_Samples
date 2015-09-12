package Ascension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaseGenerator {	

	
	public List<SupportCase> generateCases(int howMany){
		ArrayList ret = new ArrayList<SupportCase>();
		for (int idx = 0; idx < howMany; idx++){
			SupportCase aCase = generateRandomSupportCase();
			ret.add(aCase);
		}
		return ret;
	}

	private SupportCase generateRandomSupportCase() {
		SupportCase ret = new SupportCase();
		
		// Case number
		Random rand = new Random();
		int min = 1;
		int max = 99999999;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		ret.setCaseId(randomNum);
		
		// Name
		min = 1;
		max = 3;
		int lenAcctName = rand.nextInt((max - min) + 1) + min;
		max = 24;  // use alphabet
		StringBuilder acctNameBuilder = new StringBuilder();
		for (int idx = 0; idx < lenAcctName; idx++){
			int letter = rand.nextInt((max - min) + 1) + min;
			acctNameBuilder.append(String.valueOf((char)(letter + 64)));
		}
		ret.setAccountName(acctNameBuilder.toString());
		
		// SBR
		List <String> theTags = new ArrayList<String>();
		max = 5;
		int sbrNum = rand.nextInt((max - min) + 1) + min;
		int tags = rand.nextInt((max - min) + 1) + min;
		List<String> sbrs = new ArrayList<String>();
		ret.setSbrs(sbrs);
		if (1 == sbrNum){
			sbrs.add(CaseConstants.FUSE);
			if (1 == tags){
				theTags.add(CaseConstants.WS);
			}
			if (2 == tags){
				theTags.add(CaseConstants.CAMEL);
			}
		}
		if (2 == sbrNum){
			sbrs.add(CaseConstants.EAP);
			if (1 == tags){
				theTags.add(CaseConstants.WS);
			}
			if (2 == tags){
				theTags.add(CaseConstants.EJB);
			}
		}
		if (3 == sbrNum){
			sbrs.add(CaseConstants.KERNEL);
			if (1 == tags){
				theTags.add(CaseConstants.SWAP);
			}
			if (2 == tags){
				theTags.add(CaseConstants.PAGING);
			}
		}
		if (4 == sbrNum){
			sbrs.add(CaseConstants.BRMS);
			if (1 == tags){
				theTags.add(CaseConstants.SCRTY);
			}
			if (2 == tags){
				theTags.add(CaseConstants.BPM);
			}
		}
		if (5 == sbrNum){
			sbrs.add(CaseConstants.EMERGE);
			if (1 == tags){
				theTags.add(CaseConstants.OSFHT);
			}
			if (2 == tags){
				theTags.add(CaseConstants.DCKR);
			}
		}
		ret.setTags(theTags);
		
		// GEO
		max = 5;
		int geo = rand.nextInt((max - min) + 1) + min;
		if (1 == geo){ret.setGeo(CaseConstants.NA);}
		if (2 == geo){ret.setGeo(CaseConstants.APAC);}
		if (3 == geo){ret.setGeo(CaseConstants.INDIA);}
		if (4 == geo){ret.setGeo(CaseConstants.EMEA);}
		if (5 == geo){ret.setGeo(CaseConstants.LATAM);}
		
		// Description
		StringBuilder problem = new StringBuilder();
		max = 3;
		int problem1 = rand.nextInt((max - min) + 1) + min;
		if (1 == problem1){problem.append("The server  ");}
		if (2 == problem1){problem.append("Software    ");}
		if (3 == problem1){problem.append("Application ");}
		int problem2 = rand.nextInt((max - min) + 1) + min;
		if (1 == problem2){problem.append("does not start. ");}
		if (2 == problem2){problem.append("is broken.      ");}
		if (3 == problem2){problem.append("is acting funny.");}
		int problem3 = rand.nextInt((max - min) + 1) + min;
		if (1 == problem3){problem.append("Please help.           ");}
		if (2 == problem3){problem.append("Please do the needful. ");}
		if (3 == problem3){problem.append("Please hurry.          ");}
		ret.setDescription(problem.toString());
		
		return ret;
	}
	
	public static void main(String [] args){
		CaseGenerator generator = new CaseGenerator();
		List<SupportCase> cases = generator.generateCases(10);
		for (SupportCase theCase: cases){
			System.out.println(theCase.toString());
		}
	}

	
	
}

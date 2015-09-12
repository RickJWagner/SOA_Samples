package Ascension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CaseListSorter {
		
	public List<SortableCase> makeSortedScoreList(HashMap<String, Integer> scoredCases){
		List<SortableCase> sortedList = new ArrayList<SortableCase>();
	    Iterator it = scoredCases.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Integer theScore = (Integer)pair.getValue();
	        if (theScore.intValue() > 0){
	        	SortableCase sc = new SortableCase((String)pair.getKey(), theScore.intValue());
	        	sortedList.add(sc);
	        }
	        it.remove(); // avoids a ConcurrentModificationException
	    }		
	    Collections.sort(sortedList);
	    Collections.reverse(sortedList);
		return sortedList;
	}	
	
	public class SortableCase implements Comparable{
		int score;
		String caseId;
		
		public SortableCase(String id, int score){
			this.caseId = id;
			this.score = score;
		}
		
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public String getCaseId() {
			return caseId;
		}
		public void setCaseId(String caseId) {
			this.caseId = caseId;
		}

		@Override
		public int compareTo(Object arg0) {
			SortableCase otherCase = (SortableCase) arg0;
			if (score == otherCase.getScore()){
				return 0;
			}else if (score > otherCase.getScore()){
				return 1;
			}else{
				return -1;
			}
		}
	}
	

	

}

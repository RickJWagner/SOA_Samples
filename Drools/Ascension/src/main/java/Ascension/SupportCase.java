package Ascension;

import java.util.List;

public class SupportCase {
	
	private int caseId;
	private String accountName;
	//private String sbr;
	// use List, not single for better Drools behavior
	private List <String> sbrs;
	private List <String> tags;
	private String description;
	private String geo;
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Case:" + caseId);
		sb.append("\tDescription:" + description );
		sb.append("\tAccountName:" + accountName);
		sb.append("\tGeo:" + geo);
		sb.append("\tSBRs:");
		for (String sbr : sbrs){
			sb.append(" " + sbr + " ");
		}
		sb.append("\tTags:");
		for (String tag : tags){
			sb.append(" " + tag + " ");
		}
		return sb.toString();
	}
	
	
	public int getCaseId() {
		return caseId;
	}
	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public List<String> getSbrs() {
		return sbrs;
	}
	public void setSbrs(List<String> sbrs) {
		this.sbrs = sbrs;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}
	
	
	
	

}

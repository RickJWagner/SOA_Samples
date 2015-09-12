package Ascension;

import java.util.List;

public class SupportGuy {
	
	private String name;
	private String geo;
	private List <String> tags;
	private List <String> sbrs;
	
	public SupportGuy (String name, String geo, List<String> sbrs, List<String> tags){
		this.name = name;
		this.geo = geo;
		this.tags = tags;
		this.sbrs = sbrs;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Name:" + name);
		sb.append(" Geo:" + geo);
		sb.append(" Tags:");
		for (String tag : tags){
			sb.append(" " + tag );
		}
		sb.append(" SBRs:");
		for (String sbr : sbrs){
			sb.append (" " + sbr);
		}
		return sb.toString();
	}
	

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public List<String> getSbrs() {
		return sbrs;
	}
	public void setSbrs(List<String> sbrs) {
		this.sbrs = sbrs;
	}
	
	

}

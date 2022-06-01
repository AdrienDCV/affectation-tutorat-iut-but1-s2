package sae201202;

import org.json.JSONObject;

public class useMotivation {
	public static void main(String[] args) {
		String out = "{";
		for(Motivation aMotivation: Motivation.values()) {
			out = out + aMotivation.name().charAt(0) +":"+ aMotivation.name()+",";
		}
		out = out.substring(0,out.length()-1)+"}";

		System.out.println(new JSONObject(out));
		
	}
}

package sae201202;

/**
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public enum Motivation {
	//motivation des étudiants
	HIGH_MOTIVATION("HM"), AVERAGE_MOTIVATION("AM"), LOW_MOTIVATION("LM"), NO_MOTIVATION("NM"), UNKNOWN("UNKWN");
	
	private String label;
	
	private Motivation(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
}

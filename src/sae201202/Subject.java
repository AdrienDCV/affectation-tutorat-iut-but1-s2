package sae201202;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public enum Subject {
	//liste des sujets
	ALGO("Algorithmie"), SYSTEMES("Sytemes"), MATHS("Maths discretes"), DEV_OO("Developpement oriente objet"), RESEAUX("Reseaux"), BAS_NIVEAU("Bas niveau"), BDD("Base de données");
	
	private String label;
	
	private Subject(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
}

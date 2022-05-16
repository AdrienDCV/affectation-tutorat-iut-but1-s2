package sae201202;

import java.time.LocalDate;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */

public class Teacher extends Person {
	// class attributes
	private String teaching;
	
	// constructor(s)
	public Teacher(String name, String forename, LocalDate birthDate, String ID, String passWord, String mail) {
		super(name, forename, birthDate, passWord);
		this.setMail(name, forename);
		this.setID(name, forename);	
	}

	/**
	 * 
	 * Retourne l'attribut Teaching
	 * @return la valeur de l'attribut teaching
	 */
	public String getTeaching() {
		return teaching;
	}


	/**
	 * 
	 * Change l'attribut Teaching
	 * @param teaching
	 */
	public void setTeaching(String teaching) {
		this.teaching = teaching;
	}

	@Override
	public String setMail(String name, String forename) {
		return name.toLowerCase().replaceAll(" ", "")+'.'+forename.toLowerCase().replaceAll(" ", "")+"@univ-lille.fr";
	}

	@Override
	public String setID(String name, String forename) {
		return name.toLowerCase().replaceAll(" ", "")+'.'+forename.toLowerCase().replaceAll(" ", "");
	}

}

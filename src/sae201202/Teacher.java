package sae201202;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */

public class Teacher extends Person {
	// class attributes
	private String teacherID;
	private String teaching;
	

	/**
	 * 
	 * @param name
	 * @param forename
	 * @param age
	 * @param mail
	 * @param teacherID
	 * @param teaching
	 */
	// constructor(s)
	public Teacher(String name, String forename, int age, String mail, String teacherID, String teaching) {
		super(name, forename, age, mail);
		this.teacherID = teacherID;
		this.teaching = teaching; 
	}

	/**
	 * 
	 * Retourne l'attribut TeacherID
	 * @return la valeur de l'attribut teacherID
	 */
	// Methods 
	public String getTeacherID() {
		return teacherID;
	}
	
	/**
	 * Change l'attribut TeacherID
	 * @param teacherID
	 */
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
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

}

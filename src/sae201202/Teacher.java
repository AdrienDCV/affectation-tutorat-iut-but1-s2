package sae201202;

<<<<<<< HEAD
/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
public class Teacher extends Person {
	// class attributes
	private String teacherID;
	private String teaching;
	
<<<<<<< HEAD
	/**
	 * 
	 * @param name
	 * @param forename
	 * @param age
	 * @param mail
	 * @param teacherID
	 * @param teaching
	 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	// constructor(s)
	public Teacher(String name, String forename, int age, String mail, String teacherID, String teaching) {
		super(name, forename, age, mail);
		this.teacherID = teacherID;
		this.teaching = teaching; 
	}

<<<<<<< HEAD
	/**
	 * 
	 * 
	 * @return
	 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	// Methods 
	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

<<<<<<< HEAD
	/**
	 * 
	 * 
	 * @return
	 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	public String getTeaching() {
		return teaching;
	}

<<<<<<< HEAD
	/**
	 * 
	 * 
	 * @param teaching
	 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	public void setTeaching(String teaching) {
		this.teaching = teaching;
	}
	
	
	
	
}

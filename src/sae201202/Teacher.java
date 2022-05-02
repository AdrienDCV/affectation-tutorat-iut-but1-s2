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
	 * 
	 * @return
	 */
	// Methods 
	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public String getTeaching() {
		return teaching;
	}

	/**
	 * 
	 * 
	 * @param teaching
	 */
	public void setTeaching(String teaching) {
		this.teaching = teaching;
	}
	
	
	
	
}

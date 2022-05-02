package sae201202;

public class Teacher extends Person {
	// class attributes
	private String teacherID;
	private String teaching;
	
	// constructor(s)
	public Teacher(String name, String forename, int age, String mail, String teacherID, String teaching) {
		super(name, forename, age, mail);
		this.teacherID = teacherID;
		this.teaching = teaching; 
	}

	// Methods 
	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeaching() {
		return teaching;
	}

	public void setTeaching(String teaching) {
		this.teaching = teaching;
	}
	
	
	
	
}

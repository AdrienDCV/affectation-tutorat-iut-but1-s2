package sae201202;

<<<<<<< HEAD
/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
public class Person {
	// class attributes
	private String name;
	private String forename;
	private int age;
	private String mail;
	
	// constructor(s)
	public Person (String name, String forename, int age, String mail) {
		this.name = name;
		this.forename = forename;
		this.age = age;
		this.mail = mail;
	}
	
	// methods 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String toString() {
		return name + ", " + forename + ", " + age + ", " + mail;
	}
	
	
	
	
}

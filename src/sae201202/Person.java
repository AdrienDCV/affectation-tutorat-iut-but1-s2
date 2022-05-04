package sae201202;


/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class Person {
	// class attributes
	private String name;
	private String forename;
	private int age;
	private String mail;
	
	// constructor(s)
	/**
	 * 
	 * @param name
	 * @param forename
	 * @param age
	 * @param mail
	 */
	public Person (String name, String forename, int age, String mail) {
		this.name = name;
		this.forename = forename;
		this.age = age;
		this.mail = mail;
	}
	
	// methods 
	/**
	 * 
	 * TODO
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * TODO
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public String getForename() {
		return forename;
	}
	
	/**
	 * 
	 * TODO
	 * @param forename
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * 
	 * TODO
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * 
	 * TODO
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return name + ", " + forename + ", " + age + ", " + mail;
	}
	
	
	
	
}

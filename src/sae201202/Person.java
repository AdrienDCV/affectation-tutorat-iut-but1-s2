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
	 * Retourne l'attribut Name
	 * TODO
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Change l'attribut Name
	 * TODO
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Retourne l'attribut Forename
	 * TODO
	 * @return
	 */
	public String getForename() {
		return forename;
	}
	
	/**
	 * Change l'attribut Forename
	 * TODO
	 * @param forename
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	/**
	 * Retourne l'attribut Age
	 * TODO
	 * @return
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Change l'attribut Age
	 * TODO
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Retourne l'attribut Mail
	 * TODO
	 * @return
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * Change l'attribut Mail
	 * TODO
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * Retourne l'objet Person de la forme "nom, prénom, age, mail"
	 */
	public String toString() {
		return name + ", " + forename + ", " + age + ", " + mail;
	}
	
	
	
	
}

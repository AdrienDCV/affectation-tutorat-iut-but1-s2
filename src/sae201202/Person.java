package sae201202;

import java.time.LocalDate;
import java.time.Period;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public abstract class Person {
	// class attributes
	private String name;
	private String forename;
	private final LocalDate birthDate;
	private int age;
	private final String ID;
	private String passWord;
	private String mail;
	
	// constructor(s)
	/**
	 * 
	 * @param name
	 * @param forename
	 * @param age
	 * @param mail
	 */
	public Person (String name, String forename, LocalDate birthDate, String passWord) {
		this.name = name;
		this.forename = forename;
		this.birthDate = birthDate;
		this.age = Period.between(birthDate,LocalDate.now()).getYears();
		this.ID = setID(name, forename);
		this.passWord = passWord;
		this.mail = setMail(name, forename);
	}

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

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public abstract String setMail(String name, String forename); 
	
	public abstract String setID(String name, String forename);
	
	public String toString() {
		return name + ' ' + forename + "(" + age + ") : " + "ID : " + ID + ", mail : " + mail; 
	}
}

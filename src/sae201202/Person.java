package sae201202;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public abstract class Person {
	// class attributes
	/**
	 * Un objet Person est caract�ris� par un nom (String name), un pr�nom (String forename), une date de naissance (LocalDate birthDate)
	 * � partir de laquelle on d�terminera dynamiquement sont age (int age), un identifiant et mail generes automatiquement suivant le fonction
	 * de Person � l'aide de m�thodes abstraites. Et d'un mot de passe (String passWord)
	 */
	private String name;
	private String forename;
	private final LocalDate BIRTHDATE;
	private int age;
	private final String ID;
	private String passWord;
	private final String MAIL;
	
	// constructor(s)
	/**
	 * Initalisation des attributs.
	 * @param name
	 * @param forename
	 * @param age
	 * @param MAIL
	 */
	public Person (String name, String forename, LocalDate birthDate, String passWord) {
		this.name = name;
		this.forename = forename;
		this.BIRTHDATE = birthDate;
		this.setAge();
		this.ID = setID(name, forename);
		this.passWord = passWord;
		this.MAIL = setMail(name, forename);
	}

	/**
	 * Donne acces � l'attribut birthDate
	 * @return birthDate
	 */
	public LocalDate getBirthDate() {
		return BIRTHDATE;
	}

	/**
	 *  Donne acces � l'attribut name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Permet de modifier l'attribut name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Donne acces � l'attribut forename
	 * @return forename
	 */
	public String getForename() {
		return forename;
	}

	/**
	 * Permet de modifier l'attribut forename
	 * @param forename
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}

	/**
	 * Donne acces � l'attribut age
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Clacul dynamiquement l'age de l'object Person
	 */
	public void setAge() {
		this.age = (int) BIRTHDATE.until(LocalDate.now(), ChronoUnit.YEARS);;
	}

	/**
	 * Permet de modifier l'attribut passWord
	 * @param passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	/**
	 * Donne acces � l'attribut mail
	 * @return mail
	 */
	public String getMail() {
		return this.MAIL;
	}
	
	/**
	 * Donne acces � l'attribut ID
	 * @return
	 */
	public String getID() {
		return this.ID;
	}
	
	/**
	 * M�thode abstract qui sera � d�clarer dans les classes filles (Student ou Teacher)
	 * Permet de modifier la valeur de l'attribut mail
	 * @param name
	 * @param forename
	 * @return mail genere automatiquement � partir du prenom (forename), nom (name) de Person 
	 */
	public abstract String setMail(String name, String forename); 
	
	/**
	 * M�thode abstract qui sera � d�clarer dans les classes filles (Student ou Teacher)
	 * Permet de modifier la valeur de l'attribut ID
	 * @param name
	 * @param forename
	 * @return ID genere automatiquement � partir du prenom (forename) et nom (name) de Person
	 */
	public abstract String setID(String name, String forename);
	
	/**
	 * Permet d'afficher un objet Person
	 */
	public String toString() {
		return name + ' ' + forename + " (" + age + ") : " + "ID : " + ID + ", mail : " + MAIL; 
	}

	/**
	 * Permet de savoir si deux objets Person sont identique
	 * @return true si this est indentique � 
	 */
	public boolean equals(Person p2) {
		if (this == p2)
			return true;
		if (p2 == null)
			return false;
		return Objects.equals(ID, p2.ID) && age == p2.age && Objects.equals(BIRTHDATE, p2.BIRTHDATE)
				&& Objects.equals(forename, p2.forename) && Objects.equals(MAIL, p2.MAIL)
				&& Objects.equals(name, p2.name) && Objects.equals(passWord, p2.passWord);
	}
	
	
}

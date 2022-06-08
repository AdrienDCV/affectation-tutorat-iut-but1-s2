package sae201202;

import java.time.LocalDate;
import java.util.*;

/**
 * @authors adrien.dacostaveiga & adrien.degand
 * La classe FirstYearStudent permet de cr�er des �tudiants (Student) de premi�re ann�e et ainsi d'�tablir une diff�renciation 
 * entre les �tudiants de type Student dont cette classe est h�riti�re.
 */
public class FirstYearStudent extends Student {
	
	// class attributes
	/**
	 * Un FirstYearStudent peut aussi �tre consid�r� comme �tant un tutor�.
	 * Il est donc caract�ris� par un Student tuteur (ThirYearStudent  / SecondYearStudent) et une mati�re (Subject) suivit.
	 * Un FirstYearStudent h�rite des attributs et m�thodes d'un Student. Il est donc �galement caract�ris� par les m�mes attributs 
	 * de cette derni�re classe.
	 */
	private Student isTutoredBy;
	private Subject subjectTutored;
	
	// constructor
	/**
	 * Initialisation des attributs.
	 * @param name
	 * @param forename
	 * @param birthDate
	 * @param ID
	 * @param passWord
	 * @param mail
	 * @param scholarYear
	 * @param group
	 * @param motivation
	 * @param absence
	 * @param grades
	 */
	public FirstYearStudent(String name, String forename, LocalDate birthDate, String ID, String passWord, String mail,
							int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades) {
		super(name, forename, birthDate, ID, passWord, mail, scholarYear, group, motivation, absence, grades);
		this.isTutoredBy = null;
		this.subjectTutored = null;
	}
	
	public FirstYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, motivation, absence, grades);
		this.isTutoredBy = null;
		this.subjectTutored = null;
	}
	
	public FirstYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, Motivation motivation, int absence) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, motivation, absence, new HashMap<Subject, Double>());
		this.isTutoredBy = null;
		this.subjectTutored = null;
	}
	
	public FirstYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, int absence, Map<Subject, Double> grades) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, Motivation.UNKNOWN, absence, grades);
		this.isTutoredBy = null;
		this.subjectTutored = null;
	}
	
	public FirstYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, int absence) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, Motivation.UNKNOWN, absence, new HashMap<Subject, Double>());
		this.isTutoredBy = null;
		this.subjectTutored = null;
	}


	// methods
	/**
	 * Donne acces au tuteur du FirstYearStudent
	 * @return isTutoredBy
	 */
	public Student getIsTutoredBy() {
		return isTutoredBy;
	}

	/**
	 * Permet de modifier la valeur de l'attribut isTutyoredBy
	 * @param isTutoredBy
	 */
	public void setIsTutoredBy(Student isTutoredBy) {
		this.isTutoredBy = isTutoredBy;
	}
	
	/**
	 * Donne acces � la mati�re tutor�e
	 * @return subjectTutored
	 */
	public Subject getSubjectTutored() {
		return subjectTutored;
	}

	/**
	 * Permet de modifier la valeur de l'attribut subjectTutored
	 * @param subjectTutored
	 */
	public void setSubjectTutored(Subject subjectTutored) {
		this.subjectTutored = subjectTutored;
	}

}
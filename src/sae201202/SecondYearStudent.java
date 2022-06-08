package sae201202;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @authors adrien.dacostaveiga & adrien.degand
 *La classe SecondYearStudent permet de cr�er des �tudiants de deuxi�me ann�e et ainsi d'�tablir une diff�renciation 
 * entre les �tudiants dont cette classe est h�riti�re.
 */
public class SecondYearStudent extends Student{
	
	// class attributes
	/**
	 * Un SecondYearStudent peut aussi �tre consid�r� comme �tant un tuteur.
	 * Il est donc caract�ris� par un Student tutor� (FirstYearStudent) et une mati�re (Subject) tutor�e.
	 * Un SecondYear h�rite des attributs et m�thodes d'un Student. Il est donc �galement caract�ris� par les m�mes attributs 
	 * de cette derni�re classe 	  	
	 */
	private Student isTutorOf;
	private Subject subjectTutored;
	
	// constructor(s)
	/**
	 * Initilisation des attributs
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
	public SecondYearStudent(String name, String forename, LocalDate birthDate, String ID, String passWord, String mail,
							 int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades) {
		super(name, forename, birthDate, ID, passWord, mail, scholarYear, group, motivation, absence, grades);
		this.isTutorOf = null;
		this.subjectTutored = null;
	}

	public SecondYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, Motivation motivation, int absence,
							 Map<Subject, Double> grades) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, motivation, absence, grades);
		this.isTutorOf = null;
		this.subjectTutored = null;
	}

	public SecondYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, Motivation motivation,int absence) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, motivation, absence, null);
		this.isTutorOf = null;
		this.subjectTutored = null;
	}

	public SecondYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group,int absence) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, Motivation.UNKNOWN, absence, null);
		this.isTutorOf = null;
		this.subjectTutored = null;
	}
	/**
	 * Return l'�tudiant dont l'objet SecondYearStudent courant est tuteur
	 * @return Student isTutorOf
	 */
	public Student getIsTutorOf() {
		return isTutorOf;
	}

	/**
	 * Permet de modifier la valeur de l'attribut isTutorOf
	 * @param isTutorOf
	 */
	public void setIsTutorOf(Student isTutorOf) {
		this.isTutorOf = isTutorOf;
	}

	/**
	 * Return la valeur de l'attribut subjectTutored
	 * @return
	 */
	public Subject getSubjectTutored() {
		return subjectTutored;
	}

	/**
	 * Permet de modifier la valeur de l'attribut subjectTutored
	 * @param subjectTutored
	 */
	public void setSubject(Subject subjectTutored) {
		this.subjectTutored = subjectTutored;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isTutorOf, subjectTutored);
	}

	/**
	 * Return true si l'objet courant est identique � SecondYearStudent s2
	 * @return True / False
	 */
	

	

}

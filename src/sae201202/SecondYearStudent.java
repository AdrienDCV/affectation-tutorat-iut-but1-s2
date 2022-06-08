package sae201202;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @authors adrien.dacostaveiga & adrien.degand
 *La classe SecondYearStudent permet de créer des étudiants de deuxième année et ainsi d'établir une différenciation 
 * entre les étudiants dont cette classe est héritière.
 */
public class SecondYearStudent extends Student{
	
	// class attributes
	/**
	 * Un SecondYearStudent peut aussi être considéré comme étant un tuteur.
	 * Il est donc caractérisé par un Student tutoré (FirstYearStudent) et une matière (Subject) tutorée.
	 * Un SecondYear hérite des attributs et méthodes d'un Student. Il est donc également caractérisé par les mêmes attributs 
	 * de cette dernière classe 	  	
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
	 * Return l'étudiant dont l'objet SecondYearStudent courant est tuteur
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
	 * Return true si l'objet courant est identique à SecondYearStudent s2
	 * @return True / False
	 */
	

	

}

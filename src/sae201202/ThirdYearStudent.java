package sae201202;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * @authors adrien.dacostaveiga.etu & adrien.degand
 *
 */
public class ThirdYearStudent extends Student {
	// class attributes
	private Map<Student, Subject> isTutorOf;
	private boolean acceptsSeveralTutored;
	
	// constrcutor(s)
	/**
	 * 
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
	 * @param acceptsSeveralTutored
	 */
	public ThirdYearStudent(String name, String forename, LocalDate birthDate, String ID, String passWord, String mail,
							int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades, boolean acceptsSeveralTutored) {
		super(name, forename, birthDate, ID, passWord, mail, scholarYear, group, motivation, absence, grades);
		this.isTutorOf = new HashMap<Student, Subject>();
		this.acceptsSeveralTutored = acceptsSeveralTutored;
	}
	
	// constructeur faux-profil
	public ThirdYearStudent(String name, String forename, LocalDate birthDate, String ID, String passWord, String mail,
							int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades) {
		super(name, forename, birthDate, ID, passWord, mail, scholarYear, group, motivation, absence, grades);
		this.isTutorOf = new HashMap<Student, Subject>();
		this.acceptsSeveralTutored = false;
	}

	
	public ThirdYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, Motivation motivation,
			int absence, boolean acceptsSeveralTutored, Map<Subject, Double> grades) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, motivation, absence, grades);
	}

	// methods
	public Map<Student, Subject> getIsTutorOf() {
		return isTutorOf;
	}

	public void setIsTutorOf(Map<Student, Subject> isTutorOf) {
		this.isTutorOf = isTutorOf;
	}

	public boolean doesAcceptSeveralTutored() {
		return this.acceptsSeveralTutored;
	}
	

	public void setAcceptsSeveralTutored(boolean severalTutored) {
		this.acceptsSeveralTutored = severalTutored;
	}
	
	

}

package sae201202;

import java.time.LocalDate;
import java.util.*;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class FirstYearStudent extends Student {
	
	// class attributes
	private Student isTutoredBy;
	private Subject subjectTutored;
	
	// constructor
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
	public Student getIsTutoredBy() {
		return isTutoredBy;
	}

	public void setIsTutoredBy(Student isTutoredBy) {
		this.isTutoredBy = isTutoredBy;
	}

	public Subject getSubjectTutored() {
		return subjectTutored;
	}

	public void setSubjectTutored(Subject subjectTutored) {
		this.subjectTutored = subjectTutored;
	}

}
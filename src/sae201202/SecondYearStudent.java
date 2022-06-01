package sae201202;

import java.time.LocalDate;
import java.util.Map;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class SecondYearStudent extends Student{
	
	// class attributes
	private Student isTutorOf;
	private Subject subjectTutord;
	
	// constructor(s)
	public SecondYearStudent(String name, String forename, LocalDate birthDate, String ID, String passWord, String mail,
							 int scholarYear, char group, Motivation motivation, int absence, String subjectWished, Map<Subject, Double> grades) {
		super(name, forename, birthDate, ID, passWord, mail, scholarYear, group, motivation, absence, subjectWished, grades);
		this.isTutorOf = null;
		this.subjectTutord = null;
	}

	public SecondYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, Motivation motivation, int absence,
							 Map<Subject, Double> grades) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, motivation, absence, null, grades);
		this.isTutorOf = null;
		this.subjectTutord = null;
	}

	public Student getIsTutorOf() {
		return isTutorOf;
	}

	public void setIsTutorOf(Student isTutorOf) {
		this.isTutorOf = isTutorOf;
	}

	public Subject getSubjectTutored() {
		return subjectTutord;
	}

	public void setSubject(Subject subjectTutored) {
		this.subjectTutord = subjectTutored;
	}
	
	// methods


}

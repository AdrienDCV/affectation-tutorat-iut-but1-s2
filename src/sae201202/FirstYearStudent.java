package sae201202;

import java.util.*;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class FirstYearStudent extends Student {
	// class attributes
	private Student isTutoredBy;
	private Subject subject;
	
	// constructors
	/**
	 * 
	 * @param name
	 * @param forename
	 * @param age
	 * @param mail
	 * @param scholarYear
	 * @param group
	 * @param studentID
	 * @param motivation
	 * @param absence
	 * @param grades
	 * @param isTutoredBy
	 * @param subject
	 */
	public FirstYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<Subject, Double> grades, Student isTutoredBy, Subject subject) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, false, grades);
		this.isTutoredBy = isTutoredBy;
		this.subject = subject;
	}
	public FirstYearStudent(String name, String forename, int age, String mail, int schoolYear, char group, String studentID, Motivation motivation, int absence, Map<Subject, Double> grades) {
		this(name, forename, age, mail, schoolYear, group, studentID, motivation, absence, grades, null, null);
	}

	public FirstYearStudent(String name, String forename, int age, String mail, int schoolYear, char group, String studentID, Motivation motivation, int absence) {
		this(name, forename, age, mail, schoolYear, group, studentID, motivation, absence, new HashMap<Subject,Double>(), null, null);
	}
}

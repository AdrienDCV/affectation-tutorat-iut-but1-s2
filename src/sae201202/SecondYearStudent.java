package sae201202;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class SecondYearStudent extends Student{
	// class attributes
	private Student isTutorOf;
	private Subject subject;
	
	// constructor(s)
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
	 * @param  
	 * @param grades
	 * @param isTutorOf
	 */
	public SecondYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<Subject, Double> grades, Student isTutorOf, Subject subject) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, false, grades);
		this.isTutorOf = isTutorOf;
		this.subject = subject;
	}
	public SecondYearStudent(String name, String forename, int age, String mail, int schoolYear, char group, String studentID, Motivation motivation, int absence, Map<Subject, Double> grades) {
		this(name, forename, age, mail, schoolYear, group, studentID, motivation, absence, grades, null, null);
	}


}

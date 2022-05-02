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
	private String subject;
	
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
	 * @param isTutorOf
	 */
	// constructor(s)
	public SecondYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, boolean acceptsSeveralTutored, Map<Subject, Double> grades, Student isTutorOf) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, acceptsSeveralTutored, grades);
		this.isTutorOf = isTutorOf;
	}
	public SecondYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<Subject, Double> grades) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, false, grades);
	}

	
}

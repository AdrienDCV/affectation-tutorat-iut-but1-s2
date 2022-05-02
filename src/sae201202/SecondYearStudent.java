package sae201202;

import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD
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

	
=======
public class SecondYearStudent extends Student{
	// class attributes
	private Map<Student, String> isTutorOf;
	
	// constructor(s)
	public SecondYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<String, Double> grades, Map<Student, String> isTutorOf) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, grades);
		this.isTutorOf = isTutorOf;
	}
	public SecondYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<String, Double> grades) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, grades, new HashMap<Student, String>());	
	}
	public SecondYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, new HashMap<String,Double>(), new HashMap<Student, String>());	
	}
	
		
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
}

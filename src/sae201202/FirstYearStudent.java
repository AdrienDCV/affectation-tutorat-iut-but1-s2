package sae201202;

import java.util.*;

<<<<<<< HEAD
/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class FirstYearStudent extends Student {
	// class attributes
	private String isTutoredBy;
	private Subject subject;
	
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
	// constructors
	public FirstYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, boolean acceptsSeveralTutored ,Map<Subject, Double> grades, String isTutoredBy, Subject subject) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, acceptsSeveralTutored, grades);
		this.isTutoredBy = isTutoredBy;
		this.subject = subject;
	}
	public FirstYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<Subject, Double> hgrades) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, false ,new HashMap<Subject, Double>(), "---", null);
	}
=======

public class FirstYearStudent extends Student {
	// class attributes
	private Map<Student, String> isTutoredBy;
	
	// constructors
	public FirstYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<String, Double> grades, Map<Student, String> isTutoredBy) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, grades);
		this.isTutoredBy = isTutoredBy;
	}
	public FirstYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<String, Double> grades) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, grades, new HashMap<Student, String>());	
	}
	public FirstYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, new HashMap<String,Double>(), new HashMap<Student, String>());	
	}
	
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
}

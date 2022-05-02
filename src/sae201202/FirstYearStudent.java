package sae201202;

import java.util.*;


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
	
}

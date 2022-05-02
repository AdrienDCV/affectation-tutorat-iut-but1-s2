package sae201202;

import java.util.HashMap;
import java.util.Map;

public class ThirdYearStudent extends Student {
	// class attributes
	private Map<Student, String> isTutorOf;
	
	
	// constructor(s)
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<String, Double> grades, Map<Student, String> isTutorOf) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, grades);
		this.isTutorOf = isTutorOf;
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<String, Double> grades) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, grades, new HashMap<Student, String>());	
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, new HashMap<String,Double>(), new HashMap<Student, String>());	
	}
		
}

package sae201202;

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
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, boolean acceptsSeveralTutored, Map<Subject, Double> grades, Map<Student, Subject> isTutorOf) {
		super(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, acceptsSeveralTutored, grades);
		this.isTutorOf = isTutorOf;
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, boolean acceptsSeveralTutored, Map<Subject, Double> grades) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, acceptsSeveralTutored, grades, new HashMap<Student,Subject>());
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, boolean acceptsSeveralTutored) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, acceptsSeveralTutored, new HashMap<Subject,Double>(), new HashMap<Student,Subject>());
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, absence, false, new HashMap<Subject,Double>(), new HashMap<Student,Subject>());
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation) {
		this(name, forename, age, mail, scholarYear, group, studentID, motivation, 0, false, new HashMap<Subject,Double>(), new HashMap<Student,Subject>());
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group, String studentID) {
		this(name, forename, age, mail, scholarYear, group, studentID, Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>(), new HashMap<Student,Subject>());
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear, char group) {
		this(name, forename, age, mail, scholarYear, group, "---", Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>(), new HashMap<Student,Subject>());
	}
	public ThirdYearStudent(String name, String forename, int age, String mail, int scholarYear) {
		this(name, forename, age, mail, scholarYear, '-', "---", Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>(), new HashMap<Student,Subject>());
	}
	public ThirdYearStudent(String name, String forename, int age, String mail) {
		this(name, forename, age, mail, 0, '-', "---", Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>(), new HashMap<Student,Subject>());
	}
	public ThirdYearStudent(String name, String forename, int age) {
		this(name, forename, age, "---", 0, '-', "---", Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>(), new HashMap<Student,Subject>());
	}

}

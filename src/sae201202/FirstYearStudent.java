package sae201202;

import java.util.*;

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
}

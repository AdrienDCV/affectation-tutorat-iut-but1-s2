package sae201202;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */

public class Teacher extends Person {
	// class attributes
	private Subject teaching;
	private List<Student> listStudent;
	private List<Student> listCandidate;
	private double minGrade;
	private int maxAbsence;
	private Motivation minMotivation;
	private Affectation affectation;
	
	/**
	 * 
	 * @param name
	 * @param forename
	 * @param birthDate
	 * @param passWord
	 * @param teaching
	 * @param listStudent
	 */
	// constructor(s)
	public Teacher(String name, String forename, LocalDate birthDate, String passWord, Subject teaching, List<Student> listStudent, List<Student> listCandidate, double minGrade, int maxAbsence, Motivation minMotivation) {
		super(name, forename, birthDate, passWord);
		this.setMail(name, forename);
		this.setID(name, forename);	
		this.teaching = teaching;
		this.listStudent = listStudent;
		this.listCandidate = listCandidate;
		this.minGrade = minGrade;
		this.maxAbsence = maxAbsence;
		this.minMotivation = minMotivation;
		this.affectation = new Affectation();
	}
	
	public Teacher(String name, String forename, LocalDate birthDate, String passWord, Subject teaching, double minGrade, int maxAbsence) {
		super(name, forename, birthDate, passWord);
		this.setMail(name, forename);
		this.setID(name, forename);	 
		this.teaching = teaching;
		this.listStudent = new ArrayList<Student>();
		this.listCandidate = new ArrayList<Student>();
		this.minGrade = minGrade;
		this.maxAbsence = maxAbsence;
		this.minMotivation = Motivation.UNKNOWN;
		this.affectation = new Affectation();
	}
	
	public Teacher(String name, String forename, LocalDate birthDate, String passWord, Subject teaching) {
		super(name, forename, birthDate, passWord);
		this.setMail(name, forename);
		this.setID(name, forename);	 
		this.teaching = teaching;
		this.listStudent = new ArrayList<Student>();
		this.listCandidate = new ArrayList<Student>();
		this.minGrade = 0;
		this.maxAbsence = Integer.MAX_VALUE;
		this.minMotivation = Motivation.UNKNOWN;
		this.affectation = new Affectation();
	}
	

	/**
	 * 
	 * Retourne l'attribut Teaching
	 * @return la valeur de l'attribut teaching
	 */
	public Subject getTeaching() {
		return teaching;
	}


	/**
	 * 
	 * Change l'attribut Teaching
	 * @param teaching
	 */
	public void setTeaching(Subject teaching) {
		this.teaching = teaching;
	}

	/**
	 * 
	 */
	@Override
	public String setMail(String name, String forename) {
		return name.toLowerCase().replaceAll(" ", "")+'.'+forename.toLowerCase().replaceAll(" ", "")+"@univ-lille.fr";
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List<Student> getListStudent() {
		return listStudent;
	}

	/**
	 * 
	 * @param listStudent
	 */
	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

	/**
	 * 
	 * @return
	 */
	public List<Student> getListCandidate() {
		return listCandidate;
	}

	/**
	 * 
	 * @param listCandidate
	 */
	public void setListCandidate(List<Student> listCandidate) {
		this.listCandidate = listCandidate;
	}

	/**
	 * 
	 * @return
	 */
	public double getMinGrade() {
		return minGrade;
	}

	/**
	 * 
	 * @param minGrade
	 */
	public void setMinGrade(double minGrade) {
		this.minGrade = minGrade;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getMaxAbsence() {
		return maxAbsence;
	}

	/**
	 * 
	 * @param maxAbsence
	 */
	public void setMaxAbsence(int maxAbsence) {
		this.maxAbsence = maxAbsence;
	}

	/**
	 * 
	 * @return
	 */
	public Motivation getMinMotivation() {
		return minMotivation;
	}

	/**
	 * 
	 * @param minMotivation
	 */
	public void setMinMotivation(Motivation minMotivation) {
		this.minMotivation = minMotivation;
	}

	/**
	 * 
	 */
	@Override
	public String setID(String name, String forename) {
		return name.toLowerCase().replaceAll(" ", "")+'.'+forename.toLowerCase().replaceAll(" ", "");
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentNameASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new PersonNameComparator());
		return l;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentNameDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new PersonNameComparator().reversed());
		return l;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentForenameASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new PersonForenameComparator());
		return l;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentForenameDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new PersonForenameComparator().reversed());
		return l;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentScholarYearASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentScholarYearComparator());
		return l;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentScholarYearDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentScholarYearComparator().reversed());
		return l;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudetnGradesASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentGradesComparator(this.teaching));
		return l;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentGradesDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentGradesComparator(this.teaching).reversed());
		return l;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentAbsenceASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentAbsenceComparator());
		return l;
	} 
	
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> sortByStudentAbsenceDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentAbsenceComparator().reversed());
		return l;
	} 

}

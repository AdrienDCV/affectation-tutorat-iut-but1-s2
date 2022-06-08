package sae201202;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */

public class Teacher extends Person {
	// class attributes
	/**
	 * Un Teacher est caractérisé par une matière enseignée (Subject teaching), une liste d'étudiants Tuteurs et tutorés inscrits
	 * à son enseignement (List<Student> listStudent), une liste de candidats au rôle de tuteur (List<Student> listCandidate).
	 * Ainsi que des critères de selection concernant les candidats au rôle de tuteur : une moyenne / note minimale (double minGrade),
	 * un nombre max. d'absences tolérées (int maxAbsence), une motivation minimale (Motivation minMotivation) et enfin une affectation 
	 * qui permettra de réaliser des calculs d'affectation (Affectation affectation).
	 */
	private Subject teaching;
	private List<Student> listStudent;
	private List<Student> listCandidate;
	private double minGrade;
	private int maxAbsence;
	private Motivation minMotivation;
	private Affectation affectation;
	
	
	// constructor(s)
	/**
	 * Initialisation des attributs 
	 * @param name
	 * @param forename
	 * @param birthDate
	 * @param passWord
	 * @param teaching
	 * @param listStudent
	 */
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
	 * Return la valeur de l'attribut teaching
	 * @return la valeur de l'attribut teaching
	 */
	public Subject getTeaching() {
		return teaching;
	}


	/**
	 * Permet de modifier la valeur de l'attribut teaching
	 * @param teaching
	 */
	public void setTeaching(Subject teaching) {
		this.teaching = teaching;
	}
	
	/**
	 * Méthode héritée de Person
	 * Permet de generer automatiquement un indentifiant (ID) à partir du prénom (forname) et nom (name)
	 * de la forne : forename.name
	 */
	@Override
	public String setID(String name, String forename) {
		return name.toLowerCase().replaceAll(" ", "")+'.'+forename.toLowerCase().replaceAll(" ", "");
	}

	/**
	 * Méthode héritée de Person
	 * Permet de generer automatiquement une adresse mail à partir du prénom (forname) et nom (name)
	 * de la forme : forename.name@uni-lille.fr
	 */
	@Override
	public String setMail(String name, String forename) {
		return this.getID()+"@univ-lille.fr";
	}
	

	/**
	 * Return la valeur de l'attribut listStudent
	 * @return listStudent
	 */
	public List<Student> getListStudent() {
		return listStudent;
	}

	/**
	 * Permet de modifier la valeur de l'attribut listStudent
	 * @param listStudent
	 */
	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

	/**
	 * Return la valeur de l'attribut listCandidate
	 * @return
	 */
	public List<Student> getListCandidate() {
		return listCandidate;
	}

	/**
	 * Permet de modifier la valeur de l'attribut listCandidate
	 * @param listCandidate
	 */
	public void setListCandidate(List<Student> listCandidate) {
		this.listCandidate = listCandidate;
	}

	/**
	 * Return la valeur de l'attribut minGrade
	 * @return minGrade
	 */
	public double getMinGrade() {
		return minGrade;
	}

	/**
	 * Permet de modifier la valeur de l'attribut minGrade 
	 * @param minGrade
	 */
	public void setMinGrade(double minGrade) {
		this.minGrade = minGrade;
	}
	
	/**
	 * Return la valeur de l'attribut maxAbsence
	 * @return
	 */
	public int getMaxAbsence() {
		return maxAbsence;
	}

	/**
	 * Permet de modifier la valeur de l'attribut maxAbsence
	 * @param maxAbsence
	 */
	public void setMaxAbsence(int maxAbsence) {
		this.maxAbsence = maxAbsence;
	}

	/**
	 * Return la valeur de l'attribut minMotivation
	 * @return minMotivation
	 */
	public Motivation getMinMotivation() {
		return minMotivation;
	}

	/**
	 * Permet de modifier la valeur de l'attribut minMotivation
	 * @param minMotivation
	 */
	public void setMinMotivation(Motivation minMotivation) {
		this.minMotivation = minMotivation;
	}

	/**
	 * Return la valeur de l'attribut affectation
	 * @return affectation
	 */
	public Affectation getAffectation()  {
		return this.affectation;
	}
	
	public void fillListStudent(Student s) {
		this.listStudent.add(s);
	}
	
	/**
	 * Return une liste de Student triee par nom dans l'ordre croissant (A -> Z)
	 * @return listStudent trie par nom dans l'ordre croissant
	 */
	public List<Student> sortByStudentNameASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new PersonNameComparator());
		return l;
	}
	
	/**
	 * Return une liste de Student triee par nom dans l'ordre decroissant (Z -> A)
	 * @return listStudent trie par nom dans l'ordre décroissant
	 */
	public List<Student> sortByStudentNameDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new PersonNameComparator().reversed());
		return l;
	}
	
	/**
	 * Return une liste de Student triee par prenom dans l'ordre croissant (A -> Z)
	 * @return listStudent trie par prenom dans l'ordre croissant
	 */
	public List<Student> sortByStudentForenameASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new PersonForenameComparator());
		return l;
	}
	
	/**
	 * Return une liste de Student triee par prenom dans l'ordre decroissant (Z -> A)
	 * @return listStudent trie par prenom dans l'ordre decroissant
	 */
	public List<Student> sortByStudentForenameDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new PersonForenameComparator().reversed());
		return l;
	}
	
	/**
	 * Return une liste de Student triee par niveau d'étude (annee) dans l'ordre croissant (1 -> 3)
	 * @return listStudent trie par niveau d'etude dans l'ordre croissant
	 */
	public List<Student> sortByStudentScholarYearASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentScholarYearComparator());
		return l;
	}
	
	/**
	 * Return une liste de Student triee par niveau d'etude (annee) dans l'ordre decroissant (3 -> 1)
	 * @return listStudent trie par niveau d'etude dans l'ordre croissant
	 */
	public List<Student> sortByStudentScholarYearDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentScholarYearComparator().reversed());
		return l;
	}
	
	/**
	 * Return une liste de Student triee par moyenne / note dans l'ordre croissant (0.0 -> 20.0)
	 * @return listStudent trie par moyenne / note dans l'ordre croissant
	 */
	public List<Student> sortByStudetnGradesASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentGradesComparator(this.teaching));
		return l;
	}
	
	/**
	 * Return une liste de Student triee par moyenne / note dans l'ordre decroissant (20.0 -> 0.0)
	 * @return listStudent trie par moyenne / note dans l'ordre decroissant
	 */
	public List<Student> sortByStudentGradesDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentGradesComparator(this.teaching).reversed());
		return l;
	}
	
	/**
	 * Return une liste de Student triee par nombre d'absence dans l'ordre croissant (0 -> X)
	 * @return listStudent trie par nombre d'absence l'ordre croissant
	 */
	public List<Student> sortByStudentAbsenceASC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentAbsenceComparator());
		return l;
	} 
	
	
	/**
	 * Return une liste de Student triee par nombre d'absence dans l'ordre croissant (X -> 0)
	 * @return listStudent trie par nombre d'absence l'ordre decroissant
	 */
	public List<Student> sortByStudentAbsenceDESC() {
		List<Student> l = new ArrayList<Student>(listStudent);
		Collections.sort(l, new StudentAbsenceComparator().reversed());
		return l;
	}

	/**
	 * Permet d'afficher un Teacher
	 */
	@Override
	public String toString() {
		return super.toString() + this.teaching.getLabel() + " " + this.getMinGrade() + " " + this.getMaxAbsence(); 
	}
	
	
}
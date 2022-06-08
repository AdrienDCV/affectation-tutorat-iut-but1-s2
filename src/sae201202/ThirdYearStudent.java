package sae201202;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * @authors adrien.dacostaveiga.etu & adrien.degand
 * Un ThirdYearStudent est caract�ris� par les attributs h�rit�s de Student ainsi que d'une Map<Student, Subject> correspondant � la 
 * la liste du/des �tudiant(s) de premi�re ann�e dont il est tuteur. Nous nous servons d'une Map afin de pouvoir coupler un Student � 
 * un Subject dans le cas o� le ThirdYearStudent est aussi inscrit dans le programme de tutorat d'un autre ensiegnement.
 */
public class ThirdYearStudent extends Student {
	// class attributes
	private Map<Student, Subject> isTutorOf;
	
	// constrcutor(s)
	/**
	 * Construit un objet ThirdYearStudent caract�ris� par les �l�ments pr�cis�s en param�tres
	 * @param name
	 * @param forename
	 * @param birthDate
	 * @param ID
	 * @param passWord
	 * @param mail
	 * @param scholarYear
	 * @param group
	 * @param motivation
	 * @param absence
	 * @param grades
	 * @param acceptsSeveralTutored
	 */
	public ThirdYearStudent(String name, String forename, LocalDate birthDate, String ID, String passWord, String mail,
							int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades, boolean acceptsSeveralTutored) {
		super(name, forename, birthDate, ID, passWord, mail, scholarYear, group, motivation, absence, grades, acceptsSeveralTutored);
		this.isTutorOf = new HashMap<Student, Subject>();
	}

	public ThirdYearStudent(String name, String forename, LocalDate birthDate, int scholarYear, char group, Motivation motivation,
			int absence, Map<Subject, Double> grades, boolean acceptsSeveralutored) {
		super(name, forename, birthDate, null, null, null, scholarYear, group, motivation, absence, grades, acceptsSeveralutored);
		this.isTutorOf = new HashMap<Student, Subject>();
	}
	
	// constructeur faux-profil
	public ThirdYearStudent(String name, String forename, int scholarYear, int absence) {
		super(name, forename, LocalDate.of(2000, 1, 1), null, null, "----", scholarYear, '-', Motivation.UNKNOWN, absence, new HashMap<Subject, Double>(), false);
		this.isTutorOf = null;
	}

	// methods
	/**
	 * Return le contenu de isTutorOf
	 * @return
	 */
	public Map<Student, Subject> getIsTutorOf() {
		return isTutorOf;
	}

	/**
	 * Permet de modifier la valeur de isTutorOf
	 * @param isTutorOf
	 */
	public void setIsTutorOf(Map<Student, Subject> isTutorOf) {
		this.isTutorOf = isTutorOf;
	}

	/**
	 * Permet de modifier la valeur de l'attribut acceptsSeveralTutored
	 * @param severalTutored
	 */
	public void setAcceptsSeveralTutored(boolean severalTutored) {
		this.acceptsSeveralTutored = severalTutored;
	}
	
	/**
	 * Return la valeur de l'attribut accpetsSeveralTutored
	 * @return True / False accpetsSeveralTutored
	 */
	public boolean doesAcceptSeveralTutored() {
		return this.acceptsSeveralTutored;
	}
	

}

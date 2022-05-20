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
	public Teacher(String name, String forename, LocalDate birthDate, String passWord, Subject teaching, List<Student> listStudent) {
		super(name, forename, birthDate, passWord);
		this.setMail(name, forename);
		this.setID(name, forename);	
		this.teaching = teaching;
		this.listStudent = listStudent;
	}
	
	public Teacher(String name, String forename, LocalDate birthDate, String passWord, Subject teaching) {
		super(name, forename, birthDate, passWord);
		this.setMail(name, forename);
		this.setID(name, forename);	 
		this.teaching = teaching;
		this.listStudent = new ArrayList<Student>();
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

	public static void main(String[] args) {
		Map<Subject, Double> Cgrades = new HashMap<Subject,Double>();
		Student C = new FirstYearStudent("C", "C", LocalDate.of(2003,10,6), 3, 'A', Motivation.HIGH_MOTIVATION, 20, Cgrades);
		C.getGrades().put(Subject.ALGO, 7.8);
		
		Map<Subject, Double> Mgrades = new HashMap<Subject,Double>();
		Student M = new FirstYearStudent("M", "M", LocalDate.of(2003, 2, 28), 3, 'B', Motivation.NO_MOTIVATION, 3, Mgrades);
		M.getGrades().put(Subject.ALGO, 6.9);
		
		Map<Subject, Double> Xgrades = new HashMap<Subject,Double>();
		Student X = new FirstYearStudent("X", "X", LocalDate.of(2002, 5, 19), 2, 'C', Motivation.HIGH_MOTIVATION, 5, Xgrades);
		X.getGrades().put(Subject.ALGO, 9.7);
		
		Map<Subject, Double> Agrades = new HashMap<Subject,Double>();
		Student A = new FirstYearStudent("A", "A", LocalDate.of(2002, 5, 19), 1, 'C', Motivation.HIGH_MOTIVATION, 1, Agrades);
		A.getGrades().put(Subject.ALGO, 19.7);
		
		Teacher Florian = new Teacher("LAFUTEUR", "Florian", LocalDate.of(1985, 01, 01), "sectionEuroGrenet", Subject.ALGO);	
		Florian.listStudent.add(C);
		Florian.listStudent.add(M);
		Florian.listStudent.add(X);
		Florian.listStudent.add(A);
		for (int i=0; i<Florian.listStudent.size(); i++) {
			System.out.println(Florian.listStudent.get(i).getName());
		}
		System.out.println("\n");
		Florian.listStudent = Florian.sortByStudentAbsenceASC();
		for (int i=0; i<Florian.listStudent.size(); i++) {
			System.out.println(Florian.listStudent.get(i).getName());
		}
		System.out.println("\n");
		Florian.listStudent = Florian.sortByStudentAbsenceDESC();
		for (int i=0; i<Florian.listStudent.size(); i++) {
			System.out.println(Florian.listStudent.get(i).getName());
		}
		
	}
	
}

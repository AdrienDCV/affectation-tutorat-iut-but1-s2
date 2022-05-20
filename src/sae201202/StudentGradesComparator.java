package sae201202;

import java.util.Comparator;
/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class StudentGradesComparator implements Comparator<Student>{
	private Subject subject;
	
	/**
	 * 
	 * @param subject
	 */
	public StudentGradesComparator(Subject subject) {
		this.subject = subject;
	}
	
	/**
	 * 
	 */
	@Override
	public int compare(Student s1, Student s2) {
		return ((Double) s1.getGrade(this.subject)).compareTo((Double) s2.getGrade(this.subject));
	}

}

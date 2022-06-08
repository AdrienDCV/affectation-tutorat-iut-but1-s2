package sae201202;

import java.util.Comparator;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class StudentScholarYearComparator implements Comparator<Student> {
	
	/**
	 * 
	 */
	@Override
	public int compare(Student s1, Student s2) {
		return ((Integer) s1.getScholarYear()).compareTo((Integer) s2.getScholarYear());
	}

}

package sae201202;

import java.util.Comparator;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class StudentAbsenceComparator implements Comparator<Student> {

	/**
	 * 
	 */
	@Override
	public int compare(Student s1, Student s2) {
		return ((Integer)s1.getAbsence()).compareTo(((Integer) s2.getAbsence()));
	}

}

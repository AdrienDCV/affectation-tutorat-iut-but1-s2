package sae201202;

import java.util.Comparator;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class PersonForenameComparator implements Comparator<Person>{

	/**
	 * 
	 */
	@Override
	public int compare(Person p1, Person p2) {
		return p1.getForename().compareTo(p2.getForename());
	}

}

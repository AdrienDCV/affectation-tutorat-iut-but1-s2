package sae201202;

import java.util.Comparator;


/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class PersonNameComparator implements Comparator<Person>{

	/**
	 * 
	 */
	@Override
	public int compare(Person p1, Person p2) {
		return p1.getName().compareTo(p2.getName());
	}
	

}

package sae201202;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AffectationTest {
	
	private Map<Subject, Double> Cgrades;
	private Map<Subject, Double> Dgrades;
	private Student s1, s2;
	private List<Student> studentList;
	private Affectation a1;
	
	@BeforeEach
	 public void initialization() {
		Cgrades = new HashMap<Subject,Double>();
		s1 = new FirstYearStudent("ALLARD", "Claude", LocalDate.of(2003,10,6), 1, 'A', Motivation.HIGH_MOTIVATION, 0, Cgrades);
		s1.getGrades().put(Subject.ALGO, 7.8);
		
		Dgrades = new HashMap<Subject,Double>();
		s2 = new ThirdYearStudent("LEFEBVRE", "Daniel", LocalDate.of(2001, 10, 31), 3, 'M', Motivation.AVERAGE_MOTIVATION, 0, Dgrades, true);
		s2.getGrades().put(Subject.ALGO, 15.9);
		
		studentList = new ArrayList<Student>();
		a1 = new Affectation();
    }
	
	
	@Test
	void test() {
		studentList.add(s1);studentList.add(s2);
		a1.fillStudentsLists(studentList);
		assertEquals(1, Cgrades.size());
		assertEquals(s1, a1.getFirstYear().get(0));
	}

}

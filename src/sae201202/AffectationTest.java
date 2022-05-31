package sae201202;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	private Map<Subject, Double> Mgrades;
	private Student s1, s2, s3;
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
		
		Mgrades = new HashMap<Subject,Double>();
		s3 = new FirstYearStudent("BARRE", "Madeleine", LocalDate.of(2003, 2, 28), 1, 'B', Motivation.NO_MOTIVATION, 3, Mgrades);
		s3.getGrades().put(Subject.ALGO, 6.9);
		
		studentList = new ArrayList<Student>();
		a1 = new Affectation();
    }
	
	@Test
	void getterTest() {
		studentList.add(s1);studentList.add(s2);
		assertTrue(a1.getFirstYear().isEmpty());
		assertTrue(a1.getThirdSecondYear().isEmpty());
		
		assertEquals(new ArrayList<Student>(), a1.getFirstYear());
		assertEquals(new ArrayList<Student>(), a1.getThirdSecondYear());
	}
	
	void listTest() {
		studentList = new ArrayList<Student>();
		a1 = new Affectation();
		studentList.add(s1);studentList.add(s2);
		
		a1.fillStudentsLists(studentList);
		assertEquals(s1, a1.getFirstYear().get(0));
		assertEquals(2, a1.getFirstYear().size());
	}
	
	void thirdYearTest() {
		studentList = new ArrayList<Student>();
		a1 = new Affectation();
		studentList.add(s1);studentList.add(s2);studentList.add(s3);
		a1.fillStudentsLists(studentList);
		
		assertEquals(2, a1.getFirstYear().size());
		assertEquals(1, a1.getThirdSecondYear().size());
		assertEquals(a1.getFirstYear().size(), a1.mostPopulated());
	}
	
	void botTest() {
		studentList = new ArrayList<Student>();
		studentList.add(s1);studentList.add(s2);studentList.add(s3);
		
		a1 = new Affectation();
		a1.fillStudentsLists(studentList);
		a1.addNodes(studentList);
		assertFalse(a1.haveBot());
		
		a1 = new Affectation();
		a1.prepaList(studentList);
		a1.addNodes(studentList);
		assertTrue(a1.haveBot());
	}

}

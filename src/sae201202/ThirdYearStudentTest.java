package sae201202;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThirdYearStudentTest {
	ThirdYearStudent s1, s2, s3;
	Map<Student, Subject> isTutorOf;
	Map<Student, Subject> isTutorOf2;
	
	@BeforeEach
	 public void initialization() {
		s1 = new ThirdYearStudent("DEGAND", "Adrien", LocalDate.of(2003, 5, 27), 3, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>(),false);
		s2 = new ThirdYearStudent("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), "adrien.dacostaveiga.etu","passwd","adrien.dacostaveiga.etu@univ-lille.fr", 3, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>());
		s3 = new ThirdYearStudent("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), "adrien.dacostaveiga.etu","passwd","adrien.dacostaveiga.etu@univ-lille.fr", 3, 'F', Motivation.HIGH_MOTIVATION, 0, null, new HashMap<Subject, Double>(), true);
		isTutorOf = new HashMap<Student,Subject>();
		isTutorOf2 = new HashMap<Student,Subject>();
	}
	@Test
	void getterTest() {
		isTutorOf.put(s2, Subject.ALGO);
		isTutorOf2.put(s3, Subject.ALGO);
		
		s1.setIsTutorOf(isTutorOf); s2.setIsTutorOf(isTutorOf2);
		
		assertEquals(Subject.ALGO, s1.getIsTutorOf().get(s2));  
		assertEquals(Subject.ALGO, s2.getIsTutorOf().get(s3));
		
		assertFalse(s1.doesAcceptSeveralTutored());
		assertTrue(s3.doesAcceptSeveralTutored());
	}
	
	@Test
	void toStringTest() {
		assertEquals("DEGAND Adrien (19) : ID : adrien.degand.etu, mail : adrien.degand.etu@univ-lille.fr, est en 3 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", s1.toString());
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 3 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", s2.toString());
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 3 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", s3.toString());
		}
}

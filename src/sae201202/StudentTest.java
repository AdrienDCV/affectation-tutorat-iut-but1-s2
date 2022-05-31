package sae201202;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
	private Student s1, s2, s3;

	@BeforeEach
	public void initialization() {
		s1 = new Student("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), "1234","passwd","adrien.dacostaveiga.etu@univ-lille.fr", 1, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>());
		s2 = new Student("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 27), 1, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>());
		s3 = new Student("DEGAND", "Adrien", LocalDate.of(2003, 5, 27), "1234","passwd","adrien.degand.etu@univ-lille.fr", 3, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>(), true);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 1 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", s1.toString());
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 1 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", s2.toString());
		assertEquals("DEGAND Adrien (19) : ID : adrien.degand.etu, mail : adrien.degand.etu@univ-lille.fr, est en 3 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", s3.toString());
	}
	
	@Test
	public void getterTest() {
		assertEquals('F', s1.getGroup());
		assertEquals(19, s2.getAge());
		assertEquals(Motivation.HIGH_MOTIVATION, s3.getMotivation());
		assertEquals("adrien.degand.etu@univ-lille.fr", s3.getMail());
	}
	
	@Test
	public void subjectGradesTest() {
		s1.getGrades().put(Subject.ALGO, 10.0);
		ArrayList<Subject> subjectList = new ArrayList<Subject>();
		subjectList = s1.getSubject();
		
		assertEquals(Subject.ALGO, subjectList.get(0));
		assertEquals(10.0, s1.getGrade(Subject.ALGO));
		
		s1.getGrades().put(Subject.BAS_NIVEAUX, 18.0);
		assertEquals(Subject.BAS_NIVEAUX, s1.highestGrade());
		assertEquals(Subject.ALGO, s1.lowestGrade());
		 
		assertEquals(8, s1.bonusMalusFirstYear(Subject.ALGO));
		
		s3.getGrades().put(Subject.ALGO, 17.5);
		assertEquals(10, s3.bonusMalusThirdYear(Subject.ALGO));
		
		assertEquals(2, s1.calculPoid(s3, Subject.ALGO));
	}
}

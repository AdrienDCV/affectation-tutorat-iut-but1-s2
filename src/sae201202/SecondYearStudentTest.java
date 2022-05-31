package sae201202;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecondYearStudentTest {
	SecondYearStudent s1, s2;
	
	@BeforeEach
	 public void initialization() {
		s1 = new SecondYearStudent("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), 2, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>());
		s2 = new SecondYearStudent("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), "1234","passwd","dacostaveiga.etu@univ-lille.fr", 2, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>());


	}
	@Test
	void getterTest() {
		s1.setIsTutorOf(s2); s2.setIsTutorOf(s1);
		assertEquals(s2, s1.getIsTutorOf());
		assertEquals(s1, s2.getIsTutorOf());
		
		s1.setSubject(Subject.ALGO);
		assertEquals(Subject.ALGO, s1.getSubjectTutored());
	}
	
	@Test
	void toStringTest() {
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 2 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", s1.toString());
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 2 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", s2.toString());

	}

}

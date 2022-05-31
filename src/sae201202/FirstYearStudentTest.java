package sae201202;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstYearStudentTest {
	FirstYearStudent f1, f2, f3, f4, f5;
	
	@BeforeEach
	 public void initialization() {
		f1 = new FirstYearStudent("DEGAND", "Adrien", LocalDate.of(2003, 5, 27), 1, 'F', 1);
		f2 = new FirstYearStudent("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), 1, 'F', 0, new HashMap<Subject, Double>());
		f3 = new FirstYearStudent("DEGAND", "Adrien", LocalDate.of(2003, 5, 27), 1, 'F', Motivation.AVERAGE_MOTIVATION, 1);
		f4 = new FirstYearStudent("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), 1, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>());
		f5 = new FirstYearStudent("DA COSTA VEIGA", "Adrien", LocalDate.of(2003, 5, 25), "1234","passwd","dacostaveiga.etu@univ-lille.fr", 1, 'F', Motivation.HIGH_MOTIVATION, 0, new HashMap<Subject, Double>());


	}
	@Test
	void getterTest() {
		f1.setIsTutoredBy(f2); f2.setIsTutoredBy(f3);
		assertEquals(f2, f1.getIsTutoredBy());
		assertEquals(f3, f2.getIsTutoredBy());
		
		f1.setSubjectTutored(Subject.ALGO);
		assertEquals(Subject.ALGO, f1.getSubjectTutored());
	}
	
	@Test
	void toStringTest() {
		assertEquals("DEGAND Adrien (19) : ID : adrien.degand.etu, mail : adrien.degand.etu@univ-lille.fr, est en 1 année, moyennes : {}, motivation : UNKNOWN, nombre d'absences : 1", f1.toString());
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 1 année, moyennes : {}, motivation : UNKNOWN, nombre d'absences : 0", f2.toString());
		assertEquals("DEGAND Adrien (19) : ID : adrien.degand.etu, mail : adrien.degand.etu@univ-lille.fr, est en 1 année, moyennes : {}, motivation : AVERAGE_MOTIVATION, nombre d'absences : 1", f3.toString());
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 1 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", f4.toString());
		assertEquals("DA COSTA VEIGA Adrien (19) : ID : adrien.dacostaveiga.etu, mail : adrien.dacostaveiga.etu@univ-lille.fr, est en 1 année, moyennes : {}, motivation : HIGH_MOTIVATION, nombre d'absences : 0", f5.toString());
	}

}

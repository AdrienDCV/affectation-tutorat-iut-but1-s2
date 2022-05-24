package sae201202;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ulille.but.sae2_02.graphes.Arete;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class UseAffectation {
	
	public static void display(List<Arete<Student>> liste) {
		   String string = ""; 
		   for(int i=0; i<liste.size(); i++) {
			   System.out.println(liste.get(i).getExtremite1().getName() + " " + liste.get(i).getExtremite1().getForename() + " est affecté(e) à : " + liste.get(i).getExtremite2().getName() + " " + liste.get(i).getExtremite2().getForename());
		   }
	}
	
	public static void main(String[] args) {
		// creation of examples of 1st year Students 
		Map<Subject, Double> Cgrades = new HashMap<Subject,Double>();			     
		Student Claude = new FirstYearStudent("ALLARD", "Claude", LocalDate.of(2003,10,6), 1, 'A', Motivation.HIGH_MOTIVATION, 0, Cgrades);
		Claude.getGrades().put(Subject.ALGO, 7.8);
		
		Map<Subject, Double> Mgrades = new HashMap<Subject,Double>();
		Student Madeleine = new FirstYearStudent("BARRE", "Madeleine", LocalDate.of(2003, 2, 28), 1, 'B', Motivation.NO_MOTIVATION, 3, Mgrades);
		Madeleine.getGrades().put(Subject.ALGO, 6.9);
		
		Map<Subject, Double> Sgrades = new HashMap<Subject,Double>();
		Student Sabine = new FirstYearStudent("BESNARD", "Sabine", LocalDate.of(2002, 5, 19), 1, 'C', Motivation.HIGH_MOTIVATION, 5, Sgrades);
		Sabine.getGrades().put(Subject.ALGO, 9.7);
		
		Map<Subject, Double> Hgrades = new HashMap<Subject,Double>();
		Student Honore = new FirstYearStudent("MARTEL", "Honoré", LocalDate.of(2001, 11, 11), 1, 'D', Motivation.LOW_MOTIVATION, 1, Hgrades);
		Honore.getGrades().put(Subject.ALGO, 11.7);
		
		Map<Subject, Double> Agrades = new HashMap<Subject,Double>();
		Student Aurore = new FirstYearStudent("SCHMITT", "Aurore", LocalDate.of(2002, 1, 22), 1, 'E', Motivation.AVERAGE_MOTIVATION, 1, Agrades);
		Aurore.getGrades().put(Subject.ALGO, 9.9);
		
		// creation of examples of 2nd  / 3rd year Students 
		Map<Subject, Double> Pgrades = new HashMap<Subject,Double>();
		Student Paul = new ThirdYearStudent("SANCHEZ", "Paul", LocalDate.of(2000, 6, 03), 3, 'L', Motivation.AVERAGE_MOTIVATION, 1, Pgrades, false);
		Paul.getGrades().put(Subject.ALGO, 12.0);

		Map<Subject, Double> Dgrades = new HashMap<Subject,Double>();
		Student Daniel = new ThirdYearStudent("LEFEBVRE", "Daniel", LocalDate.of(2001, 10, 31), 3, 'M', Motivation.AVERAGE_MOTIVATION, 0, Dgrades, true);
		Daniel.getGrades().put(Subject.ALGO, 15.9);

		Map<Subject, Double> SOgrades = new HashMap<Subject,Double>();
		Student Sophie = new SecondYearStudent("VALLEE", "Sophie", LocalDate.of(1999, 3, 24), 2, 'G', Motivation.NO_MOTIVATION, 2, SOgrades);
		Sophie.getGrades().put(Subject.ALGO, 13.8);
		
		Map<Subject, Double> Lgrades = new HashMap<Subject,Double>();
        Student Laure = new SecondYearStudent("MARTIN", "Laure", LocalDate.of(2002, 02, 02), 2, 'G', Motivation.AVERAGE_MOTIVATION, 0, Lgrades);
        Laure.getGrades().put(Subject.ALGO, 17.3); 

		
		//
		List<Student> studentList = new ArrayList<Student>();
		List<Student> botAffectation = new ArrayList<Student>();
		List<Student> severalAffectation = new ArrayList<Student>();
		studentList.add(Claude);
		studentList.add(Madeleine);
		studentList.add(Sabine);
		studentList.add(Honore);
		studentList.add(Aurore);
		studentList.add(Paul);
		studentList.add(Daniel);
		studentList.add(Sophie);
		studentList.add(Laure);
		
		Affectation A = new Affectation();
		//affectation plusieurs tutorant pour un 3e année
		Affectation B = new Affectation();
		//affectation forcé
		Affectation Forced = new Affectation();
		
		
		A.prepaList(studentList);
		
		Forced.affectationForce(Claude, Paul, A, studentList);

		A.addNodes(studentList);
		A.addEdges();
		
		CalculAffectation<Student> calculNormal = new CalculAffectation<Student>(A.graphe, A.getFirstYear(), A.getThirdSecondYear());
		CalculAffectation<Student> calculForced = new CalculAffectation<Student>(Forced.graphe, Forced.getFirstYear(), Forced.getThirdSecondYear());
		
		A.setCalcul(calculNormal);
		
		
		System.out.println(calculNormal.getAffectation());
		calculForced.getAffectation();
		
		
		B = A;
		B.setCalcul(calculNormal);
		
		List<Arete<Student>> listeArete = A.severalAffectation();
		
		//A.getListArete(A.eviterAffectation(Honore, Sophie)
		//A.getListArete(calculNormal)
		listeArete.addAll(A.getListArete(A.getListArete(A.eviterAffectation(Sabine, Laure))));
		listeArete.addAll(Forced.getListArete(calculForced));
		
		
		List<FirstYearStudent> list = Affectation.isTutoredBy(listeArete);
		display(listeArete);
	}
}

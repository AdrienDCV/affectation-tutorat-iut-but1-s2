package sae201202;

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
	public static void main(String[] args) {
		// creation of examples of 1st year Students 
		Map<Subject, Double> Cgrades = new HashMap<Subject,Double>();
						     
		Student Claude = new FirstYearStudent("Allard", "Claude", 18, "allard.claude.etu@univ-lille.fr", 1, 'A', "12184258", Motivation.HIGH_MOTIVATION, 0, Cgrades);
		Claude.getGrades().put(Subject.ALGO, 7.8);
		
		Map<Subject, Double> Mgrades = new HashMap<Subject,Double>();
		Student Madeleine = new FirstYearStudent("Barre", "Madeleine", 18, "madeleine.barre.etu@univ-lill.fr", 1, 'B', "69189681", Motivation.NO_MOTIVATION, 3, Mgrades);
		Madeleine.getGrades().put(Subject.ALGO, 6.9);
		
		Map<Subject, Double> Sgrades = new HashMap<Subject,Double>();
		Student Sabine = new FirstYearStudent("Besnard", "Sabine", 22, "sabine.besnard.etu@univ-lille.fr", 1, 'C', "27252003", Motivation.HIGH_MOTIVATION, 5, Sgrades);
		Sabine.getGrades().put(Subject.ALGO, 12.7);
		
		Map<Subject, Double> Hgrades = new HashMap<Subject,Double>();
		Student Honore = new FirstYearStudent("Martel", "Honoré", 19, "honoré.martel.etu@univ-lille.fr", 1, 'D', "01121405", Motivation.LOW_MOTIVATION, 1, Hgrades);
		Honore.getGrades().put(Subject.ALGO, 11.7);
		
		Map<Subject, Double> Agrades = new HashMap<Subject,Double>();
		Student Aurore = new FirstYearStudent("Schmitt", "Aurore", 21, "aurore.schmitt.etu@univ-lille.fr", 1, 'E', "99989796", Motivation.AVERAGE_MOTIVATION, 1, Agrades);
		Aurore.getGrades().put(Subject.ALGO, 9.9);
		
		// creation of examples of 2nd  / 3rd year Students 
		Map<Subject, Double> Pgrades = new HashMap<Subject,Double>();
		Student Paul = new ThirdYearStudent("Sanchez", "Paul", 20, "paule.sanchez.etu@univ-lille.fr", 3, 'L', "12101210", Motivation.HIGH_MOTIVATION, 1, false, Pgrades);
		Paul.getGrades().put(Subject.ALGO, 12.0);

		Map<Subject, Double> Dgrades = new HashMap<Subject,Double>();
		Student Daniel = new ThirdYearStudent("Lefebvre", "Daniel", 23, "daniel.lefebvre.etu@univ-lille.fr", 3, 'M', "28042022", Motivation.AVERAGE_MOTIVATION, 0, true, Dgrades);
		Daniel.getGrades().put(Subject.ALGO, 15.9);

		Map<Subject, Double> SOgrades = new HashMap<Subject,Double>();
		Student Sophie = new SecondYearStudent("Vallee", "Sophie", 19, "---", 2, 'G', "02091945", Motivation.HIGH_MOTIVATION, 0, SOgrades);
		Sophie.getGrades().put(Subject.ALGO, 15.8);
		
		
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
		
		Affectation A = new Affectation();
		//affectation plusieurs tutorant pour un 3e année
		Affectation B = new Affectation();
		//affectation forcé
		Affectation Forced = new Affectation();
		
		
		A.doAffectation(studentList);
		
		Forced.affectationForce(Claude, Paul, A, studentList);

		A.addNodes(studentList);
		A.addEdges();
		
		CalculAffectation<Student> calcul = new CalculAffectation<Student>(A.graphe, A.getFirstYear(), A.getThirdSecondYear());
		CalculAffectation<Student> calcul2 = new CalculAffectation<Student>(Forced.graphe, Forced.getFirstYear(), Forced.getThirdSecondYear());
		
		System.out.println(calcul.getCout());
		System.out.println(calcul.getAffectation());
		System.out.println(calcul2.getCout());
		System.out.println(calcul2.getAffectation());
		
		
		B = A;
		B.setCalcul(calcul);
		
		List<Arete<Student>> listeArete = new ArrayList<Arete<Student>>();
		do {
			botAffectation.clear();
			severalAffectation.clear();
			Affectation C = new Affectation();
			
			botAffectation = B.getBotAffectation(B.getCalcul());
			severalAffectation = A.getSeveralTutored(botAffectation);
			studentList.clear();
			studentList.addAll(botAffectation);
			studentList.addAll(severalAffectation);
			
			C.doAffectation(studentList);
			
			C.addNodes(studentList);
			C.addEdges();
			
			CalculAffectation<Student> calcul3 = new CalculAffectation<Student>(C.graphe, C.getFirstYear(), C.getThirdSecondYear());
			System.out.println(calcul3.getCout());
			System.out.println(calcul3.getAffectation());
			listeArete.addAll(C.getListArete(calcul3));
			B = C;
			B.setCalcul(calcul3);
		} while(B.haveBot());
		
		listeArete.addAll(A.getListArete(calcul));
		listeArete.addAll(Forced.getListArete(calcul2));
		System.out.println(listeArete);

	}
}

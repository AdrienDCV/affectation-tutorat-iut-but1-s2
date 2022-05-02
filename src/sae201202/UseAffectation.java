package sae201202;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ulille.but.sae2_02.graphes.CalculAffectation;

public class UseAffectation {
	public static void main(String[] args) {
		// creation of examples of 1st year Students 
		Map<String, Double> Cgrades = new HashMap<String,Double>();
		Student Claude = new FirstYearStudent("Allard", "Claude", 18, "---", 1, 'A', "12184258", Motivation.HIGH_MOTIVATION, 0, Cgrades);
		Claude.getGrades().put("Algo", 7.8);
		
		Map<String, Double> Mgrades = new HashMap<String,Double>();
		Student Madeleine = new FirstYearStudent("Barre", "Madeleine", 18, "---", 1, 'B', "69189681", Motivation.NO_MOTIVATION, 3, Mgrades);
		Madeleine.getGrades().put("Algo", 6.9);
		
		Map<String, Double> Sgrades = new HashMap<String,Double>();
		Student Sabine = new FirstYearStudent("Besnard", "Sabine", 22, "---", 1, 'C', "27252003", Motivation.HIGH_MOTIVATION, 5, Sgrades);
		Sabine.getGrades().put("Algo", 12.7);
		
		Map<String, Double> Hgrades = new HashMap<String,Double>();
		Student Honore = new FirstYearStudent("Martel", "Honoré", 19, "---", 1, 'D', "01121405", Motivation.LOW_MOTIVATION, 1, Hgrades);
		Honore.getGrades().put("Algo", 11.7);
		
		Map<String, Double> Agrades = new HashMap<String,Double>();
		Student Aurore = new FirstYearStudent("Schmitt", "Aurore", 21, "---", 1, 'E', "99989796", Motivation.AVERAGE_MOTIVATION, 1, Agrades);
		Aurore.getGrades().put("Algo", 9.9);
		
		// creation of examples of 2nd  / 3rd year Students 
		Map<String, Double> Pgrades = new HashMap<String,Double>();
		Student Paul = new ThirdYearStudent("Sanchez", "Paul", 20, "---", 3, 'L', "12101210", Motivation.HIGH_MOTIVATION, 1, Pgrades);
		Paul.getGrades().put("Algo", 12.0);

		Map<String, Double> Dgrades = new HashMap<String,Double>();
		Student Daniel = new ThirdYearStudent("Lefebvre", "Daniel", 23, "---", 3, 'M', "28042022", Motivation.AVERAGE_MOTIVATION, 0, Pgrades);
		Daniel.getGrades().put("Algo", 15.9);

		Map<String, Double> SOgrades = new HashMap<String,Double>();
		Student Sophie = new SecondYearStudent("Vallee", "Sophie", 19, "---", 2, 'G', "02091945", Motivation.HIGH_MOTIVATION, 0, SOgrades);
		Sophie.getGrades().put("Algo", 15.8);
		
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(Claude);
		studentList.add(Madeleine);
		studentList.add(Sabine);
		studentList.add(Honore);
		studentList.add(Aurore);
		studentList.add(Paul);
		studentList.add(Daniel);
		studentList.add(Sophie);		
		
		Affectation A = new Affectation();
		
		A.fillStudentsLists(studentList);
		A.fillMissingStudents();
		A.unionStudentLists(studentList);

		
		A.addNodes(studentList);
		A.addEdges();
		
		CalculAffectation<Student> calcul = new CalculAffectation<Student>(A.graphe, A.getFirstYear(), A.getThirdSecondYear());

		System.out.println(calcul.getCout());
		System.out.println(calcul.getAffectation());
	}
}

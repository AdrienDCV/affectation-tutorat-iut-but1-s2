package sae201202;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ulille.but.sae2_02.graphes.Arete;

/**
 * @authors adrien.dacostaveiga & adrien.degand
 * Classe Main permettant d'exécuter le programme
 */
public class UseAffectation {
	
	public static void display(List<Arete<Student>> liste) {
		   for(int i=0; i<liste.size(); i++) {
			   System.out.println(liste.get(i).getExtremite1().getName() + " " + liste.get(i).getExtremite1().getForename() + " est affecté(e) à : " + liste.get(i).getExtremite2().getName() + " " + liste.get(i).getExtremite2().getForename());
		   }
	}
	
	/**
	 * Scénario 1 : nombre de 1ère année > 2ème+3ème année
	 */
	public static void scenario1() {
		// nombre 1A > nombre 3A + 2A
		List<Student> studentList = new ArrayList<Student>();
		SaveData.loadData(studentList, "scenario1.json");
		Affectation A = new Affectation();
		
		A.prepaList(studentList);
		A.forcedAffectation(studentList.get(0), studentList.get(5), studentList);
		A.affectation(studentList);
		
		List<Arete<Student>> listeArete = A.severalAffectation();
		listeArete.addAll(A.getListArete(A.getListArete(A.avoidAffectation(studentList.get(2), studentList.get(7)))));
		if(!A.getForcedFirstYear().isEmpty() && !A.getThirdSecondYear().isEmpty()) {
			listeArete.addAll(A.getListForcedArete(A.getForcedCalcul()));
		}
		List<FirstYearStudent> list = Affectation.isTutoredBy(listeArete);
		System.out.println(list);
		display(listeArete);
	}
	
	/**
	 * Scénario 2 : nombre de 1ère année = 2ème+3ème année
	 */
	public static void scenario2() {
		//nombre de 1A == 3A + 2A
		List<Student> studentList = new ArrayList<Student>();
		SaveData.loadData(studentList, "scenario2.json");
		Affectation A = new Affectation();

		A.prepaList(studentList);

		
		A.affectation(studentList);
		
		List<Arete<Student>> listeArete = new ArrayList<Arete<Student>>();
		
		listeArete.addAll(A.getListArete(A.getCalcul()));
		
		List<FirstYearStudent> list = Affectation.isTutoredBy(listeArete);
		System.out.println(list);
		display(listeArete);
	}
	
	/**
	 * Scénario 3 : nombre de 1ère année < 2ème+3ème année
	 */
	public static void scenario3() {
		//nombre de 1A < 3A + 2A
		List<Student> studentList = new ArrayList<Student>();
		SaveData.loadData(studentList, "scenario3.json");
		Affectation A = new Affectation();

		A.prepaList(studentList);

		
		A.affectation(studentList);
		
		List<Arete<Student>> listeArete = new ArrayList<Arete<Student>>();
		
		listeArete.addAll(A.getListArete(A.getCalcul()));
		
		List<FirstYearStudent> list = Affectation.isTutoredBy(listeArete);
		System.out.println(list);
		display(listeArete);
	}
	
	public static void main(String[] args) {
		System.out.println("Scénario 1 (nombre 1ère année > 3ème+2ème année): ");
		scenario1();
		System.out.println("\nScénario 2 (nombre 1ère année = 3�me+2ème année): ");
		scenario2();
		System.out.println("\nScénario 3 (nombre 1ère année < 3ème+2ème année): ");
		scenario3();
	}
}

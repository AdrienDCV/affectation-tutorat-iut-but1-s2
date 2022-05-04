package sae201202;

import fr.ulille.but.sae2_02.*;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

import java.util.*;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class Affectation {
	// class attributes
	private CalculAffectation c;
	private List<Student> firstYear;
	private List<Student> thirdSecondYear;
	GrapheNonOrienteValue<Student> graphe;
	private List<Student> forcedAssignment;
	
	
	// constructor(s)
	/**
	 * 
	 */
	public Affectation (){
		firstYear = new ArrayList<Student>();
		thirdSecondYear = new ArrayList<Student>();
		graphe = new GrapheNonOrienteValue<Student>();
		forcedAssignment = new ArrayList<Student>();
		c = new CalculAffectation<Student>(graphe, firstYear, firstYear);
	}
	
	// methods
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> getFirstYear() {
		return firstYear;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public List<Student> getThirdSecondYear() {
		return thirdSecondYear;
	}
	
	/**
	 * 
	 * TODO
	 * @param studentList
	 */
	public void fillStudentsLists(List<Student> studentList) {
		for (int i=0; i<studentList.size(); i++) {
			if (studentList.get(i).isFirstYear()) {
				firstYear.add((FirstYearStudent) studentList.get(i));
			} else if (studentList.get(i).isThirdYear()) {
				thirdSecondYear.add((ThirdYearStudent) studentList.get(i));
			} else if (studentList.get(i).isSecondYear()) {
				thirdSecondYear.add((SecondYearStudent) studentList.get(i));
			}
		}
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public int mostPopulated() {
		return Math.max(firstYear.size(), thirdSecondYear.size());
	}
	
	/**
	 * 
	 * TODO
	 */
	public void fillMissingStudents() {
		if(firstYear.size() != mostPopulated()) {
			for(int i=firstYear.size(); i<mostPopulated(); i++) {
				firstYear.add(new FirstYearStudent("X", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000));
			}
		} 
		if (thirdSecondYear.size() != mostPopulated()) {
			for(int i=thirdSecondYear.size(); i<mostPopulated(); i++) {
				thirdSecondYear.add(new ThirdYearStudent("XXX", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000));
			}
		}
	}
	
	/**
	 * 
	 * TODO
	 * @param studentList
	 */
	public void unionStudentLists(List<Student> studentList) {  
        studentList.addAll(firstYear);
        studentList.addAll(thirdSecondYear);
    }

	/**
	 * 
	 * TODO
	 * @param studentList
	 */
	public void addNodes(List<Student> studentList) {
		for (int i=0; i<studentList.size(); i++) {
			graphe.ajouterSommet(studentList.get(i));
		}
	}
    
	
	/**
	 * 
	 * TODO
	 */
    public void addEdges() {
        for(int i = 0; i < firstYear.size(); i ++) {
            for(int j = 0; j < thirdSecondYear.size(); j ++) {
            	/*if (this.forcedAssignment.containsKey(firstYear.get(i))) {
            		if(this.forcedAssignment.get(firstYear.get(i)).equals(thirdSecondYear.get(j))) {
            			j = j + 1;
            		}
            	}*/
            	for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
                    graphe.ajouterArete(firstYear.get(i), thirdSecondYear.get(j), firstYear.get(i).calculPoid(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k)));
                    System.out.println(firstYear.get(i).getName() + " -> " + thirdSecondYear.get(j).getName());
                    System.out.println(firstYear.get(i).calculPoid(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k)));
            	}
            }
        }
 
    }
    
    /**
     * 
     * TODO
     * @param s1
     * @param s2
     * @return
     */
    private boolean isEdge(Student s1, Student s2) {
    	return graphe.contientArete(s1, s2);
    }
    
    /**
     * 
     * TODO
     * @param s1
     * @param s2
     * @param A
     * @param studentList
     * @return
     */
    public boolean affectationForce(Student s1, Student s2, Affectation A, List <Student> studentList) {
    	//Force une affectation, true si réussie false sinon
    	if (!this.isEdge(s1, s2)) {
    		A.firstYear.remove(s1);
        	A.thirdSecondYear.remove(s2);
        	forcedAssignment.add(s1);
        	forcedAssignment.add(s2);
        	
        	studentList.removeAll(forcedAssignment);
        	this.fillStudentsLists(forcedAssignment);
    		this.addNodes(forcedAssignment);
    		graphe.ajouterArete(forcedAssignment.get(0),forcedAssignment.get(1), Integer.MAX_VALUE);
    		System.out.println(forcedAssignment.get(0).getName() + " -> " + forcedAssignment.get(1).getName());
    		System.out.println(graphe.getPoids(forcedAssignment.get(0), forcedAssignment.get(1)));
    		
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * 
     * TODO
     * @param l
     * @return
     */
    private int minIdxList(List<Integer> l) {
    	//retourne l'indice du plus petit nombre de la liste
    	int result = l.get(0);
    	int idx = 0;
    	for(int i = 0; i < l.size(); i ++) {
    		result = Math.min(result, l.get(i));
    		if (l.get(i) == result) {
    			idx = i;
    		}
    	}
    	return idx;
    }

    /**
     * 
     * TODO
     */
    public void triFirstYear() {
    	//liste trié
    	List<Student> tri = new ArrayList<Student>();
    	//liste des plus petits poid de chaque firstyear
    	List<Integer> minPoid = new ArrayList<Integer>();
    	//ajout de tout les poid d'un firstyear avec tous les third et second year
    	for(int i = 0; i < firstYear.size(); i ++) {
    		List<Integer> poid = new ArrayList<Integer>();
    		for(int j = 0; j < thirdSecondYear.size(); j ++) {
    			for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
    			   Integer n = firstYear.get(i).calculPoid(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k));
                   poid.add(n);
            	}
    		}
    		//cherche le plus petit poid du firstyear vers les tuteurs et l'ajoute à la liste
    		List<Integer> sortedList = new ArrayList<>(poid);
            Collections.sort(sortedList);
            minPoid.add(sortedList.get(0));
    	}
    	//on cherche l'indice du int le plus petit et on le supprime de firstyear pour l'ajouter dans la liste trié
    	int idx = 0;
    	while(firstYear.size() != 0) {
    		idx = this.minIdxList(minPoid);
    		tri.add(firstYear.remove(idx));
    		minPoid.remove(idx);
    	}
    	
    	//on remplace firstyear par la liste trié
    	firstYear = tri;
    }
}
	
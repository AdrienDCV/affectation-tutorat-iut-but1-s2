package sae201202;

import fr.ulille.but.sae2_02.*;
import fr.ulille.but.sae2_02.graphes.Arete;
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
	private CalculAffectation<Student> c;
	GrapheNonOrienteValue<Student> graphe;
	private List<Student> firstYear;
	private List<Student> thirdSecondYear;
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
	 * Retourne la liste des premières années
	 * TODO
	 * @return la valeur de la liste firstYear
	 */
	public List<Student> getFirstYear() {
		return firstYear;
	}
	
	/**
	 * Retourne la liste des troisièmes années
	 * TODO
	 * @return la valeur de la liste thirdYear
	 */
	public List<Student> getThirdSecondYear() {
		return thirdSecondYear;
	}
	
	/**
     * Change l'attribut Calcul
     * @param c
     */
    public void setCalcul(CalculAffectation<Student> c) {
    	this.c = c;
    }
	
    /**
     * Retourne l'attribut Calcul
     * @return le calcul d'une affectation
     */
    public CalculAffectation<Student> getCalcul() {
    	return this.c;
    }
	/**
	 * Ajout des étudiants contenu dans la student liste dans les listes de la classes respective
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
	 * Retourne la taille de la plus grande liste entre les premières années et les deuxièmes/troisièmes années
	 * TODO
	 * @return la liste la plus longue
	 */
	public int mostPopulated() {
		return Math.max(firstYear.size(), thirdSecondYear.size());
	}
	
	/**
	 * Ajoute des étudiants fictif dans la liste la plus petite
	 * TODO
	 */
	public void fillMissingStudents() {
		//ajout des bots dans la liste des 1A
		if(firstYear.size() != mostPopulated()) {
			for(int i=firstYear.size(); i<mostPopulated(); i++) {
				firstYear.add(new FirstYearStudent("X", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000));
			}
		}
		//ajout des bots dans la liste des 3A
		if (thirdSecondYear.size() != mostPopulated()) {
			for(int i=thirdSecondYear.size(); i<mostPopulated(); i++) {
				thirdSecondYear.add(new ThirdYearStudent("XXX", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000));
			}
		}
	}
	
	/**
	 * Ajoute les les premières années et les deuxièmes/troisièmes années dans une liste
	 * TODO
	 * @param studentList
	 */
	public void unionStudentLists(List<Student> studentList) {  
		//ajoute les 1A et les 2A/3A dans la liste en paramètre
        studentList.addAll(firstYear);
        studentList.addAll(thirdSecondYear);
    }

	/**
	 * Ajoute les sommets des étudiants de la liste
	 * TODO
	 * @param studentList
	 */
	public void addNodes(List<Student> studentList) {
		//création des sommets
		for (int i=0; i<studentList.size(); i++) {
			graphe.ajouterSommet(studentList.get(i));
		}
	}
    
	
	/**
	 * Ajoute les aretes dans le graphe
	 * TODO
	 */
    public void addEdges() {
    	//création des aretes
        for(int i = 0; i < firstYear.size(); i ++) {
            for(int j = 0; j < thirdSecondYear.size(); j ++) {
            	for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
                    graphe.ajouterArete(firstYear.get(i), thirdSecondYear.get(j), firstYear.get(i).calculPoid(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k)));
            	}
            }
        }
 
    }
    
    /**
     * Vérifie si l'étudiant 1 et l'étudiant 2 sont une arete
     * TODO
     * @param s1
     * @param s2
     * @return true si le graphe contient une arête liant s1 et s2 / false si le graphe ne contient pas d'arête liant s1 et s2 
     */
    private boolean isEdge(Student s1, Student s2) {
    	return graphe.contientArete(s1, s2);
    }
    
    /**
     * Force l'affectation de l'étudiant 1 et l'étudiant 2
     * TODO
     * @param s1
     * @param s2
     * @param A
     * @param studentList
     * @return true si l'affectation forcée a réussit / false si non
     */
    public boolean affectationForce(Student s1, Student s2, Affectation A, List <Student> studentList) {
    	//Force une affectation, true si réussie false sinon
    	if (!this.isEdge(s1, s2)) {
    		//on enlève le 1A / 3A des listes pour l'affecter dans la liste des affectations forcé
    		A.firstYear.remove(s1);
        	A.thirdSecondYear.remove(s2);
        	forcedAssignment.add(s1);
        	forcedAssignment.add(s2);
        	
        	//on les enlève de la liste des étudiants à affecter normalement
        	studentList.removeAll(forcedAssignment);
        	
        	//création de l'arete forcé
        	this.fillStudentsLists(forcedAssignment);
    		this.addNodes(forcedAssignment);
    		graphe.ajouterArete(forcedAssignment.get(0),forcedAssignment.get(1), Integer.MAX_VALUE);		
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * Retourne l'indice du plus petit nombre de la liste
     * TODO
     * @param l
     * @return 
     */
    private int minIdxList(List<Integer> l) {
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
     * Tri la liste des premières années
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
    		//cherche le plus petit poid du firstyear vers les tuteurs et l'ajoute Ã  la liste
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
    
    /**
     * retourne la liste des étudiants qui ont une affectation avec un étudiant fictif
     * @param c
     * @return la liste des FirstYeartStudent / ThirdYearStudent / SecondeYearStudent qui sont affectés à un faux profil d'étudiant 
     */
    public List<Student> getBotAffectation(CalculAffectation<Student> c) {
    	List<Student> result = new ArrayList<Student>();
    	for (int i = 0 ; i < c.getAffectation().size(); i = i+1) {
    		if(c.getAffectation().get(i).getExtremite1().isFirstYear() && c.getAffectation().get(i).getExtremite2().getName().equals("XXX")) {
    			result.add(c.getAffectation().get(i).getExtremite1());
    		} else if (c.getAffectation().get(i).getExtremite2().isThirdYear() && c.getAffectation().get(i).getExtremite1().getName().equals("XXX")) {
    			result.add(c.getAffectation().get(i).getExtremite2());
    		}
    	}
    	return result;
    }
    
    /**
     * retourne la liste des tuteurs qui acceptent plusieurs FirstYearStudent
     * @param botAffectation
     * @return la liste des ThirdYearStudent qui acceptent d'être tuteur de plus d'un FirstYearStudent
     */
    public List<Student> getSeveralTutored(List<Student> botAffectation) {
    	List<Student> result = new ArrayList<Student>();
    	for(int i = 0; i < graphe.sommets().size(); i ++) {
    		if (graphe.sommets().get(i).isThirdYear() && graphe.sommets().get(i).getSeveralTutored()) {
    			if(result.size() < botAffectation.size()) {
    				result.add(graphe.sommets().get(i));
    			}
    		}
    	}
    	return result;
    }
    /**
     * Initialise les listes
     * @param studentList
     */
    public void prepaList(List<Student> studentList) {
    	this.fillStudentsLists(studentList);
		this.fillMissingStudents();
		this.unionStudentLists(studentList);
		this.triFirstYear();
    	
    }
    /**
     * Retourne true ou false si un graphe contient un bot
     * @return true ou false si un graphe contient un bot
     */
    public boolean haveBot() {
    	for(int i = 0; i < graphe.sommets().size(); i ++) {
    		if (graphe.sommets().get(i).getName().equals("XXX")) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Retourne une liste d'arete ne comprenant pas d'étudiant fictif
     * @param c
     * @return une liste d'arete ne comprenant pas d'étudiant fictif
     */
    public List<Arete<Student>> getListArete(CalculAffectation<Student> c) {
    	List<Arete<Student>> result = new ArrayList<Arete<Student>>();
    	for (int i = 0 ; i < c.getAffectation().size(); i = i+1) {
    		if(c.getAffectation().get(i).getExtremite1().isFirstYear() && !(c.getAffectation().get(i).getExtremite2().getName().equals("XXX"))) {
    			//ajout des aretes qui ne comporte pas de bot
    			result.add(graphe.getArete(c.getAffectation().get(i).getExtremite1(), c.getAffectation().get(i).getExtremite2()));
    		}
    	}
    	
    	return result;
    }
  
}
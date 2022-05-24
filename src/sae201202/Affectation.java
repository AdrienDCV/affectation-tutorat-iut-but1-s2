package sae201202;

import fr.ulille.but.sae2_02.*;
import fr.ulille.but.sae2_02.graphes.Arete;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

import java.time.LocalDate;
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
	 * Retourne la liste des premi�res ann�es
	 * TODO
	 * @return la valeur de la liste firstYear
	 */
	public List<Student> getFirstYear() {
		return firstYear;
	}
	
	/**
	 * Retourne la liste des troisi�mes ann�es
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
	 * Ajout des �tudiants contenu dans la student liste dans les listes de la classes respective
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
	 * Retourne la taille de la plus grande liste entre les premi�res ann�es et les deuxi�mes/troisi�mes ann�es
	 * TODO
	 * @return la liste la plus longue
	 */
	public int mostPopulated() {
		return Math.max(firstYear.size(), thirdSecondYear.size());
	}
	
	/**
	 * Ajoute des �tudiants fictif dans la liste la plus petite
	 * TODO
	 */
	public void fillMissingStudents() {
		//ajout des bots dans la liste des 1A
		if(firstYear.size() != mostPopulated()) {
			for(int i=firstYear.size(); i<mostPopulated(); i++) {
				firstYear.add(new FirstYearStudent("FAUX", "Profil", LocalDate.of(2000, 01, 01), "-", "-", "-",
						1, '-', Motivation.UNKNOWN, 1000, new HashMap<Subject, Double>()));
			}
		}
		//ajout des bots dans la liste des 3A
		if (thirdSecondYear.size() != mostPopulated()) {
			for(int i=thirdSecondYear.size(); i<mostPopulated(); i++) {
				thirdSecondYear.add(new ThirdYearStudent("FAUX", "Profil", LocalDate.of(2000, 01, 01), "---", "---", "---",
						3, '-', Motivation.UNKNOWN, 1000, new HashMap<Subject, Double>( )));
			}
		}
	}
	
	/**
	 * Ajoute les les premi�res ann�es et les deuxi�mes/troisi�mes ann�es dans une liste
	 * TODO
	 * @param studentList
	 */
	public void unionStudentLists(List<Student> studentList) {  
		//ajoute les 1A et les 2A/3A dans la liste en param�tre
        studentList.addAll(firstYear);
        studentList.addAll(thirdSecondYear);
    }

	/**
	 * Ajoute les sommets des �tudiants de la liste
	 * TODO
	 * @param studentList
	 */
	public void addNodes(List<Student> studentList) {
		//cr�ation des sommets
		for (int i=0; i<studentList.size(); i++) {
			graphe.ajouterSommet(studentList.get(i));
		}
	}
    
	
	/**
	 * Ajoute les aretes dans le graphe
	 * TODO
	 */
    public void addEdges() {
    	//cr�ation des aretes
        for(int i = 0; i < firstYear.size(); i ++) {
            for(int j = 0; j < thirdSecondYear.size(); j ++) {
            	for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
                    graphe.ajouterArete(firstYear.get(i), thirdSecondYear.get(j), firstYear.get(i).calculPoid(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k)));
            	}
            }
        }
 
    }
    
    /**
     * V�rifie si l'�tudiant 1 et l'�tudiant 2 sont une arete
     * TODO
     * @param s1
     * @param s2
     * @return true si le graphe contient une ar�te liant s1 et s2 / false si le graphe ne contient pas d'ar�te liant s1 et s2 
     */
    private boolean isEdge(Student s1, Student s2) {
    	return graphe.contientArete(s1, s2);
    }
    
    /**
     * Force l'affectation de l'�tudiant 1 et l'�tudiant 2
     * TODO
     * @param s1
     * @param s2
     * @param A
     * @param studentList
     * @return true si l'affectation forc�e a r�ussit / false si non
     */
    public boolean affectationForce(Student s1, Student s2, Affectation A, List <Student> studentList) {
    	//Force une affectation, true si r�ussie false sinon
    	if (!this.isEdge(s1, s2)) {
    		//on enl�ve le 1A / 3A des listes pour l'affecter dans la liste des affectations forc�
    		A.firstYear.remove(s1);
        	A.thirdSecondYear.remove(s2);
        	forcedAssignment.add(s1);
        	forcedAssignment.add(s2);
        	
        	//on les enl�ve de la liste des �tudiants � affecter normalement
        	studentList.removeAll(forcedAssignment);
        	
        	//cr�ation de l'arete forc�
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
     * Tri la liste des premi�res ann�es
     * TODO
     */
    public void triFirstYear() {
    	//liste tri�
    	List<Student> tri = new ArrayList<Student>();
    	//liste des plus petits poid de chaque firstyear
    	List<Integer> minPoid = new ArrayList<Integer>();
    	//ajout de tout les poid d'un firstyear avec tous les third et second year et pour chaque matière
    	for(int i = 0; i < firstYear.size(); i ++) {
    		List<Integer> poid = new ArrayList<Integer>();
    		for(int j = 0; j < thirdSecondYear.size(); j ++) {
    			for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
    			   Integer n = firstYear.get(i).calculPoid(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k));
                   poid.add(n);
            	}
    		}
    		//cherche le plus petit poid du firstyear vers les tuteurs et l'ajoute à la liste
            Collections.sort(poid);
            minPoid.add(poid.get(0));
    	}
    	//on cherche l'indice du int le plus petit et on le supprime de firstyear pour l'ajouter dans la liste tri�
    	int idx = 0;
    	while(firstYear.size() != 0) {
    		idx = this.minIdxList(minPoid);
    		tri.add(firstYear.remove(idx));
    		minPoid.remove(idx);
    	}
    	
    	//on remplace firstyear par la liste tri�
    	firstYear = tri;
    }
    
    /**
     * retourne la liste des �tudiants qui ont une affectation avec un �tudiant fictif
     * @param c
     * @return la liste des FirstYeartStudent / ThirdYearStudent / SecondeYearStudent qui sont affect�s � un faux profil d'�tudiant 
     */
    public List<Student> getBotAffectation(CalculAffectation<Student> c) {
    	List<Student> result = new ArrayList<Student>();
    	for (int i = 0 ; i < c.getAffectation().size(); i = i+1) {
    		if(c.getAffectation().get(i).getExtremite1().isFirstYear() && 
    				c.getAffectation().get(i).getExtremite2().getName().equals("FAUX")) {
    			result.add(c.getAffectation().get(i).getExtremite1());
    		} else if (c.getAffectation().get(i).getExtremite2().isThirdYear() && 
    				c.getAffectation().get(i).getExtremite1().getName().equals("FAUX")) {
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
    		if (graphe.sommets().get(i).isThirdYear() && 
    				graphe.sommets().get(i).doesAcceptSeveralTutored() && 
    				result.size() < botAffectation.size()) {
    			result.add(graphe.sommets().get(i));
    		}
    	}
    	return result;
    }
    
    public List<Arete<Student>> severalAffectation() {
    	List<Arete<Student>> listeArete = new ArrayList<Arete<Student>>();
		List<Student> severalAffectation = this.getSeveralTutored(thirdSecondYear);
		List<Student> studentList = new ArrayList<Student>();
		Affectation B = this;
		do {
			Affectation C = new Affectation();
			List<Student> botAffectation = new ArrayList<Student>();
			
			botAffectation = B.getBotAffectation(B.getCalcul());
			studentList.clear();
			studentList.addAll(botAffectation);
			studentList.addAll(severalAffectation);
			
			C.prepaList(studentList);
			
			C.addNodes(studentList);
			C.addEdges();
			
			CalculAffectation<Student> calculSeveralTutored = new CalculAffectation<Student>(C.graphe, C.getFirstYear(), C.getThirdSecondYear());
			calculSeveralTutored.getAffectation();
			listeArete.addAll(C.getListArete(calculSeveralTutored)); 
			B = C;
			B.setCalcul(calculSeveralTutored);
			
		} while(B.haveBot());
		return listeArete;
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
    		if (graphe.sommets().get(i).getName().equals("FAUX")) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Retourne une liste d'arete ne comprenant pas d'�tudiant fictif
     * @param c
     * @return une liste d'arete ne comprenant pas d'�tudiant fictif
     */
    public List<Arete<Student>> getListArete(CalculAffectation<Student> c) {
    	List<Arete<Student>> result = new ArrayList<Arete<Student>>();
    	for (int i = 0 ; i < c.getAffectation().size(); i = i+1) {
    		if(c.getAffectation().get(i).getExtremite1().isFirstYear() && 
    				!(c.getAffectation().get(i).getExtremite2().getName().equals("FAUX"))) {
    			//ajout des aretes qui ne comporte pas de bot
    			result.add(graphe.getArete(c.getAffectation().get(i).getExtremite1(), c.getAffectation().get(i).getExtremite2()));
    		}
    	}
    	
    	return result;
    }
    /**
     * Retourne une liste d'arete ne comprenant pas d'�tudiant fictif
     * @param l List<Arete<Student>> 
     * @return une liste d'arete ne comprenant pas d'�tudiant fictif
     */
    public List<Arete<Student>> getListArete(List<Arete<Student>> l) {
    	List<Arete<Student>> result = new ArrayList<Arete<Student>>();
    	for (int i = 0 ; i < l.size(); i = i+1) {
    		if(l.get(i).getExtremite1().isFirstYear() && 
    				!(l.get(i).getExtremite2().getName().equals("FAUX"))) {
    			//ajout des aretes qui ne comporte pas de bot
    			result.add(graphe.getArete(l.get(i).getExtremite1(), l.get(i).getExtremite2()));
    		}
    	}
    	
    	return result;
    }
    
    /**
     * Evite l'affectation entre l'étudiant s1 et s2
     * @param s1(student)
     * @param s2(student)
     * @return List(Arete<Student>) liste des arêtes ne contenant pas l'affectation s1 > s2
     */
    public List<Arete<Student>> eviterAffectation(Student s1, Student s2) {
    	List<Arete<Student>> result = new ArrayList<Arete<Student>>();
    	//on parcours le tableau de l'affectation qui comporte des aretes
    	for(int i=0; i < c.getAffectation().size(); i = i + 1) {
    		//on vérifie que les extrémités soit s1 et s2
    		if(c.getAffectation().get(i).getExtremite1().equals(s1) 
    				&& c.getAffectation().get(i).getExtremite2().equals(s2)) {
    			//tant qu'il n'est pas affectés ou que la liste des sommets est entièrement parcouru
    			boolean estAffecte = false;
    			int j = 0;
    			while(!estAffecte && j < graphe.sommets().size()) {
    				//si le sommet est un 3ème année et différent de s2
    				if(graphe.sommets().get(j).isThirdYear() 
    						&& !graphe.sommets().get(j).equals(s2)
    						&& ((ThirdYearStudent) graphe.sommets().get(j)).doesAcceptSeveralTutored()) {
    					Arete<Student> arete = new Arete<Student>(s1, graphe.sommets().get(j));
    					result.add(arete);
    					estAffecte = true;
    				}
    				j = j + 1;
    			}
    		//sinon on ajoute l'arete
    		} else {
    			result.add(c.getAffectation().get(i));
    		}
    	}
    	return result;
    }
    
    /**
     * Retourne la liste des 1ère année avec leur attribut isTutoredBy mis à jour.
     * @param listeArete: la liste des arrêtes de l'affectation
     * @return List(FirstYearStudent): liste de première année.
     */
    public static List<FirstYearStudent> isTutoredBy(List<Arete<Student>> listeArete) {
    	List<FirstYearStudent> list = new ArrayList<FirstYearStudent>();
    	for(int i = 0; i < listeArete.size(); i ++) {
    		//vérification s'il est bien un 1ère année
    		if(listeArete.get(i).getExtremite1().isFirstYear()) {
    			//downcast pour avoir accès à l'attribut
    			FirstYearStudent student = (FirstYearStudent) listeArete.get(i).getExtremite1();
    			//modification de l'attribut
    			student.setIsTutoredBy(listeArete.get(i).getExtremite2());
    			//ajout de l'étudiant
    			list.add(student);
    		}
    	}
    	return list;
    }
  
}
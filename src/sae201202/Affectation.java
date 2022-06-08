package sae201202;

import fr.ulille.but.sae2_02.graphes.Arete;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

import java.time.LocalDate;
import java.util.*;

/**
 * @authors adrien.dacostaveiga & adrien.degand
 * La classe Affectation est d�stin�e � d�composer tous les �l�ments n�cessaires au calcul d'une nouvelle
 * affectation avec ou sans contraintes.
 */
public class Affectation {
	// class attributes
	/**
	 Une Affectation est caract�ris�e par deux listes de FirstYearStudent, une liste de ThridYearStudent et de SecondYearStudent
	 * afin de s�parer les Student afin de traiter ces listes en vue du calcul d'affectation forc�ee et non forc�e.
	 * Elle se caract�rise aussi par un graphe non orient� et valu�, une liste que servire � forcer des affectations et 
	 * �videment, un calcul d'affectation non forc�ee et forc�e.
	 */
	private CalculAffectation<Student> calcul;
	private CalculAffectation<Student> forcedCalcul;
	
	public GrapheNonOrienteValue<Student> graph;
	public GrapheNonOrienteValue<Student> forcedGraph;
	
	private List<Student> firstYear;
	private List<Student> thirdSecondYear;

	private List<Student> forcedFirstYear;
	private List<Student> forcedThirdSecondYear;

	
	
	// constructor(s)
	/**
	 * Initialisation de toutes les listes, du graphe non orient� valu� et du calcul d'affectation
	 */
	public Affectation (){
		firstYear = new ArrayList<Student>();
		thirdSecondYear = new ArrayList<Student>();
		graph = new GrapheNonOrienteValue<Student>();
		forcedFirstYear = new ArrayList<Student>();
		forcedThirdSecondYear = new ArrayList<Student>();
		forcedGraph = new GrapheNonOrienteValue<Student>();
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
	public List<Student> getForcedFirstYear() {
		return forcedFirstYear;
	}
	
	/**
	 * Retourne la liste des troisi�mes ann�es
	 * TODO
	 * @return la valeur de la liste thirdYear
	 */
	public List<Student> getThirdSecondYear() {
		return thirdSecondYear;
	}
	
	public List<Student> getForcedFirstYear() {
		return forcedFirstYear;
	}
	
	/**
	 * Retourne la liste des troisi�mes ann�es
	 * TODO
	 * @return la valeur de la liste thirdYear
	 */
	public List<Student> getForcedThirdSecondYear() {
		return forcedThirdSecondYear;
	}
	
	/**
     * Change l'attribut Calcul
     * @param calcul
     */
    public void setCalcul(CalculAffectation<Student> calcul) {
    	this.calcul = calcul;
    }
    
    /**
     * Permet de modifier la valeur de l'attribut forcedCalcul
     * @param calcul
     */
    public void setForcedCalcul(CalculAffectation<Student> calcul) {
    	this.forcedCalcul = calcul;
    }
	
    /**
     * Retourne l'attribut Calcul
     * @return le calcul d'une affectation
     */
    public CalculAffectation<Student> getCalcul() {
    	return this.calcul;
    }
    
    /**
     * Return la valeur de l'attribut forcedCalcul
     * @return CalculAffectation<Student> forcedCalcul
     */
    public CalculAffectation<Student> getForcedCalcul() {
    	return this.forcedCalcul;
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
	 * Retourne la taille de la plus grande liste entre les premieres annees et les deuxiemes/troisiemes annees
	 * TODO
	 * @return la liste la plus longue
	 */
	public int mostPopulated() {
		return Math.max(firstYear.size(), thirdSecondYear.size());
	}
	
	/**
	 * Ajoute des etudiants fictif dans la plus petite liste
	 * TODO
	 */
	public void fillMissingStudents() {
		//ajout des faux profils dans la liste des 1 annees
		if(firstYear.size() != mostPopulated()) {
			for(int i=firstYear.size(); i<mostPopulated(); i++) {
				firstYear.add(new FirstYearStudent("FAUX", "Profil", LocalDate.of(2000, 01, 01), "-", "-", "-",
						1, '-', Motivation.UNKNOWN, 1000, new HashMap<Subject, Double>()));
			}
		}
		//ajout des faux profils dans la liste des 3 annees
		if (thirdSecondYear.size() != mostPopulated()) {
			for(int i=thirdSecondYear.size(); i<mostPopulated(); i++) {
				thirdSecondYear.add(new ThirdYearStudent("FAUX", "Profil", 3, '-'));
			}
		}
	}
	
	/**
	 * Ajoute les premieres annees et les deuxiemes/troisiemes annees dans une liste
	 * TODO
	 * @param studentList
	 */
	public void unionStudentLists(List<Student> studentList) {  
		studentList.clear();
		//ajoute les 1A et les 2A/3A dans la liste en param�tre
        studentList.addAll(firstYear);
        studentList.addAll(thirdSecondYear);
    }

	/**
	 * Ajoute les sommets des etudiants de la liste
	 * TODO
	 * @param studentList
	 */
	public void addNodes(List<Student> studentList) {
		//cr�ation des sommets
		for (int i=0; i<studentList.size(); i++) {
			graph.ajouterSommet(studentList.get(i));
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
            	if(!firstYear.get(i).getName().equals("FAUX")) {
            		for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
                		graph.ajouterArete(firstYear.get(i), thirdSecondYear.get(j), firstYear.get(i).calculPoids(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k)));
                        
                	}
            	} else {
            		graph.ajouterArete(firstYear.get(i), thirdSecondYear.get(j), 1000);
            	}
            	
            }
        }
 
    }
    
    /**
     * Verifie si l'etudiant 1 et l'etudiant 2 forment une arete
     * TODO
     * @param s1
     * @param s2
     * @return true si le graphe contient une arete liant s1 et s2 / false si le graphe ne contient pas d'arete liant s1 et s2 
     */
	 private boolean isEdge(Student s1, Student s2) {
	    	return graph.contientArete(s1, s2);
	 } 
    
    /**
     * Force l'affectation de l'etudiant 1 et l'etudiant 2
     * TODO
     * @param s1
     * @param s2
     * @param A
     * @param studentList
     * @return true si l'affectation forcee a reussit / false si non
     */
	 public boolean forcedAffectation(Student s1, Student s2, List <Student> studentList) {
	    	//Force une affectation, true si r�ussie false sinon
	    	if (!this.isEdge(s1, s2)) {
	    		//on enl�ve le 1A / 3A des listes pour l'affecter dans la liste des affectations forc�
	    		this.firstYear.remove(s1);
	        	this.thirdSecondYear.remove(s2);
	        	forcedFirstYear.add(s1);
	        	forcedThirdSecondYear.add(s2);
	        	
	        	//on les enl�ve de la liste des �tudiants � affecter normalement
	        	studentList.remove(s1);
	        	studentList.remove(s2);
	        	
	        	//cr�ation de l'arete forc�
	    		forcedGraph.ajouterSommet(s1);
	    		forcedGraph.ajouterSommet(s2);
	    		forcedGraph.ajouterArete(s1,s2, Integer.MAX_VALUE);
	    		forcedCalcul = new CalculAffectation<Student>(forcedGraph, forcedFirstYear, forcedThirdSecondYear);
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
     * Tri la liste des premieres annees
     * TODO
     */
    public void triFirstYear() {
    	//liste triee
    	List<Student> tri = new ArrayList<Student>();
    	//liste des plus petits poid de chaque firstyear
    	List<Integer> minPoid = new ArrayList<Integer>();
    	//ajout de tout les poid d'un FirstYearStudent avec tous les ThirdYearStudent et SecondYearStudent, pour chaque matiere
    	for(int i = 0; i < firstYear.size(); i ++) {
    		List<Integer> poid = new ArrayList<Integer>();
    		if (!firstYear.get(i).getName().equals("FAUX")) {
    			for(int j = 0; j < thirdSecondYear.size(); j ++) {
        			for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
        			   Integer n = firstYear.get(i).calculPoids(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k));
                       poid.add(n);
                	}
        		}
    		} else {
    			poid.add(1000);
    		}
    		
    		//cherche le plus petit poid du firstyear vers les tuteurs et l'ajoute a�la liste
            Collections.sort(poid);
            if (!poid.isEmpty()) {
            	minPoid.add(poid.get(0));
            }
    	}
    	//on cherche l'indice du int le plus petit et on le supprime de firstYear pour l'ajouter dans la liste triee
    	int idx = 0;
    	while(!firstYear.isEmpty()) {
    		idx = this.minIdxList(minPoid);
    		tri.add(firstYear.remove(idx));
    		minPoid.remove(idx);
    	}
    	
    	//on remplace firstYear par la liste triee
    	firstYear = tri;
    }
    
    /**
     * retourne la liste des etudiants qui ont une affectation avec un etudiant fictif
     * @param c
     * @return la liste des FirstYeartStudent / ThirdYearStudent / SecondeYearStudent qui sont affectes a un faux profil d'etudiant 
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
    	for(int i = 0; i < graph.sommets().size(); i ++) {
    		if (graph.sommets().get(i).isThirdYear() && 
    				((ThirdYearStudent) graph.sommets().get(i)).doesAcceptSeveralTutored() && 
    				result.size() < botAffectation.size()) {
    			result.add(graph.sommets().get(i));
    		}
    	}
    	return result;
    }
    
    /**
     * 
     * créer les sommets, les arêtes et le calcul d'affectation
     * @param studentList
     */
    public void affectation(List<Student> studentList) {
		this.addNodes(studentList);
		this.addEdges();

		calcul = new CalculAffectation<Student>(this.graph, this.getFirstYear(), this.getThirdSecondYear());
	}
    
    /**
     * Affecter plusieurs FirstYearStudent � un ThirdYearStudent si ils sont affectes a un faux profil.
     * @return Une liste d'aretes sans faux profil.
     */
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
			
			CalculAffectation<Student> calculSeveralTutored = new CalculAffectation<Student>(C.graph, C.getFirstYear(), C.getThirdSecondYear());
			calculSeveralTutored.getAffectation();
			listeArete.addAll(C.getListArete(calculSeveralTutored)); 
			B = C;
			B.setCalcul(calculSeveralTutored);
			
		} while(B.haveBot());
		return listeArete;
    }
    
    /**
     * Retourne true ou false si un graphe contient un bot
     * @return true ou false si un graphe contient un bot
     */
    public boolean haveBot() {
    	for(int i = 0; i < graph.sommets().size(); i ++) {
    		if (graph.sommets().get(i).getName().equals("FAUX")) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Retourne une liste d'arete ne comprenant pas d'etudiant fictif
     * @param l List<Arete<Student>> 
     * @return une liste d'arete ne comprenant pas d'etudiant fictif
     */
    public List<Arete<Student>> getListArete(List<Arete<Student>> l) {
    	List<Arete<Student>> result = new ArrayList<Arete<Student>>();
    	for (int i = 0 ; i < l.size(); i = i+1) {
    		if(l.get(i).getExtremite1().isFirstYear() && 
    				!(l.get(i).getExtremite2().getName().equals("FAUX"))) {
    			//ajout des aretes qui ne comporte pas de bot
    			if (!l.get(i).getExtremite1().getName().equals("FAUX")) {
    				result.add(graph.getArete(l.get(i).getExtremite1(), l.get(i).getExtremite2()));
    			}
    			
    		}
    	}
    	
    	return result;
    }
    
    /**
     * Retourne une liste d'arete ne comprenant pas d'etudiant fictif
     * @param c
     * @return une liste d'arete ne comprenant pas d'etudiant fictif
     */
    public List<Arete<Student>> getListArete(CalculAffectation<Student> c) {
    	List<Arete<Student>> result = new ArrayList<Arete<Student>>();
    	for (int i = 0 ; i < c.getAffectation().size(); i = i+1) {
    		if(c.getAffectation().get(i).getExtremite1().isFirstYear() && 
    				!(c.getAffectation().get(i).getExtremite2().getName().equals("FAUX"))) {
    			//ajout des aretes qui ne comporte pas de bot
    			if (!c.getAffectation().get(i).getExtremite1().getName().equals("FAUX")) {
    				result.add(graph.getArete(c.getAffectation().get(i).getExtremite1(), c.getAffectation().get(i).getExtremite2()));
    			}
    		}
    	}
    	
    	return result;
    }
    
    /**
     * Retourne une liste d'arete ne comprenant pas d'etudiant fictif
     * @param l List<Arete<Student>> 
     * @return une liste d'arete ne comprenant pas d'etudiant fictif
     */
    public List<Arete<Student>> getListForcedArete(CalculAffectation<Student> c) {
    	List<Arete<Student>> result = new ArrayList<Arete<Student>>();
    	for (int i = 0 ; i < c.getAffectation().size(); i = i+1) {
    		if(c.getAffectation().get(i).getExtremite1().isFirstYear() && 
    				!(c.getAffectation().get(i).getExtremite2().getName().equals("FAUX"))) {
    			//ajout des aretes qui ne comporte pas de bot
    			result.add(forcedGraph.getArete(c.getAffectation().get(i).getExtremite1(), c.getAffectation().get(i).getExtremite2()));
    		}
    	}
    	
    	return result;
    }
    
    /**
     * Evite l'affectation entre l'etudiant s1 et s2
     * @param s1(student)
     * @param s2(student)
     * @return List(Arete<Student>) liste des aretes ne contenant pas l'affectation s1 > s2
     */
    public List<Arete<Student>> avoidAffectation(Student s1, Student s2) {
    	List<Arete<Student>> result = new ArrayList<Arete<Student>>();
    	//on parcours le tableau de l'affectation qui comporte des aretes
    	for(int i=0; i < calcul.getAffectation().size(); i = i + 1) {
    		//on vérifie que les extrémités soit s1 et s2
    		if(calcul.getAffectation().get(i).getExtremite1().equals(s1) 
    				&& calcul.getAffectation().get(i).getExtremite2().equals(s2)) {
    			//tant qu'il n'est pas affectés ou que la liste des sommets est entièrement parcouru
    			boolean estAffecte = false;
    			int j = 0;
    			while(!estAffecte && j < graph.sommets().size()) {
    				//si le sommet est un 3ème année et différent de s2
    				if(graph.sommets().get(j).isThirdYear() 
    						&& !graph.sommets().get(j).equals(s2)
    						&& ((ThirdYearStudent) graph.sommets().get(j)).doesAcceptSeveralTutored()) {
    					Arete<Student> arete = new Arete<Student>(s1, graph.sommets().get(j));
    					result.add(arete);
    					estAffecte = true;
    				}
    				j = j + 1;
    			}
    		//sinon on ajoute l'arete
    		} else {
    			result.add(calcul.getAffectation().get(i));
    		}
    	}
    	return result;
    }
    
    /**
     * Retourne la liste des 1 annee avec leur attribut isTutoredBy mis a� jour.
     * @param listeArete: la liste des arretes de l'affectation
     * @return List(FirstYearStudent): liste de premiere annee.
     */
    public static List<FirstYearStudent> isTutoredBy(List<Arete<Student>> listeArete) {
    	List<FirstYearStudent> list = new ArrayList<FirstYearStudent>();
    	for(int i = 0; i < listeArete.size(); i ++) {
    		//veification s'il est bien un 1 annee
    		if(listeArete.get(i).getExtremite1().isFirstYear()) {
    			//downcast pour avoir acces a�l'attribut
    			FirstYearStudent student = (FirstYearStudent) listeArete.get(i).getExtremite1();
    			//modification de l'attribut
    			student.setIsTutoredBy(listeArete.get(i).getExtremite2());
    			//ajout de l'etudiant
    			list.add(student);
    		}
    	}
    	return list;
    }
  
}
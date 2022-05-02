package sae201202;

import fr.ulille.but.sae2_02.*;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

<<<<<<< HEAD
import java.lang.Math;
import java.util.*;

/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 * 
 *
 */
=======
import java.util.*;

>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
public class Affectation {
	private List<Student> firstYear;
	private List<Student> thirdSecondYear;
	GrapheNonOrienteValue<Student> graphe;
	
<<<<<<< HEAD
	/**
	 * 
	 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	public Affectation (){
		firstYear = new ArrayList<Student>();
		thirdSecondYear = new ArrayList<Student>();
		graphe = new GrapheNonOrienteValue<Student>();
	}
	
<<<<<<< HEAD
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
=======
	public List<Student> getFirstYear() {
		return firstYear;
	}

>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	public List<Student> getThirdSecondYear() {
		return thirdSecondYear;
	}
	
<<<<<<< HEAD
	/**
	 * 
	 * TODO
	 * @param studentList
	 */
=======
	
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
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
	
<<<<<<< HEAD
	/**
	 * 
	 * TODO
	 * @return
	 */
	public int mostPopulated() {
		return Math.max(firstYear.size(), thirdSecondYear.size());
	}
	
	public boolean acceptsSeveralTutored(List<Student> list, int idx) {
		boolean result = false;
		if (list.get(idx).getSeveralTutored()) {
				result = list.get(idx).getSeveralTutored();
				System.out.println(list.get(idx).getForename());
		}
		return result;
	}
	
	/**
	 * TODO
	 */
	public void fillMissingStudents() {
		if(firstYear.size() != mostPopulated()) {
			for(int i=firstYear.size(); i<mostPopulated(); i++) {
				firstYear.add(new FirstYearStudent("X", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000, new HashMap<Subject, Double>()));
=======
	public int mostPopulated() {
		int max = 0;
		if (firstYear.size() > max) {
			max = firstYear.size();
		} 
		if (thirdSecondYear.size() > max) {
			max = thirdSecondYear.size();
		}
		return max;
	}
	
	public void fillMissingStudents() {
		if(firstYear.size() != mostPopulated()) {
			for(int i=firstYear.size(); i<mostPopulated(); i++) {
				firstYear.add(new FirstYearStudent("X", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000));
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
			}
		} 
		if (thirdSecondYear.size() != mostPopulated()) {
			for(int i=thirdSecondYear.size(); i<mostPopulated(); i++) {
<<<<<<< HEAD
				thirdSecondYear.add(new Student("XXX", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000, false, new HashMap<Subject, Double>()));
		
=======
				thirdSecondYear.add(new ThirdYearStudent("XXX", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000));
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
			}
		}
	}
	
<<<<<<< HEAD
	
	
	/**
	 * 
	 * TODO
	 * @param studentList
	 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	public void unionStudentLists(List<Student> studentList) {  
        studentList.addAll(firstYear);
        studentList.addAll(thirdSecondYear);
    }

<<<<<<< HEAD
	/**
	 * 
	 * TODO
	 * @param studentList
	 */
=======
	
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	public void addNodes(List<Student> studentList) {
		for (int i=0; i<studentList.size(); i++) {
			graphe.ajouterSommet(studentList.get(i));
		}
	}
    
<<<<<<< HEAD
	/**
	 * 
	 * TODO
	 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
    public void addEdges() {
        for(int i = 0; i < firstYear.size(); i ++) {
            for(int j = 0; j < thirdSecondYear.size(); j ++) {
                for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
                    graphe.ajouterArete(firstYear.get(i), thirdSecondYear.get(j), firstYear.get(i).calculPoid(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k)));
<<<<<<< HEAD
                }  
=======
                }
                
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
            }
        }
    }
	
}
	
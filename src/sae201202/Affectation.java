package sae201202;

import fr.ulille.but.sae2_02.*;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;

import java.util.*;

public class Affectation {
	private List<Student> firstYear;
	private List<Student> thirdSecondYear;
	GrapheNonOrienteValue<Student> graphe;
	
	public Affectation (){
		firstYear = new ArrayList<Student>();
		thirdSecondYear = new ArrayList<Student>();
		graphe = new GrapheNonOrienteValue<Student>();
	}
	
	public List<Student> getFirstYear() {
		return firstYear;
	}

	public List<Student> getThirdSecondYear() {
		return thirdSecondYear;
	}
	
	
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
			}
		} 
		if (thirdSecondYear.size() != mostPopulated()) {
			for(int i=thirdSecondYear.size(); i<mostPopulated(); i++) {
				thirdSecondYear.add(new ThirdYearStudent("XXX", "---", 0, "---", 0, '-', "---", Motivation.UNKNOWN, 1000));
			}
		}
	}
	
	public void unionStudentLists(List<Student> studentList) {  
        studentList.addAll(firstYear);
        studentList.addAll(thirdSecondYear);
    }

	
	public void addNodes(List<Student> studentList) {
		for (int i=0; i<studentList.size(); i++) {
			graphe.ajouterSommet(studentList.get(i));
		}
	}
    
    public void addEdges() {
        for(int i = 0; i < firstYear.size(); i ++) {
            for(int j = 0; j < thirdSecondYear.size(); j ++) {
                for(int k= 0; k < firstYear.get(i).getSubject().size(); k ++) {
                    graphe.ajouterArete(firstYear.get(i), thirdSecondYear.get(j), firstYear.get(i).calculPoid(thirdSecondYear.get(j), firstYear.get(i).getSubject().get(k)));
                }
                
            }
        }
    }
	
}
	
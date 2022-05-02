package sae201202;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

<<<<<<< HEAD
/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
=======
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
public class Student extends Person {
	// class attributes
	private int scholarYear;
	private char group;
	private String studentID;
<<<<<<< HEAD
	private Map<Subject,Double> grades;
	private Motivation motivation;
	private int absence;
	private boolean acceptsSeveralTutored = false;
	private boolean priority;	
	private int score = 0;
	
	/**
	 * 
	 * @param name
	 * @param forename
	 * @param age
	 * @param mail
	 * @param scholarYear
	 * @param group
	 * @param studentID
	 * @param motivation
	 * @param absence
	 * @param grades
	 */
	// constructor(s)
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, boolean acceptsSeveralTutored, Map<Subject, Double> grades) {
=======
	private Map<String,Double> grades;
	private Motivation motivation;
	private int absence;
	private boolean priority;	
	private int score = 0;
	
	// constructor(s)
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<String, Double> grades) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
		super(name, forename, age, mail);
		this.setScholarYear(scholarYear);
		this.group = group;
		this.studentID = studentID;
		this.motivation = motivation;
		this.absence = absence;
<<<<<<< HEAD
		this.acceptsSeveralTutored = acceptsSeveralTutored;
		this.grades = grades;
	
	}
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, boolean accpetsSeveralTutored) {
		this(name, forename, age, mail, scholarYear,group,studentID, motivation, absence, accpetsSeveralTutored,new HashMap<Subject,Double>());
	}
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID, int absence) {
		this(name, forename, age, mail, scholarYear,group,studentID, Motivation.UNKNOWN, absence, false, new HashMap<Subject,Double>());
	}
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID) {
		this(name, forename, age, mail, scholarYear,group,studentID, Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>());
	}
	public Student (String name, String forename, int age, String mail, int scholarYear, char group) {
		this(name, forename, age, mail, scholarYear,group,"---", Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>());
	}
	public Student (String name, String forename, int age, String mail, int scholarYear) {
		this(name, forename, age, mail, scholarYear,'-',"---", Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>());
	}
	public Student (String name, String forename, int age, String mail) {
		this(name, forename, age, mail,0,'-',"---",Motivation.UNKNOWN, 0, false, new HashMap<Subject,Double>());
=======
		this.grades = grades;
	
	}
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID, int absence, Motivation motivation) {
		this(name, forename, age, mail, scholarYear,group,studentID, motivation, absence, new HashMap<String,Double>());
	}
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID, int absence) {
		this(name, forename, age, mail, scholarYear,group,studentID, Motivation.UNKNOWN, absence, new HashMap<String,Double>());
	}
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID) {
		this(name, forename, age, mail, scholarYear,group,studentID, Motivation.UNKNOWN, 0,new HashMap<String,Double>());
	}
	public Student (String name, String forename, int age, String mail, int scholarYear, char group) {
		this(name, forename, age, mail, scholarYear,group,"---", Motivation.UNKNOWN, 0, new HashMap<String,Double>());
	}
	public Student (String name, String forename, int age, String mail, int scholarYear) {
		this(name, forename, age, mail, scholarYear,'-',"---", Motivation.UNKNOWN, 0, new HashMap<String,Double>());
	}
	public Student (String name, String forename, int age, String mail) {
		this(name, forename, age, mail,0,'-',"---",Motivation.UNKNOWN, 0, new HashMap<String,Double>());
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
	}
	
	// methods
	public String toString() {
		return super.toString() + ", " + studentID + ", " + scholarYear + ", " + group + ", " + grades +  ", " + motivation;
	}
	
	public int getScholarYear() {
		return scholarYear;
	}
	public void setScholarYear(int scholarYear) {
			this.scholarYear = scholarYear;
	}
	
	public char getGroup() {
		return group;
	}
	
	public void setGroup(char group) {
		this.group = group;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
<<<<<<< HEAD
	public Map<Subject, Double> getGrades() {
		return grades;
	}
	
	public double getGrade(Subject subject) {
		return this.grades.get(subject);
	}
	
	public boolean getSeveralTutored() {
		return this.acceptsSeveralTutored;
	}
	
	public void setSeveralTutored(boolean severalTutored) {
		this.acceptsSeveralTutored = severalTutored;
	}
	
	public ArrayList<Subject> getSubject() {
		ArrayList<Subject> result = new ArrayList<Subject>();
		for (Subject key : grades.keySet() ) {
=======
	public Map<String, Double> getGrades() {
		return grades;
	}
	
	public double getGrade(String mat) {
		return this.grades.get(mat);
	}
	
	public ArrayList<String> getSubject() {
		ArrayList<String> result = new ArrayList<String>();
		for (String key : grades.keySet() ) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
		    result.add(key);
		}
		return result;
	}
	
	public Motivation getMotivation() {
		return motivation;
	}
	
	public void setMotivation(Motivation motivation) {
		this.motivation = motivation;
	}
	
	public int getAbsence() {
		return this.absence;
	}

	public boolean isFirstYear () {
		return this.scholarYear==1;
	}
	
	public boolean isSecondYear () {
		return this.scholarYear==2;
	}
	
	public boolean isThirdYear () {
		return this.scholarYear==3;
	} 
	
	
	public boolean isUnderEight () {
		boolean result = false;
<<<<<<< HEAD
		for (Map.Entry<Subject, Double> g : this.grades.entrySet()) {
=======
		for (Map.Entry<String, Double> g : this.grades.entrySet()) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
			if (g.getValue() <= 8.0) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean isAboveSixteen () {
		boolean result = false;
<<<<<<< HEAD
		for (Map.Entry<Subject, Double> g : this.grades.entrySet()) {
=======
		for (Map.Entry<String, Double> g : this.grades.entrySet()) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
			if (g.getValue() >= 16.0) {
				result = true;
			}
		}
		return result;
	}
	
<<<<<<< HEAD
	public Subject highestGrade () {
		double max = 0.0;
		Subject result = null;
		for (Map.Entry<Subject, Double> g : this.grades.entrySet()) {
=======
	public String highestGrade () {
		double max = 0.0;
		String result = "";
		for (Map.Entry<String, Double> g : this.grades.entrySet()) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
			if (g.getValue() > max) {
				max = g.getValue();
				result = g.getKey();
			}
		}
<<<<<<< HEAD
		return result; 
	}
	
	public Subject lowestGrade () {
		double min = Double.MAX_VALUE;
		Subject result = null;
		for (Map.Entry<Subject, Double> g : this.grades.entrySet()) {
			if (g.getValue() < min) {
				min = g.getValue();
				result = g.getKey();
			}
		}
		return result; 
	}


	public void isPrioritary() {
		if (this.isThirdYear() && this.grades.get(lowestGrade()) >= 16.00) {
			this.priority = true;
		} else if (this.isThirdYear() && (this.grades.get(lowestGrade()) < 16.00 && this.grades.get(lowestGrade()) >= 12.00) && this.motivation == Motivation.HIGH_MOTIVATION ) {
			this.priority = true;
		}
		if (this.isFirstYear() && this.grades.get(lowestGrade()) <= 8.00) {
=======
		return result;
	}
	
	public double calculMoyenne() {
		double total = 0.00;
		for (Map.Entry<String, Double> g : this.grades.entrySet()) {
			total += g.getValue();
		}
		return total / this.grades.size();
	}

	public void isPrioritary() {
		if (this.isThirdYear() && this.calculMoyenne() >= 16.00) {
			this.priority = true;
		} else if (this.isThirdYear() && (this.calculMoyenne() < 16.00 && this.calculMoyenne() >= 12.00) && this.motivation == Motivation.HIGH_MOTIVATION ) {
			this.priority = true;
		}
		if (this.isFirstYear() && this.calculMoyenne() <= 8.00) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
			this.priority = true;
		}
	}	

<<<<<<< HEAD
    public int bonusMalusFirstYear(Subject subject) {
=======
    public int bonusMalusFirstYear(String mat) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
        int result = 0;
        //bonus note
        if (grades.isEmpty()) {
        	System.out.println("il est vide.");
            result = -1000;
<<<<<<< HEAD
        } else if (grades.get(subject) < 8.0) {
            result += 5;
        } else if (grades.get(subject) > 8.0 && grades.get(subject) <= 12.0) {
            result += 3;
        } else if (grades.get(subject) > 12.0 && grades.get(subject) <= 14.0) {
=======
        } else if (grades.get(mat) < 8.0) {
            result += 5;
        } else if (grades.get(mat) > 8.0 && grades.get(mat) <= 12.0) {
            result += 3;
        } else if (grades.get(mat) > 12.0 && grades.get(mat) <= 14.0) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
            result += 1;
        }
       
        //bonus/malus motivation
        if (this.motivation == Motivation.HIGH_MOTIVATION) {
            result += 5;
        } else if (this.motivation == Motivation.AVERAGE_MOTIVATION) {
            result += 3;
        } else if (this.motivation == Motivation.LOW_MOTIVATION) {
            result += 1;
        } else if (this.motivation == Motivation.NO_MOTIVATION) {
            result -= 3;
        }
       
        //malus absence
        if (this.absence >= 1 && this.absence < 3) {
            result -= 2;
        } else if (this.absence >= 3 && this.absence < 7) {
            result -= 4;
        } else if (this.absence >= 7) {
            result -= 10;
        }
       
        return result;
    }
    
    
    
<<<<<<< HEAD
    public int bonusMalusThirdYear(Subject subject) {
=======
    public int bonusMalusThirdYear(String mat) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
        int result = 0;
        //bonus moyenne
        if (grades.isEmpty()) {
            result = -1000;
<<<<<<< HEAD
        } else if (grades.get(subject) > 14.0) {
            result += 5;
        } else if (grades.get(subject) > 12.0 && grades.get(subject) <= 14.0) {
            result += 3;
        }
        else if (grades.get(subject) > 8.0 && grades.get(subject) <= 12.0) {
=======
        } else if (grades.get(mat) > 14.0) {
            result += 5;
        } else if (grades.get(mat) > 12.0 && grades.get(mat) <= 14.0) {
            result += 3;
        }
        else if (grades.get(mat) > 8.0 && grades.get(mat) <= 12.0) {
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
            result += 1;
        }
       
        //bonus/malus motivation
        if (this.motivation == Motivation.HIGH_MOTIVATION) {
            result += 5;
        } else if (this.motivation == Motivation.AVERAGE_MOTIVATION) {
            result += 3;
        } else if (this.motivation == Motivation.LOW_MOTIVATION) {
            result += 1;
        } else if (this.motivation == Motivation.NO_MOTIVATION) {
            result -= 3;
        }
       
        //malus absence
        if (this.absence >= 1 && this.absence < 3) {
            result -= 2;
        } else if (this.absence >= 3 && this.absence < 7) {
            result -= 4;
        } else if (this.absence >= 7) {
            result -= 10;
        }
       
        return result;
    }
	
<<<<<<< HEAD
	public int calculPoid(Student s2, Subject subject) {
        //on part du principe que cette fonction s'execute depuis un élève de 1ère année
        int s1Score = this.bonusMalusFirstYear(subject);
        int s2Score = s2.bonusMalusThirdYear(subject);
=======
	public int calculPoid(Student s2, String mat) {
        //on part du principe que cette fonction s'execute depuis un élève de 1ère année
        int s1Score = this.bonusMalusFirstYear(mat);
        int s2Score = s2.bonusMalusThirdYear(mat);
>>>>>>> b230cf6356b4d6e65f1af69a8162e277a2baa2f9
        return Math.abs(s1Score - s2Score);
    }

}

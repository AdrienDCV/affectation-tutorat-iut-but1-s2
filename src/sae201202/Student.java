package sae201202;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Student extends Person {
	// class attributes
	private int scholarYear;
	private char group;
	private String studentID;
	private Map<String,Double> grades;
	private Motivation motivation;
	private int absence;
	private boolean priority;	
	private int score = 0;
	
	// constructor(s)
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, Map<String, Double> grades) {
		super(name, forename, age, mail);
		this.setScholarYear(scholarYear);
		this.group = group;
		this.studentID = studentID;
		this.motivation = motivation;
		this.absence = absence;
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
	
	public Map<String, Double> getGrades() {
		return grades;
	}
	
	public double getGrade(String mat) {
		return this.grades.get(mat);
	}
	
	public ArrayList<String> getSubject() {
		ArrayList<String> result = new ArrayList<String>();
		for (String key : grades.keySet() ) {
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
		for (Map.Entry<String, Double> g : this.grades.entrySet()) {
			if (g.getValue() <= 8.0) {
				result = true;
			}
		}
		return result;
	}
	
	public boolean isAboveSixteen () {
		boolean result = false;
		for (Map.Entry<String, Double> g : this.grades.entrySet()) {
			if (g.getValue() >= 16.0) {
				result = true;
			}
		}
		return result;
	}
	
	public String highestGrade () {
		double max = 0.0;
		String result = "";
		for (Map.Entry<String, Double> g : this.grades.entrySet()) {
			if (g.getValue() > max) {
				max = g.getValue();
				result = g.getKey();
			}
		}
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
			this.priority = true;
		}
	}	

    public int bonusMalusFirstYear(String mat) {
        int result = 0;
        //bonus note
        if (grades.isEmpty()) {
        	System.out.println("il est vide.");
            result = -1000;
        } else if (grades.get(mat) < 8.0) {
            result += 5;
        } else if (grades.get(mat) > 8.0 && grades.get(mat) <= 12.0) {
            result += 3;
        } else if (grades.get(mat) > 12.0 && grades.get(mat) <= 14.0) {
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
    
    
    
    public int bonusMalusThirdYear(String mat) {
        int result = 0;
        //bonus moyenne
        if (grades.isEmpty()) {
            result = -1000;
        } else if (grades.get(mat) > 14.0) {
            result += 5;
        } else if (grades.get(mat) > 12.0 && grades.get(mat) <= 14.0) {
            result += 3;
        }
        else if (grades.get(mat) > 8.0 && grades.get(mat) <= 12.0) {
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
	
	public int calculPoid(Student s2, String mat) {
        //on part du principe que cette fonction s'execute depuis un élève de 1ère année
        int s1Score = this.bonusMalusFirstYear(mat);
        int s2Score = s2.bonusMalusThirdYear(mat);
        return Math.abs(s1Score - s2Score);
    }

}

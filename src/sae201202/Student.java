package sae201202;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class Student extends Person {
	// class attributes
	private int scholarYear;
	private char group;
	private String studentID;
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
	// constructor(s)
	public Student (String name, String forename, int age, String mail, int scholarYear, char group, String studentID, Motivation motivation, int absence, boolean acceptsSeveralTutored, Map<Subject, Double> grades) {
		super(name, forename, age, mail);
		this.setScholarYear(scholarYear);
		this.group = group;
		this.studentID = studentID;
		this.motivation = motivation;
		this.absence = absence;
		this.acceptsSeveralTutored = acceptsSeveralTutored;
		this.grades = grades;
	
	}
	public Student(String name, String forename, int age, String mail, int schoolYear, char group, String studentID, Motivation motivation, int absence, boolean acceptsSeveralTutored) {
		this(name, forename, age, mail, schoolYear, group, studentID, motivation, absence, acceptsSeveralTutored, new HashMap<Subject, Double>());
	}
	public Student(String name, String forename, int age, String mail, int schoolYear, char group, String studentID, Motivation motivation, int absence, Map<Subject, Double> grades) {
		this(name, forename, age, mail, schoolYear, group, studentID, motivation, absence, false, grades);
	}
	public Student(String name, String forename, int age, String mail, int schoolYear, char group, String studentID, Motivation motivation, int absence) {
		this(name, forename, age, mail, schoolYear, group, studentID, motivation, absence, false, new HashMap<Subject, Double>());
	}
	public Student(String name, String forename, int age, String mail, int schoolYear, char group, String studentID, Motivation motivation) {
		this(name, forename, age, mail, schoolYear, group, studentID, motivation, 0, false, new HashMap<Subject, Double>());
	}
	public Student(String name, String forename, int age, String mail, int schoolYear, char group, String studentID) {
		this(name, forename, age, mail, schoolYear, group, studentID, Motivation.UNKNOWN, 0, false, new HashMap<Subject, Double>());
	}
	public Student(String name, String forename, int age, String mail, int schoolYear, char group) {
		this(name, forename, age, mail, schoolYear, group, "---", Motivation.UNKNOWN, 0, false, new HashMap<Subject, Double>());
	}
	public Student(String name, String forename, int age, String mail, int schoolYear) {
		this(name, forename, age, mail, schoolYear, '-', "---", Motivation.UNKNOWN, 0, false, new HashMap<Subject, Double>());
	}
	public Student(String name, String forename, int age, String mail) {
		this(name, forename, age, mail, 0, '-', "---", Motivation.UNKNOWN, 0, false, new HashMap<Subject, Double>());
	}
	public Student(String name, String forename, int age) {
		this(name, forename, age, "---", 0, '-', "---", Motivation.UNKNOWN, 0, false, new HashMap<Subject, Double>());
	}
	
	// methods
	/**
	 * 
	 */
	public String toString() {
		return super.toString() + ", " + studentID + ", " + scholarYear + ", " + group + ", " + grades +  ", " + motivation;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public int getScholarYear() {
		return scholarYear;
	}
	
	/**
	 * 
	 * TODO
	 * @param scholarYear
	 */
	public void setScholarYear(int scholarYear) {
			this.scholarYear = scholarYear;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public char getGroup() {
		return group;
	}
	
	/**
	 * 
	 * TODO
	 * @param group
	 */
	public void setGroup(char group) {
		this.group = group;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public String getStudentID() {
		return studentID;
	}
	
	/**
	 * 
	 * TODO
	 * @param studentID
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public Map<Subject, Double> getGrades() {
		return grades;
	}
	
	/**
	 * 
	 * TODO
	 * @param subject
	 * @return
	 */
	public double getGrade(Subject subject) {
		return this.grades.get(subject);
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public boolean getSeveralTutored() {
		return this.acceptsSeveralTutored;
	}
	
	/**
	 * 
	 * TODO
	 * @param severalTutored
	 */
	public void setSeveralTutored(boolean severalTutored) {
		this.acceptsSeveralTutored = severalTutored;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public ArrayList<Subject> getSubject() {
		ArrayList<Subject> result = new ArrayList<Subject>();
		for (Subject key : grades.keySet() ) {
			result.add(key);
		}
		return result;
	}
	
	/**
	 * 
	 * TODO
	 * @param mat
	 * @return
	 */
	public double getGrade(String mat) {
		return this.grades.get(mat);
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public Motivation getMotivation() {
		return motivation;
	}
	
	/**
	 * 
	 * TODO
	 * @param motivation
	 */
	public void setMotivation(Motivation motivation) {
		this.motivation = motivation;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public int getAbsence() {
		return this.absence;
	}

	/**
	 * 
	 * TODO
	 * @return
	 */
	public boolean isFirstYear () {
		return this.scholarYear==1;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public boolean isSecondYear () {
		return this.scholarYear==2;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public boolean isThirdYear () {
		return this.scholarYear==3;
	} 
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public boolean isUnderEight () {
		boolean result = false;
		for (Entry<Subject, Double> g : this.grades.entrySet()) {
			if (g.getValue() <= 8.0) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public boolean isAboveSixteen () {
		boolean result = false;
		for (Map.Entry<Subject, Double> g : this.grades.entrySet()) {
			if (g.getValue() >= 16.0) {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
	public Subject highestGrade () {
		double max = 0.0;
		Subject result = null;
		for (Map.Entry<Subject, Double> g : this.grades.entrySet()) {
			if (g.getValue() > max) {
				max = g.getValue();
				result = g.getKey();
			}
		}
		return result; 
	}
	
	/**
	 * 
	 * TODO
	 * @return
	 */
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

	/**
	 * 
	 * TODO
	 * @param subject
	 * @return
	 */
    public int bonusMalusFirstYear(Subject subject) {
        int result = 0;
        //bonus note
        if (grades.isEmpty()) {
            result = -1000;
        } else if (grades.get(subject) < 8.0) {
            result += 5;
        } else if (grades.get(subject) > 8.0 && grades.get(subject) <= 12.0) {
            result += 3;
        } else if (grades.get(subject) > 12.0 && grades.get(subject) <= 14.0) {
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
    
    /**
     * 
     * TODO
     * @param subject
     * @return
     */
    public int bonusMalusThirdYear(Subject subject) {
        int result = 0;
        //bonus moyenne
        if (grades.isEmpty()) {
            result = -1000;
        } else if (grades.get(subject) > 14.0) {
            result += 5;
        } else if (grades.get(subject) > 12.0 && grades.get(subject) <= 14.0) {
            result += 3;
        }
        else if (grades.get(subject) > 8.0 && grades.get(subject) <= 12.0) {
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
	
    /**
     * 
     * TODO
     * @param s2
     * @param subject
     * @return
     */
	public int calculPoid(Student s2, Subject subject) {
        //on part du principe que cette fonction s'execute depuis un élève de 1ère année
        int s1Score = this.bonusMalusFirstYear(subject);
        int s2Score = s2.bonusMalusThirdYear(subject);
        return Math.abs(s1Score - s2Score);
    }

}

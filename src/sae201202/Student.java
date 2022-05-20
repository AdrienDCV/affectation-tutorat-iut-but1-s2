package sae201202;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;


/**
 * 
 * @
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class Student extends Person {
	// class attributes
	private String mail;
	private int scholarYear;
	private char group;
	private Map<Subject, Double> grades;
	private Motivation motivation;
	private int absence;
	private int score = 0;
	protected boolean acceptsSeveralTutored;
	

	// constructor(s)
	public Student (String name, String forename, LocalDate birthDate, String ID, String passWord, String mail, int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades) {
		super(name, forename, birthDate, passWord);
		try {
			this.setScholarYear(scholarYear);
		} catch (WrongScholarYearException e) {
			System.out.println("WrongScholarYearException. Merci d'entrer un num�ro compris entre 1 et 3 svp.");
		}
		this.setMail(name, forename); 
		this.setID(name, forename);
		this.group = group;
		this.motivation = motivation;
		this.absence = absence;
		this.grades = grades;
		this.acceptsSeveralTutored = false;
	}
	
	// constructeur spécifique aux ThirdStudentYear
	public Student (String name, String forename, LocalDate birthDate, String ID, String passWord, String mail, int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades, boolean acceptsSeveralTutored) {
		super(name, forename, birthDate, passWord);
		try {
			this.setScholarYear(scholarYear);
		} catch (WrongScholarYearException e) {
			System.out.println("WrongScholarYearException. Merci d'entrer un num�ro compris entre 1 et 3 svp.");
		}
		this.setMail(name, forename); 
		this.setID(name, forename); 
		this.group = group;
		this.motivation = motivation;
		this.absence = absence;
		this.grades = grades;
		this.acceptsSeveralTutored = acceptsSeveralTutored;
	}
	
	public Student (String name, String forename, LocalDate birthDate, int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades) {
		super(name, forename, null, null);
		try {
			this.setScholarYear(scholarYear);
		} catch (WrongScholarYearException e) {
			System.out.println("WrongScholarYearException. Merci d'entrer un num�ro compris entre 1 et 3 svp.");
		}
		this.setMail(name, forename); 
		this.setID(name, forename);
		this.group = group;
		this.motivation = motivation;
		this.absence = absence;
		this.grades = grades;
		this.acceptsSeveralTutored = false;
	}

	// methods
	/**
	 * Retourne l'objet Student sous la forme : "nom, pr�nom, age, mail, Id_�tudiant, ann�e d'�tude, groupe, notes, motivation"
	 */
	public String toString() {
		return super.toString() + ", est en " + scholarYear + " année, moyennes : " + grades + ", motivation : " + motivation + ", nombre d'absences : " + absence;
	}
	
	/**
	 * Retourne l'attribut ScholarYear
	 * TODO
	 * @return la valeur de l'attribut scholarYear
	 */
	
	@Override
	public String setMail(String name, String forename) {
		return forename.toLowerCase().replaceAll(" ", "")+'.'+name.toLowerCase().replaceAll(" ", "")+".etu@univ-lille.fr";
	}
	
	@Override
	public String setID(String name, String forename) {
		return forename.toLowerCase().replaceAll(" ", "")+'.'+name.toLowerCase().replaceAll(" ", "")+".etu";
	}
	
	public int getScholarYear() {
		return scholarYear;
	}
	
	/**
	 * Change l'attribut ScholarYear
	 * TODO
	 * @param scholarYear
	 * @throws WrongScholarYearException 
	 */
	public void setScholarYear(int scholarYear) throws WrongScholarYearException {
		if (scholarYear >= 1 && scholarYear <= 3) {
			this.scholarYear = scholarYear;
		} else {
			throw new WrongScholarYearException();
		}
			
	}
	
	/**
	 * Retourne l'attribut Group
	 * TODO
	 * @return la valeur de l'attribut group
	 */
	public char getGroup() {
		return group;
	}
	
	/**
	 * Change l'attribut Group
	 * TODO
	 * @param group
	 */
	public void setGroup(char group) {
		this.group = group;
	}
	
	/**
	 * Retourne la liste Grades
	 * TODO
	 * @return la liste des notes d'un Student
	 */
	public Map<Subject, Double> getGrades() {
		return grades;
	}	
	

	/**
	 * Retourne une liste des mati�res des notes
	 * TODO
	 * @return une liste des mati�res (ressources)
	 */
	public ArrayList<Subject> getSubject() {
		ArrayList<Subject> result = new ArrayList<Subject>();
		for (Subject key : grades.keySet() ) {
			result.add(key);
		}
		return result;
	}

	/**
	 * Retourne la/les notes en fonction de l'objet mati�re
	 * TODO
	 * @param subject
	 * @return 
	 */
	public double getGrade(Subject subject) {
		return this.grades.get(subject);
	}
	
	/**
	 * Retourne l'attribut Motivation
	 * TODO
	 * @return
	 */
	public Motivation getMotivation() {
		return motivation;
	}
	
	/**
	 * Change l'attribut Motivation
	 * TODO
	 * @param motivation
	 */
	public void setMotivation(Motivation motivation) {
		this.motivation = motivation;
	}
	
	/**
	 * Retourne l'attribut Absence
	 * TODO
	 * @return la valeur de l'attribut absence
	 */
	public int getAbsence() {
		return this.absence;
	}

	/**
	 * Retourne True si l'ann�e de Student est 1
	 * TODO
	 * @return true / false
	 */
	public boolean isFirstYear () {
		return this.scholarYear==1;
	}
	
	/**
	 * Retourne True si l'ann�e de Student est 2
	 * TODO
	 * @return true / false
	 */
	public boolean isSecondYear () {
		return this.scholarYear==2;
	}
	
	/**
	 * Retourne True si l'ann�e de Student est 3
	 * TODO
	 * @return true / false
	 */
	public boolean isThirdYear () {
		return this.scholarYear==3;
	} 
	
	public boolean doesAcceptSeveralTutored() {
		return this.acceptsSeveralTutored;
	}
	
	/**
	 * Retourne la mati�re de la note la plus haute
	 * TODO
	 * @return la mati�re de la note la plus haute
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
	 * Retourne la note de la plus petite note
	 * TODO
	 * @return la mati�re de la note la plus petite
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
	 * Retourne le score de l'�tudiant premi�re ann�e en fonction de la mati�re
	 * TODO
	 * @param subject
	 * @return le score de FirstYearStudent
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
     * Retourne le score de l'�tudiant troisi�me ann�e en fonction de la mati�re
     * TODO
     * @param subject
     * @return le score de SecondYearStudent / ThirdYearStudent
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
     * Calcul le poids de Student avec s2
     * TODO
     * @param s2
     * @param subject
     * @return le poids de l'ar�te (Student, s2)
     */
	public int calculPoid(Student s2, Subject subject) {
        //on part du principe que cette fonction s'execute depuis un élève de 1ère année
        int s1Score = this.bonusMalusFirstYear(subject);
        int s2Score = s2.bonusMalusThirdYear(subject);
        return Math.abs(s1Score - s2Score);
    }

}

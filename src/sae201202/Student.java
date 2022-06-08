package sae201202;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * 
 * @
 * @authors adrien.dacostaveiga & adrien.degand
 *
 */
public class Student extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 16543L;
	// class attributes
	private int scholarYear;
	private char group;
	private Map<Subject, Double> grades;
	private Motivation motivation;
	private int absence;
	private int score = 0;
	protected boolean acceptsSeveralTutored;
	private static Map<Subject, Teacher> teacherList = new HashMap<Subject, Teacher>();
	

	// constructor(s)
	public Student (String name, String forename, LocalDate birthDate, String ID, String passWord, String mail, int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades) {
		super(name, forename, birthDate, passWord);
		try {
			this.setScholarYear(scholarYear);
		} catch (WrongScholarYearException e) {
			System.out.println("WrongScholarYearException. Merci d'entrer un numï¿½ro compris entre 1 et 3 svp.");
		}
		this.setID(name, forename);
		this.setMail(name, forename); 
		this.group = group;
		this.motivation = motivation;
		this.absence = absence;
		this.grades = grades;
		this.acceptsSeveralTutored = false;
	}
	
	// constructeur specifique aux ThirdStudentYear
	public Student (String name, String forename, LocalDate birthDate, String ID, String passWord, String mail, int scholarYear, char group, Motivation motivation, int absence, Map<Subject, Double> grades, boolean acceptsSeveralTutored) {
		super(name, forename, birthDate, passWord);
		try {
			this.setScholarYear(scholarYear);
		} catch (WrongScholarYearException e) {
			System.out.println("WrongScholarYearException. Merci d'entrer un numï¿½ro compris entre 1 et 3 svp.");
		}
		this.setID(name, forename);
		this.setMail(name, forename); 
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
			System.out.println("WrongScholarYearException. Merci d'entrer un numï¿½ro compris entre 1 et 3 svp.");
		}
		this.setID(name, forename);
		this.setMail(name, forename); 
		this.group = group;
		this.motivation = motivation;
		this.absence = absence;
		this.grades = grades;
		this.acceptsSeveralTutored = false;
	}

	// methods
	/**
	 * Retourne l'objet Student sous la forme : "nom, preom, age, mail, Id_eudiant, annee d'etude, groupe, notes, motivation"
	 */
	public String toString() {
		return super.toString() + ", est en " + scholarYear + " annÃ©e, moyennes : " + grades + ", motivation : " + motivation + ", nombre d'absences : " + absence;
	}
	
	/**
	 * Méthode héritée de Person
	 * Permet de generer automatiquement un indentifiant (ID) à partir du prénom (forname) et nom (name)
	 * de la forne : forename.name.etu
	 * @return String ID
	 */
	@Override
	public String setID(String name, String forename) {
		return forename.toLowerCase().replaceAll(" ", "")+'.'+name.toLowerCase().replaceAll(" ", "")+".etu";
	}
	
	/**
	 * Méthode héritée de Person
	 * Permet de generer automatiquement un indentifiant (ID) à partir du prénom (forname) et nom (name)
	 * de la forne : forename.name.etu@unive-lille.fr
	 * @return String mail
	 */
	@Override
	public String setMail(String name, String forename) {
		return this.getID()+"@univ-lille.fr";
	}
	
	/**
	 * Rerturn la valeur de l'attribut scholarYear
	 * @return int shcolarYear
	 */
	public int getScholarYear() {
		return scholarYear;
	}
	
	/**
	 * Permet de modifier la valeur de l'attribut scholarYear si elle est comprise entre 1 et 3
	 * propage une exception sinon
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
	 * Retourne la valeur de l'attribut group
	 * @return char group
	 */
	public char getGroup() {
		return group;
	}
	
	/**
	 * Permet de modifier la valeur de l'attribut group
	 * @param group
	 */
	public void setGroup(char group) {
		this.group = group;
	}
	
	/**
	 * Retourne la matiere de la note la plus haute
	 * @return Subject subject
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
	 * Retourne la matiere de la plus petite note
	 * @return Subject subject
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
	 * Retourne la liste Grades
	 * @return HashMap<Subject, Double> grades
	 */
	public Map<Subject, Double> getGrades() {
		return grades;
	}	

	/**
	 * Retourne une liste des matieres des notes
	 * @return ArrayList<Subject> liste des matieres (ressources)
	 */
	public ArrayList<Subject> getSubject() {
		ArrayList<Subject> result = new ArrayList<Subject>();
		for (Subject key : grades.keySet() ) {
			result.add(key);
		}
		return result;
	}

	/**
	 * Return la/les notes en fonction de la matiere
	 * @param subject
	 * @return double grade
	 */
	public double getGrade(Subject subject) {
		return this.grades.get(subject);
	}
	
	/**
	 * Return la valeur de l'attribut Motivation
	 * @return Motivation motivation
	 */
	public Motivation getMotivation() {
		return motivation;
	}
	
	/**
	 * Permet de modifier la valeur de l'attribut Motivation
	 * @param motivation
	 */
	public void setMotivation(Motivation motivation) {
		this.motivation = motivation;
	}
	
	/**
	 * Return le nombre d'absence
	 * @return int absence
	 */
	public int getAbsence() {
		return this.absence;
	}

	/**
	 * Return True si l'attribut scholarYear vaut 1
	 * @return true / false 
	 */
	public boolean isFirstYear () {
		return this.scholarYear==1;
	}
	
	/**
	 * Return True si l'attribut scholarYear vaut 2
	 * @return true / false
	 */
	public boolean isSecondYear () {
		return this.scholarYear==2;
	}
	
	/**
	 * Retourne True si l'attribut scholarYer vaut 3
	 * TODO
	 * @return true / false
	 */
	public boolean isThirdYear () {
		return this.scholarYear==3;
	} 
	

	/**
	 * Retourne le score de l'etudiant 1 annee en fonction de la matiere
	 * @param subject
	 * @return int score
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
     * Retourne le score de l'etudiant de 2 et 3 annee en fonction de la matiere
     * @param subject
     * @return int score
     */
    public int bonusMalusSecondThirdYear(Subject subject) {
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
     * @param s2
     * @param subject
     * @return int le poids de l'arete
     */
	public int calculPoids(Student s2, Subject subject) {
        //on part du principe que cette fonction s'execute depuis un Ã©lÃ¨ve de 1Ã¨re annÃ©e
        int s1Score = this.bonusMalusFirstYear(subject);
        int s2Score = s2.bonusMalusSecondThirdYear(subject);
        return Math.abs(s1Score - s2Score);
    }
	
	/**
	 * Supprime l'objet Student de studentList
	 * @param studentList
	 */
	public void studentLeave(List<Student> studentList) {
		studentList.remove(this);
	}
	
	/**
	 * 
	 * @param tList
	 * @throws TooManyTeacherForASubjectException
	 */
	public void fillTeacherList(List<Teacher> tList) throws TooManyTeacherForASubjectException{
		if (teacherList.isEmpty()) {
			teacherList.put(tList.get(0).getTeaching(), tList.get(0));
		} else {
			for (int i=0; i<teacherList.size();i++) {
				System.out.println(i);
				if (!teacherList.entrySet().equals(tList.get(i).getTeaching())) {
					teacherList.put(tList.get(i).getTeaching(), tList.get(i));
				} else {
					new TooManyTeacherForASubjectException();
				}
				
			}
		}
	}
	
	
	/**
	 * Ajoute l'objet Student à la liste des candidats d'un objet Teacher si il remplit certains critères
	 * imposés par le Teacher
	 */
	public void applyAsTutor() {
		Scanner sc = new Scanner(System.in);
		String wishSubject = sc.next();
		for (Map.Entry<Subject, Teacher> t : this.teacherList.entrySet()) {
			if (t.getKey().equals(wishSubject)) {
				if (t.getValue().getMinGrade() < this.getGrade(t.getKey()) && (t.getValue().getMaxAbsence() > this.getAbsence())) {
					t.getValue().getListStudent().add(this);
				}
			}
		}
	}

}

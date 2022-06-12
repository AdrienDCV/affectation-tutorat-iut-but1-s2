package sae201202;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.ulille.but.sae2_02.graphes.Arete;

/**
 * 
 * @author adrien.dacostaveiga.etu && adrien.degand
 * Classe d'import/export des données
 *
 */
public class SaveData implements Serializable {
	private static final long serialVersionUID = 156846344;

	/**
	 * Permet de convertir une List<Student> vers un JSONArray
	 * @param studentList
	 * @return JSONArray
	 */
	private static JSONArray fromStudentToJson(List<Student> studentList) {
		JSONArray result = new JSONArray();
		for(Student s : studentList) {
			JSONObject obj = new JSONObject();
			obj.put("name", s.getName());
			obj.put("forename", s.getForename());
			obj.put("birthDate", s.getBirthDate());
			obj.put("scholarYear", s.getScholarYear());
			obj.put("group", s.getGroup());
			obj.put("motivation", s.getMotivation());
			obj.put("absence", s.getAbsence());
			obj.put("grades1", s.getGrades().keySet());
			obj.put("grades2", s.getGrades().values());
			obj.put("acceptsSeveralTutored", s.doesAcceptSeveralTutored());
			result.put(obj);
		}
		return result;
	}
	
	/**
	 * Permet de convertir une Affectation vers un JSONArray
	 * @param Affectation a
	 * @return JSONArray
	 */
	private static JSONArray fromAffectationToJson(Affectation a) {
		List<Student> student = new ArrayList<Student>();
		student.addAll(a.getFirstYear());
		student.addAll(a.getThirdSecondYear());
		JSONArray result = fromStudentToJson(student);
		return result;
	}
	
	/**
	 * 
	 * Sauvegarde une liste d'étudiants dans le fichier fileName
	 * @param studentList
	 * @param fileName
	 * @return Boolean vrai faux si la sauvegarde n'échoue pas ou échoue
	 */
	public static boolean saveData(List<Student> studentList, String fileName) {
		JSONArray save = fromStudentToJson(studentList);
		try(FileWriter file = new FileWriter(fileName)) {
			save.write(file);
			file.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 
	 * Sauvegarde une liste d'arêtes student dans le fichier fileName
	 * @param listArete
	 * @param fileName
	 * @return Boolean vrai faux si la sauvegarde n'échoue pas ou échoue
	 */
	public static boolean saveDataArete(List<Arete<Student>> listArete, String fileName) {
		List<Student> studentList = new ArrayList<Student>();
		for(int i = 0; i < listArete.size(); i ++ ){
			studentList.add(listArete.get(i).getExtremite1());
			studentList.add(listArete.get(i).getExtremite2());
		}
		return saveData(studentList, fileName);
	}
	
	/**
	 * 
	 * Charge une liste d'arêtes student depuis le fichier fileName
	 * @param listArete
	 * @param fileName
	 */
	public static void loadDataArete(List<Arete<Student>> listArete, String fileName) {
		List<Student> studentList = new ArrayList<Student>();
		loadData(studentList, fileName);
		for(int i = 0; i < studentList.size() - 1; i = i + 2) {
			Arete<Student> arete = new Arete<Student>(studentList.get(i), studentList.get(i+1));
			listArete.add(arete);
		}
	}
	
	/**
	 * 
	 * Change un String en Localdate
	 * @param s
	 * @return LocalDate date transformé
	 */
	private static LocalDate loadLocaldate(String s) {
		LocalDate result = LocalDate.of( Integer.parseInt(s.substring(0, 4)), Integer.parseInt(s.substring(5, 7)), Integer.parseInt(s.substring(8, s.length())));
		return result;
	}
	
	/**
	 * 
	 * Charge une liste d'étudiants depuis le fichier fileName
	 * @param studentList
	 * @param fileName
	 */
	public static void loadData(List<Student> studentList, String fileName) {
		studentList.clear();
		File fichier = new File(fileName);
		JSONArray content;
		try {
			 content = new JSONArray(Files.readString(fichier.toPath()));
			 for(int i = 0; i < content.length(); i ++) {
				 HashMap<Subject,Double> grades = new HashMap<Subject,Double>();
				 for(int j = 0; j < content.getJSONObject(i).getJSONArray("grades1").length(); j ++) {
					 grades.put(Subject.valueOf(content.getJSONObject(i).getJSONArray("grades1").get(j).toString()), content.getJSONObject(i).getJSONArray("grades2").getDouble(j));
				 }
				 if (content.getJSONObject(i).getInt("scholarYear") == 1) {
					 Student s = new FirstYearStudent(content.getJSONObject(i).getString("name"),
			 				 content.getJSONObject(i).getString("forename"),
			 				 loadLocaldate(content.getJSONObject(i).getString("birthDate")),
			 				 content.getJSONObject(i).getInt("scholarYear"),
			 				 (char) content.getJSONObject(i).getInt("group"),
			 				 Motivation.valueOf(content.getJSONObject(i).getString("motivation")),
			 				 content.getJSONObject(i).getInt("absence"), grades);
	 
					 s.acceptsSeveralTutored = content.getJSONObject(i).getBoolean("acceptsSeveralTutored");
					 //System.out.println(loadDate(content.getJSONObject(i).getString("birthDate")));
					 studentList.add(s);
				 } else if (content.getJSONObject(i).getInt("scholarYear") == 2) {
					 Student s = new SecondYearStudent(content.getJSONObject(i).getString("name"),
			 				 content.getJSONObject(i).getString("forename"),
			 				 loadLocaldate(content.getJSONObject(i).getString("birthDate")),
			 				 content.getJSONObject(i).getInt("scholarYear"),
			 				 (char) content.getJSONObject(i).getInt("group"),
			 				 Motivation.valueOf(content.getJSONObject(i).getString("motivation")),
			 				 content.getJSONObject(i).getInt("absence"),
			 				 grades);
	 
					 s.acceptsSeveralTutored = content.getJSONObject(i).getBoolean("acceptsSeveralTutored");
					 //System.out.println(loadDate(content.getJSONObject(i).getString("birthDate")));
					 studentList.add(s);
				 } else if (content.getJSONObject(i).getInt("scholarYear") == 3) {
					 Student s = new ThirdYearStudent(content.getJSONObject(i).getString("name"),
			 				 content.getJSONObject(i).getString("forename"),
			 				 loadLocaldate(content.getJSONObject(i).getString("birthDate")),
			 				 content.getJSONObject(i).getInt("scholarYear"),
			 				 (char) content.getJSONObject(i).getInt("group"),
			 				 Motivation.valueOf(content.getJSONObject(i).getString("motivation")),
			 				 content.getJSONObject(i).getInt("absence"),
			 				 grades, 
			 				 content.getJSONObject(i).getBoolean("acceptsSeveralTutored"));
					 //System.out.println(loadDate(content.getJSONObject(i).getString("birthDate")));
					 studentList.add(s);
				 }
				 
			 }
		 } catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * Sauvegarde une Affectation dans le fichier fileName
	 * @param A
	 * @param fileName
	 * @return Boolean vrai faux si la sauvegarde n'échoue pas ou échoue
	 */
	public static boolean saveAffectation(Affectation A, String fileName) {
		JSONArray save = fromAffectationToJson(A);
		try(FileWriter file = new FileWriter(fileName)) {
			save.write(file);
			file.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * Charge une Affectation depuis le fichier fileName
	 * @param A
	 * @param fileName
	 */
	public static void loadAffectation(Affectation A, String fileName) {
		List<Student> studentList = new ArrayList<Student>();
		List<Student> firstYear = new ArrayList<Student>();
		List<Student> thirdSecondYear = new ArrayList<Student>();
		loadData(studentList,fileName);
		for(int i = 0; i < studentList.size(); i ++) {
			if(studentList.get(i).getScholarYear() == 1) {
				firstYear.add(studentList.get(i));
			} else {
				thirdSecondYear.add(studentList.get(i));
			}
		}
		A.getFirstYear().addAll(firstYear);
		A.getThirdSecondYear().addAll(thirdSecondYear);
		A.unionStudentLists(studentList);
		A.triFirstYear();
		A.addNodes(studentList);
		A.addEdges();
	}
	
	public static void createFile(String fileName) {
		try{
		      File file = new File(fileName);
		      if(!file.exists()){
		    	  file.createNewFile();
		      } 
		     }catch(Exception e){
		      e.printStackTrace();
		     }
	}

	public static void deleteFile(String fileName){
	     try{
	      File file = new File(fileName);
	      if(file.isFile() && file.exists()){
	    	  file.delete();
	      } 
	     }catch(Exception e){
	      e.printStackTrace();
	     }
	}
	
	public static boolean exitst(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
}
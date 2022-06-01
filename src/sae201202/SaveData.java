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


public class SaveData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 156846344;

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
	
	private static JSONArray fromAffectationToJson(Affectation a) {
		List<Student> student = new ArrayList<Student>();
		student.addAll(a.getFirstYear());
		student.addAll(a.getThirdSecondYear());
		JSONArray result = fromStudentToJson(student);
		return result;
	}
	
	public static boolean saveData(List<Student> studentList, String path) {
		JSONArray save = fromStudentToJson(studentList);
		try(FileWriter file = new FileWriter(path)) {
			save.write(file);
			file.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static LocalDate loadLocaldate(String s) {
		LocalDate result = LocalDate.of( Integer.parseInt(s.substring(0, 4)), Integer.parseInt(s.substring(5, 7)), Integer.parseInt(s.substring(8, s.length())));
		return result;
	}
	
	public static void loadData(List<Student> studentList, String path) {
		studentList.clear();
		
		File fichier = new File(path);
		JSONArray content;
		try {
			 content = new JSONArray(Files.readString(fichier.toPath()));
			 for(int i = 0; i < content.length(); i ++) {
				 HashMap<Subject,Double> grades = new HashMap<Subject,Double>();
				 for(int j = 0; j < content.getJSONObject(i).getJSONArray("grades1").length(); j ++) {
					 grades.put(Subject.valueOf(content.getJSONObject(i).getJSONArray("grades1").get(j).toString()), content.getJSONObject(i).getJSONArray("grades2").getDouble(j));
				 }
				 
				 Student s = new Student(content.getJSONObject(i).getString("name"),
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
				 
			 }
		 } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean saveAffectation(Affectation A, String path) {
		JSONArray save = fromAffectationToJson(A);
		try(FileWriter file = new FileWriter(path)) {
			save.write(file);
			file.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void loadAffectation(Affectation A, String path) {
		List<Student> studentList = new ArrayList<Student>();
		List<Student> firstYear = new ArrayList<Student>();
		List<Student> thirdSecondYear = new ArrayList<Student>();
		loadData(studentList, path);
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
}

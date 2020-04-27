package org.java.university.users;

import java.util.ArrayList;

import org.java.university.domain.Student;
import org.java.university.repository.RepositoryHandler;

public class StudentUserHandler {
	
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public StudentUserHandler() {
		
	}
	
	public ArrayList<Student> loadStudentList() {
		
		RepositoryHandler repoHan = new RepositoryHandler();
		studentList = repoHan.loadStudentList();
		
		return this.studentList;
		
	}
	
	public ArrayList<Student> loadStudentListByCourseId(ArrayList<Student> arrStudent,String idCourse) {
		
		ArrayList<Student> studentListNew = new ArrayList<Student>();
		
		int i = 0;
		while(i < arrStudent.size()) {
			
			if (arrStudent.get(i).getIdCourse().equals(idCourse))
				studentListNew.add(arrStudent.get(i));
		i++;	
		} 
		return studentListNew;
	}
	
	public ArrayList<Student> loadStudentListByCourseIdMultiple(ArrayList<Student> arrStudent,String idCourse) {
		
		ArrayList<Student> studentListNew = new ArrayList<Student>();
		
		int i = 0;
		while(i < arrStudent.size()) {
			String courses = arrStudent.get(i).getIdCourse();
			String[] result = courses.split("&");
			if (result.length>1) {
				for (String a : result) 

		            if(a.equals(idCourse)){
		            	studentListNew.add(arrStudent.get(i));};	
			}
			if (arrStudent.get(i).getIdCourse().equals(idCourse)) {
				studentListNew.add(arrStudent.get(i));}
		i++;	
		} 
		return studentListNew;
	}
	
	public ArrayList<Student> loadStudentListByIdStudent(ArrayList<Student> arrStudent,String idStudent) {
		
		ArrayList<Student> studentListNew = new ArrayList<Student>();
		
		int i = 0;
		while(i < arrStudent.size()) {
			
			if (arrStudent.get(i).getIdUser().equals(idStudent))
				studentListNew.add(arrStudent.get(i));
		i++;	
		} 
		return studentListNew;
	}
	
	public ArrayList<Student> AddNewStudent(ArrayList<Student> arrStudent,String nameUser, String idPerson,String idCourse, int age) {
		
		Student newStudent = new Student(nameUser,idPerson,idCourse,age);
		arrStudent.add(newStudent);
		
		RepositoryHandler newStud = new RepositoryHandler();
		newStud.updateStudentArray(arrStudent);
		
		return arrStudent;
		
	}
	
public ArrayList<Student> updateStudentCourseIdByIdStud(ArrayList<Student> arrStudent,String idCourse,String idStudent) {
		
		ArrayList<Student> studentListNew = new ArrayList<Student>();
		studentListNew = arrStudent;
		
		
		int i = 0;
		while(i < studentListNew.size()) {
			
			if (studentListNew.get(i).getIdUser().equals(idStudent)) {
				Student studentNew = new Student(studentListNew.get(i).getName(),studentListNew.get(i).getIdUser(),idCourse,studentListNew.get(i).getAge());
				studentListNew.set(i,studentNew);
				}
				
		i++;	
		} 
		RepositoryHandler newEstu = new RepositoryHandler();
		newEstu.updateStudentArray(studentListNew);
		return studentListNew;
	}

}

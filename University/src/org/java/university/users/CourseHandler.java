package org.java.university.users;

import java.util.ArrayList;

import org.java.university.domain.*;

import org.java.university.repository.RepositoryHandler;

public class CourseHandler {
	
	ArrayList<Course> courseList = new ArrayList<Course>();


	public ArrayList<Course> loadCourseList(){
		
		RepositoryHandler repoHan = new RepositoryHandler();
		courseList = repoHan.loadCourseList();
		
		return this.courseList;
	}
	
	public ArrayList<Course> loadStudentListByIdStudent(ArrayList<Course> arrCourse,String idCourse) {
		
		ArrayList<Course> courseListNew = new ArrayList<Course>();
		
		int i = 0;
		while(i < arrCourse.size()) {
			
			if (arrCourse.get(i).getIdCourse().equals(idCourse))
				courseListNew.add(arrCourse.get(i));
		i++;	
		} 
		return courseListNew;
	}
	
	public ArrayList<Course> loadCourseListByCourseId(ArrayList<Course> arrCourse,String idCourse) {
		
		ArrayList<Course> CourseListNew = new ArrayList<Course>();
		
		int i = 0;
		while(i < arrCourse.size()) {
			
			if (arrCourse.get(i).getIdCourse().equals(idCourse))
				CourseListNew.add(arrCourse.get(i));
		i++;	
		} 
		return CourseListNew;
	}
	
	public ArrayList<Course> loadCourseListByCourseIdMultiple(ArrayList<Course> arrCourse,String idCourse) {
		
		ArrayList<Course> CourseListNew = new ArrayList<Course>();
		
		int i = 0;
		int l = 0;
		while(i < arrCourse.size()) {
			String courses = idCourse;
			String[] result = courses.split("&");
			if(result.length>1) {
				for (String a : result)
					
		            if(a.equals(arrCourse.get(i).getIdCourse())){
		            	l++;
		            	}
				if (l == result.length) {
					CourseListNew.add(arrCourse.get(i));
				}
					
				
				;
			}				
				if (arrCourse.get(i).getIdCourse().equals(idCourse)) {
					CourseListNew.add(arrCourse.get(i));
				}
		i++;	
		} 
		return CourseListNew;
	}
		
	
	public ArrayList<Course> addNewCourse(ArrayList<Course> arrCourse,String nameCourse, String courseRoom,String idCourse) {
		
		Course newCourse = new Course(nameCourse,courseRoom,idCourse);
		arrCourse.add(newCourse);
		
		RepositoryHandler newCour = new RepositoryHandler();
		newCour.updateCourseArray(arrCourse);
		
		return arrCourse;
		
	}
	
}

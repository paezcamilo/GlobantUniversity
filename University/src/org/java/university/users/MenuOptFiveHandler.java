package org.java.university.users;

import java.util.ArrayList;

import org.java.university.domain.Course;
import org.java.university.domain.Student;
import org.java.university.messages.MessageHandler;

public class MenuOptFiveHandler {
	
	MessageHandler messHan = new MessageHandler();
	ArrayList<Student> studentData;
	ArrayList<Course> coursedata;
	
	public void optionFiveMenu() {
		
		StudentUserHandler estuData = new StudentUserHandler();
		CourseHandler courData = new CourseHandler();
		studentData = estuData.loadStudentList();
		coursedata = courData.loadCourseList();
		
		int l = 0;
		while (l<studentData.size()) {
			System.out.println(studentData.get(l).toString());
			l++;
		}
		ArrayList<Student> studList = new ArrayList<Student>();
		String studId = messHan.showAssignationCourseToStudent();
		studList = estuData.loadStudentListByIdStudent(studentData, studId);
		if(!studList.isEmpty()) {
			int f = 0;
			while(f<studList.size()) {
				String courses = studList.get(f).getIdCourse();
				String[] result = courses.split("&");
				ArrayList<Course> coursesDa = new ArrayList<Course>();
				messHan.showListMultipleCourMessage();
				for (String r : result) {
					
					coursesDa = courData.loadCourseListByCourseId(coursedata, r);
					coursesDa.forEach((n) -> System.out.println(n));
						
					}
				f++;
				}
				
			}else {
				
				messHan.showEmptyListMessage(studId);
			}
			
		}
		
}



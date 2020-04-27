package org.java.university.users;

import java.util.ArrayList;

import org.java.university.domain.Course;
import org.java.university.domain.Student;
import org.java.university.messages.MessageHandler;


public class MenuOptThreeHandler {
	
	ArrayList<Course> coursedata;
	ArrayList<Student> studentdata;
	
	public void loadMenuThree() {
		StudentUserHandler studentNew = new StudentUserHandler();
		CourseHandler courseNew = new CourseHandler();
		coursedata = courseNew.loadCourseList();
		MessageHandler messHan = new MessageHandler();
		
		Student studentData = messHan.showStudentCreationMessage();
		//Load Student List
		ArrayList<Student> studentList = studentNew.loadStudentList();
		
		//validate the students by id
		ArrayList<Student> studentByIdList = studentNew.loadStudentListByIdStudent(studentList, studentData.getIdUser());
		ArrayList<Course> studentByCourseIdList = courseNew.loadCourseListByCourseIdMultiple(coursedata, studentData.getIdCourse());
		
		if (!studentByIdList.isEmpty()){
			System.out.println("The id "+studentData.getIdUser()+" of the student is already assigned");
		}
		if(studentByCourseIdList.isEmpty()) {
			System.out.println("The id "+studentData.getIdCourse()+" of the Courses does not exist, please insert an existing id course");
		}
		else{
			
		studentNew.AddNewStudent(studentList,studentData.getName(),studentData.getIdUser(),studentData.getIdCourse(),studentData.getAge());
		}

	}

}

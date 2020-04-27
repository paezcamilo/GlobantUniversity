package org.java.university.users;

import java.util.ArrayList;

import org.java.university.domain.*;
import org.java.university.messages.MessageHandler;

public class MenuOptFourHandler {
	
	ArrayList<Professor> professorData;
	ArrayList<Student> studentData;
	ArrayList<Course> coursedata;
	
	public void optionFourMenu() {
		
		ProfessorUserHandler profData = new ProfessorUserHandler();
		StudentUserHandler estuData = new StudentUserHandler();
		CourseHandler courData = new CourseHandler();
		MessageHandler messHan = new MessageHandler();
		professorData = profData.loadProfessorList();
		studentData = estuData.loadStudentList();
		coursedata = courData.loadCourseList();
		
		
		messHan.showListMessage("Courses and its codes");
		
		int j = 0;
		while (j<coursedata.size()) {
			System.out.println(coursedata.get(j).toString());
			j++;
		}
		
		int optionfour = messHan.showMessageOptionFour();
		
		//Load submenu of options for option 4
		switch (optionfour) {
		case 1:
			
			Course newCour = messHan.showCourseCreationMessage();
			
			ArrayList<Course> CourseByCourseList = new ArrayList<Course>();
			CourseByCourseList = courData.loadCourseListByCourseId(coursedata, newCour.getIdCourse());
		if(!CourseByCourseList.isEmpty()){	
			messHan.showCourseExistIdCourseListMessage(newCour.getIdCourse());;
			}else{
					
				courData.addNewCourse(coursedata, newCour.getNameCourse(), newCour.getCourseRoom(), newCour.getIdCourse());
					
			}
			break;
			
		case 2:
			int k = 0;
			while (k<professorData.size()) {
				System.out.println(professorData.get(k).toString());
				k++;
			}
			ArrayList<Professor> profList = new ArrayList<Professor>();
			String ProfessorId = messHan.showAssignationCourseToProfessor();
			profList = profData.loadProfessorListByProfessorId(professorData, ProfessorId);
			if(profList.isEmpty()) {
				messHan.showEmptyListMessage(ProfessorId);
			}
			ArrayList<Course> courseListToProf = new ArrayList<Course>();
			String courseId = messHan.showAssignationCourseToProfessorTwo();
			courseListToProf = courData.loadCourseListByCourseId(coursedata, courseId);
			if(courseListToProf.isEmpty()) {
				messHan.showEmptyListMessage(courseId);
			}
			if (!courseListToProf.isEmpty() && !profList.isEmpty()) {
				profData.updateProfessorCourseIdByIdProf(professorData, courseId,ProfessorId);
			}else {
				System.out.println("We could not update the professor with the course, please review the data you entered.");
			}
			
			break;
			
		case 3:
			int l = 0;
			while (l<studentData.size()) {
				System.out.println(studentData.get(l).toString());
				l++;
			}
			ArrayList<Student> studList = new ArrayList<Student>();
			String studId = messHan.showAssignationCourseToStudent();
			studList = estuData.loadStudentListByIdStudent(studentData, studId);
			if(studList.isEmpty()) {
				messHan.showEmptyListMessage(studId);
			}
			ArrayList<Course> courListToProf = new ArrayList<Course>();
			String courId = messHan.showAssignationCourseToStudentFour();
			courListToProf = courData.loadCourseListByCourseIdMultiple(coursedata, courId);
			if(courListToProf.isEmpty()) {
				messHan.showEmptyListMessage(courId);
			}
			if (!courListToProf.isEmpty() && !studList.isEmpty()) {
				estuData.updateStudentCourseIdByIdStud(studentData, courId,studId);
			}else {
				System.out.println("We could not update the student with the course, please review the data you entered.");
			}
			
			
			break;
			
			
			default:
				
				break;
		
		}
		
	}

}

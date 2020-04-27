package org.java.university.users;

import java.util.ArrayList;

import org.java.university.domain.*;
import org.java.university.messages.MessageHandler;

public class MenuOptTwoHandler {
	
	ArrayList<Professor> professorData;
	ArrayList<Student> estudentData;
	ArrayList<Course> coursedata;
	
	
	public void optionTwoSubmenu() {
		
		ProfessorUserHandler profData = new ProfessorUserHandler();
		StudentUserHandler estuData = new StudentUserHandler();
		CourseHandler courData = new CourseHandler();
		MessageHandler messHan = new MessageHandler();
		professorData = profData.loadProfessorList();
		estudentData = estuData.loadStudentList();
		coursedata = courData.loadCourseList();
		
		messHan.showListMessage("Courses and its codes");
		
		int j = 0;
		while (j<coursedata.size()) {
			System.out.println(coursedata.get(j).toString());
			j++;
		}
		
		int optionTwo = messHan.showMessageOptionTwo();
		
		//Load submenu of options for option 2
		switch (optionTwo) {
		case 1:
			String idCourseEst = messHan.showMessageSubMenuStudent();
			
			ArrayList<Student> studeListByCourse = new ArrayList<Student>();
			studeListByCourse = estuData.loadStudentListByCourseIdMultiple(estudentData, idCourseEst);
		if(studeListByCourse.isEmpty()){	
			messHan.showEmptyListMessage(idCourseEst);
			}else{
					messHan.showListMessage("students assigned to the course "+idCourseEst+".");
					int k = 0;
					while (k<studeListByCourse.size()) {
						System.out.println(studeListByCourse.get(k).toString());
						k++;	
					}
			}
			break;
			
		case 2:
			String idCourseProf = messHan.showMessageSubMenuProfessor();
			ArrayList<Professor> professorListByCourse = new ArrayList<Professor>();
			professorListByCourse = profData.loadProfessorListByCourseId(professorData, idCourseProf);
			if(professorListByCourse.isEmpty()){	
				messHan.showEmptyListMessage(idCourseProf);
				}else{
						messHan.showListMessage("professors assigned to the course "+idCourseProf+".");
						int k = 0;
						while (k<professorListByCourse.size()) {
							System.out.println(professorListByCourse.get(k).toString());
							k++;	
						}
				}
			
			break;
		
		}
	}

}

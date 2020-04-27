package org.java.university.messages;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.java.university.domain.*;

public class MessageHandler {
	
	Scanner myInitialOpt = new Scanner(System.in);
	Scanner myIdCourse = new Scanner(System.in);
	Scanner myStudentName = new Scanner(System.in);
	Scanner myStudentId = new Scanner(System.in);
	Scanner myProfessorId = new Scanner(System.in);
	Scanner myStudentAge = new Scanner(System.in);
	Scanner myCourseName = new Scanner(System.in);
	Scanner myClassRoom = new Scanner(System.in);
	
	public MessageHandler() {
		
	}
	
	public int showInitialMessage() {
		int myOptSelected=0;
		try {
        System.out.println("*****------------------*****");
        System.out.println("Hi, please select one of the next options");
        System.out.println("1. Press 1 to know the list of professors.");
        System.out.println("2. Press 2 to know the list of courses, and you will be directed to another menu.");
        System.out.println("3. Create a new student and add him to a class.");
        System.out.println("4. Create a new course and add profesor and students.");
        System.out.println("5. Search a student by id and his courses assigned.");
        System.out.println("6. To close the application.");
        System.out.println("*****------------------*****");
        myOptSelected=myInitialOpt.nextInt();
        return myOptSelected;
		}catch (InputMismatchException inPutEx) {
            System.err.println("You tried to insert a non-numeric value, please select one of the numeric options. Thank you!! ");
            
        }return myOptSelected;
	}
	
	public int showMessageOptionTwo() {
		int myOptSelected=0;
		try {
        System.out.println("*****------------------*****");
        System.out.println("Do you want to know the list of teacher or studdents associated to this course?");
        System.out.println("1. Press 1 to know the list of students associated to the course.");
        System.out.println("2. Press 2 to know the list of professors associated to the course.");
        System.out.println("3. To close the application.");
        System.out.println("*****------------------*****");
        myOptSelected=myInitialOpt.nextInt();
        return myOptSelected;
		}catch (InputMismatchException inPutEx) {
            System.err.println("You tried to insert a non-numeric value, please select one of the numeric options. Thank you!! ");
            
        }return myOptSelected;
	}
	
	public String showMessageSubMenuStudent() {
		String myCourseSelected;

        System.out.println("*****------------------*****");
        System.out.println("To know the list of students in an specific course insert the id of the course (i.e C-1)");
        System.out.println("*****------------------*****");
        myCourseSelected=myIdCourse.next();
        return myCourseSelected;

	}
	
	public String showMessageSubMenuProfessor() {
		String myCourseSelected;

        System.out.println("*****------------------*****");
        System.out.println("To know the list of professors in an specific course insert the id of the course (i.e C-1)");
        System.out.println("*****------------------*****");
        myCourseSelected=myIdCourse.next();
        return myCourseSelected;

	}
	
	public void showListMessage(String objectName) {
		System.out.println("*****------------------*****");
        System.out.println("---This is the list of "+objectName+"---");
        System.out.println("*****------------------*****");
	}
	
	public void showEmptyListMessage(String objectName) {
		System.out.println("*****------------------*****");
        System.out.println("---There were not found information associated to the id "+objectName+"---");
        System.out.println("*****------------------*****");
        
	}
	
	public Student showStudentCreationMessage() {
		System.out.println("*****---Create the new student---*****");
		System.out.println("Enter the name of the student");
		String studentname = "";
		studentname+= myStudentName.nextLine();
		System.out.println("*****------------------*****");
		System.out.println("Enter the id number only of the student, the structure of the code is (i.e E-1), just add the number:");
		String studentId = "E-"+myStudentId.next();
		System.out.println("Enter the age of the student:");
		String studentAge = myStudentAge.next();
		System.out.println("Enter the id of the courses you want to subscribe the student:");
		System.out.println("The structure of the code is (i.e C-1), if you want to add multiple courses you need to add an & (i.e C-1&C-2) between each course:");
		String studentCourseId=myIdCourse.next();
		Integer stuAge = Integer.parseInt(studentAge);
		
		Student newStudent = new Student(studentname, studentId, studentCourseId, stuAge); 
		
		return newStudent;
	}
	
	public int showMessageOptionFour() {
		int myOptSelected=0;
		try {
        System.out.println("*****------------------*****");
        System.out.println("Do you want to create a new course?");
        System.out.println("1. Press 1 to create a new course.");
        System.out.println("2. Press 2 to assign a profesor to the new course.");
        System.out.println("3. Press 3 to assign some students to the new course.");
        System.out.println("*****------------------*****");
        myOptSelected=myInitialOpt.nextInt();
        return myOptSelected;
		}catch (InputMismatchException inPutEx) {
            System.err.println("You tried to insert a non-numeric value, please select one of the numeric options. Thank you!! ");
            
        }return myOptSelected;
	}
	
	public Course showCourseCreationMessage() {
		System.out.println("*****---Create the new course---*****");
		System.out.println("Enter the name of the course");
		String courseName = "";
		courseName+= myCourseName.nextLine();
		System.out.println("*****------------------*****");
		System.out.println("Enter the class room for this course, remember the structure (i.e 1-101):");
		String classRoom = myClassRoom.next();
		System.out.println("Enter the id number only of the new course, the structure of the code is (i.e C-1), just add the number:");
		String courseId = "C-"+myIdCourse.next();
		
		Course newCourse = new Course(courseName, classRoom, courseId); 
		
		return newCourse;
	}
	
	public String showAssignationCourseToProfessor() {
		System.out.println("*****---Assign a Course to the professor---*****");
		System.out.println("Enter the id of the professor, remember the structure of the id is (i.e P-1). Enter only the number");
		String professorId = "P-"+myProfessorId.next();
		
		return professorId;
	}
	
	public String showAssignationCourseToProfessorTwo() {
		System.out.println("*****---Assign a Course to the professor---*****");
		System.out.println("Enter the id of the Course you want to assign to the professor, remember the structure of the id is (i.e C-1). Enter only the number");
		String courseId = "C-"+myIdCourse.next();
		
		return courseId;
	}
	
	public void showCourseExistIdCourseListMessage(String objectName) {
		System.out.println("*****------------------*****");
        System.out.println("---The id of the course "+objectName+" is already assigned to another course---");
        System.out.println("*****------------------*****");
        
	}
	
	public String showAssignationCourseToStudent() {
		System.out.println("*****---Assign a Course to the Student---*****");
		System.out.println("Enter the id of the student, remember the structure of the id is (i.e E-1). Enter only the number");
		String studId = "E-"+myStudentId.next();
		
		return studId;
	}
	
	public String showAssignationCourseToStudentTwo() {
		System.out.println("*****---Assign a Course to the student---*****");
		System.out.println("Enter the id of the Course you want to assign to the student, remember the structure of the id is (i.e C-1). Enter only the number");
		String courseId = "C-"+myIdCourse.next();
		
		return courseId;
	}
	
	public String showSearchCourseOfStudent() {
		System.out.println("*****---Search the Course of the Student---*****");
		System.out.println("Enter the id of the student, remember the structure of the id is (i.e E-1). Enter only the number");
		String studId = "E-"+myStudentId.next();
		
		return studId;
	}
	
	public void showListMultipleCourMessage() {
		System.out.println("*****------------------*****");
        System.out.println("---This is the list of courses assigned to the student---");
        System.out.println("*****------------------*****");
	}
	
	public String showAssignationCourseToStudentFour() {
		System.out.println("*****---Assign a Course to the student---*****");
		System.out.println("Enter the id of the Course you want to assign to the student, remember the structure of the id is (i.e C-1).");
		System.out.println("You can add multiple courses to teh student adding & between each course id (i.e C-1&C-2)");
		System.out.println("REMEMBER IF YOU WANT TO ADD ADDITIONAL COURSES YOU NEED TO ADD IN THE LIST THE COURSES ID THE THE USER ALREADY HAS ASSIGNED");
		String courseId = myIdCourse.next();
		
		return courseId;
	}

}

package org.java.university.domain;

public class Course{

	private String nameCourse; // private = restricted access
	private String courseRoom;
	private String idCourse;
	
	
	public Course(String nameCourse, String courseRoom, String idCourse){
		this.nameCourse = nameCourse;
		this.courseRoom = courseRoom;
		this.idCourse = idCourse;
	}
	// Getter and setter name of the course
	
	public String getNameCourse() {
		return nameCourse;
	}
	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}
	
	// Getter and setter of the course room
	
	public String getCourseRoom() {
		return courseRoom;
	}
	public void setCourseRoom(String courseRoom) {
		this.courseRoom = courseRoom;
	}
	

	// Getter and setter of the course id
	public String getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(String idCourse) {
		this.idCourse = idCourse;
	}
	
	public String toString() {
		
		return "Name Course: "+this.nameCourse+" || Id Course: "+ this.idCourse+" || Course Room: "+this.courseRoom; 
	}
	
}

package org.java.university.domain;

public class Student extends Person{
	
	private int age; // private = restricted access
	
	public Student(String nameUser, String idPerson,String idCourse, int age) {
		super(nameUser,idPerson,idCourse);
		this.age=age;
	}

	// Getter and setter years of experience
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Name: "+this.getName()+" id Student: "+this.getIdUser()+" Age Student: "+this.age+" Id Course: "+this.getIdCourse();
	}
}
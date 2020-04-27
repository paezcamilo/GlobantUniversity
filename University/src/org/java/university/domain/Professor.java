package org.java.university.domain;

public class Professor extends Person {
	
	  private boolean typeOfContract; // private = restricted access
	  private int expYears; // private = restricted access
	  private double baseSalary; // private = restricted access
	  private int hourPerWeek;
	
	  public Professor(String nameUser, String idPerson,String idCourse,boolean typeOfContract,int expYears, double baseSalary,int hourPerWeek) {
		super(nameUser, idPerson,idCourse);
		this.typeOfContract = typeOfContract;
		this.expYears = expYears;
		this.baseSalary = baseSalary;
		this.setHourPerWeek(hourPerWeek);
	}
	  
	  // Getter and setter years of experience

	  public int getExpYears() {
		return expYears;
	  }
	  
	  public void setExpYears(int expYears) {
		this.expYears = expYears;
	  }

	  
	  // Getter and setter type of contract true for full time, false for hours
	  
	  public boolean isTypeOfContract() {
		return typeOfContract;
	  }

	  public void setTypeOfContract(boolean typeOfContract) {
		this.typeOfContract = typeOfContract;
	  }

	  
	  // Getter and setter hour per week
	  public int getHourPerWeek() {
		  return hourPerWeek;
	  }

	  public void setHourPerWeek(int hourPerWeek) {
		  this.hourPerWeek = hourPerWeek;
	  }
	  
	  // Getter and setter salary
	  public double getBaseSalary() {
		  return baseSalary;
	  }

	  public void setBaseSalary(int baseSalary) {
		  this.baseSalary = baseSalary;
	  }


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Type of Contract: "+this.typeOfContract+" || Experience in years: "+this.expYears+" || Salary: "+this.baseSalary+" || Name: "+this.getName()+" || Id Profesor: "+this.getIdUser()+" || id Course: "+this.getIdCourse();
	}


}

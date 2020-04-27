package org.java.university.domain;

public abstract class Person {
	  private String name; // private = restricted access
	  private String idUser; // private = restricted access
	  private String idCourse; // private = restricted access
	  
	  // Getter and setter name
	  public String getName() {
	    return name;
	  }


	  public void setName(String Name) {
	    this.name = Name;
	  }

	  
	  // Getter and setter name
	  public String getIdUser() {
		return idUser;
	  }
	
	  public void setIdUser(String newIdUser) {
		this.idUser = newIdUser;
	  }
	  
	  
	  // Getter and setter id of the course	  
	  
		public String getIdCourse() {
			return idCourse;
		}


		public void setIdCourse(String idCourse) {
			this.idCourse = idCourse;
		}

	  
	  public Person(String nameUser,String idPerson,String idCourse) {
		  
		  this.name = nameUser;
		  this.idUser = idPerson;
		  this.setIdCourse(idCourse);
	  }
	  
  
	  public abstract String toString();

}
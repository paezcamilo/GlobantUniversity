package org.java.university.users;

import java.util.ArrayList;

import org.java.university.domain.*;
import org.java.university.repository.RepositoryHandler;

public class ProfessorUserHandler {
	Professor profesorNew;
	ArrayList<Professor> professorList;
	
	public ProfessorUserHandler(){
		
	}
	
	public ArrayList<Professor> loadProfessorList() {
		
		RepositoryHandler repoHan = new RepositoryHandler();
		professorList = repoHan.loadProfessorList();
		
		return this.professorList;
		
	}
	
	public ArrayList<Professor> loadProfessorListByCourseId(ArrayList<Professor> arrProfessor,String idCourse) {
		
		ArrayList<Professor> professorListNew = new ArrayList<Professor>();
		
		int i = 0;
		while(i < arrProfessor.size()) {
			
			if (arrProfessor.get(i).getIdCourse().equals(idCourse))
				professorListNew.add(arrProfessor.get(i));
		i++;	
		} 
		return professorListNew;
	}
	
	public ArrayList<Professor> loadProfessorListByProfessorId(ArrayList<Professor> arrProfessor,String idProfessor) {
		
		ArrayList<Professor> professorListNew = new ArrayList<Professor>();
		
		int i = 0;
		while(i < arrProfessor.size()) {
			
			if (arrProfessor.get(i).getIdUser().equals(idProfessor))
				professorListNew.add(arrProfessor.get(i));
		i++;	
		} 
		return professorListNew;
	}
	
	public ArrayList<Professor> updateProfessorCourseIdByIdProf(ArrayList<Professor> arrProfessor,String idCourse,String idProfessor) {
		
		ArrayList<Professor> professorListNew = new ArrayList<Professor>();
		professorListNew = arrProfessor;
		
		
		int i = 0;
		while(i < professorListNew.size()) {
			
			if (professorListNew.get(i).getIdUser().equals(idProfessor)) {
				profesorNew = new Professor(professorListNew.get(i).getName(),professorListNew.get(i).getIdUser(),idCourse,professorListNew.get(i).isTypeOfContract(),professorListNew.get(i).getExpYears(),professorListNew.get(i).getBaseSalary(),professorListNew.get(i).getHourPerWeek());
				professorListNew.set(i,profesorNew);
				}
				
		i++;	
		} 
		RepositoryHandler newProf = new RepositoryHandler();
		newProf.updateProfessorArray(professorListNew);
		return professorListNew;
	}
}

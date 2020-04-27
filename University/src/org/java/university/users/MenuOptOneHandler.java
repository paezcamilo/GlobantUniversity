package org.java.university.users;

import java.util.ArrayList;

import org.java.university.domain.*;
import org.java.university.messages.MessageHandler;

public class MenuOptOneHandler {
	
	ArrayList<Professor> professorData;
	MessageHandler messHan = new MessageHandler();
	ProfessorUserHandler profData = new ProfessorUserHandler();
	
	public void menuOptionOne() {
		
		professorData = profData.loadProfessorList();
		
		messHan.showListMessage("Professors");
		
		int i = 0;
		while(i<professorData.size()) {

			System.out.println(professorData.get(i).toString());
			i++;
		}
		
	}

}

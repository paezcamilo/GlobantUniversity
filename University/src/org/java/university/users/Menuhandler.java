package org.java.university.users;

import org.java.university.messages.MessageHandler;

public class Menuhandler {
	
	MenuOptOneHandler menuOptOne = new MenuOptOneHandler();
	MenuOptTwoHandler subMenuTwo = new MenuOptTwoHandler();
	MenuOptThreeHandler menuThree = new MenuOptThreeHandler();
	MenuOptFourHandler menuFour = new MenuOptFourHandler();
	MenuOptFiveHandler menuFive = new MenuOptFiveHandler();
	StudentUserHandler studentNew = new StudentUserHandler();
	


	public void initialesearch() {
		
		
		
		boolean loop=true;
		while (loop==true) {
			MessageHandler messHan = new MessageHandler();
			int option = messHan.showInitialMessage();
				switch (option) {
				case 1:
					
					menuOptOne.menuOptionOne();
					
					break;

				case 2:
					
					subMenuTwo.optionTwoSubmenu();
					
					break;
					
				case 3:
					
					menuThree.loadMenuThree();
											
					break;
					
				case 4:
					
					menuFour.optionFourMenu();
					
					break;	

				case 5:
					
					menuFive.optionFiveMenu();
					
					break;
							
				default:
					
					loop=false;
					break;
				}
		}
	

	}
}

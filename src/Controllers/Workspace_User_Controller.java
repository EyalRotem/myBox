package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.MainClient;
import Entites.MessageObject;
import Gui.Workspace_User_Gui;

public class Workspace_User_Controller extends AbstractTransfer{
	
	private Workspace_User_Gui workSpaceGui;
	
	public Workspace_User_Controller (Workspace_User_Gui wug){
		
		this.workSpaceGui = wug;
		workSpaceGui.addlogoutActionLisetner(new LogoutLisetner());
	
		
	}
	
	 class LogoutLisetner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == workSpaceGui.getLogoutButton()) { //if the logout button pressed
				MessageObject message = new MessageObject(MainClient.clien.getCurrUser(), "updateStatus0");
				sendToServer(message);
				workSpaceGui.dispose();
			}
			
			
			
		}
		
		
		
	}

}

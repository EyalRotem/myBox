package Controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.ClientMain;
import Entites.MessageObject;
import Entites.User;
import Gui.serverLogGui;

public class ServerLogController extends AbstractTransfer{

	private serverLogGui svlogui;
	private ServerLogController TempController;
	public ServerLogController(serverLogGui svlogui) {

		TempController = this;
		this.svlogui = svlogui;
		svlogui.addDisconnectedBottonActionListener(new DisconnectedListener());
		
	}


	
	class DisconnectedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	public void SetLog(User usr, String Task) {

		if (Task.equals("login")) {
			svlogui.getTextArea().setForeground(Color.green);
			svlogui.getTextArea().append("User name:  " + usr.getUserName() +"(" + usr.getFirstName() + usr.getLastName() + ")"+ "has just logged in\n");
		}
		if (Task.equals("logout")) {
			svlogui.getTextArea().setForeground(Color.red);
			svlogui.getTextArea().append("User name:  " + usr.getUserName() +"(" + usr.getFirstName() + usr.getLastName() + ")"+ "has just logged out\n");

		}

	}
	
	public ServerLogController getTempController() {
		return TempController;
	}
}

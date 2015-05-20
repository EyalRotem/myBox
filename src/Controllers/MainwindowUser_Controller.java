package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.MainClient;
import Entites.MessageObject;
import Gui.MainwindowUser_Gui;
import Gui.WorkspaceGui;

public class MainwindowUser_Controller extends AbstractTransfer {

	private MainwindowUser_Gui mainwindow_gui;

	public MainwindowUser_Controller(MainwindowUser_Gui wug) {

		this.mainwindow_gui = wug;
		mainwindow_gui.addlogoutActionLisetner(new LogoutLisetner());
		mainwindow_gui.addWorkspaceActionLisetner(new WorkspaceListener());

	}

	class LogoutLisetner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {

			if (event.getSource() == mainwindow_gui.getLogoutButton()) { 
				MessageObject message = new MessageObject(
						MainClient.clien.getCurrUser(), "updateStatus0");
				sendToServer(message);
				mainwindow_gui.dispose();
			}
		}
	}

	class WorkspaceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			WorkspaceGui wsg = new WorkspaceGui();
			WorkspaceController wsc =new WorkspaceController(wsg);
			
			mainwindow_gui.dispose();
			

		}

	}

}

package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Client.ClientMain;
import Client.myBoxClient;
import Entites.ClientEntity;
import Entites.LoginEntity;
import Gui.ClientGui;
import Gui.LoginGui;

public class ClientController {

	private ClientGui clientGui;
	private ClientEntity clientEntity;

	/**
	 * constructor
	 * 
	 * @param clientGui
	 *            is gui that show the host and port
	 * @param clientEntity
	 *            is entity of client that include host and port
	 */

	public ClientController(ClientGui clientGui, ClientEntity clientEntity) {
		this.clientGui = clientGui;
		this.clientEntity = clientEntity;
		clientGui.addOKActionListener(new OKListener());
		clientGui.addCancelActionListener(new CancelListener());
	}

	public boolean checkInput() {
		try {
			if (clientGui.getHost().equals("") || clientGui.getPort() == 0) {
				clientGui
						.displayWarnningMessage("Please fill the empty blanks");
				clientGui.clearFields();
				return false;
			}
			return true;
		} catch (Exception e) {
			clientGui
					.displayWarnningMessage("Error: Use of illegal characters");
			return false;
		}
	}

	/**
	 * Inner class that handles when Button OK Pressed, implements
	 * ActiontListener
	 * 
	 * @author Niv
	 *
	 */
	class OKListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ev) {
			if (checkInput() == false)
				return;
			try {
				String host = new String(clientGui.getHost());
				int port = clientGui.getPort();
				clientEntity.setHost(host);
				clientEntity.setPort(port);
				ClientMain.clien = new myBoxClient(host, port); // singleton

				if (ClientMain.clien.isConnected()) {
					clientGui.dispose(); // remove the current window to display
											// login window


					// create a new login controller
					LoginGui loginGui = new LoginGui();
					LoginEntity loginEntity = new LoginEntity();
					LoginController loginController = new LoginController(loginGui, loginEntity);
					
				} else {
					clientGui.displayWarnningMessage("Faild to connect. check IP and port!");
					clientGui.clearFields();
				}

			} catch (NumberFormatException e) {
				clientGui
						.displayWarnningMessage("Faild to connect. check IP and port!");
				clientGui.clearFields();
				// e.printStackTrace();
			} catch (IOException e) {
				clientGui
						.displayWarnningMessage("Connection problem. check IP and Port.");
				// e.printStackTrace();
			}
		}
	}

	/**
	 * Inner class that handles when Button cancel Pressed, implements
	 * ActiontListener
	 * 
	 * @author Niv
	 *
	 */
	class CancelListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			clientGui.dispose();
			System.exit(1);
		}
	}
}
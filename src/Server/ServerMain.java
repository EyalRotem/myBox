package Server;

import Controllers.ServerController;
import Gui.ServerGui;
import Gui.serverLogGui;

/**
 * main class that start the server
 * 
 * @author Niv HAHOMO
 *
 */
public class ServerMain {

	public static void main(String[] args) {
		
		ServerGui serv = new ServerGui();
		ServerController servcon = new ServerController(serv);
	}

}
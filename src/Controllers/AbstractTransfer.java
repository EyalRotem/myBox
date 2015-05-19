package Controllers;

import java.io.IOException;

import Client.ClientMain;
import Gui.AbstractGui;

public abstract class AbstractTransfer {
	
	protected Object theEntity;
	protected AbstractGui theGui;

	public AbstractTransfer() {
	}

	public AbstractTransfer(AbstractGui theGui, Object theEntity) {
		this.theEntity = theEntity;
		this.theGui = theGui;
	}

	protected void sendToServer(String request) {
		try {
			ClientMain.clien.sendToServer(request);
		} catch (IOException e) {
			theGui.displayInfoMessage("Error: Server comunication problem",
					"Commuinication Error", 0);
			e.printStackTrace();
		}
	}

	public void sendToServer(Object request) {
		try {
			ClientMain.clien.sendToServer(request);
		} catch (IOException e) {
			theGui.displayInfoMessage("Error: Server comunication problem","Commuinication Error", 0);
			e.printStackTrace();
		}
	}

	public void handleDBResult(Object message) {
		//abstract implementation
	}

	public void UpdateDB() {
		//abstract implementation//
	}
}
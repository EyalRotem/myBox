// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package Client;

import Entites.User;
import ocsf.client.*;
import java.io.*;
import Controllers.*;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class myBoxClient extends ObservableClient {

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	
	private Object currController;
	private User currUser;

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host
	 *            The server to connect to.
	 * @param port
	 *            The port number to connect on.
	 * @param clientUI
	 *            The interface type variable.
	 */

	public myBoxClient(String host, int port) throws IOException {
		super(host, port); // Call the superclass constructor
		openConnection();
	}


	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg
	 *            The message from the server.
	 */
	public synchronized void handleMessageFromServer(Object message) {

		try {

			if (message instanceof User){ // user name and password is found ( 1.setCurrUser that is using application, 2.set status to 1)
				((LoginController) currController).handleDBResult(message);
			}
			
			if (message instanceof String) {

				if (((String) message).equals("UserNotfoundLogin")) {
					((LoginController) currController).getLoginGui().setWarningMessageVisibleTrue("Invalid email or password");
				}
				
				if (((String) message).equals("ForgotPassEmailNotFound")) {
					((ForgotPassController) currController).getFPGui().setWarningMessageVisibleTrue("Email does not Exist");
				}
				
				if (((String) message).equals("ForgotPassEmailFound")) {
					((ForgotPassController) currController).getFPGui().setWarningMessageVisibleTrue("Email exists, wait for confirmation");
				}
				
				if (((String) message).equals("SignUpEmailNotFound")) {
					((SignupControler) currController).handleDBResult(message);
				}
				
				if (((String) message).equals("SignUpEmailFound")) {
					((SignupControler) currController).getSignupGui().setWarningMessageVisibleTrue("Email allready Exists, please choose another one");
				}

				
			}// end if message is String

		} catch (Exception e) {
			System.out.println(e + "mybox client");
		}

		notify();
	}

	public Object getCurrObj() {
		return currController;
	}

	public void setCurrObj(Object currObj) {
		this.currController = currObj;
	}

	public User getCurrUser() {
		return currUser;
	}

	public void setCurrUser(User currUser) {
		this.currUser = currUser;
	}

	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}// End of myBoxClient

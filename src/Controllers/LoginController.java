package Controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Client.MainClient;
import Entites.*;
import Gui.*;

public class LoginController extends AbstractTransfer {

	private LoginGui loginGui;
	private LoginEntity loginEntity;
	private LoginController TempController;
	private User user;
	public LoginController lo = null;

	public LoginController(LoginGui lg, LoginEntity le) {

		loginGui = lg;
		loginEntity = le;
		TempController = this;
		loginGui.addSignUpActionListener(new SignUpListener());
		loginGui.addLoginActionListener(new LoginListener());
		loginGui.addforgotPasswordListenerMouse(new forgotPassListenerMouse());

	}

	/**
	 * Inner class that handles when Button login Pressed, implements
	 * ActiontListener
	 * 
	 * @author Niv
	 *
	 */
	
	class LoginListener implements ActionListener {

		public void actionPerformed(ActionEvent ev) {

			String pass = loginGui.getTextPassword();
			String user = loginGui.getTextUserName();

			if (pass.equals("") || user.equals("")) 
				loginGui.setWarningMessageVisibleTrue("Please fill the empty blanks");
			else {
				try { // set the user name and password and sent to server
					loginGui.undisplayWarningMessage();
					loginEntity.setPassword(pass);
					loginEntity.setUserName(user);
					MessageObject msg = new MessageObject(loginEntity,"searchLogin");
					sendToServer(msg);
					MainClient.clien.setCurrObj(getTempController());
				} catch (Exception e) {
					System.out.println("logincontroller");
				}
			}
		}
	}

	public void handleDBResult(Object message) {

		user = (User) message;
		if (user.getStatus() == 1)
			loginGui.setWarningMessageVisibleTrue("This username has already logged to system.");
		else {
			MainClient.clien.setCurrUser(user);
			UpdateDB(); // update the status to 1 that we know user is logged to the system
			loginGui.dispose(); // - - > LEAVE LOGIN FRAME

			if(user.getPrivilege ()==0){ //open user gui
				
				MainwindowUser_Gui workspaceg = new MainwindowUser_Gui();
				MainwindowUser_Controller workspacec = new MainwindowUser_Controller(workspaceg);
				
			}
			else if(user.getPrivilege() == 1){	//open system manager gui
			
			//	Workspace_SysManager_Gui workspaceg = new Workspace_SysManager_Gui();
			//	Workspace_SysManager_Controller workspacec = new Workspace_SysManager_Gui();
				
			}
				
			// start main window
			// start main window
			// start main window
			// start main window
			// start main window
			// start main window
		}
	}

	public void UpdateDB() {
		MessageObject msg = new MessageObject(user, "updateStatus1");
		sendToServer(msg);
	}


	class forgotPassListenerMouse implements MouseListener {

		private Color hoverColor = new Color(255, 0, 128);
		private Color standardColor = new Color(0, 128, 0);

		@Override
		public void mouseClicked(MouseEvent e) {
			//
			ForgotPassGui fpg = new ForgotPassGui();
			ForgotPassController fpc = new ForgotPassController(fpg);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			loginGui.fplbl.setForeground(hoverColor);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			loginGui.fplbl.setForeground(standardColor);
		}
	}

	class SignUpListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ev) {

			SignUpGui  sug = new SignUpGui();
			SignupControler sugc = new SignupControler(sug);
		}
	}

	public LoginGui getLoginGui() {
		return loginGui;
	}

	public LoginController getTempController() {
		return TempController;
	}

}
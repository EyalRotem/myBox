package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.*;
import Client.MainClient;
import Entites.*;

public class SignupControler extends AbstractTransfer {
	
	
	private SignUpGui SignupGui;
	private SignupControler TempController;
	private User uentity;
	private boolean Flag=true; //flag for the manager to choose if true/flase.
	public SignupControler(SignUpGui sug){
		
	this.SignupGui = sug;
	TempController = this;
	SignupGui.addreturnActionListener(new ReturnListener());
	SignupGui.addfinishActionListener(new FinishListener());
	
	}
	
	class FinishListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		String user,pass,first,last;
		user  = SignupGui.getTextUserName();
		pass  = SignupGui.getTextPassword();
		first = SignupGui.getTextFirstname();
		last  = SignupGui.getTextLastname();
		
		
			if (pass.equals("") || user.equals("") ||first.equals("") || last.equals("")) 
				SignupGui.setWarningMessageVisibleTrue("Please fill the empty blanks");
			else if(pass.length() < 5)
				SignupGui.setWarningMessageVisibleTrue("Please choose a password with more than 4 letters");
			else // checkif user exists.
			{
				uentity = new User(user,pass,first,last,0,0);
				System.out.println(user + pass+  first+ last);
				MessageObject msg = new MessageObject(uentity,"CheckEmailValidity");
				MainClient.clien.setCurrObj(getTempController());
				sendToServer(msg);
			}
			
			
			
		}
	}


	class ReturnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
		
			getSignupGui().dispose();
		}
	}
	
	public void handleDBResult(Object message) {

			MessageObject msg = new MessageObject(uentity,"Signuphim");
			sendToServer(msg);
			SignupGui.setWarningMessageVisibleTrue("Welcome to my box you are now able to login.");

	}
	
	public Object getTempController() {
		return TempController;
	}
	public SignUpGui getSignupGui() {
		return SignupGui;
	}
	
}



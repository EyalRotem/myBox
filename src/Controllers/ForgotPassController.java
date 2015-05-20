package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.MainClient;
import Entites.ForgotPassEntity;
import Entites.MessageObject;
import Gui.ForgotPassGui;

public class ForgotPassController extends AbstractTransfer {

	private ForgotPassGui fpGui;
	private ForgotPassEntity fpEntity;
	private ForgotPassController TempController;
	private String user;
	private String usersentallready=null;

	
	public ForgotPassController(ForgotPassGui fpg) {
		
		TempController=this;
		fpGui = fpg;
		fpGui.addsubmitActionListener(new Submit());
		fpGui.addreturnActionListener(new ReturnListener());
	}
	
	
	
	class Submit implements ActionListener {

		public void actionPerformed(ActionEvent ev) {
		
			 user = fpGui.getTextUserName();
			
			if (user.equals("")) 
				fpGui.setWarningMessageVisibleTrue("Please fill the empty blank");
			
			else {
				MessageObject msg = new MessageObject(user,"ForgotPassEmail");
				MainClient.clien.setCurrObj(getTempController());
				sendToServer(msg);
			}
		}
	}

	class ReturnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
		
			getFPGui().dispose();
		}
	}
	
	public void handleDBResult(Object message) {
		
		//

	}
	
	public Object getTempController() {
		return TempController;
	}
	public ForgotPassGui getFPGui() {
		return fpGui;
	}

}
package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.ClientMain;
import Entites.ForgotPassEntity;
import Entites.MessageObject;
import Gui.ForgotPassGui;

public class ForgotPassController extends AbstractTransfer {

	private ForgotPassGui fpGui;
	private ForgotPassEntity fpEntity;
	private ForgotPassController TempController;

	public ForgotPassController(ForgotPassGui fpg) {
		
		TempController=this;
		fpGui = fpg;
		fpGui.addsubmitActionListener(new Submit());
		fpGui.addreturnActionListener(new ReturnListener());
	}
	
	
	
	class Submit implements ActionListener {

		public void actionPerformed(ActionEvent ev) {
		
			String user = fpGui.getTextUserName();
			
			if (user.equals("")) 
				fpGui.setWarningMessageVisibleTrue("Please fill the empty blank");
			else
			{
				MessageObject msg = new MessageObject(user,"ForgotPassEmail");
				ClientMain.clien.setCurrObj(getTempController());
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
		
		if(message.equals("EmailFound"))    //SEND CONFIRMATION TO SYS MANAGER
				{
			System.out.println("UserName: <" + fpGui.getTextUserName() + "> has reset password" );
			
				}
			

	}
	
	public Object getTempController() {
		return TempController;
	}
	public ForgotPassGui getFPGui() {
		return fpGui;
	}

}
package Gui;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Workspace_User_Gui extends JFrame{
	
	private JButton jblogout = null;
	
	public Workspace_User_Gui(){
			
		getContentPane().setLayout(null);
		getContentPane().add(getLogoutButton());
		this.setTitle("User Workpace");
		this.setBounds(500, 500, 800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	public JButton getLogoutButton() {
		if (jblogout == null) {
			jblogout = new JButton("Logout");
			jblogout.setBounds(670, 10, 100, 30);
			jblogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jblogout;
	}
	
	public void addlogoutActionLisetner(ActionListener lis){
		jblogout.addActionListener(lis);
	}

}

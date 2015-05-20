package Gui;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainwindowUser_Gui extends JFrame{
	
	private JButton jblogout = null;
	private JButton jbworkspace = null;
	
	
	public MainwindowUser_Gui(){
			
	
		getContentPane().setLayout(null);
		getContentPane().add(getLogoutButton());
		getContentPane().add(getWorkSpaceButton());
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
	
	public JButton getWorkSpaceButton() {
		if (jbworkspace == null) {
			jbworkspace = new JButton("Workspace");
			jbworkspace.setBounds(570, 10, 100, 30);
			jbworkspace.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jbworkspace;
	}
	
	
	public void addWorkspaceActionLisetner(ActionListener lis){
		jbworkspace.addActionListener(lis);
	}

	
	public void addlogoutActionLisetner(ActionListener lis){
		jblogout.addActionListener(lis);
	}

}

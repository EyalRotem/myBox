package Gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SignUpGui extends JFrame {

	/** all buttons labels and text fields */

	private JButton jbfinish = null;
	private JButton jbreturn = null;
	private JTextField tfUserName;
	private JTextField tfPassword;
	private JTextField tfFirstname;
	private JTextField tfLastname;
	private JLabel lblinsertinstuction = null;
	private JLabel lblUserName = null;
	private JLabel lblPassword = null;
	private JLabel lblFirstname = null;
	private JLabel lblLastname = null;	
	private JLabel lblwarningMessage = null;
	private Font myFont;


	public SignUpGui() {


		myFont = new Font("Serif", Font.BOLD, 17);
		getContentPane().setLayout(null);
		getContentPane().add(getLblwarningMessage());
		getContentPane().add(getReturnButton());
		getContentPane().add(getFinishButton());
		getContentPane().add(getLblinsertinstuction());
		getContentPane().add(getLblUsername());
		getContentPane().add(getLblPassword());
		getContentPane().add(getLblFirstname());
		getContentPane().add(getLblLastname());
		getContentPane().add(getTextFieldUser());
		getContentPane().add(getTextFieldPassword());
		getContentPane().add(getTextFieldFirstname());
		getContentPane().add(getTextFieldLastname());
		this.setTitle("Signup window");
		this.setBounds(500, 200, 500, 350);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

	}

	/***************************************** Getters for Button *****************************/

	
	public JButton getFinishButton() {
		if (jbfinish == null) {
			jbfinish = new JButton("Finish");
			jbfinish.setBounds(130, 220, 100, 30);
			jbfinish.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jbfinish;
	}

	public JButton getReturnButton() {
		if (jbreturn == null) {
			jbreturn = new JButton("Return");
			jbreturn.setBounds(250, 220, 100, 30);
			jbreturn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jbreturn;
	}
	
	/***************************************** Getters for Labeles *****************************/
	
	public JLabel getLblinsertinstuction() {
		if (lblinsertinstuction == null) {
			lblinsertinstuction = new JLabel("Please fill in the following blanks:");
			lblinsertinstuction.setBounds(100, 10, 300, 30);
			lblinsertinstuction.setFont(myFont);
		}
		return lblinsertinstuction;
	}
	
	public JLabel getLblUsername() {
		if (lblUserName == null) {
			lblUserName = new JLabel("Username/Email:");
			lblUserName.setBounds(10, 50, 140, 30);
			lblUserName.setFont(myFont);
		}
		return lblUserName;
	}
	
	public JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password :");
			lblPassword.setBounds(10, 80, 140, 30);
			lblPassword.setFont(myFont);
		}
		return lblPassword;
	}
	
	public JLabel getLblFirstname() {
		if (lblFirstname == null) {
			lblFirstname = new JLabel("Firstname:");
			lblFirstname.setBounds(10, 110, 140, 30);
			lblFirstname.setFont(myFont);
		}
		return lblFirstname;
	}

	public JLabel getLblLastname() {
		if (lblLastname == null) {
			lblLastname = new JLabel("Lastname:");
			lblLastname.setBounds(10, 140, 140, 30);
			lblLastname.setFont(myFont);
		}
		return lblLastname;
	}
	
	/**************************************** Getters for JTextField ******************************/

	public JTextField getTextFieldUser() {
		if (tfUserName == null) {
			tfUserName = new JTextField();
			tfUserName.setBounds(160, 55, 200, 20);
		}
		return tfUserName;
	}
	
	private JTextField getTextFieldPassword() {
		
		if (tfPassword == null) {
			tfPassword = new JTextField();
			tfPassword.setBounds(160, 85, 200, 20);
		}
		return tfPassword;	
	}
	
	private JTextField getTextFieldFirstname() {
		if (tfFirstname == null) {
			tfFirstname = new JTextField();
			tfFirstname.setBounds(160, 115, 200, 20);
		}
		return tfFirstname;
	}

	private JTextField getTextFieldLastname() {
		if (tfLastname == null) {
			tfLastname = new JTextField();
			tfLastname.setBounds(160, 145, 200, 20);
			tfLastname.setColumns(10);
		}
		return tfLastname;
	}



	/**************************************** Getters and Setters for action listeners ******************************/
	
	public void addfinishActionListener(ActionListener listener) {
		jbfinish.addActionListener(listener);
	}

	public void addreturnActionListener(ActionListener listener) {
		jbreturn.addActionListener(listener);
	}

	
	/**************************************** Getters and Setters for messages ******************************/
	public JLabel getLblwarningMessage() {
		if (lblwarningMessage == null) {
			lblwarningMessage = new JLabel("Invalid email or password");
			lblwarningMessage.setForeground(Color.RED);
			lblwarningMessage.setBounds(10, 180, 400, 30);
			lblwarningMessage.setVisible(false);
		}
		return lblwarningMessage;
	}

	public void undisplayWarningMessage() {
		lblwarningMessage.setVisible(false);
	}
	public void setWarningMessageVisibleTrue() {
		lblwarningMessage.setVisible(true);
	}

	public void setWarningMessageVisibleTrue(String st) {
		lblwarningMessage.setText(st);
		lblwarningMessage.setForeground(Color.RED);
		lblwarningMessage.setBounds(10, 180, 400, 30);
		lblwarningMessage.setVisible(true);
	}


	/**************************************** get the texts from Textfields ******************************/
	public String getTextUserName() {
		return tfUserName.getText();
	}
	public String getTextPassword() {
		return tfPassword.getText();
	}
	public String getTextFirstname() {
		return tfFirstname.getText();
	}
	public String getTextLastname() {
		return tfLastname.getText();
	}

}

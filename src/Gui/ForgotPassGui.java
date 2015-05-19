package Gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ForgotPassGui extends JFrame {

	/** all buttons labels and text fields */
	private JButton submit = null;
	private JButton jbreturn = null;
	private JLabel lblUserName = null;
	private JLabel lblwarningMessage = null;
	private JTextField textField;
	private Font myFont;

	public ForgotPassGui() {

		//setContentPane(new JLabel(new ImageIcon("C:\\workspace\\myBox\\bg.jpg")));
		myFont = new Font("Serif", Font.BOLD, 17);
		getContentPane().setLayout(null);
		getContentPane().add(getSubmitButton());
		getContentPane().add(getReturnButton());		
		getContentPane().add(getLblwarningMessage());
		getContentPane().add(getLblUserName());
		getContentPane().add(getTextFieldUser());
		this.setTitle("Forgot your password?");
		this.setBounds(500, 200, 500, 350);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	/***************************************** Getters and Setters of Label, Button,TextField *****************************/

	public JLabel getLblwarningMessage() {
		if (lblwarningMessage == null) {
			lblwarningMessage = new JLabel();
			lblwarningMessage.setForeground(Color.RED);
			lblwarningMessage.setBounds(20, 140, 260, 30);
			lblwarningMessage.setVisible(false);
		}
		return lblwarningMessage;
	}

	public void setWarningMessageVisibleTrue() {
		lblwarningMessage.setVisible(true);
	}

	public void setWarningMessageVisibleTrue(String st) {
		lblwarningMessage.setText(st);
		lblwarningMessage.setForeground(Color.RED);
		lblwarningMessage.setBounds(20, 140, 260, 30);
		lblwarningMessage.setVisible(true);
	}

	public JButton getSubmitButton() {
		if (submit == null) {
			submit = new JButton("Submit");
			submit.setBounds(230, 180, 100, 30);
			submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return submit;
	}
	public JButton getReturnButton() {
		if (jbreturn == null) {
			jbreturn = new JButton("Return");
			jbreturn.setBounds(350, 180, 100, 30);
			jbreturn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return jbreturn;
	}
	
	

	public JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel(
					"Enter your email address to reset your password.");
			lblUserName.setBounds(40, 50, 450, 40);
			lblUserName.setFont(myFont);
		}
		return lblUserName;
	}

	public JTextField getTextFieldUser() {
		if (textField == null) {
			textField = new JTextField("Email/Username");
			textField.setBounds(20, 100, 400, 35);

		}
		return textField;
	}

	public void ClearText() {
		textField.setText("");
	}

	public String getTextUserName() {
		return textField.getText();
	}

	public void addsubmitActionListener(ActionListener listener) {
		submit.addActionListener(listener);
	}

	public void undisplayWarningMessage() {
		lblwarningMessage.setVisible(false);
	}

	public void addreturnActionListener(ActionListener listener) {
		jbreturn.addActionListener(listener);
	}

}

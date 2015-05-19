package Gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LoginGui extends JFrame {

	/** all buttons labels and text fields */
	public JTextField fplbl;
	private JButton loginBut = null;
	private JButton signupBut = null;
	private JButton fpBut = null;
	private JLabel lblUserName = null;
	private JLabel lblwarningMessage = null;
	private JLabel lblLoginshow = null;
	private JLabel lblPassword = null;
	private JTextField textField;
	private JPasswordField passfield;
	private Font myFont, loginlb, fpfont;
	private Border standardBorder;

	/**
	 * login gui Constructor this constructor add all the Label,
	 * Button,TextField on the Frame
	 */
	public LoginGui() {

		
		setContentPane(new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/bglogin.png")))));
		myFont = new Font("Serif", Font.BOLD, 17);
		fpfont = new Font("Stencil", Font.ITALIC, 15);
		loginlb = new Font("Stencil", Font.ITALIC, 30);
		getContentPane().setLayout(null);
		getContentPane().add(getLogin());
		getContentPane().add(getSignup());
		getContentPane().add(ForgotPassword());
		getContentPane().add(getLblwarningMessage());
		getContentPane().add(getLblUserName());
		getContentPane().add(getLblPassword());
		getContentPane().add(getTextFieldUser());
		getContentPane().add(getTextFieldPass());
		this.setTitle("Login window");
		this.setBounds(500, 200, 500, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);

	}

	/***************************************** Getters and Setters of Label, Button,TextField *****************************/

	public JTextField ForgotPassword() {
		if (fpBut == null) {
			fplbl = new JTextField("forogt your password?");
			fplbl.setFont(fpfont);
			fplbl.setBounds(150, 250, 200, 50);
			fplbl.setEditable(false);
			fplbl.setForeground(new Color(0, 128, 0));
			fplbl.setBorder(standardBorder);
			fplbl.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return fplbl;
	}

	public JLabel getLblwarningMessage() {
		if (lblwarningMessage == null) {
			lblwarningMessage = new JLabel();
			lblwarningMessage.setForeground(Color.RED);
			lblwarningMessage.setBounds(10, 170, 260, 30);
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
		lblwarningMessage.setBounds(10, 170, 260, 30);
		lblwarningMessage.setVisible(true);
	}

	public JLabel getLblLog() {
		if (lblLoginshow == null) {
			lblLoginshow = new JLabel("Welcome to MyBox");
			lblLoginshow.setBounds(100, 7, 280, 60);
			lblLoginshow.setHorizontalAlignment(SwingConstants.CENTER);
			lblLoginshow.setFont(loginlb);

		}
		return lblLoginshow;
	}

	public JButton getLogin() {
		if (loginBut == null) {
			loginBut = new JButton("Login");
			loginBut.setBounds(130, 220, 100, 30);
			loginBut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return loginBut;
	}

	public JButton getSignup() {
		if (signupBut == null) {
			signupBut = new JButton("Sign Up");
			signupBut.setBounds(250, 220, 100, 30);
			signupBut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		return signupBut;
	}

	public JLabel getLblUserName() {
		if (lblUserName == null) {
			lblUserName = new JLabel("User name/E-mail:");
			lblUserName.setBounds(15, 100, 200, 20);
			lblUserName.setFont(myFont);
		}
		return lblUserName;
	}

	public JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password :");
			lblPassword.setBounds(75, 140, 90, 20);
			lblPassword.setFont(myFont);
		}
		return lblPassword;
	}

	public JTextField getTextFieldUser() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(200, 100, 190, 20);
			textField.setColumns(10);
		}
		return textField;
	}

	public JPasswordField getTextFieldPass() {
		if (passfield == null) {
			passfield = new JPasswordField();
			passfield.setBounds(200, 140, 190, 20);
			passfield.setColumns(10);
		}
		return passfield;
	}

	public void ClearText() {
		textField.setText("");
		passfield.setText("");
	}

	public void addLoginActionListener(ActionListener listener) {
		loginBut.addActionListener(listener);
	}

	public void addSignUpActionListener(ActionListener listener) {
		signupBut.addActionListener(listener);
	}

	public void addforgotPasswordListenerMouse(MouseListener listener) {
		fplbl.addMouseListener(listener);
	}

	public void undisplayWarningMessage() {
		lblwarningMessage.setVisible(false);
	}

	/**************************************** get the texts from Textfields ******************************/
	public String getTextUserName() {
		return textField.getText();
	}

	public String getTextPassword() {
		String str = new String(passfield.getPassword());
		return str;
	}

}

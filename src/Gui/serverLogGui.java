package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class serverLogGui extends JFrame {
	/** all the buttons, labels, panels and text fields */
	private JPanel LoggingUsers = null;
	private JScrollPane scroller = null;
	private JTextArea textArea = null;
	private Font myFont;
	private String textDetail = "";
	protected JButton backButton = null;

	/**
	 * constructor this constructor create new instance of panel
	 */
	public serverLogGui() {
		super();
		LoggingUsers = new JPanel();
		initReport();
	}

	/**
	 * Initialize report log
	 */
	public void initReport() {
		textArea = new JTextArea("Server log", 23, 38);
		textArea.setFont(myFont = new Font("Serif", Font.BOLD, 15));
		textArea.setEditable(false);
		setTitle(" Server log ");
		// setBounds(150, 150, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 550);
		setContentPane(getLoggingUsers());

	}


	public JPanel getLoggingUsers() {
		setLayout(null);
		textArea.setText(textDetail);
		if (scroller == null) {
			scroller = new JScrollPane(textArea);
			LoggingUsers.add(scroller);
			LoggingUsers.add(getBackB());
			LoggingUsers.setBackground(Color.lightGray);
		}
		setSize(500, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		return LoggingUsers;
	}

	/***************************************** Getters and Setters of Label, Button,TextField and panel *****************************/
	public JButton getBackB() {
		if (backButton == null) {
			backButton = new JButton("Logout");
			backButton.setBounds(80, 300, 80, 20);
		}
		return backButton;
	}

	public void setLoggingUsers(JPanel LoggingUsers) {
		this.LoggingUsers = LoggingUsers;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public String getStr() {
		return textDetail;
	}

	public void setStr(String str) {
		this.textDetail = str;
	}

	public JScrollPane getScroller() {
		return scroller;
	}

	public void addDisconnectedBottonActionListener(ActionListener listener) {
		backButton.addActionListener(listener);

	}

}
package Gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JInternalFrame;


public class WorkspaceGui extends JFrame{


	public JInternalFrame internalFrame_1;
	
	private Icon AddImag;
	private Icon SearchImag;
	private Icon ModifyImag;
	private Icon RemoveImag;
	private Icon ReadImag;
	private Icon ReturnImag;
	
	private JButton btnSearch;
	private JButton btnReturn;
	private JButton btnRead;
	private JButton btnUpdate;
	private JButton btnRemove;
	private JButton btnAdd;
	
	

	public WorkspaceGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 726, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		SearchImag = new ImageIcon("icons/Search.png");
		ModifyImag = new ImageIcon("icons/Modify.png");
		RemoveImag = new ImageIcon("icons/Remove.png");
		ReadImag = 	 new ImageIcon("icons/Borrow.png");
		ReturnImag = new ImageIcon("icons/Return.png");
		getContentPane().setLayout(null);
		getContentPane().add(getAddButton());
		getContentPane().add(getRemoveButton());
		getContentPane().add(getUpdateButton());
		getContentPane().add(getReadButton());
		getContentPane().add(getSearchButton());
		getContentPane().add(getReturnButton());
		getContentPane().add(getInternalFrame());

		
		setVisible(true);

	}
	
	private Component getInternalFrame() {
		
	 
	 ImageIcon i1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/dir.jpg")));	
	 
	 JButton btndirectory = new JButton(i1);
	 btndirectory.setBounds(20, 20, 100,30 );
	 

	 btndirectory. setAlignmentY(CENTER_ALIGNMENT);
	 
		internalFrame_1 = new JInternalFrame("Directories");
		internalFrame_1.getContentPane().setLayout(null);
		internalFrame_1.setBounds(0, 28, 710, 307);
		
		internalFrame_1.setVisible(true);
		internalFrame_1.getContentPane().add(btndirectory);
		internalFrame_1.getContentPane().setLayout(null);
		
		
		
		return internalFrame_1;
	}

	

	private Component getAddButton() {
		btnAdd = new JButton("Add", AddImag);
		btnAdd.setBounds(0, 0, 100,30 );
		return btnAdd;
	}

	private Component getRemoveButton() {
		btnRemove = new JButton("Remove", RemoveImag);
		btnRemove.setBounds(100, 0, 100, 30);
		return btnRemove;
	}
	
	private Component getUpdateButton() {
		btnUpdate = new JButton("Update", ModifyImag);
		btnUpdate.setBounds(200, 0,100, 30);
		return btnUpdate;
	}

	private Component getSearchButton() {
		btnSearch = new JButton("Search", SearchImag);
		btnSearch.setBounds(300, 0,100, 30);
		return btnSearch;
	}

	private Component getReadButton() {
		btnRead = new JButton("Read", ReadImag);
		btnRead.setBounds(400, 0,100, 30);
		return btnRead;
	}

	private Component getReturnButton() {
		btnReturn = new JButton("Return", ReturnImag);
		btnReturn.setBounds(300, 0,100, 30);
		return btnReturn;
	}
	
	
	
}

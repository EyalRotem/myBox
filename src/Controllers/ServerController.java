package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import Gui.ServerGui;
import Gui.serverLogGui;
import Server.myBoxServer;

public class ServerController {

	private ServerGui SerGui;
	private ServerController temp;
	private Connection conn;
	private String userName = "Niv";
	private String PasswordServer = "12345";
	private String Defport = "5555";
	private int port = 0;
	private String Scheam = "jdbc:mysql://localhost/mybox";
	private myBoxServer sv;

	public ServerController(ServerGui SerGui) {
		
		this.SerGui = SerGui;
		temp = this;
		SerGui.setTextFieldPass(PasswordServer);
		SerGui.setTextFieldUser(userName);
		SerGui.setTextFieldPort(Defport);
		SerGui.setTextFieldscheam(Scheam);
		SerGui.addLoginActionListener(new LoginListener());
	}

	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			userName = SerGui.getTextUserName();
			PasswordServer = SerGui.getTextPassword();
			Defport = SerGui.getTextPort();
			port = Integer.parseInt(Defport);
			Scheam = SerGui.getTextScheam();

			if (openConnectionDB()) {
				sv = new myBoxServer(port);
				sv.setConn(conn);

				try {
					sv.listen(); // Start listening for connections
					SerGui.dispose();
					serverLogGui servlog = new serverLogGui();
					ServerLogController serverlogc =new ServerLogController(servlog);
					sv.SetServerLogController(serverlogc);
					
					//--------when initializing the server set status0----------
						PreparedStatement ps;
						String query = "UPDATE user SET user.status = ? ";
						ps = (PreparedStatement) conn.prepareStatement(query);
						ps.setInt(1, 0);
						ps.executeUpdate();
						//--------when initializing the server set status0----------

				} catch (Exception ex) {
					SerGui.setWarningMessageVisibleTrue("ERROR - Could not listen for clients!");
				}
			}
		}
	}


	public boolean openConnectionDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {/* handle the error */
		}

		try {
			conn = DriverManager.getConnection(Scheam, userName, PasswordServer);
			System.out.println("SQL connection succeed");
			return true;
		} catch (SQLException ex) {/* handle any errors */
			SerGui.setWarningMessageVisibleTrue("SQLException: "+ ex.getMessage());
			SerGui.setWarningMessageVisibleTrue("SQLState: "+ ex.getSQLState());
			SerGui.setWarningMessageVisibleTrue("VendorError: "+ ex.getErrorCode());
			return false;
		}
	}
	

	class DisconnectedListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}
	}

	/************************************************ Getters and setters ***************************************/
	public ServerGui getSerGui() {
		return SerGui;
	}

	public void setSerGui(ServerGui SerGui) {
		this.SerGui = SerGui;
	}

	public void setPasswordServer(String PasswordServer) {
		this.PasswordServer = PasswordServer;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
package Server;

import java.sql.SQLException;
import Controllers.ServerLogController;
import Entites.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import ocsf.server.*;

public class myBoxServer extends AbstractServer {

	private Connection conn;
	private ServerLogController servcontroller;
	public ResultSet rs;
	final public static int DEFAULT_PORT = 5555;

	public myBoxServer(int port) {
		super(port);
	}

	protected void serverStarted(){ // INIT MYSQL CONNECTION AND THE SERVER
	
		System.out.println("Server listening for connections on port "
				+ getPort());
	}

	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setConn(java.sql.Connection conn) {
		this.conn = (Connection) conn;
	}

	public void SetServerLogController(ServerLogController servc) {
		this.servcontroller = servc;
	}

	public void handleMessageFromClient(Object msg, ConnectionToClient client) { // CHECK
																					// ALL
																					// INFO
																					// FROM
																					// CLIENT

		Statement stmt;
		User user = null;

		try {
			stmt = (Statement) conn.createStatement();
			PreparedStatement ps;

			if (msg instanceof String) {

				//

			}

			if (msg instanceof MessageObject) {

				MessageObject msgObject = (MessageObject) msg;

				if (msgObject.getTask().equals("searchLogin")) { // search user
																	// in data
																	// base -- >
																	// Login
					int flag = 0;
					String query = "SELECT * FROM user WHERE user.Username= '"
							+ ((LoginEntity) msgObject.getObject())
									.getUserName()
							+ "' AND user.Password='"
							+ ((LoginEntity) msgObject.getObject())
									.getPassword() + "'";
					rs = (ResultSet) stmt.executeQuery(query);
					while (rs.next()) {
						flag++;
						user = new User(rs.getString(1), rs.getString(2),
								rs.getString(3), rs.getString(4), rs.getInt(5),
								rs.getInt(6));
					}
					if (flag == 1)
						client.sendToClient(user);
					else
						client.sendToClient("UserNotfoundLogin");
				}// searchLogin

				/*--------------------------------------------------------------------------*/

				if (msgObject.getTask().equals("Signuphim")) { // new user
					user = (User) msgObject.getObject();
					String query = "INSERT INTO user (Username,Password,Firstname,Lastname,status,Privilege) VALUES (?, ?, ?, ?, '0','0');";
					ps = (PreparedStatement) conn.prepareStatement(query);
					ps.setString(1, user.getUserName());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getFirstName());
					ps.setString(4, user.getLastName());
					ps.executeUpdate();
					client.sendToClient("UserHasBeenUpdated");
					servcontroller.SetLog(user, "signup");
				}// Signuphim

				/*--------------------------------------------------------------------------*/

				if (msgObject.getTask().equals("updateStatus1")) {
					String query = "UPDATE user SET user.status = ? WHERE user.Username = ?";
					ps = (PreparedStatement) conn.prepareStatement(query);
					ps.setInt(1, 1);
					ps.setString(2,
							((User) msgObject.getObject()).getUserName());
					ps.executeUpdate();
					servcontroller
							.SetLog((User) msgObject.getObject(), "login"); // update
																			// the
																			// login
																			// serverLogGui
				}// updateStatus1

				/*--------------------------------------------------------------------------*/

				if (msgObject.getTask().equals("updateStatus0")) { // update
																	// status to
																	// 0 (User
																	// has
																	// logged
																	// out)
					String query = "UPDATE user SET user.status = ? WHERE user.Username = ?";
					ps = (PreparedStatement) conn.prepareStatement(query);
					ps.setInt(1, 0);
					ps.setString(2,
							((User) msgObject.getObject()).getUserName());
					ps.executeUpdate();
					servcontroller.SetLog((User) msgObject.getObject(),
							"logout");
				}// updateStatus0

				/*--------------------------------------------------------------------------*/

				stmt = (Statement) conn.createStatement();
				if (msgObject.getTask().equals("ForgotPassEmail")) {
					String query = "SELECT * FROM user WHERE user.Username= '"
							+ msgObject.getObject() + "'";
					rs = (ResultSet) stmt.executeQuery(query);
					if (rs.next())
						client.sendToClient("ForgotPassEmailFound");
					else {
						client.sendToClient("ForgotPassEmailNotFound");
					}
				}// Email validity -> forgotpass

				/*--------------------------------------------------------------------------*/

				if (msgObject.getTask().equals("CheckEmailValidity")) {

					String query = "SELECT * FROM user WHERE user.Username= '"
							+ ((User) msgObject.getObject()).getUserName()
							+ "'";
					rs = (ResultSet) stmt.executeQuery(query);
					if (rs.next())
						client.sendToClient("SignUpEmailFound");
					else
						client.sendToClient("SignUpEmailNotFound");
				}// Email validity -> signup

				/*--------------------------------------------------------------------------*/
				
				
				
			}// end if msg instanceof MessageObject
		} catch (Exception e) {
			System.err.println(e + " BigtryCatch - Echoserver");
		}

		System.out.println("Message received: " + msg + " from " + client);

		if (msg instanceof MessageObject) {

			MessageObject msgObject = (MessageObject) msg;
			System.out.println("Message received: " + msgObject.getObject()+ " from " + client);
		}

		this.sendToAllClients(msg);
	}
}// End of EchoServer class


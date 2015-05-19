package Server;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 


import java.sql.SQLException;

import Controllers.ServerLogController;
import Entites.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class myBoxServer extends AbstractServer {
	// Class variables *************************************************
	private Connection conn;
	private ServerLogController controller;
	public ResultSet rs;
	/**
	 * The default port to listen on.
	 */
	final public static int DEFAULT_PORT = 5555;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port
	 *            The port number to connect on.
	 */
	public myBoxServer(int port) {
		super(port);
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg
	 *            The message received from the client.
	 * @param client
	 *            The connection from which the message originated.
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) { // CHECK ALL INFO FROM CLIENT

		Statement stmt;
		User user = null;
		
		try{
				stmt = (Statement) conn.createStatement();
				PreparedStatement ps;
				
		if	(msg instanceof String)	{
			
			//
				
			
		}
				
				
		if(msg instanceof MessageObject){	
			
			MessageObject msgObject = (MessageObject) msg;
			

			
				if (msgObject.getTask().equals("searchLogin")){ // search user in data base -- > Login
					int flag = 0;
					String query = "SELECT * FROM user WHERE user.Username= '"+ ((LoginEntity) msgObject.getObject()).getUserName()+ "' AND user.Password='"+ ((LoginEntity) msgObject.getObject()).getPassword() + "'";
					rs = (ResultSet) stmt.executeQuery(query);
					while (rs.next()) {flag++;
						user = new User(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6));}
					if (flag == 1) client.sendToClient(user);
					else client.sendToClient("UserNotfoundLogin");	
				}//searchLogin
				
				/*--------------------------------------------------------------------------*/
				
				if (msgObject.getTask().equals("Signuphim")) { // new user
					user= (User)msgObject.getObject();
					String query = "INSERT INTO user (Username,Password,Firstname,Lastname,status,Privilege) VALUES (?, ?, ?, ?, '0','0');";
					ps = (PreparedStatement) conn.prepareStatement(query);
					ps.setString(1, user.getUserName());
					ps.setString(2, user.getPassword());
					ps.setString(3, user.getFirstName());
					ps.setString(4, user.getLastName());
					System.out.println("SERVER" +user.getUserName() + user.getPassword() +  user.getFirstName() + user.getLastName());
					ps.executeUpdate();
					client.sendToClient("UserHasBeenUpdated");
				}//Signuphim
			
				/*--------------------------------------------------------------------------*/
				
				if (msgObject.getTask().equals("updateStatus1")) {
					String query = "UPDATE user SET user.status = ? WHERE user.Username = ?";
					ps = (PreparedStatement) conn.prepareStatement(query);
					ps.setInt(1, 1);
					ps.setString(2,((User) msgObject.getObject()).getUserName() );
					ps.executeUpdate();
					controller.SetLog((User)msgObject.getObject(),"login"); //update the login serverLogGui
				}//updateStatus1
			
				/*--------------------------------------------------------------------------*/

				if (msgObject.getTask().equals("updateStatus0")) { // update status to 0 (User has logged out)
					String query = "UPDATE user SET user.status = ? WHERE user.Username = ?";
					ps = (PreparedStatement) conn.prepareStatement(query);
					ps.setInt(1, 0);
					ps.setString(2,((User) msgObject.getObject()).getUserName() );
					ps.executeUpdate();
					controller.SetLog((User)msgObject.getObject(),"logout"); 
				}//updateStatus0
				
				/*--------------------------------------------------------------------------*/
				
				stmt = (Statement) conn.createStatement();
				if (msgObject.getTask().equals("ForgotPassEmail"))
				{
					String query = "SELECT * FROM user WHERE user.Username= '"+	msgObject.getObject() + "'";
					rs = (ResultSet) stmt.executeQuery(query);
					if(rs.next())
						client.sendToClient("ForgotPassEmailFound");
					else{
						client.sendToClient("ForgotPassEmailNotFound");	
					}
				}//Email validity -> forgotpass
			
				/*--------------------------------------------------------------------------*/
	
				if (msgObject.getTask().equals("CheckEmailValidity")){

					String query= "SELECT * FROM user WHERE user.Username= '"+ ((User) msgObject.getObject()).getUserName()+ "'" ;
					rs = (ResultSet) stmt.executeQuery(query);
					if(rs.next())
						client.sendToClient("SignUpEmailFound");
					else
						client.sendToClient("SignUpEmailNotFound");	
				}//Email validity -> signup
				
				/*--------------------------------------------------------------------------*/
		}
		}catch (Exception e) {
			System.err.println(e + " BigtryCatch - Echoserver");}
		
				System.out.println("Message received: " + msg + " from " + client);
				this.sendToAllClients(msg);
			
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() // INIT MYSQL CONNECTION AND THE SERVER
	{
		System.out.println("Server listening for connections on port "
				+ getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * stops listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Class methods ***************************************************
	public void setConn(java.sql.Connection conn) {
		this.conn = (Connection) conn;
	}

	public void SetServerLogController(ServerLogController servc) {
		this.controller = servc;
	}
}// End of EchoServer class


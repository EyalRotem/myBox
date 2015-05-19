package Client;

import Gui.*;
import Controllers.*;
import Entites.*;
/**
 * the main class that start mybox application
 * @author Niv
 *
 */
public class ClientMain {

	 public static myBoxClient clien;
	 
        public static void main(String[] args) {

               ClientGui cg = new ClientGui();
               ClientEntity ce= new ClientEntity();
               ClientController cc = new ClientController(cg,ce);

        }

}
package tiendaVideos;

import java.sql.SQLException;


public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MySQL mySQL=new MySQL();
        MenuPrincipal m= new  MenuPrincipal();
       m.menu(mySQL);
	}

}

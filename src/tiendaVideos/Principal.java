 package tiendaVideos;

import java.sql.SQLException;


public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MySQL mySQL=new MySQL();
        menuPrincipal m= new menuPrincipal();
        m.menu(mySQL);
	}

}

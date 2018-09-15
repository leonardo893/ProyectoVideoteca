package tiendaVideos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {
	String host;
	final int PORT = 3306;
	String dbName;
	String uname;
	String pwd;
	Connection conn;
	public MySQL(String host, 
			String dbName, 
			String uname, 
			String pwd) throws ClassNotFoundException
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			throw (e);
		}
		this.host = "localhost";
		this.dbName = "tiendavideos";
		this.uname = "root";
		this.pwd = "";
	}
	public MySQL(){
		this.host = "localhost";
		this.dbName = "tiendavideos";
		this.uname = "root";
		this.pwd = "";
	}
	public void abrir() throws SQLException
	{
		this.host = "localhost";
		this.dbName = "tiendavideos";
		this.uname = "root";
		this.pwd = "";
		String url = "jdbc:mysql://" + host + ":" + PORT + "/" + dbName;
		try 
		{
			conn = DriverManager.getConnection(url, uname, pwd);
		}
		catch (SQLException e)
		{
			System.out.println("Estado: " + e.getSQLState());
			if (e.getSQLState().equals("08S01"))
				System.out.println("\nNo se puede establecer la conexion con el Servidor.");
			throw(e);
		}	
	}
	public void cerrar() throws SQLException
	{
		conn.close();	
	}
	public void insertar(String query) throws SQLException
	{
		this.abrir();
		Statement s = null;
		try 
		{
			s = conn.createStatement();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw(e);
		}
		try 
		{				
			s.executeUpdate(query);
		}
		catch (SQLException e) 
		{
			throw(e);
		}	
	}
	public ResultSet consultar(String query) throws SQLException
	{
		Statement s = null;
		ResultSet rs = null;
		try
		{
			s = conn.createStatement();
		} 
		catch (SQLException e) 
		{
			throw(e);
		}
		try 
		{
			rs = s.executeQuery(query);
		} 
		catch (SQLException e) 
		{
			throw(e);
		}
		return rs;	
	}
}


package tiendaVideos;
import java.sql.SQLException;
public class Compra {
	int codproducto;
	int cantidad;
	int precio;
	String fecha; 
    Consultas consulta = new Consultas();
	public Compra(int codproducto,int cantidad,int precio,String fecha){
        this.codproducto=codproducto;
        this.cantidad=cantidad;
        this.precio=precio;
        this.fecha=fecha;
	}
	public int getproducto(){
		return codproducto;
	}
	public int getpcantidad(){
		return cantidad;
	}
	public int getprecio(){
		return precio;
	}
	public String fecha(){	
		return fecha;
	}
	public void comprar(MySQL mySQL, Compra compra) throws SQLException {
		consulta.comprar(mySQL,compra);	
	}
}
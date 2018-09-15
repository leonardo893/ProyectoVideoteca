package tiendaVideos;
import java.sql.SQLException;

public class Compra {
	int codproducto;
	int cantidad;
	int precio;
	String fecha;
	// nos falta crear la clase consultas para que nos deje de aparecer el error  mostrado en el codigo 
    consultas consulta = new consultas();
	
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
	// nos falta crear la clase consultas para que nos deje de aparecer el error  mostrado en el codigo
		consulta.comprar(mySQL,compra);	
	}
}


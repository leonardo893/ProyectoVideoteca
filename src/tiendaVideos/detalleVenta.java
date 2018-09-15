package tiendaVideos;

import java.sql.SQLException;

public class detalleVenta {

    int codventa;
    int codproducto;
    int cantidad;
consultas consulta=new consultas();
public detalleVenta(int codventa, int codproducto,int cantidad){
	this.codventa=codventa;
	this.codproducto=codproducto;
	this.cantidad=cantidad;
	
}
public void realizarDetalleVenta(MySQL mySQL,detalleVenta detalle) throws SQLException{
consulta.guardarDetalle(mySQL,detalle);	
	consulta.modificar(mySQL,detalle);
}
public int getcodventa(){
	return codventa;
}
public int getproducto(){
	return codproducto;
}
public int getcantidad(){
	return cantidad;
}
}


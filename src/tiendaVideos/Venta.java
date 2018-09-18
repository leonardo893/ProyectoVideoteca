package tiendaVideos;

import java.sql.SQLException;
import java.util.Scanner;



public class Venta {
	Scanner leer=new Scanner(System.in);
    private int cod_cliente;
    private int cod_empleado;
    private String fecha;
    Consultas consulta = new Consultas();

public Venta(int cod_cliente,int cod_empleado,String fecha){
	this.cod_cliente=cod_cliente;
	this.cod_empleado=cod_empleado;
	this.fecha=fecha;
}
public void realizarventa(MySQL mySQL,Venta venta) throws SQLException{
	consulta.guardarVenta(mySQL, venta);

	System.out.println("INGRESE SU CODIGO DE VENTA:");
	int cod_venta= leer.nextInt();
	System.out.println("INGRESE CODIGO DE PRODUCTO:");
	int cod_producto= leer.nextInt();
	System.out.println("INGRESE CANTIDAD:");
	int cantidad= leer.nextInt();
		System.out.println("AMBOS DATOS SON CORRECTOS");
		detalleVenta  detalleventa = new detalleVenta(cod_venta,cod_producto,cantidad);
		detalleventa.realizarDetalleVenta(mySQL,detalleventa);
}
public int get_cod_cliente(){
	return cod_cliente;
}
public int get_cod_empleado(){
	return cod_empleado;
}
public Venta getVenta(){
	return this;}
public String fecha(){
	return fecha;
}
}

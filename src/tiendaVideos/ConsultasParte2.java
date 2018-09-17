/************
EMILY ROJAS
************/
	public void guardarDetalle(MiSQL miSQL,detalleVenta detalle) throws SQLException {
		System.out.println("ingresa metodo");
		int nroFactura=obtenerultimodetalle(mYSQL)+1;
		mYSQL.abrir();
		String query1 = ("INSERT INTO detalleventa(coddetalle,codventa,codproducto,cantidad) VALUES('"+nroFactura+"','"+detalle.getcodventa()+"','"+detalle.getproducto()+"','"+detalle.getcantidad()+"')");
		mYSQL.insertar(query1);
	}
	public int obtenerultimodetalle(MySQL mySQL) throws SQLException{
int resultado=0;
		mySQL.abrir();
		ResultSet rs = null;
		String query = "SELECT * ";
	 	query +=       "FROM   detalleventa ";
		rs = mySQL.consultar(query);
		while (rs.next())
		{
			resultado=resultado+1;			
}
		mySQL.cerrar();
		return resultado;
	}
	public boolean consultardatosventa(MySQL mySQL, int cod_venta) throws SQLException {
boolean resultado=false;
		mySQL.abrir();
		ResultSet rs = null;
		String query = "SELECT * ";
	 	query +=       "FROM   venta ";
		query +=       "WHERE codventa = '" + cod_venta + "'";
		rs = mySQL.consultar(query);
		if (rs.next())
		{
			resultado=true;			
}
		mySQL.cerrar();
		return resultado;
	}
	public boolean consultardatosproducto(MySQL mySQL, int cod_producto) throws SQLException {
boolean resultado=false;
		mySQL.abrir();
		ResultSet rs = null;
		String query = "SELECT * ";
	 	query +=       "FROM   producto ";
		query +=       "WHERE codproducto = '" + cod_producto + "'";
		rs = mySQL.consultar(query);
		if (rs.next())
		{
			resultado=true;
}
		mySQL.cerrar();
		return resultado;
	}
	public void modificar(MySQL mySQL, detalleVenta detalle) throws SQLException {
		int suma =cantidad(mySQL,detalle.getproducto())-detalle.getcantidad();
		mySQL.abrir();
		String query = ("UPDATE producto SET cantidad='"+suma+"' WHERE codproducto='" +detalle.getproducto()+ "' ");
		mySQL.insertar(query);
	}
	private int cantidad(MySQL mySQL, int detalle) throws SQLException {
	int valor=0;
	mySQL.abrir();
	ResultSet rs = null;
	String query = "SELECT * ";
 	query +=       "FROM   producto ";
	query +=       "WHERE codproducto = '" + detalle+ "'";
	rs = mySQL.consultar(query);
	if (rs.next())
	{
		valor=rs.getInt("cantidad");
}
	return valor;
	}
	public  void comprar(MySQL mySQL, Compra compra) throws SQLException {
		if(existe(mySQL,compra.getproducto())){
			int suma =cantidad(mySQL,compra.getproducto())+compra.getcantidad();
			mySQL.abrir();
			String query = ("UPDATE producto SET cantidad='"+suma+"' WHERE codproducto='" +compra.getproducto()+ "' ");
			mySQL.insertar(query);
			int nroFactura=obtenerultimacompra(mySQL)+1;
		System.out.println(nroFactura);
			String query1 = ("INSERT INTO compra(codcompra,codproducto,cantidad,fecha,precioventa) VALUES('"+nroFactura+"','"+compra.getproducto()+"','"+compra.getcantidad()+"','"+compra.fecha()+"','"+compra.getprecio()+"')");
			mySQL.insertar(query1);
		}
	}
	private int obtenerultimacompra(MySQL mySQL) throws SQLException {
		int resultado=0;
		mySQL.abrir();
		ResultSet rs = null;
		String query = "SELECT * ";
	 	query +=  "FROM compra ";
		rs = mySQL.consultar(query);
		while (rs.next())
		{
			resultado=resultado+1;			
}
		mySQL.cerrar();

		return resultado;
	}
	public boolean existe(MySQL mySQL,int codproducto) throws SQLException{
		boolean consulta=false;
		mySQL.abrir();
		ResultSet rs = null;
		String query = "SELECT * ";
	 	query +=       "FROM   producto ";
		query +=       "WHERE codproducto = '" + codproducto + "'";
		rs = mySQL.consultar(query);
		if (rs.next())
		{
			consulta=true;
}
		mySQL.cerrar();
		return consulta;
	}
}


package tiendaVideos;

import java.sql.SQLException;
import java.util.Scanner;


public class MenuPrincipal {
          Scanner leer= new Scanner(System.in);
          Consultas consulta= new Consultas();
	public  void menu(MySQL mySQL) throws ClassNotFoundException, SQLException {

		int a=0;
		
			do{
				System.out.println("TIENDA DE VIDEOS");
				System.out.println("------------");
				System.out.println("1.REALIZAR VENTA");
				System.out.println("2.REALIZAR COMPRA");
				System.out.println("3.VER PELICULAS");
				System.out.println("4.SALIR");
				try{
					a=leer.nextInt();
									
				switch(a){
				case 1:
					try{
					System.out.println("INGRESE LOS VALORES DE LA FACTURA:");
					System.out.println("INGRESE SU CODIGO DE CLIENTE:");
					int cod_cliente= leer.nextInt();
					System.out.println("INGRESE CODIGO DE EMPLEADO:");
					int cod_empleado= leer.nextInt();
					System.out.println("INGRESE FECHA:");
					String fecha= leer.next();
					
					if(consulta.consultardatoscliente(mySQL, cod_cliente) && consulta.consultardatosempleado(mySQL, cod_empleado)){
						Venta  venta = new Venta(cod_cliente,cod_empleado,fecha);
						venta.realizarventa(mySQL,venta);
					}
					break;
					}catch(Exception e){
					}
					break;
				case 2:
					mySQL.abrir();
                    System.out.println("INGRESE EL CODIGO DEL PRODUCTO:");
					int codproducto=leer.nextInt();
					System.out.println("INGRESE LA CANTIDAD:");
					int cantidad= leer.nextInt();
					
					System.out.println("INGRESE EL PRECIO:");
					int precio= leer.nextInt();
					System.out.println("INGRESE FECHA:");
					String fecha= leer.next();
					
					Compra compra = new Compra(codproducto,cantidad,precio,fecha);
					compra.comprar(mySQL,compra);
					break;
				case 3:
					mySQL.abrir();
					consulta.mostrarInventario(mySQL);
					break;
					default:
						System.exit(0);
						break;}
				}catch(Exception e){
					System.out.println("INGRESE UNA OPCION VALIDA ");
				}
		}while(a!=4);
			}
	}
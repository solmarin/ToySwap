package controlador;

import datos.SQLAyuda;
import datos.SQLOferta;
import datos.SQLPublicacion;
import datos.SQLUsuario;
import modelo.Oferta;
import modelo.Publicacion;
import modelo.Usuario;

/**
 * Clase principal para ir testeando las clases y sentencias SQL del paquete datos.
 * @author Sol Marín
 * @version 1
 *
 */
public class Testeo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Crear una clase SQLAyuda y conectar a la BBDD.
		SQLAyuda sqlayuda = new SQLAyuda();
		sqlayuda.conectar();
		
		Creo una clase SQLAyudas y muestro el contenido de la tabla.
		SQLAyuda sqlayuda = new SQLAyuda();
		System.out.println(sqlayuda.consultar());*/
		
		/*Creo una clase SQLOferta y conectar a la BBDD.
		SQLOferta sqloferta = new SQLOferta();
		sqloferta.conectar();
		Creo una clase SQLOferta y simulo una oferta.
		SQLOferta sqloferta = new SQLOferta();
		sqloferta.crear(new Oferta(12,true));*/
		
		/*Creo una clase SQLPublicación y conectar a la BBDD.
		SQLPublicacion sqlpubli = new SQLPublicacion();
		sqlpubli.conectar();
		Creo una clase SQLPublicacion y inserto una publicacion.
		SQLPublicacion sqlpubli = new SQLPublicacion();
		sqlpubli.crear(new Publicacion("11111111A","Peluche elefante","Peluce de un elefante de 12 cm","2 mano","Peluche"));
		//Creo una clase SQLPublicacion y elimino un registro
		SQLPublicacion sqlpubli = new SQLPublicacion();
		sqlpubli.eliminar(3);*/
		
		//Creo una clase SQLPublicación y consulto
		//SQLPublicacion sqlpubli = new SQLPublicacion();
		//System.out.println("FILTRADO TOTAL:");
		//System.out.println(sqlpubli.consultarFiltrando("", "Nombre"));
		//System.out.println("FILTRADO Nombre:");
		//System.out.println(sqlpubli.consultarFiltrando("Peluche elefa", "Nombre"));
		//System.out.println("FILTRADO ESTADO:");
		//System.out.println(sqlpubli.consultarFiltrando("2 mano", "Estado"));
		//System.out.println("FILTRADO CATEGORIA:");
		//System.out.println(sqlpubli.consultarFiltrando("Coches", "Categoria"));
		//System.out.println("FILTRADO FECHA:");
		//System.out.println(sqlpubli.consultarFiltrando("2020/4/21", "Fecha"));
		
		/*Creo una clase SQLUsuario y conecto a la BBDD
		SQLUsuario sqlusu = new SQLUsuario();
		sqlusu.conectar();
		Creo una clase SQLUsuario y le añado un usuario
		SQLUsuario sqlusu = new SQLUsuario();
		sqlusu.crear(new Usuario("1111111A","contrasena","Usuario 1","Apellido 1","1999/10/21",'M',"prueba@gmail.com",678567689,false));
		modifico el usuario creado anteriormente
		sqlusu.editar("1111111A", "nuevaContra", "Usuario 2", "Apellido 1", "1999/10/21", 'M', "prueba@gmail.com",678567689,false);
		Creo una clase SQLUsuario y busco por dni
		SQLUsuario sqlusu = new SQLUsuario();
		System.out.println(sqlusu.consulta("1111111A").toString());
		System.out.println(sqlusu.consulta("1111112B").toString());
		System.out.println(sqlusu.consulta("1112029O").toString());
		System.out.println(sqlusu.consulta("1").toString());*/
		
		
		
	}

}

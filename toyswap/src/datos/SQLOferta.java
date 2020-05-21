package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.Oferta;
/**
 * Clase de consultas SQL entre la relación tabla Ofertas - clase Oferta.
 * @author Sol Marín
 * @version 1
 *
 */
public class SQLOferta {
	//Declaración y inicialización de variables
			Connection c = null;
			Statement sentencia = null;
			
			/**
			 * Función para conectar BBDD
			 */
			public void conectar() {

				try {

					Class.forName("org.sqlite.JDBC");
					c = DriverManager.getConnection("jdbc:sqlite:servidor/toyswap.db");
					System.out.println("EXITO AL CONECTAR A LA BBDD");

				} catch (Exception e) {
					JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

				}

			}
			
			/**
			 * Función para simular la creación de una oferta.
			 * @param oferta = oferta de simulación con parametros idPubli y tipo
			 */
			public void crear(Oferta oferta){
				
				String sqlInsert = "INSERT INTO Ofertas(idPubli,tipo) VALUES('"+oferta.getIdPubli()+"','"+oferta.isTipo()+"');";

				try {

					conectar();
					sentencia = c.createStatement();
					sentencia.executeUpdate(sqlInsert);
					sentencia.close();
					c.close();
					System.out.println("OFERTA REALIZADA.\n DATOS:\nPublicación:"+oferta.getIdPubli()+"\nTipo:"+oferta.isTipo());

				} catch (Exception e) {
					JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				}

			}

}

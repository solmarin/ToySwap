package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Ayuda;

/**
 * Clase de consultas SQL entre la relaci�n tabla bbdd ayudas - clase Ayuda. 
 * @author Sol Mar�n
 * @version 1.2
 *
 */
public class SQLAyuda {
	//Declaraci�n y inicializaci�n de variables
		Connection c = null;
		Statement sentencia = null;
		ArrayList<Ayuda> aAyuda = new ArrayList <Ayuda>(); 
		
		/**
		 * Funci�n para conectar BBDD
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
	 * Funci�n para consultar las instrucciones y informaci�n.
	 *
	 * @return array de Ayudas
	 */
		public ArrayList<Ayuda> consultar() {
			conectar();
			try {
				sentencia = c.createStatement();
			} catch (SQLException e1) {
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e1.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

			}
			
			//Sentencia a ejecturar en SQL
			String consultaSql = "SELECT * FROM Ayudas;";

			try {
				
				ResultSet rs = sentencia.executeQuery(consultaSql);
				while (rs.next()) {
					
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String descripcion = rs.getString("descripcion");
					
					aAyuda.add(new Ayuda(id, nombre, descripcion));

				}
			
				rs.close();
				sentencia.close();
				c.close();
			 

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}
			return aAyuda;

		}

}

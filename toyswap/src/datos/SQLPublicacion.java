package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Publicacion;

/**
 * Clase de consultas SQL para la relación tabla Publicaciones - clase Publicacion.
 * @author Sol Marín
 * @version 2
 *
 */
public class SQLPublicacion {
	//Declaración y inicialización de variables
		Connection c = null;
		Statement sentencia = null;
		ArrayList<Publicacion> aPubli = new ArrayList <Publicacion>(); 
		
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
		 * Función para crear un nuevo registro en la tabla Publicaciones.
		 * @param publi
		 */
		public void crear(Publicacion publi){
			
			String sqlInsert = "INSERT INTO Publicaciones(dni,nombre,descripcion, estado,fecha,categoria) VALUES('"+
								publi.getDni()+"','"+publi.getNombre()+"','"+publi.getDescripcion()+"','"+
								publi.getEstado()+"','"+publi.getFecha()+"','"+publi.getCategoria()+"');";

			try {

				conectar();
				sentencia = c.createStatement();
				sentencia.executeUpdate(sqlInsert);
				sentencia.close();
				c.close();
				System.out.println("Datos insertados");

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}

		}
		/**
		 * Función para eliminar un registro de publicaciones segun un id.
		 * @param id
		 */
		public void eliminar(int id) {
			
			String sqlDelet = "DELETE FROM Publicaciones WHERE ID = '"+id+"'";

			try {

				conectar();
				sentencia = c.createStatement();
				sentencia.executeUpdate(sqlDelet);
				sentencia.close();
				c.close();
				System.out.println("Datos eliminados");

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			
			}

		}
		/**
		 * Función de consulta de publicaciones.
		 * @param x = parametro de busqueda
		 * @param filtro = filtro para la busqueda
		 * @return un array con las publicaciones encontradas
		 */
		public ArrayList<Publicacion> consultarFiltrando(String x, String filtro){
			String consultaSql = null;
			conectar();
			try {
				sentencia = c.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e1.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}		
			
			//tratado de casos posibles de consulta
			
			if(x != "" && filtro.equalsIgnoreCase("nombre")) consultaSql = "SELECT * FROM publicaciones WHERE nombre LIKE '%"+x+"%';";
			else if (x != "" && filtro.equalsIgnoreCase("fecha")) consultaSql = "SELECT * FROM publicaciones WHERE fecha LIKE '%"+x+"%';";
			else if (x != "" && filtro.equalsIgnoreCase("categoria")) consultaSql = "SELECT * FROM publicaciones WHERE categoria LIKE '%"+x+"%';";
			else if (x != "" && filtro.equalsIgnoreCase("estado")) consultaSql = "SELECT * FROM publicaciones WHERE estado LIKE '%"+x+"%';";
			else if (x != "" && filtro.equalsIgnoreCase("dni")) consultaSql = "SELECT * FROM publicaciones WHERE dni LIKE '"+x+"';";
			else if (x != "" && filtro.equalsIgnoreCase("publi")) consultaSql = "SELECT * FROM publicaciones WHERE id LIKE '"+Integer.parseInt(x)+"';";
			else consultaSql = "SELECT * FROM publicaciones;";
			
			
			
			try {
				//ejecucion consulta sql
				ResultSet rs = sentencia.executeQuery(consultaSql);

				while (rs.next()) {
					int id = rs.getInt("id");
					String dni = rs.getString("dni");
					String nombre = rs.getString("nombre");
					String descripcion = rs.getString("descripcion");
					String estado = rs.getString("estado");
					String fecha = rs.getString("fecha");
					String categoria = rs.getString("categoria");
					//añadir al array
					aPubli.add(new Publicacion(id, dni,  nombre,  descripcion,  estado, fecha, categoria));
				}
				rs.close();
				sentencia.close();
				c.close();

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}
			return aPubli;
		}


}

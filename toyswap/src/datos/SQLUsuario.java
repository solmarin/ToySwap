package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Usuario;

/**
 * Clase de sentencias SQL para la relacion tabla Usuarios - clase Usuario.
 * @author Sol Marín
 * @version 1
 *
 */
public class SQLUsuario {
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
		 * Función para añadir un registro a la tabla usuarios.
		 * @param usu = usuario a añadir
		 */
		public void crear(Usuario usu){

			String sqlInsert = "INSERT INTO usuarios(dni,contrasena, nombre, apellidos,fechaNacimiento,sexo,email,telefono,salir) VALUES('"
			+usu.getDni()+"','"+usu.getContrasena()+"','"+usu.getNombre()+"','"+usu.getApellidos()+"','"+usu.getFechaNacimiento()+"','"
			+usu.getSexo()+"','"+usu.getEmail()+"','"+usu.getTelefono()+"','"+usu.isSalir()+"');";

			try {

				conectar();
				sentencia = c.createStatement();
				sentencia.executeUpdate(sqlInsert);
				sentencia.close();
				c.close();
				System.out.println("Datos insertados");

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL INSERTAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}

		}
		/**
		 * Función para editar un registro de la tabla usuarios.
		 * @param dni (parametro para selecionar le usuario) Nuevo contenido del campo (String)
		 * @param contrasena = Nuevo contenido del campo (String)
		 * @param nombre = Nuevo contenido del campo (String)
		 * @param apellidos = Nuevo contenido del campo (String)
		 * @param fechaNacimiento = Nuevo contenido del campo (String)
		 * @param sexo = Nuevo contenido del campo (char)
		 * @param email = Nuevo contenido del campo (String)
		 * @param telefono = Nuevo contenido del campo (int)
		 * @param salir = Nuevo contenido del campo (boolean)
		 */
		public void editar( String dni, String contrasena, String nombre, String apellidos, String fechaNacimiento,
				char sexo, String email, int telefono, boolean salir){
			
			String sqlUp = "UPDATE usuarios SET dni = '"+dni+"', contrasena ='"+contrasena+"', nombre='"+nombre+"' , "
					+ "apellidos='"+apellidos+"',fechaNacimiento='"+fechaNacimiento+"', sexo='"+sexo+"', email='"+email+"', "
					+"telefono='"+telefono+"' WHERE dni ='"+dni+"';";
			try {

				conectar();
				sentencia = c.createStatement();
				sentencia.executeUpdate(sqlUp);
				sentencia.close();
				c.close();
				System.out.println("Datos actualizados");

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL ACTUALIZAR DATOS EN LA TABLA: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}

		}
		/**
		 * Función para buscar entre los registros de la tabla usuarios.
		 * @param DNI = parametro de busqueda
		 * @return devuelve un array de usuarios que en este caso solo debe contener 1 registro
		 */
		public ArrayList<Usuario> consulta(String DNI){
			ArrayList<Usuario> aUsu = new ArrayList <Usuario>(); 
			conectar();
			
			try {
				sentencia = c.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e1.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}
			String consultaSql = "SELECT * FROM usuarios WHERE dni ='"+DNI+"';";

			try {

				ResultSet rs = sentencia.executeQuery(consultaSql);
				
				while (rs.next()) {
				
					 String dni = rs.getString("dni");
					 String contrasena = rs.getString("contrasena");
					 String nombre = rs.getString("nombre");
					 String apellidos = rs.getString("apellidos");
					 String fechaNacimiento = rs.getString("fechaNacimiento");
					 char sexo = rs.getString("sexo").charAt(0);
					 String email = rs.getString("email");
					 int telefono = rs.getInt("telefono");
					 boolean salir = rs.getBoolean("salir");
					 
					
						
					aUsu.add(new Usuario(dni,contrasena,nombre,apellidos,fechaNacimiento,sexo,email,telefono,salir));
				}
				
				rs.close();
				sentencia.close();
				c.close();
			 

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "ERROR AL RECUPERAR DATOS: "+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}
			return aUsu;

		}

}

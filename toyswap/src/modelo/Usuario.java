package modelo;
/**
 * Clase para definir la estructura de los usuarios. 
 * @author Sol Marín
 * @version 1
 *
 */
public class Usuario {

	//Declaración y inicialización de variables
		private String dni;
		private String contrasena;
		private String nombre;
		private String apellidos;
		private String fechaNacimiento;
		private char sexo;
		private String email;
		private int telefono;
		private boolean salir;
		
	//Constructor/es
		public Usuario(String dni, String contrasena, String nombre, String apellidos, String fechaNacimiento,
				char sexo, String email, int telefono, boolean salir) {
			super();
			this.dni = dni;
			this.contrasena = contrasena;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.fechaNacimiento = fechaNacimiento;
			this.sexo = sexo;
			this.email = email;
			this.telefono = telefono;
			this.salir = salir;
		}

	//Métodos
		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getContrasena() {
			return contrasena;
		}

		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(String fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public char getSexo() {
			return sexo;
		}

		public void setSexo(char sexo) {
			this.sexo = sexo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public boolean isSalir() {
			return salir;
		}

		public void setSalir(boolean salir) {
			this.salir = salir;
		}

		@Override
		public String toString() {
			return "Usuario [dni=" + dni + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellidos="
					+ apellidos + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", email=" + email
					+ ", telefono=" + telefono + ", salir=" + salir + "]";
		}
		
		
	
		
}

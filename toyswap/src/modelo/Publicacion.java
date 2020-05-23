package modelo;

import java.util.Calendar;

/**
 * Clase para definir la estructura de las publicaciones.
 * @author Sol Marín
 * @version 1.5
 *
 */
public class Publicacion {
	//Declaración de variables y inicialización
		private int id;
		private String dni;
		private String nombre;
		private String descripcion;
		private String estado;
		private String fecha;
		private String categoria;
		
	//Constructor/es
		public Publicacion(String dni, String nombre, String descripcion, String estado, String categoria) {
			super();
			this.dni = dni;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.estado = estado;
			this.categoria = categoria;
			this.setFecha();
		}
		
		//constructor consulta sql
		public Publicacion(int id, String dni, String nombre, String descripcion, String estado, String fecha, String categoria) {
			this.id = id;
			this.dni = dni;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.estado = estado;
			this.categoria = categoria;
			this.fecha = fecha;
		}
		
	//Metodos

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public void setFecha() {
			Calendar cal;
			String sFecha;
			
			cal = Calendar.getInstance();
			
			sFecha = Integer.toString(cal.get(Calendar.YEAR))+"/"
					+ Integer.toString(cal.get(Calendar.MONTH))+"/"
					+ Integer.toString(cal.get(Calendar.DATE))+" ";
			
			this.fecha = sFecha;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		@Override
		public String toString() {
			return "Publicacion [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", descripcion=" + descripcion
					+ ", estado=" + estado + ", fecha=" + fecha + ", categoria=" + categoria + "]\n";
		}
		
		
		
		

}

package modelo;
/**
 * Clase para definir la estructura de las ayudas.
 * @author Sol Mar�n
 * @version 1.2
 *
 */
public class Ayuda {
	//Declaraci�n de variables y inicializaci�n
		private int id;
		private String nombre;
		private String descripcion;
		
	//Constructor/es
		public Ayuda(int id, String nombre, String descripcion) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
		}
		
	//M�todos
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
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
		@Override
		public String toString() {
			return this.descripcion;
		}
		
}

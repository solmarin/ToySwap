package modelo;

import java.util.ArrayList;

/**
 * Clase para definir la estructura de las ofertas.
 * @author Sol Marín
 * @version 1
 */
public class Oferta {
	//Declaración de variables y inicialización
		private int id;
		private int idPubli;
		private boolean tipo;
		private boolean existeChat;
		private boolean finalizarChat;
		private ArrayList<Publicacion> productosIntercambio;
		private ArrayList<Usuario> interesados;
		
	//Constructor/es
		public Oferta(int id, int idPubli, boolean tipo, boolean existeChat, boolean finalizarChat,
				ArrayList<Publicacion> productosIntercambio, ArrayList<Usuario> interesados) {
			super();
			this.id = id;
			this.idPubli = idPubli;
			this.tipo = tipo;
			this.existeChat = existeChat;
			this.finalizarChat = finalizarChat;
			this.productosIntercambio = productosIntercambio;
			this.interesados = interesados;
		}
		
	//Métodos
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getIdPubli() {
			return idPubli;
		}

		public void setIdPubli(int idPubli) {
			this.idPubli = idPubli;
		}

		public boolean isTipo() {
			return tipo;
		}

		public void setTipo(boolean tipo) {
			this.tipo = tipo;
		}

		public boolean isExisteChat() {
			return existeChat;
		}

		public void setExisteChat(boolean existeChat) {
			this.existeChat = existeChat;
		}

		public boolean isFinalizarChat() {
			return finalizarChat;
		}

		public void setFinalizarChat(boolean finalizarChat) {
			this.finalizarChat = finalizarChat;
		}

		public ArrayList<Publicacion> getProductosIntercambio() {
			return productosIntercambio;
		}

		public void setProductosIntercambio(ArrayList<Publicacion> productosIntercambio) {
			this.productosIntercambio = productosIntercambio;
		}

		public ArrayList<Usuario> getInteresados() {
			return interesados;
		}

		public void setInteresados(ArrayList<Usuario> interesados) {
			this.interesados = interesados;
		}

		@Override
		public String toString() {
			return "Oferta [id=" + id + ", idPubli=" + idPubli + ", tipo=" + tipo + ", existeChat=" + existeChat
					+ ", finalizarChat=" + finalizarChat + ", productosIntercambio=" + productosIntercambio
					+ ", interesados=" + interesados + "]";
		}
	
	
	

}

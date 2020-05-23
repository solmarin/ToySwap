package vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controlador.FrmInicio;
import datos.SQLPublicacion;
import modelo.Publicacion;
import modelo.Usuario;

import javax.swing.JTextField;

/**
 * Clase para definir el diseño de la pantalla principal.
 * @author Sol Marín
 * @version 2
 *
 */
public class FrmPrincipal {
	//Declaración y inicialización de variables globales
		public JFrame frame;
		private JTextField TFBuscador;
		private Object[] titulos = {"ID","PRODUCTO", "DESCRIPCIÓN", "FECHA","CATEGORIA","ESTADO"};
		private Object[] celdas = {};
		private JButton btnPerfil;
		private JButton btnChats;
		private JButton btnAyuda;
		private Usuario usuario;
		DefaultTableModel model;
		JTable table;
		JComboBox<String> comboBox;


	/**
	 * Create the application.
	 * @param usuario 
	 */
	public FrmPrincipal(Usuario usuario) {
		this.usuario = usuario;
		diseño();
		eventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void diseño() {
		//Ventana
			frame = new JFrame();
			frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().setEnabled(false);
			frame.setBounds(0,0, 1280, 720);
			frame.setLocationRelativeTo(null); //posición en medio de la pantalla
			frame.getContentPane().setBackground(new Color(228, 234, 232)); //crear color verde del fondo
			frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setLayout(null);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
		//Logo
			JLabel JLImagen = new JLabel();
			JLImagen.setBorder(null);
			JLImagen.setBounds(1184, 0, 82, 74);
			ImageIcon logo = new ImageIcon(FrmInicio.class.getResource("/res/logo.PNG"));
			Icon iLogo = new ImageIcon(logo.getImage().getScaledInstance(JLImagen.getWidth(), JLImagen.getHeight(), Image.SCALE_DEFAULT ));
			JLImagen.setIcon(iLogo);
			frame.getContentPane().add(JLImagen);
		
			
		//Botones
			btnPerfil = new JButton("PERFIL");
			btnPerfil.setBorder(UIManager.getBorder("Button.border"));
			btnPerfil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnPerfil.setBounds(0, 0, 119, 60);
			btnPerfil.setBackground(Color.WHITE);
			btnPerfil.setForeground(new Color(139, 196, 68));
			frame.getContentPane().add(btnPerfil);
			
			btnChats = new JButton("CHATS");
			btnChats.setForeground(new Color(139, 196, 68));
			btnChats.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnChats.setBorder(UIManager.getBorder("Button.border"));
			btnChats.setBackground(Color.WHITE);
			btnChats.setBounds(543, 0, 109, 60);
			frame.getContentPane().add(btnChats);
			
			btnAyuda = new JButton("");
			btnAyuda.setBorder(null);
			btnAyuda.setContentAreaFilled(false);
			btnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/res/info.png")));
			btnAyuda.setBounds(653, 0, 65, 60);
			frame.getContentPane().add(btnAyuda);
			
			
		//Lista de filtros
			comboBox = new JComboBox<String>();
			comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			comboBox.setName("FILTROS");
			String[] opciones = {"Nombre","Fecha","Estado","Categoria"};
			comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(opciones));
			comboBox.setBounds(436, 0, 109, 60);
			comboBox.setForeground(new Color(52, 77, 160));
			frame.getContentPane().add(comboBox);
			
		//TextField de buscador: creo un label para añadir la imagen y encima el buscador. 
			JLabel JLBuscador = new JLabel();
			JLBuscador.setBorder(null);
			JLBuscador.setBounds(129, 0, 32, 60);
			ImageIcon buscador = new ImageIcon(FrmPrincipal.class.getResource("/res/buscador.PNG"));
			Icon iBuscador = new ImageIcon(buscador.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT ));
			JLBuscador.setIcon(iBuscador);
			frame.getContentPane().add(JLBuscador);
			
			TFBuscador = new JTextField();
			TFBuscador.setForeground(Color.BLACK);
			TFBuscador.setFont(new Font("Tahoma", Font.ITALIC, 16));
			TFBuscador.setBounds(164, 10, 264, 37);
			TFBuscador.setOpaque(true);
			frame.getContentPane().add(TFBuscador);
			TFBuscador.setColumns(10);
		
		//Tabla con scroll
			JScrollPane scroll = new JScrollPane();
			scroll.setFont(new Font("Tahoma", Font.PLAIN, 14));
			scroll.setBackground(Color.WHITE);
			 model = new DefaultTableModel(celdas,0){ 
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex,int coluumnIndex) {return false;}
				};
				
			model.setColumnIdentifiers(titulos);
			table = new JTable();
			table.setShowVerticalLines(false);
			table.setGridColor(Color.white);
			table.setForeground(new Color(0, 0, 0));
			table.setEnabled(true);
			table.setModel(model);
		    table.setFont(new Font("FreeSans", Font.ITALIC, 16));
			table.setRowHeight(18);
			scroll.setViewportView(table);
			scroll.setBounds(130, 150, 992, 382);;
			table.setBackground(Color.white);
			frame.getContentPane().add(scroll);
			
			//Rellenamos la tabla inicialmente
			actualizarTabla(TFBuscador.getText(),String.valueOf(comboBox.getSelectedItem()));
			
	}
	
	/**
	 * Función donde se almacenan todos los eventos de la vista.
	 */
	public void eventos() {
		//Evento: para abrir la pantalla del usuario
			btnPerfil.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						FrmUsuario frmusuario = new FrmUsuario(usuario);
						frmusuario.frame.setVisible(true);
						
					}
				});
			
		//Evento: boton para abrir los chats --  mostrar ventana de "en proceso"
			btnChats.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "FUNCIÓN NO DISPONIBLE.\nESTAMOS TRABAJANDO EN ELLO.\nDISCULPEN LAS MOLESTIAS. ");
					
				}
			});
		
		//Evento: boton para abrir la pantalla de ayuda
			btnAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FrmAyuda frmayuda = new FrmAyuda();
					frmayuda.frame.setVisible(true);
				}
			});
			
		//Evento: escuchar el buscador
			TFBuscador.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					actualizarTabla(TFBuscador.getText(),String.valueOf(comboBox.getSelectedItem()));
					
				}
			});
		
		//Evento: escuchar a la tabla -- pasar los parametros a la nueva vista
		    table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//Le pasamos a la vista el valor de la posición 0 de la tabla en el punto seleccionado
						abrirPubliConDatos(String.valueOf(table.getValueAt(table.rowAtPoint(e.getPoint()), 0)));
				}
			});	    
	}
	
	/**
	 * Función para actualizar los campos de la tabla.
	 */
	public void actualizarTabla(String x, String filtro) {
		try {
		 model.setRowCount(0);
		 SQLPublicacion sqlpublicacion = new SQLPublicacion();
		 for(Publicacion c: sqlpublicacion.consultarFiltrando(x,filtro)) {
		    	if(c != null) {
		    		int id = c.getId();
					String nombre = c.getNombre();
					String descripcion = c.getDescripcion();
					String estado = c.getEstado();
					String fecha = c.getFecha();
					String categoria = c.getCategoria();
					model.addRow(new Object[] {id, nombre,  descripcion,  estado, fecha, categoria});
					
		    	}  	
		    }
		 } catch (NumberFormatException e) {
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		 }	
	}
	
	/**
	 * Función para abrir la ventana de publicación pasandole sus datos.
	 */
		public void abrirPubliConDatos(String id) {
			
			SQLPublicacion sqlpublicacion = new SQLPublicacion();
			ArrayList<Publicacion> publi = null;
			
			publi = sqlpublicacion.consultarFiltrando(id, "publi");
				 
			
			if(publi.isEmpty()) {
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD: mostrar datos seleccionados", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			}else {
				FrmPublicacion frmpublicacion = new FrmPublicacion(publi.get(0),usuario.getDni());
				frmpublicacion.frame.setVisible(true);
				
			}
			
		}
}

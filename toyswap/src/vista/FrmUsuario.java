package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controlador.FrmInicio;
import modelo.Usuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * Clase para definir la estructura de la vista del perfil del usuario.
 * @author Sol Marín
 * @version 1
 *
 */
public class FrmUsuario {
	//Declaración y inicialización de variables globales
		JFrame frame;
		private JTextField TFDni;
		private JTextField TFNombre;
		private JTextField TFApellidos;
		private JTextField TFDireccion;
		private JTextField TFFechaNacimiento;
		private JTextField TFSexo;
		private JTextField TFEmail;
		private JTextField TFTelefono;
		private JPasswordField pwdContrasea;
		private Object[] titulos = {"ID","PRODUCTO", "DESCRIPCIÓN", "FECHA","CATEGORIA","ESTADO"};
		private Object[] celdas = {};
		private Usuario usuario;

	/**
	 * Create the application.
	 * @param usuario 
	 */
	public FrmUsuario(Usuario usuario) {
		this.usuario = usuario;
		diseño();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void diseño() {
		//Ventana
			frame = new JFrame();
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
		
			
		//Label informativo Perfil
			Border border = LineBorder.createGrayLineBorder(); //borde negro
			JLabel JLPerfil = new JLabel("PERFIL");
			JLPerfil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			JLPerfil.setHorizontalAlignment(SwingConstants.CENTER);
			JLPerfil.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLPerfil.setBorder(UIManager.getBorder("ComboBox.border"));
			JLPerfil.setOpaque(true);
			JLPerfil.setBackground(Color.WHITE);
			JLPerfil.setForeground((new Color(139, 196, 68)));
			JLPerfil.setBounds(0, 0, 170, 60);
			JLPerfil.setBorder(border);
			frame.getContentPane().add(JLPerfil);
		
		//Label informativo
			JLabel JLDatos = new JLabel("DATOS");
			JLDatos.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			JLDatos.setBounds(90, 89, 490, 37);
			JLDatos.setForeground((new Color(139, 196, 68)));
			frame.getContentPane().add(JLDatos);
			
		//Información del usuario
			TFDni = new JTextField(usuario.getDni());
			TFDni.setEditable(false);
			TFDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFDni.setBounds(211, 124, 150, 24);
			frame.getContentPane().add(TFDni);
			TFDni.setColumns(10);
			
			TFNombre = new JTextField(usuario.getNombre());
			TFNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFNombre.setEditable(false);
			TFNombre.setColumns(10);
			TFNombre.setBounds(211, 158, 150, 24);
			frame.getContentPane().add(TFNombre);
			
			TFApellidos = new JTextField(usuario.getApellidos());
			TFApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFApellidos.setEditable(false);
			TFApellidos.setColumns(10);
			TFApellidos.setBounds(371, 158, 150, 24);
			frame.getContentPane().add(TFApellidos);
			
			
			TFFechaNacimiento = new JTextField(usuario.getFechaNacimiento());
			TFFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFFechaNacimiento.setEditable(false);
			TFFechaNacimiento.setColumns(10);
			TFFechaNacimiento.setBounds(704, 192, 150, 24);
			frame.getContentPane().add(TFFechaNacimiento);
			
			if(usuario.getSexo() == 'M') TFSexo = new JTextField("Mujer");
			if(usuario.getSexo() == 'H') TFSexo = new JTextField("Hombre");
			if(usuario.getSexo() == 'O') TFSexo = new JTextField("Otros");
			if(usuario.getSexo() == 'N') TFSexo = new JTextField("Sexo: -");
			TFSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFSexo.setEditable(false);
			TFSexo.setColumns(10);
			TFSexo.setBounds(704, 124, 150, 24);
			frame.getContentPane().add(TFSexo);
			
			TFEmail = new JTextField(usuario.getEmail());
			TFEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFEmail.setEditable(false);
			TFEmail.setColumns(10);
			TFEmail.setBounds(704, 162, 310, 24);
			frame.getContentPane().add(TFEmail);
			
			TFTelefono = new JTextField(String.valueOf(usuario.getTelefono()));
			TFTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFTelefono.setEditable(false);
			TFTelefono.setColumns(10);
			TFTelefono.setBounds(211, 192, 310, 24);
			frame.getContentPane().add(TFTelefono);
			
			pwdContrasea = new JPasswordField(usuario.getContrasena());
			pwdContrasea.setText("contrase\u00F1a");
			pwdContrasea.setEditable(false);
			pwdContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			pwdContrasea.setBounds(704, 226, 310, 24);
			frame.getContentPane().add(pwdContrasea);
			
			//Label informativo
			JLabel JLPubli = new JLabel("PUBLICACIONES");
			JLPubli.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			JLPubli.setBounds(90, 287, 181, 37);
			JLPubli.setForeground((new Color(139, 196, 68)));
			frame.getContentPane().add(JLPubli);
			
			
			//Tabla con scroll
				JScrollPane scroll = new JScrollPane();
				DefaultTableModel model;
				scroll.setBackground(Color.WHITE);
				 model = new DefaultTableModel(celdas,0){ 
					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public boolean isCellEditable(int rowIndex,int coluumnIndex) {return false;}
					};
					
				model.setColumnIdentifiers(titulos);
				model.addRow(new Object[] {"2","COD","JUEGO DE PS4","2020/02/10","PS4","2 mano"}); //ejemplo de campos
				JTable table = new JTable();
				table.setShowVerticalLines(false);
				table.setGridColor(Color.white);
				table.setForeground(new Color(0, 0, 0));
				table.setEnabled(true);
				table.setModel(model);
			    table.setFont(new Font("FreeSans", Font.ITALIC, 16));
				table.setRowHeight(18);
				scroll.setViewportView(table);
				scroll.setBounds(173, 354, 852, 283);;
				table.setBackground(Color.white);
				frame.getContentPane().add(scroll);
			
			//Botones
				JButton btnNuevaPubli = new JButton("NUEVA");
				btnNuevaPubli.setBorder(UIManager.getBorder("Button.border"));
				btnNuevaPubli.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				btnNuevaPubli.setBounds(281, 276, 102, 51);
				btnNuevaPubli.setBackground(new Color(139, 196, 68));
				btnNuevaPubli.setForeground(Color.WHITE);
				frame.getContentPane().add(btnNuevaPubli);
				
				JButton btnEliminarPubli = new JButton("ELIMINAR");
				btnEliminarPubli.setForeground(Color.WHITE);
				btnEliminarPubli.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				btnEliminarPubli.setBorder(UIManager.getBorder("Button.border"));
				btnEliminarPubli.setBackground(new Color(52, 77, 160));
				btnEliminarPubli.setBounds(381, 276, 102, 51);
				frame.getContentPane().add(btnEliminarPubli);
				
				JButton btnEditar = new JButton("EDITAR");
				btnEditar.setForeground(Color.WHITE);
				btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				btnEditar.setBorder(UIManager.getBorder("Button.border"));
				btnEditar.setBackground(new Color(139, 196, 68));
				btnEditar.setBounds(168, 0, 118, 60);
				frame.getContentPane().add(btnEditar);
				
				JButton btnSolEliminar = new JButton("SOLICITAR ELIMINAR");
				btnSolEliminar.setHideActionText(true);
				btnSolEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
				btnSolEliminar.setForeground(Color.WHITE);
				btnSolEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				btnSolEliminar.setBorder(UIManager.getBorder("Button.border"));
				btnSolEliminar.setBackground(new Color(52, 77, 160));
				btnSolEliminar.setBounds(283, 0, 181, 60);
				frame.getContentPane().add(btnSolEliminar);
	}
}

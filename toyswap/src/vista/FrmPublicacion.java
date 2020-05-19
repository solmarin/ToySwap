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

import controlador.FrmInicio;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JTextPane;
/**
 * Clase para definir el diseño al mostrar una publicacion de un producto.
 * @author Sol Marín
 * @version 1
 *
 */
public class FrmPublicacion {
	//Declaración y inicialización de variables globales
		private JFrame frame;
		private JTextField TFId;
		private JTextField TFNombre;
		private JTextField TFCategoria;
		private JTextField TFEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPublicacion window = new FrmPublicacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmPublicacion() {
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
		
			
		//Label informativo Registrar
			Border border = LineBorder.createGrayLineBorder(); //borde negro
			JLabel JLPublicacion = new JLabel("PUBLICACIÓN");
			JLPublicacion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			JLPublicacion.setHorizontalAlignment(SwingConstants.CENTER);
			JLPublicacion.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLPublicacion.setBorder(UIManager.getBorder("ComboBox.border"));
			JLPublicacion.setOpaque(true);
			JLPublicacion.setBackground(Color.WHITE);
			JLPublicacion.setForeground((new Color(139, 196, 68)));
			JLPublicacion.setBounds(0, 0, 170, 60);
			JLPublicacion.setBorder(border);
			frame.getContentPane().add(JLPublicacion);
			
		//Label para mostrar la fecha de publicación
			JLabel JLFecha = new JLabel("EJEMPLO FECHA");
			JLFecha.setOpaque(true);
			JLFecha.setHorizontalAlignment(SwingConstants.CENTER);
			JLFecha.setForeground(new Color(52, 77, 160));
			JLFecha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			JLFecha.setBorder(UIManager.getBorder("ComboBox.border"));
			JLFecha.setBackground(Color.WHITE);
			JLFecha.setAlignmentX(0.5f);
			JLFecha.setBounds(170, 0, 170, 60);
			JLFecha.setBorder(border);
			frame.getContentPane().add(JLFecha);
			
		//Label informativo
			JLabel JLDatos = new JLabel("DATOS");
			JLDatos.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			JLDatos.setBounds(107, 100, 490, 37);
			JLDatos.setForeground((new Color(139, 196, 68)));
			frame.getContentPane().add(JLDatos);
			
		//textField de los datos del producto
			TFId = new JTextField();
			TFId.setHorizontalAlignment(SwingConstants.CENTER);
			TFId.setFont(new Font("Tahoma", Font.BOLD, 14));
			TFId.setEnabled(true);
			TFId.setEditable(false);
			TFId.setOpaque(false);
			TFId.setBorder(null);
			TFId.setText("ID 1");
			TFId.setBounds(195, 161, 200, 24);
			frame.getContentPane().add(TFId);
			TFId.setColumns(10);
			
			TFNombre = new JTextField();
			TFNombre.setHorizontalAlignment(SwingConstants.CENTER);
			TFNombre.setText("ELEFANTE");
			TFNombre.setOpaque(false);
			TFNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
			TFNombre.setEnabled(true);
			TFNombre.setEditable(false);
			TFNombre.setColumns(10);
			TFNombre.setBorder(null);
			TFNombre.setBounds(449, 161, 200, 24);
			frame.getContentPane().add(TFNombre);
			
			TFCategoria = new JTextField();
			TFCategoria.setHorizontalAlignment(SwingConstants.CENTER);
			TFCategoria.setText("Peluche");
			TFCategoria.setOpaque(false);
			TFCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
			TFCategoria.setEnabled(true);
			TFCategoria.setEditable(false);
			TFCategoria.setColumns(10);
			TFCategoria.setBorder(null);
			TFCategoria.setBounds(699, 161, 200, 24);
			frame.getContentPane().add(TFCategoria);
			
			TFEstado = new JTextField();
			TFEstado.setHorizontalAlignment(SwingConstants.CENTER);
			TFEstado.setText("2 mano");
			TFEstado.setOpaque(false);
			TFEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
			TFEstado.setEnabled(true);
			TFEstado.setEditable(false);
			TFEstado.setColumns(10);
			TFEstado.setBorder(null);
			TFEstado.setBounds(917, 161, 200, 24);
			frame.getContentPane().add(TFEstado);
			
		//Linea separadora
			Panel separador = new Panel();
			separador.setBounds(195, 191, 922, 10);
			separador.setForeground(new Color(52, 77, 160));
			separador.setBackground(new Color(52, 77, 160));
			frame.getContentPane().add(separador);
			
		//Area de descripción
			JTextPane TFADescripcion = new JTextPane();
			TFADescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFADescripcion.setText("Ejemplo de descripci\u00F3n de un producto.\nElenfante de peluche de 24 cm.");
			TFADescripcion.setEditable(false);
			TFADescripcion.setOpaque(false);
			TFADescripcion.setBounds(214, 218, 878, 216);
			TFADescripcion.setBorder(null);
			frame.getContentPane().add(TFADescripcion);
		
		//Botones
			JButton btnOAbierta = new JButton("OFERTA ABIERTA");
			btnOAbierta.setBorder(UIManager.getBorder("Button.border"));
			btnOAbierta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnOAbierta.setBounds(722, 504, 260, 93);
			btnOAbierta.setBackground(new Color(139, 196, 68));
			btnOAbierta.setForeground(Color.WHITE);
			frame.getContentPane().add(btnOAbierta);	
			
			JButton btnOCerrada = new JButton("OFERTA CERRADA");
			btnOCerrada.setForeground(Color.WHITE);
			btnOCerrada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnOCerrada.setBorder(UIManager.getBorder("Button.border"));
			btnOCerrada.setBackground(new Color(52, 77, 160));
			btnOCerrada.setBounds(340, 504, 260, 93);
			frame.getContentPane().add(btnOCerrada);

		
		
		
	
		
		
		
	}
}

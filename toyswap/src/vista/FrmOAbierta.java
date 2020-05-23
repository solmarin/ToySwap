package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import datos.SQLOferta;
import modelo.Oferta;
import modelo.Publicacion;

import javax.swing.JTextPane;
import javax.swing.JTextField;
/**
 * Clase para definir el dise�o de la pantalla de ofertas abiertas.
 * @author Sol Mar�n
 * @version 2
 *
 */
public class FrmOAbierta {
	//Declaraci�n y inicializaci�n de variables globales
		JFrame frame;
		private JTextField TFNombre;
		private JTextField TFDescripcion;
		private JTextField TFFecha;
		private JTextField TFCategoria;
		private JTextField TFEstado;
		private JTextField TFId;
		private Publicacion publi;
		private JButton btnEnviar;


	/**
	 * Create the application.
	 * @param publi 
	 */
	public FrmOAbierta(Publicacion publi) {
		this.publi = publi;
		dise�o();
		eventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void dise�o() {
		//Ventana
			frame = new JFrame();
			frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().setEnabled(false);
			frame.setBounds(0,0, 1280, 720);
			frame.setLocationRelativeTo(null); //posici�n en medio de la pantalla
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
			
		//Icono informaci�n
			JLabel JLInfo= new JLabel();
			JLInfo.setBounds(129, 119, 39, 38);
			JLInfo.setForeground(Color.WHITE);
			JLInfo.setBackground(Color.WHITE);
			ImageIcon info = new ImageIcon(FrmAyuda.class.getResource("/res/info.png"));
			Icon iInfo = new ImageIcon(info.getImage().getScaledInstance(JLInfo.getWidth(), JLInfo.getHeight(), Image.SCALE_DEFAULT ));
			JLInfo.setIcon(iInfo);
			frame.getContentPane().add(JLInfo);
		
			
		//Label informativo oferta abierta
			Border border = LineBorder.createGrayLineBorder(); //borde negro
			JLabel JLOAbierta = new JLabel("OFERTA ABIERTA");
			JLOAbierta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			JLOAbierta.setHorizontalAlignment(SwingConstants.CENTER);
			JLOAbierta.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLOAbierta.setBorder(UIManager.getBorder("ComboBox.border"));
			JLOAbierta.setOpaque(true);
			JLOAbierta.setBackground(Color.WHITE);
			JLOAbierta.setForeground((new Color(139, 196, 68)));
			JLOAbierta.setBounds(0, 0, 1185, 74);
			JLOAbierta.setBorder(border);
			frame.getContentPane().add(JLOAbierta);
			
			JTextPane TFAInformacion = new JTextPane();
			TFAInformacion.setText("COMO FUNCIONA?\n	Una oferta abierta consiste en darle la posibilidad al otro usuario de eligir una de tus publicaciones a cambio de su publicaci�n.\n	Esta tria por parte del otro usuario se realizar� en el Chat.\n		Suerte con la oferta!\"");
			TFAInformacion.setOpaque(false);
			TFAInformacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFAInformacion.setFocusable(false);
			TFAInformacion.setEditable(false);
			TFAInformacion.setText("COMO FUNCIONA?");
			TFAInformacion.setBounds(178, 119, 870, 318);
			frame.getContentPane().add(TFAInformacion);
			
		//Label informativo 
			JLabel lblProductoOferta = new JLabel("PRODUCTO OFERTA");
			lblProductoOferta.setForeground(new Color(139, 196, 68));
			lblProductoOferta.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			lblProductoOferta.setBounds(108, 464, 490, 37);
			frame.getContentPane().add(lblProductoOferta);
			
		//TextField para mostrar los datos del producto
			TFNombre = new JTextField(publi.getNombre());
			TFNombre.setHorizontalAlignment(SwingConstants.CENTER);
			TFNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFNombre.setEditable(false);
			TFNombre.setBounds(258, 511, 161, 59);
			frame.getContentPane().add(TFNombre);
			TFNombre.setColumns(10);
			
			TFDescripcion = new JTextField(publi.getDescripcion());
			TFDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
			TFDescripcion.setEditable(false);
			TFDescripcion.setColumns(10);
			TFDescripcion.setBounds(429, 511, 190, 59);
			frame.getContentPane().add(TFDescripcion);
			
			TFFecha = new JTextField(publi.getFecha());
			TFFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFFecha.setHorizontalAlignment(SwingConstants.CENTER);
			TFFecha.setEditable(false);
			TFFecha.setColumns(10);
			TFFecha.setBounds(629, 511, 133, 59);
			frame.getContentPane().add(TFFecha);
			
			TFCategoria = new JTextField(publi.getCategoria());
			TFCategoria.setHorizontalAlignment(SwingConstants.CENTER);
			TFCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFCategoria.setEditable(false);
			TFCategoria.setColumns(10);
			TFCategoria.setBounds(772, 511, 146, 59);
			frame.getContentPane().add(TFCategoria);
			
			TFEstado = new JTextField(publi.getEstado());
			TFEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFEstado.setHorizontalAlignment(SwingConstants.CENTER);
			TFEstado.setEditable(false);
			TFEstado.setColumns(10);
			TFEstado.setBounds(928, 511, 146, 59);
			frame.getContentPane().add(TFEstado);
			
			TFId = new JTextField(String.valueOf(publi.getId()));
			TFId.setHorizontalAlignment(SwingConstants.CENTER);
			TFId.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFId.setEditable(false);
			TFId.setColumns(10);
			TFId.setBounds(118, 511, 130, 59);
			frame.getContentPane().add(TFId);
			
		//Boton
			btnEnviar = new JButton("ENVIAR");
			btnEnviar.setForeground(Color.WHITE);
			btnEnviar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			btnEnviar.setBorder(UIManager.getBorder("Button.border"));
			btnEnviar.setBackground(new Color(52, 77, 160));
			btnEnviar.setBounds(1120, 502, 126, 74);
			frame.getContentPane().add(btnEnviar);		
	}
	/**
	 * Funci�n que almacena los eventos de la vista.
	 */
	public void eventos() {
		//Evento: crear una simulaci�n de oferta
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					SQLOferta sqloferta = new SQLOferta();
					sqloferta.crear(new Oferta(publi.getId(),true));
					
				}
			});
	}
	
}

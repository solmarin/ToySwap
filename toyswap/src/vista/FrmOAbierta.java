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
import javax.swing.JTextPane;
import javax.swing.JTextField;
/**
 * Clase para definir el diseño de la pantalla de ofertas abiertas.
 * @author Sol Marín
 * @version 1
 *
 */
public class FrmOAbierta {
	//Declaración y inicialización de variables globales
		private JFrame frame;
		private JTextField TFNombre;
		private JTextField TFDescripcion;
		private JTextField TFFecha;
		private JTextField TFCategoria;
		private JTextField TFEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOAbierta window = new FrmOAbierta();
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
	public FrmOAbierta() {
		diseño();
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
			
		//Icono información
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
			
			JTextPane TFAInformación = new JTextPane();
			TFAInformación.setOpaque(false);
			TFAInformación.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFAInformación.setFocusable(false);
			TFAInformación.setEditable(false);
			TFAInformación.setText("COMO FUNCIONA?");
			TFAInformación.setBounds(178, 119, 870, 318);
			frame.getContentPane().add(TFAInformación);
			
		//Label informativo 
			JLabel lblProductoOferta = new JLabel("PRODUCTO OFERTA");
			lblProductoOferta.setForeground(new Color(139, 196, 68));
			lblProductoOferta.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			lblProductoOferta.setBounds(108, 464, 490, 37);
			frame.getContentPane().add(lblProductoOferta);
			
		//TextField para mostrar los datos del producto
			TFNombre = new JTextField();
			TFNombre.setHorizontalAlignment(SwingConstants.CENTER);
			TFNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFNombre.setText("Coche");
			TFNombre.setEditable(false);
			TFNombre.setBounds(108, 511, 190, 59);
			frame.getContentPane().add(TFNombre);
			TFNombre.setColumns(10);
			
			TFDescripcion = new JTextField();
			TFDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFDescripcion.setText("Coche rayo rojo con...");
			TFDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
			TFDescripcion.setEditable(false);
			TFDescripcion.setColumns(10);
			TFDescripcion.setBounds(297, 511, 190, 59);
			frame.getContentPane().add(TFDescripcion);
			
			TFFecha = new JTextField();
			TFFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFFecha.setHorizontalAlignment(SwingConstants.CENTER);
			TFFecha.setText("2020/01/11");
			TFFecha.setEditable(false);
			TFFecha.setColumns(10);
			TFFecha.setBounds(485, 511, 190, 59);
			frame.getContentPane().add(TFFecha);
			
			TFCategoria = new JTextField();
			TFCategoria.setHorizontalAlignment(SwingConstants.CENTER);
			TFCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFCategoria.setText("Mu\u00F1eco");
			TFCategoria.setEditable(false);
			TFCategoria.setColumns(10);
			TFCategoria.setBounds(674, 511, 190, 59);
			frame.getContentPane().add(TFCategoria);
			
			TFEstado = new JTextField();
			TFEstado.setText("Nuevo");
			TFEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFEstado.setHorizontalAlignment(SwingConstants.CENTER);
			TFEstado.setEditable(false);
			TFEstado.setColumns(10);
			TFEstado.setBounds(858, 511, 190, 59);
			frame.getContentPane().add(TFEstado);
			
		//Boton
			JButton btnEnviar = new JButton("ENVIAR");
			btnEnviar.setForeground(Color.WHITE);
			btnEnviar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			btnEnviar.setBorder(UIManager.getBorder("Button.border"));
			btnEnviar.setBackground(new Color(52, 77, 160));
			btnEnviar.setBounds(1070, 502, 126, 74);
			frame.getContentPane().add(btnEnviar);
			
	}
}

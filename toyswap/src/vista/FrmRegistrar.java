package vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.FrmInicio;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
/**
 * Clase para definir el diseño de la ventana para registrarse.
 * @author Sol Marín
 * @version 1
 *
 */
public class FrmRegistrar {
	//Declaración y inicialización de variables globales
		public JFrame frame;
		private JTextField TFUsuario;
		private JTextField TFDni;
		private JTextField TFNombre;
		private JTextField TFApellidos;
		private JTextField TFDireccion;
		private JTextField TFEmail;
		private JTextField TFTelefono;
		private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistrar window = new FrmRegistrar();
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
	public FrmRegistrar() {
		diseño();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void diseño() {
		//Ventana
			frame = new JFrame();
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
			JLabel JLRegistrar = new JLabel("REGISTRAR");
			JLRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			JLRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
			JLRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLRegistrar.setBorder(UIManager.getBorder("ComboBox.border"));
			JLRegistrar.setOpaque(true);
			JLRegistrar.setBackground(Color.WHITE);
			JLRegistrar.setForeground((new Color(139, 196, 68)));
			JLRegistrar.setBounds(0, 0, 170, 60);
			JLRegistrar.setBorder(border);
			frame.getContentPane().add(JLRegistrar);
			
		//Labels informativos de cada campo
			
			JLabel JLUsuario = new JLabel("USUARIO");
			JLUsuario.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLUsuario.setForeground(new Color(52, 77, 160));
			JLUsuario.setBounds(173, 109, 91, 24);
			frame.getContentPane().add(JLUsuario);
			
			JLabel JLDni = new JLabel("DNI");
			JLDni.setForeground(new Color(52, 77, 160));
			JLDni.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLDni.setBounds(539, 109, 91, 24);
			frame.getContentPane().add(JLDni);
			
			JLabel JLContrasena = new JLabel("CONTRASE\u00D1A");
			JLContrasena.setForeground(new Color(52, 77, 160));
			JLContrasena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLContrasena.setBounds(879, 109, 130, 24);
			frame.getContentPane().add(JLContrasena);
			
			JLabel JLNombre = new JLabel("NOMBRE");
			JLNombre.setForeground(new Color(52, 77, 160));
			JLNombre.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLNombre.setBounds(173, 198, 91, 24);
			frame.getContentPane().add(JLNombre);
			
			JLabel JLApellidos = new JLabel("APELLIDOS");
			JLApellidos.setForeground(new Color(52, 77, 160));
			JLApellidos.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLApellidos.setBounds(539, 198, 91, 24);
			frame.getContentPane().add(JLApellidos);
			
			JLabel JLFechaNacimiento = new JLabel("FECHA DE NACIMIENTO");
			JLFechaNacimiento.setForeground(new Color(52, 77, 160));
			JLFechaNacimiento.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLFechaNacimiento.setBounds(879, 284, 204, 24);
			frame.getContentPane().add(JLFechaNacimiento);
			
			JLabel JLDireccion = new JLabel("DIRECCI\u00D3N");
			JLDireccion.setForeground(new Color(52, 77, 160));
			JLDireccion.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLDireccion.setBounds(173, 284, 104, 24);
			frame.getContentPane().add(JLDireccion);
			
			JLabel JLEmail = new JLabel("EMAIL");
			JLEmail.setForeground(new Color(52, 77, 160));
			JLEmail.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLEmail.setBounds(173, 377, 104, 24);
			frame.getContentPane().add(JLEmail);
			
			JLabel JLTelefono = new JLabel("TEL\u00C9FONO");
			JLTelefono.setForeground(new Color(52, 77, 160));
			JLTelefono.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLTelefono.setBounds(539, 377, 104, 24);
			frame.getContentPane().add(JLTelefono);
			
			JLabel JLSexo = new JLabel("SEXO");
			JLSexo.setForeground(new Color(52, 77, 160));
			JLSexo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLSexo.setBounds(879, 377, 104, 24);
			frame.getContentPane().add(JLSexo);
			
		//textField para rellenar información
			TFUsuario = new JTextField();
			TFUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFUsuario.setBounds(173, 143, 234, 24);
			frame.getContentPane().add(TFUsuario);
			TFUsuario.setColumns(10);
			
			TFDni = new JTextField();
			TFDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFDni.setColumns(10);
			TFDni.setBounds(539, 143, 234, 24);
			frame.getContentPane().add(TFDni);
			
			TFNombre = new JTextField();
			TFNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFNombre.setColumns(10);
			TFNombre.setBounds(173, 232, 234, 24);
			frame.getContentPane().add(TFNombre);
			
			TFApellidos = new JTextField();
			TFApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFApellidos.setColumns(10);
			TFApellidos.setBounds(539, 234, 584, 24);
			frame.getContentPane().add(TFApellidos);
			
			TFDireccion = new JTextField();
			TFDireccion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFDireccion.setColumns(10);
			TFDireccion.setBounds(173, 318, 600, 24);
			frame.getContentPane().add(TFDireccion);
			
			TFEmail = new JTextField();
			TFEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFEmail.setColumns(10);
			TFEmail.setBounds(173, 411, 234, 24);
			frame.getContentPane().add(TFEmail);
			
			TFTelefono = new JTextField();
			TFTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFTelefono.setColumns(10);
			TFTelefono.setBounds(539, 411, 234, 24);
			frame.getContentPane().add(TFTelefono);
			
		//Rellenar contraseña
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			passwordField.setBounds(879, 143, 234, 24);
			frame.getContentPane().add(passwordField);
			
			
			
		//Rellenar/elegir fecha de nacimiento
			JDateChooser calendarFechaNacimiento = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
			calendarFechaNacimiento.setLocale(new Locale("es"));
			calendarFechaNacimiento.setDateFormatString("yyyy/MM/dd");
			calendarFechaNacimiento.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
			calendarFechaNacimiento.setBounds(879, 318, 244, 24);
			frame.getContentPane().add(calendarFechaNacimiento);
		
		//Rellenar/elegir sexo
			JComboBox<String> comboBox = new JComboBox<String>();
			String[] opcionesSexo = {"Mujer","Hombre","Otros","No informar"};
			comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(opcionesSexo));
			comboBox.setBounds(879, 411, 244, 21);
			frame.getContentPane().add(comboBox);
			
		//Boton
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.setBorder(UIManager.getBorder("Button.border"));
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnRegistrar.setBounds(588, 520, 171, 60);
			btnRegistrar.setBackground(new Color(139, 196, 68));
			btnRegistrar.setForeground(Color.WHITE);
			frame.getContentPane().add(btnRegistrar);
			

		
	
	}
}

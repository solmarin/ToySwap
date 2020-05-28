package vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controlador.FrmInicio;
import datos.SQLUsuario;
import modelo.Usuario;

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
 * @version 2.2
 *
 */
public class FrmRegistrar {
	//Declaración y inicialización de variables globales
		public JFrame frame;
		private JTextField TFDni;
		private JTextField TFNombre;
		private JTextField TFApellidos;
		private JTextField TFEmail;
		private JTextField TFTelefono;
		private JPasswordField passwordField;
		private JButton btnRegistrar; 
		private JDateChooser calendarFechaNacimiento;
		private JComboBox<String> comboBox;


	/**
	 * Create the application.
	 */
	public FrmRegistrar() {
		diseño();
		eventos();
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
			
			JLabel JLDni = new JLabel("DNI");
			JLDni.setForeground(new Color(52, 77, 160));
			JLDni.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLDni.setBounds(173, 109, 91, 24);
			frame.getContentPane().add(JLDni);
			
			JLabel JLContrasena = new JLabel("CONTRASE\u00D1A");
			JLContrasena.setForeground(new Color(52, 77, 160));
			JLContrasena.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLContrasena.setBounds(539, 109, 130, 24);
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
			
			JLabel JLEmail = new JLabel("EMAIL");
			JLEmail.setForeground(new Color(52, 77, 160));
			JLEmail.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLEmail.setBounds(173, 284, 104, 24);
			frame.getContentPane().add(JLEmail);
			
			JLabel JLTelefono = new JLabel("TEL\u00C9FONO");
			JLTelefono.setForeground(new Color(52, 77, 160));
			JLTelefono.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLTelefono.setBounds(539, 284, 104, 24);
			frame.getContentPane().add(JLTelefono);
			
			JLabel JLSexo = new JLabel("SEXO");
			JLSexo.setForeground(new Color(52, 77, 160));
			JLSexo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLSexo.setBounds(879, 109, 104, 24);
			frame.getContentPane().add(JLSexo);
			
			TFDni = new JTextField();
			TFDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFDni.setColumns(10);
			TFDni.setBounds(173, 143, 234, 24);
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
			
			TFEmail = new JTextField();
			TFEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFEmail.setColumns(10);
			TFEmail.setBounds(173, 318, 234, 24);
			frame.getContentPane().add(TFEmail);
			
			TFTelefono = new JTextField();
			TFTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFTelefono.setColumns(10);
			TFTelefono.setBounds(539, 318, 234, 24);
			frame.getContentPane().add(TFTelefono);
			
		//Rellenar contraseña
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
			passwordField.setBounds(539, 143, 234, 24);
			frame.getContentPane().add(passwordField);
			
			
			
		//Rellenar/elegir fecha de nacimiento
			calendarFechaNacimiento = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
			calendarFechaNacimiento.setLocale(new Locale("es"));
			calendarFechaNacimiento.setDateFormatString("yyyy/MM/dd");
			calendarFechaNacimiento.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
			calendarFechaNacimiento.setBounds(879, 318, 244, 24);
			frame.getContentPane().add(calendarFechaNacimiento);
		
		//Rellenar/elegir sexo
			comboBox = new JComboBox<String>();
			String[] opcionesSexo = {"Mujer","Hombre","Otros","No informar"};
			comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(opcionesSexo));
			comboBox.setBounds(879, 143, 244, 21);
			frame.getContentPane().add(comboBox);
			
		//Boton
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.setBorder(UIManager.getBorder("Button.border"));
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnRegistrar.setBounds(539, 454, 234, 81);
			btnRegistrar.setBackground(new Color(139, 196, 68));
			btnRegistrar.setForeground(Color.WHITE);
			frame.getContentPane().add(btnRegistrar);
			
	}
	/**
	 * Función para almacenar los eventos de la vista.
	 */
	public void eventos() {
		
		//Evento: crear un nuevo usuario
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(TFDni.getText().length() == 9 && !String.valueOf(passwordField.getPassword()).isEmpty() && !String.valueOf(passwordField.getPassword()).isBlank() 
						&&!TFNombre.getText().isBlank() && !TFNombre.getText().isEmpty() && !TFApellidos.getText().isBlank() && !TFApellidos.getText().isEmpty()
						&&!fecha().isEmpty() &&!fecha().isBlank()  && !String.valueOf(sexo()).isEmpty() && !String.valueOf(sexo()).isBlank()  
						&&!TFEmail.getText().isEmpty() && !TFEmail.getText().isBlank() && !TFTelefono.getText().isEmpty() &&  Integer.parseInt(TFTelefono.getText()) > 99999999  && !TFTelefono.getText().isBlank()) {
					//consulta sql para generar el nuevo usuario
					SQLUsuario sqlusuario = new SQLUsuario();
					sqlusuario.crear(new Usuario(TFDni.getText(),String.valueOf(passwordField.getPassword()),TFNombre.getText(),TFApellidos.getText(),
							fecha(),sexo() ,TFEmail.getText(),Integer.parseInt(TFTelefono.getText()),false));
				}else {
					JOptionPane.showConfirmDialog(null, "ERROR: DATOS INCORRECTOS.\nComprouebe que todos los campos estan rellenos.\n"
							+ "Si el error persiste, contacte con el administrador.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
	}
	/**
	 * Función para controlar las entradas del usuario.
	 * @return
	 */
	public boolean camposCorrectos() {
		return true;
	}
	/**
	 * Función para determinar el sexo que guardar.
	 * @return char adecuado según el tipo de sexo seleccionado
	 */
	public char sexo() {
		char sexo = 'M';
		
		if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Mujer")) sexo = 'M';
		else if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Hombre")) sexo = 'H';
		else if(comboBox.getSelectedItem().toString().equalsIgnoreCase("Otros")) sexo = 'O';
		else sexo = '-';
		
		return sexo;
		
	}
	/**
	 * Función para devolver la fecha para guardar.
	 * @return devuelve la fecha en formato yyyy/MM/dd para almacenar en la bbdd.
	 */
	public String fecha() {
		
		String pattern  = "yyyy/MM/dd";
		DateFormat formatter = new SimpleDateFormat(pattern);
		String fecha = formatter.format(calendarFechaNacimiento.getDate()).toString();
		return fecha;
		
	}
	
}

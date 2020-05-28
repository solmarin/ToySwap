package controlador;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

import datos.SQLUsuario;
import modelo.Usuario;
import vista.FrmPrincipal;
import vista.FrmRegistrar;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

/**
 * Clase para crear la pantalla de login. 
 * @author Sol Marín
 * @version 2
 *
 */
public class FrmInicio {
	//Declaración de variables globales
		private JFrame frame;
		private JTextField TFUsuario;
		private JPasswordField passwordField;
		private JButton btnEntrar;
		private JButton btnRegistrar;
		private JCheckBox chckContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInicio window = new FrmInicio();
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
	public FrmInicio() {
		diseño();
		eventos();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void diseño() {
		//Creación de la ventana
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setLocationRelativeTo(null); //posición en medio de la pantalla
			frame.getContentPane().setBackground(new Color(228, 234, 232)); //crear color verde del fondo
			frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setLayout(null);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			

		//Logo
			JLabel JLImagen = new JLabel();
			JLImagen.setBorder(null);
			JLImagen.setBounds(27, 35, 60, 56);
			ImageIcon logo = new ImageIcon(FrmInicio.class.getResource("/res/logo.PNG"));
			Icon icono = new ImageIcon(logo.getImage().getScaledInstance(JLImagen.getWidth(), JLImagen.getHeight(), Image.SCALE_DEFAULT ));
			JLImagen.setIcon(icono);
			frame.getContentPane().add(JLImagen);
			
	   //Labels informativos
			JLabel JLUsuario = new JLabel("Usuario");
			JLUsuario.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLUsuario.setForeground(new Color(139, 196, 68));
			JLUsuario.setBounds(149, 45, 91, 24);
			frame.getContentPane().add(JLUsuario);
			
			TFUsuario = new JTextField();
			TFUsuario.setCaretColor(Color.LIGHT_GRAY);
			TFUsuario.setBorder(UIManager.getBorder("ComboBox.border"));
			TFUsuario.setBounds(149, 67, 136, 24);
			frame.getContentPane().add(TFUsuario);
			TFUsuario.setColumns(10);
			
		//Check para mostrar la contraseña
			chckContra = new JCheckBox();
			chckContra.setText("Mostrar");
			chckContra.setOpaque(false);
			chckContra.setBounds(289, 113, 91, 21);
			frame.getContentPane().add(chckContra);
			
			
		//Campos para rellenar
			JLabel JLContraseña = new JLabel("Contrase\u00F1a");
			JLContraseña.setForeground(new Color(139, 196, 68));
			JLContraseña.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
			JLContraseña.setBounds(149, 89, 142, 24);
			frame.getContentPane().add(JLContraseña);
			
			passwordField = new JPasswordField();
			passwordField.setCaretColor(Color.LIGHT_GRAY);
			passwordField.setBounds(149, 112, 136, 24);
			frame.getContentPane().add(passwordField);
			
		//Botones
			btnEntrar = new JButton("ENTRAR");
			btnEntrar.setBorder(UIManager.getBorder("Button.border"));
			btnEntrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
			btnEntrar.setBounds(181, 146, 80, 40);
			btnEntrar.setBackground(new Color(139, 196, 68));
			btnEntrar.setForeground(Color.WHITE);
			frame.getContentPane().add(btnEntrar);
			
			btnRegistrar = new JButton("REGISTRAR");
			btnRegistrar.setForeground(Color.WHITE);
			btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
			btnRegistrar.setBorder(UIManager.getBorder("Button.border"));
			btnRegistrar.setBackground(new Color(52, 77, 160));
			btnRegistrar.setBounds(336, 222, 100, 40);
			frame.getContentPane().add(btnRegistrar);

	}
	/**
	 * Función donde se almacenan todos los eventos de la vista.
	 */
	public void eventos() {
		//Evento: comprobar si existe un usuario para abrir el programa
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				comprobar();
				
			}
		});
		
		//Evento: para abrir la pantalla de registrar un usuario
		btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					FrmRegistrar frmregistrar = new FrmRegistrar();
					frmregistrar.frame.setVisible(true);
					
				}
			});
		//Evento: controlar si mostrar la contraseña o no
		chckContra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckContra.isSelected())passwordField.setEchoChar((char)0);
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
	}
	
	/**
	 * Función para comprobar si existe el usuario introducido y si la contraseña es correcta para abrir el programa principal.
	 */
	public void comprobar() {
		
		SQLUsuario sqlusuario = new SQLUsuario();
		ArrayList<Usuario> usu = null;
		
		usu = sqlusuario.consulta(TFUsuario.getText());
			 
		
		if(usu.isEmpty()) {
			JOptionPane.showConfirmDialog(null, "Error: el usuario no existe.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}else {
			//comprobamos si la contraseña es la misma para abrir el programa
			if(usu.get(0).getContrasena().contentEquals(String.valueOf(passwordField.getPassword()))) {
				FrmPrincipal frmprincipal = new FrmPrincipal(usu.get(0));
				frmprincipal.frame.setVisible(true);
			}else {
				JOptionPane.showConfirmDialog(null, "Error: contraseña incorrecta", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
				
			}
		}
		
	}
}

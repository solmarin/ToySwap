package vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.FrmInicio;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * Clase para crear la pantalla de ayudas.
 * @author sol
 * @version 1
 */
public class FrmAyuda {
	//Declaración de variables globales
		private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAyuda window = new FrmAyuda();
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
	public FrmAyuda() {
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
			
		//Icono informativo
			JLabel JLInfo= new JLabel();
			JLInfo.setBounds(10, 8, 71, 66);
			JLInfo.setForeground(Color.WHITE);
			JLInfo.setBackground(Color.WHITE);
			ImageIcon info = new ImageIcon(FrmAyuda.class.getResource("/res/info.png"));
			Icon iInfo = new ImageIcon(info.getImage().getScaledInstance(JLInfo.getWidth(), JLInfo.getHeight(), Image.SCALE_DEFAULT ));
			JLInfo.setIcon(iInfo);
			frame.getContentPane().add(JLInfo);
			
		//Labels informativos
			JLabel JLManuales = new JLabel("MANUALES/INSTRUCCIONES");
			JLManuales.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			JLManuales.setBounds(107, 100, 490, 37);
			JLManuales.setForeground((new Color(139, 196, 68)));
			frame.getContentPane().add(JLManuales);
			
			JLabel JLContacto = new JLabel("NOSOTROS/CONTACTO");
			JLContacto.setForeground(new Color(139, 196, 68));
			JLContacto.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			JLContacto.setBounds(107, 518, 490, 37);
			frame.getContentPane().add(JLContacto);
			
	  //Label donde se mostrará la información
			JLabel JLInfoExtraida = new JLabel("Texto de muestra");
			JLInfoExtraida.setFont(new Font("Tahoma", Font.PLAIN, 14));
			JLInfoExtraida.setVerticalAlignment(SwingConstants.TOP);
			JLInfoExtraida.setBounds(107, 565, 1058, 83);
			frame.getContentPane().add(JLInfoExtraida);
			
			JLabel JLManualesExtraida = new JLabel("Texto de muestra");
			JLManualesExtraida.setVerticalAlignment(SwingConstants.TOP);
			JLManualesExtraida.setFont(new Font("Tahoma", Font.PLAIN, 14));
			JLManualesExtraida.setBounds(107, 154, 1058, 354);
			frame.getContentPane().add(JLManualesExtraida);
			
	}

}

package vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controlador.FrmInicio;
import javax.swing.JTextField;

/**
 * Clase para definir el diseño de la pantalla principal.
 * @author Sol Marín
 * @version 1
 *
 */
public class FrmPrincipal {
	//Declaración y inicialización de variables globales
		private JFrame frame;
		private JTextField TFBuscador;
		private Object[] titulos = {"ID","PRODUCTO", "DESCRIPCIÓN", "FECHA","CATEGORIA","ESTADO"};
		private Object[] celdas = {};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal window = new FrmPrincipal();
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
	public FrmPrincipal() {
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
		
			
		//Botones
			JButton btnPerfil = new JButton("PERFIL");
			btnPerfil.setBorder(UIManager.getBorder("Button.border"));
			btnPerfil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnPerfil.setBounds(0, 0, 119, 60);
			btnPerfil.setBackground(Color.WHITE);
			btnPerfil.setForeground(new Color(139, 196, 68));
			frame.getContentPane().add(btnPerfil);
			
			JButton btnChats = new JButton("CHATS");
			btnChats.setForeground(new Color(139, 196, 68));
			btnChats.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
			btnChats.setBorder(UIManager.getBorder("Button.border"));
			btnChats.setBackground(Color.WHITE);
			btnChats.setBounds(543, 0, 109, 60);
			frame.getContentPane().add(btnChats);
			
			JButton btnAyuda = new JButton("");
			btnAyuda.setBorder(null);
			btnAyuda.setContentAreaFilled(false);
			btnAyuda.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/res/info.png")));
			btnAyuda.setBounds(653, 0, 65, 60);
			frame.getContentPane().add(btnAyuda);
			
			
		//Lista de filtros
			JComboBox<String> comboBox = new JComboBox<String>();
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
			scroll.setBounds(130, 150, 992, 382);;
			table.setBackground(Color.white);
			frame.getContentPane().add(scroll);
			
	}
}

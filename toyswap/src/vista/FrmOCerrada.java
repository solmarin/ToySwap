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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controlador.FrmInicio;
/**
 * Clase para definir el diseño de la oferta cerrada.
 * @author Sol Marín
 * @version 1
 *
 */
public class FrmOCerrada {
	//Declaración y inicialización de variables globales
		private JFrame frame;
		private JTextField TFNombre;
		private JTextField TFDescripcion;
		private JTextField TFFecha;
		private JTextField TFCategoria;
		private JTextField TFEstado;
		private Object[] titulos = {"ID", "PRODUCTO", "DESCRIPCIÓN", "FECHA","CATEGORIA","ESTADO"};
		private Object[] celdas = {};
		private JTextField TFId;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOCerrada window = new FrmOCerrada();
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
	public FrmOCerrada() {
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
			
		//Label informativo oferta cerrada
			Border border = LineBorder.createGrayLineBorder(); //borde negro
			JLabel JLOCerrada = new JLabel("OFERTA CERRADA");
			JLOCerrada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			JLOCerrada.setHorizontalAlignment(SwingConstants.CENTER);
			JLOCerrada.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLOCerrada.setBorder(UIManager.getBorder("ComboBox.border"));
			JLOCerrada.setOpaque(true);
			JLOCerrada.setBackground(Color.WHITE);
			JLOCerrada.setForeground((new Color(139, 196, 68)));
			JLOCerrada.setBounds(0, 0, 1194, 74);
			JLOCerrada.setBorder(border);
			frame.getContentPane().add(JLOCerrada);
			
		//Labels informativos
			JLabel lblSelecciona = new JLabel("SELECCIONA");
			lblSelecciona.setForeground(new Color(139, 196, 68));
			lblSelecciona.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			lblSelecciona.setBounds(95, 84, 490, 37);
			frame.getContentPane().add(lblSelecciona);
			
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
			TFNombre.setBounds(276, 511, 177, 59);
			frame.getContentPane().add(TFNombre);
			TFNombre.setColumns(10);
			
			TFDescripcion = new JTextField();
			TFDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFDescripcion.setText("Coche rayo rojo con...");
			TFDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
			TFDescripcion.setEditable(false);
			TFDescripcion.setColumns(10);
			TFDescripcion.setBounds(463, 511, 190, 59);
			frame.getContentPane().add(TFDescripcion);
			
			TFFecha = new JTextField();
			TFFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFFecha.setHorizontalAlignment(SwingConstants.CENTER);
			TFFecha.setText("2020/01/11");
			TFFecha.setEditable(false);
			TFFecha.setColumns(10);
			TFFecha.setBounds(663, 511, 139, 59);
			frame.getContentPane().add(TFFecha);
			
			TFCategoria = new JTextField();
			TFCategoria.setHorizontalAlignment(SwingConstants.CENTER);
			TFCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFCategoria.setText("Mu\u00F1eco");
			TFCategoria.setEditable(false);
			TFCategoria.setColumns(10);
			TFCategoria.setBounds(812, 511, 126, 59);
			frame.getContentPane().add(TFCategoria);
			
			TFEstado = new JTextField();
			TFEstado.setText("Nuevo");
			TFEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFEstado.setHorizontalAlignment(SwingConstants.CENTER);
			TFEstado.setEditable(false);
			TFEstado.setColumns(10);
			TFEstado.setBounds(948, 511, 146, 59);
			frame.getContentPane().add(TFEstado);
			
			TFId = new JTextField();
			TFId.setText("1");
			TFId.setHorizontalAlignment(SwingConstants.CENTER);
			TFId.setFont(new Font("Tahoma", Font.PLAIN, 16));
			TFId.setEditable(false);
			TFId.setColumns(10);
			TFId.setBounds(151, 511, 115, 59);
			frame.getContentPane().add(TFId);
			
		//Boton
			JButton btnEnviar = new JButton("ENVIAR");
			btnEnviar.setForeground(Color.WHITE);
			btnEnviar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			btnEnviar.setBorder(UIManager.getBorder("Button.border"));
			btnEnviar.setBackground(new Color(52, 77, 160));
			btnEnviar.setBounds(1122, 502, 126, 74);
			frame.getContentPane().add(btnEnviar);
			
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
			model.addRow(new Object[] {"2", "COD","JUEGO DE PS4","2020/02/10","PS4","2 mano"}); //ejemplo de campos
			JTable table = new JTable();
			table.setShowVerticalLines(false);
			table.setGridColor(Color.white);
			table.setForeground(new Color(0, 0, 0));
			table.setEnabled(true);
			table.setModel(model);
		    table.setFont(new Font("FreeSans", Font.ITALIC, 16));
		    
			table.setRowHeight(18);
			scroll.setViewportView(table);
			scroll.setBounds(128, 141, 700, 283);;
			table.setBackground(Color.white);
			frame.getContentPane().add(scroll);
			
			
			
		
	}

}

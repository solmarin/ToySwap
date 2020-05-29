package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import controlador.FrmInicio;
import datos.SQLPublicacion;
import datos.SQLUsuario;
import modelo.Publicacion;
import modelo.Usuario;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 * Clase para definir la estructura de la vista del perfil del usuario.
 * @author Sol Marín
 * @version 3.2
 *
 */
public class FrmUsuario {
	//Declaración y inicialización de variables globales
		JFrame frame;
		private JTextField TFDni;
		private JTextField TFNombre;
		private JTextField TFApellidos;
		private JTextField TFFechaNacimiento;
		private JTextField TFSexo;
		private JTextField TFEmail;
		private JTextField TFTelefono;
		private JPasswordField pwdContrasea;
		private Object[] titulos = {"ID","PRODUCTO", "DESCRIPCIÓN", "ESTADO","FECHA","CATEGORIA"};
		private Object[] celdas = {};
		private Usuario usuario;
		private DefaultTableModel model;
		private JTable table;
		private JButton btnNuevaPubli;
		private JButton btnEliminarPubli;
		private JButton btnEditar;
		private JButton btnSolEliminar;
		private JButton btnGuardar;
		private JComboBox<String> comboBox;
		private JDateChooser calendarFechaNacimiento;
		private boolean editar = false;
		private boolean nueva = false;
		private boolean eliminar = false;
		private JTextField TFNombreP;
		private JTextField TFDescP;
		private JTextField TFFechaP;
		private JTextField TFCategoriaP;
		private JTextField TFEstadoP;

	/**
	 * Create the application.
	 * @param usuario 
	 */
	public FrmUsuario(Usuario usuario) {
		this.usuario = usuario;
		diseño();
		eventos();
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
			TFFechaNacimiento.setBounds(704, 158, 150, 24);
			frame.getContentPane().add(TFFechaNacimiento);
			
			if(usuario.getSexo() == 'M') TFSexo = new JTextField("Mujer");
			if(usuario.getSexo() == 'H') TFSexo = new JTextField("Hombre");
			if(usuario.getSexo() == 'O') TFSexo = new JTextField("Otros");
			if(usuario.getSexo() == '-') TFSexo = new JTextField("-");
			
			TFSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFSexo.setEditable(false);
			TFSexo.setColumns(10);
			TFSexo.setBounds(704, 124, 150, 24);
			frame.getContentPane().add(TFSexo);
			
			TFEmail = new JTextField(usuario.getEmail());
			TFEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFEmail.setEditable(false);
			TFEmail.setColumns(10);
			TFEmail.setBounds(211, 226, 310, 24);
			frame.getContentPane().add(TFEmail);
			
			TFTelefono = new JTextField(String.valueOf(usuario.getTelefono()));
			TFTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
			TFTelefono.setEditable(false);
			TFTelefono.setColumns(10);
			TFTelefono.setBounds(211, 192, 310, 24);
			frame.getContentPane().add(TFTelefono);
			
			pwdContrasea = new JPasswordField(usuario.getContrasena());
			pwdContrasea.setEditable(false);
			pwdContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			pwdContrasea.setBounds(704, 192, 310, 24);
			frame.getContentPane().add(pwdContrasea);
			
			//Label informativo
			JLabel JLPubli = new JLabel("PUBLICACIONES");
			JLPubli.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
			JLPubli.setBounds(90, 287, 181, 37);
			JLPubli.setForeground((new Color(139, 196, 68)));
			frame.getContentPane().add(JLPubli);
			
			
			//Tabla con scroll
				JScrollPane scroll = new JScrollPane();
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
				table = new JTable();
				table.setShowVerticalLines(false);
				table.setGridColor(Color.white);
				table.setForeground(new Color(0, 0, 0));
				table.setEnabled(true);
				table.setModel(model);
			    table.setFont(new Font("FreeSans", Font.ITALIC, 16));
				table.setRowHeight(18);
				scroll.setViewportView(table);
				scroll.setBounds(173, 354, 852, 233);;
				table.setBackground(Color.white);
				table.getTableHeader().setReorderingAllowed(false);
				frame.getContentPane().add(scroll);
			
			//Botones
				btnNuevaPubli = new JButton("NUEVA");
				btnNuevaPubli.setBorder(UIManager.getBorder("Button.border"));
				btnNuevaPubli.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				btnNuevaPubli.setBounds(281, 276, 102, 51);
				btnNuevaPubli.setBackground(new Color(139, 196, 68));
				btnNuevaPubli.setForeground(Color.WHITE);
				frame.getContentPane().add(btnNuevaPubli);
				
				btnEliminarPubli = new JButton("ELIMINAR");
				btnEliminarPubli.setForeground(Color.WHITE);
				btnEliminarPubli.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
				btnEliminarPubli.setBorder(UIManager.getBorder("Button.border"));
				btnEliminarPubli.setBackground(new Color(52, 77, 160));
				btnEliminarPubli.setBounds(381, 276, 102, 51);
				frame.getContentPane().add(btnEliminarPubli);
				
				btnEditar = new JButton("EDITAR");
				btnEditar.setForeground(Color.WHITE);
				btnEditar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				btnEditar.setBorder(UIManager.getBorder("Button.border"));
				btnEditar.setBackground(new Color(139, 196, 68));
				btnEditar.setBounds(168, 0, 118, 60);
				frame.getContentPane().add(btnEditar);
				
				btnSolEliminar = new JButton("SOLICITAR ELIMINAR");
				btnSolEliminar.setHideActionText(true);
				btnSolEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
				btnSolEliminar.setForeground(Color.WHITE);
				btnSolEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				btnSolEliminar.setBorder(UIManager.getBorder("Button.border"));
				btnSolEliminar.setBackground(new Color(52, 77, 160));
				btnSolEliminar.setBounds(283, 0, 181, 60);
				frame.getContentPane().add(btnSolEliminar);
				
				btnGuardar = new JButton("GUARDAR");
				btnGuardar.setForeground(Color.WHITE);
				btnGuardar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
				btnGuardar.setBorder(UIManager.getBorder("Button.border"));
				btnGuardar.setBackground(new Color(139, 196, 68));
				btnGuardar.setBounds(1083, 139, 118, 60);
				btnGuardar.setVisible(false);
				frame.getContentPane().add(btnGuardar);
				
				TFNombreP = new JTextField((String) null);
				TFNombreP.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TFNombreP.setEditable(false);
				TFNombreP.setColumns(10);
				TFNombreP.setVisible(false);
				TFNombreP.setBounds(318, 618, 135, 24);
				frame.getContentPane().add(TFNombreP);
				
				TFDescP = new JTextField((String) null);
				TFDescP.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TFDescP.setEditable(false);
				TFDescP.setColumns(10);
				TFDescP.setVisible(false);
				TFDescP.setBounds(463, 618, 135, 24);
				frame.getContentPane().add(TFDescP);
				
				TFFechaP = new JTextField((String) null);
				TFFechaP.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TFFechaP.setEditable(false);
				TFFechaP.setColumns(10);
				TFFechaP.setVisible(false);
				TFFechaP.setBounds(744, 618, 135, 24);
				frame.getContentPane().add(TFFechaP);
				
				TFCategoriaP = new JTextField((String) null);
				TFCategoriaP.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TFCategoriaP.setEditable(false);
				TFCategoriaP.setColumns(10);
				TFCategoriaP.setVisible(false);
				TFCategoriaP.setBounds(889, 618, 135, 24);
				frame.getContentPane().add(TFCategoriaP);
				
				TFEstadoP = new JTextField((String) null);
				TFEstadoP.setFont(new Font("Tahoma", Font.PLAIN, 14));
				TFEstadoP.setEditable(false);
				TFEstadoP.setColumns(10);
				TFEstadoP.setVisible(false);
				TFEstadoP.setBounds(608, 618, 126, 24);
				frame.getContentPane().add(TFEstadoP);
				
			//Actualizar tabla del usuario
				actualizarTabla(usuario.getDni(),"dni");
	}
	/**
	 * Función que almacena los eventos de la vista.
	 */
	public void eventos() {
		//Evento: editar los campos del usuario
			btnEditar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					editar = true;
					nueva = true;
					eliminar = false;
					editarVista();
					
				
				}
			});
			
		//Evento: crear nueva publicacion
		btnNuevaPubli.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nueva = true;
				editar = false;
				eliminar = false;
				editarVista();
			
			}
		});
		
		//Evento: eliminar una publicación
		btnEliminarPubli.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				nueva = false;
				editar = false;
				eliminar = true;
				editarVista();
				
			}
		});
			
		
		//Evento: guardar los cambios
			btnGuardar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					
					if(editar) editar();
					else if (nueva) {
						nueva();
						actualizarTabla(usuario.getDni(),"dni");
					}else if(eliminar) {
						if(table.getSelectedRow() >0) {
							int dialogResult = JOptionPane.showConfirmDialog (null, "Seguro que quieres eliminar la publicación?","ELIMINAR PUBLICACIÓN",JOptionPane.YES_NO_OPTION);
							 if(dialogResult == JOptionPane.YES_OPTION) {
								 eliminar(Integer.parseInt(String.valueOf(table.getValueAt(table.getSelectedRow(), 0))));
							
							 }
							 actualizarTabla(usuario.getDni(),"dni");
						}else {
							JOptionPane.showConfirmDialog(null, "INFO: NO HAY NINGUNA PUBLICACIÓN PARA ELIMINAR.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
						}
					}
					
					resetDiseño();
					
				
				}
			});
			
			//Evento: "enviar" solicitud de eliminación
			btnSolEliminar.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					solElimFichero();
					
				}
			});
	}
	
	/**
	 * Función para actualizar la tabla.
	 * @param x = dni
	 * @param filtro = dni
	 */
	public void actualizarTabla(String x, String filtro) {
		try {
		 model.setRowCount(0);
		 SQLPublicacion sqlpublicacion = new SQLPublicacion();
		 for(Publicacion c: sqlpublicacion.consultarFiltrando(x,filtro)) {
		    	if(c != null) {
		    		int id = c.getId();
					String nombre = c.getNombre();
					String descripcion = c.getDescripcion();
					String estado = c.getEstado();
					String fecha = c.getFecha();
					String categoria = c.getCategoria();
					model.addRow(new Object[] {id, nombre,  descripcion,  estado, fecha, categoria});
		    	}
		    }
		 } catch (NumberFormatException e) {
				JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		 }	
	}
	/**
	 * Función editar un usuario.
	 */
	public void editar() {
		
		if(!String.valueOf(pwdContrasea.getPassword()).isEmpty() && !String.valueOf(pwdContrasea.getPassword()).isBlank() 
			&&!TFNombre.getText().isBlank() && !TFNombre.getText().isEmpty() && !TFApellidos.getText().isBlank() && !TFApellidos.getText().isEmpty()
			&&!fecha().isEmpty() &&!fecha().isBlank()  && !String.valueOf(sexo()).isEmpty() && !String.valueOf(sexo()).isBlank()  
			&&!TFEmail.getText().isEmpty() && !TFEmail.getText().isBlank() && !TFTelefono.getText().isEmpty() && !TFTelefono.getText().isBlank()) {
			
			SQLUsuario sqlusuario = new SQLUsuario();
			sqlusuario.editar(TFDni.getText(), String.valueOf(pwdContrasea.getPassword()), TFNombre.getText(), TFApellidos.getText(),fecha() , 
					sexo(), TFEmail.getText(), Integer.parseInt(TFTelefono.getText()), false);
			
		}else {
			JOptionPane.showConfirmDialog(null, "ERROR: DATOS INCORRECTOS.\nComprouebe que todos los campos estan rellenos.\n"
					+ "Si el error persiste, contacte con el administrador.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	/**
	 * Función para crear una nueva publicación
	 */
	public void nueva() {
		
		if(usuario.getDni().length()!=9 || Character.isDigit(usuario.getDni().charAt(8))) {
			JOptionPane.showConfirmDialog(null, "DATOS INCORRECTOS.\nIntroduzca un dni correcto (8 digitos y 1 letra).\nEjemplo: 12345678A", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
		}else if(!TFNombreP.getText().isEmpty() && !TFDescP.getText().isEmpty() && !TFEstadoP.getText().isEmpty() &&
			!TFCategoriaP.getText().isEmpty() && !TFDni.getText().isBlank() && !TFNombreP.getText().isBlank() && !TFDescP.getText().isBlank() 
			&& !TFEstadoP.getText().isBlank() && !TFCategoriaP.getText().isBlank()) {
			
			SQLPublicacion sqlpubli = new SQLPublicacion();
			sqlpubli.crear(new Publicacion(usuario.getDni(),TFNombreP.getText(),TFDescP.getText(), TFEstadoP.getText(),TFCategoriaP.getText()));	
		}else {
			JOptionPane.showConfirmDialog(null, "ERROR: DATOS INCORRECTOS.\nComprouebe que todos los campos estan rellenos.\n"
					+ "Si el error persiste, contacte con el administrador.", "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}
		
	}
	/**
	 * Función para eliminar una publicación.
	 */
	public void eliminar(int id) {		
			SQLPublicacion sqlpubli = new SQLPublicacion();
			sqlpubli.eliminar(id);
			model.setRowCount(0);
		
	}
	/**
	 * Función que escribe en un fichero la "solicitud de eliminación".
	 */
	public void solElimFichero() {
		//fichero donde escribir
		FileReader fichero = null;
	    Scanner entrada = null;
	    Boolean encontrado = false;
		try {

			fichero = new FileReader("solElim.txt");
			
			entrada = new Scanner(fichero);
			
			while (entrada.hasNext() && !encontrado) { 
                if (entrada.nextLine().contains(usuario.getDni()))  encontrado = true;
            }
			
            if(encontrado){ 
				JOptionPane.showMessageDialog(null, "Ya tiene una solicitud en proceso.\nEstamos trabajando en ello.\nGracias.");
                
            }else {
            	FileWriter ficheroEscribir = new FileWriter("solElim.txt",true);
				// Escribimos linea a linea en el fichero
				ficheroEscribir.write("Fecha solicitud: "+fechaSol()+" - DNI:" + usuario.getDni()+"\n");
				ficheroEscribir.close();
				JOptionPane.showMessageDialog(null, "SOLICITUD ENVIADA. ");
            }

			fichero.close();
			


		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD: ERROR AL ENVIAR LA SOLICITUD CONTACTE CON EL ADMINISTRADOR."+ex.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);

		}
		
	}
	/**
	 * Función para obtener la fecha actual.
	 */
	public String fechaSol() {
		Calendar cal;
		String sFecha;
		
		cal = Calendar.getInstance();
		
		sFecha = Integer.toString(cal.get(Calendar.YEAR))+"/"
				+ Integer.toString(cal.get(Calendar.MONTH))+"/"
				+ Integer.toString(cal.get(Calendar.DATE))+" ";
		
		return sFecha;
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
	 * Función que habilita/deshabilita opciones al clicar el botón editar.
	 */
	public void editarVista() {
		//activar y desactivar botones
			btnEditar.setEnabled(false);
			btnSolEliminar.setEnabled(false);
			btnEliminarPubli.setEnabled(false);
			btnNuevaPubli.setEnabled(false);
			btnGuardar.setEnabled(true);
			btnGuardar.setVisible(true);
			
			if(editar) {
				//activar campos
					TFNombre.setEditable(true);
					TFApellidos.setEditable(true);
					TFFechaNacimiento.setEditable(false);
					TFFechaNacimiento.setVisible(false);
					TFSexo.setVisible(false);
					TFSexo.setEditable(false);
					TFEmail.setEditable(true);
					TFTelefono.setEditable(true);
					pwdContrasea.setEditable(true);
					table.setEnabled(false);
					
				
				//Rellenar/elegir sexo
					comboBox = new JComboBox<String>();
					String[] opcionesSexo = {"Mujer","Hombre","Otros","No informar"};
					comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(opcionesSexo));
					comboBox.setSelectedItem(TFSexo.getText()); //poner el sexo actual
					comboBox.setBounds(704, 124, 150, 24);
					comboBox.setVisible(true);
					frame.getContentPane().add(comboBox);
					
				//Rellenar/elegir fecha de nacimiento
					calendarFechaNacimiento = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
					calendarFechaNacimiento.setLocale(new Locale("es"));
					calendarFechaNacimiento.setDateFormatString("yyyy/MM/dd");
					calendarFechaNacimiento.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 14));
					calendarFechaNacimiento.setVisible(true);
					calendarFechaNacimiento.setBounds(704, 158, 150, 24);
					
					Date date = null;
					try {
						date = new SimpleDateFormat("yyyy/MM/dd").parse(TFFechaNacimiento.getText());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						JOptionPane.showConfirmDialog(null, "CONTACTE TECNICO BBDD:"+e.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
					} 
					//poner la fecha actual
					calendarFechaNacimiento.setDate(date);
					frame.getContentPane().add(calendarFechaNacimiento);
					
			} else if(nueva) {
				TFNombreP.setEditable(true);
				TFNombreP.setVisible(true);
				TFDescP.setEditable(true);
				TFDescP.setVisible(true);
				TFFechaP.setVisible(true);
				TFFechaP.setText("HOY");
				TFCategoriaP.setEditable(true);
				TFCategoriaP.setVisible(true);
				TFEstadoP.setEditable(true);
				TFEstadoP.setVisible(true);
				
			}
	}
	/**
	 * Función para volver a las funcionalidades/diseño inicial.
	 */
	public void resetDiseño() {
		
			editar=false;
			nueva = false;
		
		//activar y desactivar botones
			btnEditar.setEnabled(true);
			btnSolEliminar.setEnabled(true);
			btnEliminarPubli.setEnabled(true);
			btnNuevaPubli.setEnabled(true);
			btnGuardar.setEnabled(false);
			btnGuardar.setVisible(false);
			
		//activar campos
			TFNombre.setEditable(false);
			TFApellidos.setEditable(false);
			TFFechaNacimiento.setEditable(false);
			TFFechaNacimiento.setVisible(true);
			TFSexo.setVisible(true);
			TFSexo.setEditable(false);
			TFEmail.setEditable(false);
			TFTelefono.setEditable(false);
			pwdContrasea.setEditable(false);
			table.setEnabled(true);
	
			
			
		//Actualizar los datos del usuario
			SQLUsuario sqlusu = new SQLUsuario();
			this.usuario = sqlusu.consulta(usuario.getDni()).get(0);
			TFDni.setText(usuario.getDni());
			TFNombre.setText(usuario.getNombre());
			TFApellidos.setText(usuario.getApellidos());
			TFTelefono.setText(String.valueOf(usuario.getTelefono()));
			TFEmail.setText(usuario.getEmail());
			TFFechaNacimiento.setText(usuario.getFechaNacimiento());
			if(usuario.getSexo() == 'M') TFSexo.setText("Mujer");
			if(usuario.getSexo() == 'H') TFSexo.setText("Hombre");
			if(usuario.getSexo() == 'O') TFSexo.setText("Otros");
			if(usuario.getSexo() == '-') TFSexo.setText("-");
			
			
		//Desaparecer parametros de la publicación nueva
			TFNombreP.setEditable(false);
			TFNombreP.setVisible(false);
			TFDescP.setEditable(false);
			TFDescP.setVisible(false);
			TFFechaP.setVisible(false);
			TFCategoriaP.setEditable(false);
			TFCategoriaP.setVisible(false);
			TFEstadoP.setEditable(false);
			TFEstadoP.setVisible(false);
			
	}
	
	
	
	
}

package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;

public class AltasModificar extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDNI;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfcorreo;
	private JTextField tftelefono;
	private JTextField tfedad;
 Paciente paciente = new Paciente();
	
	
	
	private String stf1="Introduzca nombre",stf2= "Introduzca apellido",
			stf3 = "Introduzca DNI",stf4 = "Introduzca correo",stf5 = "Introduzca telefono",stf6="Introduzca edad";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ArrayList<String> b = null;
		Conexion con = null;


	
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			
					AltasModificar modificar = new AltasModificar(b,con,null,true);
					//metodo para que la pantalla sea en pantalla completa
				
					modificar.setVisible(true);
					modificar.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltasModificar(ArrayList<String> a, Conexion con,InicioAdmin parent,boolean modal) {
		super(parent,modal);
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(null);
				
				
				
				
				//AÑADIR EN LA TABLA EL SELECCIONADO
				
				//DISEÑO
				
				//PRIMERA SELECCION
				
				tfDNI = new JTextField();
				tfDNI.setForeground(new Color(192, 192, 192));
				tfDNI.setText("Introduzca DNI");
				tfDNI.setFont(new Font("Calibri", Font.PLAIN, 15));
				tfDNI.setBounds(124, 241, 189, 30);
				contentPane.add(tfDNI);
				tfDNI.setColumns(10);
				
			
			

		
				
				//SEGUNDA SELECCION
				//text field apellidos
				tfNombre = new JTextField();
				tfNombre.setForeground(new Color(192, 192, 192));
				tfNombre.setText("Introduzca Nombre");
				tfNombre.setFont(new Font("Calibri", Font.PLAIN, 15));
				tfNombre.setBounds(124, 304, 189, 30);
				contentPane.add(tfNombre);
				tfNombre.setColumns(10);
				
				JLabel lblFotoUser = new JLabel();
				lblFotoUser.setBounds(154, 72, 120, 120);
				ImageIcon imagen= new ImageIcon(getClass().getResource("user.png"));
				ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
				lblFotoUser.setIcon(imagen2);
				contentPane.add(lblFotoUser);
				
				JButton btnVolver = new JButton("Volver");
				btnVolver.setBounds(23, 10, 76, 64);
				btnVolver.setBackground(new Color(207, 241, 255));
				btnVolver.setForeground(new Color(255, 255, 255));
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				ImageIcon i7 = new ImageIcon(getClass().getResource("volver.png"));
				ImageIcon i8 = new ImageIcon(i7.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
				btnVolver.setIcon(i8);
				contentPane.add(btnVolver);
				
				tfApellido = new JTextField();
				tfApellido.setForeground(new Color(192, 192, 192));
				tfApellido.setText("Introduzca Apellido");
				tfApellido.setFont(new Font("Calibri", Font.PLAIN, 15));
				tfApellido.setBounds(124, 360, 189, 30);
				contentPane.add(tfApellido);
				tfApellido.setColumns(10);
				
				tfcorreo = new JTextField();
				tfcorreo.setForeground(new Color(192, 192, 192));
				tfcorreo.setText("Introduzca correo electronico");
				tfcorreo.setFont(new Font("Calibri", Font.PLAIN, 15));
				tfcorreo.setBounds(124, 418, 189, 30);
				contentPane.add(tfcorreo);
				tfcorreo.setColumns(10);
				
				tftelefono = new JTextField();
				tftelefono.setForeground(new Color(192, 192, 192));
				tftelefono.setText("Introduzca el telefono");
				tftelefono.setFont(new Font("Calibri", Font.PLAIN, 15));
				tftelefono.setBounds(124, 465, 189, 30);
				contentPane.add(tftelefono);
				tftelefono.setColumns(10);
				
				tfedad = new JTextField();
				tfedad.setForeground(new Color(192, 192, 192));
				tfedad.setText("Introduzca edad");
				tfedad.setFont(new Font("Calibri", Font.PLAIN, 15));
				tfedad.setBounds(124, 518, 189, 30);
				contentPane.add(tfedad);
				tfedad.setColumns(10);
				
				
		
				
				
				
				
				//-----------------------Para que desaparezca y aparezca cuando este vacio----------------
				
				
				tfDNI.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
							tfDNI.setText("");
							tfDNI.setForeground(new Color(0,0,0));
							
						
					}
					
				});
				
				tfDNI.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfDNI.getText().isEmpty()) {
							
							
							tfDNI.setText(stf1);
							tfDNI.setForeground(new Color(192,192,192));
							
						}
					}
				});
				tfNombre.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tfNombre.setText("");
						tfNombre.setForeground(new Color(0,0,0));
						
					}
					
				});
				
				tfNombre.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfNombre.getText().isEmpty()) {
							
							
							tfNombre.setText(stf2);
							tfNombre.setForeground(new Color(192,192,192));
						}
					}
				});
				
				tfApellido.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tfApellido.setText("");
					
						tfApellido.setForeground(new Color(0,0,0));
						
					}
					
				});
				
				tfApellido.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfApellido.getText().isEmpty()) {
							
							
							tfApellido.setText(stf3);
							tfApellido.setForeground(new Color(192,192,192));
						}
					}
				});
				tfcorreo.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tfcorreo.setText("");
						tfcorreo.setForeground(new Color(0,0,0));
						
					}
					
				});
				
				tfcorreo.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfcorreo.getText().isEmpty()) {
							
							
							tfcorreo.setText(stf4);
							tfcorreo.setForeground(new Color(192,192,192));
						}
					}
				});
				tftelefono.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tftelefono.setText("");
						tftelefono.setForeground(new Color(0,0,0));
						
					}
					
				});
				
				tftelefono.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tftelefono.getText().isEmpty()) {
							
							
							tftelefono.setText(stf5);
							tftelefono.setForeground(new Color(192,192,192));
						}
					}
				});
				tfedad.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tfedad.setText("");
						tfedad.setForeground(new Color(0,0,0));
					}
					
				});
				
				tfedad.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfedad.getText().isEmpty()) {
							
							
							tfedad.setText(stf6);
							tfedad.setForeground(new Color(192,192,192));
						}
					}
				});
				
				
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(407, 222, 560, 326);
                scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
                getContentPane().add(scrollPane);

                // Personalizo la tabla
                JTable table_1 = new JTable();
                //desactiva la la tabla para que no se pueda cambiar
                table_1.setEnabled(false);
                //objeto para editar encabezado
                JTableHeader header = table_1.getTableHeader(); 
                header.setForeground(Color.black); 
                header.setBackground(new Color(207, 241, 255));
                table_1.setIntercellSpacing(new Dimension(4, 4));
                // ajusta el alto de las columnas de la tabla
                table_1.setRowHeight(30);
                // Cambia el color de fondo de las filas seleccionadas
                table_1.setSelectionBackground(new Color(217, 217, 217)); 
                table_1.setSelectionForeground(Color.BLACK);
                DefaultTableModel model;
				table_1.setModel(model = new DefaultTableModel(new Object[][] {
                }, new String[] { "DNIpaciente", "Nombre", "Apellidos", "Correo", "Telefono", "Edad" }));
                table_1.getColumnModel().getColumn(1).setMinWidth(23);
                scrollPane.setViewportView(table_1);
                paciente.CargarTabla(model,table_1);
                
		
                
		
                
                
                //BOTON FUNCIONALIDAD
                
                JButton btnAnadir = new JButton("Modificar");
                btnAnadir.setBounds(407, 162, 560, 30);
                contentPane.add(btnAnadir);
                btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 22));
                btnAnadir.setForeground(new Color(0, 0, 0));
                btnAnadir.setBackground(new Color (207, 241, 255));
                btnAnadir.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		String dni=tfDNI.getText();
                		String apellido=tfApellido.getText();
                		String nombre = tfNombre.getText();
                		String correo=tfcorreo.getText();
                		int telefono= Integer.parseInt(tftelefono.getText());
                		int edad =Integer.parseInt(tfedad.getText());
                		String sentencia = "UPDATE dentiapp.pacientes " +
                                "SET Nombre='" + nombre + "', " +
                                "Apellidos='" + apellido + "', " +
                                "correo='" + correo + "', " +
                                "telefono=" + telefono + ", " +
                                "edad=" + edad + " " +
                                "WHERE DNIpaciente='" + dni + "';";            			
                		boolean status = false;
            			status = conexion.insertar(conexion,sentencia);
            			if (status=true) {
            				
            			}
            			paciente.CargarTabla(model, table_1);
                	}
                });


				
				
	}public void clearTxtField(JTextField text) {
		text.setText("");
	}
}

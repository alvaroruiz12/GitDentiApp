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

public class DoctorModificar extends JDialog {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	Especialidad especialidad = new Especialidad();
 Doctor doctor = new Doctor();
	
	
	
	private String stf1="Introduzca DNI",stf2= "Introduzca Nombre",
			stf3 = "Introduzca idusuario",stf4 = "Introduzca idespecialidad";
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ArrayList<String> b = null;
		Conexion con = null;


	
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			
					DoctorModificar modificar = new DoctorModificar(b,con,null,true);
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
	public DoctorModificar(ArrayList<String> a, Conexion con,InicioAdmin parent,boolean modal) {
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
				
				//SEGUNDA SELECCION
				
				tfNombre = new JTextField();
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
				
				
		
				JLabel textoDNI = new JLabel("DNI");
				textoDNI.setBounds(124, 243, 189, 30);
				textoDNI.setFont(new Font("Arial", Font.PLAIN, 20));
				textoDNI.setForeground(Color.white);
				textoDNI.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(textoDNI);
				
				
				
				// combobox doctor
				JComboBox comboBoxDoctor = new JComboBox();
				// cargar datos al combobox

				// esto da null

				int tamañoNombre = 0;
				// metodo recoge el nombre y el dni

				ArrayList<String> Dni=doctor.CargarDNIDoctorCitas();
				ArrayList<String> Nombre=doctor.CargarNombreDoctorCitas();

				System.out.println(Nombre);
				// mete los nombres en el combobox
				for (int i = 0; i < Nombre.size(); i++) {
					comboBoxDoctor.addItem(Nombre.get(i).toString());
				}

				comboBoxDoctor.setBounds(406, 107, 157, 33);
				getContentPane().add(comboBoxDoctor);
				
				JComboBox comboEspecialidad = new JComboBox();
				int tamañoNombreEspecialidad = 0;
				// metodo recoge el nombre y el dni

				ArrayList<String> idEspecialidad=especialidad.CargarNumeroEspecialidad();
				ArrayList<String> NombreEspecialidad=especialidad.CargarNombreEspecialidad();

				// mete los nombres en el combobox
				for (int i = 0; i < NombreEspecialidad.size(); i++) {
					comboEspecialidad.addItem(NombreEspecialidad.get(i).toString());
				}

				
				comboEspecialidad.setBounds(124, 361, 189, 30);
				contentPane.add(comboEspecialidad);
				
				
				
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(406, 160, 560, 326);
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
        		header.setFont(new Font("Arial", Font.PLAIN, 20));

                table_1.setIntercellSpacing(new Dimension(4, 4));
                // ajusta el alto de las columnas de la tabla
                table_1.setRowHeight(30);
                // Cambia el color de fondo de las filas seleccionadas
                table_1.setSelectionBackground(new Color(217, 217, 217)); 
                table_1.setSelectionForeground(Color.BLACK);
                DefaultTableModel model;
				table_1.setModel(model = new DefaultTableModel(new Object[][] {
                }, new String[] { "DNIdoctor", "Nombre"}));
                table_1.getColumnModel().getColumn(1).setMinWidth(23);
                scrollPane.setViewportView(table_1);
                doctor.CargarTabla(model,table_1);
                
                //boton para rellenar todo los datos automaticamente
				JButton btnRelleno = new JButton("RELLENAR");
				btnRelleno.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList <String> datos= null;
						String doc = "";
						String nomDoc="";
						//coger el dni
						for (int i = 0; i < Nombre.size(); i++) {

							 nomDoc = Nombre.get(i).toString();
							 System.out.println(comboBoxDoctor.getSelectedItem().toString());
							if (nomDoc.equals(comboBoxDoctor.getSelectedItem().toString())) {
								doc = Dni.get(i);
								tfNombre.setText(nomDoc);
								datos=doctor.RellenarDatosModificar(doc);
								textoDNI.setText(doc);
							}	
						}
						

						
					}
				});
				btnRelleno.setBounds(572, 112, 89, 23);
				contentPane.add(btnRelleno);
		
                
                
                //BOTON FUNCIONALIDAD
                
                JButton btnAnadir = new JButton("Modificar");
                btnAnadir.setBounds(406, 510, 560, 30);
                contentPane.add(btnAnadir);
                btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 22));
                btnAnadir.setForeground(new Color(0, 0, 0));
                btnAnadir.setBackground(new Color (207, 241, 255));
                btnAnadir.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		String espe = "";
						//coger el dni
						for (int i = 0; i < NombreEspecialidad.size(); i++) {

							String nomEspe = NombreEspecialidad.get(i).toString();
							if (nomEspe.equals(comboEspecialidad.getSelectedItem().toString())) {
								espe = idEspecialidad.get(i);
							}	
						}
                		String dni=textoDNI.getText().toString();
                		String nombre = tfNombre.getText().toString();
                		String sentencia = "UPDATE dentiapp.doctor " +
                                "SET  " +
                                "nombre_doctor='" + nombre + "', " +
                                "idespecialidad="+espe+ ""
                                		+ " WHERE DNIdoctor='"+dni+"';";            			
                		boolean status = false;
                		System.out.println(sentencia);
            			status = conexion.insertar(conexion,sentencia);
            			if (status=true) {
            				
            			}
            			doctor.CargarTabla(model, table_1);
                	}
                });
                
				
				JLabel lblNewLabel = new JLabel("Nombre");
				lblNewLabel.setBounds(23, 310, 46, 14);
				
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_2 = new JLabel("Especialidad");
				lblNewLabel_2.setBounds(23, 369, 76, 14);
				contentPane.add(lblNewLabel_2);

                JLabel fondo = new JLabel();
				fondo.setBounds(0, 0, 1100, 650);

				ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
				ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
				fondo.setIcon(imagen6);
				contentPane.add(fondo);
				


				

				

				
				
	}public void clearTxtField(JTextField text) {
		text.setText("");
	}
}

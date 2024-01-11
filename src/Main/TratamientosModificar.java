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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;

public class TratamientosModificar extends JDialog {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tftratamiento;
	private JTextField tfCoste;
	private JTextField tfnombre;
 Tratamiento tratamiento = new Tratamiento();
	
	
	
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
			
					TratamientosModificar modificar = new TratamientosModificar(b,con,null,true);
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
	public TratamientosModificar(ArrayList<String> a, Conexion con,InicioAdmin parent,boolean modal) {
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
				
				tftratamiento = new JTextField();
				tftratamiento.setForeground(new Color(192, 192, 192));
				tftratamiento.setText("Introduzca idtratamiento");
				tftratamiento.setFont(new Font("Calibri", Font.PLAIN, 15));
				tftratamiento.setBounds(124, 241, 189, 30);
				contentPane.add(tftratamiento);
				tftratamiento.setColumns(10);
				
			
			

		
				
				//SEGUNDA SELECCION
				
				tfCoste = new JTextField();
				tfCoste.setForeground(new Color(192, 192, 192));
				tfCoste.setText("Introduzca Coste");
				tfCoste.setFont(new Font("Calibri", Font.PLAIN, 15));
				tfCoste.setBounds(124, 304, 189, 30);
				contentPane.add(tfCoste);
				tfCoste.setColumns(10);
				
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
				
				tfnombre = new JTextField();
				tfnombre.setForeground(new Color(192, 192, 192));
				tfnombre.setText("Introduzca Nombre");
				tfnombre.setFont(new Font("Calibri", Font.PLAIN, 15));
				tfnombre.setBounds(124, 360, 189, 30);
				contentPane.add(tfnombre);
				tfnombre.setColumns(10);
				
				
		
				
				
				
				
				//-----------------------Para que desaparezca y aparezca cuando este vacio----------------
				
				
				tftratamiento.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
							tftratamiento.setText("");
							tftratamiento.setForeground(new Color(0,0,0));
							
						
					}
					
				});
				
				tftratamiento.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tftratamiento.getText().isEmpty()) {
							
							
							tftratamiento.setText(stf1);
							tftratamiento.setForeground(new Color(192,192,192));
							
						}
					}
				});
				tfCoste.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tfCoste.setText("");
						tfCoste.setForeground(new Color(0,0,0));
						
					}
					
				});
				
				tfCoste.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfCoste.getText().isEmpty()) {
							
							
							tfCoste.setText(stf2);
							tfCoste.setForeground(new Color(192,192,192));
						}
					}
				});
				
				tfnombre.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tfnombre.setText("");
					
						tfnombre.setForeground(new Color(0,0,0));
						
					}
					
				});
				
				tfnombre.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfnombre.getText().isEmpty()) {
							
							
							tfnombre.setText(stf3);
							tfnombre.setForeground(new Color(192,192,192));
						}
					}
				});
				
				
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(410, 164, 560, 326);
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
                }, new String[] {	"Coste", "Nombre"}));
                table_1.getColumnModel().getColumn(1).setMinWidth(23);
                scrollPane.setViewportView(table_1);
                tratamiento.CargarTabla(model,table_1);
                
		
                
		
                
                
                //BOTON FUNCIONALIDAD
                
                JButton btnAnadir = new JButton("Modificar");
                btnAnadir.setBounds(410, 513, 560, 30);
                contentPane.add(btnAnadir);
                btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 22));
                btnAnadir.setForeground(new Color(0, 0, 0));
                btnAnadir.setBackground(new Color (207, 241, 255));
                btnAnadir.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	
                		String nombre = tfnombre.getText();
                		int idtratamientos= Integer.parseInt(tftratamiento.getText());
                		int Coste =Integer.parseInt(tfCoste.getText());
                		String sentencia = "UPDATE dentiapp.tratamientos " +
                                "SET " +
                                "Coste=" + Coste + ", " +
                                "Nombre='" + nombre + "' " +
                                "WHERE idtratamientos=" + idtratamientos + ";";           			
                		boolean status = false;
            			status = conexion.insertar(conexion,sentencia);
            			if (status=true) {
            				
            			}
            			tratamiento.CargarTabla(model, table_1);
                	}
                });
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

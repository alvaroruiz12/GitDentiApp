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
import javax.swing.JComboBox;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;

public class TratamientosModificar extends JDialog {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCoste;
	private JTextField tfnombre;
 Tratamiento tratamiento = new Tratamiento();
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ArrayList<String> b = null;
		Conexion con =null;


	
	
		
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
		
		tfCoste = new JTextField();
		tfCoste.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
		tfCoste.setText("Seleccione un coste");
		tfCoste.setOpaque(false);
		tfCoste.setBounds(90, 400, 250, 27);
		tfnombre = new JTextField();
		tfnombre.setBounds(new Rectangle(0, 0, 2, 2));
		tfnombre.setCaretColor(new Color(0, 0, 0));
		tfnombre.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)));
		tfnombre.setOpaque(false);
		tfnombre.setBackground(new Color(0, 0, 0));
		tfnombre.setToolTipText("");
		tfnombre.setText("Seleccione un tratamiento");
		tfnombre.setBounds(90, 300, 250, 27);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1100, 650);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JComboBox cbTratamientos = new JComboBox();
				cbTratamientos.setBackground(new Color(192, 192, 192));
				cbTratamientos.setForeground(new Color(0, 0, 0));
				cbTratamientos.setBounds(90, 180, 250, 35);
				contentPane.add(cbTratamientos);
				ArrayList<String> nombreTratamiento = tratamiento.CargarNombreTratamiento();
				
				
				
				cbTratamientos.addActionListener(new ActionListener()  {
					public void actionPerformed(ActionEvent e) {
						
						String datos= (String)cbTratamientos.getSelectedItem();
		                tfnombre.setText(datos);
		           int costeTratamiento = tratamiento.CargarCosteTratamiento(datos);
		                String coste=String.valueOf(costeTratamiento);
		                tfCoste.setText(coste);
					}
				});
			
				
		

				for (int i = 0; i < nombreTratamiento.size(); i++) {
					cbTratamientos.addItem(nombreTratamiento.get(i).toString());
					
			
				}
				
				
				//SEGUNDA SELECCION
				
				
				tfCoste.setForeground(new Color(192, 192, 192));
			
				tfCoste.setFont(new Font("Calibri", Font.PLAIN, 17));
				contentPane.add(tfCoste);
				tfCoste.setColumns(10);
				ImageIcon imagen= new ImageIcon(getClass().getResource("user.png"));
				
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
				tfnombre.setForeground(new Color(192, 192, 192));
				
				tfnombre.setFont(new Font("Calibri", Font.PLAIN, 17));
				contentPane.add(tfnombre);
				tfnombre.setColumns(10);
				
				
				tfnombre.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tfnombre.setText("");
						tfnombre.setForeground(Color.LIGHT_GRAY);
							
						
					}
					
				});
				
				tfnombre.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfnombre.getText().isEmpty()) {
							
							
							tfnombre.setText("Seleccione un tratamiento");
							tfnombre.setForeground(Color.LIGHT_GRAY);
							
						}
					}
				});
	tfCoste.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						
						tfCoste.setText("");
						tfCoste.setForeground(Color.LIGHT_GRAY);
							
						
					}
					
				});
				
	tfCoste.addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
						
						
						if(tfCoste.getText().isEmpty()) {
							
							
							tfCoste.setText("Seleccione un tratamiento");
							tfCoste.setForeground(Color.LIGHT_GRAY);
							
						}
					}
				});
				
				
				
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(410, 164, 560, 326);
                scrollPane.setBorder(new LineBorder((Color.black), 2, true));
                getContentPane().add(scrollPane);

                // Personalizo la tabla
                JTable table_1 = new JTable();
                //desactiva la la tabla para que no se pueda cambiar
                table_1.setEnabled(false);
                //objeto para editar encabezado
                JTableHeader header = table_1.getTableHeader(); 
                header.setForeground(Color.black); 
                header.setBackground(Color.LIGHT_GRAY);
        		header.setFont(new Font("Arial", Font.PLAIN, 20));

                table_1.setIntercellSpacing(new Dimension(4, 4));
                // ajusta el alto de las columnas de la tabla
                table_1.setRowHeight(30);
                // Cambia el color de fondo de las filas seleccionadas
                table_1.setSelectionBackground(new Color(217, 217, 217)); 
                table_1.setSelectionForeground(Color.BLACK);
                DefaultTableModel model;
				table_1.setModel(model = new DefaultTableModel(new Object[][] {
                }, new String[] {	"Tipo Tratamiento", "Coste"}));
                table_1.getColumnModel().getColumn(1).setMinWidth(23);
                scrollPane.setViewportView(table_1);
                tratamiento.CargarTabla(model,table_1);
                
		
                
		
                
                
                //BOTON FUNCIONALIDAD
                
                JButton btnAnadir = new JButton("Modificar");
                btnAnadir.setBounds(410, 513, 560, 30);
                contentPane.add(btnAnadir);
                btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 22));
                btnAnadir.setForeground(new Color(0, 0, 0));
                btnAnadir.setBackground(new Color(192, 192, 192));
                btnAnadir.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	//
                		String datos= (String)cbTratamientos.getSelectedItem();
		            
                		
                		int Coste =Integer.parseInt(tfCoste.getText());
                		String sentencia = "UPDATE dentiapp.tratamientos " +
                                "SET " +
                                "coste_tratamiento=" + Coste + ", " +
                                "nombre_tratamiento='" + datos + "' " +
                                "WHERE nombre_tratamiento='" + datos + "';";           			
                		boolean status = false;
               
            			status = conexion.insertar(conexion,sentencia);
            			if (status=true) {
            				
            			}
            			tratamiento.CargarTabla(model, table_1);
                	}
                });
         

                JLabel fondo = new JLabel();
                fondo.setBounds(new Rectangle(0, 0, 2, 2));
                fondo.setBorder(new EmptyBorder(0, 0, 2, 0));
                fondo.setForeground(new Color(192, 192, 192));
				fondo.setBounds(0, 0, 1100, 650);

				ImageIcon imagen5= new ImageIcon(getClass().getResource("fondologin.jpg"));
				ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
				fondo.setIcon(imagen6);
				contentPane.add(fondo);
				
	}public void clearTxtField(JTextField text) {
		text.setText("");
	}
}

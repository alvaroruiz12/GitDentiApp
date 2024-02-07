package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class EliminarCitas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table_1;
	DefaultTableModel model;
	
	Citas citas = new Citas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<String> b = null;
				Conexion con = null;
				try {
					EliminarCitas dialog = new EliminarCitas(b,con,null,true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setResizable(false); // Para que no pueda agrandar la ventana.
					dialog.setLocationRelativeTo(null); // Para que nuestra ventana aparezca siempre en la mitad de la pantalla.
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public EliminarCitas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		
		super(parent,modal);
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		
		setBounds(200, 150, 1100, 650);
		getContentPane().setLayout(null);
		
	
		// scroll panel de la tabla
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(48, 168, 993, 386);
					scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
					getContentPane().add(scrollPane);

					// Personalizo la tabla
					table_1 = new JTable();
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
					table_1.setModel(model = new DefaultTableModel(new Object[][] {
					}, new String[] {  "Hora", "Fecha", "DNI paciente", "DNI doctor","Observaciones" }));
					table_1.getColumnModel().getColumn(1).setMinWidth(23);
					scrollPane.setViewportView(table_1);
					
					
			        //BOTON DE ELIMINAR
					JButton btnEliminar = new JButton("ELIMINAR");
					
					btnEliminar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {

								int filaSeleccionada = table_1.getSelectedRow();
								if (filaSeleccionada == -1) {

									Font fuente = new Font("Arial", Font.BOLD, 18);
									UIManager.put("OptionPane.messageFont", fuente);
									JOptionPane.showMessageDialog(null, "Carga la tabla o selecciona un cita. ", "Mensaje",
											JOptionPane.INFORMATION_MESSAGE);
									return;

								}

								else {

									Font fuente = new Font("Abel", Font.BOLD, 18);
									UIManager.put("OptionPane.messageFont", fuente);
									int respuesta = JOptionPane.showConfirmDialog(null,
											"¿Estás seguro de que quieres eliminar esta cita?", "Confirmación",
											JOptionPane.YES_NO_OPTION);

									if (respuesta == JOptionPane.YES_OPTION) {
										// Código para la acción si el usuario selecciona "Sí"
										citas.EliminarCitas(table_1,con);
										citas.CargarTabla(model, table_1);
									}
								}
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					});
					btnEliminar.setBounds(440, 60, 192, 62);
					ImageIcon imagen= new ImageIcon(getClass().getResource("boton.png"));
					ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(btnEliminar.getWidth(), btnEliminar.getHeight(), Image.SCALE_SMOOTH));
			        
					// Establecer el texto sobre la imagen
					btnEliminar.setHorizontalTextPosition(SwingConstants.CENTER);
			        btnEliminar.setVerticalTextPosition(SwingConstants.CENTER);

			        // Personalizar el estilo del texto
			        btnEliminar.setForeground(Color.WHITE); // Color del texto
			        btnEliminar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
					btnEliminar.setIcon(imagen2);
			        
			        
			        // Eliminar el borde del botón para que la imagen sea visible
			        btnEliminar.setBorderPainted(false);
			        btnEliminar.setContentAreaFilled(false);
					getContentPane().add(btnEliminar);
					
					//boton para volver a inicio
					JButton btnVolver = new JButton("VOLVER");
					
					btnVolver.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					btnVolver.setBounds(969, 11, 105, 50);
					ImageIcon imagen3= new ImageIcon(getClass().getResource("boton.png"));
					ImageIcon imagen4= new ImageIcon(imagen.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
			        btnVolver.setIcon(imagen4);
			        
			        // Eliminar el borde del botón para que la imagen sea visible
			        btnVolver.setBorderPainted(false);
			        btnVolver.setContentAreaFilled(false);

					// Establecer el texto sobre la imagen
					btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
					btnVolver.setVerticalTextPosition(SwingConstants.CENTER);

			        // Personalizar el estilo del texto
					btnVolver.setForeground(Color.WHITE); // Color del texto
					btnVolver.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
					getContentPane().add(btnVolver);
					
					//fondo
					JLabel fondo = new JLabel();
					fondo.setBounds(0, 0, 1100, 650);
				
					ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
					ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
					fondo.setIcon(imagen6);
					getContentPane().add(fondo);
					citas.CargarTabla(model, table_1);
						
	
	}
	

}

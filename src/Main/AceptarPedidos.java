package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.Statement;

import BBDD.Conexion;
import javax.swing.JTable;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class AceptarPedidos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	Pedidos pedidos = new Pedidos();

	/**
	 * Launch the application.
	 */
public static void main(String[] args) {
		
		ArrayList<String> b = null;
		Conexion con = null;


	
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
			
					AceptarPedidos modificar = new AceptarPedidos(b,con,null,true);
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
	 * Create the dialog.
	 */
	public AceptarPedidos(ArrayList<String> a, Conexion con,InicioAdmin parent,boolean modal) {
		
super(parent,modal);
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(127, 117, 548, 350);
		scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setMinimumSize(new Dimension(10, 10));
		scrollPane.setMaximumSize(new Dimension(500, 250));
		scrollPane.setBorder(new LineBorder(new Color(0, 128, 255), 2, true));
		getContentPane().add(scrollPane);

		// creamos la tabla
		JTable table_1 = new JTable();
		//objeto para editar encabezado
		JTableHeader header = table_1.getTableHeader(); 
		header.setForeground(Color.black); 
		header.setFont(new Font("Arial", Font.PLAIN, 20));
		header.setBackground(new Color(207, 241, 255));
		table_1.setIntercellSpacing(new Dimension(2, 2));
		// ajusta el alto de las columnas de la tabla
		table_1.setRowHeight(20);
		// Cambia el color de fondo de las filas seleccionadas
		table_1.setSelectionBackground(new Color(217, 217, 217)); 
		table_1.setSelectionForeground(Color.BLACK);
		
		//creamos el modelo de la tabla y guardaremos los nombre en un array de object ya que model no coge otro tipo de variable
		DefaultTableModel model;
		table_1.setModel(model = new DefaultTableModel(new Object[][] {
		}, new String[] { "Idpedidos","NombreMaterial", "Cantidad", "Aceptado"}));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		
		
		//utilizamos el metodo para cargar tabla
		//en este caso las que ya esten aceptadas no saldran en pantalla
		
		pedidos.CargarTablaPedidos(model, table_1);
		
		JButton volver = new JButton("Volver");
		volver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		volver.setForeground(new Color(255, 255, 255));
		volver.setOpaque(false);
		volver.setBorderPainted(false);
		volver.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		volver.setBounds(10, 25, 89, 23);
		getContentPane().add(volver);
		  
		
		
		
		   // Realizamos el jscroll para ver los componentes bien
	
		
		//creamos un escuchador de la tabla para poder asi eliminar una solicitud ya aceptada
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Nos aseguramos de que se escoga una fila si o si
                if (table_1.getSelectedRow() != -1) {
                    int filaSeleccionada = table_1.getSelectedRow();

                    // Mostrar un mensaje de confirmación
                    int opcion = JOptionPane.showConfirmDialog(AceptarPedidos.this,
                            "¿Deseas aceptar esta solicitud?", "Confirmación",
                            JOptionPane.OK_CANCEL_OPTION);

                    if (opcion == JOptionPane.OK_OPTION) {
                        // Obtener el valor de la pk (asumiendo que está en la columna 0)
                        Object idpedidos = table_1.getValueAt(filaSeleccionada, 0);

                        // aceptamos la solicitud que no estaba aceptada y como esta aceptada la borrar de base de datos y la tabla
                        pedidos.AceptarSolicitud(idpedidos);
                        pedidos.Actualizarmateriales((int)idpedidos);

                        // Eliminar la fila de la tabla
                        model.removeRow(filaSeleccionada);
                    }
                }
            }
        });
		 Insets margenes = new Insets(15, 15, 15, 15);
		 JLabel fondo = new JLabel();
			fondo.setForeground(Color.LIGHT_GRAY);
			fondo.setBorder(null);
			fondo.setBounds(0, 0, 797, 526);
			ImageIcon imagen3= new ImageIcon(getClass().getResource("fondo.jpg"));
			ImageIcon imagen4= new ImageIcon(imagen3.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
			fondo.setIcon(imagen4);
			getContentPane().add(fondo);
		 
		}			
}





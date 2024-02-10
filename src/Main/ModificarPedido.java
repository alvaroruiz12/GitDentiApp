package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BBDD.Conexion;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.Rectangle;

public class ModificarPedido extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField tfcantidad;
	private Conexion con = new Conexion();
	private JTable table_1;
	private JTextField tfnombre;
	private int idmaterial;
	private int idpedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			ModificarPedido dialog = new ModificarPedido(b, con, null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	 /**
	 * Create the dialog.
	 */
	public ModificarPedido(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		super(parent, modal);
		setBounds(new Rectangle(62, 0, 854, 480));
		getContentPane().setBounds(new Rectangle(0, 0, 900, 800));
		Conexion solicitar = new Conexion();
		Pedidos pedido = new Pedidos();
		ArrayList<String> usuario = a;
		Conexion conexion = con;

		setBounds(100, 100, 800, 493);
		
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		Pedidos pedido1= new Pedidos();
		JTable table_1_1 = new JTable();

		contentPanel.setLayout(null);
		
		DefaultTableModel model = null;
		
		tfnombre = new JTextField();
		tfnombre.setOpaque(false);
		tfnombre.setForeground(Color.LIGHT_GRAY);
		tfnombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfnombre.setColumns(10);
		tfnombre.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)));
		tfnombre.setBounds(180, 170, 105, 24);
		contentPanel.add(tfnombre);
		
		JLabel lblIdpedido = new JLabel("IdPedido");
		lblIdpedido.setForeground(Color.LIGHT_GRAY);
		lblIdpedido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdpedido.setBackground(Color.LIGHT_GRAY);
		lblIdpedido.setBounds(49, 106, 100, 25);
		contentPanel.add(lblIdpedido);
		tfcantidad = new JTextField();
		tfcantidad.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfcantidad.setForeground(new Color(192, 192, 192));
		tfcantidad.setOpaque(false);
		tfcantidad.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)));
		tfcantidad.setBounds(245, 224, 40, 19);
		contentPanel.add(tfcantidad);
		tfcantidad.setColumns(10);

		JComboBox combomaterial = new JComboBox();
		combomaterial.setFont(new Font("Tahoma", Font.PLAIN, 17));
		combomaterial.setBorder(null);
		combomaterial.setBackground(new Color(192, 192, 192));
		combomaterial.setToolTipText("");
		combomaterial.setBounds(234, 103, 51, 30);
		contentPanel.add(combomaterial);
	
		ArrayList<String> nombrematerial = pedido1.CargarIdpedidos();
		
		
		
		combomaterial.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {
				
				String datos=(String)combomaterial.getSelectedItem();
         
           int cantidad = pedido1.CargarCantidadPedidos(Integer.parseInt(datos));
                String resultado=String.valueOf(cantidad);
                tfcantidad.setText(resultado);
            String nombre = pedido1.CargarNombrePedidos(Integer.parseInt(datos));
                     tfnombre.setText(nombre);     
            
                
       
			}
		});
	
		


		for (int i = 0; i < nombrematerial.size(); i++) {
			combomaterial.addItem(nombrematerial.get(i).toString());
			
	
		}
		
		
		
		
		

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(192, 192, 192));
		lblNewLabel.setBounds(49, 168, 100, 25);
		contentPanel.add(lblNewLabel);

	
		JButton btnNewButton_1 = new JButton("ACEPTAR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	//
				String datos= (String)combomaterial.getSelectedItem();
	            
		                int resultado1=Integer.parseInt(tfcantidad.getText());
		                String nombre = pedido1.CargarNombrePedidos(Integer.parseInt(datos));
		                String nombre1= tfnombre.getText(); 
		                int datos1=Integer.parseInt((String) combomaterial.getSelectedItem());
            			actualizarpedido(nombre,resultado1,nombre1,datos1);
         
            	
        			
        		
            	}
            });
		
		btnNewButton_1.setBounds(134, 320, 120, 25);
		contentPanel.add(btnNewButton_1);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 7, 58, 51);
		btnVolver.setBackground(new Color(192, 192, 192));
		btnVolver.setForeground(new Color(255, 255, 255));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		ImageIcon i7 = new ImageIcon(getClass().getResource("volver.png"));
		ImageIcon i8 = new ImageIcon(
				i7.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
		btnVolver.setIcon(i8);
		contentPanel.add(btnVolver);

		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(192, 192, 192));
		lblNewLabel_1.setBounds(49, 220, 130, 25);
		contentPanel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);
		scrollPane.setBounds(337, 76, 437, 330);
		scrollPane.setBorder(new LineBorder((new Color(0,0,0)), 2, true));

		// Personalizo la tabla
	
		// desactiva la la tabla para que no se pueda cambiar
		table_1_1.setEnabled(false);
		// objeto para editar encabezado
		JTableHeader header = table_1_1.getTableHeader();

		header.setForeground(Color.black);
		header.setBackground(Color.LIGHT_GRAY);
		header.setFont(new Font("Arial", Font.PLAIN, 20));
		table_1_1.setIntercellSpacing(new Dimension(4, 4));
		// ajusta el alto de las columnas de la tabla
		table_1_1.setRowHeight(30);
		// Cambia el color de fondo de las filas seleccionadas
		table_1_1.setSelectionBackground(new Color(217, 217, 217));
		table_1_1.setSelectionForeground(Color.BLACK);
		table_1_1.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] {  "IdPedidos", "NombreMaterial", "Cantidad","Aceptado"}));

		table_1_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1_1);
		pedido.CargarTablaPedidosTodos(model, table_1_1);

		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 794, 561);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondologin.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPanel.add(fondo);

	}
private void  actualizarpedido(String nombre,int cantidad,String nombre1,int idpedido) {

        
		
		try {
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			Conexion controlador = new Conexion();
			cn = (Connection) controlador.conectar();
			stm = cn.createStatement();
			String consulta1 = "SELECT  materiales.idmateriales "
					+ "FROM materiales  "
					+ "JOIN pedidos  "
					+ "ON pedidos.idmateriales = materiales.idmateriales where nombre_material ='"+nombre+"' ";
			
			rs = stm.executeQuery(consulta1);
			while (rs.next()) {
				idmaterial= rs.getInt("idmateriales");
				
				
			}
			

			String consulta2 ="UPDATE materiales set nombre_material='"+nombre1+"' where idmateriales = "+idmaterial+" ";
			
		
			stm.executeUpdate(consulta2);
			String consulta ="UPDATE pedidos set cantidad="+cantidad+" where idpedidos = "+idpedido+"";
			
			stm.executeUpdate(consulta);
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}

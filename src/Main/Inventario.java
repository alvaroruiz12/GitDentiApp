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

public class Inventario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField tfcantidad;
	private Conexion con = new Conexion();
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			Inventario dialog = new Inventario(b, con, null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	 /**
	 * Create the dialog.
	 */
	public Inventario(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		super(parent, modal);
		setBounds(new Rectangle(62, 0, 700, 480));
		getContentPane().setBounds(new Rectangle(0, 0, 900, 800));
		Conexion solicitar = new Conexion();
		Pedidos pedido = new Pedidos();
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		Pedidos pedido1= new Pedidos();
		JTable table_1_1 = new JTable();
		contentPanel.setLayout(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		DefaultTableModel model = null;

	
		

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 7, 58, 51);
		btnVolver.setBackground(new Color(53, 154, 255));
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

	

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);
		scrollPane.setBounds(89, 77, 519, 330);
		scrollPane.setBorder(new LineBorder(new Color(0, 128, 255), 1, true));

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
				new String[] { "Nombre_material","Cantidad","Precio","CIFproveedor"}));
		table_1_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1_1);
		pedido.CargarTabla(model, table_1_1);

		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 684, 482);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPanel.add(fondo);

	}
}

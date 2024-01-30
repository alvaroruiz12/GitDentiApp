package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
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

public class SolicitarMaterial extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField textField_1;
	private JTextField textField_2;
	private Conexion con = new Conexion();
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			SolicitarMaterial dialog = new SolicitarMaterial(b, con, null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the dialog.
	 */
	public SolicitarMaterial(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		Conexion solicitar = new Conexion();
		Material material = new Material();
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		setBounds(100, 100, 800, 600);
		
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		DefaultTableModel model;

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(101, 142, 70, 25);
		contentPanel.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(213, 149, 96, 19);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(213, 203, 96, 19);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton_1 = new JButton("ACEPTAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(178, 256, 75, 21);
		contentPanel.add(btnNewButton_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 7, 35, 30);
		btnVolver.setBackground(new Color(207, 241, 255));
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
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(101, 196, 78, 25);
		contentPanel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		contentPanel.add(scrollPane);
		scrollPane.setBounds(339, 69, 437, 330);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));

		// Personalizo la tabla
		JTable table_1_1 = new JTable();
		// desactiva la la tabla para que no se pueda cambiar
		table_1_1.setEnabled(false);
		// objeto para editar encabezado
		JTableHeader header = table_1_1.getTableHeader();

		header.setForeground(Color.black);
		header.setBackground(new Color(207, 241, 255));
		header.setFont(new Font("Arial", Font.PLAIN, 20));
		table_1_1.setIntercellSpacing(new Dimension(4, 4));
		// ajusta el alto de las columnas de la tabla
		table_1_1.setRowHeight(30);
		// Cambia el color de fondo de las filas seleccionadas
		table_1_1.setSelectionBackground(new Color(217, 217, 217));
		table_1_1.setSelectionForeground(Color.BLACK);
		table_1_1.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "Nombre", "Cantidad", "Precio", "Proveedor_CIF" }));
		table_1_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1_1);
		material.CargarTabla(model, table_1_1);

		JLabel fondo = new JLabel();
		fondo.setBounds(-55, 0, 900, 800);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPanel.add(fondo);

	}

}

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

public class CrearCuenta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField tfpassword;
	private Conexion con = new Conexion();
	private JTable table_1;
	private JTextField txtIntroduzcaNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			CrearCuenta dialog = new CrearCuenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	 /**
	 * Create the dialog.
	 */
	public CrearCuenta() {

		setBounds(new Rectangle(62, 0, 854, 480));
		getContentPane().setBounds(new Rectangle(0, 0, 900, 800));
		Conexion solicitar = new Conexion();
		Pedidos pedido = new Pedidos();
	
		Conexion conexion = con;
		txtIntroduzcaNombre = new JTextField();
		tfpassword = new JTextField();
		setBounds(100, 100, 760, 514);
		
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);

		Pedidos pedido1= new Pedidos();

		contentPanel.setLayout(null);
		
		DefaultTableModel model = null;
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(306, 148, 120, 22);
		comboBox.addItem("Admin");
		comboBox.addItem("Doctor");
		

		
		contentPanel.add(comboBox);
		
		
		txtIntroduzcaNombre = new JTextField();
		
		txtIntroduzcaNombre.setText("Name");
		txtIntroduzcaNombre.setHorizontalAlignment(txtIntroduzcaNombre.CENTER);
			
		txtIntroduzcaNombre.setOpaque(false);
		txtIntroduzcaNombre.setForeground(new Color(255, 255, 255));
		txtIntroduzcaNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtIntroduzcaNombre.setColumns(10);
		txtIntroduzcaNombre.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		txtIntroduzcaNombre.setBounds(260, 210, 202, 25);
		contentPanel.add(txtIntroduzcaNombre);
		tfpassword = new JTextField();
		tfpassword.setText("Password");
		tfpassword.setHorizontalAlignment(tfpassword.CENTER);

		tfpassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfpassword.setForeground(new Color(255, 255, 255));
		tfpassword.setOpaque(false);
		tfpassword.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 255)));
		tfpassword.setBounds(260, 287, 202, 25);
		contentPanel.add(tfpassword);
		tfpassword.setColumns(10);
	

	
		




	
		JButton aceptar = new JButton("ACEPTAR");
		aceptar.setForeground(new Color(255, 255, 255));
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem()=="Admin") {
					String nombre=txtIntroduzcaNombre.getText();
					String contrasenia=tfpassword.getText();
					Usuarios admin = new Usuarios();
					admin.InsertarAdmin(nombre,contrasenia);
					System.out.println("Se ha insertado el admin");
				}else {
					String nombre=txtIntroduzcaNombre.getText();
					String contrasenia=tfpassword.getText();
					Usuarios doctor = new Usuarios();
					doctor.InsertarDoctor(nombre,contrasenia);
					System.out.println("Se ha insertado el doctor");
					
				}
			}
		});
	

        // Eliminar el borde del botón para que la imagen sea visible
		aceptar.setBorderPainted(false);
		aceptar.setContentAreaFilled(false);

        // Establecer el texto sobre la imagen
		aceptar.setHorizontalTextPosition(SwingConstants.CENTER);
		aceptar.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		aceptar.setForeground(Color.WHITE); // Color del texto
		aceptar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		aceptar.setBounds(306, 361, 120, 25);
		ImageIcon imagen3= new ImageIcon(getClass().getResource("boton.png"));
        ImageIcon imagen4= new ImageIcon(imagen3.getImage().getScaledInstance(aceptar.getWidth(), aceptar.getHeight(), Image.SCALE_SMOOTH));
        aceptar.setIcon(imagen4);
		
		contentPanel.add(aceptar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 7, 58, 51);
		btnVolver.setBackground(new Color(148, 223, 239));
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

		JLabel lblNewLabel_1 = new JLabel("SIGN UP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(320, 87, 130, 38);
		contentPanel.add(lblNewLabel_1);

	

		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 751, 482);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPanel.add(fondo);

	}
	
	
	
}
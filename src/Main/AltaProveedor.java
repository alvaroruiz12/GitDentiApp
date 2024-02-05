package Main;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

public class AltaProveedor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txCIF;
	private JTextField txNombre;
	private JTextField textoTelefono;
	private JTextField textoCorreo;
	private Paciente paciente = new Paciente();
	
	
	private String stf1="Introduzca nombre",stf2= "Introduzca apellido",
			stf3 = "Introduzca DNI",stf4 = "Introduzca correo",stf5 = "Introduzca telefono",stf6="Introduzca edad";
	private JTextField txDireccion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			AltaProveedor dialog = new AltaProveedor(b,con,null,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaProveedor(ArrayList<String> a, Conexion con,InicioAdmin parent,boolean modal) {
		super(parent,modal);
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		

		txCIF = new JTextField();
		txCIF.setForeground(new Color(192, 192, 192));
		txCIF.setFont(new Font("Calibri", Font.PLAIN, 15));
		txCIF.setBounds(497, 125, 189, 30);
		contentPanel.add(txCIF);
		txCIF.setColumns(10);
		
	
	


		
		//SEGUNDA SELECCION
		//text field apellidos
		txNombre = new JTextField();
		txNombre.setForeground(new Color(192, 192, 192));
		txNombre.setFont(new Font("Calibri", Font.PLAIN, 15));
		txNombre.setBounds(497, 193, 189, 30);
		contentPanel.add(txNombre);
		txNombre.setColumns(10);
        
		

		
		
		//BOTON FUNCIONALIDAD
		
		JButton btnAnadir = new JButton("+");
		btnAnadir.setBounds(466, 525, 52, 42);
		btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 28));
		btnAnadir.setForeground(new Color(0, 0, 0));
		btnAnadir.setBackground(new Color (207, 241, 255));
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
					String sentencia3="Insert into dentiapp.proveedor (CIFproveedor,nombre_proveedor,telefono_proveedor,correo_proveedor,direccion_proveedor)"
							+ "values('"+txCIF.getText()+"','"+txNombre.getText()+"',"+textoTelefono.getText()+ ",'"+ textoCorreo.getText() + "','" + txDireccion.getText() +"');";
					
					
					
					boolean status3 = false;
					status3 = conexion.insertar(conexion,sentencia3);
					if (status3=true) {
						
					}	
			}
		});
		contentPanel.add(btnAnadir);
		
		JLabel lblFotoUser = new JLabel();
		lblFotoUser.setBounds(94, 125, 170, 170);
		ImageIcon imagen= new ImageIcon(getClass().getResource("user.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen2);
		contentPanel.add(lblFotoUser);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 43, 76, 64);
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
		contentPanel.add(btnVolver);
		
		textoTelefono = new JTextField();
		textoTelefono.setForeground(new Color(192, 192, 192));
		textoTelefono.setFont(new Font("Calibri", Font.PLAIN, 15));
		textoTelefono.setBounds(497, 253, 189, 30);
		contentPanel.add(textoTelefono);
		textoTelefono.setColumns(10);
		
		textoCorreo = new JTextField();
		textoCorreo.setForeground(new Color(192, 192, 192));
		textoCorreo.setFont(new Font("Calibri", Font.PLAIN, 15));
		textoCorreo.setBounds(497, 316, 189, 30);
		contentPanel.add(textoCorreo);
		textoCorreo.setColumns(10);
		
		txDireccion = new JTextField();
		txDireccion.setBounds(500, 371, 186, 30);
		contentPanel.add(txDireccion);
		txDireccion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CIF");
		lblNewLabel.setBounds(336, 131, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(336, 199, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(336, 259, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(336, 322, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(336, 379, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		// JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 750, 650);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPanel.add(fondo);
		

		
}public void clearTxtField(JTextField text) {
text.setText("");
}
}

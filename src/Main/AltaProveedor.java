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
import javax.swing.SwingConstants;
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
		txCIF.setFont(new Font("Calibri", Font.PLAIN, 15));
		txCIF.setBounds(497, 125, 189, 30);
		contentPanel.add(txCIF);
		txCIF.setColumns(10);
		
	
	


		
		//SEGUNDA SELECCION
		//text field apellidos
		txNombre = new JTextField();
		txNombre.setFont(new Font("Calibri", Font.PLAIN, 15));
		txNombre.setBounds(497, 193, 189, 30);
		contentPanel.add(txNombre);
		txNombre.setColumns(10);
        
		

		
		
		//BOTON FUNCIONALIDAD
		
		JButton btnAnadir = new JButton("DAR DE ALTA");
		btnAnadir.setBounds(492, 435, 208, 47);
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
		
		ImageIcon imagen= new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(btnAnadir.getWidth(), btnAnadir.getHeight(), Image.SCALE_SMOOTH));
        
		// Establecer el texto sobre la imagen
		btnAnadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAnadir.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
        btnAnadir.setForeground(Color.WHITE); // Color del texto
        btnAnadir.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
        btnAnadir.setIcon(imagen2);
        
        
        // Eliminar el borde del botón para que la imagen sea visible
		btnAnadir.setBorderPainted(false);
        btnAnadir.setContentAreaFilled(false);
		contentPanel.add(btnAnadir);
		
		JLabel lblFotoUser = new JLabel();
		lblFotoUser.setBounds(94, 125, 170, 170);
		ImageIcon imagen3= new ImageIcon(getClass().getResource("user.png"));
		ImageIcon imagen4= new ImageIcon(imagen3.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen4);
		contentPanel.add(lblFotoUser);
		
		//boton para volver a inicio
				JButton btnVolver = new JButton("VOLVER");
				
				btnVolver.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnVolver.setBounds(619, 11, 105, 50);
				ImageIcon imagen6= new ImageIcon(getClass().getResource("boton.png"));
				ImageIcon imagen5= new ImageIcon(imagen.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
		        btnVolver.setIcon(imagen5);
		        
		        // Eliminar el borde del botón para que la imagen sea visible
		        btnVolver.setBorderPainted(false);
		        btnVolver.setContentAreaFilled(false);

				// Establecer el texto sobre la imagen
				btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
				btnVolver.setVerticalTextPosition(SwingConstants.CENTER);

		        // Personalizar el estilo del texto
				btnVolver.setForeground(Color.WHITE); // Color del texto
				btnVolver.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
				contentPanel.add(btnVolver);
				
		
		textoTelefono = new JTextField();
		textoTelefono.setFont(new Font("Calibri", Font.PLAIN, 15));
		textoTelefono.setBounds(497, 253, 189, 30);
		contentPanel.add(textoTelefono);
		textoTelefono.setColumns(10);
		
		textoCorreo = new JTextField();
		textoCorreo.setFont(new Font("Calibri", Font.PLAIN, 15));
		textoCorreo.setBounds(497, 316, 189, 30);
		contentPanel.add(textoCorreo);
		textoCorreo.setColumns(10);
		
		txDireccion = new JTextField();
		txDireccion.setBounds(500, 371, 186, 30);
		contentPanel.add(txDireccion);
		txDireccion.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CIF");
		lblNewLabel.setBounds(336, 131, 76, 24);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(336, 199, 93, 24);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(336, 259, 93, 24);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(336, 319, 76, 27);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(336, 379, 93, 22);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setForeground(Color.white);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_4);
		
		// JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 750, 650);

		ImageIcon imagen7 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen8 = new ImageIcon(
				imagen7.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen8);
		contentPanel.add(fondo);
		

		
}public void clearTxtField(JTextField text) {
text.setText("");
}
}

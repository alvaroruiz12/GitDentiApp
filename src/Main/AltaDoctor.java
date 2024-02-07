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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;
import javax.swing.JComboBox;

public class AltaDoctor extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String stf1="Introduzca nombre",stf2= "Introduzca apellido",
			stf3 = "Introduzca DNI",stf4 = "Introduzca correo",stf5 = "Introduzca telefono",stf6="Introduzca edad";
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	Especialidad especialidad= new Especialidad();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			AltaDoctor dialog = new AltaDoctor(b,con,null,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaDoctor(ArrayList<String> a, Conexion con,InicioAdmin parent,boolean modal) {
		
		super(parent,modal);
		
		
		ArrayList <String> nombreEspecialidad=especialidad.CargarNombreEspecialidad();
		ArrayList <String> idEspecialidad=especialidad.CargarNumeroEspecialidad();
		JComboBox comboNombre = new JComboBox();
		comboNombre.setBounds(494, 332, 189, 30);
		contentPanel.add(comboNombre);
		
		// mete los nombres en el combobox
		for (int i = 0; i < nombreEspecialidad.size(); i++) {
			comboNombre.addItem(nombreEspecialidad.get(i).toString());
		}
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		setBounds(100, 100, 750, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setForeground(new Color(192, 192, 192));
		tf1.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf1.setBounds(494, 125, 189, 30);
		contentPanel.add(tf1);
		tf1.setColumns(10);
		
	
	


		
		//SEGUNDA SELECCION
		//text field apellidos
		tf2 = new JTextField();
		tf2.setForeground(new Color(192, 192, 192));
		tf2.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf2.setBounds(494, 194, 189, 30);
		contentPanel.add(tf2);
		tf2.setColumns(10);
        
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(376, 125, 87, 30);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(376, 194, 87, 30);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.white);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Id usuarios");
		lblNewLabel_2.setBounds(356, 265, 96, 30);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Especialidad");
		lblNewLabel_3.setBounds(354, 333, 120, 22);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel_3);
		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(584, 11, 140, 47);
		ImageIcon imagen34 = new ImageIcon(getClass().getResource("boton.png"));

		ImageIcon imagen6 = new ImageIcon(
				imagen34.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
		btnVolver.setIcon(imagen6);

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
		
		
		//BOTON FUNCIONALIDAD
		
		JButton btnAnadir = new JButton("DAR DE ALTA DOCTOR");
		btnAnadir.setBounds(450, 400, 254, 38);
		btnAnadir.setFont(new Font("Calibri", Font.PLAIN, 28));
		btnAnadir.setForeground(new Color(0, 0, 0));
		btnAnadir.setBackground(new Color (207, 241, 255));
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nEspecialidad="";
				String id="";
				int nid=0;
				for (int i = 0; i < nombreEspecialidad.size(); i++) {
					 nEspecialidad = nombreEspecialidad.get(i).toString();
					if (nEspecialidad.equals(comboNombre.getSelectedItem().toString())) {
						id = idEspecialidad.get(i);
						nid=Integer.parseInt(id);
					}	
				}
				

		
					String sentencia2="Insert into dentiapp.doctor (DNI,Nombre,usuarios_idusuarios,especialidad_idespecialidad)values('"
							+tf2.getText()+"','"+tf1.getText()+"',"+tf3.getText()+"," + nid +");";
				
					
					boolean status2 = false;
					status2 = conexion.insertar(conexion, sentencia2);
					if (status2=true) {
						
					}
			}
		});
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4 = new ImageIcon(
				imagen3.getImage().getScaledInstance(btnAnadir.getWidth(), btnAnadir.getHeight(), Image.SCALE_SMOOTH));
		btnAnadir.setIcon(imagen4);

		// Eliminar el borde del botón para que la imagen sea visible
		btnAnadir.setBorderPainted(false);
		btnAnadir.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnAnadir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAnadir.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnAnadir.setForeground(Color.WHITE); // Color del texto
		btnAnadir.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		contentPanel.add(btnAnadir);
		
		JLabel lblFotoUser = new JLabel();
		lblFotoUser.setBounds(94, 125, 170, 170);
		ImageIcon imagen= new ImageIcon(getClass().getResource("user.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
		lblFotoUser.setIcon(imagen2);
		contentPanel.add(lblFotoUser);
		
		
		
		tf3 = new JTextField();
		tf3.setForeground(new Color(192, 192, 192));
		tf3.setFont(new Font("Calibri", Font.PLAIN, 15));
		tf3.setBounds(494, 265, 189, 30);
		contentPanel.add(tf3);
		tf3.setColumns(10);

		
		
		
		//JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 750, 650);

		ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen7= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen7);
		contentPanel.add(fondo);
		

		

		

		
}public void clearTxtField(JTextField text) {
text.setText("");
}
}




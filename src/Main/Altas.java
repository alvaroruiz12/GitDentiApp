package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import javax.swing.JTextField;
public class Altas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField tfNombre;
	private JTextField tfApellido;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ArrayList<String> b = null;
		Conexion con = null;
		try {
			Altas dialog = new Altas(b,con, null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


public Altas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
	
	  super(parent,modal);
		
	ArrayList<String> usuario = a;
	Conexion conexion = con;
	
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setBounds(0, 0, 1920, 1080);
	
	contentPanel.setBackground(new Color(235, 235, 235));
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPanel);
			contentPanel.setLayout(null);
	
	//boton para hacer pedido
			JButton btnHacerPedido = new JButton("HACER PEDIDO");
			btnHacerPedido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnHacerPedido.setBackground(new Color(134, 215, 253));
			btnHacerPedido.setBounds(0, 0, 380, 90);
			btnHacerPedido.setForeground(new Color(255, 255, 255));
			btnHacerPedido.setFont(new Font("Arial", Font.ITALIC, 33));
			btnHacerPedido.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(btnHacerPedido);
			
			
			//boton de altas 
			JButton btnAltas = new JButton("CONSULTA");
			btnAltas.setBackground(new Color(134, 215, 253));
			btnAltas.setBounds(380, 0, 380, 90);
			btnAltas.setForeground(new Color(255, 255, 255));
			btnAltas.setFont(new Font("Arial", Font.ITALIC, 33));
			btnAltas.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(btnAltas);
			

			//boton de pedeidos
			JButton btnPedidos = new JButton("PEDIDOS");
			btnPedidos.setBackground(new Color(134, 215, 253));
			btnPedidos.setBounds(1536, 0, 380, 90);
			btnPedidos.setForeground(new Color(255, 255, 255));
			btnPedidos.setFont(new Font("Arial", Font.ITALIC, 33));
			btnPedidos.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(btnPedidos);
			
			
			//boton de inventario
			JButton btnInventario = new JButton("INVENTARIO");
			btnInventario.setBackground(new Color(134, 215, 253));
			btnInventario.setBounds(1158, 0, 380, 90);
			btnInventario.setForeground(new Color(255, 255, 255));
			btnInventario.setFont(new Font("Arial", Font.ITALIC, 33));
			btnInventario.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(btnInventario);
			
			
			//boton consulta
			JButton consulta = new JButton("ALTAS");
			consulta.setBackground(new Color(134, 215, 253));
			consulta.setBounds(967, 6, 380, 90);
			consulta.setForeground(new Color(255, 255, 255));
			consulta.setFont(new Font("Arial", Font.ITALIC, 33));
			consulta.setHorizontalAlignment(SwingConstants.CENTER);
			consulta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			consulta.setBounds(758, 0, 400, 90);
			contentPanel.add(consulta);
			
			//combobox
			JComboBox topoConsulta = new JComboBox();
			topoConsulta.setForeground(new Color(255, 255, 255));
			topoConsulta.setBackground(new Color(134, 215, 253));
			topoConsulta.setFont(new Font("Arial Black", Font.PLAIN, 33));
			topoConsulta.setBounds(81, 159, 500, 50);
			((JLabel)topoConsulta.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

			contentPanel.add(topoConsulta);
			//añadir todo al combobox
			topoConsulta.addItem("Paciente");
			topoConsulta.addItem("Doctor");
			topoConsulta.addItem("Proveedor");
			
			
			//AÑADIR EN LA TABLA EL SELECCIONADO
			
			//DISEÑO
			
			//PRIMERA SELECCION
			
			tfNombre = new JTextField();
			tfNombre.setBounds(824, 300, 200, 40);
			contentPanel.add(tfNombre);
			tfNombre.setColumns(10);
			
			JLabel lblNombre = new JLabel("NOMBRE");
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setBounds(560, 291, 200, 50);
			lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 20));

			contentPanel.add(lblNombre);
			
			//SEGUNDA SELECCION
			//text field apellidos
			tfApellido = new JTextField();
			tfApellido.setBounds(824, 367, 200, 40);
			contentPanel.add(tfApellido);
			tfApellido.setColumns(10);
			
			//label apellidos
			JLabel lblApellidos = new JLabel("APELLIDOS");
			lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
			lblApellidos.setBounds(570, 358, 200, 50);
			lblApellidos.setFont(new Font("Arial Black", Font.PLAIN, 20));
			contentPanel.add(lblApellidos);
			
			
			//BOTON FUNCIONALIDAD
			
			JButton btnAnadir = new JButton("Añadir");
			btnAnadir.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnAnadir.setForeground(new Color(255,255,255));
			btnAnadir.setBackground(new Color (134, 215, 253));
			btnAnadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sentencia="Insert into dentiapp.pacientes (Nombre,Apellidos)values('"
							+tfNombre.getText()+"','"+tfApellido.getText()+"');";
					
					
					
					boolean status = false;
					status = conexion.insertar(conexion,sentencia);
					if (status=true) {
						
					}
				}
			});
			btnAnadir.setBounds(755, 534, 100, 50);
			contentPanel.add(btnAnadir);
			
			JLabel lblFotoUser = new JLabel();
			lblFotoUser.setBounds(149, 265, 256, 256);
			ImageIcon imagen= new ImageIcon(getClass().getResource("user.png"));
			ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
			lblFotoUser.setIcon(imagen2);
			contentPanel.add(lblFotoUser);
			

			
			
}
}




/*
 package Main;



public class Altas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		
		ArrayList<String> b = null;
		Conexion con = null;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
			}
		});
	}
	
	public Altas()
	{
		
	}

	/**
	 * Create the frame.
	 
	public Altas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		
	    /* Invoco al constructor de la clase superior 
	  // super();
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
				contentPane.setLayout(null);
		
		//boton para hacer pedido
				JButton btnHacerPedido = new JButton("HACER PEDIDO");
				btnHacerPedido.setBackground(new Color(134, 215, 253));
				btnHacerPedido.setBounds(0, 0, 380, 90);
				btnHacerPedido.setForeground(new Color(255, 255, 255));
				btnHacerPedido.setFont(new Font("Arial", Font.ITALIC, 33));
				btnHacerPedido.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(btnHacerPedido);
				
				
				//boton de altas 
				JButton btnAltas = new JButton("CONSULTA");
				btnAltas.setBackground(new Color(134, 215, 253));
				btnAltas.setBounds(380, 0, 380, 90);
				btnAltas.setForeground(new Color(255, 255, 255));
				btnAltas.setFont(new Font("Arial", Font.ITALIC, 33));
				btnAltas.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(btnAltas);
				

				//boton de pedeidos
				JButton btnPedidos = new JButton("PEDIDOS");
				btnPedidos.setBackground(new Color(134, 215, 253));
				btnPedidos.setBounds(1536, 0, 380, 90);
				btnPedidos.setForeground(new Color(255, 255, 255));
				btnPedidos.setFont(new Font("Arial", Font.ITALIC, 33));
				btnPedidos.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(btnPedidos);
				
				
				//boton de inventario
				JButton btnInventario = new JButton("INVENTARIO");
				btnInventario.setBackground(new Color(134, 215, 253));
				btnInventario.setBounds(1158, 0, 380, 90);
				btnInventario.setForeground(new Color(255, 255, 255));
				btnInventario.setFont(new Font("Arial", Font.ITALIC, 33));
				btnInventario.setHorizontalAlignment(SwingConstants.CENTER);
				contentPane.add(btnInventario);
				
				
				//boton consulta
				JButton consulta = new JButton("ALTAS");
				consulta.setBackground(new Color(134, 215, 253));
				consulta.setBounds(967, 6, 380, 90);
				consulta.setForeground(new Color(255, 255, 255));
				consulta.setFont(new Font("Arial", Font.ITALIC, 33));
				consulta.setHorizontalAlignment(SwingConstants.CENTER);
				consulta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				consulta.setBounds(758, 0, 400, 90);
				contentPane.add(consulta);
				
				//combobox
				JComboBox topoConsulta = new JComboBox();
				topoConsulta.setForeground(new Color(255, 255, 255));
				topoConsulta.setBackground(new Color(134, 215, 253));
				topoConsulta.setFont(new Font("Arial Black", Font.PLAIN, 33));
				topoConsulta.setBounds(81, 159, 500, 50);
				((JLabel)topoConsulta.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

				contentPane.add(topoConsulta);
				//añadir todo al combobox
				topoConsulta.addItem("Paciente");
				topoConsulta.addItem("Doctor");
				topoConsulta.addItem("Proveedor");
				
				
				//AÑADIR EN LA TABLA EL SELECCIONADO
				
				//DISEÑO
				
				//PRIMERA SELECCION
				
				tfNombre = new JTextField();
				tfNombre.setBounds(824, 300, 200, 40);
				contentPane.add(tfNombre);
				tfNombre.setColumns(10);
				
				JLabel lblNombre = new JLabel("NOMBRE");
				lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
				lblNombre.setBounds(560, 291, 200, 50);
				lblNombre.setFont(new Font("Arial Black", Font.PLAIN, 20));

				contentPane.add(lblNombre);
				
				//SEGUNDA SELECCION
				//text field apellidos
				tfApellido = new JTextField();
				tfApellido.setBounds(824, 367, 200, 40);
				contentPane.add(tfApellido);
				tfApellido.setColumns(10);
				
				//label apellidos
				JLabel lblApellidos = new JLabel("APELLIDOS");
				lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
				lblApellidos.setBounds(570, 358, 200, 50);
				lblApellidos.setFont(new Font("Arial Black", Font.PLAIN, 20));
				contentPane.add(lblApellidos);
				
				
				//BOTON FUNCIONALIDAD
				
				JButton btnAnadir = new JButton("Añadir");
				btnAnadir.setFont(new Font("Arial Black", Font.PLAIN, 15));
				btnAnadir.setForeground(new Color(255,255,255));
				btnAnadir.setBackground(new Color (134, 215, 253));
				btnAnadir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String sentencia="Insert into dentiapp.pacientes (Nombre,Apellidos)values('"
								+tfNombre.getText()+"','"+tfApellido.getText()+"');";
						
						
						
						boolean status = false;
						status = conexion.insertar(conexion,sentencia);
						if (status=true) {
							
						}
					}
				});
				btnAnadir.setBounds(755, 534, 100, 50);
				contentPane.add(btnAnadir);
				
				JLabel lblFotoUser = new JLabel();
				lblFotoUser.setBounds(149, 265, 256, 256);
				ImageIcon imagen= new ImageIcon(getClass().getResource("user.png"));
				ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
				lblFotoUser.setIcon(imagen2);
				contentPane.add(lblFotoUser);
				

				
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

  */
 
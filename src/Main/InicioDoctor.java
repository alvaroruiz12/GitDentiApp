package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import BBDD.Conexion;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import com.toedter.calendar.JDateChooser;

public class InicioDoctor extends JFrame {

	private JPanel contentPane;
	private JTable tablaDia;
	private JTable table_1;
	DefaultTableModel model;
	Citas citas = new Citas();
	Paciente paciente= new Paciente();
	Date hoy = new Date();
	private ArrayList<String> usuario;
	private Conexion conexion;
	private InicioDoctor padre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<String> b = null;
				Conexion con = null;
				try {
					InicioDoctor frame = new InicioDoctor(b,con);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setSize(1920, 1080);
					// Maximiza la ventana
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioDoctor(ArrayList<String> a, Conexion con) {
		padre = this;
		usuario = a;
		conexion = con;
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		// MENU
		JMenuBar menuBar = new JMenuBar();
		//cambiar vista
		Insets margenes = new Insets(15, 15, 15, 15);
		menuBar.setBackground(new Color(207, 241, 255));
		menuBar.setForeground(Color.black);
		menuBar.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.setMargin(margenes);
		setJMenuBar(menuBar);

		// INFORMACION PACIENTES
		JMenu mnNewMenu = new JMenu("Info Paciente");
		// CAMBIAR VISTA
		mnNewMenu.setBackground(new Color(207, 241, 255));
		mnNewMenu.setForeground(Color.black);
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu.setMargin(margenes);
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Odontograma");
		mnNewMenu.add(mntmNewMenuItem);
		//CAMBIAR VISTA
		mntmNewMenuItem.setMargin(margenes);
		mntmNewMenuItem.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem.setForeground(Color.black);
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 25));
		
		JMenu mnNewMenu_1 = new JMenu("Solicitar material");
		//cambiar vista
		mnNewMenu_1.setBackground(new Color(207, 241, 255));
		mnNewMenu_1.setForeground(Color.black);
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_1.setMargin(margenes);
		menuBar.add(mnNewMenu_1);


		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Crear solicitud");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				SolicitarMaterial solicitar = new SolicitarMaterial(a,con,padre,modal);
				solicitar.setVisible(true);
			}
		});
		//CAMBIAR VISTA
		mntmNewMenuItem_1.setMargin(margenes);
		mntmNewMenuItem_1.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_1.setForeground(Color.black);
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ver solicitudes");
		//CAMBIAR VISTA
		mntmNewMenuItem_2.setMargin(margenes);
		mntmNewMenuItem_2.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_2.setForeground(Color.black);
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		// TRATAMIENTOS
		JMenu mnNewMenu_2 = new JMenu("Tratamientos");
		//vista
		mnNewMenu_2.setBackground(new Color(207, 241, 255));
		mnNewMenu_2.setForeground(Color.black);
		mnNewMenu_2.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_2.setMargin(margenes);
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Crear tratamiento");
		//CAMBIAR VISTA
		mntmNewMenuItem_3.setMargin(margenes);
		mntmNewMenuItem_3.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_3.setForeground(Color.black);
		mntmNewMenuItem_3.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_2.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Lista tratamientos");
		//CAMBIAR VISTA
		mntmNewMenuItem_5.setMargin(margenes);
		mntmNewMenuItem_5.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_5.setForeground(Color.black);
		mntmNewMenuItem_5.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		// CALENDARIO
		JMenu mnNewMenu_3 = new JMenu("Calendario");
		//vista
		mnNewMenu_3.setBackground(new Color(207, 241, 255));
		mnNewMenu_3.setForeground(Color.black);
		mnNewMenu_3.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_3.setMargin(margenes);
		
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Visualizar calendario");
		//CAMBIAR VISTA
		mntmNewMenuItem_4.setMargin(margenes);
		mntmNewMenuItem_4.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_4.setForeground(Color.black);
		mntmNewMenuItem_4.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		SimpleDateFormat formatoBBDD = new SimpleDateFormat("dd-MM-yyyy");

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(815, 84, 158, 30);
		dateChooser.setMinSelectableDate(hoy);

		contentPane.add(dateChooser);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 150, 1223, 529);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);

		// Personalizo la tabla
		table_1 = new JTable();
		// objeto para editar encabezado
		JTableHeader header = table_1.getTableHeader();
		header.setForeground(Color.black);
		header.setFont(new Font("Arial", Font.PLAIN, 20));

		header.setBackground(new Color(207, 241, 255));
		table_1.setIntercellSpacing(new Dimension(4, 4));
		// ajusta el alto de las columnas de la tabla
		table_1.setRowHeight(30);
		// Cambia el color de fondo de las filas seleccionadas
		table_1.setSelectionBackground(new Color(217, 217, 217));
		table_1.setSelectionForeground(Color.BLACK);
		table_1.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "Hora", "Fecha", "DNI paciente", "DNI doctor", "Observaciones" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);

		citas.CargarTablaDoctor(model, table_1);

		JButton btnCerrarSesion = new JButton("");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				dispose();
				login.setVisible(true);
			}
		});
		btnCerrarSesion.setBounds(1839, 913, 55, 55);
		ImageIcon cerra = new ImageIcon(getClass().getResource("botonapagarsolo.png"));
		ImageIcon sesion = new ImageIcon(cerra.getImage().getScaledInstance(btnCerrarSesion.getWidth(),
				btnCerrarSesion.getHeight(), Image.SCALE_SMOOTH));
		btnCerrarSesion.setIcon(sesion);
		
		
		JTextField textoNombre = new JTextField();
		textoNombre.setBounds(52, 84, 150, 30);
		getContentPane().add(textoNombre);
		textoNombre.setColumns(10);

		
		
		JTextField textoApellidos = new JTextField();
		textoApellidos.setBounds(212, 84, 250, 30);
		getContentPane().add(textoApellidos);
		textoApellidos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(52, 31, 150, 30);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.white);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		lblNewLabel_1.setBounds(212, 31, 158, 30);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.white);

		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_1);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(633, 71, 172, 50);
		lblDNI.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDNI.setForeground(Color.white);
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDNI);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DNI=paciente.BuscarPaciente(textoNombre.getText().toString(), textoApellidos.getText().toString());
				if(dateChooser.getDate() == null) {
					model.setRowCount(0);
					citas.CargarTablaBusqueda(model, table_1, DNI);
					
					lblDNI.setText(DNI);
				}else {
					
					String fecha = formatoBBDD.format(dateChooser.getDate());
					
					model.setRowCount(0);
					citas.CargarTablaDoctorFecha(model, table_1, fecha);
				}

				
				
			}
		});
		btnBuscar.setBounds(474, 75, 120, 44);
		ImageIcon imagen5 = new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(btnBuscar.getWidth(), btnBuscar.getHeight(), Image.SCALE_SMOOTH));
		btnBuscar.setIcon(imagen6);

		// Eliminar el borde del botón para que la imagen sea visible
		btnBuscar.setBorderPainted(false);
		btnBuscar.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnBuscar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscar.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnBuscar.setForeground(Color.WHITE); // Color del texto
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnBuscar);
		
		JButton btnCerrarSesion1 = new JButton("");
		btnCerrarSesion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				dispose();
				login.setVisible(true);
			}
		});
		btnCerrarSesion1.setBounds(1839, 913, 55, 55);
		ImageIcon cerra1 = new ImageIcon(getClass().getResource("botonapagarsolo.png"));
		ImageIcon sesion1 = new ImageIcon(cerra.getImage().getScaledInstance(btnCerrarSesion1.getWidth(),
				btnCerrarSesion1.getHeight(), Image.SCALE_SMOOTH));
		
		 // Eliminar el borde del botón para que la imagen sea visible
		btnCerrarSesion1.setBorderPainted(false);
		btnCerrarSesion1.setContentAreaFilled(false);

        // Establecer el texto sobre la imagen
		btnCerrarSesion1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrarSesion1.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		btnCerrarSesion1.setForeground(Color.WHITE); // Color del texto
		btnCerrarSesion1.setIcon(sesion1);
		
		contentPane.add(btnCerrarSesion1);

		
				
				
				
				// JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1920, 1080);

		ImageIcon imagen8 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen9 = new ImageIcon(
				imagen8.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen9);
		contentPane.add(fondo);


	}
}

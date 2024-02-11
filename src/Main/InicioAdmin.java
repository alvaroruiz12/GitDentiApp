package Main;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class InicioAdmin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private JTable table;
	Citas citas = new Citas();
	private ArrayList<String> usuario;
	private Conexion conexion;
	private InicioAdmin padre;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		ArrayList<String> b = null;
		Conexion con = null;

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioAdmin frame = new InicioAdmin(b, con);
					// metodo para que la pantalla sea en pantalla completa
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					frame.setVisible(true);
					frame.setResizable(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public InicioAdmin(ArrayList<String> a, Conexion con) {

		padre = this;
		usuario = a;
		conexion = con;
		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		InicioAdmin frame = this;

		// easter egg control + O mensaje medi
		KeyStroke keystroke = KeyStroke.getKeyStroke("control O");
		int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap inputmap = getRootPane().getInputMap(condition);
		inputmap.put(keystroke, "mostraroptionpane");
		ActionMap actionmap = getRootPane().getActionMap();
		actionmap.put("mostraroptionpane", new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarioptionpane(frame);

			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 275, 1300, 513);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);

		// Personalizo la tabla
		JTable table_1 = new JTable();
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
		DefaultTableModel model;
		table_1.setModel(model = new DefaultTableModel(new Object[][] {
				// datos de la tabla
		}, new String[] { "Hora", "Fecha", "DNI paciente", "DNI doctor", "Observaciones" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		// metodo de cargar la tabla
		citas.CargarTabla(model, table_1);
		Insets margenes = new Insets(15, 15, 15, 15);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(207, 241, 255));
		menuBar.setForeground(Color.black);
		menuBar.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.setMargin(margenes);
		setJMenuBar(menuBar);

		JMenu mnNewMenu_1 = new JMenu("Hacer Pedido");
		mnNewMenu_1.setMargin(margenes);

		mnNewMenu_1.setBackground(new Color(207, 241, 255));
		mnNewMenu_1.setForeground(Color.black);
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Consulta");
		mnNewMenu_2.setMargin(margenes);

		mnNewMenu_2.setBackground(new Color(207, 241, 255));
		mnNewMenu_2.setForeground(Color.black);
		mnNewMenu_2.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Agregar citas");
		mntmNewMenuItem_4.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_4.setForeground(Color.black);
		mntmNewMenuItem_4.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				abrirCitas(a, con, padre);

			}

		});

		mnNewMenu_2.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Editar citas");
		mntmNewMenuItem_5.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_5.setForeground(Color.black);
		mntmNewMenuItem_5.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal2 = true;
				EditarCitas editarCitas = new EditarCitas(a, con, padre, modal2);
				editarCitas.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);

		
		
		JMenuItem  mntmNewMenuItem_1= new JMenuItem("Consultar citas");
		mntmNewMenuItem_1.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_1.setForeground(Color.black);
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal3 = true;
				ConsultarCitas consultarCitas = new ConsultarCitas(a, con, padre, modal3);
				consultarCitas.setVisible(true);

			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_3 = new JMenu("Inventario");
		mnNewMenu_3.setMargin(margenes);

		mnNewMenu_3.setBackground(new Color(207, 241, 255));
		mnNewMenu_3.setForeground(Color.black);
		mnNewMenu_3.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Consultar Inventario");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal1 = true;
				Inventario inventario = new Inventario(a, con, padre, modal1);
				inventario.setVisible(true);
			}
		});
		mntmNewMenuItem_12.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_12.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_3.add(mntmNewMenuItem_12);
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JMenu mnNewMenu_11 = new JMenu("Pedidos");
		
		mnNewMenu_11.setMargin(margenes);

		mnNewMenu_11.setBackground(new Color(207, 241, 255));
		mnNewMenu_11.setForeground(Color.black);
		mnNewMenu_11.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_11);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Aceptar Pedidos");
		mntmNewMenuItem_2.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal=true;
				AceptarPedidos aceptar = new AceptarPedidos(a,con,padre,modal);
				aceptar.setVisible(true);
			}
		});
		mnNewMenu_11.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Ver Pedidos");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				VerPedidos ver = new VerPedidos(a,con,padre,modal);
				ver.setVisible(true);			}
		});
		mntmNewMenuItem_3.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_3.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_11.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Modificar Pedidos");
		mntmNewMenuItem_13.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal=true;
				ModificarPedido modificar = new ModificarPedido(a,con,padre,modal);
				modificar.setVisible(true);
			}
		});
		mntmNewMenuItem_13.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_11.add(mntmNewMenuItem_13);


		JMenu mnNewMenu_5 = new JMenu("Pacientes");
		mnNewMenu_5.setMargin(margenes);

		mnNewMenu_5.setBackground(new Color(207, 241, 255));
		mnNewMenu_5.setForeground(Color.black);
		mnNewMenu_5.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_5);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Añadir paciente");
		mntmNewMenuItem_7.setMargin(margenes);

		mntmNewMenuItem_7.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_7.setForeground(Color.black);
		mntmNewMenuItem_7.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				AltaPacientes altaPaciente = new AltaPacientes(usuario, conexion, padre, rootPaneCheckingEnabled);
				altaPaciente.setVisible(modal);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_7);

		JMenuItem menuItem = new JMenuItem("Editar paciente");
		menuItem.setMargin(margenes);

		menuItem.setBackground(new Color(207, 241, 255));
		menuItem.setForeground(Color.black);
		menuItem.setFont(new Font("Arial", Font.PLAIN, 25));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				PacienteModificar pp = new PacienteModificar(a, con, padre, modal);
				pp.setVisible(modal);
			}
		});
		mnNewMenu_5.add(menuItem);
		
		JMenuItem mntmNewMenuItem_31 = new JMenuItem("Consultar paciente");
		mntmNewMenuItem_31.setMargin(margenes);

		mntmNewMenuItem_31.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_31.setForeground(Color.black);
		mntmNewMenuItem_31.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				ConsultarPaciente cp = new ConsultarPaciente(a, con, padre, modal);
				cp.setVisible(modal);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_31);
		
		JMenu mnNewMenu_6 = new JMenu("Doctores");
		mnNewMenu_6.setMargin(margenes);

		mnNewMenu_6.setBackground(new Color(207, 241, 255));
		mnNewMenu_6.setForeground(Color.black);
		mnNewMenu_6.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Añadir doctor");
		mntmNewMenuItem_8.setMargin(margenes);

		mntmNewMenuItem_8.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_8.setForeground(Color.black);
		mntmNewMenuItem_8.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				AltaDoctor altaDoctor = new AltaDoctor (usuario, conexion, padre, rootPaneCheckingEnabled);
				altaDoctor.setVisible(modal);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Editar doctor");
		mntmNewMenuItem_9.setMargin(margenes);

		mntmNewMenuItem_9.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_9.setForeground(Color.black);
		mntmNewMenuItem_9.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				DoctorModificar pp = new DoctorModificar(a, con, padre, modal);
				pp.setVisible(modal);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Baja doctor");		
		mntmNewMenuItem.setMargin(margenes);
		mntmNewMenuItem.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem.setForeground(Color.black);
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				BajaDoctor pp = new BajaDoctor(a, con, padre, modal);
				pp.setVisible(modal);
			}
		});

		mnNewMenu_6.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_131 = new JMenuItem("Consultar doctor");
		mntmNewMenuItem_131.setMargin(margenes);
		mntmNewMenuItem_131.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_131.setForeground(Color.black);
		mntmNewMenuItem_131.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_131.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				ConsultarDoctor cd = new ConsultarDoctor(a, con, padre, modal);
				cd.setVisible(modal);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_131);
		
		JMenu mnNewMenu_7 = new JMenu("Proveedores");
		mnNewMenu_7.setMargin(margenes);

		mnNewMenu_7.setBackground(new Color(207, 241, 255));
		mnNewMenu_7.setForeground(Color.black);
		mnNewMenu_7.setFont(new Font("Arial", Font.PLAIN, 25));
		
		menuBar.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Añadir proveedores");
		mntmNewMenuItem_10.setMargin(margenes);

		mntmNewMenuItem_10.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_10.setForeground(Color.black);
		mntmNewMenuItem_10.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				AltaProveedor pp = new AltaProveedor(a, con, padre, modal);
				pp.setVisible(modal);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Consultar proveedor");
		mntmNewMenuItem_14.setMargin(margenes);

		mntmNewMenuItem_14.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_14.setForeground(Color.black);
		mntmNewMenuItem_14.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				ConsultarProveedor cp = new ConsultarProveedor(a, con, padre, modal);
				cp.setVisible(modal);
			}
		});
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Modificar proveedores");
		mntmNewMenuItem_19.setMargin(margenes);

		mntmNewMenuItem_19.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_19.setForeground(Color.black);
		mntmNewMenuItem_19.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				ModificarProveedor mp = new ModificarProveedor(a, con, padre, modal);
				mp.setVisible(modal);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_19);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Dar de baja proveedores");
		mntmNewMenuItem_20.setMargin(margenes);

		mntmNewMenuItem_20.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_20.setForeground(Color.black);
		mntmNewMenuItem_20.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				BajaProveedor bp = new BajaProveedor(a, con, padre, modal);
				bp.setVisible(modal);
			}
		});
		mntmNewMenuItem_14.setMargin(margenes);

		mntmNewMenuItem_14.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_14.setForeground(Color.black);
		mntmNewMenuItem_14.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				ConsultarProveedor cp = new ConsultarProveedor(a, con, padre, modal);
				cp.setVisible(modal);
			}
		});
		mnNewMenu_7.add(mntmNewMenuItem_20);
		mnNewMenu_7.add(mntmNewMenuItem_14);
		
		JMenu mnNewMenu_8 = new JMenu("Tratamientos");
		mnNewMenu_8.setMargin(margenes);

		mnNewMenu_8.setBackground(new Color(207, 241, 255));
		mnNewMenu_8.setForeground(Color.black);
		mnNewMenu_8.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_8);
		
		
		JMenuItem mntmNewMenuItem_121 = new JMenuItem("Alta tratamiento");
		mntmNewMenuItem_121.setMargin(margenes);

		mntmNewMenuItem_121.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_121.setForeground(Color.black);
		mntmNewMenuItem_121.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_121.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				AltaTratamiento at = new AltaTratamiento(a, con, padre, modal);
				at.setVisible(modal);
			}
		});
		
		mnNewMenu_8.add(mntmNewMenuItem_121);
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Editar tratamientos");
		mntmNewMenuItem_11.setMargin(margenes);

		mntmNewMenuItem_11.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_11.setForeground(Color.black);
		mntmNewMenuItem_11.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				TratamientosModificar pp = new TratamientosModificar(a, con, padre, modal);
				pp.setVisible(modal);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_11);
		
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Consultar tratamientos");
		mntmNewMenuItem_21.setMargin(margenes);

		mntmNewMenuItem_21.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_21.setForeground(Color.black);
		mntmNewMenuItem_21.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				ConsultarTratamiento ct = new ConsultarTratamiento(a, con, padre, modal);
				ct.setVisible(modal);
			}
		});
		mnNewMenu_8.add(mntmNewMenuItem_21);
		

		
		JMenu mnNewMenu = new JMenu("Especialidad");
		mnNewMenu.setMargin(margenes);

		mnNewMenu.setBackground(new Color(207, 241, 255));
		mnNewMenu.setForeground(Color.black);
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 25));
		
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Alta especialidad");
		mntmNewMenuItem_15.setMargin(margenes);

		mntmNewMenuItem_15.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_15.setForeground(Color.black);
		mntmNewMenuItem_15.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				AltaEspecialidad ae = new AltaEspecialidad(a, con, padre, modal);
				ae.setVisible(modal);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Modificar especialidad");
		mntmNewMenuItem_16.setMargin(margenes);
		mntmNewMenuItem_16.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_16.setForeground(Color.black);
		mntmNewMenuItem_16.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				ModificarEspecialidad me = new ModificarEspecialidad(a, con, padre, modal);
				me.setVisible(modal);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_16);
		

		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Consultar especialidad");
		mntmNewMenuItem_17.setMargin(margenes);

		mntmNewMenuItem_17.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_17.setForeground(Color.black);
		mntmNewMenuItem_17.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				ConsultarEspecialidad ce = new ConsultarEspecialidad(a, con, padre, modal);
				ce.setVisible(modal);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_17);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Dar de baja una especialidad");
		mntmNewMenuItem_18.setMargin(margenes);

		mntmNewMenuItem_18.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_18.setForeground(Color.black);
		mntmNewMenuItem_18.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal = true;
				BajaEspecialidad be = new BajaEspecialidad(a, con, padre, modal);
				be.setVisible(modal);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_18);
		
		

		// combobox mes
		JComboBox<String> comboMes = new JComboBox<String>();
		comboMes.setBackground(new Color(207, 241, 255));
		comboMes.setForeground(Color.black);
		comboMes.setFont(new Font("Arial Black", Font.PLAIN, 30));
		comboMes.setBounds(81, 159, 1300, 70);
		((JLabel) comboMes.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(comboMes);
		// añadir todos los meses al combobox
		comboMes.addItem("Enero");
		comboMes.addItem("Febrero");
		comboMes.addItem("Marzo");
		comboMes.addItem("Abril");
		comboMes.addItem("Mayo");
		comboMes.addItem("Junio");
		comboMes.addItem("Julio");
		comboMes.addItem("Agosto");
		comboMes.addItem("Septiembre");
		comboMes.addItem("Octubre");
		comboMes.addItem("Noviembre");
		comboMes.addItem("Diciembre");

		// -------------------------------------------------
		// doctor 1
		// boton
		JButton btnDoctor1 = new JButton("Doctor Ramirez");
		btnDoctor1.setBackground(new Color(207, 241, 255));
		btnDoctor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor1.setBounds(1429, 260, 400, 60);
		ImageIcon imagen = new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4 = new ImageIcon(
				imagen.getImage().getScaledInstance(btnDoctor1.getWidth(), btnDoctor1.getHeight(), Image.SCALE_SMOOTH));
		// Eliminar el borde del botón para que la imagen sea visible
		btnDoctor1.setBorderPainted(false);
		btnDoctor1.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnDoctor1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDoctor1.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnDoctor1.setIcon(imagen4);
		contentPane.add(btnDoctor1);
		// barra progreso
		JProgressBar progressBarDoctor1 = new JProgressBar();
		progressBarDoctor1.setBounds(1471, 328, 300, 15);
		contentPane.add(progressBarDoctor1);

		// doctor 2
		// boton
		JButton btnDoctor2 = new JButton("Doctor Gutierrez");
		btnDoctor2.setBackground(new Color(207, 241, 255));
		btnDoctor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor2.setBounds(1429, 344, 400, 60);
		// Eliminar el borde del botón para que la imagen sea visible
		btnDoctor2.setBorderPainted(false);
		btnDoctor2.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnDoctor2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDoctor2.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnDoctor2.setIcon(imagen4);
		contentPane.add(btnDoctor2);
		// barra progreso
		JProgressBar progressBarDoctor2 = new JProgressBar();
		progressBarDoctor2.setBounds(1471, 409, 300, 15);
		contentPane.add(progressBarDoctor2);

		// doctor 3
		// boton
		JButton btnDoctor3 = new JButton("Doctora Martinez");
		btnDoctor3.setBackground(new Color(207, 241, 255));
		btnDoctor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor3.setBounds(1429, 435, 400, 60);
		// Eliminar el borde del botón para que la imagen sea visible
		btnDoctor3.setBorderPainted(false);
		btnDoctor3.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnDoctor3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDoctor3.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnDoctor3.setIcon(imagen4);
		contentPane.add(btnDoctor3);
		// barra progreso
		JProgressBar progressBarDoctor3 = new JProgressBar();
		progressBarDoctor3.setBounds(1471, 498, 300, 15);
		contentPane.add(progressBarDoctor3);
		// doctor 4
		// boton
		JButton btnDoctor4 = new JButton("Doctor Márquez");
		btnDoctor4.setBackground(new Color(207, 241, 255));
		btnDoctor4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor4.setBounds(1429, 524, 400, 60);
		// Eliminar el borde del botón para que la imagen sea visible
		btnDoctor4.setBorderPainted(false);
		btnDoctor4.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnDoctor4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDoctor4.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnDoctor4.setIcon(imagen4);
		contentPane.add(btnDoctor4);
		// barra progreso
		JProgressBar progressBarDoctor4 = new JProgressBar();
		progressBarDoctor4.setBounds(1471, 583, 300, 15);
		progressBarDoctor4.setValue(10);
		contentPane.add(progressBarDoctor4);
		// doctor 5
		// boton
		JButton btnDoctor5 = new JButton("Doctor Ayarza");
		btnDoctor5.setBackground(new Color(207, 241, 255));
		btnDoctor5.setBounds(1429, 609, 400, 60);
		// Eliminar el borde del botón para que la imagen sea visible
		btnDoctor5.setBorderPainted(false);
		btnDoctor5.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnDoctor5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDoctor5.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnDoctor5.setIcon(imagen4);
		contentPane.add(btnDoctor5);
		// progreso
		JProgressBar progressBarDoctor5 = new JProgressBar();
		progressBarDoctor5.setBounds(1471, 670, 300, 15);
		contentPane.add(progressBarDoctor5);
		// doctor 6
		// boton
		JButton btnDoctor6 = new JButton("Doctor Lavado");
		btnDoctor6.setBounds(1429, 696, 400, 60);
		btnDoctor6.setBackground(new Color(207, 241, 255));
		// Eliminar el borde del botón para que la imagen sea visible
		btnDoctor6.setBorderPainted(false);
		btnDoctor6.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnDoctor6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDoctor6.setVerticalTextPosition(SwingConstants.CENTER);
		// Personalizar el estilo del texto
		btnDoctor6.setIcon(imagen4);
		contentPane.add(btnDoctor6);
		// progreso
		JProgressBar progressBarDoctor6 = new JProgressBar();
		progressBarDoctor6.setBounds(1471, 759, 300, 15);

		contentPane.add(progressBarDoctor6);

		// boton cerrar sesion
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

		// Eliminar el borde del botón para que la imagen sea visible
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setContentAreaFilled(false);
		frame.getContentPane().add(btnCerrarSesion);

		// JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1920, 1080);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPane.add(fondo);
		
		JMenuItem mntmNewMenuItem_211 = new JMenuItem("New menu item");
		mntmNewMenuItem_211.setBounds(631, 111, 137, 26);
		contentPane.add(mntmNewMenuItem_211);

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()),
				"presionarBoton");
		getRootPane().getActionMap().put("presionarBoton", accionBoton);

	}

	private void abrirCitas(ArrayList<String> a, Conexion con, InicioAdmin padre) {
		// TODO Auto-generated method stub
		boolean modal = true;
		AgregarCitas agregarCitas = new AgregarCitas(a, con, padre, modal);
		agregarCitas.setVisible(true);

	}

	AbstractAction accionBoton = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {

			abrirCitas(usuario, conexion, padre);

		}
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void mostrarioptionpane(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "medinilla apruebanos <3", "TECLADO PULSADO",
				JOptionPane.INFORMATION_MESSAGE);
	}
}

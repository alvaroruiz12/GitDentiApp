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
	Citas citas= new Citas();
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
					//metodo para que la pantalla sea en pantalla completa
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
		setBounds(0,0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
   		InicioAdmin frame = this;
   		
   		//easter egg control + O mensaje medi
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
		//objeto para editar encabezado
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
			//datos de la tabla
		}, new String[] { "Hora", "Fecha", "IdPagos", "DNI paciente", "DNI doctor","Observaciones" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		//metodo de cargar la tabla
		citas.CargarTabla(model, table_1);
		 Insets margenes = new Insets(15, 15, 15, 15);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(207, 241, 255));
		menuBar.setForeground(Color.black);
		menuBar.setFont(new Font("Arial", Font.PLAIN, 25));
		 menuBar.setMargin(margenes);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Dar Alta");
		mnNewMenu.setBackground(new Color(207, 241, 255));
		mnNewMenu.setForeground(Color.black);
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu.setMargin(margenes);

		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Insertar Alta");
		mntmNewMenuItem.setMargin(margenes);

		mntmNewMenuItem.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem.setForeground(Color.black);
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal=true;
				InicioAltas alta = new InicioAltas(a,con,padre,modal);
				alta.setVisible(modal);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar Paciente");
		mntmNewMenuItem_1.setMargin(margenes);

		mntmNewMenuItem_1.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_1.setForeground(Color.black);
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal=true;
				PacienteModificar pp = new PacienteModificar(a,con,padre,modal);
				pp.setVisible(modal);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
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
				
				abrirCitas(a,con,padre);
				
			}

			
		});
		
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Editar citas");
		mntmNewMenuItem_5.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_5.setForeground(Color.black);
		mntmNewMenuItem_5.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal2=true;
				EditarCitas editarCitas=new EditarCitas(a,con,padre,modal2);
				editarCitas.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Eliminar citas");
		mntmNewMenuItem_6.setBackground(new Color(207, 241, 255));
		mntmNewMenuItem_6.setForeground(Color.black);
		mntmNewMenuItem_6.setFont(new Font("Arial", Font.PLAIN, 25));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modal3=true;
				EliminarCitas eliminarCitas= new EliminarCitas(a,con,padre,modal3);
				eliminarCitas.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_3 = new JMenu("Inventario");
		mnNewMenu_3.setMargin(margenes);

		mnNewMenu_3.setBackground(new Color(207, 241, 255));
		mnNewMenu_3.setForeground(Color.black);
		mnNewMenu_3.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Pedidos");
		mnNewMenu_4.setMargin(margenes);

		mnNewMenu_4.setBackground(new Color(207, 241, 255));
		mnNewMenu_4.setForeground(Color.black);
		mnNewMenu_4.setFont(new Font("Arial", Font.PLAIN, 25));
		menuBar.add(mnNewMenu_4);
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		 
		 JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modificar Doctor");
		 mntmNewMenuItem_2.setMargin(margenes);

		 mntmNewMenuItem_2.setBackground(new Color(207, 241, 255));
		 mntmNewMenuItem_2.setForeground(Color.black);
		 mntmNewMenuItem_2.setFont(new Font("Arial", Font.PLAIN, 25));
		 mntmNewMenuItem_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		boolean modal=true;
				DoctorModificar pp = new DoctorModificar(a,con,padre,modal);
				pp.setVisible(modal);
		 	}
		 });
		 mnNewMenu.add(mntmNewMenuItem_2);
		 
		 JMenuItem mntmNewMenuItem_3 = new JMenuItem("Modificar tratamiento");
		 mntmNewMenuItem_3.setMargin(margenes);

		 mntmNewMenuItem_3.setBackground(new Color(207, 241, 255));
		 mntmNewMenuItem_3.setForeground(Color.black);
		 mntmNewMenuItem_3.setFont(new Font("Arial", Font.PLAIN, 25));
		 mntmNewMenuItem_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		boolean modal=true;
				TratamientosModificar pp = new TratamientosModificar(a,con,padre,modal);
				pp.setVisible(modal);
		 	}
		 });
		 mnNewMenu.add(mntmNewMenuItem_3);
	
		
		
		//combobox mes
		JComboBox<String> comboMes = new JComboBox<String>();
		comboMes.setBackground(new Color(207, 241, 255));
		comboMes.setForeground(Color.black);
		comboMes.setFont(new Font("Arial Black", Font.PLAIN, 30));
		comboMes.setBounds(81, 159, 1300, 70);
		((JLabel)comboMes.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(comboMes);
		//añadir todos los meses al combobox
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
		
		//-------------------------------------------------
		//doctor 1
		//boton
		JButton btnDoctor1 = new JButton("Doctor Ramirez");
		btnDoctor1.setBackground(new Color(207, 241, 255));
		btnDoctor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor1.setBounds(1429, 260, 400, 60);
		ImageIcon imagen= new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4= new ImageIcon(imagen.getImage().getScaledInstance(btnDoctor1.getWidth(), btnDoctor1.getHeight(), Image.SCALE_SMOOTH));
        // Eliminar el borde del botón para que la imagen sea visible
		btnDoctor1.setBorderPainted(false);
		btnDoctor1.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnDoctor1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDoctor1.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		btnDoctor1.setIcon(imagen4);
		contentPane.add(btnDoctor1);
		//barra progreso
		JProgressBar progressBarDoctor1 = new JProgressBar();
		progressBarDoctor1.setBounds(1471, 328, 300, 15);
		contentPane.add(progressBarDoctor1);
		
		

		
		//doctor 2
		//boton
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
		//barra progreso
		JProgressBar progressBarDoctor2 = new JProgressBar();
		progressBarDoctor2.setBounds(1471, 409,300, 15);
		contentPane.add(progressBarDoctor2);
		
		//doctor 3
		//boton
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
		//barra progreso
		JProgressBar progressBarDoctor3 = new JProgressBar();
		progressBarDoctor3.setBounds(1471, 498,300, 15);
		contentPane.add(progressBarDoctor3);
		//doctor 4
		//boton
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
		//barra progreso
		JProgressBar progressBarDoctor4 = new JProgressBar();
		progressBarDoctor4.setBounds(1471, 583,300, 15);
		progressBarDoctor4.setValue(10);
		contentPane.add(progressBarDoctor4);
		//doctor 5
		//boton
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
		//progreso
		JProgressBar progressBarDoctor5 = new JProgressBar();
		progressBarDoctor5.setBounds(1471, 670,300, 15);
		contentPane.add(progressBarDoctor5);
		//doctor 6
		//boton
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
		//progreso
		JProgressBar progressBarDoctor6 = new JProgressBar();
		progressBarDoctor6.setBounds(1471, 759,300, 15);
		
		contentPane.add(progressBarDoctor6);
		

		
		
		//boton cerrar sesion
		JButton btnCerrarSesion = new JButton("");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login =new Login();
				dispose();
				login.setVisible(true);
			}
		});
		btnCerrarSesion.setBounds(1839, 913, 55, 55);
		ImageIcon cerra= new ImageIcon(getClass().getResource("botonapagarsolo.png"));
		ImageIcon sesion= new ImageIcon(cerra.getImage().getScaledInstance(btnCerrarSesion.getWidth(), btnCerrarSesion.getHeight(), Image.SCALE_SMOOTH));
		btnCerrarSesion.setIcon(sesion);
        
        // Eliminar el borde del botón para que la imagen sea visible
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setContentAreaFilled(false);
		frame.getContentPane().add(btnCerrarSesion);	
		

		
		//JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1920, 1080);

		ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPane.add(fondo);
		
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "presionarBoton");
        getRootPane().getActionMap().put("presionarBoton", accionBoton);
		
	}
	
	private void abrirCitas(ArrayList<String> a, Conexion con, InicioAdmin padre) {
		// TODO Auto-generated method stub
		boolean modal=true;
		AgregarCitas agregarCitas= new AgregarCitas(a,con,padre,modal);
		agregarCitas.setVisible(true);
		
	}
	
	AbstractAction accionBoton = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
        	
            abrirCitas(usuario,conexion,padre); 
            
        }
    };
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mostrarioptionpane(JFrame frame) {
		JOptionPane.showMessageDialog(frame, "medinilla apruebanos <3", "TECLADO PULSADO", JOptionPane.INFORMATION_MESSAGE);
	}
}

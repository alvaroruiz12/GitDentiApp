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
import java.util.ArrayList;

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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class InicioDoctor extends JFrame {

	private JPanel contentPane;
	private JTable tablaDia;
	private JTable table_1;
	DefaultTableModel model;
	Citas citas = new Citas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioDoctor frame = new InicioDoctor();
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
	public InicioDoctor() {

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
		
		// SOLICITAR MATERIALES
		JMenu mnNewMenu_1 = new JMenu("Solicitar material");
		//cambiar vista
		mnNewMenu_1.setBackground(new Color(207, 241, 255));
		mnNewMenu_1.setForeground(Color.black);
		mnNewMenu_1.setFont(new Font("Arial", Font.PLAIN, 25));
		mnNewMenu_1.setMargin(margenes);
		menuBar.add(mnNewMenu_1);


		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Crear solicitud");
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 151, 1223, 529);
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
		
		// boton cerrar sesion
				JButton btnCerra = new JButton("");
				btnCerrarSesion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login login = new Login();
						dispose();
						login.setVisible(true);
					}
				});
				btnCerrarSesion.setBounds(1639, 913, 55, 55);
				ImageIcon ca = new ImageIcon(getClass().getResource("botonapagarsolo.png"));
				ImageIcon sasa = new ImageIcon(ca.getImage().getScaledInstance(btnCerrarSesion.getWidth(),
						btnCerrarSesion.getHeight(), Image.SCALE_SMOOTH));
				btnCerrarSesion.setIcon(sesion);
		// JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1920, 1080);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		contentPane.add(fondo);

	}
}

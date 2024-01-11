package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 235, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		//boton para hacer info pacientes
		JButton btnInfoClientes = new JButton("INFO PACIENTE");
		btnInfoClientes.setBackground(new Color(134, 215, 253));
		btnInfoClientes.setBounds(0, 0, 380, 90);
		btnInfoClientes.setForeground(new Color(255, 255, 255));
		btnInfoClientes.setFont(new Font("Arial", Font.BOLD, 30));
		btnInfoClientes.setHorizontalAlignment(SwingConstants.CENTER);
		
		ImageIcon imagen= new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(btnInfoClientes.getWidth(), btnInfoClientes.getHeight(), Image.SCALE_SMOOTH));
        // Eliminar el borde del botón para que la imagen sea visible
		btnInfoClientes.setBorderPainted(false);
		btnInfoClientes.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnInfoClientes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInfoClientes.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		btnInfoClientes.setIcon(imagen2);
		
		contentPane.add(btnInfoClientes);
		
		
		//boton de solicitar material 
		JButton btnSolicitarMaterial = new JButton("<html><p>SOLICITAR</p><p>MATERIAL</p></html>");
		btnSolicitarMaterial.setBackground(new Color(134, 215, 253));
		btnSolicitarMaterial.setBounds(380, 0, 380, 90);
		btnSolicitarMaterial.setForeground(new Color(255, 255, 255));
		btnSolicitarMaterial.setFont(new Font("Arial", Font.BOLD, 30));
		btnSolicitarMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		btnSolicitarMaterial.setBorderPainted(false);
		btnSolicitarMaterial.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnSolicitarMaterial.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSolicitarMaterial.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		btnSolicitarMaterial.setIcon(imagen2);
		contentPane.add(btnSolicitarMaterial);
		

		//boton de crear CALENDARIO
		JButton btnCalendario= new JButton("CALENDARIO");
		btnCalendario.setBackground(new Color(134, 215, 253));
		btnCalendario.setBounds(1536, 0, 380, 90);
		btnCalendario.setForeground(new Color(255, 255, 255));
		btnCalendario.setFont(new Font("Arial", Font.BOLD, 30));
		btnCalendario.setHorizontalAlignment(SwingConstants.CENTER);
		//quitar bordes y fondo
		btnCalendario.setBorderPainted(false);
		btnCalendario.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnCalendario.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCalendario.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		btnCalendario.setIcon(imagen2);
		
		contentPane.add(btnCalendario);
		
		
		//boton de crear tratamiento
		JButton btnCrearTratamiento = new JButton("<html><p>CREAR</p><p>TRATAMIENTO</p></html>");
		btnCrearTratamiento.setBackground(new Color(134, 215, 253));
		btnCrearTratamiento.setBounds(1158, 0, 380, 90);
		btnCrearTratamiento.setForeground(new Color(255, 255, 255));
		btnCrearTratamiento.setFont(new Font("Arial", Font.BOLD, 30));
		btnCrearTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnCrearTratamiento.setBorderPainted(false);
		btnCrearTratamiento.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		btnCrearTratamiento.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCrearTratamiento.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		btnCrearTratamiento.setIcon(imagen2);
		contentPane.add(btnCrearTratamiento);
		
		
		//boton citas hoy
		JButton citasHoy = new JButton("<html><p>CITAS</p><p>HOY</p></html>");
		citasHoy.setBackground(new Color(134, 215, 253));
		citasHoy.setBounds(745, 0, 413, 90);
		citasHoy.setForeground(new Color(255, 255, 255));
		citasHoy.setFont(new Font("Arial", Font.BOLD, 30));
		citasHoy.setHorizontalAlignment(SwingConstants.CENTER);
		
		citasHoy.setBorderPainted(false);
		citasHoy.setContentAreaFilled(false);
		// Establecer el texto sobre la imagen
		citasHoy.setHorizontalTextPosition(SwingConstants.CENTER);
		citasHoy.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		citasHoy.setIcon(imagen2);
		
		citasHoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		citasHoy.setBounds(758, 0, 400, 90);
		contentPane.add(citasHoy);
			

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 168, 993, 386);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);

		// Personalizo la tabla
		table_1 = new JTable();
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
		table_1.setModel(model = new DefaultTableModel(new Object[][] {
		}, new String[] { "Hora", "Fecha", "IdPagos", "DNI paciente", "DNI doctor","Observaciones" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		
		citas.CargarTabla(model, table_1);

		
		//JLabel de fondo
				JLabel fondo = new JLabel();
				fondo.setBounds(0, 0, 1920, 1080);
			
				ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
				ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
				fondo.setIcon(imagen6);
				contentPane.add(fondo);
		

		
		
	}
}

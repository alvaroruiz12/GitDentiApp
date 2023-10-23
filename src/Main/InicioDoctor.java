package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import BBDD.Conexion;

import javax.swing.JLabel;
import javax.swing.JTable;

public class InicioDoctor extends JFrame {


	private JPanel contentPane;
	private JTable tablaDia;

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
		setBounds(100, 100, 1920, 1080);
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
		btnInfoClientes.setFont(new Font("Arial", Font.ITALIC, 33));
		btnInfoClientes.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(btnInfoClientes);
		
		
		//boton de solicitar material 
		JButton btnSolicitarMaterial = new JButton("<html><p>SOLICITAR</p><p>MATERIAL</p></html>");
		btnSolicitarMaterial.setBackground(new Color(134, 215, 253));
		btnSolicitarMaterial.setBounds(380, 0, 380, 90);
		btnSolicitarMaterial.setForeground(new Color(255, 255, 255));
		btnSolicitarMaterial.setFont(new Font("Arial", Font.ITALIC, 33));
		btnSolicitarMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(btnSolicitarMaterial);
		

		//boton de crear CALENDARIO
		JButton btnCalendario= new JButton("CALENDARIO");
		btnCalendario.setBackground(new Color(134, 215, 253));
		btnCalendario.setBounds(1536, 0, 380, 90);
		btnCalendario.setForeground(new Color(255, 255, 255));
		btnCalendario.setFont(new Font("Arial", Font.ITALIC, 33));
		btnCalendario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(btnCalendario);
		
		
		//boton de crear tratamiento
		JButton btnCrearTratamiento = new JButton("<html><p>CREAR</p><p>TRATAMIENTO</p></html>");
		btnCrearTratamiento.setBackground(new Color(134, 215, 253));
		btnCrearTratamiento.setBounds(1158, 0, 380, 90);
		btnCrearTratamiento.setForeground(new Color(255, 255, 255));
		btnCrearTratamiento.setFont(new Font("Arial", Font.ITALIC, 33));
		btnCrearTratamiento.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(btnCrearTratamiento);
		
		
		//boton citas hoy
		JButton citasHoy = new JButton("<html><p>CITAS</p><p>HOY</p></html>");
		citasHoy.setBackground(new Color(134, 215, 253));
		citasHoy.setBounds(1158, 0, 380, 90);
		citasHoy.setForeground(new Color(255, 255, 255));
		citasHoy.setFont(new Font("Arial", Font.ITALIC, 33));
		citasHoy.setHorizontalAlignment(SwingConstants.CENTER);
		citasHoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		citasHoy.setBounds(758, 0, 400, 90);
		contentPane.add(citasHoy);
			
		//array bidimencional de objetos con los datos de la tabla
		 Object[][] rowData = {
		 {"15/10/2023", "Álvaro Ruiz Lavado", "18:00", "Problemas de ortodoncia severa debido a una mala mordida y malos habitos"},
		 {"15/10/2023", "Ana Elena Ayarza Bueno", "19:00", "Problemas de ortodoncia severa debido a una mala mordida y malos habitos"},
		 {"15/10/2023", "Dani Fernadez Martinez", "14:00", "Problemas de ortodoncia severa debido a una mala mordida y malos habitos"},
	
		 };
		 

		//array String para las columnas de la tabla
		String[] columnNames = {"Día", "Pacientes", "Horas", "Tratamiento"};
		//tabla con la información del dia
		tablaDia = new JTable(rowData,columnNames);
			    
		
		tablaDia.setBounds(165, 204, 1600, 760);
		
		tablaDia.setFont(new Font("Arial", Font.PLAIN, 20));
	
		contentPane.add(tablaDia);
		
		//cambiar tamaño de las columnas
	     tablaDia.getColumnModel().getColumn(0).setPreferredWidth(200);
	     tablaDia.getColumnModel().getColumn(1).setPreferredWidth(500);
	     tablaDia.getColumnModel().getColumn(2).setPreferredWidth(200);
	     tablaDia.getColumnModel().getColumn(3).setPreferredWidth(800);

			//cambiar altura de las filas
			tablaDia.setRowHeight(40);
			
			
			//titulo de la tabla
			//Dia
			JLabel lblDia = new JLabel("Día");
			lblDia.setBounds(165, 179, 46, 14);
			contentPane.add(lblDia);
			//paciente
			JLabel lblPaciente = new JLabel("Paciente");
			lblPaciente.setBounds(564, 179, 46, 14);
			contentPane.add(lblPaciente);
			//fecha
			JLabel lblFecha = new JLabel("Fecha");
			lblFecha.setBounds(964, 179, 46, 14);
			contentPane.add(lblFecha);
			//Tratamiento
			JLabel lblTratamiento = new JLabel("Tratamiento");
			lblTratamiento.setBounds(1362, 179, 46, 14);
			contentPane.add(lblTratamiento);

	     


		
		
	}
}

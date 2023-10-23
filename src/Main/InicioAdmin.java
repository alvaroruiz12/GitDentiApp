package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTable;

public class InicioAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
			        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
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
	
	public InicioAdmin(ArrayList<String> a, Conexion con) {
		
		

	    
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		
		ArrayList<String> usuario_actual = a;
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
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
		JButton btnAltas = new JButton("ALTAS");
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InicioAltas altas = new InicioAltas(usuario,conexion);
				altas.setVisible(true);
				dispose();
				
			}
		});
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
		JButton consulta = new JButton("CONSULTA");
		consulta.setBackground(new Color(134, 215, 253));
		consulta.setBounds(1158, 0, 380, 90);
		consulta.setForeground(new Color(255, 255, 255));
		consulta.setFont(new Font("Arial", Font.ITALIC, 33));
		consulta.setHorizontalAlignment(SwingConstants.CENTER);
		consulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		consulta.setBounds(758, 0, 400, 90);
		contentPane.add(consulta);
		
		
		//combobox mes
		JComboBox comboMes = new JComboBox();
		comboMes.setForeground(new Color(255, 255, 255));
		comboMes.setBackground(new Color(134, 215, 253));
		comboMes.setFont(new Font("Arial Black", Font.PLAIN, 33));
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
		
		
		//doctor 1
		//boton
		JButton btnDoctor1 = new JButton("Doctor Ramirez");
		btnDoctor1.setBackground(new Color(134, 215, 253));
		btnDoctor1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor1.setBounds(1429, 260, 400, 60);
		contentPane.add(btnDoctor1);
		//barra progreso
		JProgressBar progressBarDoctor1 = new JProgressBar();
		progressBarDoctor1.setBounds(1429, 315, 400, 30);
		contentPane.add(progressBarDoctor1);
		
		

		
		//doctor 2
		//boton
		JButton btnDoctor2 = new JButton("Doctor Gutierrez");
		btnDoctor2.setBackground(new Color(134, 215, 253));
		btnDoctor2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor2.setBounds(1429, 344, 400, 60);
		contentPane.add(btnDoctor2);
		//barra progreso
		JProgressBar progressBarDoctor2 = new JProgressBar();
		progressBarDoctor2.setBounds(1429, 405, 400, 30);
		contentPane.add(progressBarDoctor2);
		
		//doctor 3
		//boton
		JButton btnDoctor3 = new JButton("Doctora Martinez");
		btnDoctor3.setBackground(new Color(134, 215, 253));
		btnDoctor3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor3.setBounds(1429, 435, 400, 60);
		contentPane.add(btnDoctor3);
		//barra progreso
		JProgressBar progressBarDoctor3 = new JProgressBar();
		progressBarDoctor3.setBounds(1429, 494, 400, 30);
		contentPane.add(progressBarDoctor3);
		//doctor 4
		//boton
		JButton btnDoctor4 = new JButton("Doctor Márquez");
		btnDoctor4.setBackground(new Color(134, 215, 253));
		btnDoctor4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDoctor4.setBounds(1429, 524, 400, 60);
		contentPane.add(btnDoctor4);
		//barra progreso
		JProgressBar progressBarDoctor4 = new JProgressBar();
		progressBarDoctor4.setBounds(1429, 580, 400, 30);
		progressBarDoctor4.setValue(10);
		contentPane.add(progressBarDoctor4);
		//doctor 5
		//boton
		JButton btnDoctor5 = new JButton("Doctor Ayarza");
		btnDoctor5.setBackground(new Color(134, 215, 253));
		btnDoctor5.setBounds(1429, 609, 400, 60);
		contentPane.add(btnDoctor5);
		//progreso
		JProgressBar progressBarDoctor5 = new JProgressBar();
		progressBarDoctor5.setBounds(1429, 667, 400, 30);
		contentPane.add(progressBarDoctor5);
		//doctor 6
		//boton
		JButton btnDoctor6 = new JButton("Doctor Lavado");
		btnDoctor6.setBounds(1429, 696, 400, 60);
		btnDoctor6.setBackground(new Color(134, 215, 253));
		contentPane.add(btnDoctor6);
		//progreso
		JProgressBar progressBarDoctor6 = new JProgressBar();
		progressBarDoctor6.setBounds(1429, 758, 400, 30);
		
		contentPane.add(progressBarDoctor6);
		
		table = new JTable();
		table.setBounds(81, 283, 1300, 554);
		contentPane.add(table);
		

		

		

		
		
	}
	
}

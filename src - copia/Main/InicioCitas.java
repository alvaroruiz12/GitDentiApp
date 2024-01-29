package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import BBDD.Conexion;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class InicioCitas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblPagos;
	private JTextField txHora;
	private JTextField txFecha;
	private JTextField txDoctor;
	private JTextField txPagos;
	private JTextField txTratamientos;
	private JTextField txPacientes;
	private JTextField txObservaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<String> b = null;
				Conexion con = null;
				try {
					InicioCitas dialog = new InicioCitas(b,con,null,true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					//hacer que no se pueda cambiar de tamaño
					dialog.setResizable(false);
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public InicioCitas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		
		super(parent,modal);
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		
		
		
		setBounds(100, 100, 1100, 650);
		getContentPane().setLayout(null);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(318, 69, 200, 50);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHora);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(318, 130, 200, 50);
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(318, 191, 200, 50);
		lblDoctor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDoctor);
		
		lblPagos = new JLabel("Pagos");
		lblPagos.setBounds(318, 252, 200, 50);
		lblPagos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPagos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPagos);
		
		JLabel lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.setBounds(318, 313, 200, 50);
		lblTratamientos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTratamientos);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(318, 435, 200, 50);
		lblObservaciones.setFont(new Font("Arial", Font.PLAIN, 20));
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblObservaciones);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setBounds(318, 374, 200, 50);
		lblPacientes.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPacientes);
		
		
		//jtextField
		txHora = new JTextField();
		txHora.setBounds(540, 82, 150, 30);
		getContentPane().add(txHora);
		txHora.setColumns(10);
		
		txFecha = new JTextField();
		txFecha.setBounds(540, 143, 150, 30);
		getContentPane().add(txFecha);
		txFecha.setColumns(10);
		
		txDoctor = new JTextField();
		txDoctor.setBounds(540, 204, 150, 30);
		getContentPane().add(txDoctor);
		txDoctor.setColumns(10);
		
		txPagos = new JTextField();
		txPagos.setBounds(540, 265, 150, 30);
		getContentPane().add(txPagos);
		txPagos.setColumns(10);
		
		txTratamientos = new JTextField();
		txTratamientos.setBounds(540, 326, 150, 30);
		getContentPane().add(txTratamientos);
		txTratamientos.setColumns(10);
		
		txPacientes = new JTextField();
		txPacientes.setBounds(540, 387, 150, 30);
		getContentPane().add(txPacientes);
		txPacientes.setColumns(10);
		
		txObservaciones = new JTextField();
		txObservaciones.setBounds(540, 442, 200, 80);
		getContentPane().add(txObservaciones);
		txObservaciones.setColumns(10);
		

		
		//boton insertar
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pagosId=Integer.parseInt(txPagos.getText().toString());
				int tratamientosId=Integer.parseInt(txTratamientos.getText().toString());
				String sentencia="Insert into dentiapp.citas (Hora,Fecha,pagos_idpagos,tratamientos_idtratamientos,"
						+ "observaciones,pacientes_DNIpaciente,doctor_DNI1)values('"+txHora.getText().toString()+"',"
								+ "'"+txFecha.getText().toString()+"',"+pagosId+","+tratamientosId+",'"+txObservaciones.getText().toString()+"'"
										+ ",'"+txPacientes.getText().toString()+"','"+txDoctor.getText().toString()+"')";
				
				
				boolean status = false;
				status = conexion.insertar(conexion,sentencia);
			}
		});
		btnInsertar.setBounds(870, 313, 108, 73);
		getContentPane().add(btnInsertar);
		
	
		
		
	
		
		
	}
}

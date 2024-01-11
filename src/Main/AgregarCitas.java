package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import BBDD.Conexion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JTextField;
import javax.print.attribute.AttributeSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AgregarCitas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblPagos;
	private JTextField txHora;
	private JTextField txFecha;
	private JTextField txDoctor;
	private JTextField txPagos;
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
					AgregarCitas dialog = new AgregarCitas(b,con,null,true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setResizable(false); // para que no se pueda cambiar de tamaño
					dialog.setLocationRelativeTo(null); // Para que nuestra ventana aparezca siempre en la mitad de la
														// pantalla.

					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AgregarCitas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		
		super(parent,modal);
		
		ArrayList<String> usuario = a;
		Conexion conexion = con;
		
		 
		
		setBounds(200, 150, 1100, 650);
		getContentPane().setLayout(null);
		//labels
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(318, 69, 200, 50);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHora.setForeground(Color.white);

		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHora);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(318, 130, 200, 50);
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFecha.setForeground(Color.white);

		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(318, 191, 200, 50);
		lblDoctor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDoctor.setForeground(Color.white);

		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDoctor);
		
		lblPagos = new JLabel("Pagos");
		lblPagos.setBounds(318, 252, 200, 50);
		lblPagos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPagos.setForeground(Color.white);

		lblPagos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPagos);
		
		JLabel lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.setBounds(318, 313, 200, 50);
		lblTratamientos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTratamientos.setForeground(Color.white);

		lblTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTratamientos);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(318, 435, 200, 50);
		lblObservaciones.setFont(new Font("Arial", Font.PLAIN, 20));
		lblObservaciones.setForeground(Color.white);

		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblObservaciones);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setBounds(318, 374, 200, 50);
		lblPacientes.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPacientes.setForeground(Color.white);
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
		
		txPacientes = new JTextField();
		txPacientes.setBounds(540, 387, 150, 30);
		getContentPane().add(txPacientes);
		txPacientes.setColumns(10);
		
		txObservaciones = new JTextField();
		txObservaciones.setBounds(540, 443, 200, 80);
		getContentPane().add(txObservaciones);
		txObservaciones.setColumns(10);
// combobox tratamientos
		
		JComboBox cbTratamientos = new JComboBox();
		cbTratamientos.setBounds(540, 326, 150, 30);
		getContentPane().add(cbTratamientos);
		cbTratamientos.addItem("Limpieza dental");
		cbTratamientos.addItem("Ortodoncia");
		cbTratamientos.addItem("Empaste");
		cbTratamientos.addItem("Extracción");
		
		
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fecha = txFecha.getText();
				int pagosId=0;
				//declaracion de variables
				int tratamientosId=0;
				String pagos=txPagos.getText().toString();
				if (pagos.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Introduce un id de pago", "Error", JOptionPane.ERROR_MESSAGE);

				}else{
					 pagosId=Integer.parseInt(txPagos.getText().toString());

				}
				//seleccion del combobox de tratamientos
				if(cbTratamientos.getSelectedItem().equals("Limpieza dental")) {
					 tratamientosId=5;
				}else if(cbTratamientos.getSelectedItem().equals("Ortodoncia")){
					 tratamientosId=6;

				}else if(cbTratamientos.getSelectedItem().equals("Empaste")) {
					 tratamientosId=7;

				}else if(cbTratamientos.getSelectedItem().equals("Extracción")){
					 tratamientosId=8;
				}
				if (tratamientosId==0) {
			        JOptionPane.showMessageDialog(null, "Selecciona un tratamiento", "Error", JOptionPane.ERROR_MESSAGE);

				}
				//comprobaciones
				String dnipaciente=txPacientes.getText();
				if (dnipaciente.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Escribe un DNI en pacientes", "Error", JOptionPane.ERROR_MESSAGE);
				}
				String dnidoctor=txDoctor.getText();
				if(dnidoctor.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Escribe un DNI de doctor", "Error", JOptionPane.ERROR_MESSAGE);

				}
				String hora=txHora.getText();
				if(hora.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Introduce una hora", "Error", JOptionPane.ERROR_MESSAGE);

				}
				if (fecha.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Introduce una fecha", "Error", JOptionPane.ERROR_MESSAGE);

				}
				String observaciones=txObservaciones.getText();
                if (observaciones.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Escribe un observacion", "Error", JOptionPane.ERROR_MESSAGE);
                }
				//sentencia sql
				String sentencia="Insert into dentiapp.citas (Hora,Fecha,pagos_idpagos,tratamientos_idtratamientos,"
						+ "observaciones,pacientes_DNIpaciente,doctor_DNI)values('"+txHora.getText().toString()+"',"
								+ "'"+txFecha.getText().toString()+"',"+pagosId+","+tratamientosId+",'"+txObservaciones.getText().toString()+"'"
										+ ",'"+txPacientes.getText().toString()+"','"+txDoctor.getText().toString()+"')";
				
				
				
				boolean status = false;
				status = conexion.insertar(conexion,sentencia);}
			
		});
		btnInsertar.setBounds(966, 530, 108, 70);
		ImageIcon imagen= new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(btnInsertar.getWidth(), btnInsertar.getHeight(), Image.SCALE_SMOOTH));
        
		// Establecer el texto sobre la imagen
		btnInsertar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnInsertar.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		btnInsertar.setForeground(Color.WHITE); // Color del texto
        btnInsertar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
        btnInsertar.setIcon(imagen2);
        
        
        // Eliminar el borde del botón para que la imagen sea visible
        btnInsertar.setBorderPainted(false);
        btnInsertar.setContentAreaFilled(false);
		getContentPane().add(btnInsertar);
		
		JButton btnVolver = new JButton("VOLVER");
	
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(966, 7, 105, 50);
		ImageIcon imagen3= new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4= new ImageIcon(imagen3.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
        btnVolver.setIcon(imagen4);
        
        // Eliminar el borde del botón para que la imagen sea visible
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnVolver.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVolver.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
		btnVolver.setForeground(Color.WHITE); // Color del texto
		btnVolver.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnVolver);
		
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1100, 650);
	
		ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		getContentPane().add(fondo);
		

		
	
		
	}
	
	
}

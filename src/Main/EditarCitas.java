package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BBDD.Conexion;

public class EditarCitas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblPagos;
	private JTextField txHora;
	private JTextField txFecha;
	private JTextField txDoctor;
	private JTextField txPagos;
	private JTextField txPacientes;
	private JTextField txObservaciones;
	private JTextField txID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ArrayList<String> b = null;
				Conexion con = null;
				try {
					EditarCitas dialog = new EditarCitas(b,con,null,true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public EditarCitas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 1100, 650);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(318, 152, 200, 50);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHora.setForeground(Color.white);

		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblHora);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(318, 201, 200, 50);
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 20));
		lblFecha.setForeground(Color.white);

		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);
		
		JLabel lblDoctor = new JLabel("Doctor");
		lblDoctor.setBounds(318, 262, 200, 50);
		lblDoctor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDoctor.setForeground(Color.white);

		lblDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDoctor);
		
		lblPagos = new JLabel("Pagos");
		lblPagos.setBounds(318, 323, 200, 50);
		lblPagos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPagos.setForeground(Color.white);

		lblPagos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPagos);
		
		JLabel lblTratamientos = new JLabel("Tratamientos");
		lblTratamientos.setBounds(318, 384, 200, 50);
		lblTratamientos.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTratamientos.setForeground(Color.white);

		lblTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTratamientos);
		
		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setBounds(318, 518, 200, 50);
		lblObservaciones.setFont(new Font("Arial", Font.PLAIN, 20));
		lblObservaciones.setForeground(Color.white);

		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblObservaciones);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setBounds(318, 444, 200, 50);
		lblPacientes.setFont(new Font("Arial", Font.PLAIN, 20));
		lblPacientes.setForeground(Color.white);
		lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPacientes);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(318, 91, 200, 50);
		lblID.setFont(new Font("Arial", Font.PLAIN, 20));
		lblID.setForeground(Color.white);

		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblID);
		//jtextField
		txHora = new JTextField();
		txHora.setBounds(540, 165, 150, 30);
		getContentPane().add(txHora);
		txHora.setColumns(10);
		
		txFecha = new JTextField();
		txFecha.setBounds(540, 214, 150, 30);
		getContentPane().add(txFecha);
		txFecha.setColumns(10);
		
		txDoctor = new JTextField();
		txDoctor.setBounds(540, 275, 150, 30);
		getContentPane().add(txDoctor);
		txDoctor.setColumns(10);
		
		txPagos = new JTextField();
		txPagos.setBounds(540, 336, 150, 30);
		getContentPane().add(txPagos);
		txPagos.setColumns(10);
		
		txPacientes = new JTextField();
		txPacientes.setBounds(540, 457, 150, 30);
		getContentPane().add(txPacientes);
		txPacientes.setColumns(10);
		
		txObservaciones = new JTextField();
		txObservaciones.setBounds(540, 506, 200, 80);
		getContentPane().add(txObservaciones);
		txObservaciones.setColumns(10);
		
		txID = new JTextField();
		txID.setBounds(540, 104, 150, 30);
		getContentPane().add(txID);
		txID.setColumns(10);
		
// combobox tratamientos
		
		JComboBox cbTratamientos = new JComboBox();
		cbTratamientos.setBounds(540, 397, 150, 30);
		getContentPane().add(cbTratamientos);
		cbTratamientos.addItem("Limpieza dental");
		cbTratamientos.addItem("Ortodoncia");
		cbTratamientos.addItem("Empaste");
		cbTratamientos.addItem("Extracción");
		
		
		JButton btnVolver = new JButton("VOLVER");
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(966, 7, 105, 50);
		ImageIcon imagen3= new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4= new ImageIcon(imagen3.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
        getContentPane().setLayout(null);
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
		
		//BOTON EDITAR
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int pagosId=0;
				//declaracion de variables
				int tratamientosId=0;
				String pagos=txPagos.getText().toString();
				if (pagos.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Introduce un id de pago", "Error", JOptionPane.ERROR_MESSAGE);

				}else{
					 pagosId=Integer.parseInt(txPagos.getText().toString());

				}
				int nid=0;
				String id=txID.getText().toString();
				if (id.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Introduce un id", "Error", JOptionPane.ERROR_MESSAGE);

				}else{
					 nid=Integer.parseInt(txID.getText().toString());

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

				
				
				String fecha = txFecha.getText();

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                String hora=txHora.getText();
                String pacientes=txPacientes.getText();
                String doctor=txDoctor.getText();
                String observaciones=txObservaciones.getText();
                if (hora.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Escribe una hora", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (fecha.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Escribe una fecha", "Error", JOptionPane.ERROR_MESSAGE);
                }                
                if (pacientes.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Escribe un DNI de paciente", "Error", JOptionPane.ERROR_MESSAGE);
                }                
                if (doctor.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Escribe un DNI de doctor", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (observaciones.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Escribe un observacion", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
              //sentencia sql
				 try {
                String consulta = "UPDATE citas " +
		                 "SET Hora = '" + hora + "', " +
		                 "Fecha = '" + fecha + "', " +
		                 "pagos_idpagos = " +pagosId+ ", " +
		                 "pacientes_DNIpaciente = '" + pacientes+ "', " +
		                 "tratamientos_idtratamientos = " + tratamientosId+ ", " +
		                 "doctor_DNI = '" +doctor+ "', " +
		                 "observaciones = '" + observaciones + "', " +
		                 "WHERE idcitas = "+nid+";" ;
			
               
					con.ejecutarInsertDeleteUpdate(consulta);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEditar.setBounds(966, 550, 105, 50);
		getContentPane().setLayout(null);
		btnEditar.setIcon(imagen4);
        
        // Eliminar el borde del botón para que la imagen sea visible
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
        btnEditar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(SwingConstants.CENTER);

        // Personalizar el estilo del texto
        btnEditar.setForeground(Color.WHITE); // Color del texto
        btnEditar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnEditar);
		getContentPane().add(btnEditar);
		
		

		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1100, 650);
	
		ImageIcon imagen5= new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6= new ImageIcon(imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		getContentPane().add(fondo);
		

	}
	
}

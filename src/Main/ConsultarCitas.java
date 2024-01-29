package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;
import javax.swing.JTextField;

public class ConsultarCitas extends JDialog {
	Citas citas = new Citas();
	private static final long serialVersionUID = 1L;
	private JTextField textoNombre;
	private JTextField textoApellidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<String> b = null;
		Conexion con = null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCitas dialog = new ConsultarCitas(b, con, null, true);
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
	public ConsultarCitas(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 1000, 700);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 261, 927, 389);
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

		// boton para volver a inicio
		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(879, 0, 105, 50);
		ImageIcon imagen3 = new ImageIcon(getClass().getResource("boton.png"));
		ImageIcon imagen4 = new ImageIcon(
				imagen3.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH));
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

		textoNombre = new JTextField();
		textoNombre.setBounds(106, 79, 86, 20);
		getContentPane().add(textoNombre);
		textoNombre.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(431, 78, 89, 23);
		getContentPane().add(btnBuscar);

		
		textoApellidos = new JTextField();
		textoApellidos.setBounds(224, 79, 86, 20);
		getContentPane().add(textoApellidos);
		textoApellidos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(106, 54, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(214, 53, 46, 14);
		getContentPane().add(lblNewLabel_1);

		
		
		// JLabel de fondo
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1000, 700);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		getContentPane().add(fondo);

	}
}
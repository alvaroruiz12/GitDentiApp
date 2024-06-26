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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BBDD.Conexion;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ModificarProveedor extends JDialog {

	private static final long serialVersionUID = 1L;
	JTable table_1 = new JTable();
	Proveedor proveedor = new Proveedor();
	DefaultTableModel model;
	private JTextField txTelefono;
	private JTextField txCorreo;
	private JTextField txNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			ArrayList<String> b = null;
			Conexion con = null;

			public void run() {
				try {
					ModificarProveedor dialog = new ModificarProveedor(b, con, null, true);
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
	public ModificarProveedor(ArrayList<String> a, Conexion con, InicioAdmin parent, boolean modal) {
		setBounds(100, 100, 1100, 600);
		getContentPane().setLayout(null);

		Conexion conexion = con;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(356, 72, 718, 435);
		scrollPane.setBorder(new LineBorder((new Color(86, 151, 153)), 2, true));
		getContentPane().add(scrollPane);

		// Personalizo la tabla
		// objeto para editar encabezado
		JTableHeader header = table_1.getTableHeader();
		header.setForeground(Color.black);
		header.setBackground(new Color(207, 241, 255));
		table_1.setIntercellSpacing(new Dimension(4, 4));
		// ajusta el alto de las columnas de la tabla
		table_1.setRowHeight(30);
		// Cambia el color de fondo de las filas seleccionadas
		table_1.setSelectionBackground(new Color(217, 217, 217));
		table_1.setSelectionForeground(Color.BLACK);
		table_1.setModel(model = new DefaultTableModel(new Object[][] {},
				new String[] { "CIF", "Nombre", "Telefono", "Correo" }));
		table_1.getColumnModel().getColumn(1).setMinWidth(23);
		scrollPane.setViewportView(table_1);
		proveedor.CargarTabla(model, table_1);
		// boton para volver a inicio
		JButton btnVolver = new JButton("VOLVER");

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(969, 11, 105, 50);
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

		JLabel NombreTexto = new JLabel("Nombre");
		NombreTexto.setBounds(55, 106, 80, 30);
		NombreTexto.setFont(new Font("Arial", Font.PLAIN, 20));
		NombreTexto.setForeground(Color.white);

		NombreTexto.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(NombreTexto);

		JComboBox comboNombre = new JComboBox();
		int tamañoNombre = 0;
		// metodo recoge el nombre y el dni

		ArrayList<String> CIFList = proveedor.CargarCIF();
		ArrayList<String> Nombre = proveedor.CargarNombreProveedor();

		System.out.println(Nombre);
		// mete los nombres en el combobox
		for (int i = 0; i < Nombre.size(); i++) {
			comboNombre.addItem(Nombre.get(i).toString());
		}

		comboNombre.setBounds(67, 31, 181, 30);
		getContentPane().add(comboNombre);

		JLabel txCIF = new JLabel("CIF");
		txCIF.setBounds(156, 173, 151, 30);
		txCIF.setFont(new Font("Arial", Font.PLAIN, 20));
		txCIF.setForeground(Color.white);

		txCIF.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txCIF);

		txTelefono = new JTextField();
		txTelefono.setBounds(156, 237, 151, 30);
		getContentPane().add(txTelefono);
		txTelefono.setColumns(10);

		txCorreo = new JTextField();
		txCorreo.setBounds(156, 308, 151, 30);
		getContentPane().add(txCorreo);
		txCorreo.setColumns(10);

		txNombre = new JTextField();
		txNombre.setBounds(156, 109, 151, 30);
		getContentPane().add(txNombre);
		txNombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(36, 237, 105, 30);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setBounds(55, 310, 61, 20);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel_3);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doc = "";
				// coger el dni
				for (int i = 0; i < Nombre.size(); i++) {

					String nomDoc = Nombre.get(i).toString();
					if (nomDoc.equals(comboNombre.getSelectedItem().toString())) {
						doc = CIFList.get(i);
					}
				}
				int telefono=Integer.parseInt(String.valueOf(txTelefono.getText()));
				String sentencia = "UPDATE dentiapp.proveedor " 
				+ "SET " + "nombre_proveedor='" + txNombre.getText().toString() + "', "
								+ "" + "telefono_proveedor="+ telefono + ","
										+ " " + "correo_proveedor='"+ txCorreo.getText().toString() + "' "
												+ "WHERE CIFproveedor='"+txCIF.getText().toString()+"'";
				boolean status = false;
				status = conexion.insertar(conexion, sentencia);
				if (status = true) {

				}
				proveedor.CargarTabla(model, table_1);

			}
		});
		btnModificar.setBounds(137, 392, 170, 37);
		btnModificar.setIcon(imagen4);

		// Eliminar el borde del botón para que la imagen sea visible
		btnModificar.setBorderPainted(false);
		btnModificar.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnModificar.setForeground(Color.WHITE); // Color del texto
		btnModificar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnModificar);

		JButton btnRellenar = new JButton("RELLENAR");
		btnRellenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String doc = "";
				// coger el dni
				for (int i = 0; i < Nombre.size(); i++) {

					String nomDoc = Nombre.get(i).toString();
					if (nomDoc.equals(comboNombre.getSelectedItem().toString())) {
						doc = CIFList.get(i);
					}
				}

				ArrayList<String> datos = null;

				System.out.println(doc);
				datos = proveedor.RellenarDatosProveedor(doc);
				txCIF.setText(datos.get(0));
				txNombre.setText(datos.get(1));
				txTelefono.setText(datos.get(2));
				txCorreo.setText(datos.get(3));

			}

		});
		btnRellenar.setBounds(258, 19, 137, 50);
		btnRellenar.setIcon(imagen4);

		// Eliminar el borde del botón para que la imagen sea visible
		btnRellenar.setBorderPainted(false);
		btnRellenar.setContentAreaFilled(false);

		// Establecer el texto sobre la imagen
		btnRellenar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRellenar.setVerticalTextPosition(SwingConstants.CENTER);

		// Personalizar el estilo del texto
		btnRellenar.setForeground(Color.WHITE); // Color del texto
		btnRellenar.setFont(new Font("Arial", Font.BOLD, 16)); // Tipo de letra y tamaño
		getContentPane().add(btnRellenar);

		
		
		
		JLabel fondo = new JLabel();
		fondo.setBounds(0, 0, 1100, 650);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("fondo.jpg"));
		ImageIcon imagen6 = new ImageIcon(
				imagen5.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(imagen6);
		getContentPane().add(fondo);
	}

}

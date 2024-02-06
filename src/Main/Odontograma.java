package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BBDD.Conexion;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Odontograma extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Paciente paciente;
	private int seleccionado;
	Conexion con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//Odontograma dialog = new Odontograma();
			//dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			//dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Odontograma(String DNIpaciente) {
		setBounds(100, 100, 707, 736);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(113, 467, 440, 125);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(113, 331, 440, 125);
		contentPanel.add(textArea);
		
		con = new Conexion();
		con.conectar();
		
		//pillar el paciente por el dni que me han pasado
		
		ArrayList<String> observacionesDientes = con.selectObservacionesDiente(DNIpaciente);
		
		
		
		JLabel lblFotoDiente = new JLabel();
		lblFotoDiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String res = observacionesDientes.get(0);
				
				textArea.setText(res);
				
				seleccionado = 1;
				
			}
		});
		lblFotoDiente.setBounds(60, 68, 90, 92);
		ImageIcon imagen= new ImageIcon(getClass().getResource("colorido-diente.png"));
		ImageIcon imagen2= new ImageIcon(imagen.getImage().getScaledInstance(lblFotoDiente.getWidth(), lblFotoDiente.getHeight(), Image.SCALE_SMOOTH));
		lblFotoDiente.setIcon(imagen2);
		contentPanel.add(lblFotoDiente);
		
		JLabel lblFotoDiente_1 = new JLabel();
		lblFotoDiente_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String res = observacionesDientes.get(1);
				
				textArea.setText(res);
				seleccionado = 2;
			}
		});
		lblFotoDiente_1.setBounds(173, 68, 90, 92);
		lblFotoDiente_1.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_1);
		
		JLabel lblFotoDiente_2 = new JLabel();
		lblFotoDiente_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String res = observacionesDientes.get(2);
				
				textArea.setText(res);
				seleccionado = 3;
			}
		});
		lblFotoDiente_2.setBounds(300, 68, 90, 92);
		lblFotoDiente_2.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_2);
		
		JLabel lblFotoDiente_3 = new JLabel();
		lblFotoDiente_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				String res = observacionesDientes.get(3);
				
				textArea.setText(res);
				seleccionado = 4;
			}
		});
		lblFotoDiente_3.setBounds(419, 68, 90, 92);
		lblFotoDiente_3.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_3);
		
		JLabel lblFotoDiente_4 = new JLabel();
		lblFotoDiente_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String res = observacionesDientes.get(4);
				
				textArea.setText(res);
				seleccionado = 5;
			}
		});
		lblFotoDiente_4.setBounds(543, 68, 90, 92);
		lblFotoDiente_4.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_4);
		
		JLabel lblFotoDiente_5 = new JLabel();
		lblFotoDiente_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String res = observacionesDientes.get(5);
				
				textArea.setText(res);
				seleccionado = 6;
			}
		});
		lblFotoDiente_5.setBounds(60, 171, 90, 92);
		lblFotoDiente_5.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_5);
		
		JLabel lblFotoDiente_6 = new JLabel();
		lblFotoDiente_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String res = observacionesDientes.get(6);
				
				textArea.setText(res);
				seleccionado = 7;
			}
		});
		lblFotoDiente_6.setBounds(173, 171, 90, 92);
		lblFotoDiente_6.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_6);
		
		JLabel lblFotoDiente_7 = new JLabel();
		lblFotoDiente_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String res = observacionesDientes.get(7);
				
				textArea.setText(res);
				seleccionado = 8;
			}
		});
		lblFotoDiente_7.setBounds(300, 171, 90, 92);
		lblFotoDiente_7.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_7);
		
		JLabel lblFotoDiente_8 = new JLabel();
		lblFotoDiente_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String res = observacionesDientes.get(8);
				
				textArea.setText(res);
				seleccionado = 9;
			}
		});
		lblFotoDiente_8.setBounds(419, 171, 90, 92);
		lblFotoDiente_8.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_8);
		
		JLabel lblFotoDiente_9 = new JLabel();
		lblFotoDiente_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				String res = observacionesDientes.get(9);
				
				textArea.setText(res);
				seleccionado = 10;
			}
		});
		lblFotoDiente_9.setBounds(543, 171, 90, 92);
		lblFotoDiente_9.setIcon(imagen2);
		contentPanel.add(lblFotoDiente_9);
		
		JLabel lblNewLabel = new JLabel("D 1");
		lblNewLabel.setBounds(80, 43, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("D 2");
		lblNewLabel_1.setBounds(196, 43, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("D 3");
		lblNewLabel_2.setBounds(320, 43, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("D 4");
		lblNewLabel_3.setBounds(443, 43, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("D 5");
		lblNewLabel_4.setBounds(564, 43, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("D 6");
		lblNewLabel_5.setBounds(80, 274, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("D 7");
		lblNewLabel_6.setBounds(196, 274, 46, 14);
		contentPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("D 8");
		lblNewLabel_7.setBounds(320, 274, 46, 14);
		contentPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("D 9");
		lblNewLabel_8.setBounds(443, 274, 46, 14);
		contentPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("D 10");
		lblNewLabel_9.setBounds(564, 274, 46, 14);
		contentPanel.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nuevo = textField.getText();
				
				
				
			}
		});
		btnNewButton.setBounds(165, 625, 110, 43);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(387, 625, 110, 43);
		contentPanel.add(btnNewButton_1);
		
		
		
	}
}

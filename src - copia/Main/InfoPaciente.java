package Main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class InfoPaciente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Paciente paciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InfoPaciente dialog = new InfoPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InfoPaciente() {
		setBounds(100, 100, 848, 603);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(467, 127, 296, 191);
		contentPanel.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(467, 329, 296, 127);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ODONTOGRAMA");
		btnNewButton.setBounds(548, 62, 149, 40);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("guardar");
		btnNewButton_1.setBounds(496, 500, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("cancelar");
		btnNewButton_2.setBounds(640, 500, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("FOTO");
		lblNewLabel.setBackground(new Color(128, 128, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(85, 73, 124, 132);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(40, 302, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(40, 344, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lbl1 = new JLabel("New label");
		lbl1.setBounds(146, 302, 118, 14);
		contentPanel.add(lbl1);
		
		JLabel lbl2 = new JLabel("New label");
		lbl2.setBounds(146, 344, 118, 14);
		contentPanel.add(lbl2);
		
		JLabel lblNewLabel_5 = new JLabel("Edad");
		lblNewLabel_5.setBounds(40, 385, 46, 14);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lbl3 = new JLabel("New label");
		lbl3.setBounds(146, 385, 46, 14);
		contentPanel.add(lbl3);
		
		
		/*
		 * 
		 * 
		 * SPINNER Y ELEGIR CON QUE PACIENTE ESTAMOS TRATANTO
		 * 
		 * 
		 * 
		 * */
		
		//CAMBIO LA INFO DEL PACIENTE
		
		lbl1.setText(paciente.getNombre());
		lbl2.setText(paciente.getApellidos());
		int a = paciente.getEdad();
		lbl3.setText(Integer.toString(a));
		
		
		
	}
}

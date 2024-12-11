package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Ventana_IMC {

	// aqui estan declarados los campos que utilizamos en la ventana Swing de este
	// proyecto de la calculadora IMC
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	// este metodo crea una instancia de la clase que llamara al constructor y hace
	// que el frame sea visible
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_IMC window = new Ventana_IMC();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Importante : este es el contructor de la clase y llama a un solo metodo que
	// es el que inicia la carga y posicion de los componentes de la ventana
	/**
	 * Create the application.
	 */
	public Ventana_IMC() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//declaramen el tamaño del frame,el que salga al darle a x y el tipo de layout
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 183);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Ventana IMC");
		//declaramos el slider, las funciones de cada cuanto hay un tic o las lineas del mismo estan dentro del windowbuilder de forma grafica 
		JSlider slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int sleepSense = slider.getValue();
				textField_1.setText("" + sleepSense);

			}
		});
		slider.setMajorTickSpacing(10);
		slider.setBounds(95, 22, 371, 58);
		frame.getContentPane().add(slider);

		//las labels que estan en las esquinas de la ventana dando informacion
		JLabel lblNewLabel = new JLabel("Peso");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(36, 33, 49, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Altura");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(36, 109, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(104, 108, 96, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("en cm");
		lblNewLabel_2.setBounds(224, 111, 49, 14);
		frame.getContentPane().add(lblNewLabel_2);

		//el boton que hace el calculo matematico del imc
		JButton btnNewButton = new JButton("Calcular IMC");
		btnNewButton.addActionListener(new ActionListener() {
			boolean val = false;

			public void actionPerformed(ActionEvent e) {
				// y aqui extraemos el dato introducido por el usuario
				String altura = textField.getText();
				// esto nos da la validacion de que el dato puede ser usado correctamente
				if (altura.contains(".") || altura.matches("^[0-9]+$")) {
					val = true;
				} else {
					JOptionPane.showMessageDialog(frame, "introduzca en numero dividido por '.' ");
				}
				//si el dato es valido entramos por aqui para hacer el calculo
				if (val) {
					//parceamos el string numerico para pasarlo a float
					float altura_num = Float.parseFloat(altura);
					//extraemos el peso del slider
					int peso = slider.getValue();
					float icm = peso / (altura_num * altura_num);
					// el formmatter nos permite mostrar el dato con dos decimales
					DecimalFormat df = new DecimalFormat();
					df.setMaximumFractionDigits(2);
					String formateado = df.format(icm);
					textField_2.setText("" + formateado);
				}
			}
		});
		btnNewButton.setBounds(263, 107, 184, 23);
		frame.getContentPane().add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(476, 32, 68, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(457, 108, 68, 20);
		frame.getContentPane().add(textField_2);

		JLabel lblNewLabel_3 = new JLabel("Kg");
		lblNewLabel_3.setBounds(549, 35, 17, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setBounds(535, 111, 49, 14);
		frame.getContentPane().add(lblNewLabel_4);

	}
}

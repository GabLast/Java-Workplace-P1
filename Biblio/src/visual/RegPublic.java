package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;

import logico.Articulo;
import logico.Biblioteca;
import logico.Libro;
import logico.Publicacion;
import logico.Revista;

import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class RegPublic extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtTitle;
	private JTextField txtAutor;
	int mode;
	private JTextField txtNum;
	private JTextField textField;
	JPanel panel_revista;
	JPanel panel_articulo;
	JPanel panel_libro;
	JRadioButton rdbtnLibro;
	JRadioButton rdbtnArtculo;
	JRadioButton rdbtnRevista;
	JSpinner spnCant;
	JComboBox cbxMateria;
	JComboBox cbxEditorial;

	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegPublic(String title, int mode) {
		setBounds(100, 100, 475, 378);
		this.mode = mode;
		setTitle(title);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 439, 155);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 26, 14, 14);
		panel.add(lblId);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(10, 58, 46, 14);
		panel.add(lblTtulo);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setBounds(10, 90, 46, 14);
		panel.add(lblMateria);
		
		JLabel lblCantidadDeEjemplares = new JLabel("Cantidad de Ejemplares:");
		lblCantidadDeEjemplares.setBounds(231, 90, 139, 14);
		panel.add(lblCantidadDeEjemplares);
		
		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(10, 122, 46, 14);
		panel.add(lblAutor);
		
		txtId = new JTextField();
		txtId.setBounds(61, 23, 160, 21);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(61, 55, 368, 21);
		panel.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(61, 119, 368, 21);
		panel.add(txtAutor);
		txtAutor.setColumns(10);
		
		cbxMateria = new JComboBox();
		cbxMateria.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "F\u00EDsica", "Matem\u00E1tica", "POO", "Java", "C#", "Circuito", "Redes"}));
		cbxMateria.setBounds(61, 87, 160, 21);
		panel.add(cbxMateria);
		
		spnCant = new JSpinner();
		spnCant.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spnCant.setBounds(374, 87, 55, 21);
		panel.add(spnCant);
		
		panel_revista = new JPanel();
		panel_revista.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_revista.setBounds(10, 219, 439, 77);
		contentPanel.add(panel_revista);
		panel_revista.setLayout(null);
		panel_revista.setVisible(false);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(10, 21, 46, 14);
		panel_revista.add(lblAo);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(231, 21, 60, 14);
		panel_revista.add(lblNmero);
		
		txtNum = new JTextField();
		txtNum.setBounds(289, 18, 140, 21);
		panel_revista.add(txtNum);
		txtNum.setColumns(10);
		
		JSpinner spnAnno = new JSpinner();
		Date date = new Date();
		spnAnno.setModel(new SpinnerDateModel(date, null, null, Calendar.YEAR));
		JSpinner.DateEditor de = new JSpinner.DateEditor(spnAnno, "yyyy");
		spnAnno.setEditor(de);
		spnAnno.setBounds(59, 18, 151, 21);
		panel_revista.add(spnAnno);
		
		panel_articulo = new JPanel();
		panel_articulo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_articulo.setBounds(10, 219, 439, 77);
		contentPanel.add(panel_articulo);
		panel_articulo.setLayout(null);
		panel_articulo.setVisible(false);
		
		JLabel lblArbitro = new JLabel("Arbitro:");
		lblArbitro.setBounds(10, 21, 46, 14);
		panel_articulo.add(lblArbitro);
		
		textField = new JTextField();
		textField.setBounds(61, 18, 365, 21);
		panel_articulo.add(textField);
		textField.setColumns(10);
		
		panel_libro = new JPanel();
		panel_libro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_libro.setBounds(10, 219, 439, 77);
		contentPanel.add(panel_libro);
		panel_libro.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editorial:");
		lblNewLabel.setBounds(10, 21, 55, 14);
		panel_libro.add(lblNewLabel);
		
		cbxEditorial = new JComboBox();
		cbxEditorial.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Ambar", "Santillana", "Susaeta", "Coral", "McGraw Hill"}));
		cbxEditorial.setBounds(65, 18, 200, 21);
		panel_libro.add(cbxEditorial);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Tipo de Publicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 168, 439, 48);
		contentPanel.add(panel_4);
		panel_4.setLayout(null);
		
		rdbtnLibro = new JRadioButton("Libro");
		rdbtnLibro.setBounds(55, 18, 88, 23);
		panel_4.add(rdbtnLibro);
		rdbtnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLibro.setSelected(true);
				rdbtnRevista.setSelected(false);
				rdbtnArtculo.setSelected(false);
				panel_revista.setVisible(false);
				panel_articulo.setVisible(false);
				panel_libro.setVisible(true);
				txtAutor.setVisible(true);
			}
		});
		rdbtnLibro.setSelected(true);
		
		rdbtnArtculo = new JRadioButton("Art\u00EDculo");
		rdbtnArtculo.setBounds(190, 18, 88, 23);
		panel_4.add(rdbtnArtculo);
		
		rdbtnRevista = new JRadioButton("Revista");
		rdbtnRevista.setBounds(333, 18, 76, 23);
		panel_4.add(rdbtnRevista);
		rdbtnRevista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLibro.setSelected(false);
				rdbtnArtculo.setSelected(false);
				rdbtnRevista.setSelected(true);
				panel_revista.setVisible(true);
				panel_articulo.setVisible(false);
				panel_libro.setVisible(false);
				txtAutor.setVisible(false);
			}
		});
		rdbtnArtculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLibro.setSelected(false);
				rdbtnRevista.setSelected(false);
				rdbtnArtculo.setSelected(true);
				panel_revista.setVisible(false);
				panel_articulo.setVisible(true);
				panel_libro.setVisible(false);
				txtAutor.setVisible(false);
			}
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegister = new JButton("Registrar");
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Publicacion aux = null;
						String id = txtId.getText();
						String titulo = txtTitle.getText();
						String autor = txtAutor.getText();
						int cant = new Integer(spnCant.getValue().toString());
						String materia = cbxMateria.getSelectedItem().toString();
						
						if(rdbtnRevista.isSelected()){
							int anno = new Integer(spnCant.getValue().toString());
							int numero = new Integer(txtNum.getText()); 
							aux = new Revista(id, titulo, autor, cant, true, materia, anno, numero);
						    
						}
						if(rdbtnArtculo.isSelected()){
							String arbitro = textField.getText();
							aux = new Articulo(id, titulo, autor, cant, true, materia, arbitro);
							
						}
						if(rdbtnLibro.isSelected()){
							String editorial = cbxEditorial.getSelectedItem().toString();
							aux = new Libro(id, titulo, autor, cant, true, materia, editorial);
							
						}
						Biblioteca.getInstance().insertPublicacion(aux);
						//fed.insertPublicacion(aux);
						//System.out.println("La cantidad de libros es: "+fed.getMisPublicaciones().size());
					}
				});
				btnRegister.setActionCommand("OK");
				buttonPane.add(btnRegister);
				getRootPane().setDefaultButton(btnRegister);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
}

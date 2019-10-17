package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class RegPublicacion extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPublicacion dialog = new RegPublicacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPublicacion() {
		setTitle("Publicaciones");
		setBounds(100, 100, 679, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 637, 119);
		contentPanel.add(panel);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Información", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(12, 13, 56, 16);
		panel.add(lblId);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(12, 42, 56, 16);
		panel.add(lblTtulo);
		
		JLabel lblMateria = new JLabel("Materia:");
		lblMateria.setBounds(12, 71, 56, 16);
		panel.add(lblMateria);
		
		JLabel lblCantidadDeEjemplares = new JLabel("Cantidad de Ejemplares:");
		lblCantidadDeEjemplares.setBounds(405, 71, 147, 16);
		panel.add(lblCantidadDeEjemplares);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(12, 145, 637, 63);
		contentPanel.add(panel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(null, "Tipo de Publicación", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			JRadioButton rdbtnLibro = new JRadioButton("Libro");
			rdbtnLibro.setBounds(62, 29, 127, 25);
			panel_1.add(rdbtnLibro);
			
			JRadioButton rdbtnArtculo = new JRadioButton("Art\u00EDculo");
			rdbtnArtculo.setBounds(211, 29, 127, 25);
			panel_1.add(rdbtnArtculo);
			
			JRadioButton rdbtnRevista = new JRadioButton("Revista");
			rdbtnRevista.setBounds(386, 29, 127, 25);
			panel_1.add(rdbtnRevista);
			
			JPanel panel_Revista = new JPanel();
			panel_Revista.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_Revista.setBounds(12, 221, 637, 151);
			contentPanel.add(panel_Revista);
			panel_Revista.setLayout(null);
			
			JPanel panel_Libro = new JPanel();
			panel_Libro.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_Libro.setBounds(12, 221, 637, 151);
			contentPanel.add(panel_Libro);
			panel_Libro.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("A\u00F1o");
			lblNewLabel.setBounds(10, 22, 60, 20);
			panel_Libro.add(lblNewLabel);
			
			
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

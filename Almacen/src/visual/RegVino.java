package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Almacen;
import logico.Vino;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;

public class RegVino extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private Almacen alma = null;
	private Vino miVino = null;
	private JSpinner spnCosecha;
	private JComboBox cbxTipo;
	private JComboBox cbxSumi;
	private JSpinner spnReal;
	private JSpinner spnMini;
	private JSpinner spnMax;

	/**
	 * Launch the application.
	 */
		/**
	 * Create the dialog.
	 */
	public RegVino(Almacen mialma, Vino aux) {
		this.alma = mialma;
		this.miVino = aux;
		if(miVino == null){
		setTitle("Registrar Vino");
		}else{
			setTitle("Modificar Vino");	
		}
		setBounds(100, 100, 391, 375);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n del Vino:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(10, 24, 69, 14);
			panel.add(lblCdigo);
			
			
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			if(miVino==null){
				txtCodigo.setText("V-"+(alma.getGeneradorCodigoVino()));
			}
			txtCodigo.setBounds(10, 43, 86, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 79, 86, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(10, 104, 197, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCosecha = new JLabel("Cosecha:");
			lblCosecha.setBounds(235, 79, 69, 14);
			panel.add(lblCosecha);
			
			spnCosecha = new JSpinner();
			spnCosecha.setModel(new SpinnerNumberModel(new Integer(1650), null, null, new Integer(1)));
			spnCosecha.setBounds(235, 104, 113, 20);
			panel.add(spnCosecha);
			
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(235, 137, 69, 14);
			panel.add(lblTipo);
			
			cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Blanco", "Tinto", "Rosado"}));
			cbxTipo.setBounds(235, 162, 113, 20);
			panel.add(cbxTipo);
			
			JLabel lblSuministrador = new JLabel("Suministrador:");
			lblSuministrador.setBounds(10, 137, 155, 14);
			panel.add(lblSuministrador);
			
			cbxSumi = new JComboBox();
			cbxSumi.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>"}));
			cbxSumi.setBounds(10, 162, 197, 20);
			panel.add(cbxSumi);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cantidades:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 193, 338, 89);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblReal = new JLabel("Real:");
			lblReal.setBounds(50, 36, 46, 14);
			panel_1.add(lblReal);
			
			JLabel lblMnima = new JLabel("M\u00EDnima:");
			lblMnima.setBounds(146, 36, 46, 14);
			panel_1.add(lblMnima);
			
			JLabel lblMxima = new JLabel("M\u00E1xima:");
			lblMxima.setBounds(242, 36, 67, 14);
			panel_1.add(lblMxima);
			
			spnReal = new JSpinner();
			spnReal.setBounds(27, 55, 76, 20);
			panel_1.add(spnReal);
			
			spnMini = new JSpinner();
			spnMini.setBounds(130, 55, 76, 20);
			panel_1.add(spnMini);
			
			spnMax = new JSpinner();
			spnMax.setBounds(233, 55, 76, 20);
			panel_1.add(spnMax);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadSumis();
	}

	private void loadSumis() {
		cbxSumi.removeAllItems();
		for (int i = 0; i < alma.getCantSumi(); i++) {
		  cbxSumi.addItem(new String(alma.getMisSumis()[i].getId()+":"+alma.getMisSumis()[i].getNombre()));
		}
		cbxSumi.insertItemAt(new String("<Seleccione>"), 0);
		cbxSumi.setSelectedIndex(0);
		
	}
}

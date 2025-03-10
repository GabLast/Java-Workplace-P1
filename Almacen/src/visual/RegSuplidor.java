package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Almacen;
import logico.Suministrador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class RegSuplidor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JComboBox cbxpais;
	private JSpinner spntiempo;
	private Almacen mialma = null;
	private Suministrador miSumi = null;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RegSuplidor(Almacen alma, Suministrador sumi) {
		this.mialma = alma;
		this.miSumi = sumi;
		setResizable(false);
		if(miSumi==null)
		{
		  setTitle("Registrar Suplidor");
		}else{
		  setTitle("Modificar: "+miSumi.getNombre());	
		}

		setBounds(100, 100, 386, 228);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Registro de informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(6, 27, 55, 14);
			panel.add(lblCdigo);

			txtcodigo = new JTextField();
			txtcodigo.setEditable(false);
			txtcodigo.setBounds(62, 24, 114, 20);
			panel.add(txtcodigo);
			txtcodigo.setColumns(10);
			txtcodigo.setText("s-"+mialma.getGeneradorCodigoSupli());

			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(6, 72, 55, 14);
			panel.add(lblNombre);

			txtnombre = new JTextField();
			txtnombre.setBounds(63, 69, 303, 20);
			panel.add(txtnombre);
			txtnombre.setColumns(10);

			JLabel lblPas = new JLabel("Pa\u00EDs:");
			lblPas.setBounds(6, 121, 32, 14);
			panel.add(lblPas);

			cbxpais = new JComboBox();
			cbxpais.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Chile", "Espa\u00F1a", "Francia", "Portugal"}));
			cbxpais.setBounds(62, 118, 114, 20);
			panel.add(cbxpais);

			JLabel lblTiempo = new JLabel("Tiempo:");
			lblTiempo.setBounds(196, 121, 46, 14);
			panel.add(lblTiempo);

			spntiempo = new JSpinner();
			spntiempo.setModel(new SpinnerNumberModel(1, 1, 90, 1));
			spntiempo.setBounds(252, 118, 114, 20);
			panel.add(spntiempo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnaceptar = new JButton("");
				if(miSumi==null){
					btnaceptar.setText("Registrar");
				}else{
					btnaceptar.setText("Modificar");
				}
				btnaceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(miSumi==null){
						Suministrador aux = new Suministrador(txtcodigo.getText(), txtnombre.getText(), cbxpais.getSelectedItem().toString(), Integer.valueOf(spntiempo.getValue().toString()));
						mialma.insertarSuministrador(aux);
						JOptionPane.showMessageDialog(null, "Operación satisfactoria", "Notificación", JOptionPane.INFORMATION_MESSAGE);
						clean();
						}else{
							miSumi.setNombre(txtnombre.getText());
							miSumi.setPais(cbxpais.getSelectedItem().toString());
							miSumi.setTiempoEntrega(Integer.valueOf(spntiempo.getValue().toString()));
							mialma.modificarSuministrador(miSumi);
							listSuplidores.loadSuplidores();
							dispose();
						}
					}


				});
				btnaceptar.setActionCommand("OK");
				buttonPane.add(btnaceptar);
				getRootPane().setDefaultButton(btnaceptar);
			}
			{
				JButton btncancelar = new JButton("Cancelar");
				btncancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btncancelar.setActionCommand("Cancel");
				buttonPane.add(btncancelar);
			}
			
			loadSuministrador();
		}
	}

	private void loadSuministrador() {
		if(miSumi!=null){
			txtcodigo.setText(miSumi.getId());
			txtnombre.setText(miSumi.getNombre());
			spntiempo.setValue(Integer.valueOf(miSumi.getTiempoEntrega()));
			cbxpais.setSelectedItem(miSumi.getPais().toString());
		}
		
	}

	private void clean() {
		cbxpais.setSelectedIndex(0);
		spntiempo.setValue(Integer.valueOf("1"));
		txtnombre.setText("");
		txtcodigo.setText("s-"+mialma.getGeneradorCodigoSupli());

	}
}

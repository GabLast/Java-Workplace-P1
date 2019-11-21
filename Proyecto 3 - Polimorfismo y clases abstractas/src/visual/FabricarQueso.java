package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.naming.ldap.Rdn;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.CHueco;
import logico.Cilindro;
import logico.Complejo;
import logico.Esfera;
import logico.Queso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;

public class FabricarQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	
	JButton btnFabricar;
	
	JRadioButton rdBtnEsferico;
	JRadioButton rdBtnCilindrico;
	JRadioButton rdBtnHueco;
	
	JSpinner spnLongitudHueco;
	JSpinner spnRadioExtHueco;
	JSpinner spnRadioIntHueco;
	
	private JPanel panel_CHueco;
	private JPanel panel_Esferico;
	private JLabel lblRadio_1;
	private JSpinner spnRadio;
	private JPanel panel_Cilindro;
	private JLabel label;
	private JSpinner spnLongitudCilindro;
	private JLabel label_1;
	private JSpinner spnRadioCilindro;
	private JLabel lblNewLabel;
	private JLabel lblPrecioUnitario;
	
	private JTextField txtPrecioBase;
	private JTextField txtPrecioUnit;
	private JPanel panel_2;
	
	//panel_CHueco.setBounds(17, 104, 684, 124);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			FabricarQueso dialog = new FabricarQueso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FabricarQueso() {
		getContentPane().setBackground(new Color(250, 250, 210));
		setBackground(new Color(238, 232, 170));
		setTitle("Fabricando Queso");
		setResizable(false);
		setBounds(100, 100, 734, 418);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			panel_CHueco = new JPanel();
			panel_CHueco.setBounds(17, 104, 684, 124);
			panel.add(panel_CHueco);
			panel_CHueco.setLayout(null);
			panel_CHueco.setBorder(new TitledBorder(null, "Dimensiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			
			panel_CHueco.setVisible(false);
			JLabel lblRadio = new JLabel("Longitud:");
			lblRadio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblRadio.setBounds(25, 53, 87, 23);
			panel_CHueco.add(lblRadio);
			
			JLabel lblLongitud = new JLabel("Radio exterior:");
			lblLongitud.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblLongitud.setBounds(216, 53, 131, 23);
			panel_CHueco.add(lblLongitud);
			
			JLabel lblRadioInterior = new JLabel("Radio interior:");
			lblRadioInterior.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblRadioInterior.setBounds(451, 53, 125, 23);
			panel_CHueco.add(lblRadioInterior);
			
			spnLongitudHueco = new JSpinner();
			spnLongitudHueco.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnLongitudHueco.setBounds(115, 50, 54, 30);
			panel_CHueco.add(spnLongitudHueco);
			
			spnRadioExtHueco = new JSpinner();
			spnRadioExtHueco.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnRadioExtHueco.setBounds(350, 50, 54, 30);
			panel_CHueco.add(spnRadioExtHueco);
			
			spnRadioIntHueco = new JSpinner();
			spnRadioIntHueco.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnRadioIntHueco.setBounds(578, 50, 54, 30);
			panel_CHueco.add(spnRadioIntHueco);
			
			panel_Esferico  = new JPanel();
			panel_Esferico.setLayout(null);
			panel_Esferico.setBorder(new TitledBorder(null, "Dimensiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_Esferico.setBounds(17, 104, 684, 124);
			panel.add(panel_Esferico);
			panel_Esferico.setVisible(true);

			
			lblRadio_1 = new JLabel("Radio:");
			lblRadio_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblRadio_1.setBounds(25, 53, 87, 23);
			panel_Esferico.add(lblRadio_1);
			
			spnRadio = new JSpinner();
			spnRadio.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnRadio.setBounds(90, 50, 54, 30);
			panel_Esferico.add(spnRadio);
			
			panel_Cilindro = new JPanel();
			panel_Cilindro.setLayout(null);
			panel_Cilindro.setBorder(new TitledBorder(null, "Dimensiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_Cilindro.setBounds(17, 104, 684, 124);
			panel.add(panel_Cilindro);
			panel_Cilindro.setVisible(false);
			
			label = new JLabel("Longitud:");
			label.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			label.setBounds(25, 53, 87, 23);
			panel_Cilindro.add(label);

			spnLongitudCilindro = new JSpinner();
			spnLongitudCilindro.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnLongitudCilindro.setBounds(109, 50, 54, 30);
			panel_Cilindro.add(spnLongitudCilindro);

			label_1 = new JLabel("Radio:");
			label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			label_1.setBounds(216, 53, 131, 23);
			panel_Cilindro.add(label_1);

			spnRadioCilindro = new JSpinner();
			spnRadioCilindro.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnRadioCilindro.setBounds(280, 50, 54, 30);
			panel_Cilindro.add(spnRadioCilindro);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Forma del Queso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(17, 13, 684, 78);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			rdBtnEsferico = new JRadioButton("Esf\u00E9rico");
			rdBtnEsferico.setBounds(103, 23, 75, 25);
			panel_1.add(rdBtnEsferico);
			rdBtnEsferico.setSelected(true);
			rdBtnEsferico.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			
			rdBtnCilindrico = new JRadioButton("Cil\u00EDndrico");
			rdBtnCilindrico.setBounds(281, 23, 83, 25);
			panel_1.add(rdBtnCilindrico);
			rdBtnCilindrico.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			
			rdBtnHueco = new JRadioButton("Cilindro Hueco");
			rdBtnHueco.setBounds(467, 23, 113, 25);
			panel_1.add(rdBtnHueco);
			rdBtnHueco.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Precios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(17, 241, 684, 67);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			lblNewLabel = new JLabel("Precio Base:");
			lblNewLabel.setBounds(12, 25, 69, 17);
			panel_2.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			
			txtPrecioBase = new JTextField();
			txtPrecioBase.setBounds(93, 19, 166, 29);
			panel_2.add(txtPrecioBase);
			txtPrecioBase.setColumns(10);
			
			lblPrecioUnitario = new JLabel("Precio Unitario:");
			lblPrecioUnitario.setBounds(351, 22, 105, 23);
			panel_2.add(lblPrecioUnitario);
			lblPrecioUnitario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			
			txtPrecioUnit = new JTextField();
			txtPrecioUnit.setBounds(467, 19, 166, 29);
			panel_2.add(txtPrecioUnit);
			txtPrecioUnit.setColumns(10);
			rdBtnHueco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdBtnEsferico.setSelected(false);
					rdBtnCilindrico.setSelected(false);
					rdBtnHueco.setSelected(true);
					
					panel_Esferico.setVisible(false);
					panel_Cilindro.setVisible(false);
					panel_CHueco.setVisible(true);
				}
			});
			rdBtnCilindrico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdBtnEsferico.setSelected(false);
					rdBtnCilindrico.setSelected(true);
					rdBtnHueco.setSelected(false);
					
					panel_Esferico.setVisible(false);
					panel_Cilindro.setVisible(true);
					panel_CHueco.setVisible(false);
				}
			});
			rdBtnEsferico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdBtnEsferico.setSelected(true);
					rdBtnCilindrico.setSelected(false);
					rdBtnHueco.setSelected(false);
					
					panel_Esferico.setVisible(true);
					panel_Cilindro.setVisible(false);
					panel_CHueco.setVisible(false);
				}
			});
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFabricar = new JButton("Fabricar");
				btnFabricar.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				btnFabricar.setBackground(new Color(204, 204, 255));
				btnFabricar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Queso queso = null;
						
						if(rdBtnEsferico.isSelected())
						{
							if((int)spnRadio.getValue() > 0
									&& txtPrecioBase.getText().length() > 0 && txtPrecioUnit.getText().length() > 0)
							{
								queso = new Esfera("ESF" + Complejo.getGenCodeQueso(), Float.valueOf(txtPrecioBase.getText()),
										Float.valueOf(txtPrecioUnit.getText()), true, (int)spnRadio.getValue());
								clean();
							}
						}
						else if(rdBtnCilindrico.isSelected())
						{
							if((int)spnRadioCilindro.getValue() > 0 && (int)spnLongitudCilindro.getValue() > 0
									&& txtPrecioBase.getText().length() > 0 && txtPrecioUnit.getText().length() > 0)
							{
								queso = new Cilindro("CIL" + Complejo.getGenCodeQueso(), Float.valueOf(txtPrecioBase.getText()),
										Float.valueOf(txtPrecioUnit.getText()), true, (int)spnRadioCilindro.getValue(), 
										(int)spnLongitudCilindro.getValue());
								clean();
							}
						}
						else if(rdBtnHueco.isSelected())
						{
							if((int)spnRadioExtHueco.getValue() > (int)spnRadioIntHueco.getValue() 
									&& txtPrecioBase.getText().length() > 0 && txtPrecioUnit.getText().length() > 0)
							{
								queso = new CHueco("CHUE" + Complejo.getGenCodeQueso(), Float.valueOf(txtPrecioBase.getText()),
										Float.valueOf(txtPrecioUnit.getText()), true, (int)spnRadioExtHueco.getValue(),
										(int)spnRadioIntHueco.getValue(), (int)spnLongitudHueco.getValue());
								clean();
							}
							
						}
						
						if(queso != null)
						{
							Complejo.getInstance().agregarQueso(queso);
							JOptionPane.showMessageDialog(null, "Queso fabricado satisfactoriamente", "Notificación", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							if(rdBtnHueco.isSelected() && (int)spnRadioExtHueco.getValue() <= (int)spnRadioIntHueco.getValue())
							{
								JOptionPane.showMessageDialog(null, "El radio exterior debe ser mayor que el radio interior", "Notificación", JOptionPane.INFORMATION_MESSAGE);
							}
							else if((rdBtnCilindrico.isSelected() || rdBtnEsferico.isSelected()) && (int)spnRadio.getValue() < 0 || ((int)spnRadioCilindro.getValue() < 0 && (int)spnLongitudCilindro.getValue() < 0))
							{
								JOptionPane.showMessageDialog(null, "No se permiten números menores que cero", "Notificación", JOptionPane.INFORMATION_MESSAGE);
							}else
								JOptionPane.showMessageDialog(null, "Operación Errónea", "Notificación", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
				btnFabricar.setActionCommand("OK");
				buttonPane.add(btnFabricar);
				getRootPane().setDefaultButton(btnFabricar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				btnCancelar.setBackground(new Color(204, 204, 255));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void clean() {

		spnRadio.setValue(0);
		spnLongitudCilindro.setValue(0);
		spnRadioCilindro.setValue(0);
		spnLongitudHueco.setValue(0);
		spnRadioExtHueco.setValue(0);
		spnRadioIntHueco.setValue(0);
		txtPrecioBase.setText("");
		txtPrecioUnit.setText("");
	}
}

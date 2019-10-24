package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Complejo;
import logico.Factura;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ReporteFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCode;

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
			ReporteFactura dialog = new ReporteFactura();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReporteFactura() {
		setTitle("Reporte de una factura");
		setBounds(100, 100, 392, 226);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			panel.setBorder(new TitledBorder(null, "Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			{
				JLabel lblCdigo = new JLabel("C\u00F3digo:");
				lblCdigo.setBounds(17, 52, 72, 23);
				panel.add(lblCdigo);
			}
			{
				txtCode = new JTextField();
				txtCode.setBounds(91, 49, 225, 29);
				panel.add(txtCode);
				txtCode.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Buscar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Factura fact = Complejo.getInstance().buscarFacturaByCode(txtCode.getText());
						JOptionPane.showMessageDialog(null, "Precio del queso esférico de mayor volumen: RD$" + fact.precioQuesoEsfericoMayor(), "Reporte", JOptionPane.INFORMATION_MESSAGE);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnCancel = new JButton("Salir");
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

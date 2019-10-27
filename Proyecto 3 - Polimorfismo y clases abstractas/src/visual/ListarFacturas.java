package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.Complejo;
import logico.Factura;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class ListarFacturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private static DefaultTableModel model;
	private static Object[] row;
	private static JTable table;
	private String code = "";
	JButton btnReporteDelQueso;
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
			ListarFacturas dialog = new ListarFacturas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarFacturas() {
		setTitle("Facturas");
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		dim.width *= .50;
		dim.height *= .50;
		super.setSize(dim.width, dim.height);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane);
				{
					model = new DefaultTableModel() {
						@Override
					    public boolean isCellEditable(int row, int column) {
					       //all cells false
					       return false;
					    }
					};
					
					
					String[] header = {"Código", "Cédula Cliente", "Cantidad de Quesos Comprados", "Total"};
					model.setColumnIdentifiers(header);
					
					table = new JTable();
					
					loadFacturas();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>-1){
								int index = table.getSelectedRow();
								btnReporteDelQueso.setEnabled(true);
								code = String.valueOf(table.getValueAt(index, 0));
								
							}
						}
					});
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					btnReporteDelQueso = new JButton("Reporte del queso esf\u00E9rico de mayor volumen");
					btnReporteDelQueso.setFont(new Font("Times New Roman", Font.PLAIN, 19));
					btnReporteDelQueso.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(!code.equals(""))
							{
								Factura fact = Complejo.getInstance().buscarFacturaByCode(code);
								int option = JOptionPane.showConfirmDialog(null, "Conocer el precio del queso esférico de mayor volumen de la factura: " 
										   + fact.getCodigo(),"Información",JOptionPane.WARNING_MESSAGE);
								
								if(option == JOptionPane.OK_OPTION && fact != null)
								{
									JOptionPane.showMessageDialog(null, "Precio del queso esférico de mayor volumen: RD$" + String.format("%.2f", fact.precioQuesoEsfericoMayor()), "Reporte", JOptionPane.INFORMATION_MESSAGE);
								}
							}
							
						}
					});
					btnReporteDelQueso.setEnabled(false);
					buttonPane.add(btnReporteDelQueso);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public static void loadFacturas() 
	{
		model.setRowCount(0);
		Complejo unComp = Complejo.getInstance();
		//{"Código", "Cédula Cliente", "Cantidad de Quesos", "valor total"};
		row = new Object[model.getColumnCount()];
		for (int i = 0; i < unComp.getFacturas().size(); i++) 
		{
			row[0] = unComp.getFacturas().get(i).getCodigo();
			row[1] = unComp.getFacturas().get(i).getMiCliente().getCedula();
			row[2] = unComp.getFacturas().get(i).getMisQuesos().size();
			row[3] = "RD$" + String.format("%.2f", unComp.getFacturas().get(i).valorTotal());
			model.addRow(row);
		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);

	}
}

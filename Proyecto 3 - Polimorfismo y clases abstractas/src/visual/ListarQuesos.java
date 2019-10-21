package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import logico.CHueco;
import logico.Cilindro;
import logico.Complejo;
import logico.Esfera;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class ListarQuesos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private static DefaultTableModel model;
	private static Object[] row;
	private JTable table;
	private String idQueso = "";

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
			ListarQuesos dialog = new ListarQuesos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarQuesos() {
		setAlwaysOnTop(false);
		setTitle("Lista de quesos");
		setBounds(100, 100, 567, 397);
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
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel() {
						@Override
					    public boolean isCellEditable(int row, int column) {
					       //all cells false
					       return false;
					    }
					};
					
					
					String[] header = {"Código", "Tipo", "Volumen", "Precio Base", "Precio Unitario", "Precio Total", "Estado de Venta"};
					model.setColumnIdentifiers(header);
					
					table = new JTable();
					
					loadQuesos();
					
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(table.getSelectedRow()>-1){
								int index = table.getSelectedRow();
								idQueso = String.valueOf(table.getValueAt(index, 0));
								
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					JButton btnReporte = new JButton("Reporte de quesos");
					btnReporte.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Complejo.getInstance().reporteTipoQueso();
							JOptionPane.showMessageDialog(null, "Esférico: " + Complejo.getInstance().getContEsf()+ "\n"
									+ "Cilíndrico: " + Complejo.getInstance().getContCil() + "\n"
									+ "Cilíndrico Hueco: " + Complejo.getInstance().getContHue()
									, "Reporte de Quesos", JOptionPane.INFORMATION_MESSAGE);
							Complejo.getInstance().resetReporte();
						}
					});
					btnReporte.setActionCommand("Cancel");
					buttonPane.add(btnReporte);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public static void loadQuesos() 
	{
		model.setRowCount(0);
		Complejo.getInstance();
		//{"Código", "Tipo", "Volumen", "Precio Base", "Precio Unitario", "Total", "Estado de Venta"};
		row = new Object[model.getColumnCount()];
		for (int i = 0; i < Complejo.getInstance().getQuesos().size(); i++) 
		{
			row[0] = Complejo.getInstance().getQuesos().get(i).getId();
			
			if(Complejo.getInstance().getQuesos().get(i) instanceof Esfera)
			{
				row[1] = "Esférico";
			}
			else if(Complejo.getInstance().getQuesos().get(i) instanceof Cilindro)
			{
				row[1] = "Cilíndrico";
			}
			else if(Complejo.getInstance().getQuesos().get(i) instanceof CHueco)
			{
				row[1] = "Cilíndrico Hueco";
			}
			
			row[2] = String.format("%.2f", Complejo.getInstance().getQuesos().get(i).volumen());
			row[3] = "$"+Complejo.getInstance().getQuesos().get(i).getPrecioBase();
			row[4] = "$"+Complejo.getInstance().getQuesos().get(i).getPrecioUnitario();
			row[5] = "$"+Complejo.getInstance().getQuesos().get(i).precioTotal();
			
			if(Complejo.getInstance().getQuesos().get(i).isEstadoDeVenta())
			{
				row[6] = "Disponible";
			}
			else
				row[6] = "Vendido"; 
			
			model.addRow(row);
		}
	}
}

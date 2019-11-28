package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logico.CHueco;
import logico.Cilindro;
import logico.Complejo;
import logico.Esfera;
import logico.Queso;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ListadoQuesos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] row;
	private static DefaultTableModel model;
	JScrollPane scrollPane;
	//private Dimension dim;

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
			ListadoQuesos dialog = new ListadoQuesos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListadoQuesos() {
		setBackground(new Color(250, 250, 210));
		setTitle("Lista de quesos");
		setBounds(100, 100, 1207, 759);
//		dim = super.getToolkit().getScreenSize();
//		dim.width *= .50;
//		dim.height *= .50;
//		super.setSize(dim.width, dim.height);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setBorder(new TitledBorder(null, "Listado de Quesos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			
			JLabel lblTipoDeQueso = new JLabel("Tipo de Queso:");
			lblTipoDeQueso.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblTipoDeQueso.setBounds(27, 32, 137, 23);
			panel.add(lblTipoDeQueso);
			
			JComboBox cbxTipo = new JComboBox();
			cbxTipo.setFont(new Font("Times New Roman", Font.PLAIN, 19));
			cbxTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int selection = cbxTipo.getSelectedIndex();
					loadQuesos(selection);
				}
			});
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Esf\u00E9ricos", "Cil\u00EDndricos", "Cil\u00EDndrico Huecos"}));
			cbxTipo.setBounds(131, 28, 222, 29);
			panel.add(cbxTipo);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(17, 61, 1139, 564);
			
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			scrollPane = new JScrollPane();
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			model = new DefaultTableModel() {
				@Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
			};
			String[] header = {"Código", "Tipo", "Volumen", "Precio Base", "Precio Unitario", "Precio Total", "Estado de Venta"};
			model.setColumnIdentifiers(header);
			loadQuesos(0);
			scrollPane.setViewportView(table);
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public static void loadQuesos(int tipo) 
	{
		model.setRowCount(0);
		Complejo.getInstance();
		//{"Código", "Tipo", "Volumen", "Precio Base", "Precio Unitario", "Total", "Estado de Venta"};
		row = new Object[model.getColumnCount()];
		switch(tipo)
		{
			case 0: //TODOS
				for (Queso cheese : Complejo.getInstance().getQuesos()) 
				{
					row[0] = cheese.getId();
					
					if(cheese instanceof Esfera)
					{
						row[1] = "Esférico";
					}
					else if(cheese instanceof Cilindro && !(cheese instanceof CHueco))
					{
						row[1] = "Cilíndrico";
					}
					else if(cheese instanceof CHueco)
					{
						row[1] = "Cilíndrico Hueco";
					}
					
					row[2] = String.format("%.2f", cheese.volumen());
					row[3] = "RD$"+cheese.getPrecioBase();
					row[4] = "RD$"+cheese.getPrecioUnitario();
					row[5] = "RD$"+String.format("%.2f", cheese.precioTotal());
					
					if(cheese.isEstadoDeVenta())
					{
						row[6] = "Disponible";
					}
					else
						row[6] = "Vendido"; 
					
					model.addRow(row);
				}
				break;
				
			case 1: //Esfera
				for (Queso cheese : Complejo.getInstance().getQuesos()) 
				{
					if(cheese instanceof Esfera)
					{
						row[0] = cheese.getId();
						row[1] = "Esférico";
						row[2] = String.format("%.2f", cheese.volumen());
						row[3] = "RD$"+cheese.getPrecioBase();
						row[4] = "RD$"+cheese.getPrecioUnitario();
						row[5] = "RD$"+String.format("%.2f", cheese.precioTotal());
						
						if(cheese.isEstadoDeVenta())
						{
							row[6] = "Disponible";
						}
						else
							row[6] = "Vendido"; 
						model.addRow(row);
					}

				}
				break;
				
			case 2:
				for (Queso cheese : Complejo.getInstance().getQuesos()) 
				{
					if(cheese instanceof Cilindro && !(cheese instanceof CHueco))
					{
						row[0] = cheese.getId();
						row[1] = "Cilíndrico";
						row[2] = String.format("%.2f", cheese.volumen());
						row[3] = "RD$"+cheese.getPrecioBase();
						row[4] = "RD$"+cheese.getPrecioUnitario();
						row[5] = "RD$"+String.format("%.2f", cheese.precioTotal());
						
						if(cheese.isEstadoDeVenta())
						{
							row[6] = "Disponible";
						}
						else
							row[6] = "Vendido"; 
						model.addRow(row);
					}
				}
				break;
			case 3:
				for (Queso cheese : Complejo.getInstance().getQuesos()) 
				{
					if(cheese instanceof CHueco)
					{
						row[0] = cheese.getId();
						row[1] = "Cilíndrico Hueco";
						row[2] = String.format("%.2f", cheese.volumen());
						row[3] = "RD$"+cheese.getPrecioBase();
						row[4] = "RD$"+cheese.getPrecioUnitario();
						row[5] = "RD$"+String.format("%.2f", cheese.precioTotal());
						
						if(cheese.isEstadoDeVenta())
						{
							row[6] = "Disponible";
						}
						else
							row[6] = "Vendido"; 
						model.addRow(row);
					}
				}
				break;
				
			default:
				break;
		}
		//{"Código", "Tipo", "Volumen", "Precio Base", "Precio Unitario", "Total", "Estado de Venta"}1139;
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setReorderingAllowed(false);
		
	}
}

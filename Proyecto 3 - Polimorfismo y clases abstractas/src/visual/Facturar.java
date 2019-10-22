package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.CHueco;
import logico.Cilindro;
import logico.Cliente;
import logico.Complejo;
import logico.Esfera;
import logico.Factura;
import logico.Queso;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	
	JButton btnBuscarCliente;
	JButton btnBuscarQuesos;
	JButton btnRight;
	JButton btnLeft;
	JButton btnMultiRight;	
	JButton btnMultiLeft;
	
	JComboBox cbxTipoQueso;
	
	DefaultListModel jListLeftModel;
	DefaultListModel jListRightModel;
	
	JList list_ViewingQuesos;
	JList list_CompraQuesos;
	

	ArrayList<Queso> quesos = new ArrayList<>();
	private Cliente micliente = null;
	private String cedula = "";
	
	private JTextField txtTotal;
	private JTextField txtFactCode;
	
	
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
			Facturar dialog = new Facturar(false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturar(boolean modificarCliente) {
		setTitle("Facturando");
		
		setResizable(false);
		if(modificarCliente)
		{
			setTitle("Modificando Cliente");
		}
		else
		{
			setTitle("Generar Factura");
		}
		setBounds(100, 100, 849, 900);
		setLocationRelativeTo(null);
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(17, 19, 809, 273);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		contentPanel.add(panel);
		
		JLabel lblCdula = new JLabel("C\u00E9dula:");
		lblCdula.setBounds(17, 95, 73, 23);
		panel.add(lblCdula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(17, 154, 88, 23);
		panel.add(lblNombre);
		if(modificarCliente)
			lblNombre.setVisible(true);
		else
			lblNombre.setVisible(false);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(17, 214, 88, 23);
		panel.add(lblDireccin);
		if(modificarCliente)
			lblDireccin.setVisible(true);
		else
			lblDireccin.setVisible(false);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(438, 154, 88, 23);
		panel.add(lblTelfono);
		if(modificarCliente)
			lblTelfono.setVisible(true);
		else
			lblTelfono.setVisible(false);
		
		
		JButton btnRegistrar = new JButton("Registrar");
		if(modificarCliente)
		{
//			btnRegistrar.setText("Modificar");
			btnRegistrar.setVisible(true);
//			txtNombre.setText(miCliente.getNombre());
//			txtDireccion.setText(miCliente.getDireccion());
//			txtTelefono.setText(miCliente.getTelefono());
//			txtCedula.setText(miCliente.getCedula());
		}
		else
		{
			btnRegistrar.setVisible(false);
		}
			
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente miCliente = Complejo.getInstance().buscarClienteByCedula(txtCedula.getText());
				
				if(miCliente == null)
				{
					
					if(txtCedula.getText().length() > 1 && txtNombre.getText().length() > 1 && txtCedula.getText().length() > 1
							&& txtDireccion.getText().length() > 1)
					{
						miCliente = new Cliente(txtNombre.getText(), txtCedula.getText(), txtDireccion.getText(), 
								txtTelefono.getText());
						
						System.out.println(miCliente.getCedula());
						
						cedula = miCliente.getCedula();
						Complejo.getInstance().agregarCliente(miCliente);
						
						btnRegistrar.setVisible(false);
						txtTelefono.setEditable(false);
						txtDireccion.setEditable(false);
						txtNombre.setEditable(false);
						JOptionPane.showMessageDialog(null, "Cliente Registrado", "Notificación", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Operación Errónea", "Notificación", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
//					if(txtCedula.getText().length() > 1 && txtNombre.getText().length() > 1 && txtTelefono.getText().length() > 1
//							&& txtDireccion.getText().length() > 1)
					if(true)
					{
						//System.out.println(miCliente.getCedula());
						//btnRegistrar.setText("Modificar");
						cedula = miCliente.getCedula();
						btnRegistrar.setVisible(false);
						txtNombre.setText(miCliente.getNombre());
						txtDireccion.setText(miCliente.getDireccion());
						txtTelefono.setText(miCliente.getTelefono());
						txtCedula.setText(miCliente.getCedula());
						miCliente.setNombre(txtNombre.getText());
						miCliente.setDireccion(txtDireccion.getText());
						miCliente.setTelefono(txtTelefono.getText());
						miCliente.setCedula(txtCedula.getText());
//						ListarClientes.loadClientes();
//						dispose();
//						JOptionPane.showMessageDialog(null, "Modificación realizada", "Notificación", JOptionPane.INFORMATION_MESSAGE);
					}
//					else
//						JOptionPane.showMessageDialog(null, "Operación Errónea", "Notificación", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnRegistrar.setBounds(661, 223, 131, 31);
		panel.add(btnRegistrar);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(107, 92, 314, 29);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(107, 151, 314, 29);
		panel.add(txtNombre);
		if(modificarCliente)
			txtNombre.setVisible(true);
		else
			txtNombre.setVisible(false);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(107, 211, 314, 29);
		panel.add(txtDireccion);
		if(modificarCliente)
			txtDireccion.setVisible(true);
		else
			txtDireccion.setVisible(false);
		
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(529, 151, 263, 29);
		panel.add(txtTelefono);
		if(modificarCliente)
			txtTelefono.setVisible(true);
		else
			txtTelefono.setVisible(false);
		
		
		btnBuscarCliente = new JButton("Buscar");
		if(modificarCliente)
			btnBuscarCliente.setVisible(false);
		else
			btnBuscarCliente.setVisible(true);
		
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente miCliente = Complejo.getInstance().buscarClienteByCedula(txtCedula.getText());
				
				if(miCliente != null)
				{
					cedula = miCliente.getCedula();
					txtCedula.setText(miCliente.getCedula());
					txtNombre.setText(miCliente.getNombre());
					txtDireccion.setText(miCliente.getDireccion());
					txtTelefono.setText(miCliente.getTelefono());
					lblNombre.setVisible(true);
					lblDireccin.setVisible(true);
					lblTelfono.setVisible(true);
					txtNombre.setVisible(true);
					txtDireccion.setVisible(true);
					txtTelefono.setVisible(true);
					txtNombre.setVisible(true);
					txtDireccion.setVisible(true);
					txtTelefono.setEditable(false);
					txtDireccion.setEditable(false);
					txtNombre.setEditable(false);
					if(modificarCliente)
						btnRegistrar.setVisible(true);
					else
						btnRegistrar.setVisible(false);
				}
				else
				{
					lblNombre.setVisible(true);
					lblDireccin.setVisible(true);
					lblTelfono.setVisible(true);
					txtNombre.setVisible(true);
					txtDireccion.setVisible(true);
					txtTelefono.setVisible(true);
					txtNombre.setText("");
					txtDireccion.setText("");
					txtTelefono.setText("");
					btnRegistrar.setVisible(true);
					txtTelefono.setEditable(true);
					txtDireccion.setEditable(true);
					txtNombre.setEditable(true);
					
				}
			}
		});
		btnBuscarCliente.setBounds(438, 91, 131, 31);
		panel.add(btnBuscarCliente);
		
		JLabel lblCdigoDeFactura = new JLabel("C\u00F3digo de factura:");
		lblCdigoDeFactura.setBounds(17, 36, 156, 23);
		panel.add(lblCdigoDeFactura);
		
		txtFactCode = new JTextField();
		txtFactCode.setBounds(179, 33, 244, 29);
		panel.add(txtFactCode);
		txtFactCode.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtFactCode.setEditable(false);
		txtFactCode.setColumns(10);
		txtFactCode.setText("FACT" + Complejo.getGenCodeFact());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(17, 311, 809, 483);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Quesos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		if(modificarCliente)
		{
			panel_1.setVisible(false);
		}
		else
			panel_1.setVisible(true);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(17, 35, 48, 23);
		panel_1.add(lblTipo);
		
		cbxTipoQueso = new JComboBox();
		cbxTipoQueso.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Esf\u00E9rico", "Cil\u00EDndrico", "Cil\u00EDndrico Hueco"}));
		cbxTipoQueso.setBounds(82, 32, 204, 29);
		panel_1.add(cbxTipoQueso);
		
		btnBuscarQuesos = new JButton("Buscar");
		
		jListRightModel = new DefaultListModel();
		
		btnBuscarQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jListLeftModel = new DefaultListModel();
				
				//Mostrando los quesos en la lista
				
				
				for(Queso cheese : Complejo.getInstance().getQuesos())
				{
					if(cbxTipoQueso.getSelectedIndex() == 0)
					{
						//Todos
						if(cheese.isEstadoDeVenta())
							jListLeftModel.addElement(cheese.getId());
					}
					else if(cbxTipoQueso.getSelectedIndex() == 1)
					{
						//Esferico
						if(cheese instanceof Esfera)
						{
							if(cheese.isEstadoDeVenta())
								jListLeftModel.addElement(cheese.getId());
						}
					}
					else if(cbxTipoQueso.getSelectedIndex() == 2)
					{
						//Cilindrico
						if(cheese instanceof Cilindro && !(cheese instanceof CHueco))
						{
							if(cheese.isEstadoDeVenta())
								jListLeftModel.addElement(cheese.getId());
							
						}
					}
					else if(cbxTipoQueso.getSelectedIndex() == 3)
					{
						//Hueco
						if(cheese instanceof CHueco)
						{
							if(cheese.isEstadoDeVenta())
								jListLeftModel.addElement(cheese.getId());
						}
					}
				}
				list_ViewingQuesos.setModel(jListLeftModel);
			}
		});
		btnBuscarQuesos.setBounds(303, 31, 131, 31);
		panel_1.add(btnBuscarQuesos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 77, 305, 357);
		panel_1.add(scrollPane);
		
		list_ViewingQuesos = new JList();
		scrollPane.setViewportView(list_ViewingQuesos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(487, 77, 305, 357);
		panel_1.add(scrollPane_1);
		
		list_CompraQuesos = new JList();
		scrollPane_1.setViewportView(list_CompraQuesos);
		
		btnRight = new JButton(">");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MOVIENDO DE IZQUIERDA A DERECHA
				String string = (String) list_ViewingQuesos.getSelectedValue();
				
				if(list_ViewingQuesos.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Seleccione algún queso", "", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					//agregar valor a la lista derecha
					int value = list_ViewingQuesos.getSelectedIndex();
					jListRightModel.addElement(string);
					list_CompraQuesos.setModel(jListRightModel);
					
//					System.out.println("Moviendo a la derecha:");
//					System.out.println("1"+list_ViewingQuesos.getSelectedValue());
//					System.out.println("2"+list_ViewingQuesos.getName());
//					System.out.println("3"+list_ViewingQuesos.getSelectedValue().toString());
					
					Queso buscando = Complejo.getInstance().buscarQuesoByID(list_ViewingQuesos.getSelectedValue().toString());
					buscando.setEstadoDeVenta(false);
					quesos.add(buscando);
					
					float total = 0;
					for(Queso cheese : quesos)
					{
						
						total += cheese.precioTotal();
					}
					txtTotal.setText("$" + String.format("%.2f", total));
					
					//removiendo valor de la lista de la izquierda
					if(jListLeftModel.getSize() != 0)
					{
						jListLeftModel.removeElementAt(value);
					}
					
					list_ViewingQuesos.setModel(jListLeftModel);
				}
				 
			}
		});
		btnRight.setBounds(338, 123, 131, 31);
		panel_1.add(btnRight);
		
		btnLeft = new JButton("<");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MOVIENDO DE DERECHA A IZQUIERDA
				String string = (String) list_CompraQuesos.getSelectedValue();
				
				if(list_CompraQuesos.getSelectedIndex() == -1)
				{
					JOptionPane.showMessageDialog(null, "Seleccione algún queso", "Notificación", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					//agregar valor a la lista izquierda
					
					int value = list_CompraQuesos.getSelectedIndex();
					
					jListLeftModel.addElement(string);
					list_ViewingQuesos.setModel(jListLeftModel);
					
//					System.out.println("Moviendo a la izquierda:");
//					System.out.println("1:"+list_CompraQuesos.getSelectedValue());
//					System.out.println("2"+list_CompraQuesos.getName());
//					System.out.println("3:"+list_CompraQuesos.getSelectedValue().toString());
					
					Queso buscando = Complejo.getInstance().buscarQuesoByID(list_CompraQuesos.getSelectedValue().toString());
					buscando.setEstadoDeVenta(true);
					quesos.remove(buscando);
					
					float total = 0;
					for(Queso cheese : quesos)
					{
						
						total += cheese.precioTotal();
					}
					
					txtTotal.setText("$" + String.format("%.2f", total));
					
					//removiendo valor de la lista de la derecha
					if(jListRightModel.getSize() != 0)
					{
						jListRightModel.removeElementAt(value);
					}
					
					list_CompraQuesos.setModel(jListRightModel);
				}
			}
		});
		btnLeft.setBounds(338, 275, 131, 31);
		panel_1.add(btnLeft);
		//multi btns could be here
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(497, 441, 48, 23);
		panel_1.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtTotal.setEditable(false);
		txtTotal.setBounds(562, 438, 166, 29);
		panel_1.add(txtTotal);
		
		txtTotal.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnGenerar = new JButton("Generar");
				btnGenerar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						micliente = Complejo.getInstance().buscarClienteByCedula(cedula);
						
//						System.out.println("Cliente que se agrega:"+micliente.getCedula());
//						
//						for(Queso chese : quesos)
//						{
//							System.out.println("Factura:");
//							System.out.println(chese.getId());
//						}
//						
						if(micliente != null && quesos.size() > 0)
						{
							Factura fact = new Factura(txtFactCode.getText(), micliente, quesos);
							Complejo.getInstance().agregarFactura(fact);
							JOptionPane.showMessageDialog(null, "Factura generada satisfactoriamente", "Notificación", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Operación Errónea", "Notificación", JOptionPane.INFORMATION_MESSAGE);
						}
						
						
					}
				});
				btnGenerar.setActionCommand("OK");
				buttonPane.add(btnGenerar);
				getRootPane().setDefaultButton(btnGenerar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
}

//btnMultiRight = new JButton(">>>");
//btnMultiRight.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		//multiple swaps >>>
//		if(list_ViewingQuesos.getSelectedIndex() == -1)
//		{
//			JOptionPane.showMessageDialog(rootPane, "Seleccione algún queso", "", 1);
//		}
//		else
//		{
//			List lista = list_ViewingQuesos.getSelectedValuesList();
//			int[] selectedIndices = list_ViewingQuesos.getSelectedIndices();
//			Object temp[] = lista.toArray();
//			
//			//Agregando elementos a la lista derecha
//			for(int i = 0; i < lista.size(); i++)
//			{
//				jListRightModel.addElement(temp[i]);
//				
//				
//			}
//			list_CompraQuesos.setModel(jListRightModel);
//			
//			//Removiendo elementos de la lista izquierda
//			if(jListLeftModel.getSize() != 0)
//			{
//				for(int i = 0; i < lista.size(); i++)
//				{
//					jListLeftModel.removeElement(temp[i]);
//				}
//			}
//			
//			list_ViewingQuesos.setModel(jListLeftModel);
//		}
//	}
//});
//btnMultiRight.setBounds(338, 173, 131, 31);
//panel_1.add(btnMultiRight);
//
//btnMultiLeft = new JButton("<<<");
//btnMultiLeft.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		//multiple swaps <<<
//		
//		if(list_CompraQuesos.getSelectedIndex() == -1)
//		{
//			JOptionPane.showMessageDialog(rootPane, "Seleccione algún queso", "", 1);
//		}
//		else
//		{
//			List lista = list_CompraQuesos.getSelectedValuesList();
//			int[] selectedIndices = list_CompraQuesos.getSelectedIndices();
//			Object temp[] = lista.toArray();
//			
//			//Agregando elementos a la lista izquierda
//			for(int i = 0; i < lista.size(); i++)
//			{
//				jListLeftModel.addElement(temp[i]);
//			}
//			list_ViewingQuesos.setModel(jListLeftModel);
//			
//			//Removiendo elementos de la lista izquierda
//			if(jListRightModel.getSize() != 0)
//			{
//				for(int i = 0; i < lista.size(); i++)
//				{
//					jListRightModel.removeElement(temp[i]);
//				}
//			}
//			
//			list_CompraQuesos.setModel(jListRightModel);
//		}
//	}
//});
//btnMultiLeft.setBounds(338, 325, 131, 31);
//panel_1.add(btnMultiLeft);
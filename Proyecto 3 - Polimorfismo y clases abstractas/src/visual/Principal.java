package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import logico.Complejo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				FileInputStream complejoFileIn;
				FileOutputStream complejoFileOut;
				ObjectInputStream complejoRead;
				ObjectOutputStream complejoWrite;
				
				try {
					
					complejoFileIn = new FileInputStream ("fabrica.dat");
					complejoRead = new ObjectInputStream(complejoFileIn);
					
					Complejo temp = (Complejo)complejoRead.readObject();
					
					Complejo.setMiFabrica(temp);
					complejoFileIn.close();
					complejoRead.close();
				} catch (FileNotFoundException e) {
					try {
						
						complejoFileOut = new  FileOutputStream("fabrica.dat");
						complejoWrite = new ObjectOutputStream(complejoFileOut);

						complejoWrite.writeObject(Complejo.getInstance());
						
						complejoFileOut.close();
						complejoWrite.close();
						
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream complejoOut;
				ObjectOutputStream complejoWrite;
				try {
					complejoOut = new  FileOutputStream("fabrica.dat");
					complejoWrite = new ObjectOutputStream(complejoOut);
					complejoWrite.writeObject(Complejo.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setBackground(new Color(240, 230, 140));
		setResizable(false);
		setTitle("Complejo L\u00E1cteo (Ciudad de La Habana)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		dim.width *= .90;
		dim.height *= .90;
		super.setSize(dim.width, dim.height);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnQuesos = new JMenu("Quesos");
		mnQuesos.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		menuBar.add(mnQuesos);
		
		JMenuItem mntmFabricarQueso = new JMenuItem("Fabricar");
		mntmFabricarQueso.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		mntmFabricarQueso.setBackground(new Color(250, 250, 210));
		mntmFabricarQueso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FabricarQueso().setVisible(true);
			}
		});
		mnQuesos.add(mntmFabricarQueso);
		
		JMenuItem mntmListarQuesos = new JMenuItem("Listar");
		mntmListarQuesos.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		mntmListarQuesos.setBackground(new Color(250, 250, 210));
		mntmListarQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListadoQuesos().setVisible(true);
			}
		});
		mnQuesos.add(mntmListarQuesos);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		menuBar.add(mnClientes);
		
		JMenuItem menuItem = new JMenuItem("Listar");
		menuItem.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		menuItem.setBackground(new Color(250, 250, 210));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarClientes().setVisible(true);
			}
		});
		mnClientes.add(menuItem);
		
		JMenu mnFacturar = new JMenu("Facturar");
		mnFacturar.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		menuBar.add(mnFacturar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Generar");
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		mntmNewMenuItem.setBackground(new Color(250, 250, 210));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Facturar(false).setVisible(true);
			}
		});
		mnFacturar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar");
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		mntmNewMenuItem_1.setBackground(new Color(250, 250, 210));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarFacturas().setVisible(true);
			}
		});
		mnFacturar.add(mntmNewMenuItem_1);
		
//		JMenuItem mntmReporteDe = new JMenuItem("Reporte de factura");
//		mntmReporteDe.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new ReporteFactura().setVisible(true);
//			}
//		});
//		mnFacturar.add(mntmReporteDe);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

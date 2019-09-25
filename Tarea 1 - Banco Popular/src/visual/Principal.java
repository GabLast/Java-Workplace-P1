package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Banco;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Banco miBanco = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banco popular = new Banco();
					Principal frame = new Principal(popular);
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
	public Principal(Banco popular) {
		this.miBanco = popular;
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.GRAY);
		setResizable(false);
		setTitle("Banco Popular");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 355);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegCliente(popular, null).setVisible(true);
			}
		});
		mnClientes.add(mntmRegistrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new listClientes(miBanco).setVisible(true);
			}
		});
		mnClientes.add(mntmListar);
		
		JMenu mnCuentas = new JMenu("Cuentas");
		menuBar.add(mnCuentas);
		
		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListaCuentas(miBanco).setVisible(true);
			}
		});
		mnCuentas.add(mntmListar_1);
		
		JMenu mnAdministrarCuentas = new JMenu("Administrar cuentas");
		menuBar.add(mnAdministrarCuentas);
		
		JMenuItem mntmIngresarDinero = new JMenuItem("Ingresar dinero");
		mntmIngresarDinero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IngresarSaldo(miBanco).setVisible(true);
			}
		});
		mnAdministrarCuentas.add(mntmIngresarDinero);
		
		JMenuItem mntmRetirarDinero = new JMenuItem("Retirar dinero");
		mntmRetirarDinero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RetirarDinero(miBanco).setVisible(true);
			}
		});
		mnAdministrarCuentas.add(mntmRetirarDinero);
		
		JMenuItem mntmRevisinMensual = new JMenuItem("Revisi\u00F3n mensual");
		mntmRevisinMensual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RevisionMensual(miBanco).setVisible(true);
			}
		});
		mnAdministrarCuentas.add(mntmRevisinMensual);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

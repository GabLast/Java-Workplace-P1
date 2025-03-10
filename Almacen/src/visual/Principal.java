package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Almacen;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Almacen mialma = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almacen alma = new Almacen();
					Principal frame = new Principal(alma);
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
	public Principal(Almacen alma) {
		this.mialma = alma;
		setResizable(false);
		setTitle("Almacen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 342);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(173, 216, 230));
		setJMenuBar(menuBar);
		
		JMenu mnSuplidores = new JMenu("Suplidores");
		menuBar.add(mnSuplidores);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegSuplidor reg = new RegSuplidor(mialma,null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnSuplidores.add(mntmRegistrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listSuplidores list = new listSuplidores(mialma);
				list.setModal(true);
				list.setVisible(true);
				
			}
		});
		mnSuplidores.add(mntmListar);
		
		JMenu mnVinos = new JMenu("Vinos");
		menuBar.add(mnVinos);
		
		JMenuItem mntmRegistrarVino = new JMenuItem("Registrar Vino");
		mntmRegistrarVino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegVino regvino = new RegVino(alma, null);
				regvino.setModal(true);
				regvino.setVisible(true);
			}
		});
		mnVinos.add(mntmRegistrarVino);
		
		JMenu mnAdministracin = new JMenu("Administraci\u00F3n");
		menuBar.add(mnAdministracin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(173, 216, 230));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(10);
		contentPane.add(panel, BorderLayout.SOUTH);
	}

}

package reloj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Principal extends JFrame implements Runnable  {

	private JPanel contentPane;
	JLabel lblNewLabel;
    int hora, minutos, segundos;
    Calendar calendario;
    Thread h1;
    

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(31, 11, 133, 117);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/imagen/fotico.jpg")));
		lblNewLabel_1.setBounds(273, 35, 133, 117);
		contentPane.add(lblNewLabel_1);
		 h1 = new Thread(this);
	     h1.start();
	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblNewLabel.setText(hora + ":" + minutos + ":" + segundos);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
		
	}
	
	public void calcula() {
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
    }
  }



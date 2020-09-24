package Tela_jogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Tela_inicial extends JFrame {
	private Tela_cadastro Tela_cadastro = new Tela_cadastro();
	private Jogo  Jogo = new Jogo();
	private Tela_jogadores Tela_jogadores = new Tela_jogadores();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_inicial frame = new Tela_inicial();
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
	public Tela_inicial() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_jogar = new JButton("Jogar");
		btn_jogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jogo.setVisible(true);
				
				
			}
		});
		btn_jogar.setBounds(129, 61, 89, 23);
		contentPane.add(btn_jogar);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_cadastro.setVisible(true);
			}
		});
		btn_cadastrar.setBounds(129, 114, 89, 23);
		contentPane.add(btn_cadastrar);
		
		JButton btnJogadores = new JButton("Jogadores");
		btnJogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_jogadores.setVisible(true);
			}
			
		});
		btnJogadores.setBounds(129, 162, 89, 23);
		contentPane.add(btnJogadores);
	}
}

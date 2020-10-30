package Tela_jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class Tela_login extends JFrame {
	Tela_inicial telaInicial = new Tela_inicial();
	Tela_cadastro telacadastro = new Tela_cadastro();
	
	
	private JPanel contentPane;
	private JTextField txt_usuario;
	private JTextField txt_senha;
	JogadorDAO jgdao = new JogadorDAO();
	Jogador jg = new Jogador();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_login frame = new Tela_login();
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
	public Tela_login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 143, 94, 33);
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 18));
		contentPane.add(lblSenha);
		
		txt_senha = new JTextField();
		txt_senha.setBounds(123, 153, 86, 20);
		txt_senha.setColumns(10);
		contentPane.add(txt_senha);
		
		JButton btn_Entrar = new JButton("Entrar");
		btn_Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				jg = jgdao.Logar(txt_usuario.getText());
				telaInicial.setVisible(true);
				telaInicial.jg = jg;
				//Tela_inicial.lbljogador.setText()
			//	System.out.println(jg.getEmail());
			//	Integer.parseInt;
				telaInicial.lbljogador.setText(jg.getNome());
				//telaInicial.
			}
		});
		btn_Entrar.setBounds(32, 239, 104, 33);
		btn_Entrar.setBackground(Color.GREEN);
		contentPane.add(btn_Entrar);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telacadastro.setVisible(true);
			}
		});
		btn_cadastrar.setBounds(149, 239, 94, 33);
		btn_cadastrar.setBackground(Color.WHITE);
		contentPane.add(btn_cadastrar);
		
		JButton btn_jogarSemCadastro = new JButton("Jogar Sem Cadastro");
		btn_jogarSemCadastro.setBounds(310, 228, 206, 54);
		btn_jogarSemCadastro.setBackground(new Color(255, 0, 0));
		contentPane.add(btn_jogarSemCadastro);
		
		JLabel lblNewLabel_1 = new JLabel("Onion");
		lblNewLabel_1.setBounds(149, 11, 193, 75);
		lblNewLabel_1.setForeground(new Color(0, 255, 0));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 28));
		contentPane.add(lblNewLabel_1);
		
		Panel panel = new Panel();
		panel.setBounds(268, 64, 206, 121);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(50, 107, 94, 33);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(123, 117, 86, 20);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);
	}
}

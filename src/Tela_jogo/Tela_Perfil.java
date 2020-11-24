package Tela_jogo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.facear.bo.JogadorBO;
import br.edu.facear.entity.Jogador;

public class Tela_Perfil extends JFrame {

	private JPanel contentPane;
	static JTextField txt_jogador;
	 static JTextField txt_email;
	 static JTextField txt_idade;
	private JTextField txt_senhaatual;
	private JTextField txt_senhanova;
	static JLabel lblpontuacao = new JLabel("");
	static JLabel lbljogador = new JLabel("");

	
	JogadorBO jgbo = new JogadorBO();
	
	static Jogador jg = new Jogador();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					
					Tela_Perfil frame = new Tela_Perfil();
					frame.setVisible(true);
					carregar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Perfil() {
	//	carregar();
		System.out.println("aaaa: "+jg);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Perfil");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(71, 11, 151, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(32, 92, 79, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(32, 126, 79, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Idade");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(32, 160, 79, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  nomeAntigo = jg.getNome();
				jg.setNome(txt_jogador.getText());
				jg.setEmail(txt_email.getText());
				jg.setIdade(txt_idade.getText());
				jgbo.salvar(jg);
				carregar();
			}
		});
		btnNewButton.setBounds(22, 264, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela_inicial inicial = new Tela_inicial();
				inicial.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(133, 264, 89, 23);
		contentPane.add(btnVoltar);
		
		txt_jogador = new JTextField();
		txt_jogador.setEditable(false);
		txt_jogador.setBounds(93, 95, 170, 20);
		contentPane.add(txt_jogador);
		txt_jogador.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(93, 129, 170, 20);
		contentPane.add(txt_email);
		
		txt_idade = new JTextField();
		txt_idade.setColumns(10);
		txt_idade.setBounds(93, 163, 170, 20);
		contentPane.add(txt_idade);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Senha atual");
		lblNewLabel_1_2_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(304, 92, 105, 23);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Nova Senha");
		lblNewLabel_1_2_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(304, 129, 105, 23);
		contentPane.add(lblNewLabel_1_2_2);
		
		txt_senhaatual = new JTextField();
		txt_senhaatual.setBounds(419, 95, 86, 20);
		contentPane.add(txt_senhaatual);
		txt_senhaatual.setColumns(10);
		
		txt_senhanova = new JTextField();
		txt_senhanova.setColumns(10);
		txt_senhanova.setBounds(419, 132, 86, 20);
		contentPane.add(txt_senhanova);
		
		JLabel lblNewLabel_1_3 = new JLabel("Jogador");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(32, 45, 79, 23);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblultima = new JLabel("Ultima Pontua\u00E7\u00E3o");
		lblultima.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblultima.setBounds(228, 45, 149, 23);
		contentPane.add(lblultima);
		
		
		lbljogador.setFont(new Font("Verdana", Font.PLAIN, 15));
		lbljogador.setBounds(111, 45, 79, 23);
		contentPane.add(lbljogador);
		
	
		lblpontuacao.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblpontuacao.setBounds(376, 45, 79, 23);
		contentPane.add(lblpontuacao);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(22, 234, 89, 23);
		contentPane.add(btnNewButton_1);
		System.out.println("aaaa: "+jg);
	}

	public static void carregar() {
		
		lblpontuacao.setText(Integer.toString(jg.getPontuacao()));
		lbljogador.setText(jg.getNome());
		txt_jogador.setText(jg.getNome());
		txt_idade.setText(jg.getIdade());
		txt_email.setText(jg.getEmail());
	
	}
}

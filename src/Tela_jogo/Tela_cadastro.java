package Tela_jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controler.ConfiguracaoControle;
import Controler.ControleJogador;
import Controler.ControleJogo;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class Tela_cadastro extends JFrame {
	//Tela_login telalogin = new Tela_login();
	
	 Jogador jogador = new Jogador();
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_idade;
	private JTextField txt_email;
	public static DefaultListModel lista;
	ArrayList  <Jogador> listadejogador= new ArrayList();
	JogadorDAO jogadordao = new JogadorDAO();
	ControleJogador controlejg = new ControleJogador();
	ConfiguracaoControle confcontrole = new ConfiguracaoControle();
	ControleJogo controle = new ControleJogo();
	private JTextField txt_senha1;
	private JTextField txt_senha2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_cadastro frame = new Tela_cadastro();
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
	public Tela_cadastro() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNome.setBounds(36, 58, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(131, 52, 264, 26);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblIdade.setBounds(36, 95, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblEmail.setBounds(36, 130, 46, 14);
		contentPane.add(lblEmail);
		
		txt_idade = new JTextField();
		txt_idade.setBounds(131, 89, 264, 26);
		contentPane.add(txt_idade);
		txt_idade.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(131, 124, 264, 26);
		contentPane.add(txt_email);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Jogador jn = new Jogador();

				
				int comparacao =0; // controle se a senha for imcompativel usado para apagar apenas texto das senhas
				String nome;
				String idade;
				
				int codigo;
				codigo = confcontrole.PegarCodJogador();
				nome = (txt_nome.getText());
				//jogador.setNome(nome);
				jogador.setNome(txt_nome.getText());
				jogador.setCod_jogador(codigo);
				
				idade = (txt_idade.getText());
				jogador.setIdade(idade);
				jogador.setEmail(txt_email.getText());
				comparacao= controlejg.comparaSenha(txt_senha1.getText(), txt_senha2.getText());
			
				jogador.setSenha(Integer.parseInt(txt_senha1.getText()));
				
				
				listadejogador.add(jogador);
				
				//for(int cont = 0;cont < listadejogador.size();cont++){
					
				//	lista.addElement(listadejogador.get(cont).getNome()+"    "+listadejogador.get(cont).getIdade());
					//jogadordao.Salvar(jogador);
					
				//lista.set(index, nome);
					if(comparacao == 1) {
						txt_senha1.setText(null);
						txt_senha2.setText(null);
					}else {
					
						
						lista.addElement(jogador.getCod_jogador()+"      "+jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
						controlejg.CadastrarJogador(jogador);
						
						
				txt_nome.setText(null);
				txt_idade.setText(null);
				txt_email.setText(null);
				txt_senha1.setText(null);
				txt_senha2.setText(null);
					}
			}
		});
		btnCadastrar.setBounds(22, 251, 131, 33);
		contentPane.add(btnCadastrar);
		lista = new DefaultListModel();
		
		JLabel lblsenha1 = new JLabel("Senha");
		lblsenha1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblsenha1.setBounds(36, 179, 46, 14);
		contentPane.add(lblsenha1);
		
		txt_senha1 = new JPasswordField();
		txt_senha1.setColumns(10);
		txt_senha1.setBounds(171, 177, 146, 23);
		contentPane.add(txt_senha1);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblConfirmarSenha.setBounds(36, 211, 137, 20);
		contentPane.add(lblConfirmarSenha);
		
		txt_senha2 = new JPasswordField();
		txt_senha2.setColumns(10);
		txt_senha2.setBounds(171, 211, 146, 20);
		contentPane.add(txt_senha2);
		
		JButton bnt_voltar = new JButton("Voltar");
		bnt_voltar.setFont(new Font("Verdana", Font.BOLD, 15));
		bnt_voltar.setBackground(Color.RED);
		bnt_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela_login tela = new Tela_login();
				controle.Somvoltar();
				dispose();
				tela.setVisible(true);
				
			}
		});
		bnt_voltar.setBounds(348, 251, 83, 42);
		contentPane.add(bnt_voltar);
		
		JLabel lblNewLabel = new JLabel("Novo Jogador");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 20));
		lblNewLabel.setBounds(122, 11, 257, 30);
		contentPane.add(lblNewLabel);
	}
}

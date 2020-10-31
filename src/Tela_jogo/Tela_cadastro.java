package Tela_jogo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controler.ConfiguracaoControle;
import Controler.ControleJogador;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class Tela_cadastro extends JFrame {
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
		setBounds(100, 100, 605, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(36, 58, 46, 14);
		contentPane.add(lblNome);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(92, 55, 119, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(36, 95, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(36, 130, 46, 14);
		contentPane.add(lblEmail);
		
		txt_idade = new JTextField();
		txt_idade.setBounds(92, 92, 119, 20);
		contentPane.add(txt_idade);
		txt_idade.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(92, 127, 119, 20);
		contentPane.add(txt_email);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
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
		btnCadastrar.setBounds(235, 219, 89, 23);
		contentPane.add(btnCadastrar);
		lista = new DefaultListModel();
		JList list = new JList(lista);
		list.setBounds(350, 24, 190, 169);
		contentPane.add(list);
		
		JButton btnJ_jogadores = new JButton("Jogadores");
		btnJ_jogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(int cont = 0;cont < listadejogador.size();cont++){
					
					 
					    lista.addElement( listadejogador.get( cont ) );  
					
					//lista.addElement(jogador.getNome()+"      "+jogador.getIdade()+"    "+jogador.getEmail()+ "   "+jogador.getPontuacao());
					//lista.addElement(listadejogador.get(cont).getNome()+"    "+listadejogador.get(cont).getIdade());
					}
			Tela_jogadores tela_jogadores = new Tela_jogadores();
			
			tela_jogadores.setVisible(true);
			}
		});
		btnJ_jogadores.setBounds(372, 219, 89, 23);
		contentPane.add(btnJ_jogadores);
		
		JLabel lblsenha1 = new JLabel("Senha");
		lblsenha1.setBounds(22, 179, 46, 14);
		contentPane.add(lblsenha1);
		
		txt_senha1 = new JPasswordField();
		txt_senha1.setColumns(10);
		txt_senha1.setBounds(123, 180, 86, 20);
		contentPane.add(txt_senha1);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha");
		lblConfirmarSenha.setBounds(22, 212, 109, 20);
		contentPane.add(lblConfirmarSenha);
		
		txt_senha2 = new JPasswordField();
		txt_senha2.setColumns(10);
		txt_senha2.setBounds(123, 212, 86, 20);
		contentPane.add(txt_senha2);
	}
}

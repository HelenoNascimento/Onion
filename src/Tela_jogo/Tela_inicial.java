package Tela_jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ConfiguracaoControle;
import Controler.ControleDificuldade;
import Controler.ControleJogo;
import Controler.Tela_InicialControle;
import br.edu.facear.dao.HistoricoDAO;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Dificuldade;
import br.edu.facear.entity.Jogador;

public class Tela_inicial extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tela_cadastro Tela_cadastro = new Tela_cadastro();
	
	private Tela_jogadores Tela_jogadores = new Tela_jogadores();
	private Tela_Historico tela_historico = new Tela_Historico();
	private Tela_Pontos tela_pontos = new Tela_Pontos();
	Tela_Perfil tela_perfil = new Tela_Perfil();
	ConfiguracaoControle conficotrole = new ConfiguracaoControle();
	private Tela_jogo  Tela_jogo = new Tela_jogo();
	
	private JPanel contentPane;
	 private List<Dificuldade> lista;
	 JComboBox <String> comboBox = new JComboBox<String>();
	 public String dificu;
	 ControleDificuldade cd = new ControleDificuldade();
	 ControleJogo cj = new ControleJogo();
	 Dificuldade df = new Dificuldade();
	 Tela_InicialControle iniciocontrole = new Tela_InicialControle();
	 JogadorDAO jgdao = new JogadorDAO();
	 Jogador jg  = new Jogador();
	 public static JLabel lbldificu = new JLabel("Dificuldade");
	 public static JLabel lbljogador = new JLabel("");
	 //String dificuldade = null;
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
		Tela_jogo.btn_start.setLocation(10, 318);
		

		
		conficotrole.CriarPasta();
		 List<Dificuldade> listDificuldade = new ControleDificuldade().criaListDificuldade();      
	        //EstadosComboModel modelEstados = new EstadosComboModel(listEstados);


		 cd.criaListDificuldade();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_jogar = new JButton("Novo Jogo");
		btn_jogar.setBackground(new Color(50, 205, 50));
		btn_jogar.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_jogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// NA TELA JOGO MOSTRA QUAL É O JOGADOR
				//Tela_jogo.lblqualjogador.setText(jgdao.BuscaCodigoJogador(txt_jogador.getText()));
				Tela_jogo.lblqualjogador.setText(jg.getNome());
				 dificu = String.valueOf(comboBox.getSelectedItem()); // SELECIONA A DIFICULDADE
				Tela_jogo.setVisible(true); // ABRE A TELA JOGO
				cj.pegaDificuldade(dificu);
				cj.listartop3();
				ControleJogo.dificuldadee = dificu;
				Tela_jogo.dificuldade = dificu;
				//Tela_jogo.CodigoJogador = Integer.parseInt(txt_jogador.getText());
				Tela_jogo.jogador = jg;
				//Tela_jogo.Continuar
				Tela_jogo.reiniciar = 1;
				
			}
		});
		btn_jogar.setBounds(50, 58, 141, 42);
		contentPane.add(btn_jogar);
		
		JButton btnJogadores = new JButton("Jogadores");
		btnJogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// ABRE A TELA JOGADORES
				Tela_jogadores.setVisible(true);
			}
			
		});
		btnJogadores.setBounds(50, 243, 141, 23);
		contentPane.add(btnJogadores);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		
		//comboBox = 
		
		
		comboBox.setToolTipText("aaa\r\naaa\r\naa");
		comboBox.setBounds(419, 58, 102, 23);
		contentPane.add(comboBox);
		lbljogador.setFont(new Font("Verdana", Font.PLAIN, 25));
	
		
		lbljogador.setBounds(291, 11, 172, 51);
		contentPane.add(lbljogador);
		
		JButton btnNewButton = new JButton("Historico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(jg);
				tela_historico.setVisible(true);
				//dispose();
				// txt_jogador.setText(Integer.toString(jg.getCod_jogador()));
			}
		});
		btnNewButton.setBounds(50, 277, 141, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				
				//Tela_jogo.enable();
				
				Tela_jogo.Continuar =1; // PASSA PARA A TELA JOGO QUE É UMA OPCAO CONTINUAR
				String codigo = Integer.toString(jg.getCod_jogador());
				Tela_jogo.ListaSalvo = HistoricoDAO.PegarSalvo(codigo);
				//Tela_jogo.ListaSalvo = HistoricoDAO.LerUtilmaJogada(codigo);
				//Tela_jogo.MaquinaLista = HistoricoDAO.PegarSalvo(codigo);
				//LerUtilmaJogada
				cj.listartop3();
				// NA TELA JOGO MOSTRA QUAL É O JOGADOR
				//Tela_jogo.lblqualjogador.setText(jgdao.BuscaCodigoJogador(txt_jogador.getText()));
				Tela_jogo.lblqualjogador.setText(jg.getNome());
				 dificu = String.valueOf(comboBox.getSelectedItem()); // SELECIONA A DIFICULDADE
					Tela_jogo.jogador = jg;
					Tela_jogo.dificuldade = dificu;
					Tela_jogo.setVisible(true); // ABRE A TELA JOGO
				cj.pegaDificuldade(dificu);
				ControleJogo.dificuldadee = dificu;
				//Tela_jogo.CodigoJogador = Integer.parseInt(txt_jogador.getText());
			
			}
		});
		btnNewButton_1.setBackground(new Color(240, 248, 255));
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_1.setBounds(50, 127, 143, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btn_sair = new JButton("SAIR");
		btn_sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			iniciocontrole.sair();
				Tela_login tela = new Tela_login();
				dispose();
				tela.setVisible(true);
			}
		});
		btn_sair.setBackground(Color.RED);
		btn_sair.setForeground(Color.WHITE);
		btn_sair.setFont(new Font("Verdana", Font.PLAIN, 18));
		btn_sair.setBounds(450, 277, 89, 42);
		contentPane.add(btn_sair);
		
		
		lbldificu.setFont(new Font("Verdana", Font.PLAIN, 15));
		lbldificu.setBounds(300, 58, 114, 23);
		contentPane.add(lbldificu);
		
		JLabel lblNewLabel = new JLabel("Valores Pontua\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel.setBounds(280, 145, 141, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnpontuacao = new JButton("");
		btnpontuacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tela_pontos.setVisible(true);
			}
		});
		btnpontuacao.setBounds(419, 145, 27, 23);
		contentPane.add(btnpontuacao);
		
		JButton btnNewButton_2 = new JButton("Perfil");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("teste "+jg);
				
				Tela_Perfil.lblpontuacao.setText(Integer.toString(jg.getPontuacao()));
				Tela_Perfil.lbljogador.setText(jg.getNome());
				Tela_Perfil.txt_jogador.setText(jg.getNome());
				Tela_Perfil.txt_idade.setText(jg.getIdade());
				Tela_Perfil.txt_email.setText(jg.getEmail());
				
				tela_perfil.jg = jg;
				tela_perfil.setVisible(true);
				
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(50, 213, 89, 23);
		contentPane.add(btnNewButton_2);

		
		comboBox.addItem("Facil");
		comboBox.addItem("Normal");
		comboBox.addItem("Dificil");
		comboBox.addItem("Hardcore");
		System.out.println(String.valueOf(comboBox.getSelectedItem()));
		System.out.println(jg.getNome()+"aa");
		System.out.println(comboBox.getSelectedIndex());
		
		}
}

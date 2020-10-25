package Tela_jogo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controler.ControleDificuldade;
import Controler.ControleJogo;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Dificuldade;

public class Tela_inicial extends JFrame {
	private Tela_cadastro Tela_cadastro = new Tela_cadastro();
	private Tela_jogo  Tela_jogo = new Tela_jogo();
	private Tela_jogadores Tela_jogadores = new Tela_jogadores();
	private JPanel contentPane;
	 private List<Dificuldade> lista;
	 JComboBox <String> comboBox = new JComboBox<String>();
	 public String dificu;
	 ControleDificuldade cd = new ControleDificuldade();
	 ControleJogo cj = new ControleJogo();
	 Dificuldade df = new Dificuldade();
	 JogadorDAO jgdao = new JogadorDAO();
	 private JTextField txt_jogador;
	 
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
		
		 List<Dificuldade> listDificuldade = new ControleDificuldade().criaListDificuldade();      
	        //EstadosComboModel modelEstados = new EstadosComboModel(listEstados);


		 cd.criaListDificuldade();
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_jogar = new JButton("Jogar");
		btn_jogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// NA TELA JOGO MOSTRA QUAL É O JOGADOR
				Tela_jogo.lblqualjogador.setText(jgdao.BuscaCodigoJogador(txt_jogador.getText()));
				 dificu = String.valueOf(comboBox.getSelectedItem()); // SELECIONA A DIFICULDADE
				Tela_jogo.setVisible(true); // ABRE A TELA JOGO
				cj.pegaDificuldade(dificu);
				ControleJogo.dificuldadee = dificu;
				Tela_jogo.CodigoJogador = Integer.parseInt(txt_jogador.getText());
				
			}
		});
		btn_jogar.setBounds(50, 58, 119, 23);
		contentPane.add(btn_jogar);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ABRE A TELA CADASTRO
				Tela_cadastro.setVisible(true);
			}
		});
		btn_cadastrar.setBounds(50, 116, 119, 23);
		contentPane.add(btn_cadastrar);
		
		JButton btnJogadores = new JButton("Jogadores");
		btnJogadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// ABRE A TELA JOGADORES
				Tela_jogadores.setVisible(true);
			}
			
		});
		btnJogadores.setBounds(50, 169, 119, 23);
		contentPane.add(btnJogadores);
		
		//comboBox = 
		
		
		comboBox.setToolTipText("aaa\r\naaa\r\naa");
		comboBox.setBounds(282, 96, 102, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Qual jogador Teste");
		lblNewLabel.setBounds(273, 173, 111, 14);
		contentPane.add(lblNewLabel);
		
		txt_jogador = new JTextField();
		txt_jogador.setBounds(270, 198, 86, 20);
		contentPane.add(txt_jogador);
		txt_jogador.setColumns(10);
		comboBox.addItem("Facil");
		comboBox.addItem("Normal");
		comboBox.addItem("Dificil");
		comboBox.addItem("Hardcore");
		System.out.println(String.valueOf(comboBox.getSelectedItem()));
		
		System.out.println(comboBox.getSelectedIndex());
		/*for(int i = 0; i < lista.size(); i++) {
			
			comboBox.addItem(lista);
			
			}*/
		
		}
}

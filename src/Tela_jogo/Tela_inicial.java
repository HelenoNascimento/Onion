package Tela_jogo;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import Controler.ControleDificuldade;
import Controler.ControleJogo;
import br.edu.facear.entity.Dificuldade;
import javax.swing.DefaultComboBoxModel;

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
				
				 dificu = String.valueOf(comboBox.getSelectedItem());
				Tela_jogo.setVisible(true);
				cj.pegaDificuldade(dificu);
				ControleJogo.dificuldadee = dificu;
				
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
		
		//comboBox = 
		
		
		comboBox.setToolTipText("aaa\r\naaa\r\naa");
		comboBox.setBounds(282, 96, 102, 23);
		contentPane.add(comboBox);
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
	
	
	//public String pegaDificuldade() {
		
	//	Object a = comboBox.getSelectedItem();
	//	dificuldade = a.toString();
		//return dificuldade;
	//}
}

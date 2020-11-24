package Tela_jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controler.ConfiguracaoControle;
import Controler.ControleJogador;
import Controler.ControleJogo;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Jogador;

public class Tela_login extends JFrame {
	Tela_inicial telaInicial = new Tela_inicial();
	Tela_cadastro telacadastro = new Tela_cadastro();
	//Tela_login tela= new Tela_login();
	ConfiguracaoControle conficotrole = new ConfiguracaoControle(); 
	
	JFrame frame = new JFrame();
	
	private JButton btn1 = new JButton("");
	private JButton btn2 = new JButton("");
	private JButton btn3 = new JButton("");
	private JButton btn4 = new JButton("");
	
	JLabel lbl_onion = new JLabel("Onion");
	
	JButton[] botoes = {btn1,btn2 , btn3 , btn4};
	ArrayList <Integer> lista = new ArrayList(); //sequencia do jogador
	ArrayList <Integer> MaquinaLista = new ArrayList(); // sequencia da maquina
	
	int numero;
	private JPanel contentPane;
	private JTextField txt_usuario;
	private JTextField txt_senha;
	JogadorDAO jgdao = new JogadorDAO();
	Jogador jg = new Jogador();
	ControleJogador controlejg = new ControleJogador();
	ControleJogo controle = new ControleJogo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				//	Tela_login window = new Tela_login();
					//window.setVisible(true);
					
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
		//teste();
		teste1();
		conficotrole.CriarPasta();
		//conficotrole.CriarConfig();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 381);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 143, 94, 33);
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 18));
		contentPane.add(lblSenha);
		
		txt_senha = new JPasswordField();
		txt_senha.setBounds(123, 153, 86, 20);
		txt_senha.setColumns(10);
		contentPane.add(txt_senha);
		
		JButton btn_Entrar = new JButton("Entrar");
		btn_Entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//frame.setVisible(false);
				//jg = jgdao.Logar(txt_usuario.getText());
				jg = controlejg.Logar(txt_usuario.getText(), txt_senha.getText());
				
				//Tela_inicial.lbljogador.setText()
			//	System.out.println(jg.getEmail());
			//	Integer.parseInt;
			
				//telaInicial.
				String senha = Integer.toString(jg.getSenha());
				if((txt_usuario.getText().equals(jg.getNome())&&(txt_senha.getText().equals(senha)))) {
					telaInicial.setVisible(true);
					telaInicial.lbljogador.setText(jg.getNome());
					telaInicial.jg = jg;
					dispose();
					JOptionPane.showMessageDialog(null, "Bem vindo de volta "+jg.getNome());
					//Tela_login.setVisible(false);
					//tela.setVisible(true);
					
					
					//Runtime.getRuntime().exit(0);
				}else {
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto ");
					txt_senha.setText(null);
				}
			}
		});
		btn_Entrar.setBounds(32, 239, 104, 33);
		btn_Entrar.setBackground(Color.GREEN);
		contentPane.add(btn_Entrar);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(false);
				dispose();
				telacadastro.setVisible(true);
				
			}
		});
		btn_cadastrar.setBounds(149, 239, 94, 33);
		btn_cadastrar.setBackground(Color.WHITE);
		contentPane.add(btn_cadastrar);
		
		JButton btn_jogarSemCadastro = new JButton("Jogar Sem Cadastro");
		btn_jogarSemCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				jg = controlejg.JogarSemCadastro();
				telaInicial.jg = jg;
				telaInicial.lbljogador.setText(jg.getNome());
				telaInicial.setVisible(true);
			}
		});
		btn_jogarSemCadastro.setForeground(new Color(255, 255, 255));
		btn_jogarSemCadastro.setFont(new Font("Verdana", Font.PLAIN, 15));
		btn_jogarSemCadastro.setBounds(310, 228, 206, 54);
		btn_jogarSemCadastro.setBackground(new Color(255, 0, 0));
		contentPane.add(btn_jogarSemCadastro);
		
		
		lbl_onion.setBounds(78, 11, 193, 75);
		lbl_onion.setForeground(Color.GREEN);
		lbl_onion.setFont(new Font("Verdana", Font.PLAIN, 35));
		contentPane.add(lbl_onion);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(50, 107, 94, 33);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(123, 117, 86, 20);
		contentPane.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		//JButton btn1 = new JButton("");
		btn1.setEnabled(false);
		btn1.setBackground(new Color(50, 205, 50));
		btn1.setBounds(346, 45, 86, 67);
		contentPane.add(btn1);
		
		//JButton btn2 = new JButton("");
		btn2.setEnabled(false);
		btn2.setBackground(new Color(255, 0, 0));
		btn2.setBounds(440, 45, 86, 67);
		contentPane.add(btn2);
		
		//JButton btn4 = new JButton("");
		btn4.setEnabled(false);
		btn4.setBackground(new Color(255, 255, 0));
		btn4.setBounds(440, 117, 86, 67);
		contentPane.add(btn4);
		
		//JButton btn3 = new JButton("");
		btn3.setEnabled(false);
		btn3.setBackground(new Color(0, 0, 255));
		btn3.setBounds(346, 117, 86, 67);
		contentPane.add(btn3);
	}
	
public void Pisca_Botoes(JButton e) {
		
		Color c = e.getBackground();
		String test;
		test = e.getText();
		// System.out.println("controle "+controle.Dificuldade());
        try {
            Thread.currentThread();
            if(test == "1") {
            e.setBackground(Color.BLUE);
            Thread.sleep(400);
            }
            lbl_onion.setForeground(Color.GREEN);
            Tela_inicial.lbljogador.setForeground(Color.GREEN);
            e.setBackground(Color.WHITE);
            Thread.sleep(400); //pega o tempo que o jogador escolheu conforme a dificuldade
            
            e.setBackground(c);

        } catch (InterruptedException P) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, P.getMessage());
        }

		
	}

public void teste() {
		
		Random gerador = new Random();
		numero = gerador.nextInt(4);
		MaquinaLista.add(numero);
		new Thread(new Runnable() {
            @Override
            public void run() {
            	
            	 for (int i = 0; i < MaquinaLista.size(); i++) {
            		 System.out.println(MaquinaLista.get(i));
            	 }
               
                try {
                    Thread.sleep(400);
                   
                    Thread.sleep(400);
                    for (int i = 0; i < MaquinaLista.size(); i++) {
                    	
                        if (MaquinaLista.get(i) == null) {
                            break;
                        } else {
                        	Pisca_Botoes(botoes[(MaquinaLista.get(i))]);
                        }
                        Thread.sleep(400);
                       
                    }
                    Thread.sleep(400);
                    
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
                
            }
        }).start();
	}

				public void teste1() {
					
					new Thread(new Runnable() {
			            @Override
			            public void run() {
			            	try {
			            	while(numero<=9){
			            		Random gerador = new Random();
			            		numero = gerador.nextInt(4);
			            		Tela_inicial.lbljogador.setForeground(Color.blue);
			            		Thread.sleep(400); 
			            		Pisca_Botoes(botoes[(numero)]);
			            		lbl_onion.setForeground(Color.blue);
			            		
			                }
			                
			                        Thread.sleep(400);
			                       
			                    
			                    Thread.sleep(400);
			                    
			                    
			                } catch (InterruptedException e1) {
			                    // TODO Auto-generated catch block
			                    JOptionPane.showMessageDialog(null, e1.getMessage());
			                }
			                
			            }
			        }).start();
				}

}

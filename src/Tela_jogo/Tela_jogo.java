package Tela_jogo;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controler.ControleJogo;
import br.edu.facear.dao.HistoricoDAO;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Historico;
import br.edu.facear.entity.Jogador;

public class Tela_jogo extends JFrame {

	private JPanel contentPane;
	private JButton btn1 = new JButton("");
	private JButton btn2 = new JButton("");
	private JButton btn3 = new JButton("");
	private JButton btn4 = new JButton("");
	public static JLabel lblSuaVez = new JLabel("Sua Vez!!");
	String[] array_aux = new String[8];
	JButton[] botoes = {btn1,btn2 , btn3 , btn4};
	ArrayList <Integer> lista = new ArrayList();
	ArrayList <Integer> MaquinaLista = new ArrayList();
	Jogador jogador = new Jogador();
	Historico historico = new Historico ();
	ControleJogo controle = new ControleJogo();
	JogadorDAO jogadordao = new JogadorDAO();
	HistoricoDAO historicodao = new HistoricoDAO();
	int contadorVez = 0;
	int numero;
	int vezJogar = 0;
	int controlaVezJogador = 0;
	int num = 0;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_jogo frame = new Tela_jogo();
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
	public Tela_jogo() {
		/*array_aux[0] = "2";
		array_aux[1] = "1";
		array_aux[2] = "3";
		array_aux[3] = "0";
		array_aux[4] = "0";
		array_aux[5] = "0";
		array_aux[6] = "0";
		array_aux[7] = "0";*/
		array_aux[0] = "1";
		jogador.setEmail("Teste@gemail.com");
		jogador.setIdade("15");
		jogador.setNome("Tiago");
		jogador.setCod_jogador(10);
		setBounds(100, 100, 514, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				controlaVezJogador++;
				contadorVez++;
				//array_aux[contadorVez] = "0";
				System.out.println("controle" +controlaVezJogador);
				lista.add(0);
				int test = MaquinaLista.size();
				if(controlaVezJogador == test) {
					vezJogar = 1;
					if(lista.equals(MaquinaLista)) {
						Random gerador = new Random();
						numero = gerador.nextInt(4);
						MaquinaLista.add(numero);
						System.out.println("entrou");
						ControlaVez();
						System.out.println("errou ");
						
					}else {
						JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						controle.Vida(1);
						int pont = array_aux.length;
						jogador.setPontuacao(contadorVez);
						jogadordao.Salvar(jogador);
						SalvaHistorico();
						contadorVez =0;
						
					}
					
				}
				
				
				
			
				
			}
		});
		

		btn1.setBackground(new Color(0, 100, 0));
		btn1.setBounds(48, 37, 114, 77);
		contentPane.add(btn1);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlaVezJogador++;
				contadorVez++;
				//array_aux[contadorVez] = "0";
				System.out.println("controle" +controlaVezJogador);
				lista.add(1);
				int test = MaquinaLista.size();
				if(controlaVezJogador == test) {
					vezJogar = 1;
					if(lista.equals(MaquinaLista)) {
						Random gerador = new Random();
						numero = gerador.nextInt(4);
						MaquinaLista.add(numero);
						System.out.println("entrou");
						ControlaVez();
						System.out.println("errou ");
					}else {
						JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						controle.Vida(1);
						int pont = array_aux.length;
						jogador.setPontuacao(contadorVez);
						jogadordao.Salvar(jogador);
						SalvaHistorico();
						contadorVez =0;
					}
					
				}
				
				
			}
		});
		
		
		btn2.setBackground(new Color(153, 0, 0));
		btn2.setBounds(235, 37, 114, 77);
		contentPane.add(btn2);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlaVezJogador++;
				contadorVez++;
				//array_aux[contadorVez] = "0";
				System.out.println("controle" +controlaVezJogador);
				lista.add(2);
				int test = MaquinaLista.size();
				if(controlaVezJogador == test) {
					vezJogar = 1;
					if(lista.equals(MaquinaLista)) {
						Random gerador = new Random();
						numero = gerador.nextInt(4);
						MaquinaLista.add(numero);
						System.out.println("entrou");
						ControlaVez();
						System.out.println("errou ");
					}else {
						JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						controle.Vida(1);
						int pont = array_aux.length;
						jogador.setPontuacao(contadorVez);
						jogadordao.Salvar(jogador);
						SalvaHistorico();
						contadorVez =0;
					}
					
				}
				
			}
		});
		
		
		btn3.setBackground(new Color(0, 0, 153));
		btn3.setBounds(48, 144, 114, 77);
		contentPane.add(btn3);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlaVezJogador++;
				contadorVez++;
				//array_aux[contadorVez] = "0";
				System.out.println("controle" +controlaVezJogador);
				lista.add(3);
				int test = MaquinaLista.size();
				if(controlaVezJogador == test) {
					vezJogar = 1;
					if(lista.equals(MaquinaLista)) {
						Random gerador = new Random();
						numero = gerador.nextInt(4);
						MaquinaLista.add(numero);
						System.out.println("entrou");
						ControlaVez();
						System.out.println("errou ");
					}else {
						JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						controle.Vida(1);
						int pont = array_aux.length;
						jogador.setPontuacao(contadorVez);
						jogadordao.Salvar(jogador);
						SalvaHistorico();
						contadorVez =0;
					}
					
				}
				
			}
		});
		
		
		btn4.setBackground(new Color(255, 204, 0));
		btn4.setBounds(238, 144, 111, 77);
		contentPane.add(btn4);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contadorVez = 0;
				vezJogar = 1;
				
				ControlaVez();/*
				new Thread(new Runnable() {
		            @Override
		            public void run() {
		            	 for (int i = 0; i < MaquinaLista.size(); i++) {
		            		 System.out.println(MaquinaLista.get(i));
		            	 }
		               
		                try {
		                    Thread.sleep(controle.Dificuldade());
		                   
		                    Thread.sleep(controle.Dificuldade());
		                    for (int i = 0; i < lista.size(); i++) {

		                        if (lista.get(i) == null) {
		                            break;
		                        } else {
		                        	Pisca_Botoes(botoes[(lista.get(i))]);
		                        }
		                        Thread.sleep(controle.Dificuldade());
		                       
		                    }
		                    Thread.sleep(controle.Dificuldade());
		                    
		                } catch (InterruptedException e1) {
		                    // TODO Auto-generated catch block
		                    JOptionPane.showMessageDialog(null, e1.getMessage());
		                }

		            }
		        }).start();*/
				//lista = null;
			}
				
			
		});
		btnNewButton.setBounds(42, 267, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSuaVez.setVisible(false);
				
				System.out.println("");
				System.out.print("Maquina lista");
				for (int i = 0; i < MaquinaLista.size(); i++) {	
           		 System.out.print(MaquinaLista.get(i));
           	 }
				System.out.println("");
				System.out.print("jogador lista");
				for (int i = 0; i < lista.size(); i++) {	
           		 System.out.print(lista.get(i));
           	 }
				
			}
		});
		btnNewButton_1.setBounds(238, 267, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(389, 58, 81, 66);
		contentPane.add(lblNewLabel);
		
		
		lblSuaVez.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblSuaVez.setBounds(22, 232, 140, 24);
		contentPane.add(lblSuaVez);
		
	}
	public void SalvaHistorico() {
		Date data = new Date(System.currentTimeMillis());
		java.util.Date d = new Date();
		

		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		
		
		String testedata = dStr.toString();
		historico.setCod_Dificuldade(2);
		historico.setCod_historico(1);
		historico.setCod_jogador(5);
		historico.setDate(testedata);
		historico.setN_sequencia(contadorVez-1);
		historico.setPontos(contadorVez*2);
		historicodao.Salvar(historico);
		
		
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
            Thread.sleep(controle.Dificuldade());
            }
          //  System.out.println(e.getText().toString());
            e.setBackground(Color.WHITE);
            Thread.sleep(controle.Dificuldade());
            
           // System.out.println(e.getText());
          // controlador.Tocar_Musica(e.getText().toString());
            e.setBackground(c);
            // controlador.Tocar_Musica("Botao 0");
            // Thread.sleep(controlador.getPartida_1().getPISCAR_COR());

        } catch (InterruptedException P) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, P.getMessage());
        }

		
	}

		public void ControlaVez() {
			controlaVezJogador =0;
			
			if (vezJogar == 1) {
				System.out.println("vez Maquina");
				lblSuaVez.setVisible(false);
				
				contadorVez =0;
				if(num == 0) {
					num++;
				Random gerador = new Random();
				numero = gerador.nextInt(4);
				MaquinaLista.add(numero);
				}
				new Thread(new Runnable() {
		            @Override
		            public void run() {
		            	
		            	 for (int i = 0; i < MaquinaLista.size(); i++) {
		            		 System.out.println(MaquinaLista.get(i));
		            	 }
		               
		                try {
		                    Thread.sleep(controle.Dificuldade());
		                   
		                    Thread.sleep(controle.Dificuldade());
		                    for (int i = 0; i < MaquinaLista.size(); i++) {
		                    	
		                        if (MaquinaLista.get(i) == null) {
		                            break;
		                        } else {
		                        	Pisca_Botoes(botoes[(MaquinaLista.get(i))]);
		                        }
		                        Thread.sleep(controle.Dificuldade());
		                       
		                    }
		                    Thread.sleep(controle.Dificuldade());
		                    
		                } catch (InterruptedException e1) {
		                    // TODO Auto-generated catch block
		                    JOptionPane.showMessageDialog(null, e1.getMessage());
		                }
		                
		            }
		        }).start();
				lista.clear();
				vezJogar =2;
				
			}else if(vezJogar ==2){
				System.out.println("Vez Jogador");
				
				lblSuaVez.setVisible(true);
				new Thread(new Runnable() {
		            @Override
		            public void run() {
		            	
		            	 for (int i = 0; i < MaquinaLista.size(); i++) {
		            		 System.out.println(MaquinaLista.get(i));
		            	 }
		               
		                try {
		                	
		                    Thread.sleep(controle.Dificuldade());
		                
		                    Thread.sleep(controle.Dificuldade());
		                    for (int i = 0; i < lista.size(); i++) {

		                        if (lista.get(i) == null) {
		                            break;
		                        } else {
		                           
		                        	Pisca_Botoes(botoes[(lista.get(i))]);
		                        }
		                        Thread.sleep(controle.Dificuldade());
		                       
		                    }
		                    Thread.sleep(controle.Dificuldade());
		                    
		                } catch (InterruptedException e1) {
		                    // TODO Auto-generated catch block
		                    JOptionPane.showMessageDialog(null, e1.getMessage());
		                }

		            }
		        }).start();
				
			}
			
		}
}

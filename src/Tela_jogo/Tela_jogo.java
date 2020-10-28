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
	
	//botoes que demonstro as cores para ser jogado
	private JButton btn1 = new JButton("");
	private JButton btn2 = new JButton("");
	private JButton btn3 = new JButton("");
	private JButton btn4 = new JButton("");
	
	//botoes que demonstro quantas vida o jogador tem
	public static JButton vida1 = new JButton("");
	public static JButton vida2 = new JButton("");
	public static JButton vida3 = new JButton("");
	public static JLabel lblSuaVez = new JLabel("Sua Vez!!");
	String[] array_aux = new String[8];
	JButton[] botoes = {btn1,btn2 , btn3 , btn4};
	ArrayList <Integer> lista = new ArrayList(); //sequencia do jogador
	ArrayList <Integer> MaquinaLista = new ArrayList(); // sequencia da maquina
	ArrayList<Integer> ListaSalvo = new ArrayList();
	
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
	private final JLabel lblJogador = new JLabel("Jogador");
	public static JLabel lblqualjogador = new JLabel("");
	private final JLabel lblqualdificuldade = new JLabel("Dificuldade: ");
	public static JLabel lbldificuldade = new JLabel("");
	public static int CodigoJogador;
	private final JButton btnSalvar = new JButton("Salvar");
	
	
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

		array_aux[0] = "1";
		//jogador.setEmail("Teste@gemail.com");
		//jogador.setIdade("15");
		//jogador.setNome("Tiago");
		//jogador.setCod_jogador(10);
		setBounds(100, 100, 536, 400);
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
				int test = MaquinaLista.size(); // SEQUENCIA NA QUAL A MAQUINA GEROU
				if(controlaVezJogador == test) {
					vezJogar = 1;
					if(lista.equals(MaquinaLista)) {
						Random gerador = new Random(); 
						numero = gerador.nextInt(4);// GERA UM NOVO NUMERO ATÉ O 4
						MaquinaLista.add(numero); // ADICIONA ESSE NUMERO NA SEQUENCIA DA MAQUINA
				
						ControlaVez(); // METEDO Q CONTROLA DE QUEM É A VEZ
					
						
					}else {
						JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						controle.Vida(1,jogador,historico,MaquinaLista,contadorVez,MaquinaLista); // CASO O JOGADOR ERRAR ELE PERDE UMA VIDA
						int pont = array_aux.length;
					//	jogador.setPontuacao(contadorVez);
					//	jogadordao.Salvar(jogador);
						
						//SalvaHistorico();
						contadorVez =0;
						
					}
					
				}
				
				
				
			
				
			}
		});
		

		btn1.setBackground(new Color(0, 100, 0));
		btn1.setBounds(76, 70, 114, 77);
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
						ControlaVez();
						
					}else {
						JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						controle.Vida(1,jogador,historico,MaquinaLista,contadorVez,MaquinaLista);
						int pont = array_aux.length;
						jogador.setPontuacao(contadorVez);
						//jogadordao.Salvar(jogador);
					//	SalvaHistorico();
						contadorVez =0;
					}
					
				}
				
				
			}
		});
		
		
		btn2.setBackground(new Color(153, 0, 0));
		btn2.setBounds(213, 70, 114, 77);
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
						
						ControlaVez();
						
					}else {
						JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						controle.Vida(1,jogador,historico,MaquinaLista,contadorVez,MaquinaLista);
						int pont = array_aux.length;
						//jogador.setPontuacao(contadorVez);
						//jogadordao.Salvar(jogador);
					//	SalvaHistorico();
						contadorVez =0;
					}
					
				}
				
			}
		});
		
		
		btn3.setBackground(new Color(0, 0, 153));
		btn3.setBounds(76, 158, 114, 77);
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
						
						ControlaVez();
					
					}else {
						JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						controle.Vida(1,jogador,historico,MaquinaLista,contadorVez,MaquinaLista);
						int pont = array_aux.length;
						//jogador.setPontuacao(contadorVez);
					//	jogadordao.Salvar(jogador);
					//	SalvaHistorico();
						contadorVez =0;
					}
					
				}
				
			}
		});
		
		
		btn4.setBackground(new Color(255, 204, 0));
		btn4.setBounds(216, 158, 111, 77);
		contentPane.add(btn4);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contadorVez = 0;
				vezJogar = 1;
				//String a = (Integer.toString(CodigoJogador));
				jogador = jogadordao.BuscaJogador(Integer.toString(CodigoJogador));
				ControlaVez(); //metodo que controla de quem é a vez
			}
				
			
		});
		btnNewButton.setBounds(36, 306, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String a = CodigoJogador.toString();
				jogador = jogadordao.BuscaJogador(Integer.toString(CodigoJogador));
				System.out.println(jogador.getCod_jogador());
				System.out.println(jogador.getNome());
				System.out.println(jogador.getIdade());
				System.out.println(jogador.getEmail());
				int t = MaquinaLista.size();
				t = t-1;
				//MaquinaLista.remove(t);
				controle.Salvar(jogador, historico, MaquinaLista,contadorVez);
				
				////MaquinaLista = null;
			/*	vezJogar =1; 
				MaquinaLista = historicodao.LerUtilmaJogada();
			//	historicodao.teste();
				ControlaVez();
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
           	 }*/
				
			}
		});
		btnNewButton_1.setBounds(238, 267, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(389, 58, 81, 66);
		contentPane.add(lblNewLabel);
		
		
		lblSuaVez.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblSuaVez.setBounds(22, 271, 140, 24);
		contentPane.add(lblSuaVez);
		lblJogador.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblJogador.setBounds(80, 16, 82, 31);
		
		contentPane.add(lblJogador);
		lblqualjogador.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblqualjogador.setBounds(157, 15, 111, 33);
		
		contentPane.add(lblqualjogador);
		lblqualdificuldade.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblqualdificuldade.setBounds(251, 15, 90, 33);
		
		contentPane.add(lblqualdificuldade);
		lbldificuldade.setFont(new Font("Verdana", Font.PLAIN, 15));
		lbldificuldade.setBounds(342, 16, 101, 31);
		
		contentPane.add(lbldificuldade);
		
		
		vida1.setBackground(Color.RED);
		vida1.setBounds(238, 318, 24, 23);
		contentPane.add(vida1);
		
		
		vida2.setBackground(Color.RED);
		vida2.setBounds(272, 318, 24, 23);
		contentPane.add(vida2);
		
		
		vida3.setBackground(Color.RED);
		vida3.setBounds(306, 318, 24, 23);
		contentPane.add(vida3);
		
		JLabel lblNewLabel_1 = new JLabel("vidas");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(177, 327, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRepetir = new JButton("Repetir");
		btnRepetir.setBackground(Color.GREEN);
		btnRepetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//lista = null;
				vezJogar =1; 	
				ControlaVez();
			}
		});
		btnRepetir.setBounds(357, 112, 140, 35);
		contentPane.add(btnRepetir);
		
		JButton btnNewButton_2_1 = new JButton("Maior Sequencia");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MaquinaLista = controle.LerMaiorSequencia();
				vezJogar =1; 	
				ControlaVez();
				
			}
		});
		btnNewButton_2_1.setBackground(Color.WHITE);
		btnNewButton_2_1.setBounds(357, 200, 140, 35);
		contentPane.add(btnNewButton_2_1);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t = MaquinaLista.size();
				t = t-1;
				MaquinaLista.remove(t);
				controle.MaiorSequencia(MaquinaLista);
				
				
			}
		});
		btnSalvar.setBounds(381, 294, 89, 23);
		
		contentPane.add(btnSalvar);
		
	}
	public void SalvaHistorico() {
		Date data = new Date(System.currentTimeMillis());
		java.util.Date d = new Date();
		

		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		
		// teste para salvar historico
		String testedata = dStr.toString();
		historico.setCod_Dificuldade(2);
		historico.setCod_historico(1);
		historico.setCod_jogador(5);
		historico.setDate(testedata);
		historico.setN_sequencia(contadorVez-1);
		historico.setPontos(contadorVez*2);
		historicodao.Salvar(historico);
		int t = MaquinaLista.size();
		t = t-1;
		//MaquinaLista.remove(t);
		//historicodao.gravar(MaquinaLista);
		
		
	}
	// metodo que faz os botoes piscar
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
         
            e.setBackground(Color.WHITE);
            Thread.sleep(controle.Dificuldade()); //pega o tempo que o jogador escolheu conforme a dificuldade
    
            e.setBackground(c);

        } catch (InterruptedException P) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, P.getMessage());
        }

		
	}
// metodo que ve de quem é a vez de jogar
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

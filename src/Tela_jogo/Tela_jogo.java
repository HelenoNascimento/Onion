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
import Controler.Pontuacao;
import br.edu.facear.dao.HistoricoDAO;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Historico;
import br.edu.facear.entity.Jogador;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

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
	
	public static JButton btn_start = new JButton("Iniciar");
	
	public static JLabel lblSuaVez = new JLabel("Sua Vez!!");
	
	public static JLabel jg1 = new JLabel("");
	public static JLabel jg2 = new JLabel("");
	public static JLabel jg3 = new JLabel("");
	public static JLabel ptn1 = new JLabel("");
	public static JLabel pnt2 = new JLabel("");
	public static JLabel pnt3 = new JLabel("");
	
	String[] array_aux = new String[8];
	JButton[] botoes = {btn1,btn2 , btn3 , btn4};
	ArrayList <Integer> lista = new ArrayList(); //sequencia do jogador
	ArrayList <Integer> MaquinaLista = new ArrayList(); // sequencia da maquina
	public ArrayList<Integer> ListaSalvo = new ArrayList();
	
	Jogador jogador = new Jogador();
	Historico historico = new Historico ();
	ControleJogo controle = new ControleJogo();
	JogadorDAO jogadordao = new JogadorDAO();
	HistoricoDAO historicodao = new HistoricoDAO();
	Pontuacao pts = new Pontuacao();
	
	//essa variavel é usada para usar o metodo sair
	public static int sair = 0;
	
	public int Continuar = 0;
	int contadorVez = 0;
	int numero;
	int vezJogar = 0;
	int controlaVezJogador = 0;
	int totalVida= 3;
	int num = 0;
	private final JLabel lblJogador = new JLabel("Jogador");
	public static JLabel lblqualjogador = new JLabel("");
	private final JLabel lblqualdificuldade = new JLabel("Dificuldade: ");
	public static JLabel lbldificuldade = new JLabel("");
	public static int CodigoJogador;
	public static String dificuldade;
	public static int reiniciar =0;
	private final JButton btnSalvar = new JButton("Salvar");
	;
	
	String arquivo1 = "/Arquivos/errou2.png";
	String arquivo2 = "/Arquivos/olokomeu.png" ;
	
	 ImageIcon imagem = new ImageIcon(getClass().getResource("/Arquivos/errou2.png"));
	ImageIcon imagem1 = new ImageIcon(getClass().getResource("/Arquivos/trofeu.png"));
	
	 
	public JLabel lblerrou = new JLabel(imagem);
	public JLabel lbltrofeu = new JLabel(imagem1);
	 
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
		//if(Continuar == 1) {
			//MaquinaLista.clear();
	//	//	MaquinaLista = ListaSalvo;
	//		num =1;
	//		Continuar = 0;
	//	}
		
		if(contadorVez >= 5) {
			
		}
		
		lblerrou.setVisible(false);
		array_aux[0] = "1";
		//jogador.setEmail("Teste@gemail.com");
		//jogador.setIdade("15");
		//jogador.setNome("Tiago");
		//jogador.setCod_jogador(10);
		setBounds(100, 100, 948, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				controlaVezJogador++;
				contadorVez++;
				toca();
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
						lblerrou.setVisible(true);
					//	JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						int pont = array_aux.length;
						jogador.setPontuacao(pts.SomaPonto(dificuldade, contadorVez-1));
						controle.Vida(1,jogador,historico,MaquinaLista,contadorVez,MaquinaLista); // CASO O JOGADOR ERRAR ELE PERDE UMA VIDA
						
					//	jogador.setPontuacao(contadorVez);
					//	jogadordao.Salvar(jogador);
						
						//SalvaHistorico();
						contadorVez =0;
					//	if(sair ==1) {
						//	sair();
						//}
						
					}
					
				}
				
				
				
			
				
			}
		});
		

		btn1.setBackground(new Color(50, 205, 50));
		btn1.setBounds(45, 70, 114, 77);
		contentPane.add(btn1);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlaVezJogador++;
				contadorVez++;
				toca();
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
						lblerrou.setVisible(true);
						//JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						int pont = array_aux.length;
						System.out.println("pontuação :"+pts.SomaPonto(dificuldade, pont));
						jogador.setPontuacao(pts.SomaPonto(dificuldade, contadorVez-1));
						controle.Vida(1,jogador,historico,MaquinaLista,contadorVez,MaquinaLista);
						
						//jogadordao.Salvar(jogador);
					//	SalvaHistorico();
						contadorVez =0;
						//if(sair ==1) {
						//	sair();
						//}
					}
					
				}
				
				
			}
		});
		
		
		btn2.setBackground(new Color(255, 0, 0));
		btn2.setBounds(182, 70, 114, 77);
		contentPane.add(btn2);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlaVezJogador++;
				contadorVez++;
				toca();
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
						lblerrou.setVisible(true);
						int pont = array_aux.length;
						System.out.println("pontuação :"+pts.SomaPonto(dificuldade, pont));
						jogador.setPontuacao(pts.SomaPonto(dificuldade, contadorVez-1));
						controle.Vida(1,jogador,historico,MaquinaLista,contadorVez,MaquinaLista);
						//int pont = array_aux.length;
						//jogador.setPontuacao(contadorVez);
						//jogadordao.Salvar(jogador);
					//	SalvaHistorico();
						contadorVez =0;
					//	JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
					//	if(sair ==1) {
						//	sair();
						//}
					}
					
				}
				
			}
		});
		
		
		btn3.setBackground(new Color(0, 0, 255));
		btn3.setBounds(45, 158, 114, 77);
		contentPane.add(btn3);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlaVezJogador++;
				contadorVez++;
				toca();
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
						lblerrou.setVisible(true);
						int pont = array_aux.length;
						System.out.println("pontuação :"+pts.SomaPonto(dificuldade, pont));
						jogador.setPontuacao(pts.SomaPonto(dificuldade, contadorVez-1));
						controle.Vida(1,jogador,historico,MaquinaLista,contadorVez,MaquinaLista);
						//jogador.setPontuacao(contadorVez);
					//	jogadordao.Salvar(jogador);
					//	SalvaHistorico();
						contadorVez =0;
						//JOptionPane.showMessageDialog(null, "Errou", "Errou", JOptionPane.PLAIN_MESSAGE);
						//if(sair ==1) {
							//sair();
					//	}
					}
					
				}
				
			}
		});
		
		
		btn4.setBackground(new Color(255, 255, 0));
		btn4.setBounds(185, 158, 111, 77);
		contentPane.add(btn4);
		
	
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblerrou.setVisible(false);
				if(Continuar == 1) {
				//	MaquinaLista.clear();
					MaquinaLista = ListaSalvo;
					num =1;
					Continuar = 0;
					reiniciar =0;
				}
				
				if(reiniciar == 1) {
					totalVida = controle.Vida(-3,jogador,historico,MaquinaLista,contadorVez,MaquinaLista); // CASO O JOGADOR ERRAR ELE PERDE UMA VIDA
					MaquinaLista.clear();
					lista.clear();
					reiniciar =0;
					num =0;
					if(totalVida ==3) {
						//vida1.setVisible(true);
						//vida2.setVisible(true);
						//vida3.setVisible(true);
					}
					
					//controle.Vida(-3,jogador,historico,MaquinaLista,contadorVez,MaquinaLista); // CASO O JOGADOR ERRAR ELE PERDE UMA VIDA
				}
				contadorVez = 0;
				vezJogar = 1;
				//String a = (Integer.toString(CodigoJogador));
				//jogador = jogadordao.BuscaJogador(Integer.toString(CodigoJogador));
				ControlaVez(); //metodo que controla de quem é a vez
	
			}
				
			
		});
		btn_start.setBounds(22, 306, 140, 35);
		contentPane.add(btn_start);
		
		
		lblSuaVez.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblSuaVez.setBounds(22, 271, 140, 24);
		contentPane.add(lblSuaVez);
		lblJogador.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblJogador.setBounds(45, 12, 82, 31);
		
		contentPane.add(lblJogador);
		lblqualjogador.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblqualjogador.setBounds(122, 11, 111, 33);
		
		contentPane.add(lblqualjogador);
		lblqualdificuldade.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblqualdificuldade.setBounds(216, 11, 90, 33);
		
		contentPane.add(lblqualdificuldade);
		lbldificuldade.setFont(new Font("Verdana", Font.PLAIN, 15));
		lbldificuldade.setBounds(307, 12, 101, 31);
		
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
		btnRepetir.setBounds(359, 342, 140, 35);
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
		btnNewButton_2_1.setBounds(519, 342, 140, 35);
		contentPane.add(btnNewButton_2_1);
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int t = MaquinaLista.size();
				t = t-1;
				MaquinaLista.remove(t);
				controle.MaiorSequencia(MaquinaLista);
				String cod = Integer.toString(jogador.getCod_jogador());
				controle.SalvarJogada(MaquinaLista, cod);
				
				Tela_inicial inicial = new Tela_inicial();
				dispose();
				inicial.setVisible(true);
				
				
			}
		});
		btnSalvar.setBounds(360, 312, 89, 23);
		
		contentPane.add(btnSalvar);
		
		JLabel lbltop3 = new JLabel("TOP 3 JOGADORES");
		lbltop3.setForeground(Color.GREEN);
		lbltop3.setFont(new Font("Verdana", Font.PLAIN, 25));
		lbltop3.setBounds(619, 28, 252, 52);
		contentPane.add(lbltop3);
		
		JLabel lbltop1 = new JLabel("1\u00BA");
		lbltop1.setForeground(Color.BLUE);
		lbltop1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lbltop1.setBounds(626, 132, 46, 14);
		contentPane.add(lbltop1);
		
		JLabel lbltop1_1 = new JLabel("2\u00BA");
		lbltop1_1.setForeground(Color.BLUE);
		lbltop1_1.setFont(new Font("Verdana", Font.PLAIN, 15));
		lbltop1_1.setBounds(626, 168, 46, 14);
		contentPane.add(lbltop1_1);
		
		JLabel lbltop1_2 = new JLabel("3\u00BA");
		lbltop1_2.setForeground(Color.BLUE);
		lbltop1_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		lbltop1_2.setBounds(626, 210, 46, 14);
		contentPane.add(lbltop1_2);
		

		
		jg1.setFont(new Font("Verdana", Font.PLAIN, 15));
		jg1.setBounds(662, 133, 89, 14);
		contentPane.add(jg1);
		
		
		jg2.setFont(new Font("Verdana", Font.PLAIN, 15));
		jg2.setBounds(662, 170, 89, 14);
		contentPane.add(jg2);
		
		
		jg3.setFont(new Font("Verdana", Font.PLAIN, 15));
		jg3.setBounds(662, 210, 89, 14);
		contentPane.add(jg3);
		
		JLabel lbnomes = new JLabel("Nome:");
		lbnomes.setBounds(672, 107, 46, 14);
		contentPane.add(lbnomes);
		
		JLabel lblPontos = new JLabel("Pontos:");
		lblPontos.setBounds(766, 107, 46, 14);
		contentPane.add(lblPontos);
		
		
		ptn1.setFont(new Font("Verdana", Font.PLAIN, 15));
		ptn1.setBounds(761, 132, 73, 14);
		contentPane.add(ptn1);
		
		
		pnt2.setFont(new Font("Verdana", Font.PLAIN, 15));
		pnt2.setBounds(761, 168, 73, 14);
		contentPane.add(pnt2);
		
		
		pnt3.setFont(new Font("Verdana", Font.PLAIN, 15));
		pnt3.setBounds(761, 210, 73, 14);
		contentPane.add(pnt3);
		lblerrou.setBounds(306, 50, 303, 214);
		
		contentPane.add(lblerrou);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sair();
				dispose();
			}
		});
		btnVoltar.setBackground(Color.RED);
		btnVoltar.setFont(new Font("Verdana", Font.BOLD, 15));
		btnVoltar.setBounds(833, 335, 89, 44);
		contentPane.add(btnVoltar);
		lbltrofeu.setBounds(833, 120, 89, 133);
		
		contentPane.add(lbltrofeu);
		
	}
	public void SalvaHistorico() {
		Date data = new Date(System.currentTimeMillis());
		java.util.Date d = new Date();
		

		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		
		// teste para salvar historico
		String testedata = dStr.toString();
		///historico.setCod_Dificuldade(2);
		historico.setCod_historico(1);
		//historico.setCod_jogador(5);
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
		
		public void toca() {
			if (contadorVez ==5) {
				controle.tocarmeu();
			}else if (contadorVez ==10) {
				controle.tocarmeu();
			}
		}
		
		
		
		public void sair() {
			vida1.setVisible(true);
			vida2.setVisible(true);
			vida3.setVisible(true);
			totalVida = 3;
			//Continuar = 0;
			 contadorVez = 0;
			// reiniciar =0;
			 vezJogar = 0;
			 controlaVezJogador = 0;
			 controlaVezJogador = 0;
				//contadorVez = 0;
				MaquinaLista.clear();
				lista.clear();
				ListaSalvo.clear();
				sair = 0;
				//dispose();
				
		}
}

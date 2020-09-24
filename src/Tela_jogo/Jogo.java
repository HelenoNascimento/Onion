package Tela_jogo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Jogo extends JFrame {
	
	ArrayList <Integer> lista = new ArrayList();
	private JPanel contentPane;
	private JTextField txt_num;
	private JTextField txt_acerto;
	private int n=0;
	private int numero=0;
	private int acerto=1;
	public JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_4;
	private int botao;
	 int vetor[]=new int [9];
	 int vetor_botao[]=new int[9];
	 private JButton azul;
	 private JButton amarelo;
	 public JButton vermelho;
	 private JButton verde;
	 private final Action action = new SwingAction();
	 int qntpisca = 0;

	/**
	 * Launch the application.
	 */
	 

	public void btn(){
		
		Random gerador = new Random();
		numero = gerador.nextInt(4);
		txt_num.setText(Integer.toString(numero+1));
		n = Integer.parseInt(txt_num.getText());
		lista.add(n);
		//vetor[cont]=numero;
		
		for(int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i));
			//System.out.println("");
		}
		System.out.println(qntpisca);
		
		//piscapisca();
	}
	public void cor(){
		if(n==1){
			vermelho.setBackground(Color.RED);
			
		}
		 else if(n==2){
			amarelo.setBackground(Color.YELLOW);
		}
		else if(n==3){
			verde.setBackground(Color.GREEN);
		}
		 else if(n==4){
			azul.setBackground(Color.BLUE);
		}
	}
	
	 public void piscapisca() {
		 

					for(int i = 0; i < lista.size(); i++) {
						
						System.out.println("aaa");
				int cor = lista.get(i);
				//System.out.println(lista.get(i));
				//System.out.println("");
				n = cor;
				//Pisca();
				
				try {
					Thread.sleep(3000);
					if(cor==1){
						vermelho.setBackground(null);
						amarelo.setBackground(null);
						verde.setBackground(null);
						azul.setBackground(null);
						vermelho.setBackground(Color.blue);
						
					}
					 else if(cor==2){
						amarelo.setBackground(Color.red);
						
					}
					else if(cor==3){
						verde.setBackground(Color.DARK_GRAY);
						
					}
					 else if(cor==4){
						azul.setBackground(Color.green);
						
						
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			
				
				
			}
				
			
			 
		 }
	    private  void Pisca() {  
	    	 btn();  
	            //btn_1.setBackground( Color.red);
	         //   azul.setBackground(Color.BLUE);
	            //for (int i = 0; i<222; i++) {
	            	
	  	           
	            	
	            	 
	    	 if(n==1){
	    		 
	    		 vermelho.setBackground(Color.RED);
	    		 btn_1.setBackground(Color.RED);
	    		 
	    		 try { 
	    			 
	    			 Thread.sleep (2000); 
	    			 vermelho.setBackground(null);
		    		 btn_1.setBackground(null);
	    		 } catch (InterruptedException ex) {}
	    		 
	    		  

				}
				 else if(n==2){
					amarelo.setBackground(Color.YELLOW);
				}
				else if(n==3){
					verde.setBackground(Color.GREEN);
				}
				 else if(n==4){
					azul.setBackground(Color.BLUE);
					
				}
	    	 
	    	 /*for (int a = 0; a<4; a++) {
         		
        		 btn();
        	 }*/
	            	
	         //  }
	          
	           
	            
	          }
	    
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogo frame = new Jogo();
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
	public Jogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		final JButton btn_1 = new JButton("");
		btn_1.setBackground(Color.red);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(n!=1){
					
					JOptionPane.showMessageDialog(null,"ERROU");
				}
				else {
					
					btn_1.setBackground(null);
					//btn_1.setBackground(Color.yellow);
					/*JOptionPane.showMessageDialog(null,"ACERTOU");*/
					txt_acerto.setText(Integer.toString(acerto));
					acerto++;
					qntpisca++;
					txt_num.setText(null);
					}	
				btn();
				
				cor();
				/*Random gerador = new Random();
				numero = gerador.nextInt(4);
				txt_num.setText(Integer.toString(numero+1));
				n = Integer.parseInt(txt_num.getText());
				if(n==1){
					vermelho.setBackground(Color.RED);
				}
				 else if(n==2){
					amarelo.setBackground(Color.YELLOW);
				}
				else if(n==3){
					verde.setBackground(Color.GREEN);
				}
				 else if(n==4){
					azul.setBackground(Color.BLUE);
				}*/
			}
		});
		btn_1.setBounds(35, 30, 117, 66);
		contentPane.add(btn_1);
		vermelho=btn_1;
		
		final JButton btn_2 = new JButton("");
		btn_2.setBackground(Color.YELLOW);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//n = Integer.parseInt(txt_num.getText());
				if(n!=2){
					JOptionPane.showMessageDialog(null,"ERROU");
				}
				else {
					btn_2.setBackground(null);
					/*JOptionPane.showMessageDialog(null,"ACERTOU");*/
					txt_acerto.setText(Integer.toString(acerto));
					acerto++;
					qntpisca++;
					txt_num.setText(null);
					//piscapisca();
					}
				btn();
				cor();
			}
		});
		btn_2.setBounds(192, 30, 117, 66);
		contentPane.add(btn_2);
		amarelo=btn_2;
		final JButton btn_3 = new JButton("") ;
		btn_3.setBackground(Color.GREEN);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//n = Integer.parseInt(txt_num.getText());
				if(n!=3){
					JOptionPane.showMessageDialog(null,"ERROU");
				}
				else {
					btn_3.setBackground(null);
					/*JOptionPane.showMessageDialog(null,"ACERTOU");*/
					txt_acerto.setText(Integer.toString(acerto));
					acerto++;
					qntpisca++;
					txt_num.setText(null);
					}
				btn();
				cor();
			}
		});
		btn_3.setBounds(35, 109, 117, 66);
		contentPane.add(btn_3);
		verde=btn_3;
		final JButton btn_4 = new JButton("");
		btn_4.setBackground(Color.BLUE);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//n = Integer.parseInt(txt_num.getText());
				if(n!=4){
					JOptionPane.showMessageDialog(null,"ERROU");
				}
				else {
					btn_4.setBackground(null);
					/*JOptionPane.showMessageDialog(null,"ACERTOU");*/
					txt_acerto.setText(Integer.toString(acerto));
					acerto++;
					qntpisca++;
					txt_num.setText(null);
					}
				btn();
				cor();
				/*Random gerador = new Random();
				numero = gerador.nextInt(4);
				txt_num.setText(Integer.toString(numero+1));
				n = Integer.parseInt(txt_num.getText());
				
				if(n==1){
					btn_1.setBackground(Color.RED);
				}
				else if(n==2){
					btn_2.setBackground(Color.YELLOW);
				}
				else if(n==3){
					
					btn_3.setBackground(Color.GREEN);
				}
				else if(n==4){
					btn_4.setBackground(Color.BLUE);
				}*/
			}
		});
		btn_4.setBounds(192, 109, 117, 66);
		contentPane.add(btn_4);
		azul=btn_4;
		txt_num = new JTextField();
		txt_num.setBounds(38, 187, 114, 57);
		contentPane.add(txt_num);
		txt_num.setColumns(10);
		
		JButton btn_iniciar = new JButton("INICIAR");
		btn_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_1.setBackground(null);
				btn_2.setBackground(null);
				btn_3.setBackground(null);
				btn_4.setBackground(null);
				qntpisca = 0;
				btn();
				cor();
				//piscapisca();
				/*vermelho.setBackground(Color.RED);
				try {
					Thread.sleep(1000);
					vermelho.setBackground(Color.yellow);
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				*/
				
				
				
				/*if(n==1){
					btn_1.setBackground(Color.RED);
				}
				else if(n==2){
					btn_2.setBackground(Color.YELLOW);
				}
				else if(n==3){
					
					btn_3.setBackground(Color.GREEN);
				}
				else if(n==4){
					btn_4.setBackground(Color.BLUE);
				}*/
				
				
			}
		});
		btn_iniciar.setBounds(189, 187, 117, 57);
		contentPane.add(btn_iniciar);
		
		JLabel lbl_acerto = new JLabel("ACERTOS");
		lbl_acerto.setBounds(65, 261, 70, 37);
		contentPane.add(lbl_acerto);
		
		txt_acerto = new JTextField();
		txt_acerto.setBounds(192, 262, 114, 35);
		contentPane.add(txt_acerto);
		txt_acerto.setColumns(10);
		
		JButton btn_novo = new JButton("NOVA PARTIDA");
		btn_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_num.setText(null);
				txt_acerto.setText(null);
				btn_1.setBackground(null);
				btn_2.setBackground(null);
				btn_3.setBackground(null);
				btn_4.setBackground(null);
				acerto=1;
			}
		});
		btn_novo.setBounds(70, 320, 159, 64);
		contentPane.add(btn_novo);
		
		JButton btnTeste = new JButton("teste");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_1.setBackground(null);
				btn_2.setBackground(null);
				btn_3.setBackground(null);
				btn_4.setBackground(null);
				//vermelho.setBackground(null);
				Pisca();
			}
		});
		btnTeste.setBounds(75, 341, 89, 23);
		contentPane.add(btnTeste);
		
		JButton btnTeste_1 = new JButton("teste");
		btnTeste_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				piscapisca();
				 

			}
		});
		btnTeste_1.setAction(action);
		btnTeste_1.setBounds(20, 289, 89, 23);
		contentPane.add(btnTeste_1);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

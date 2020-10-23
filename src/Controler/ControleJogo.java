package Controler;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Tela_jogo.Tela_inicial;
import Tela_jogo.Tela_jogo;

public class ControleJogo {
	//Tela_inicial telainicial = new Tela_inicial();
	int pontuacao;
	int pontos;
	private int vidatotal = 3;
	//int dificuldade =1;
	//Tela_inicial telainicial = new Tela_inicial();
	//public String dificuldade;
	public static String dificuldadee;
	//String dificuldade = telainicial.pegaDificuldade();
	//String dificuldade = telainicial.dificu;
	public void pegaDificuldade(String difu) {
		dificuldade = difu;
		System.out.println("entro aqui na difi "+difu);
		
	}
	
	String dificuldade = dificuldadee;
	
			public   int Dificuldade(){
				dificuldade = dificuldadee;
					if (dificuldade == "Facil") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 1000;
						Tela_jogo.lbldificuldade.setText("Facil");
						Tela_jogo.lbldificuldade.setForeground(Color.green);
		
					}else if (dificuldade =="Normal") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 500;
						Tela_jogo.lbldificuldade.setText("Normal");
		
					}else if(dificuldade =="Dificil") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 400;
						Tela_jogo.lbldificuldade.setText("Dificil");
						Tela_jogo.lbldificuldade.setForeground(Color.ORANGE);
						
		
					}else if(dificuldade =="Hardcore") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 250;
						Tela_jogo.lbldificuldade.setText("Hardcore");
						Tela_jogo.lbldificuldade.setForeground(Color.red);
		
					}
		
				return pontuacao;
					}
			// metodo que controla a quantidade de vida
			public int Vida(int vidaRecebida ) {
				
				vidatotal = vidatotal - vidaRecebida;
				System.out.println("total vida "+vidatotal);
				if(vidatotal == 0 ) {
					System.out.println("acabooo");
					JOptionPane.showMessageDialog(null,"aaaa");
					Tela_jogo.lblSuaVez.setVisible(false);
					Tela_jogo.vida1.setVisible(false); // controla as vidas que mostra na tela jogo
					Tela_jogo.vida2.setVisible(false);
					Tela_jogo.vida3.setVisible(false);
					//Tela_jogo.
				}else if(vidatotal == 1) {
					Tela_jogo.vida1.setVisible(false);
					Tela_jogo.vida2.setVisible(false);
					
				}else if(vidatotal == 2) {
					Tela_jogo.vida1.setVisible(false);
				}
				
				
				return vidatotal; // retorna a quantidade de vida que ainda resta
			}
			
			//public void 
			
		}




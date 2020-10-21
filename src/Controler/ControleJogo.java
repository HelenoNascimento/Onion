package Controler;

import javax.swing.JOptionPane;

import Tela_jogo.Tela_inicial;

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
		
					}else if (dificuldade =="Normal") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 500;
		
					}else if(dificuldade =="Dificil") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 400;
		
					}else if(dificuldade =="Hardcore") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 250;
		
					}
		
				return pontuacao;
					}
			
			public int Vida(int vidaRecebida ) {
				
				vidatotal = vidatotal - vidaRecebida;
				System.out.println("total vida "+vidatotal);
				if(vidatotal == 0 ) {
					System.out.println("acabooo");
					JOptionPane.showMessageDialog(null,"aaaa");
					Tela_jogo.Tela_jogo.lblSuaVez.setVisible(false);
					//Tela_jogo.
				}
				return vidatotal;
			}
			
			//public void 
			
		}



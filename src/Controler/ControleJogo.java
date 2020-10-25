package Controler;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tela_jogo.Tela_jogo;
import br.edu.facear.dao.HistoricoDAO;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Historico;
import br.edu.facear.entity.Jogador;

public class ControleJogo {
	
	Jogador jogador = new Jogador();
	JogadorDAO jgdao = new JogadorDAO();
	HistoricoDAO historicodao = new HistoricoDAO();
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
			public void Salvar(Jogador jogador,Historico historico,ArrayList histo) {
				jogador.setPontuacao(200);
				jgdao.Salvar(jogador);
				historicodao.gravar(histo,Integer.toString(jogador.getCod_jogador()));
				historicodao.Salvar(historico);
				
			}
			
			public void MaiorSequencia(ArrayList novasequencia) {
				int sequencianova, antiga;
				sequencianova = novasequencia.size();
				ArrayList sequenciaAntiga = historicodao.PegaMaiorSequencia();
				antiga = sequenciaAntiga.size();
				//maiorsequencia = historicodao.PegaMaiorSequencia();
				
				sequencianova = novasequencia.size();
				if(sequencianova >antiga) {
				historicodao.MaiorSequencia(novasequencia);
				}
				
			}
			
			public ArrayList LerMaiorSequencia(){
				ArrayList maior = new ArrayList();
				maior = historicodao.PegaMaiorSequencia();
				return maior;
			}
		}
	




package Controler;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Tela_jogo.Tela_jogo;
import br.edu.facear.dao.HistoricoDAO;
import br.edu.facear.dao.JogadorDAO;
import br.edu.facear.entity.Historico;
import br.edu.facear.entity.Jogador;

public class ControleJogo {
//ImageIcon imagem = new ImageIcon(getClass().getResource("faustao.png"));
	
	Jogador jogador = new Jogador();
	JogadorDAO jgdao = new JogadorDAO();
	
	
	HistoricoDAO historicodao = new HistoricoDAO();
	ConfiguracaoControle conficotrole = new ConfiguracaoControle();
	ControleJogador controlejg = new ControleJogador();
	
	//Tela_inicial telainicial = new Tela_inicial();
	int pontuacao;
	int pontos;
	int jatoco = 0;
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
		public void limpar() {
			
			Tela_jogo.vida1.setVisible(true);
			Tela_jogo.vida2.setVisible(true);
			Tela_jogo.vida3.setVisible(true);
		//	Tela_jogo.totalVida = 3;
			//Tela_jogo.Continuar = 0;
			//Tela_jogo.contadorVez = 0;
			//Tela_jogo.reiniciar =0;
			//Tela_jogo. vezJogar = 0;
			//Tela_jogo. controlaVezJogador = 0;
			//Tela_jogo. controlaVezJogador = 0;
			//Tela_jogo.	contadorVez = 0;
				//Tela_jogo.MaquinaLista.clear();
				//Tela_jogo.lista.clear();
				///Tela_jogo.ListaSalvo.clear();
				//Tela_jogo.sair = 0;
				//Tela_jogo.dispose();
			
			
		}
	
	
				String dificuldade = dificuldadee;
	
			public   int Dificuldade(){
				dificuldade = dificuldadee;
					if (dificuldade == "Facil") {
						
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 350;
						Tela_jogo.lbldificuldade.setText("Facil");
						Tela_jogo.lbldificuldade.setForeground(Color.green);
						
						
		
					}else if (dificuldade =="Normal") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 300;
						Tela_jogo.lbldificuldade.setText("Normal");
		
					}else if(dificuldade =="Dificil") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 250;
						Tela_jogo.lbldificuldade.setText("Dificil");
						Tela_jogo.lbldificuldade.setForeground(Color.ORANGE);
						
		
					}else if(dificuldade =="Hardcore") {
						System.out.println("dificuldade  "+dificuldadee);
						pontuacao = 1 * 150;
						Tela_jogo.lbldificuldade.setText("Hardcore");
						Tela_jogo.lbldificuldade.setForeground(Color.red);
		
					}
		
				return pontuacao;
					}
			// metodo que controla a quantidade de vida
			public int Vida(int vidaRecebida, Jogador jogador,Historico historico,ArrayList histo,int contadorVez,ArrayList novasequencia) {
				
				vidatotal = vidatotal - vidaRecebida;
				
				if (vidatotal >=3) {
					vidatotal = 3;
				}
				System.out.println("total vida "+vidatotal);
				if(vidatotal == 0 ) {
					tocarErrou();
					System.out.println("acabooo");
					JOptionPane.showMessageDialog(null,"Fim");
					Tela_jogo.lblSuaVez.setVisible(false);
					Tela_jogo.vida1.setVisible(false); // controla as vidas que mostra na tela jogo
					Tela_jogo.vida2.setVisible(false);
					Tela_jogo.vida3.setVisible(false);
					MaiorSequencia(novasequencia);
					Salvar(jogador,historico,histo,contadorVez);
					
					controlejg.listarTop();
					Tela_jogo.btn_start.setText("Jogar Denovo");
					Tela_jogo.reiniciar = 1;
					Tela_jogo.sair = 1;
					//Tela_jogo.
					//Tela_jogo.lblerrou.set
					
				}else if(vidatotal == 1) {
					tocarErrou();
					Tela_jogo.vida1.setVisible(false);
					Tela_jogo.vida2.setVisible(false);
					
					
				}else if(vidatotal == 2) {
					tocarErrou();
					Tela_jogo.vida1.setVisible(false);
					Tela_jogo.btn_start.setText("Continuar");
					
				}else if(vidatotal == 3) {
					tocarErrou();
					Tela_jogo.vida1.setVisible(true); // controla as vidas que mostra na tela jogo
					Tela_jogo.vida2.setVisible(true);
					Tela_jogo.vida3.setVisible(true);
					
				}
				
				
				return vidatotal; // retorna a quantidade de vida que ainda resta
			}
			
			//public void 
			public void Salvar(Jogador jogador,Historico historico,ArrayList histo,int contadorVez) {
				Date data = new Date(System.currentTimeMillis());
				java.util.Date d = new Date();
				

				String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
				
				// teste para salvar historico
				String testedata = dStr.toString();
				//historico.setDificuldade(testedata);
				
				controlejg.SalvaJogadorTop(jogador);
				historico.setCod_historico(conficotrole.PegarCodHistorico());
				if(historico.getCod_historico() <0) {
					historico.setCod_historico(0);
					conficotrole.ControleCodHistorico(0, 0);
				}else {
					conficotrole.ControleCodHistorico(conficotrole.PegarCodHistorico(), 0);
				}
				historico.setNome(jogador.getNome());
				historico.setDate(dStr);
				historico.setDificuldade(dificuldade);
				historico.setN_sequencia(contadorVez-1);
				historico.setPontos(jogador.getPontuacao());

				int t = histo.size();
				t = t-1;
				histo.remove(t);
				
				
				//jogador.setPontuacao(200);
				jgdao.Salvar(jogador);
				jgdao.Cadastrar(jogador);
				historicodao.gravar(histo,Integer.toString(jogador.getCod_jogador()));
				historicodao.Salvar(historico);
				//historicodao.Salvar(historico);
				
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
			public void JogarSemCadastro() {
				
			}
			
			public ArrayList LerMaiorSequencia(){
				ArrayList maior = new ArrayList();
				maior = historicodao.PegaMaiorSequencia();
				return maior;
			}
			
			//metodo que vai na classe ControleJogador e aciona o metodo listar top 3 
			public void listartop3 () {
				
				controlejg.listarTop();
			}
		
			public void SalvarJogada(ArrayList lista, String cod) {
				
				historicodao.gravar(lista, cod);
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			}
			
			public void  tocarErrou(){
				URL url = getClass().getResource("/Arquivos/errou.wav");
				AudioClip audio = Applet.newAudioClip(url);
				audio.play();
				
			}
			
			public void tocarmeu() {
				jatoco++;
				if(jatoco ==1) {
					URL url = getClass().getResource("/Arquivos/porraameu.wav");
					AudioClip audio = Applet.newAudioClip(url);
					audio.play();
				}if(jatoco == 5) {
					URL url = getClass().getResource("/Arquivos/porraameu.wav");
					AudioClip audio = Applet.newAudioClip(url);
					audio.play();
					
				}
				
				
			}
			
		}
	




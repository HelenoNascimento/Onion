package Controler;

import Tela_jogo.Tela_Pontos;
import br.edu.facear.entity.Dificuldade;

public class Pontuacao {
	
	
	
	int pontuacao;
	
	public  int SomaPonto (String dificuldade, int pontos) {
		
		Tela_Pontos.facil.setText("5 pontos");
		Tela_Pontos.normal.setText("10 pontos");
		Tela_Pontos.dificil.setText("15 pontos");
		Tela_Pontos.hardcore.setText("20 pontos");
		
		if (dificuldade.contentEquals("Facil")) {
			pontuacao = 5 * pontos;
			
		}else if (dificuldade.contentEquals("Normal")) {
			pontuacao = 10 * pontos;
			
		}else if(dificuldade.contentEquals("Dificil")) {
			pontuacao = 15 * pontos;
			
		}else if(dificuldade.contentEquals("Hardcore")) {
			pontuacao = 20 * pontos;
			
		}
			
		
		return pontuacao;
		
	}
	
	
	

	
	
	

}

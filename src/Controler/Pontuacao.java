package Controler;

import br.edu.facear.entity.Dificuldade;

public class Pontuacao {
	
	
	
	int pontuacao;
	
	public  int SomaPonto (String dificuldade, int pontos) {
		
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

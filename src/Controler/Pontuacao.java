package Controler;

import br.edu.facear.entity.Dificuldade;

public class Pontuacao {
	
	
	
	int pontuacao;
	
	public  int SomaPonto (int dificuldade, int pontos) {
		
		if (dificuldade == 1) {
			pontuacao = 1 * pontos;
			
		}else if (dificuldade ==2) {
			pontuacao = 2 * pontos;
			
		}else if(dificuldade ==3) {
			pontuacao = 3 * pontos;
			
		}else if(dificuldade ==4) {
			pontuacao = 4 * pontos;
			
		}
			
		
		return pontuacao;
		
	}
	
	
	

	
	
	

}

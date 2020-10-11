package Controler;

public class ControleJogo {
	
	int pontuacao;
	int pontos;
	int dificuldade =1;

	
	
			public   int Dificuldade(){
					if (dificuldade == 1) {
						pontuacao = 1 * 200;
		
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

package Controler;

import br.edu.facear.entity.Dificuldade;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dificuldade df = new Dificuldade();
		Pontuacao pt = new Pontuacao();
		
		
		
		int Dificuldade =  2;
		int Pontos =50;
		int resultado ;
		resultado = pt.SomaPonto(Dificuldade, Pontos);
		
		System.out.println(resultado);

	}

}

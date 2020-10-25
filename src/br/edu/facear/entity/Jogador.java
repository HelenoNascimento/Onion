package br.edu.facear.entity;

import br.edu.facear.dao.JogadorDAO;

public class Jogador {
	

	
	
	private static final Jogador Jogador = null;
	int cod_jogador;
	
	public int getCod_jogador() {
		return cod_jogador;
	}

	@Override
	public String toString() {
		return "Jogador [cod_jogador=" + cod_jogador + ", nome=" + nome + ", idade=" + idade + ", pontuacao="
				+ pontuacao + ", email=" + email + "]";
	}

	public void setCod_jogador(int cod_jogador) {
		this.cod_jogador = cod_jogador;
	}
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	private String idade;

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
		private int pontuacao;

		public int getPontuacao() {
			return pontuacao;
		}

		public void setPontuacao(int pontuacao) {
			this.pontuacao = pontuacao;
		}
		
		private String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
	
		

}

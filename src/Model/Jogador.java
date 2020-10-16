package Model;

import java.io.FileReader; // strem (sequencia) de leitura de caracteres em um arquivo
import java.io.BufferedReader; // � instanciado a partir do filereader implementando otimizacoes utilizando buffer de memoria
import java.io.IOException; // tratar excecoes

public class Jogador {
	public static void main(String[] args) {
		String path = "C:\\Users\\helen\\Documents\\jogador\\teste1.txt";
		BufferedReader br = null; // obj da classe filereader
		FileReader fr = null; // obje da classe bufferedreader
		try {
			fr = new FileReader(path); // caminho do arquivo como argumento
			br = new BufferedReader(fr); 
			String line = br.readLine(); // lendo a linha
			while (line != null) {
				System.out.println(line); // imprimindo a linha
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage()); // mostrando a msg erro caso ocorra
		} finally {
			try { // tratar para verificar a excecao para "fechar" as stream
				if (br != null) // se for nulo "fecha" o objeto
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace(); // 
			}
		}
	}
}
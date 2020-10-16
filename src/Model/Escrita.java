package Model;

import java.io.File;
import java.util.Scanner;

//para listar pastas e arquivos
public class Escrita {

	public static void main(String[] args) {
		
		Scanner obj = new Scanner(System.in);
		System.out.println("Entre com o caminho: ");
		String strPasta = obj.nextLine();
		File caminho = new File(strPasta);
		
		File[] pastas = caminho.listFiles(File::isDirectory); // listando diretorio
	
		System.out.println("Pastas:");
		for (File pasta : pastas) {
			System.out.println(pasta);
		}
		
		File[] arquiuvos = caminho.listFiles(File::isFile); // listando arquivo
		
		System.out.println("Arquivos:");
		
		for (File arquiuvo : arquiuvos) {
			System.out.println(arquiuvo);
		}
		
		boolean successo = new File(strPasta + "\\subpasta").mkdir(); // criando pasta
		System.out.println("Diretorio criado? " + successo);
		obj.close();

	}

}
package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;


public class FileTesteProduct {
	private static void escrever(Produto produto) {
        File dir = new File("C:\\Users\\DevLibbs\\Desktop\\java2024-ds");
        File arq = new File(dir, "Produto.txt");

        try {
            arq.createNewFile();

            FileWriter fileWriter = new FileWriter(arq, false);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(produto.getQuantidade());
            printWriter.println(produto.getNome());
            printWriter.println(produto.getDescricao());
            printWriter.println(produto.getCodigo());
            printWriter.println(produto.getPreco());

            
            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	private static void ler() {
		File dir = new File("C:\\TutorialArquivos");
	    File arq = new File(dir, "Produto.txt");

	    try {     
	        FileReader fileReader = new FileReader(arq);    
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String linha = "";
	        while ( ( linha = bufferedReader.readLine() ) != null) {      
	        System.out.println(linha);
	    }
	        fileReader.close();
	        bufferedReader.close();
		} catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
}

package sistemas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import models.Alimento;
import models.Eletronico;
import models.Produto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = new Produto();
        Alimento alimento = new Alimento();
        Eletronico eletronico = new Eletronico();
        do {
        	System.out.println("Que tipo de produto você deseja adicionar?");
        	System.out.println("1. Produto não especificado");
        	System.out.println("2. Alimento");
        	System.out.println("3. Eletrônico");
        	System.out.println("4. Ler produtos");
        	int tipoProduto = scanner.nextInt();
        	scanner.nextLine();

        	switch (tipoProduto) {
            	case 1:
            		produto.adicionarProdutoGenerico();
            		continue;
            	case 2:
            		alimento.adicionarAlimento();
            		continue;
            	case 3:
            		eletronico.adicionarEletronico();
            		continue;
            	case 4:
            		ler();
            		continue;
            	default:
            		System.out.println("Opção inválida.");
            		break;
        }
        }while (true);
    }
        
    private static void ler() {
        File dir = new File("C:\\Users\\DevLibbs\\Desktop\\java2024-ds");
        File arq = new File(dir, "estoque.txt");

        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
                switch (linha) {
                    case "Alimento":
                        System.out.println("Tipo: Alimento");
                        System.out.println("Código: " + bufferedReader.readLine());
                        System.out.println("Nome: " + bufferedReader.readLine());
                        System.out.println("Descrição: " + bufferedReader.readLine());
                        System.out.println("Quantidade: " + bufferedReader.readLine());
                        System.out.println("Preço: " + bufferedReader.readLine());
                        System.out.println("Data de Validade: " + bufferedReader.readLine());
                        break;
                    case "Eletrônico":
                        System.out.println("Tipo: Eletrônico");
                        System.out.println("Código: " + bufferedReader.readLine());
                        System.out.println("Nome: " + bufferedReader.readLine());
                        System.out.println("Descrição: " + bufferedReader.readLine());
                        System.out.println("Quantidade: " + bufferedReader.readLine());
                        System.out.println("Preço: " + bufferedReader.readLine());
                        System.out.println("Marca: " + bufferedReader.readLine());
                        System.out.println("Modelo: " + bufferedReader.readLine());
                        break;
                    default:
                        System.out.println("Tipo: Produto não especificado");
                        System.out.println("Código: " + linha);
                        System.out.println("Nome: " + bufferedReader.readLine());
                        System.out.println("Descrição: " + bufferedReader.readLine());
                        System.out.println("Quantidade: " + bufferedReader.readLine());
                        System.out.println("Preço: " + bufferedReader.readLine());
                        break;
                }
            }

            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
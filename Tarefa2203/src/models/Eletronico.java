package models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Eletronico extends Produto {
    private String marca;
    private String modelo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + "\nMarca: " + marca + "\nModelo: " + modelo;
    }

    @Override
    public void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco) {
        File dir = new File("C:\\Users\\DevLibbs\\Desktop\\java2024-ds");
        File arq = new File(dir, "estoque.txt");

        try {
            arq.createNewFile();

            FileWriter fileWriter = new FileWriter(arq, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Eletrônico");
            printWriter.println(codigo);
            printWriter.println(nome);
            printWriter.println(descricao);
            printWriter.println(quantidade);
            printWriter.println(preco);
            printWriter.println(marca);
            printWriter.println(modelo);

            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void adicionarEletronico() {
        Eletronico eletronico = new Eletronico();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o código do eletrônico:");
            eletronico.setCodigo(scanner.nextInt());
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao informar o código do eletrônico: " + e.getMessage());
            return;
        }
        try {
            System.out.println("Informe o nome do eletrônico:");
            eletronico.setNome(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao informar o nome do eletrônico: " + e.getMessage());
            return;
        }
        try {
            System.out.println("Informe a descrição do eletrônico:");
            eletronico.setDescricao(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao informar a descrição do eletrônico: " + e.getMessage());
            return;
        }
        try {
            System.out.println("Informe a quantidade do eletrônico:");
            eletronico.setQuantidade(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("Erro ao informar a quantidade do eletrônico: " + e.getMessage());
            return;
        }
    }
}
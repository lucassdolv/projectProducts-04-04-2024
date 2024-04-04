package models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private int quantidade;
    private double preco;

    public Produto() {
    }

    // Getters e Setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // Métodos

    public String exibirDetalhes() {
        return "Código: " + codigo + "\nNome: " + nome + "\nDescrição: " + descricao + "\nQuantidade: " + quantidade
                + "\nPreço: " + preco;
    }

    public void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco) {
        File dir = new File("C:\\Users\\DevLibbs\\Desktop\\java2024-ds");
        File arq = new File(dir, "estoque.txt");

        try {
            arq.createNewFile();

            FileWriter fileWriter = new FileWriter(arq, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(codigo);
            printWriter.println(nome);
            printWriter.println(descricao);
            printWriter.println(quantidade);
            printWriter.println(preco);

            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void adicionarProdutoGenerico() {
        Produto produto = new Produto();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Informe o código do produto:");
            produto.setCodigo(scanner.nextInt());
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao informar o código do produto: " + e.getMessage());
            return;
        }

        try {
            System.out.println("Informe o nome do produto:");
            produto.setNome(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao informar o nome do produto: " + e.getMessage());
            return;
        }

        try {
            System.out.println("Informe a descrição do produto:");
            produto.setDescricao(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao informar a descrição do produto: " + e.getMessage());
            return;
        }

        try {
            System.out.println("Informe a quantidade do produto:");
            produto.setQuantidade(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("Erro ao informar a quantidade do produto: " + e.getMessage());
            return;
        }

        try {
            System.out.println("Informe o preço do produto:");
            produto.setPreco(scanner.nextDouble());
        } catch (Exception e) {
            System.out.println("Erro ao informar o preço do produto: " + e.getMessage());
            return;
        }

        try {
            produto.gravaEstoque(produto.getCodigo(), produto.getNome(), produto.getDescricao(), produto.getQuantidade(),
                    produto.getPreco());
        } catch (Exception e) {
            System.out.println("Erro ao gravar informações do produto: " + e.getMessage());
        }
    }

}

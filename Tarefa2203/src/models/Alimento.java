package models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Alimento extends Produto {
    private LocalDate dataValidade;

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + "\nData de Validade: " + dataValidade;
    }

    @Override
    public void gravaEstoque(int codigo, String nome, String descricao, int quantidade, double preco) {
        File dir = new File("C:\\Users\\DevLibbs\\Desktop\\java2024-ds");
        File arq = new File(dir, "estoque.txt");

        try {
            arq.createNewFile();

            FileWriter fileWriter = new FileWriter(arq, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println("Alimento");
            printWriter.println(codigo);
            printWriter.println(nome);
            printWriter.println(descricao);
            printWriter.println(quantidade);
            printWriter.println(preco);
            printWriter.println(dataValidade);

            printWriter.flush();

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void adicionarAlimento() {
        Alimento alimento = new Alimento();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Informe o código do alimento:");
            alimento.setCodigo(scanner.nextInt());
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao informar o código do alimento: " + e.getMessage());
            return;
        }
        try {
            System.out.println("Informe o nome do alimento:");
            alimento.setNome(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao informar o nome do alimento: " + e.getMessage());
            return;
        }
        try {
            System.out.println("Informe a descrição do alimento:");
            alimento.setDescricao(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Erro ao informar a descrição do alimento: " + e.getMessage());
            return;
        }
        try {
            System.out.println("Informe a quantidade do alimento:");
            alimento.setQuantidade(scanner.nextInt());
        } catch (Exception e) {
            System.out.println("Erro ao informar a quantidade do alimento: " + e.getMessage());
            return;
        }
        try {
            System.out.println("Informe o preço do alimento:");
            alimento.setPreco(scanner.nextDouble());
        } catch (Exception e) {
            System.out.println("Erro ao informar o preço do alimento: " + e.getMessage());
            return;
        }
        try {
            alimento.gravaEstoque(alimento.getCodigo(), alimento.getNome(), alimento.getDescricao(), alimento.getQuantidade(),
                    alimento.getPreco());
        } catch (Exception e) {
            System.out.println("Erro ao gravar informações do alimento: " + e.getMessage());
        }
    }
}
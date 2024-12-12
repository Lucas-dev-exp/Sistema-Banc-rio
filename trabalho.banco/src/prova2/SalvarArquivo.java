package prova2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SalvarArquivo {

    public static void main(String[] args) {
        String conteudo = "Este Ã© o conteÃºdo que serÃ¡ salvo no arquivo.";
        String caminhoArquivo = "arquivo.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write(conteudo);
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar o arquivo.");
            e.printStackTrace();
        }
    }
}
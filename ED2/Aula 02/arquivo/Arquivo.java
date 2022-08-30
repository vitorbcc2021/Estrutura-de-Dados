package arquivo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Arquivo {
    public int[] lerArquivo(String url){
        Path caminho = Paths.get(url); // Vai receber o caminho do arquivo
        String leitura = "";

        try {
            byte[] texto = Files.readAllBytes(caminho); // ira retornar um array de bytes que sera armazenado no array texto
            leitura = new String(texto); // o construtor da classe String aceita um parametro de array do tipo byte

        } catch (Exception e) {
            System.out.println("Não foi possível ler o arquivo!");
        }

        ArrayList<Integer> protoVetor = new ArrayList<>();

        String num = "";

        for(int i=0; i<leitura.length(); i++){
            if(leitura.charAt(i) != '[' && leitura.charAt(i) != ']' && leitura.charAt(i) != ',' && leitura.charAt(i) != ' '){
                num += leitura.charAt(i);
            }
            else{
                if(num != ""){
                    int numero = Integer.parseInt(num);
                    protoVetor.add(numero);
                    num = "";
                }
            }
        }

        int[] vetor = new int[protoVetor.size()];

        for(int i=0; i<protoVetor.size(); i++){
            vetor[i] = protoVetor.get(i);
        }

        return vetor;
    }

    public void gravarArquivo(String url, int[] conteudo){
        Path caminho = Paths.get(url);

        String cabecalho = "Nome do Aluno: Vitor Allace Marques Costa\nVetor Invertido para Testar o Pior Caso:\n\n";

        String vetor = cabecalho + "[";

        for(int i=0; i<conteudo.length; i++){
            vetor += conteudo[i];

            if(i == conteudo.length-1) vetor += "]";
            else{
                vetor += ", ";
            }
        }

        byte[] textoEmBytes = vetor.getBytes(); 

        try{
            Files.write(caminho, textoEmBytes);
        } catch(Exception e){
            System.out.println("Erro!!");
        }
    }

    public void gravarArquivo(String url, String conteudo, String nomeAlg, long tempoExe, long qtdComp, long qtdMov){
        Path caminho = Paths.get(url);
        String texto = conteudo;
        byte[] textoEmBytes = texto.getBytes(); 

        try{
            Files.write(caminho, textoEmBytes);
        } catch(Exception e){
            System.out.println("Erro!!");
        }
    }

    public void gravarArquivo(String url, int[] conteudo, String nomeAlg, long tempoExe, long qtdComp, long qtdMov){
        Path caminho = Paths.get(url);

        int segundos = (int) (tempoExe / 1000) % 60;
        int minutos = segundos / 60;
        int horas = minutos / 60;


        String cabecalho = "Nome do Aluno: Vitor Allace Marques Costa" + "\nNome do algoritmo: " + nomeAlg + "\nTempo de execução: " + horas + ":" + minutos + ":" + segundos + ":" + (tempoExe%1000) + "\nQuantidade de Comparações: " + qtdComp + "\nQuantidade de Movimentos: " + qtdMov + "\n\n";

        
        String vetor = cabecalho + "[";


        for(int i=0; i<conteudo.length; i++){
            vetor += conteudo[i];

            if(i == conteudo.length-1) vetor += "]";
            else{
                vetor += ", ";
            }
        }

        byte[] textoEmBytes = vetor.getBytes(); 

        try{
            Files.write(caminho, textoEmBytes);
        } catch(Exception e){
            System.out.println("Erro!!");
        }
    }
}

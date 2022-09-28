package aula006;

import java.util.Stack;

import arquivo.Arquivo;

public class App {

    private static CountingSort cs;
    private static GnomeSort gs;
    private static RadixSort rs;

    public static void main(String[] args) {
        int[] vetor = Arquivo.lerArquivo("C:/Users/vitor/Desktop/Vitor/4 Periodo/ED2/ArquivosTeste/dados500_mil.txt");

        System.out.println("Inicializando...\n");

        cs = new CountingSort(vetor.clone(), "CountingSort (Caso Medio)");
        gs = new GnomeSort(vetor.clone(), "GnomeSort (Caso Medio)");
        rs = new RadixSort(vetor, "RadixSort (Caso Medio)");
        
        melhorCaso(vetor);
        piorCaso(vetor);
    }

    public static void melhorCaso(int[] vetor){
        cs = new CountingSort(vetor, "CountingSort (Melhor Caso)");
        gs = new GnomeSort(vetor, "GnomeSort (Melhor Caso)");
        rs = new RadixSort(vetor, "RadixSort (Melhor Caso");
    }

    public static void piorCaso(int[] vetor){
        Stack<Integer> pilha = new Stack<>();
        
        for(int valor : vetor) pilha.push(valor);

        for(int i=0; i<vetor.length; i++)
            vetor[i] = pilha.pop();
        
        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula006/arquivos gravados/Desordenado.txt", vetor);

        cs = new CountingSort(vetor.clone(), "CountingSort (Pior Caso)");
        gs = new GnomeSort(vetor.clone(), "GnomeSort (Pior Caso)");
        rs = new RadixSort(vetor.clone(), "RadixSort (Pior Caso");

        System.out.println("Programa Finalizado!!!");
    }
}

package aula004;

import java.util.Stack;

import arquivo.Arquivo;

public class App {
  
    public static QuickSort qs;
    public static MergeSort ms;  
    public static Arquivo arq = new Arquivo();
  
    public static void main(String[] args) {
        int[] vetor1 = arq.lerArquivo("C:/Users/vitor/Desktop/Vitor/4 Periodo/ED2/ArquivosTeste/dados1000.txt");
        int[] vetor2 = vetor1.clone();

        System.out.println("Iniciando...");

        qs = new QuickSort(vetor1, "Quick Sort (Caso Medio)");
        System.out.println("Quick Sort (Caso Medio) Pronto!!");

        ms = new MergeSort(vetor2, "Merge Sort (Caso Medio)");
        System.out.println("Merge Sort (Caso Medio) Pronto!!");

        melhorCaso(vetor1);

        piorCaso(vetor1);

        System.out.println("Programa finalizado!!");
    }

    public static void melhorCaso(int[] vetor){
        qs = new QuickSort(vetor, "Quick Sort (Melhor caso)");
        System.out.println("Melhor Caso Quick Sort Pronto!...");

        ms = new MergeSort(vetor, "Merge Sort (Melhor caso)");
        System.out.println("Melhor Caso Merge Sort Pronto!...");
    }

    public static void piorCaso(int[] vetor){
        Stack<Integer> pilha = new Stack<>();
        Arquivo arq = new Arquivo();

        for(int numero : vetor) pilha.push(numero);

        for(int i=0; i<vetor.length; i++) vetor[i] = pilha.pop();

        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula003/arquivos gravados/Desordenado.txt", vetor);

        qs = new QuickSort(vetor.clone(), "Quick Sort (Pior caso)");
        System.out.println("Pior Caso Quick Sort Pronto!...");

        ms = new MergeSort(vetor.clone(), "Merge Sort (Pior caso)");
        System.out.println("Pior caso Merge Sort Pronto!...");
    }

}

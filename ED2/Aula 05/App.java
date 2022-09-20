package aula005;

import java.util.Stack;
import arquivo.Arquivo;

public class App {
  
    public static HeapSort hs;
  
    public static void main(String[] args) {
        int[] vetor1 = Arquivo.lerArquivo("C:/Users/vitor/Desktop/Vitor/4 Periodo/ED2/ArquivosTeste/dados500_mil.txt");

        System.out.println("Iniciando...");

        hs = new HeapSort(vetor1, "Heap Sort (Caso Medio)");
        System.out.println("Heap Sort (Caso Medio) Pronto!!");

        melhorCaso(vetor1);
        piorCaso(vetor1);

        System.out.println("Programa finalizado!!");
    }

    public static void melhorCaso(int[] vetor){
        hs = new HeapSort(vetor, "Heap Sort (Melhor caso)");
        System.out.println("Melhor Caso Heap Sort Pronto!...");
    }

    public static void piorCaso(int[] vetor){
        Stack<Integer> pilha = new Stack<>();

        for(int numero : vetor) pilha.push(numero);

        for(int i=0; i<vetor.length; i++) vetor[i] = pilha.pop();

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula005/arquivos gravados/Desordenado.txt", vetor);

        hs = new HeapSort(vetor.clone(), "Heap Sort (Pior caso)");
        System.out.println("Pior Caso Heap Sort Pronto!...");
    }

}
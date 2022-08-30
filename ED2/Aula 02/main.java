package aula002;

import java.util.Stack;
import arquivo.Arquivo;

public class Aula002 {
    public static void main(String[] args) {
        Arquivo arq = new Arquivo();

        int[] vetor1 = arq.lerArquivo("C:/Users/vitor/Desktop/Vitor/4 Periodo/ED2/ArquivosTeste/dados100_mil.txt");
        int[] vetor2 = vetor1;

        System.out.println("Iniciando...\n");

        int[] vetor3 = insertionSort(vetor1);
        System.out.println("Insertion Sort Pronto!...");

        selectionSort(vetor2);
        System.out.println("Selection Sort Pronto!...");
        
        piorCaso(vetor3);

        melhorCaso(vetor1);

        System.out.println("\nPrograma Finalizado!");
        
    }

    public static int[] insertionSort(int[] vetor){
        int chave;
        long mov = 0;
        long exec = 0;
        long comp = 0;

        Arquivo arq = new Arquivo();
        
        long tempoInicial = System.currentTimeMillis();

        for(int i=1; i<vetor.length; i++){
            if(vetor.length == 1) arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula002/arquivos gravados/insertionSort.txt", vetor, "Insertion Sort", exec, comp, mov);

            comp++;
            if(vetor[i] < vetor[i-1]){
                chave = vetor[i];

                for(int j=i; j>0; j--){
                    vetor[j] = vetor[j-1];
                    mov++;
                }
                vetor[i] = chave;
            }
        }

        long tempoFinal = System.currentTimeMillis();

        exec = tempoFinal - tempoInicial;

        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula002/arquivos gravados/insertionSort.txt", vetor, "Insertion Sort", exec, comp, mov);

        return vetor;
    }

    

    public static void selectionSort(int[] vetor) {
        int indiceMenor;
        long mov = 0;
        long exec = 0;
        long comp = 0;

        Arquivo arq = new Arquivo();

        long tempoInicial = System.currentTimeMillis();

        for(int i=0; i<vetor.length; i++){
            indiceMenor = i;

            for(int j=i; j<vetor.length; j++){
                comp++;
                if(vetor[j] < vetor[indiceMenor]){
                    indiceMenor = j;
                }
            }

            int x = vetor[i];
            vetor[i] = vetor[indiceMenor];
            vetor[indiceMenor] = x;
            mov++;
        }

        long tempoFinal = System.currentTimeMillis();

        exec = tempoFinal - tempoInicial;

        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula002/arquivos gravados/selectionSort.txt", vetor, "Selection Sort", exec, comp, mov);
    }

    public static void piorCaso(int[] vetor){
        Stack<Integer> pilha = new Stack<>();
        Arquivo arq = new Arquivo();

        for(int numero : vetor) pilha.push(numero);

        for(int i=0; i<vetor.length; i++) vetor[i] = pilha.pop();

        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula002/arquivos gravados/pior caso/piorcaso.txt", vetor);

        insertionSort(vetor);
        System.out.println("Pior Caso Insertion Sort Pronto!...");

        selectionSort(vetor);
        System.out.println("Pior caso Selection Sort Pronto!...");
    }

    public static void melhorCaso(int[] vetor){
        insertionSort(vetor);
        System.out.println("Melhor Caso Insertion Sort Pronto!...");

        selectionSort(vetor);
        System.out.println("Melhor Caso Selection Sort Pronto!...");
    }
}

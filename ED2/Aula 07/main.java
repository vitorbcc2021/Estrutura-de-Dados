package aula007;

import java.util.Stack;

import arquivo.Arquivo;

public class App {

    private static BucketSort bs;
    private static CocktailSort cs;
    private static TimSort ts;

    public static void main(String[] args) {
        int[] vetor = Arquivo.lerArquivo("C:/Users/vitor/Desktop/Vitor/4 Periodo/ED2/ArquivosTeste/dados500_mil.txt");

        System.out.println("Inicializando...\n");

        bs = new BucketSort(vetor.clone(), "BucketSort (Caso Medio)");
        cs = new CocktailSort(vetor.clone(), "CocktailSort (Caso Medio)");
        //ts = new TimSort(vetor, "TimSort (Caso Medio)");
        
        melhorCaso(vetor);
        piorCaso(vetor);
    }

    public static void melhorCaso(int[] vetor){
        bs = new BucketSort(vetor, "BucketSort (Melhor Caso)");
        cs = new CocktailSort(vetor, "CocktailSort (Melhor Caso)");
       // ts = new TimSort(vetor, "TimSort (Melhor Caso)");
    }

    public static void piorCaso(int[] vetor){
        Stack<Integer> pilha = new Stack<>();
        
        for(int valor : vetor) pilha.push(valor);

        for(int i=0; i<vetor.length; i++)
            vetor[i] = pilha.pop();
        
        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula006/arquivos gravados/Desordenado.txt", vetor);

        bs = new BucketSort(vetor.clone(), "BucketSort (Pior Caso)");
        cs = new CocktailSort(vetor.clone(), "CocktailSort (Pior Caso)");
        //ts = new TimSort(vetor.clone(), "TimSort (Pior Caso)");

        System.out.println("Programa Finalizado!!!");
    }
}

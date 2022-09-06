package aula003;

import java.util.Stack;

import arquivo.Arquivo;

public class App {
    public static void main(String[] args) {
        Arquivo arq = new Arquivo();

        int[] vetor1 = arq.lerArquivo("C:/Users/vitor/Desktop/Vitor/4 Periodo/ED2/ArquivosTeste/dados100_mil.txt");

        int[] vetor2 = vetor1.clone();
        int[] vetor3 = vetor1.clone();
        int[] vetor4 = vetor1.clone();

        System.out.println("Iniciando...\n");

        int vetor5[] = bubbleSort(vetor1, "Bubble Sort (Caso Medio)");
        System.out.println("Bubble Sort Pronto!...");

        combSort(vetor2, "Comb Sort (Caso Medio)");
        System.out.println("Comb Sort Pronto!...");
        
        shellSort(vetor3, "Shell Sort (Caso Medio)");
        System.out.println("Shell Sort Pronto!...");

        // Bogo bogo = new Bogo(vetor4, "Bogo Sort");
        // System.out.println("Bogo Sort Pronto!...");

        melhorCaso(vetor5);

        piorCaso(vetor5);

        System.out.println("\nPrograma Finalizado!");
        
    }

    public static int[] bubbleSort(int[] vetor, String nomeArq){
        int chave;
        long comp = 0;
        long mov = 0;

        Arquivo arq = new Arquivo();

        long inicio = System.currentTimeMillis();

        for(int i=1; i<vetor.length; i++){
            for(int j=0; j < vetor.length-i; j++){
                comp++;
                if(vetor[j] > vetor[j+1]){
                    chave = vetor[j];
                    vetor[j] = vetor[j+1];
                    vetor[j+1] = chave;
                    mov+=2; // Dois pq movi o proximo para o anterior e o anterior para o proximo
                }
            }
        }

        long fim = System.currentTimeMillis();

        long tempoExec = fim - inicio;


        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula003/arquivos gravados/"+ nomeArq + ".txt", vetor, "Bubble Sort", tempoExec, comp, mov);

        return vetor;
    }

    public static int[] combSort(int[] vetor, String nomeArq){
        long comp = 0;
        long mov = 0;

        Arquivo arq = new Arquivo();

        long inicio = System.currentTimeMillis();

        int gap = vetor.length;
        boolean houveTrocas = true;
        int aux;

        while(gap >1 || houveTrocas){
            if(gap > 1)
                gap = (int)(gap / 1.3f);
            
            houveTrocas = false;

            for(int i=0; i+gap < vetor.length; i++){
                comp++;
                if(vetor[i] > vetor[i+gap]){
                    aux = vetor[i];
                    vetor[i] = vetor[i+gap];
                    vetor[i+gap] = aux;
                    mov += 2;
                    houveTrocas = true;
                }
            }
        }
        
        long fim = System.currentTimeMillis();
        long tempoExec = fim - inicio;


        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula003/arquivos gravados/"+ nomeArq + ".txt", vetor, "Comb Sort", tempoExec, comp, mov);

        return vetor;
    }

    public static int[] shellSort(int[] vetor, String nomeArq){
        long comp = 0;
        long mov = 0;
        int aux;

        Arquivo arq = new Arquivo();

        long inicio = System.currentTimeMillis();

        for (int i = vetor.length/2; i > 0; i/=2) { //tamanho do gap
            for (int j = i; j < vetor.length; j++) { //percorre do gap até o final
                for (int k = j-i; k >= 0; k-=i) { /*    Basicamente ele nao tem condição de parada,
                                                        decrementação ou incrementação, ele é programado
                                                        para apenas realizar uma troca e voltar para o for(j)
                                                    */
                    comp++;
                    if(vetor[k+i] >= vetor[k]) break;

                    aux = vetor[k];
                    vetor[k] = vetor[k+i];
                    vetor[k+i] = aux;
                    mov+=2;
                }
            }
        }

        long fim = System.currentTimeMillis();

        long tempoExec = fim - inicio;


        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula003/arquivos gravados/"+ nomeArq + ".txt", vetor, "Comb Sort", tempoExec, comp, mov);

        return vetor;
    }

    public static void melhorCaso(int[] vetor){
        bubbleSort(vetor, "Bubble Sort (Melhor caso)");
        System.out.println("Melhor Caso Bubble Sort Pronto!...");

        combSort(vetor, "Comb Sort (Melhor caso)");
        System.out.println("Melhor Caso Comb Sort Pronto!...");

        shellSort(vetor, "Shell Sort (Melhor caso)");
        System.out.println("Melhor Caso Shell Sort Pronto!...");

        // bogoSort(vetor, "Bogo Sort (Mehor caso)");
        // System.out.println("Melhor Caso Bogo Sort Pronto!...");
    }

    public static void piorCaso(int[] vetor){
        Stack<Integer> pilha = new Stack<>();
        Arquivo arq = new Arquivo();

        for(int numero : vetor) pilha.push(numero);

        for(int i=0; i<vetor.length; i++) vetor[i] = pilha.pop();

        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula003/arquivos gravados/Desordenado.txt", vetor);

        bubbleSort(vetor.clone(), "Bubble Sort (Pior caso)");
        System.out.println("Pior Caso Bubble Sort Pronto!...");

        combSort(vetor.clone(), "Comb Sort (Pior caso)");
        System.out.println("Pior caso Comb Sort Pronto!...");

        shellSort(vetor.clone(), "Shell Sort (Pior caso)");
        System.out.println("Pior caso Shell Sort Pronto!...");
    }
    
}

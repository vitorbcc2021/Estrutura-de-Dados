package aula007;

import arquivo.Arquivo;

public class TimSort {
    private static int run = 32;
    private long mov;
    private long comp;

    public TimSort(int[] vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long tempoIni = System.currentTimeMillis();

        timSort(vetor);

        long tempoFim = System.currentTimeMillis();

        long tempoTotal = tempoFim - tempoIni;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula007/arquivos gravados/" + nomeArq + ".txt", vetor, "Tim Sort", tempoTotal, this.comp, this.mov);
    }

    private void timSort(int[] vetor) {

        for (int i = 0; i < vetor.length; i+=run) {

            insertionSort(vetor, i, Math.min((i + 31), (vetor.length-1)));

        }

        for (int size = run; size<vetor.length; size *= 2) {

            for (int esquerda = 0; esquerda < vetor.length; esquerda += 2 * size) {

                int meio = esquerda + size - 1;
                int direita = Math.min((esquerda + 2 * size -1), (vetor.length-1));

                if(meio < direita)
                    merge(vetor, esquerda, meio, direita);
            }
        }
    }

    private void insertionSort(int[] vetor, int comeco, int fim){
        for (int i = comeco+1; i <= fim; i++) {
            int temp = vetor[i];
            int j = i-1;

            while(vetor[j] > temp && j >= comeco){
                vetor[j+1] = vetor[j];
                j--;
                if(j < 0) break;
            }
            vetor[j+1] = temp;
        }
    }

    private void merge(int[] vetor, int comeco, int meio, int fim){
        int alcance1 = meio - comeco + 1;
        int alcance2 = fim - meio;

        int[] esq = new int[alcance1];
        int[] dir = new int[alcance2];

        for(int i=0; i< alcance1; i++){
            esq[i] = vetor[comeco + i];
        }

        for(int i=0; i< alcance2; i++){
            dir[i] = vetor[meio + 1 + i];
        }

        int i=0, j=0, k=1;

        while(i < alcance1 && j < alcance2){
            if(esq[i] <= dir[j]){
                vetor[k] = esq[i];
                i++;
            }
            else{
                vetor[k] = dir[j];
                j++;
            }
            k++;
        }

        while(i < alcance1) {
            vetor[k] = esq[i];
            k++; i++;
        }
        
        while(j < alcance2){
            vetor[k] = dir[j];
            k++; j++;
        }
    }

}

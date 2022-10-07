package aula007;

import java.util.Arrays;

import arquivo.Arquivo;

public class BucketSort {
    
    private long mov;
    private long comp;

    public BucketSort(int[] vetor, String nomeArq) {
        this.mov = 0;
        this.comp = 0;

        long tempoIni = System.currentTimeMillis();

        bucketSort(vetor);

        long tempoFim = System.currentTimeMillis();

        long tempoTotal = tempoFim - tempoIni;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula007/arquivos gravados/" + nomeArq + ".txt", vetor, nomeArq, tempoTotal, this.comp, this.mov);

    }

    private void bucketSort(int[]vetor){
        int maiorValor = Arrays.stream(vetor).max().orElse(Integer.MAX_VALUE);
        int menorValor = Arrays.stream(vetor).min().orElse(0);

        int[] balde = new int[(maiorValor - menorValor) + 1];

        for (int i = 0; i < vetor.length; i++) {
            balde[vetor[i] - menorValor]++;
        }

        int index = 0;

        for (int i = 0; i < balde.length; i++) {
            for (int j = 0; j < balde[i]; j++) {
                vetor[index++] = i + menorValor;
                this.mov++;
            }
        }


    }
    
}

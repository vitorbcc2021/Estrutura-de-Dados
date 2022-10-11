package aula007;

import java.util.Collections;
import java.util.Vector;

import arquivo.Arquivo;

public class BucketSort {
    
    private long mov;
    private long comp;

    public BucketSort(int[] vetor, String nomeArq) {
        this.mov = 0;
        this.comp = 0;

        float[] vetorFloat = convertFloat(vetor);

        long tempoIni = System.currentTimeMillis();

        bucketSort(vetorFloat);

        long tempoFim = System.currentTimeMillis();

        long tempoTotal = tempoFim - tempoIni;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula007/arquivos gravados/" + nomeArq + ".txt", vetor, nomeArq, tempoTotal, this.comp, this.mov);

    }

    private void bucketSort(float[] vetor){
        @SuppressWarnings("unchecked")
        Vector<Float>[] bucket = new Vector[vetor.length];

        for (int i = 0; i < vetor.length; i++) {
            bucket[i] = new Vector<Float>(); //cada posicao do meu vetor vai receber a instancia de um outro vetor
        }

        for (int i = 0; i < vetor.length; i++) {
            float index = vetor[i] * vetor.length;
            bucket[(int)index].add(vetor[i]);
        }

        for (Vector<Float> vector : bucket) {
            Collections.sort(vector);
        }

        int index = 0;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                vetor[index++] = bucket[i].get(j);
            }
        }

    }

    private float[] convertFloat(int[] vetor) {
        int i = 0;

        float[] aux = new float[vetor.length];

        for (int num : vetor) {
            aux[i] = (float) num;
            i++;
        }

        return aux;
    }
    
}

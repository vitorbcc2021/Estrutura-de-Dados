package aula007;

import java.util.Arrays;
import java.util.Vector;

import arquivo.Arquivo;

public class BucketSort {
    
    private long mov;
    private long comp;
    private int maior;
    private int menor;
    private int[] vetor;

    public BucketSort(int[] vetor, String nomeArq) {
        this.mov = 0;
        this.comp = 0;
        this.maior = Arrays.stream(vetor).max().orElse(Integer.MAX_VALUE);
        this.menor = Arrays.stream(vetor).min().orElse(0);
        this.vetor = vetor;

        float[] vetorFloat = convertFloat(vetor); // Nao contei como parte do algoritmo pois estou simulando uma situacao em que de fato um vetor de float seria passado, como o objetivo do exercicio e apenas calcular o tempo de execucao do algoritmo em si, eu tomei a liberdade de retirar algo que nao e do bucket sort pois atrapalharia uma analise real!

        long tempoIni = System.currentTimeMillis();

        bucketSort(vetorFloat);

        long tempoFim = System.currentTimeMillis();

        long tempoTotal = tempoFim - tempoIni;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula007/arquivos gravados/" + nomeArq + ".txt", vetor, nomeArq, tempoTotal, this.comp, this.mov);

    }

    private void bucketSort(float[] vetor){
        //int tam = (this.maior - this.menor) / vetor.length;
        int size = maior - menor + 1;

        @SuppressWarnings("unchecked")
        Vector<Float>[] bucketPositivos = new Vector[size];
        @SuppressWarnings("unchecked")
        Vector<Float>[] bucketNegativos = new Vector[size];

        for (int i = 0; i < size; i++) {
            bucketPositivos[i] = new Vector<Float>(); //cada posicao do meu balde vai receber a instancia de um outro vetor
            bucketNegativos[i] = new Vector<Float>();
        }

        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] >= 0){
                float index = (vetor[i] - this.menor) / size;
                bucketPositivos[(int) index].add(vetor[i]);
            }
            else{
                float index = ((-vetor[i]) - this.menor) / size;
                bucketNegativos[(int) index].add(vetor[i]); 
            }
        }

        for (Vector<Float> vector : bucketPositivos) { // ordena cada um dos vetores do meu balde
            insertionSort(vector);
        }

        for (Vector<Float> vector : bucketNegativos) {
            insertionSort(vector);
        }

        int index = 0;
        for (int i=size-1; i>=0; i--) {
            for (int j = 0; j < bucketNegativos[i].size(); j++) {
                this.vetor[index++] = bucketNegativos[i].get(j).intValue();
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < bucketPositivos[i].size(); j++) {
                this.vetor[index++] = bucketPositivos[i].get(j).intValue();
            }
        }

    }

    private Vector<Float> insertionSort(Vector<Float> vetor) {
        Float chave;
        
        if(vetor.size() == 1) return vetor;

        for(int i=1; i<vetor.size(); i++){
            chave = vetor.get(i);
            int j = i - 1;

            this.comp++;
            while(j>=0 && vetor.get(j) > chave){
                this.comp++;
                vetor.set(j+1, vetor.get(j));;
                this.mov++;
                j--;
            }

            vetor.set(j+1, chave);
            mov++;
        }

        return vetor;
    }

    private float[] convertFloat(int[] vetor) {
        float[] aux = new float[vetor.length];

        for (int i = 0; i < aux.length; i++) {
            aux[i] = (float) vetor[i];
        }

        return aux;
    }

    
    
}

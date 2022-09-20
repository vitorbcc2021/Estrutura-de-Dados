package aula005;

import arquivo.Arquivo;

public class HeapSort {
    private long mov;
    private long comp;

    public HeapSort(int[]vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long inicioProg = System.currentTimeMillis();

        ordenacao(vetor);

        long fimProg = System.currentTimeMillis();

        long tempoExec = fimProg - inicioProg;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula005/arquivos gravados/" + nomeArq + ".txt", vetor, "Heap Sort", tempoExec, comp, mov);

    }

    public void ordenacao(int[] vetor){
        for(int i = (vetor.length/2)-1; i>=0; i--){
            amontoar(vetor, vetor.length, i);
        }

        for(int i = vetor.length-1; i>=0; i--){
            int aux = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;
            this.mov+=2;
            
            amontoar(vetor, i, 0);
        }
    }

    public void amontoar(int[] vetor, int tamanho, int i){
        int maior = i;
        int esquerda = 2*i+1;
        int direita = 2*i+2;

        this.comp+=2;
        if(esquerda < tamanho && vetor[esquerda] > vetor[maior]){
            maior = esquerda;
            this.mov++;
        }
        this.comp+=2;
        if(direita < tamanho && vetor[direita] > vetor[maior]){
            maior = direita;
            this.mov++;
        }

        this.comp++;
        if(maior != i){
            int aux = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = aux;
            this.mov+=2;

            amontoar(vetor, tamanho, maior);
        }
    }

}

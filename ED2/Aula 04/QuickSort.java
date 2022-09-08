package aula004;

import arquivo.Arquivo;

public class QuickSort {
    long mov;
    long comp;

    public QuickSort(int[] vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long inicio = System.currentTimeMillis();

        ordenacao(vetor, 0, (vetor.length-1));

        long fim = System.currentTimeMillis();

        long tempoExec = fim - inicio;

        Arquivo arq = new Arquivo();

        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula004/arquivos gravados/" + nomeArq + ".txt", vetor, "Quick Sort", tempoExec, comp, mov);

    }

    private void ordenacao(int[] vetor, int comeco, int fim){
        comp++;
        if (comeco < fim) {
			int pIndex = particao(vetor, comeco, fim);
			ordenacao(vetor, comeco, pIndex - 1);
			ordenacao(vetor, pIndex + 1, fim);
		}
    }

    private void troca(int vetor[], int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;

        mov+=2;
	}

    private int particao(int vetor[], int comeco, int fim) {
		int pivot = vetor[fim];
		int pIndex = comeco;

		for (int i = comeco; i<fim; i++) {
            comp++;
			if (vetor[i] <= pivot) {
				troca(vetor, i, pIndex);
				pIndex++;
			}
		}
		troca(vetor, pIndex, fim);

		return pIndex;
	}
}

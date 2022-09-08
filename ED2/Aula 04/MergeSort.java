package aula004;

import arquivo.Arquivo;

public class MergeSort {
    long mov;
    long comp;

    public MergeSort(int[] vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long inicio = System.currentTimeMillis();

        mergeSort(vetor);

        long fim = System.currentTimeMillis();

        long tempoExe = fim - inicio;

        Arquivo arq = new Arquivo();

        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula004/arquivos gravados/" + nomeArq + ".txt", vetor, "Merge Sort", tempoExe, comp, mov);
    }

    private void mergeSort(int[] vetor) {
		ordenacao(vetor, 0, vetor.length - 1);
	}

	private void ordenacao(int[] vetor, int comeco, int fim) {
		int meio = (comeco + fim) / 2;

        comp++;
		if (comeco < fim) {
			ordenacao(vetor, comeco, meio);
			ordenacao(vetor, meio + 1, fim);
		}
		
        int i = 0;
        int primeiro = comeco;
        int ultimo = meio + 1;
		int[] tmp = new int[fim - comeco + 1];

        comp+=2; //entrada do while
		while (primeiro <= meio && ultimo <= fim) {
            comp+=2; //toda vez que o while se repetir
            
            comp++;
			tmp[i++] = vetor[primeiro] < vetor[ultimo] ? vetor[primeiro++] : vetor[ultimo++];
		}

        comp++;
		while (primeiro <= meio) {
            comp++;

			tmp[i++] = vetor[primeiro++];
            mov++;
		}
        
        comp++;
		while (ultimo <= fim) {
            comp++;

			tmp[i++] = vetor[ultimo++];
            mov++;
		}

		i = 0;

        comp++;
		while (comeco <= fim) {
            comp++;

			vetor[comeco++] = tmp[i++];
            mov++;
		}
	}
}

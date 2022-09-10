package aula004;

import arquivo.Arquivo;

public class QuickSort {
    long mov;
    long comp;

    public QuickSort(int[] vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long inicio = System.currentTimeMillis();

        ordenacao(vetor, 0, vetor.length-1);

        long fim = System.currentTimeMillis();

        long tempoExec = fim - inicio;

        Arquivo arq = new Arquivo();

        arq.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula004/arquivos gravados/" + nomeArq + ".txt", vetor, "Quick Sort", tempoExec, comp, mov);

    }

    private void ordenacao(int[] vetor, int lEsquerdo, int lDireito){
        comp++;
        if (lEsquerdo < lDireito) {
			int indicePivot = separacao(vetor, lEsquerdo, lDireito);/*  Pega o pivot, separa todos os elementos 
                                                                        menores que ele na esquerda e os maiores que ele na direita, após isso ele retorna o índice do pivot    */
            try{
                ordenacao(vetor, lEsquerdo, indicePivot);/* ira separar todo o lado esquerdo
                                                            do pivot em partes menores  */

                ordenacao(vetor, indicePivot + 1, lDireito);/*  ira ordenar todo o lado direito do pivot*/
            }
            catch(StackOverflowError so){
                System.out.print("");
            }
		}
    }

    private void troca(int[] vetor, int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;

        mov+=2;
	}

    private int separacao(int[] vetor, int lEsquerdo, int lDireito) {
        int meio = (int) (lEsquerdo + lDireito) / 2;
        int pivot = vetor[meio];
        int i = lEsquerdo-1;
        int j = lDireito+1;

        while(true){
            do {
                i++;
                comp++;
            } while (vetor[i] < pivot);
            
            do {
                j--;
                comp++;
            } while (vetor[j] > pivot);

            comp++;
            if(i >= j) return j;

            troca(vetor, i, j);
        }
    }
}

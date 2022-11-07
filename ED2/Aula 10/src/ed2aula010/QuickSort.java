package ed2aula010;

public class QuickSort {

    public QuickSort(int[] vetor){
        ordenacao(vetor, 0, vetor.length-1);
    }

    private void ordenacao(int[] vetor, int lEsquerdo, int lDireito){
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
	}

    private int separacao(int[] vetor, int lEsquerdo, int lDireito) {
        int meio = (int) (lEsquerdo + lDireito) / 2;
        int pivot = vetor[meio];
        int i = lEsquerdo-1;
        int j = lDireito+1;

        while(true){
            do {
                i++;
            } while (vetor[i] < pivot);
            
            do {
                j--;
            } while (vetor[j] > pivot);

            if(i >= j) return j;

            troca(vetor, i, j);
        }
    }
}

package aula007;

import arquivo.Arquivo;

public class CocktailSort {

    private long mov;
    private long comp;

    public CocktailSort(int[] vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long tempoIni = System.currentTimeMillis();

        cocktailSort(vetor);

        long tempoFim = System.currentTimeMillis();

        long tempoTotal = tempoFim - tempoIni;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula007/arquivos gravados/" + nomeArq + ".txt", vetor, nomeArq, tempoTotal, this.comp, this.mov);
    }

    private void cocktailSort(int[] vetor){

        boolean trocado = true;

        int inicio = 0;
        int fim = vetor.length-1;

        while(trocado){
            trocado = false;

            for(int i=inicio; i<fim; i++){
                this.comp++;
                if(vetor[i] > vetor[i+1]){
                    troca(vetor, i, i+1);
                    this.mov+=2;
                    trocado = true;
                }
            }

            if(!trocado) break;

            trocado = false;

            fim--;

            for (int i=fim-1; i>=inicio; i--) {
                this.comp++;
                if(vetor[i] > vetor[i+1]){
                    troca(vetor, i, i+1);
                    this.mov+=2;
                    trocado = true;
                }
            }

            inicio++;
        }
    }

    private void troca(int[] vetor, int x, int y){
        int aux = vetor[x];
        vetor[x] = vetor[y];
        vetor[y] = aux;
    }
}

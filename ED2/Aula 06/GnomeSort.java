package aula006;

import arquivo.Arquivo;

public class GnomeSort {
    private long mov;
    private long comp;

    public GnomeSort(int[] vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long tempoIni = System.currentTimeMillis();

        ordenacao(vetor);

        long tempoFinal = System.currentTimeMillis();

        long tempoExec = tempoFinal - tempoIni;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula006/arquivos gravados/" + nomeArq + ".txt", vetor, "Gnome Sort", tempoExec, this.comp, this.mov);
    } 

    private void ordenacao(int[] vetor){
        if(vetor.length > 1){

            for(int i=1; i<vetor.length; i++){
                this.comp++;
                if(vetor[i] < vetor[i-1]){

                    for(int j=i; j>0; j--){
                        this.comp++;
                        if(vetor[j] < vetor[j-1]){
                            troca(vetor, j, j-1);
                            this.mov += 2;
                        }
                        else{
                            break;
                        }
                    }   
                }
            }
        }
    }

    private void troca(int[] vetor, int a, int b){
        int aux = vetor[a];
        vetor[a] = vetor[b];
        vetor[b] = aux;
    }
}

package aula006;

import java.util.Arrays;

import arquivo.Arquivo;

public class CountingSort {
    private long mov;
    private long comp;
    
    public CountingSort(int[] vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long tempoIni = System.currentTimeMillis();

        ordenacao(vetor);

        long tempoFinal = System.currentTimeMillis();

        long tempoExec = tempoFinal - tempoIni;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula006/arquivos gravados/" + nomeArq + ".txt", vetor, "Counting Sort", tempoExec, this.comp, this.mov);

    }

    private void ordenacao(int[] vetor){
        int menorElemento = Arrays.stream(vetor).min().orElse(0); //vai percorrer todo o array caçando o menor elemento
        int maiorElemento = Arrays.stream(vetor).max().orElse(Integer.MAX_VALUE); //vai percorrer todo o array caçando o maior elemento

        int[] aux = new int[maiorElemento - menorElemento +1];

        for(int valor : vetor){    //vai incrementar as posições equivalentes aos elementos de vetor de acordo com a quantidade de ocorrencias daquele elemento no vetor
            aux[valor - menorElemento]++;
        }

        int indiceDoArray = 0; // sera utilizado para percorrer o vetor

        for(int i=0; i<aux.length; i++){   //irá percorrer todo o vetor auxiliar
            while(aux[i] > 0){ //enquanto o elemento de aux for maior que zero ele ira percorrer todo o vetor e atribuir i(que sera um valor mt grande) somado com o menor(que sera negativo), e ira colocar todos os elementos repetidos um na frente do outro até acabar a quantidade daquele elemento(zerar), e ele podera partir para o proximo elemento de aux! 
                vetor[indiceDoArray] = i + menorElemento;
                aux[i]--; // vai decrementar a quantidade de um elemento
                this.mov++;
                indiceDoArray++;
            }
        }
    }
}

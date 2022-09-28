package aula006;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import arquivo.Arquivo;

public class RadixSort {
    private long mov;
    private long comp;

    public RadixSort(int[] vetor, String nomeArq){
        this.mov = 0;
        this.comp = 0;

        long tempoIni = System.currentTimeMillis();

        sort(vetor);
        
        long tempoFinal = System.currentTimeMillis();

        long tempoExec = tempoFinal - tempoIni;

        Arquivo.gravarArquivo("C:/Users/vitor/Documents/Visual Studio Code/IFGOIANO/ED2/Aula006/arquivos gravados/" + nomeArq + ".txt", vetor, "Radix Sort", tempoExec, this.comp, this.mov);
    }

    private void sort(int[] vetor){
        Map<Boolean, List<Integer>> divideVetor = Arrays.stream(vetor).boxed().collect(Collectors.partitioningBy(i -> i<0));

        //vai ordenar os negativosInteiros com o radix sort, mas antes, o metodo abs coloca todos os valores como positivos, em seguida o radix sort ira os ordenar do menor positivo para o maior positivo
        int[] negativosInteiros = radixSort(divideVetor.get(true).stream().mapToInt(Integer::intValue).map(Math::abs).toArray());

        //radixsort ira ordenar todos os positivos, repare que desta vez nao usei o metodo abs pois nao ha necessidade
        int[] positivosInteiros = radixSort(divideVetor.get(false).stream().mapToInt(Integer::intValue).toArray());

        //vai pegar todos os valores positivos que foram ordenados de 'negativosInteiros', e transformá-los devolta em negativos, como o 'negativosInteiros' ja estava ordenado, basta percorre-lo de tras para frente para que fique ordenado no 'vetor'
        for(int i = negativosInteiros.length-1, j=0; i>=0; i--, j++){
            mov++;
            vetor[j] = -negativosInteiros[i];
        }

        //agora basta colocar os positivos no vetor certo?? :)
        //colocaremos os positivos atraves do metodo 'System.arraycopy'
        
        //vai copiar do positivosInteiros comecando em 0 para o vetor, iniciando no tamanho final dos negativos inteiros
        for(int i=negativosInteiros.length, j=0; i<vetor.length; i++, j++){
            this.mov++;
            vetor[i] = positivosInteiros[j];
        }
    }

    private int[] radixSort(int[] vetor){
        int maior = Arrays.stream(vetor).max().orElse(Integer.MAX_VALUE);

        for(int divisor=1; maior/divisor > 0; divisor*=10){ //este for e responsavel nao so por repetir o counting sort a quantidade de vezes que e necessario, mas tambem por sempre incrementar o divisor o quanto for necessario
            CountingSort(vetor, divisor);
        }

        return vetor;
    }

    private void CountingSort(int[] vetor, int divisor){

        int[] aux = new int[10]; //vai criar um vetor do tamanho 10, assim, para cada digito que compoe aquele valor, ira ser somado 1, seguindo a logica LSD(Last Signifficant Digit)

        for (int valor : vetor) {
            aux[(valor/divisor) % 10]++; //a posicao de cada digito que compoe os varios valores de 'vetor' ira ser incrementada, comecando no ultimo digito que compoe aquele valor, ate o primeiro digito que compoe aquele valor
        }

        for(int i=1; i<10; i++){ //aplica counting sort para somar a posicao atual com a proxima! Obs: este for so vai ate dez pois tem o alcance de 0 ate 9, assim, mantendo a ideia de usar aqueles numeros como indices igual ao counting sort, porem, armazenando de forma ordenada do ultimo digito para o primeiro, devido ao padrao LSD
            aux[i] += aux[i-1];
        }

        int[] vetorFinal = new int[vetor.length];


        for(int i=vetor.length-1; i>=0; i--){ // Percorrendo do final para o começo igual ao countingsort...
            int atual = vetor[i];
            int posicao = aux[(atual/divisor) % 10] - 1; // ira pegar o ultimo digito de um numero armazenado naquela posicao do vetor
            vetorFinal[posicao] = atual; //recebe o elemento do vetor de forma direta
            aux[(atual/divisor) % 10]--;
            mov++;
        }
        //ao final deste for, o vetor estara ordenado de modo que todos os ultimos digitos dele estejam em ordem crescente.....

        //ira salvar todo o progresso no 'vetor'
        //System.arraycopy(vetorFinal, 0, vetor, 0, vetor.length);
        
        for(int i=0, j=0; i<vetor.length; i++, j++){
            this.mov++;
            vetor[i] = vetorFinal[j];
        }
    }
}

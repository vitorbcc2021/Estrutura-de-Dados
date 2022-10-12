package aula007;

import java.util.Vector;

public class TimVector {
    private int run = 32;
    private long mov;
    private long comp;

    public TimVector(){
        this.mov = 0;
        this.comp = 0;
    }

    public void ordene(Vector<Float> vetor) {

        for (int i = 0; i < vetor.size(); i+=run) {

            insertionSort(vetor, i, Math.min((i + 31), (vetor.size()-1)));

        }

        for (int size = run; size<vetor.size(); size *= 2) {

            for (int esquerda = 0; esquerda < vetor.size(); esquerda += 2 * size) {

                int meio = esquerda + size - 1;
                int direita = Math.min((esquerda + 2 * size -1), (vetor.size()-1));

                if(meio < direita)
                    merge(vetor, esquerda, meio, direita);
            }
        }
    }

    private void insertionSort(Vector<Float> vetor, int comeco, int fim){
        for (int i = comeco+1; i <= fim; i++) {
            Float temp = vetor.get(i);
            int j = i-1;

            comp++;
            while(vetor.get(j) > temp && j >= comeco){
                comp++;

                mov++;
                vetor.set(j+1, vetor.get(j));
                j--;
                if(j < 0) break;
            }

            mov++;
            vetor.set(j+1, temp);
        }
    }

    private void merge(Vector<Float> vetor, int comeco, int meio, int fim){
        int alcance1 = meio - comeco + 1;
        int alcance2 = fim - meio;

        Float[] esq = new Float[alcance1];
        Float[] dir = new Float[alcance2];

        for(int i=0; i<alcance1; i++){
            mov++;
            esq[i] = vetor.get(comeco + i);
        }

        for(int i=0; i< alcance2; i++){
            mov++;
            dir[i] = vetor.get(meio + 1 + i);
        }

        int i=0, j=0, k=comeco;

        while(i < alcance1 && j < alcance2){
            comp++;
            if(esq[i] <= dir[j]){
                mov++;
                vetor.set(k, esq[i]);
                i++;
            }
            else{
                mov++;
                vetor.set(k, dir[j]);
                j++;
            }
            k++;
        }

        while(i < alcance1) {
            mov++;
            vetor.set(k, esq[i]);
            k++;
            i++;
        }
        
        while(j < alcance2){
            mov++;
            vetor.set(k, dir[j]);
            k++;
            j++;
        }
    }

    public long getMov() {
        return mov;
    }

    public long getComp() {
        return comp;
    }

    public void setMov(long mov) {
        this.mov = mov;
    }

    public void setComp(long comp) {
        this.comp = comp;
    }
    
    
}

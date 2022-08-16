package ed1dozedois;

import java.util.Arrays;
import java.util.Random;

public class Ed1DozeDois {
    public static void main(String[] args) {
        Random rdm = new Random();
        int vetor[] = new int[1000];
        
        for(int i=0; i<1000; i++){
            int aleatorio = rdm.nextInt(-9999, 9999);
            vetor[i] = aleatorio;
            System.out.println("Posicao " + i + " recebe: " + aleatorio);
        }
        
        Lista lista = new Lista();
        
        Arrays.sort(vetor);
        
        for(int i=0; i<1000; i++){
            lista.adiciona(vetor[i]);
        }
        
        System.out.println(lista.imprimirDecrescente());
        
    }

}

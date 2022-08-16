package ed1dezsete;

import java.util.Random;

public class Ed1DezSete {
    public static void main(String[] args) {
        Fila fila = new Fila();
        Random rdm = new Random();
        Fila filaInvertida = new Fila();
        
        //Construindo a fila
        for(int i=0; i<20; i++){
            fila.push(rdm.nextInt());
        }
        
        //Imprimindo a fila antes de ser invertida
        System.out.println("Fila antes de ser invertida:");
        while(!fila.empty()){
            filaInvertida.push(fila.peek());
            System.out.println(fila.pop());
        }
        
        filaInvertida.inverterFila();
        
        System.out.println("\nFila Invertida:");
        while(!filaInvertida.empty()){
            System.out.println(filaInvertida.pop());
        }
    }

}

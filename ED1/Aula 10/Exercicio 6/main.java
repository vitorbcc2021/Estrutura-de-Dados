package ed1dezseis;

import java.util.Random;
import java.util.Stack;

public class Ed1DezSeis {
    public static void main(String[] args) {
        Fila fila = new Fila();
        Stack<Integer> pilha = new Stack<>();
        Random rdm = new Random();
        
        int i=0;
        
        //Coloca os 1000 positivos na fila
        while(i<1000){
            int numAleatorio = rdm.nextInt();
            if(numAleatorio >= 0){
                fila.push(numAleatorio);
                i++;
            }
        }
        
        i=0;
        
        //Coloca os 1000 negativos na fila
        while(i<1000){
            int numAleatorio = rdm.nextInt();
            if(numAleatorio < 0){
                fila.push(numAleatorio);
                i++;
            }
        }
        
        i=0;
        
        while(!fila.empty()){
            if(fila.peek() > 0){
                pilha.push(fila.pop());
            }
            else{
                System.out.println(i + ". " + pilha.pop());
                i++;
                fila.pop();
            }
            
        }
    }

}

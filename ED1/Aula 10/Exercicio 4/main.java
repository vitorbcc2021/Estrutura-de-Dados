package ed1dezquatro;

import java.util.Random;
import java.util.Stack;

public class Ed1DezQuatro {
    public static void main(String[] args) {
        Fila F1 = new Fila();
        Stack<Integer> pilha = new Stack<>();
        Fila F2 = new Fila();
        
        Random random = new Random();
        
        byte i=0;
        
        while(F1.tamanhoFila() < 100){
            F1.push(random.nextInt(100)); 
        }
        
        while(!F1.empty()){
            pilha.push(F1.pop());
            F2.push(pilha.pop());
        }
        
        while(!F2.empty()){
            System.out.println(i + ". "+ F2.pop());
            i++;
        }
    }
}

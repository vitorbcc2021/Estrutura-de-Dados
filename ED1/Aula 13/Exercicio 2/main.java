package ed1trezedois;

import java.util.Random;

public class Ed1TrezeDois {
    public static void main(String[] args) {
        Random rdm = new Random();
        
        PilhaDinamica pilhaPar = new PilhaDinamica();
        PilhaDinamica pilhaImpar = new PilhaDinamica();
        
        while(true){
            int numAleatorio = rdm.nextInt(-127, 129);
            
            if(numAleatorio == 0){
                break;
            }
            else if((numAleatorio % 2) == 0){
                System.out.println(numAleatorio + " e par!!");
                pilhaPar.push(numAleatorio);
            }
            else{
                System.out.println(numAleatorio + " e impar!!");
                pilhaImpar.push(numAleatorio);
            }
        }
        
        while(true){
            pilhaImpar.pop();
            pilhaPar.pop();
            
            if(pilhaImpar.isEmpty()) break;
            if(pilhaPar.isEmpty()) break;
        }
        
        if(!pilhaPar.isEmpty()){
            System.out.println("\nA pilha Par ainda possui " + pilhaPar.sizePilha() +" elementos!");
            System.out.println("\nAinda falta retirar os elementos:\n");
            pilhaPar.imprimir();
        }
        
        if(!pilhaImpar.isEmpty()){
            System.out.println("\nA pilha Impar ainda possui " + pilhaImpar.sizePilha() + " elementos!");
            System.out.println("\nAinda falta retirar os elementos:\n");
            pilhaImpar.imprimir();
        }

    }

}

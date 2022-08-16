package ed1dezcinco;

import java.util.Random;
import java.util.Stack;

public class Ed1DezCinco {
    public static void main(String[] args) {
        Stack<Integer> pilhaP = new Stack<>();
        Fila filaF = new Fila();
        
        Random rdm = new Random();
        
        int i = 0;
        while(i<1000){
            int numAleatorio = rdm.nextInt();
            if(!filaF.procurarNaFila(numAleatorio)){
                filaF.push(numAleatorio);
            }
            else{
                pilhaP.push(numAleatorio);  /*Obs: Por serem números totalmente aleatorios sem nenhum limite,
                                                   as chances de repetir um número são extremamente baixas, portanto,
                                                   para forçar que a pilha P receba valores, o ideal seria limitar a
                                                   quantidade de numeros aleatorios que poderiam ser gerados, mas como
                                                   o exercicio nao pediu para que os mesmos fossem limitados eu nao os limitei*/
            }
            
            i++;
        }
        
        i=0;
        System.out.println("FILA F:");
        while(!filaF.empty()){
            System.out.println(i + ". " + filaF.pop());
            i++;
        }
        
        i=0;
        System.out.println("\nPILHA P:");
        while(!pilhaP.empty()){
            System.out.println(i + ". " + pilhaP.pop());
            i++;
        }
    }

}

package ex001;

import java.util.Stack;
public class App {
    public static void main(String[] args) {
        Stack<Integer> pilhaPar = new Stack<>();
        Stack<Integer> pilhaImpar = new Stack<>();

        int i=1;

        while(i<=20){
            pilhaImpar.push(i);
            i++;
            pilhaPar.push(i);
            i++;
        }

        int[] vetor = pilhasVetor(pilhaPar, pilhaImpar);

        for(i=0; i<vetor.length; i++){
            System.out.println("Posicao " + i + " : " + vetor[i]);
        }

    }

    public static int[] pilhasVetor(Stack<Integer> pilha1, Stack<Integer> pilha2) {
        int[] vetor = new int[pilha1.size() + pilha2.size()];
        int i=0;

        while(!pilha1.empty()){
            vetor[i] = pilha1.pop();
            i++;
        }

        while(!pilha2.empty()){
            vetor[i] = pilha2.pop();
            i++;
        }

        return vetor;
    }
}

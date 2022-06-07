package javaapplication63;

import java.util.Scanner;
import java.util.Stack;

public class JavaApplication63 {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<String>();
        Stack<String> pilha2 = new Stack<String>();
        Stack<String> pilha3 = new Stack<String>();
        
        Scanner sc = new Scanner(System.in);
        
        pilha.push("carro");
        pilha.push("moto");
        pilha.push("camionete");
        pilha.push("caminhao");
        pilha.push("lancha");
        pilha.push("bicicleta");
        pilha.push("barco");
        
        while(!pilha.empty()){
            pilha2.push(pilha.peek());
            pilha3.push(pilha.pop());
        }
        
        //o exercício nao deixou claro oq seria esta chave c
        //ele também não disse de qual tipo deveria ser esta pilha
        //também não foi pedido que o usuário digitasse os valores da pilha
        
        System.out.println("Digite o elemento que deseja remover: ");
        String chaveC = sc.nextLine();
        
        System.out.println("\nPilha antes de remover o elemento: ");
        while(!pilha2.empty()){
            System.out.print(pilha2.pop() + ' ');
        }
        System.out.println();
        
        System.out.println("\nPilha depois de remover o elemento: ");
        while(!pilha3.empty()){
            if(pilha3.peek().equals(chaveC)){
                pilha3.pop();
            } else{
                System.out.print(pilha3.pop() + ' ');
            }
            
        }
        System.out.println();
    }

}

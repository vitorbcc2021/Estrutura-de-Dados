package editresum;

import java.util.Stack;
import java.util.Scanner;

public class EdiTresUm {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Insira a frase que gostaria de inverter as palavras:");
        
	String frase = sc.nextLine();
        
	System.out.println("\nFrase antes de ser invertida:\n" + frase);
        
	Stack<Character> pilhaCaracteres = new Stack<Character>();
        
	for (int i = 0; i < frase.length(); i++){ //este for só vai transformar a String em uma pilha
            
            pilhaCaracteres.push(frase.charAt(i));  /* o método .charAt() vai ler todos os caracteres da string usando
                                                       um indice inteiro e retornar o caractere nessa posição */
            
        }
        StringBuilder fraseInvertida = new StringBuilder();
        
        while(!pilhaCaracteres.empty()){
            fraseInvertida.append(pilhaCaracteres.pop());
        }
        
        System.out.println("\nPalavras Invertidas:");
        
        System.out.print(fraseInvertida);
        
	System.out.println();
        
    }
}

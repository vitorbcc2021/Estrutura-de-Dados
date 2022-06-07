package ed1dezum;
import java.util.Stack;
import java.util.Scanner;
public class Ed1DezUm {
    public static void main(String[] args) {
        
        Stack<Character> pilha = new Stack<Character>();
        Stack<Character> desinverter = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite uma frase:");
        
        String usuario = sc.nextLine();
        StringBuilder auxiliar1 = new StringBuilder();
        StringBuilder auxiliar2 = new StringBuilder();
        
        
        for(int i=0; i<usuario.length(); i++){
            pilha.push(usuario.charAt(i)); //fiz a pilha com a frase invertida
            
            if((usuario.charAt(i) != ' ') && (usuario.charAt(i) != '.') && (usuario.charAt(i) != '-')){
                auxiliar2.append(usuario.charAt(i));
            }
        }
        
        System.out.println("\nA) texto invertido:");
        
        while(!pilha.empty()){
            if((pilha.peek() != ' ') && (pilha.peek() != '.') && (pilha.peek() != '-')){
                System.out.print(pilha.peek()); //imprime a frase invertida
                
                desinverter.push(pilha.pop()); //desinverte a frase na pilha 'desinverter'
                
                auxiliar1.append(desinverter.pop()); /*ja estou construindo a String sem espaços, pontos e traços
                                                  para comparar com a original, e dizer se é um palíndromo*/
            }
            else if(pilha.peek() == ' '){
                System.out.print(' ');
                pilha.pop();
            }
            else if(pilha.peek() == '.'){
                System.out.print('.');
                pilha.pop();
            }
            else if(pilha.peek() == '-'){
                System.out.print('-');
                pilha.pop();
            }
        }
        System.out.println("\n");
        
        if(auxiliar1.compareTo(auxiliar2) == 0){
            System.out.println("B) A frase e um palindromo!");
        } else{
            System.out.println("B) A frase nao e um palindromo!");
        }    
    }
}

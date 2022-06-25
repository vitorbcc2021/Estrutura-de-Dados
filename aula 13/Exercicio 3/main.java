package ed1trezetres;

import java.util.Random;

public class Ed1TrezeTres {
    public static void main(String[] args) {
        Random rdm = new Random();
        
        PilhaDinamica p1 = new PilhaDinamica();
        PilhaDinamica p2 = new PilhaDinamica();
        PilhaDinamica p3 = new PilhaDinamica();
        
        for(int i = 0; i<100; i++){
            int numAleatorio = rdm.nextInt(1, 10);
            
            if(numAleatorio <= 3){
                p1.push(numAleatorio);
            }
            else if(numAleatorio > 3 && numAleatorio <=6){
                p2.push(numAleatorio);
            }
            else if(numAleatorio > 6 && numAleatorio <=9){
                p3.push(numAleatorio);
            }
        }
        
        System.out.println("\npilha 1:");
        p1.imprimir();
        System.out.println("\npilha 2:");
        p2.imprimir();
        System.out.println("\npilha 3:");
        p3.imprimir();
        
        for(int i=0; i<100; i++){
            int sorteio = rdm.nextInt(1, 4);
            
            if(p1.isEmpty()) break;
            else if(p2.isEmpty()) break;
            else if(p3.isEmpty()) break;
            
            switch(sorteio) {
                case 1:
                    System.out.println("Empilhando os numeros " + p2.peek() + " e " + p3.peek() + " na pilha 1");
                    p1.push(p2.pop());
                    p1.push(p3.pop());
                    break;
                case 2:
                    System.out.println("Empilhando os numeros " + p1.peek() + " e " + p3.peek() + " na pilha 2");
                    p1.push(p1.pop());
                    p1.push(p3.pop());
                    break;
                case 3:
                    System.out.println("Empilhando os numeros " + p1.peek() + " e " + p2.peek() + " na pilha 3");
                    p1.push(p1.pop());
                    p1.push(p2.pop());
                    break;
                default:
                    break;
            }
            
            if(p1.isEmpty()){
                System.out.println("\n\nO programa foi encerrado porque a pilha 1 esta vazia");
            }
            else if(p2.isEmpty()){
                System.out.println("\n\nO programa foi encerrado porque a pilha 2 esta vazia");
            }
            else if(p3.isEmpty()){
                System.out.println("\n\nO programa foi encerrado porque a pilha 3 esta vazia");
            }
        }
        
        System.out.println("\n");
        System.out.println("Pilha 1:");
        p1.imprimir();
        System.out.println("\n\nPilha 2:");
        p2.imprimir();
        System.out.println("\n\nPilha 3:");
        p3.imprimir();
    }

}

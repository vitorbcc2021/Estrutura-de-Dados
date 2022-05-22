package ediquatroum;

import java.util.Scanner;

public class EdiQuatroUm {
    
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Insira o numero de discos: ");
        int numDiscos = sc.nextInt();
        
        Hanoi torreHanoi = new Hanoi();
        
        long timerInicial = System.nanoTime(); //vai guardar o tempo em nanossegundos, so funciona com tipo long
        
        System.out.println("A quantidade de movimentos e: " + torreHanoi.movimentarDiscos(numDiscos, 'A', 'B', 'C')); //vai fazer as combinações
        
        long timerFinal = System.nanoTime();
        
        long tempoTotal = timerFinal - timerInicial; //total de tempo em nanossegundos
        
        
        //Temporizador:
        long tempoMicrossegundos = tempoTotal / 1000;
        int tempoMilissegundos = (int) tempoMicrossegundos / 1000;
        int tempoSegundos = tempoMilissegundos / 1000;
        int tempoMinutos = tempoSegundos / 60;
        int tempoHoras = tempoMinutos / 60;
        
        System.out.printf("tempo de execucao: %d : %d : %d : %d \n\n", tempoHoras, tempoMinutos, tempoSegundos, tempoMilissegundos);
    }
    
}

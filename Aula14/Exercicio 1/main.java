package ed1quatorzeum;

import java.util.Random;

public class Ed1QuatorzeUm {
    public static void main(String[] args) {
        int totalPessoas = 0;
        int pessoasAtendidas = 0;
        int atendimentosPorVez = 1;
        
        Random rdm = new Random();
        
        Deque deque = new Deque();
        
        for(int i = 0; i < 100; i++){
            Pessoa paciente = new Pessoa(rdm.nextInt(0, 10000), rdm.nextBoolean(), rdm.nextInt(0, 120), rdm.nextBoolean(), rdm.nextBoolean(), rdm.nextBoolean());
            deque.adicionaFinal(paciente);
        }
        
        while(deque.tamanho() != 0){
            for(int i=0; i<10; i++){
                        
                Pessoa paciente = (Pessoa) deque.pegaElemento();

                if(paciente.isLactante() || paciente.isGestante()){
                    
                    if(paciente.isLactante() && paciente.isGestante()) System.out.println("O Paciente lactante e gestante " + paciente.getID() + " foi retirado!");
                    else if(paciente.isLactante()) System.out.println("O Paciente lactante " + paciente.getID() + " foi retirado!");
                    else if(paciente.isGestante()) System.out.println("O Paciente gestante " + paciente.getID() + " foi retirado!");
                    
                    deque.retiraComeco();
                }
                else if(paciente.isEspecial()){
                    System.out.println("O Paciente especial " + paciente.getID() + " foi retirado!");
                    deque.retiraComeco();
                }
                else if(paciente.getIdade() > 60){
                    System.out.println("O Paciente acima de 60 anos " + paciente.getID() + " foi retirado!");
                    deque.retiraComeco();
                }
                else{
                    System.out.println("O Paciente normal " + paciente.getID() + " foi retirado!");
                    deque.retiraComeco();
                }
            }
        }
        
    }

}

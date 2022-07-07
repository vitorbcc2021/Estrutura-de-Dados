package ed1onzedois;

import java.util.Random;

public class Ed1OnzeDois {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Random rdm = new Random();
        
        
        for(int i = 0; i < 100; i++){
            Pessoa p = new Pessoa(rdm.nextInt(0, 10000), rdm.nextBoolean(), rdm.nextInt(0, 120),
                                         rdm.nextBoolean(), rdm.nextBoolean(), rdm.nextBoolean() );
            
            lista.adiciona(p);
        }
        
        while(lista.tamanho() != 0){
            for(int i=0; i<10; i++){
                        
                Pessoa p = (Pessoa) lista.pegaComeco();

                if(p.isLactante() || p.isGestante()){
                    
                    if(p.isLactante() && p.isGestante()) System.out.println("O Paciente lactante e gestante " + p.getID() + " foi retirado!");
                    else if(p.isLactante()) System.out.println("O Paciente lactante " + p.getID() + " foi retirado!");
                    else if(p.isGestante()) System.out.println("O Paciente gestante " + p.getID() + " foi retirado!");
                    
                    lista.remove(0);
                }
                else if(p.isEspecial()){
                    System.out.println("O Paciente especial " + p.getID() + " foi retirado!");
                    lista.remove(0);
                }
                else if(p.getIdade() > 60){
                    System.out.println("O Paciente acima de 60 anos " + p.getID() + " foi retirado!");
                    lista.remove(0);
                }
                else{
                    System.out.println("O Paciente normal " + p.getID() + " foi retirado!");
                    lista.remove(0);
                }
            }
        }
        
        
        
    }

}

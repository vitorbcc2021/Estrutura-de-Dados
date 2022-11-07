package ed2aula010;

import java.util.Random;

public class ED2Aula010 {
    public static void main(String[] args) {
        ArvoreBinaria arv = new ArvoreBinaria();
        
        Random rdm = new Random();
        
        for(int i=0; i<100; i++) ArvoreBinaria.insere(arv, rdm.nextInt(0, 100));
        
        System.out.println("Quantidade de nos: " + arv.getQtdNos());
        
        for(int i=0; i<3; i++) arv = ArvoreBinaria.retira(arv, arv.getElemento());
        
        System.out.println("Quantidade de nos: " + arv.getQtdNos());
        
        ArvoreBinaria.inOrdem(arv);
        
        System.out.println();
        
        arv = ArvoreBinaria.balancearVetor(arv);
        
        System.out.println("\nMetodo vetor:");
        ArvoreBinaria.inOrdem(arv);
        
        for(int i=0; i<20; i++) ArvoreBinaria.insere(arv, rdm.nextInt(0,100));
        
        System.out.println();
        arv = ArvoreBinaria.balancearDSW(arv);
        
        System.out.println("\n\nMetodo DSW:");
        ArvoreBinaria.inOrdem(arv);
        System.out.println();
        
    }

}
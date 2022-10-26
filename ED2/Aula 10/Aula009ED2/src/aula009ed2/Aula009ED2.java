package aula009ed2;

import java.util.Random;

public class Aula009ED2 {
    public static void main(String[] args) {
        ArvoreBinaria arv = new ArvoreBinaria();
        
        Random rdm = new Random();
        
        for (int i = 0; i < 20; i++) {
            int num = rdm.nextInt(0, 100);
            System.out.println("Inserindo: " + num);
            ArvoreBinaria.insere(arv, num);
        }
        
        System.out.println("\nPre ordem:");
        ArvoreBinaria.preOrdem(arv);
        
        System.out.println("\nIn ordem:");
        ArvoreBinaria.inOrdem(arv);
        
        System.out.println("\nPos ordem:");
        ArvoreBinaria.posOrdem(arv);
        
        System.out.println("\nEm nivel:");
        ArvoreBinaria.emNivel(arv);
        System.out.println("\n");
        
//##############################    Retirando elementos!  ############################################
        
        while(arv != null){
            System.out.println("Retirando: " + arv.getElemento());
            arv = ArvoreBinaria.retira(arv, arv.getElemento());
        }
        
        System.out.println("\n");
        
        
//#############################    Inserindo novos elementos!  ######################################
        if(arv == null) arv = new ArvoreBinaria();

        for (int i = 0; i < 20; i++) {
            int num = rdm.nextInt(0, 100);
            System.out.println("Inserindo: " + num);
            ArvoreBinaria.insere(arv, num);
        }
        
        System.out.println("\nPre ordem:");
        ArvoreBinaria.preOrdem(arv);
        
        System.out.println("\nIn ordem:");
        ArvoreBinaria.inOrdem(arv);
        
        System.out.println("\nPos ordem:");
        ArvoreBinaria.posOrdem(arv);
        
        System.out.println("\nEm nivel:");
        ArvoreBinaria.emNivel(arv);
        System.out.println("\n");
        
        
        
    }
}
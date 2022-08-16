package ed1dezoito;

import java.util.Random;

public class Ed1DezOito {
    public static void main(String[] args) {
        TestaPilha pilha = new TestaPilha();
        Random rdm = new Random();
        
        for(int i=0; i<1000; i++){
            pilha.validar(rdm.nextInt(-100, 100));
        }
    }

}

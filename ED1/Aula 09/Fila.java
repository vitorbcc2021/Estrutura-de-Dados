package ed1cincoum;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Fila {
    List<Carro> filaCarros = new ArrayList<>();
    ArrayList<Integer> array = new ArrayList<>();
    List<Carro> filaLavados = new ArrayList<>();
    List<Integer> filaNumeros = new ArrayList<>();
    
    private int carrosNaFila = 0;
    
    public void push(Carro car){
        carrosNaFila++;
        
        if(carrosNaFila == 3){
            this.filaCarros.remove(0);
            carrosNaFila = 2;   /* Como eu removi apenas 1 elemento, devo considerar q os outros 2
                                   continuam na fila pois, de acordo com o exercício, se 3 carros 
                                   estão na fila o primeiro à ter entrado na fila deve ser removido,
                                   logo, sempre teremos apenas 2 carros na fila esperando!! */
        }
        
        this.filaCarros.add(car);
    }
    
    public int pop(){
        Carro car = this.filaCarros.get(0);
        Carro carroRemovido = car;
        this.filaCarros.remove(0);
        
        carroRemovido.setLimpo(true);
        this.filaLavados.add(carroRemovido);
        
        return carroRemovido.getNumero();
    }
    
    public boolean empty(){
        return this.filaCarros.isEmpty();
    }
    
    public int peekFirst(){
        Carro car = this.filaCarros.get(0);
        return car.getNumero();
    }
    
    public int peekLast(){
        Carro car = this.filaCarros.get(filaCarros.size()-1);
        return car.getNumero();
    }
    
    public void imprimirDados(){
        Carro car = this.filaLavados.get(0);
        System.out.printf("Modelo: %s \nEstá limpo?: %b \nNumero de identificação: %d", car.getModelo(), car.isLimpo(), car.getNumero());
    }
    
    public void ordenar(){
        Carro car = this.filaLavados.get(0);
        
        while(!this.filaLavados.isEmpty()){
            array.add(car.getNumero());
            this.filaLavados.remove(0);
        }
        
        Collections.sort(array);
        
        while(!array.isEmpty()){
            this.filaNumeros.add(array.get(0));
            this.array.remove(0);
        }
        
        while(!filaLavados.isEmpty()){
            System.out.println(this.filaLavados.get(0));
        }
        
    }
}

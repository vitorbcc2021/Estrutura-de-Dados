package ed1cincoum;
public class Ed1CincoUm {
    public static void main(String[] args) {
        Carro c1 = new Carro("Gol", 11);
        Carro c2 = new Carro("Camaro", 52);
        Carro c3 = new Carro("Lambourghini", 83);
        Carro c4 = new Carro("Fusca", 72);
        Carro c5 = new Carro("Celta", 42);
        Carro c6 = new Carro("Jeta", 66);
        Carro c7 = new Carro("Golf", 4);
        Carro c8 = new Carro("Onix", 88);
        Carro c9 = new Carro("Uno", 1);
        Carro c10 = new Carro("Corsa", 33);
        Carro c11 = new Carro("HB20", 22);
        Carro c12 = new Carro("Civic", 12);
        Carro c13 = new Carro("City", 2);
        Carro c14 = new Carro("Gol Quadrado", 123);
        Carro c15 = new Carro("Ford Ka", 21);
        
        Fila fila = new Fila();
        
        fila.push(c1);
        fila.push(c2);
        fila.push(c3);
        fila.push(c4);
        fila.push(c5);
        
        
        System.out.println(fila.peekFirst());
        System.out.println(fila.peekLast());
        System.out.println(fila.pop());
        
        
        
        
        
        
    }
}
        

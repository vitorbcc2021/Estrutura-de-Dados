package ed1cincoum;
public class Carro {
    private String modelo;
    private boolean limpo;
    private int numero;

    public Carro(String modelo, int numero) {
        this.modelo = modelo;
        this.limpo = false;
        this.numero = numero;
    }

    
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isLimpo() {
        return limpo;
    }

    public void setLimpo(boolean limpo) {
        this.limpo = limpo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}

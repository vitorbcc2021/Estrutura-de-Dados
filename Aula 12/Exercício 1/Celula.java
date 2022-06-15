package ed1dozeum;

public class Celula {
    private Celula proxima;
    private Celula anterior;
    private Object elemento;

    public Celula(Celula Proxima, Object Elemento) {
        this.proxima = Proxima;
        this.anterior = null;
        this.elemento = Elemento;
    }
    
    public Celula(Object Elemento){
        this.proxima = null;
        this.anterior = null;
        this.elemento = Elemento;
    }

    public Celula getProxima() {
        return proxima;
    }

    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
    
    
    
}

package ed1trezedois;

public class CelulaPilha {
    private Object elemento;
    private CelulaPilha anterior;

    public CelulaPilha(){}
     
    public CelulaPilha(Object elemento, CelulaPilha anterior) {
        this.elemento = elemento;
        this.anterior = anterior;
    }

    
    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public CelulaPilha getAnterior() {
        return anterior;
    }

    public void setAnterior(CelulaPilha anterior) {
        this.anterior = anterior;
    }
    
    
}

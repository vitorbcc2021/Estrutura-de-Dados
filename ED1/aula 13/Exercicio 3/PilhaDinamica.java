package ed1trezetres;

public class PilhaDinamica {
    private CelulaPilha topo;
    
    public void push(Object elemento){
        CelulaPilha novaCelula = new CelulaPilha();
        
        novaCelula.setElemento(elemento);
        novaCelula.setAnterior(this.topo);
        this.topo = novaCelula;
    }
    
    public Object pop(){
        if(!isEmpty()){
            Object retirado = this.topo.getElemento();
            this.topo = this.topo.getAnterior();
            return retirado;
        }
        else{
            System.out.println("Pilha Vazia!!!");
            return null;
        }
    }
    
    public Object peek(){
        return this.topo.getElemento();
    }
    
    public boolean isEmpty(){
        return this.topo == null;
    }
    
    public int sizePilha(){
        CelulaPilha p;
        int cont = 0;
        p = this.topo;
        
        while(p != null){
            p = p.getAnterior();
            cont++;
        }
        return cont;
    }
    
    public void imprimir(){
        CelulaPilha p;
        p = this.topo;
        
        if(isEmpty()){
            System.out.println("Pilha Vazia!!!");
        }
        else{
            while(p != null){
                System.out.println(p.getElemento());
                p = p.getAnterior();
            }
        }
    }
    
    public CelulaPilha topo(){
        if(isEmpty()){
            System.out.println("Pilha Vazia!!!");
            return null;
        }
        else {
            System.out.println("Nome no topo da Pilha..: "+topo.getElemento());
            return this.topo;
        }
    }
}
package ed1trezedois;

public class PilhaDinamica {
    private CelulaPilha topo;
    
    public void push(Object elemento){
        CelulaPilha novaCelula = new CelulaPilha();
        
        novaCelula.setElemento(elemento);
        novaCelula.setAnterior(this.topo);
        this.topo = novaCelula;
    }
    
    public void pop(){
        if(!isEmpty()){
            System.out.println("Retirando elem. da pilha..: "+this.topo.getElemento());
            this.topo = this.topo.getAnterior();
        }
        else{
            System.out.println("Pilha Vazia!!!");
        }
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
            int i=0;
            while(p != null){
                
                System.out.println(i + " - " + p.getElemento());
                i++;
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

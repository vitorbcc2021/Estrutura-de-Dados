package ed1quatorzeum;

public class Deque {
    
    private Celula cabeca;
    private int tamanho;
    private Object elemento;
    
    private void inicializarDeque(Object elemento){
        Celula inicial = new Celula(elemento);
        
        this.cabeca = inicial;
        this.cabeca.setAnterior(inicial);
        this.cabeca.setProxima(inicial);
        
        this.tamanho++;
    }
    
    public void adicionaComeco(Object elemento){
        if(this.tamanho == 0) inicializarDeque(elemento);
        else{
            Celula proxima = new Celula(cabeca, elemento);
            
            this.cabeca.setAnterior(proxima);
            this.cabeca = proxima;
            
            this.tamanho++;
        }
    }
    
    public void adicionaFinal(Object elemento){
        if(this.tamanho == 0) inicializarDeque(elemento);
        else{
            Celula ultima = cabeca.getAnterior();
            
            Celula nova = new Celula(cabeca, elemento);
            
            ultima.setProxima(nova);
            nova.setAnterior(ultima);
            this.cabeca.setAnterior(nova);
            
            this.tamanho++;
        }
    }
    
    public void retiraComeco(){
        if(this.tamanho == 1){
            this.cabeca = null;
            
            this.tamanho--;
        }
        else if(this.tamanho > 1){
            Celula ultima = this.cabeca.getAnterior();
            
            this.cabeca = cabeca.getProxima();
            
            ultima.setProxima(this.cabeca);
            
            this.tamanho--;
            
        }
        else if(this.tamanho == 0){
            throw new PosicaoDequeInvalidaException("A posicao que voce esta tentando remover e invalida!!");
        }
    }
    
    public void retiraFinal(){
         if(this.tamanho == 1){
            this.cabeca = null;
            
            this.tamanho--;
        }
        else if(this.tamanho > 1){
            Celula ultima = this.cabeca.getAnterior().getAnterior();
            
            this.cabeca.setAnterior(ultima);
            
            ultima.setProxima(this.cabeca);
            
            this.tamanho--;
            
        }
        else if(this.tamanho == 0){
            throw new PosicaoDequeInvalidaException("A posicao que voce esta tentando remover e invalida!!");
        }
    }
    
    public void imprimir(){  // Inacabado!!
        if(this.tamanho == 0){
            throw new PosicaoDequeInvalidaException("Nao e possivel imprimir pois o Deque encontra-se vazio!");
        }
        else{
            Celula deque = this.cabeca;
            
            for(int i = 0; i<this.tamanho-1; i++){
                System.out.println(deque.getElemento());
                deque = deque.getProxima();
            }
        }
    }
    
    public boolean reinicializarDeque(){
        this.cabeca = null;
        this.tamanho = 0;
        return true;
    }
    
    public int tamanho(){
        return this.tamanho;
    }
    
    public Object pegaElemento(){
        return this.cabeca.getElemento();
    }
    
    
    
    
}

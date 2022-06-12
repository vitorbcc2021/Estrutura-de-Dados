package ed1onzeum;

public class ListaEncadeada{
    
    
    private Celula primeiraPosicao;
    private Celula ultimaPosicao;
    private int numElementos = 0;
    
    
    public void comeco(Object p){
        Celula nova = new Celula(this.primeiraPosicao, p);
            
        this.primeiraPosicao = nova;
        
        if(this.numElementos == 0) this.ultimaPosicao = this.primeiraPosicao;
        
        numElementos++;
    }
    
    
    public void adiciona(Object p){
        if(this.numElementos == 0){
            this.comeco(p);
        }
        else{
            Celula nova = new Celula(p);
        
            this.ultimaPosicao.setProxima(nova);
            this.ultimaPosicao = nova;
        
            numElementos++;
        }
    }
    
    
    private boolean posicaoOcupada(int pos){
        return (pos >= 0) && (pos < this.numElementos);
    }
    
    
    private Celula pegaCelula(int pos){
        if(!this.posicaoOcupada(pos)){
            throw new IllegalArgumentException("Posicao nao Existe");
        }
        else{
            Celula atual = this.primeiraPosicao;
            
            for(int i=0; i<pos; i++){
                atual = atual.getProxima();
            }
            
            return atual;
        }
    }
    
    
    public Object pega(int pos){
        return this.pegaCelula(pos).getElemento();
    }
    
    
    public void remove(int pos){
        if(!this.posicaoOcupada(pos)){
            throw new IllegalArgumentException("Posicao nao Existe");
        }
        else if(pos == 0){
            this.primeiraPosicao = this.primeiraPosicao.getProxima();
            numElementos--;
            
            if(this.numElementos == 0){
                this.ultimaPosicao = null;
            }
            
        }
        else{
            Celula atual = this.primeiraPosicao;
            
            for(int i=0; i<pos-1; i++){
                atual = atual.getProxima();
            }
            
            atual.setProxima(atual.getProxima().getProxima());
            
            numElementos--;
        }
    }
    
    
    public boolean contem(Object p){
        Celula atual = this.primeiraPosicao;
        
        while(atual != null){
            if(atual.getElemento().equals(p)){
                return true;
            }
            atual = atual.getProxima();
        }
       return false; 
    }
    
    
    public int tamanho(){
        return this.numElementos;
    }
    
    
}

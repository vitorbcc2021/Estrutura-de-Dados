package ed1dozedois;

public class Lista {
    private Celula primeira;
    private Celula ultima;
    private int totalElementos = 0;
    
    public void adicionaComeco(Object elemento){
        if(this.totalElementos == 0){
            Celula comeco = new Celula(elemento);
            
            this.primeira = comeco;
            this.ultima = this.primeira;
            
            this.totalElementos++;
        }
        else{
            Celula comeco = new Celula(this.primeira, elemento);
            
            this.primeira.setAnterior(comeco);
            this.primeira = comeco;
        
            this.totalElementos++;
        }
    }
    
    public void adiciona(Object elemento){ //adiciona no final
        if(this.totalElementos == 0){
            this.adicionaComeco(elemento);
        }
        else{
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
        
            this.totalElementos++;
        }
    }
    
    public void adiciona(int pos, Object elemento){
        if(pos == 0){
            this.adicionaComeco(elemento);
        }
        else if(pos == this.totalElementos){
            this.adiciona(elemento);//adiciona no final
        }
        else{
            Celula anterior = this.pegaCelula(pos-1);
            Celula proxima = anterior.getProxima();
            Celula atual = new Celula(anterior.getProxima(), elemento);
            
            atual.setAnterior(anterior);
            anterior.setProxima(atual);
            proxima.setAnterior(atual);
            
            this.totalElementos++;
            
        }
    }
    
    public boolean posicaoOcupada(int pos){
        return pos >= 0 && pos < this.totalElementos;
    }
    
    public Celula pegaCelula(int pos){
        if(!posicaoOcupada(pos)){
            throw new IllegalArgumentException("Posicao nao existe");
        }
        else{
            Celula atual = this.primeira;
            
            for(int i=0; i<pos; i++){
                atual = atual.getProxima();
            }
            
            return atual;
        }
    }
    
    public Object pega(int pos){
        return this.pegaCelula(pos).getElemento();
    }
    
    public int tamanho(){
        return this.totalElementos;
    }
    
    public boolean contem(Object elemento){
        Celula atual = this.primeira;
        
        while(atual != null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }
    
    public Object removeComeco(){
        if(!this.posicaoOcupada(0)){
            throw new IllegalArgumentException("Posicao nao Existe");
        }
        
        Object backupPrimeira = this.primeira.getElemento();
        this.primeira = this.primeira.getProxima();
        this.primeira.setAnterior(null);
        
        this.totalElementos--;
        
        if(this.totalElementos == 0) this.ultima = null;
        
        return backupPrimeira;
    }
    
    public Object removeFim(){
        if(!this.posicaoOcupada(this.totalElementos-1)){
            throw new IllegalArgumentException("Posicao nao existe");
        }
        if(this.totalElementos == 0){
            this.removeComeco();
        }
        
        Object backupUltima = this.ultima.getElemento();
        
        this.ultima = this.ultima.getAnterior();
        this.ultima.setProxima(null);
        
        this.totalElementos--;
        
        return backupUltima;
    }
    
    public Object remove(int pos){
        if(!this.posicaoOcupada(pos)){
            throw new IllegalArgumentException("Posicao nao Existe");
        }
        else if(pos == 0){
            this.removeComeco();
        }
        else if(pos == this.totalElementos){
            this.removeFim();
        }
        
        Celula atual = this.primeira;
        
        for(int i=0; i<pos-1; i++){
            atual = atual.getProxima();
        }
        
        Celula proxima = atual.getProxima();
        Object backup = atual.getElemento();
        
        atual.setProxima(atual.getProxima().getProxima());
        proxima.setAnterior(atual);
        
        this.totalElementos--;
        
        return backup;
    }
    
    public String imprimir(){
        if(this.totalElementos == 0){
            return "[]";
        }
        else{
            StringBuilder strb = new StringBuilder("\n[");
            
            Celula atual = this.primeira;
            
            for(int i=0; i<this.totalElementos-1; i++){
                strb.append(atual.getElemento());
                strb.append(", ");
                atual = atual.getProxima();
                if(i==200) strb.append("\n");
                if(i==400) strb.append("\n");
                if(i==600) strb.append("\n");
                if(i==800) strb.append("\n");
            }
            strb.append(atual.getElemento());
            strb.append("]");
            
            return strb.toString();
        }
    }
    
    public String imprimirDecrescente(){
        if(this.totalElementos == 0){
            return "[]";
        }
        else{
            StringBuilder strb = new StringBuilder("\n[");
            
            Celula atual = this.ultima;
            
            for(int i=0; i<this.totalElementos-1; i++){
                strb.append(atual.getElemento());
                strb.append(", ");
                atual = atual.getAnterior();
                if(i==200) strb.append("\n");
                if(i==400) strb.append("\n");
                if(i==600) strb.append("\n");
                if(i==800) strb.append("\n");
            }
            strb.append(atual.getElemento());
            strb.append("]");
            
            return strb.toString();
        }
    }
    
    public void esvaziarLista(){
        this.primeira = null;
        this.ultima = null;
        this.totalElementos = 0;
    }
    
    public void adicionaOrdenando(Object elemento){
        if(this.totalElementos == 0){ //inicio da lista
            Celula comeco = new Celula(elemento);
            
            this.primeira = comeco;
            this.ultima = this.primeira;
            
            this.totalElementos++;
            
            System.out.println(this.imprimir());
        }
        else{
            Celula atual = this.primeira;
            
            if((int) elemento <= (int) atual.getElemento()){ //se a lista n estiver vazia verifica se é menor que o primeiro elemento, e o insere atrás
                Celula comeco = new Celula(this.primeira, elemento);
            
                this.primeira.setAnterior(comeco);
                this.primeira = comeco;
                
                this.totalElementos++;
                
                System.out.println(this.imprimir());
            }
            else{ //se nao for, verifica se e do tamanho do proximo, e vai fazendo isso ate este elemento ser igual, ou maior que o proximo, e o insere na frente
                while(true){
                    if((int) elemento > (int) atual.getElemento() && (int) elemento < (int) this.ultima.getElemento()){
                        atual = atual.getProxima();
                    }
                    else if((int) elemento >= (int) this.ultima.getElemento()){
                        Celula ultimaPos = new Celula(elemento);
                        
                        this.ultima.setProxima(ultimaPos);
                        ultimaPos.setAnterior(this.ultima);
                        this.ultima = ultimaPos;
                        
                        totalElementos++;
                        
                        System.out.println(this.imprimir());
                        
                        break;
                    }
                    else{
                        atual = atual.getAnterior();
                        Celula nova = new Celula(atual, elemento);
                        nova.setAnterior(atual.getAnterior());
                        atual.setAnterior(nova);
                        
                        this.totalElementos++;
                        
                        System.out.println(this.imprimir());
                        
                        break;
                    }
                }

            }
        
        }
        
        
        
        
    }
}

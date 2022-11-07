package ed2aula010;

public class ArvoreBinaria {
    private int elemento;
    private ArvoreBinaria esquerda;
    private ArvoreBinaria direita;
    private static int qtdNos;
    private static boolean semRaiz;
    
    public ArvoreBinaria(){
        this.setElemento(0);
        this.setEsquerda(null);
        this.setDireita(null);
        setSemRaiz(true);
    }
    
    public static void preOrdem(ArvoreBinaria arvore){
        if(arvore != null){
            System.out.print(arvore.getElemento() + "  ");
            preOrdem(arvore.getEsquerda());
            preOrdem(arvore.getDireita());
        }
    }
    
    public static void inOrdem(ArvoreBinaria arvore){
        if(arvore != null){
            inOrdem(arvore.getEsquerda());
            System.out.print(arvore.getElemento() + "  ");
            inOrdem(arvore.getDireita());
        }
    }
    
    public static void posOrdem(ArvoreBinaria arvore){
        if(arvore != null){
            posOrdem(arvore.getEsquerda());
            posOrdem(arvore.getDireita());
            System.out.print(arvore.getElemento() + "  ");
        }
    }
    
    public static void emNivel(ArvoreBinaria arvore){
        System.out.print(arvore.getElemento() + "  ");
        
        emNivelAux(arvore);
    }
    
    private static void emNivelAux(ArvoreBinaria arvore){
        if(arvore != null){
            if(arvore.getEsquerda() != null) {
                System.out.print(arvore.getEsquerda().getElemento() + "  ");
            }
            if(arvore.getDireita() != null) {
                System.out.print(arvore.getDireita().getElemento() + "  ");
            }

            emNivelAux(arvore.getEsquerda());
            emNivelAux(arvore.getDireita());
        }
    }
    
    public static ArvoreBinaria procura(ArvoreBinaria arvore, int valor){
        if(arvore == null)
            return null;
        else if(arvore.getElemento() > valor)
            return procura(arvore.getEsquerda(), valor);
        else if(arvore.getElemento() < valor)
            return procura(arvore.getDireita(), valor);
        else
            return arvore;
    }
    
    public static ArvoreBinaria insereRaiz(ArvoreBinaria noRaiz, int valor){
        noRaiz.setElemento(valor);
        noRaiz.setDireita(null);
        noRaiz.setEsquerda(null);
        noRaiz.setSemRaiz(false);
        noRaiz.setQtdNos(0);
        
        return noRaiz;
    }
    
    public static ArvoreBinaria insere(ArvoreBinaria arvore, int valor){
        insereAux(arvore, valor);
        
        arvore.qtdNos++;
        
        return arvore;
    }
    
    private static ArvoreBinaria insereAux(ArvoreBinaria arvore, int valor){
        if(arvore == null){
            arvore = new ArvoreBinaria();
            insereRaiz(arvore, valor);
        }
        else if(isSemRaiz()){
            insereRaiz(arvore, valor);
        }
        else if(valor < arvore.getElemento()){
            arvore.setEsquerda(insereAux(arvore.getEsquerda(), valor));
        }
        else{
            arvore.setDireita(insereAux(arvore.getDireita(), valor));
        }
        
        return arvore;
    }
    
    public static ArvoreBinaria retira(ArvoreBinaria arvore, int valor){
        arvore = retiraAux(arvore, valor);
        
        arvore.qtdNos--;
        
        return arvore;
    }
    
    private static ArvoreBinaria retiraAux(ArvoreBinaria arvore, int valor){
        if(arvore == null)
        {
            System.out.println("Elemento nao encontrado..: " + valor);
            return null;
        }
        else if(valor < arvore.getElemento())
        {
            arvore.setEsquerda(retiraAux(arvore.getEsquerda(), valor));
        }
        else if(valor > arvore.getElemento())
        {
            arvore.setDireita(retiraAux(arvore.getDireita(), valor));
        }
        else{
            //no sem filhos
            if((arvore.getEsquerda() == null) && (arvore.getDireita() == null))
            {
                arvore = null;
            }
            else if(arvore.getEsquerda() == null)
            {
                //no so tem filho a direita
                ArvoreBinaria novo = arvore;
                arvore = arvore.getDireita();
            }
            else if(arvore.getDireita() == null)
            {
                //no so tem filho a esquerda
                ArvoreBinaria novo = arvore;
                arvore = arvore.getEsquerda();
            }
            else{
                //no tem 2 filhos
                ArvoreBinaria novo = arvore.getEsquerda();
                
                while(novo.getDireita() != null){
                    novo = novo.getDireita();
                }
                
                arvore.setElemento(novo.getElemento());
                novo.setElemento(valor);
                
                arvore.setEsquerda(retiraAux(arvore.getEsquerda(), valor));
            }
        }
        return arvore;
    }
    
    public static ArvoreBinaria balancearVetor(ArvoreBinaria arvore){
        int[] vetor = new int[arvore.getQtdNos()];
        int i=0;
        
        while(arvore != null){
            int retirado = arvore.getElemento();
            arvore = retira(arvore, arvore.getElemento());
            vetor[i] = retirado;
            i++;
        }
        
        QuickSort qs = new QuickSort(vetor);
        
        arvore = new ArvoreBinaria();
        
        if(vetor.length > 1){
            int meio = (int) vetor.length/2;
            ArvoreBinaria.insere(arvore, vetor[meio]);
            
            for(int j=0; j<vetor.length; j+=3){
                if((j+1 != meio) && (j+1 < vetor.length))
                    ArvoreBinaria.insere(arvore, vetor[j+1]);
                if(j != meio)
                    ArvoreBinaria.insere(arvore, vetor[j]);
                if((j+2 != meio) && (j+2 < vetor.length))
                    ArvoreBinaria.insere(arvore, vetor[j+2]);
            }
        }
        else{
            ArvoreBinaria.insere(arvore, vetor[0]);
        }
        
        return arvore;
    }
    
    public static ArvoreBinaria balancearDSW(ArvoreBinaria arvore){
        ArvoreBinaria nova = new ArvoreBinaria();
        
        nova = criarArvoreDegenerada(nova, arvore);
        
        System.out.println("\nDegenerada: ");
        ArvoreBinaria.inOrdem(nova);
        
        ArvoreBinaria aux1 = nova;
        ArvoreBinaria aux2 = nova;
        
        if(nova.getEsquerda() != null){
            for(int i=0; i<nova.getQtdNos();i++){
                if(aux1 != null){
                    aux2 = nova.getEsquerda();
                    aux2.insere(aux2, aux1.getElemento());
                    aux1 = aux1.getEsquerda().getEsquerda();
                }
            }
        }
        else if(nova.getDireita() != null){
            for(int i=0; i<nova.getQtdNos(); i++){
                if(aux1 != null){
                    aux2 = nova.getDireita();
                    aux2.insere(aux2, aux1.getElemento());
                    aux1 = aux1.getDireita().getDireita();
                }
            }
        }
        
        return aux2; 
       
    }
    
    private static ArvoreBinaria criarArvoreDegenerada(ArvoreBinaria nova, ArvoreBinaria arvore){
        if(arvore != null){
            criarArvoreDegenerada(nova, arvore.getEsquerda());
            nova.insere(nova, arvore.getElemento());
            criarArvoreDegenerada(nova, arvore.getDireita());
        }
        
        return nova;
    }
    
    // Gettes And Setters

    public int getElemento() {
        return elemento;
    }

    private void setElemento(int elemento) {
        this.elemento = elemento;
    }

    private ArvoreBinaria getEsquerda() {
        return esquerda;
    }

    private void setEsquerda(ArvoreBinaria esquerda) {
        this.esquerda = esquerda;
    }

    private ArvoreBinaria getDireita() {
        return direita;
    }

    private void setDireita(ArvoreBinaria direita) {
        this.direita = direita;
    }
    
    private static boolean isSemRaiz() {
        return semRaiz;
    }

    private static void setSemRaiz(boolean aSemRaiz) {
        semRaiz = aSemRaiz;
    }

    public static int getQtdNos() {
        return qtdNos;
    }

    private static void setQtdNos(int numNos) {
        qtdNos = qtdNos;
    }
    
    

}
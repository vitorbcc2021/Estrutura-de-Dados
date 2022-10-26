using System;

namespace prog
{
class ArvoreBinaria
{
    private int elemento;
    private ArvoreBinaria esquerda;
    private ArvoreBinaria direita;
    private bool semRaiz;
    
    public ArvoreBinaria()
    {
        this.setElemento(0);
        this.setEsquerda(null);
        this.setDireita(null);
        setSemRaiz(true);
    }
    
    public static void preOrdem(ArvoreBinaria arvore)
    {
        if(arvore != null)
        {
            Console.Write(arvore.getElemento() + "  ");
            preOrdem(arvore.getEsquerda());
            preOrdem(arvore.getDireita());
        }
    }
    
    public static void inOrdem(ArvoreBinaria arvore)
    {
        if(arvore != null)
        {
            inOrdem(arvore.getEsquerda());
            Console.Write(arvore.getElemento() + "  ");
            inOrdem(arvore.getDireita());
        }
    }
    
    public static void posOrdem(ArvoreBinaria arvore)
    {
        if(arvore != null)
        {
            posOrdem(arvore.getEsquerda());
            posOrdem(arvore.getDireita());
            Console.Write(arvore.getElemento() + "  ");
        }
    }
    
    public static void emNivel(ArvoreBinaria arvore)
    {
        Console.Write(arvore.getElemento() + "  ");
        
        emNivelAux(arvore);
    }
    
    private static void emNivelAux(ArvoreBinaria arvore)
    {
        if(arvore != null)
        {
            if(arvore.getEsquerda() != null)
            {
                Console.Write(arvore.getEsquerda().getElemento() + "  ");
            }
            if(arvore.getDireita() != null)
            {
                Console.Write(arvore.getDireita().getElemento() + "  ");
            }

            emNivelAux(arvore.getEsquerda());
            emNivelAux(arvore.getDireita());
        }
    }
    
    public static ArvoreBinaria procura(ArvoreBinaria arvore, int valor)
    {
        if(arvore == null)
            return null;
        else if(arvore.getElemento() > valor)
            return procura(arvore.getEsquerda(), valor);
        else if(arvore.getElemento() < valor)
            return procura(arvore.getDireita(), valor);
        else
            return arvore;
    }
    
    public static ArvoreBinaria insereRaiz(ArvoreBinaria noRaiz, int valor)
    {
        noRaiz.setElemento(valor);
        noRaiz.setDireita(null);
        noRaiz.setEsquerda(null);
        noRaiz.setSemRaiz(false);
        
        return noRaiz;
    }
    
    public static ArvoreBinaria insere(ArvoreBinaria arvore, int valor)
    {
        if(arvore == null)
        {
            arvore = new ArvoreBinaria();
            arvore.setElemento(valor);
            arvore.setDireita(null);
            arvore.setEsquerda(null);
            arvore.setSemRaiz(false);
        }
        else if(arvore.isSemRaiz())
        {
            insereRaiz(arvore, valor);
        }
        else if(valor < arvore.getElemento())
        {
            arvore.setEsquerda(insere(arvore.getEsquerda(), valor));
        }
        else
        {
            arvore.setDireita(insere(arvore.getDireita(), valor));
        }
        
        return arvore;
    }
    
    public static ArvoreBinaria retira(ArvoreBinaria arvore, int valor)
    {
        if(arvore == null)
        {
            Console.WriteLine("Elemento nao encontrado..: " + valor);
            return null;
        }
        else if(valor < arvore.getElemento())
        {
            arvore.setEsquerda(retira(arvore.getEsquerda(), valor));
        }
        else if(valor > arvore.getElemento())
        {
            arvore.setDireita(retira(arvore.getDireita(), valor));
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
                
                arvore.setEsquerda(retira(arvore.getEsquerda(), valor));
            }
        }
        return arvore;
    }
    
    // Gettes And Setters

    public int getElemento()
    {
        return elemento;
    }

    private void setElemento(int elemento)
    {
        this.elemento = elemento;
    }

    private ArvoreBinaria getEsquerda()
    {
        return esquerda;
    }

    private void setEsquerda(ArvoreBinaria esquerda) 
    {
        this.esquerda = esquerda;
    }

    private ArvoreBinaria getDireita()
    {
        return direita;
    }

    private void setDireita(ArvoreBinaria direita)
    {
        this.direita = direita;
    }
    
    private bool isSemRaiz()
    {
        return semRaiz;
    }

    private void setSemRaiz(bool SemRaiz)
    {
        semRaiz = SemRaiz;
    }

}
}

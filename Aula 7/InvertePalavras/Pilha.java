package invertestring;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Pilha {
    private ArrayList<Object> vetor;
    private int topo;
    
    public Pilha(){
        this.vetor = new ArrayList<Object>();
        this.topo = -1;
    }

    public int tamanho(){
        return(this.topo+1);
    }
    
    public void push(Object elemento){
        this.vetor.add(elemento);
        System.out.println("Inserindo o elemento..: " + elemento);

        this.topo++;
    }
    
    public Object pop(){
        this.topo--;
        
        if(this.topo<-1){
           JOptionPane.showMessageDialog(null,"Pilha vazia!!! Erro..: -997");
           return('9');
        }else{
            System.out.println("Retirando o valor.....: "+this.vetor.get(this.topo+1));
            return(this.vetor.remove(this.topo+1));
        }
    }

    public boolean empty(){
        return this.tamanho() == 0;
    }

    public Object peek(){
        if(this.topo < 0) throw new ArrayIndexOutOfBoundsException("Sua pilha esta vazia!");
        return this.vetor.get(topo);
    }

    public String invertePalavras(String frase){
        Pilha pilha = new Pilha();
        String aux = "";
        String fraseComparacao = "";
        String auxComparacao = "";

        for(int i=0; i < frase.length(); i++){
            if(frase.charAt(i) != ' '){
                pilha.push(frase.charAt(i)); //    Inserindo UMA palavra por vez
            }
            else{
                System.out.println();
                while(!pilha.empty()){
                    char temp = (char) pilha.pop();
                    aux += temp; //    Monta uma palavra -> Adiciona um espaco -> Volta para o o if
                }
                    aux += ' ';
                    System.out.println();
            }
        }
            
        if(!pilha.empty()){
            System.out.println();
            while(!pilha.empty()){
                char temp = (char) pilha.pop();
                aux += temp;
            }
            System.out.println();
        }

        //  Verificando se a frase é um PALINDROMO!
        //  Obs1: Nunca será palindromo, pois a frase nao e invertida por completa, apenas as palavras são!
        //  Obs2: Apenas irá funcionar para uma palavra única! Ex: Ana
        for(int i=0; i < frase.length(); i++){
            if(frase.charAt(i) != ' '){
                fraseComparacao += frase.charAt(i);
                auxComparacao += aux.charAt(i);
            }
        }

        fraseComparacao = fraseComparacao.toLowerCase(); //Este metodo deixa todas as letras minúsculas!
        auxComparacao = auxComparacao.toLowerCase();

        //System.out.println(aux);

        if(fraseComparacao.equals(auxComparacao)){
            System.out.println("\nEsta frase e um palindromo!");
        }
                
        return aux;
    }

    public boolean reset(){
        this.topo = -1;
        this.vetor = new ArrayList<>();
        if(this.vetor.size() == 0) return true;
        
        return false;
    }
}
package ed1dozeum;

public class Ed1DozeUm {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        
        lista.adiciona("Homer");
        lista.adiciona("Marge");
        System.out.println(lista.imprimir());
//        
//        
//        
        lista.esvaziarLista();
        System.out.println(lista.imprimir()); 
//        
//        
//        
        lista.adiciona("Homer");
        lista.adiciona(0, "Bart");
        lista.adiciona(1, "Moll");
        System.out.println(lista.imprimir());
//        
//        
//        
        lista.esvaziarLista();
//        
//        
//        
        lista.adiciona("Homer");
        lista.adiciona("Bart");
        lista.adicionaComeco("Lisa");
        System.out.println(lista.imprimir() + "\nO tamanho da lista e: " + lista.tamanho());
//        
//        
//        
        lista.esvaziarLista();
        System.out.println(lista.imprimir());
//        
//        
//        
        lista.adiciona("Homer");
        lista.adiciona("Maggie");
        lista.adiciona(0, "Bart");
        lista.adiciona(1, "Marge");
        lista.adiciona("Lisa");
        if(lista.contem("Lisa")){
            System.out.println("Esta lista contem Lisa!");
        }
        else{
            System.out.println("Nao contem Lisa!");    
        }
//        
//        
//        
        lista.esvaziarLista();
//        
//        
//        
        lista.adiciona("Homer");
        lista.adiciona("Bart");
        System.out.println(lista.imprimir() + "\nO tamanho desta lista e: " + lista.tamanho());
//        
//        
//        
        if(lista.contem("Marge")){
            System.out.println("Marge esta na lista");
        }
        else{
            System.out.println("Marge nao esta na lista");
        }
        
        if(lista.contem("Homer")){
            System.out.println("Homer esta na lista");
        }
        else{
            System.out.println("Homer nao esta na lista");
        }
        
        if(lista.contem("Bart")){
            System.out.println("Bart esta na lista");
        }
        else{
            System.out.println("Bart nao esta na lista");
        }
        
        if(lista.contem("Maggie")){
            System.out.println("Maggie esta na lista");
        }
        else{
            System.out.println("Maggie nao esta na lista");
        }
        
        System.out.println(lista.imprimir() + "\nO tamanho e: " + lista.tamanho());
//
//
//        
        lista.esvaziarLista();
//        
//        
//        
        lista.adicionaComeco("Homer");
        lista.adicionaComeco("Bart");
        lista.adiciona("Marge");
        lista.adiciona(1, "Maggie");
        lista.adicionaComeco("Ned Flanders");
        lista.adiciona("Sr. Burns");
        System.out.println(lista.imprimir());
//        
//        
//        
        lista.removeFim();
        System.out.println(lista.imprimir());
//        
//        
//        
        lista.remove(1);
        System.out.println(lista.imprimir() + "\n O tamanho e: " + lista.tamanho());
//        
//        
//        
        if(lista.contem("Marge")){
            System.out.println("Marge esta na lista");
        }
        else{
            System.out.println("Marge nao esta na lista");
        }
        
        if(lista.contem("Homer")){
            System.out.println("Homer esta na lista");
        }
        else{
            System.out.println("Homer nao esta na lista");
        }
        
        if(lista.contem("Bart")){
            System.out.println("Bart esta na lista");
        }
        else{
            System.out.println("Bart nao esta na lista");
        }
        
        if(lista.contem("Maggie")){
            System.out.println("Maggie esta na lista");
        }
        else{
            System.out.println("Maggie nao esta na lista");
        }
        
        System.out.println(lista.imprimir() + "\nO tamanho e: " + lista.tamanho());
        
//        
//        
        lista.removeComeco();
        System.out.println(lista.imprimir() + "\nO tamanho e: " + lista.tamanho());
//        
//        
//        
        if(lista.contem("Marge")){
            System.out.println("Marge esta na lista");
        }
        else{
            System.out.println("Marge nao esta na lista");
        }
        
        if(lista.contem("Homer")){
            System.out.println("Homer esta na lista");
        }
        else{
            System.out.println("Homer nao esta na lista");
        }
        
        if(lista.contem("Bart")){
            System.out.println("Bart esta na lista");
        }
        else{
            System.out.println("Bart nao esta na lista");
        }
        
        if(lista.contem("Maggie")){
            System.out.println("Maggie esta na lista");
        }
        else{
            System.out.println("Maggie nao esta na lista");
        }
        
        System.out.println(lista.imprimir() + "\nO tamanho e: " + lista.tamanho());
//        
//        
//        
        lista.esvaziarLista();
        System.out.println(lista.tamanho());
    }

}

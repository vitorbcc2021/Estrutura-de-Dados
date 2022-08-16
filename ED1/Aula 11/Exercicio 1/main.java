package ed1onzeum;

import java.util.Random;

public class Ed1OnzeUm {
    public static void main(String[] args) {
        Random rdm = new Random(); // Vou usar ele para sortear numeros de 1 a 20
        
        
        //Criando as pessoas
        Pessoa p01 = new Pessoa("Vitor", "9279-3740", "123.456.789-10", "Rua 1", 1);
        Pessoa p02 = new Pessoa("Andressa", "2546-2347", "3243.434.452-75", "Rua 2", 2);
        Pessoa p03 = new Pessoa("Micaela", "8987-4235", "845.834.345-54", "Rua 3", 3);
        Pessoa p04 = new Pessoa("Julio", "9999-9999", "999.999.999-99", "Rua 4", 4);
        Pessoa p05 = new Pessoa("Robson", "5555-5555", "555.555.555-55", "Rua 5", 5);
        Pessoa p06 = new Pessoa("Joao", "3232-3232", "323.232.323-23", "Rua 6", 6);
        Pessoa p07 = new Pessoa("Matheus", "5656-5656", "565.656.565-65", "Rua 7", 7);
        Pessoa p08 = new Pessoa("Gabriel", "7777-7777", "777.777.777-77", "Rua 8", 8);
        Pessoa p09 = new Pessoa("Pedro", "6666-6666", "666.666.666-66", "Rua 9", 9);
        Pessoa p10 = new Pessoa("Gustavo", "3333-3333", "333.333.333-33", "Rua 10", 10);
        Pessoa p11 = new Pessoa("Miguel", "4444-4444", "789.212.111-18", "Rua 11", 11);
        Pessoa p12 = new Pessoa("Leandro", "0000-0000", "022.042.990-44", "Rua 12", 12);
        Pessoa p13 = new Pessoa("Antonio", "3425-5853", "234.666.886-89", "Rua 13", 13);
        Pessoa p14 = new Pessoa("Savio", "7878-9876", "909.888.666-22", "Rua 14", 14);
        Pessoa p15 = new Pessoa("Lucas", "2020-3030", "300.400.500-60", "Rua 15", 15);
        Pessoa p16 = new Pessoa("Jose", "1111-1111", "111.111.111-11", "Rua 16", 16);
        Pessoa p17 = new Pessoa("Michel", "7644-9274", "143.444.442-44", "Rua 17", 17);
        Pessoa p18 = new Pessoa("Manoel", "2174-2747", "723.434.742-47", "Rua 18", 18);
        Pessoa p19 = new Pessoa("Renato", "7777-2444", "123.777.742-77", "Rua 19", 19);
        Pessoa p20 = new Pessoa("Clara", "1010-1010", "010.100.001-00", "Rua 20", 20);
        
        
        //Criando a lista
        ListaEncadeada list = new ListaEncadeada();
        
        
        //Inserindo elementos na lista
        list.adiciona(p01);
        list.adiciona(p02);
        list.adiciona(p03);
        list.adiciona(p04);
        list.adiciona(p05);
        list.adiciona(p06);
        list.adiciona(p07);
        list.adiciona(p08);
        list.adiciona(p09);
        list.adiciona(p10);
        list.adiciona(p11);
        list.adiciona(p12);
        list.adiciona(p13);
        list.adiciona(p14);
        list.adiciona(p15);
        list.adiciona(p16);
        list.adiciona(p17);
        list.adiciona(p18);
        list.adiciona(p19);
        list.adiciona(p20);
        
        int x = 20;
        
        while(list.tamanho() > 0){
            
            int numAleatorio = rdm.nextInt(0, x);
            x--; /* A medida que a lista for diminuinido de tamanho a variavel x tbm ira diminuir
                    para que os numeros aleatorios fiquem sempre proporcionais ao tamanho da lista*/
            
            Pessoa aleatoria = (Pessoa) list.pega(numAleatorio);
            
            System.out.printf("A lista contem: %d elementos\n\n\n", list.tamanho());
            
            if(list.tamanho() == 1){
                System.out.println("A ultima pessoa que restou e da posicao: " + aleatoria.getNumero());
                System.out.println("Nome: " + aleatoria.getNome() + "\nTelefone: " + aleatoria.getTelefone()
                        + "\nCPF: " + aleatoria.getCpf() + "\nEndereco: " + aleatoria.getEndereco() + "\n\n");
                
                break;
            }
            else{
                
                System.out.printf("""
                                  A pessoa da posicao %d foi removida!
                                  Nome: %s
                                  Telefone: %s
                                  CPF: %s
                                  Endereco: %s
                                  
                                  
                                  """,
                        aleatoria.getNumero(), aleatoria.getNome(), aleatoria.getTelefone(),
                        aleatoria.getCpf(), aleatoria.getEndereco());
                
                
                list.remove(numAleatorio); //apos mostrar os dados, ele remove o elemento
            }
        }
        
    }

}

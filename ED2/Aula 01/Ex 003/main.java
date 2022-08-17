public class App {
    public static void main(String[] args) {
        int fibo = fib(11);
        System.out.println(fibo);

        fibo = fibIterativo(11);
        System.out.println(fibo);

    }

    public static int fib(int n) {
        return(n<2?n:fib(n-1)+fib(n-2));
    }

    public static int fibIterativo(int n){
        int x = 0;
        int y = 1;
    
        if(n<2) return n;
        
        for(int z = 1; z < n; z++){
            int t = x + y;
            x = y;
            y = t;
        }
        return y;
    }

    /*  Um padrao observado e:
     *      Ambos irao ficar se repetindo e fazendo verificacoes
     *      ate que o algoritmo alcance a posicao 'n' e ele possa finalizar
     *      a busca pelo numero e retornar o resultado para a funcao!
     */
}

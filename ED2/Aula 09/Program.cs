using System;

namespace prog
{
class Aula009ED2
{
    static void Main(String[] args)
    {
        ArvoreBinaria arv = new ArvoreBinaria();
        
        Random rdm = new Random();
        
        Console.ForegroundColor = ConsoleColor.Cyan;

        for(int i = 0; i < 20; i++)
        {
            int num = rdm.Next(0, 100);
            Console.WriteLine("Inserindo: " + num);
            ArvoreBinaria.insere(arv, num);
        }
        
        Console.ForegroundColor = ConsoleColor.Green;

        Console.WriteLine("\nPre ordem:");
        ArvoreBinaria.preOrdem(arv);
        
        Console.WriteLine("\nIn ordem:");
        ArvoreBinaria.inOrdem(arv);
        
        Console.WriteLine("\nPos ordem:");
        ArvoreBinaria.posOrdem(arv);
        
        Console.WriteLine("\nEm nivel:");
        ArvoreBinaria.emNivel(arv);
        Console.WriteLine("\n");

        Console.ForegroundColor = ConsoleColor.White;
        
//##############################    Retirando elementos!  ############################################
        
        for(int i=0; i<5; i++)
        {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("Retirando: " + arv.getElemento());
            arv = ArvoreBinaria.retira(arv, arv.getElemento());
        }
        
        Console.ForegroundColor = ConsoleColor.Green;
        
        Console.WriteLine("\nPre ordem:");
        ArvoreBinaria.preOrdem(arv);
        
        Console.WriteLine("\nIn ordem:");
        ArvoreBinaria.inOrdem(arv);
        
        Console.WriteLine("\nPos ordem:");
        ArvoreBinaria.posOrdem(arv);
        
        Console.WriteLine("\nEm nivel:");
        ArvoreBinaria.emNivel(arv);
        Console.WriteLine("\n");

        Console.ForegroundColor = ConsoleColor.White;
    }
}
}
using System;

namespace prog
{
class Aula009ED2
{
    static void Main(String[] args)
    {
        ArvoreBinaria arv = new ArvoreBinaria();
        
        Random rdm = new Random();
        
        for(int i = 0; i < 20; i++)
        {
            int num = rdm.Next(0, 100);
            Console.WriteLine("Inserindo: " + num);
            ArvoreBinaria.insere(arv, num);
        }
        
        Console.WriteLine("\nPre ordem:");
        ArvoreBinaria.preOrdem(arv);
        
        Console.WriteLine("\nIn ordem:");
        ArvoreBinaria.inOrdem(arv);
        
        Console.WriteLine("\nPos ordem:");
        ArvoreBinaria.posOrdem(arv);
        
        Console.WriteLine("\nEm nivel:");
        ArvoreBinaria.emNivel(arv);
        Console.WriteLine("\n");
        
//##############################    Retirando elementos!  ############################################
        
        while(arv != null)
        {
            Console.WriteLine("Retirando: " + arv.getElemento());
            arv = ArvoreBinaria.retira(arv, arv.getElemento());
        }
        
        Console.WriteLine("\n");
        
        
//#############################    Inserindo novos elementos!  ######################################
        if(arv == null) arv = new ArvoreBinaria();

        for (int i = 0; i < 20; i++)
        {
            int num = rdm.Next(0, 100);
            Console.WriteLine("Inserindo: " + num);
            ArvoreBinaria.insere(arv, num);
        }
        
        Console.WriteLine("\nPre ordem:");
        ArvoreBinaria.preOrdem(arv);
        
        Console.WriteLine("\nIn ordem:");
        ArvoreBinaria.inOrdem(arv);
        
        Console.WriteLine("\nPos ordem:");
        ArvoreBinaria.posOrdem(arv);
        
        Console.WriteLine("\nEm nivel:");
        ArvoreBinaria.emNivel(arv);
        Console.WriteLine("\n");
        
    }
}
}
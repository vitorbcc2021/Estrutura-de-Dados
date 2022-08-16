#include <stdio.h>
#include <math.h>

void funcao(int *array){
    int entrada;
    int contador;
    int maior = -2147483648;
    int menor = 2147483647;

    for(int i=0; i<5; i++){
        scanf("%d", &entrada);
        array[i] = entrada;
    }

    for(int i=0; i<5; i++){
        if(array[i] > maior){
            maior = array[i];
        
        } else if(array[i] < menor){
            menor = array[i];
        }
    }

    for(int i=0; i<5; i++){
        if(array[i] == maior){
            contador++;
        }
    }

    printf("O maior valor e: %d\n", maior);
    printf("O maior valor do vetor se repete: %d", contador);
}

void main(){
    int a[5];
    funcao(&a);
}
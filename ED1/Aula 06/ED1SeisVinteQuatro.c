#include <stdio.h>

void funcao(int *V, int *min, int *max){
    int entrada;

    for(int i=0; i<5; i++){
        scanf("%d", &entrada);
        V[i] = entrada;
    }
    
    for(int i=0; i<5; i++){

        if(V[i] > *max){
            *max = V[i];
        }

        if(V[i] < *min){
            *min = V[i];
        }
    }
    
}

void main(){
    int array[5];
    int maior = -2147483648;
    int menor = 2147483647;

    funcao(&array, &menor, &maior);

    printf("\nO valor minimo deste array e: %d\n", menor);
    printf("O valor maximo deste array e: %d", maior);
}
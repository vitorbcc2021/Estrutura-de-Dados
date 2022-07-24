#include <stdio.h>

int negativos(float *vet, int N){
    float entrada;

    for(int i=0; i<5; i++){
        scanf("%f", &entrada);
        vet[i] = entrada;
    }
    
    for(int i=0; i<5; i++){
        if(vet[i] < 0){
            N++;
        }
    }

    return N;
}

void main(){
    float a[5];
    int numNegativo=0;

    printf("A quantidade de numeros negativos no vetor e: %d", negativos(&a, numNegativo));
}
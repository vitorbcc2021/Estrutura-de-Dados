#include <stdio.h>
#include <stdlib.h>

void funcao(float *nota1, float *nota2){
    scanf("%f", &*nota1);
    scanf("%f", &*nota2); 
}

float mediaSimples(float *nota1, float *nota2){
    float mSimples;

    mSimples = (*nota1 + *nota2)/2;

    return mSimples;
}

float mediaPonderada(float *nota1, float *nota2){
    float mPonderada;
    
    mPonderada = ((*nota1 + *nota2) * 2)/3;

    return mPonderada;
}

void main(){
    float n1, n2;
    float notaMedia;
    float notaPonderada;

    funcao(&n1, &n2);
    
    notaMedia = mediaSimples(&n1, &n2);
    notaPonderada = mediaPonderada(&n1, &n2);

    printf("A media simples e: %.2f", notaMedia);
    printf("\nA media ponderada e: %.2f", notaPonderada);

}
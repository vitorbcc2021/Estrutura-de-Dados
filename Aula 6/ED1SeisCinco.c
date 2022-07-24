#include <stdio.h>

void funcao(int *A, int *B){
    int C;

    if(*A < *B){
        C = *A;
        *A = *B;
        *B = C;
    }
}

void main(){
    int num1, num2;

    scanf("%d", &num1);
    scanf("%d", &num2);

    funcao(&num1, &num2);

    printf("A: %d\nB: %d", num1, num2);
    

    


    
}
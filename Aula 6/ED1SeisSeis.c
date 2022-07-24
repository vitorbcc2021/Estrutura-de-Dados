#include <stdio.h>

int funcao(int *A, int *B){
    int C;
    *A = *A * 2;
    *B = *B * 2;
    C = *A + *B;
    
    return C;
}

void main(){
    int num1, num2, num3;

    scanf("%d", &num1);
    scanf("%d", &num2);

    num3 = funcao(&num1, &num2);

    printf("\nA: %d\nB: %d\n", num1, num2);
    printf("\nA soma dos numeros e: %d", num3);
}
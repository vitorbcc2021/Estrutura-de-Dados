#include <stdio.h>

void funcao(int *A, int *B){
    int C;

    C = *A;
    *A = *B;
    *B = C;
    
}

void main(){
    int num1, num2;

    num1 = 1321;
    num2 = 2134;

    printf("Os valores de A e B sao:\nA: %d\nB: %d",num1, num2);

    funcao(&num1, &num2);

    printf("\nOs valores de A e B apos a mudanca sao:\nA: %d\nB: %d",num1, num2);

    
}
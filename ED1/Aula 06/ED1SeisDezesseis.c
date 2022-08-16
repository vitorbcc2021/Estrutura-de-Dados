#include <stdio.h>

void main(){
    int A, *B, **C, ***D;
    B = &A;
    C = &B;
    D = &C;

    printf("Insira um valor: ");
    scanf("%d", &A);

    printf("O dobro de A e: %d\n", *B * 2);
    printf("O Triplo de A e: %d\n", **C * 3);
    printf("O Quadruplo de A e: %d\n", ***D * 4);
}
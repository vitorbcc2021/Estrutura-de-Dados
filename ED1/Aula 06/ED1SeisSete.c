#include <stdio.h>

void soma(int *A, int *B){
    *A += *B;
}

void main(){
    int num1, num2;

    num1 = 76;
    num2= 24;

    soma(&num1, &num2);
    
    printf("O valor A apos a modificacao e: %d", num1);

}
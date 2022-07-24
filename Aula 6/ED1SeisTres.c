#include <stdio.h>
    /* 3. Escreva um programa que contenha duas variaveis inteiras. Leia essas variaveis do
       teclado. Em seguida, compare seus enderecos e exiba o conteudo do maior endereco */

void main(){
    int num1, num2;
    int *p1, *p2;

    printf("Digite dois valores inteiros: ");
    scanf("%d", &num1);
    scanf("%d", &num2);

    p1 = &num1;
    p2 = &num2;

    if(p1 > p2){
        printf("O maior endereco e o de p1: %d\nEndereco de p2: %d", p1, p2);
    } else{
        printf("O maior endereco e o de p2: %d\nEndereco de p1: %d", p2, p1);
    }
    
}
#include <stdio.h>
/*2. Escreva um programa que contenha duas variaveis inteiras. Compare seus enderecos e
    exiba o maior endereco */

void main(){
    //variaveis inteiras
    int num1, num2;

    num1 = 4;
    num2 = 1889;

    //ponteiros
    int *p1, *p2;
    
    p1 = &num1;
    p2 = &num2;


    //se for maior imprime o endereço da variável do ponteiro
    
    if(p1 > p2){
        printf("O maior endereco e p1: %d\nEndereco de p2: %d \n", p1, p2);
    } else{
        printf("O maior endereco e p2: %d\nEndereco de p1: %d \n", p2, p1);
    }
    
    

}
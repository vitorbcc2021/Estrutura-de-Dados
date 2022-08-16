#include <stdio.h>

void funcao(int *array){
    int i;
    int *p1;
    p1 = &i;

    for(*p1 = 0; *p1<5; *p1+=1){
        printf("Posicao %d: %d \n", *p1, array[*p1]);
    }
    
}

void main(){
    int a[5] = {12, 27, 46, 82, 99};
    
    funcao(&a);
    
}
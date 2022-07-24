#include <stdio.h>

void funcao(int *array, int *valor){
    int i;
    int *p1;
    p1 = &i;

    for(*p1 = 0; *p1<5; *p1+=1){
       scanf("%d", &*valor);
       array[*p1] = *valor; 
    }

    *p1 = 0; //reset o i após ser modificado no for

    for(*p1 = 0; *p1<5; *p1+=1){
        printf("Posicao %d: %d \n", *p1, array[*p1]);
    }
    
}

void main(){
    int a[5];
    int val;
    
    funcao(&a, &val);

}
#include <stdio.h>

int funcao(int *array1, int *array2){
    int array3[5];

    if(array1 > array2 || array2 > array1){
        return 0;
    }

    for(int i=0; i<5; i++){
        array3[i] = array3[i] + array1[i] + array2[i];
    }

    for(int i=0; i<5; i++){
        printf("Array3 na posicao %d e: %d", i, array3[i]);
    }

    return 1;
}

void main(){
    int a1[5] = {1, 3 , 5, 7 , 9};
    int a2[5] = {2 , 4, 6, 8, 10};
    int retorno;

    funcao(&a1, &a2);

}
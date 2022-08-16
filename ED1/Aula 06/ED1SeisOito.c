#include <stdio.h>

void main(){
    float array[10] = {12.3, 5.6, 16.7, 9.8, 5.7, 7.3, 9.2, 10.1, 99.9, 8};
    float *ponteiro;

    for(int i = 0; i<10; i++){
        ponteiro = &array[i];
        printf("Na posicao %d, temos o numero %.1f, com o endereco: %d\n", i, array[i], ponteiro);
    }
}
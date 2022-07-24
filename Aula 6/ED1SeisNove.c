#include <stdio.h>

void main(){
    float array[3][3] = {12.3, 5.6, 16.7, 9.8, 5.7, 7.3, 9.2, 10.1, 99.9};
    float *ponteiro;

    for(int i = 0; i<3; i++){
        for(int j = 0; j<3; j++){
        ponteiro = &array[i][j];
        printf("Na posicao Linha:%d Coluna: %d, temos o numero %.1f, com o endereco: %d\n", i, j, array[i][j], ponteiro);
        }
    }
}
#include <stdio.h>

void main(){
    int array[5];
    int *ponteiro;

    for(int i=0; i<5; i++){
        scanf("%d", &array[i]);

        ponteiro = &array[i];
        *ponteiro = *ponteiro * 2;
    }

    for(int i=0; i<5; i++){
        ponteiro = &array[i];
        printf("O dobro do valor que esta na posicao %d e: %d\n", i, *ponteiro);
    }
}
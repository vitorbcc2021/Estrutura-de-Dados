#include <stdio.h>

void main(){
    int array[5];
    int *ponteiro;

    for(int i=0; i<5; i++){
        scanf("%d", &array[i]);
    }

    for(int i=0; i<5; i++){
        if(array[i] % 2 == 0){
            ponteiro = &array[i];
            printf("O dobro do valor que esta na posicao %d e: %d\n", i, ponteiro);
        } else{
            continue;
        }
    }
}
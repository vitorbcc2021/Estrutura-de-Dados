#include <stdio.h>

void main(){
    int Array[5] = {23, 34, -25, 46, -1};
    int *p1;
    int i=0;
    
    p1 = &Array;

    while(i < 5){
        printf("Vetor na posicao %d e: %d\n", i, p1[i]+=1);
        i++;
    }
}
#include <stdio.h>

void frac(float num, int *inteiro, float *frac){
    *frac = num;
    *inteiro = (int) num;


    printf("Original: %f\nInteiro: %d\nFracionado: %.2f", num, *inteiro, *frac);

}

void main(){
    float n1 = 23.77;
    int n2;

    frac(n1, &n2, &n1);
}
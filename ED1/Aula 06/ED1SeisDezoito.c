#include <stdio.h>
#include <math.h>

void calc_esfera(float R, float *area, float *volume){
    float p = 3.1415;
    float A, V;
    
    A = 4 * p * pow(R,2);
    V = (4 * p * pow(R,3))/3;
    
    *area = A;
    *volume = V;
}

void main(){
    float R = 20.87;
    float area;
    float vol;
    
    calc_esfera(R, &area, &vol);

    printf("A area da superficie e: %.4f\n", area);
    printf("O volume da esfera e: %.4f", vol);
}
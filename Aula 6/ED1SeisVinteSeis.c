#include <stdio.h>
#include <math.h>

int raizes(float A, float B, float C, float *X1,float *X2){
    float delta;
    float raizPositiva;
    float raizNegativa;

    delta = B - ((4 * A) *C);
    
    if(delta < 0){
        printf("\nNão há nenhuma raiz real");
    } else if(delta == 0){
        printf("\nExiste uma raiz real");
    } else if(delta >= 0){
        printf("\nExistem duas raizes reais");
    }

    raizPositiva = (-B + sqrt(delta)) / (2*A);

}

void main(){
    float A, B, C;
}
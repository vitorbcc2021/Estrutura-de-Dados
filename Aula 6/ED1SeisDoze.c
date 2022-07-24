#include <stdio.h>

int ordenados(int *A, int *B, int *C){
    int D, E;
    if(*A > *C && *A > *B){ //se A for o maior valor joga em C
        D = *C;
        *C = *A;
        *A = D;
        if(*A > *B){ //se o B for menor que A jogue-o em A
            D = *B;
            *B = *A;
            *A = D;
        } else if(*B > *C){ //se B for maior que C
            D = *B;
            *B = *C;
            *C = D;
        }
    } else if(*C < *A && *C < *B){ //se C for o menor valor joga em A
        D = *A;
        *A = *C;
        *C = D;
        if(*A > *B){
            D = *B;
            *B = *A;
            *A = D;
        } else if(*B > *C){ //se B for maior que C
            D = *B;
            *B = *C;
            *C = D;
        }
    } else if(*B > *A && *B > *C){ //se B for o maior valor joga em C
        D = *B;
        *B = *C;
        *C = D;
        if(*A > *C){
            D = *A;
            *A = *C;
            *C = D;
        }
    } else if(*B < *A && *B < *C){ //se B for o menor valor joga em A
        D = *A;
        *A = *B;
        *B = D;
        if(*A > *C){
            D = *A;
            *A = *C;
            *C = D;
        }
    }
    if(*A == *B && *B == *C && *A == *C){
        return 1;
    } else if(*A != *B || *A != *C || *B != *C){
        return 0;
    }

}

void main(){
    int num1, num2, num3;

    scanf("%d", &num1);
    scanf("%d", &num2);
    scanf("%d", &num3);

    int retorno = ordenados(&num1, &num2, &num3);

    printf("A: %d\nB: %d\nC: %d\nRetorno: %d", num1, num2, num3, retorno);
}
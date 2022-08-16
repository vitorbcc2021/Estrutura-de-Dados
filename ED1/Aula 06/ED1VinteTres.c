#include <stdio.h>

void main(){
    int a[6];
    int *p1;
    int k;
    int maior = -2147483648;
    int entrada;

    p1 = &a;

    for(int i=0; i<6; i++){
        scanf("%d", &entrada);
        a[i] = entrada;
    }

    printf("Quantos elementos por linha vc quer? ");
    scanf("%d", &k);

    for(int i=0; i<6; i++){
        if(a[i] > maior){
            maior = a[i];
        }
    }

    for(int i=0; i<6; i++){
        for(int j=1; j<=k; j++){
            printf("%d ", p1[i]);
            i++;
            if(j==k){
                printf("\n");
            }
        }
          
    }
    

    printf("O maior elemento e: %d", maior);
    
}
#include <stdio.h>

int main()
{
    int c,k,f;
    char resp;

    printf("--------------------- Convertor de graus -------------------------------\n \n");
    printf("Digite uma temperatura em C: \n");
    scanf("%d",&c);
    printf("Deseja converter em Kelvin ou Fahrenheit? \n");
    scanf("%d",&resp);

    switch(resp){
        case 'Kelvin':
        k= c + 273.15;
        printf("A temperatura em Kelvin: %d",k);
        break;
        case 'Fahrenheit':
        f = c * 1.8 + 32;
        printf("A temperatura em Fahrenheit: %d",f);
        break;
        default:
        printf("Resposta Invalida");
        }
    return 0;
}

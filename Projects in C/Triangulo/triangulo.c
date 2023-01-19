#include <stdio.h>
#include <locale.h>

 int main(){
     setlocale(LC_ALL, "Portuguese");
     int a,b,c;
     printf("-----------------Identificador de Triangulo-----------------------\n\n");
     printf("Digite 3 valores para identificar se e um triangulo\n");
     scanf("%d %d %d",&a,&b,&c);
     if(a + b > c && b + c > a && c + a > b){
         printf("E um Triangulo\n");
         if(a==b && b==c && c==a){
             printf("Triangulo Equilatero");
            
         }else{
             if(a==c || a==b || c==a){
                 printf("Triangulo Isosceles");
             }else{
                 printf("Triangulo Escaleno");
             }
         }
     }
     else{
         printf("Nao é um triangulo");
     }
     
     return 0;
 }

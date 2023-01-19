#include <stdio.h>
#include <locale.h>

int main() {
  setlocale(LC_ALL, "Portuguese");
    float num1, num2, result;
    char op;

    printf("Digite um Numero: ");
    scanf("%f", &num1);

    printf("Escolha com o que fara o calculo: (+, -, *, /): ");
    scanf(" %c", &op);

    printf("Escolha o proximo numero: ");
    scanf("%f", &num2);

    switch (op) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            result = num1 / num2;
            break;
        default:
            printf("Invalido\n");
            return 0;
    }

    printf("%.2f %c %.2f = %.2f\n", num1, op, num2, result);

    return 0;
}

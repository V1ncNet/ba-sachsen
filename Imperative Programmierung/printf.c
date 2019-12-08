#include <stdio.h>

/* Prints 'Hello World!' to the console */
void greet(void);

/* Prints some sample math operations to the console */
int calc(int, int);

int main(int argc, char *argv[])
{
    greet();
    calc(42, 5);

    return 0;
}

void greet(void)
{
    printf("Hello World!\n");
}

int calc(int a, int b)
{
    if (0 == b)
    {
        return -1;
    }

    printf("Addition:       %d + %d = %d\n", a, b, a + b);
    printf("Substraciton:   %d - %d = %d\n", a, b, a - b);
    printf("Multiplication: %d * %d = %d\n", a, b, a * b);
    printf("Division:       %f / %f = %f\n", (double)a, (double)b, (double)a / (double)b);
    printf("Modulo:         %d mod %d = %d\n", a, b, a % b);

    return 0;
}

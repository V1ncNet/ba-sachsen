#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int rand_num(void);

int main(void)
{
    int i, special = 1, tries = 10;

    /* Seeds the rand method */
    srand(time(0));

    /* Prints 10 random numbers */
    printf("Print %d random numbers.\n", tries);
    for (i = 0; i < tries; i++) {
        rand_num();
    }

    /* Generate numbers until a special number occurres. */
    printf("\nPrint random numbers unti a special number occuures.\n");
    do {
        tries++;
        special = rand_num();
    } while (!special);

    printf("\nPrint more random numbers until the 'tries' counter reaches 20.\n");
    while (tries < 20) {
        tries++;
        rand_num();
    }
    printf("\nPrinted %d randum numbers.\n", tries);

    return 0;
}

int rand_num(void) {
    int val = rand() % 100;

    switch (val) {
        case 0:
        case 2:
        case 5:
        case 23:
        case 42:
        case 97:
            printf("Number is %d. Such special!\n", val);
            break;
        default:
            printf("Number %2d isn't special at all. LAME!\n", val);
            return 0;
    }

    return 1;
}

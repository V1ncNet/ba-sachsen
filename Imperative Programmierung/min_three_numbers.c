/* ref: Luntovskyy - KI-1 2.1 Minimum dreier Zahlen */
#include <stdio.h>
#include <stdlib.h>

int compare(const void *, const void *);

int main(void) {
    int numbers[3];

    printf("Dieses Programm gibt die kleinste von drei Zahlen, die der Nutzer eingibt zurück.\n\n");
    printf("Zahl a = ");
    fflush(stdin);
    scanf("%d", &numbers[0]);
    printf("Zahl b = ");
    fflush(stdin);
    scanf("%d", &numbers[1]);
    printf("Zahl c = ");
    fflush(stdin);
    scanf("%d", &numbers[2]);

    qsort(numbers, 3, sizeof(int), compare);

    printf("Die kleinste Zahl ist: %d\n", numbers[0]);

    return 0;
}

/* https://rosettacode.org/wiki/Sort_an_integer_array#C */
int compare(const void *aa, const void *bb) {
    const int *a = aa, *b = bb;
    return (*a < *b) ? -1 : (*a > *b);
}

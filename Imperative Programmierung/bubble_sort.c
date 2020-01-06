/* ref: Luntovskyy - KI-28 2.24 Sortiere ein Zufallsarray mit reellen Zahlen */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define LENGTH 50

void bubble_sort(float *, int);

int main(void) {
    int i;
    float array[LENGTH];
    srand(time(NULL));
    printf("Dieses Programm sortiert das folgende Array von %d zufälligen reellen Zahlen zwischen 1.0 und 100.0.\n", LENGTH);

    for (i = 0; i < LENGTH; i++) {
        array[i] = (1 + rand() % 10000) / 100.;
        printf("%.2lf\t", array[i]);
    }
    printf("\n\n");

    bubble_sort(array, LENGTH);
    printf("Sortiertes Array:\n");

    for (i = 0; i < LENGTH; i++) {
        printf("%.2lf\t", array[i]);
    }

    printf("\n");

    return 0;
}

/* https://de.wikibooks.org/wiki/Algorithmen_und_Datenstrukturen_in_C/_Bubblesort */
void bubble_sort(float *array, int length) {
    int i, j, tmp;

    for (i = 1; i < length; i++) {
        for (j = 0; j < length - i; j++) {
            if (array[j] > array[j + 1]) {
                tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
            }
        }
    }
}

/* ref: Luntovskyy - KI-6 2.6 6 x 6 würfeln! */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int die_throw(void);

int main(void) {
    int i = 0, curr, expected, hits = 0;
    srand(time(0));

    printf("Diese Programm gibt die Anzahl aus, die es gebracht hat um n Sechsen zu würflen.\n");
    printf("Anzahl n = ");
    fflush(stdin);
    scanf("%d", &expected);

    do {
        curr = die_throw();

        #ifdef DEBUG
        printf("Nach dem %d wurde eine %d wurde gewürfelt", i, curr);
        #endif
        if (curr == 6) {
            hits++;

            #ifdef DEBUG
            printf("\t HIT");
            #endif
        }
        #ifdef DEBUG
        printf("\n");
        #endif

        i++;
    } while(hits < expected);

    printf("Es wurden %d Versuche benötigt, um %d Sechsen zu würfeln.\n", i, expected);

    return 0;
}

int die_throw(void) {
    return (rand() % 6) + 1;
}

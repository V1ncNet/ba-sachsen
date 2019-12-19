/* ref: Luntovskyy - KI-3 2.3 Zufallszahlenermittlung und Würfel-Funktion */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int throw_die(void);

int main(void) {
    int i =0;
    srand(time(0));
    printf("Diese Programm würfelt so lange einen sechs-seitigen Würfel, bis die Augenzahl 4 erscheint.\n");

    do {
        i++;
        if (throw_die() == 4) {
            printf("Nach dem %d Versucht wurde eine 4 gewürfelt.\n", i);
            return 0;
        }
    } while(1);

    return 1;
}

int throw_die(void) {
    return (rand() % 6) + 1;
}

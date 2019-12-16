#include <stdio.h>
#include <stdlib.h>

#define BUFFER 20

int main(void) {
    int i, j;
    char text1[BUFFER + 1], text2[BUFFER + 1], zieltext[BUFFER * 2 + 1];

    printf("Eingabe 1: ");
    fflush(stdin);
    scanf("%20s", &text1[0]);

    printf("Eingabe 2: ");
    fflush(stdin);
    scanf("%20s", &text2[0]);

    for (i = 0; text1[i]; i++) {
        zieltext[i] = text1[i];
    }
    zieltext[i] = '\0';

    for (j = 0; text2[j]; j++, i++) {
        zieltext[i] = text2[j];
    }
    zieltext[i] = '\0';

    printf("\nZieltext: %s\n", zieltext);

    return 0;
}

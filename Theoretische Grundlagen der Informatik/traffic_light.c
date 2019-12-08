#include <stdio.h>
#include <stdlib.h>

void delay(void);
void fsm(void);

unsigned char state = 0;

int main(void) {
    while (1) {
        fsm();
        delay();
    }

    return 0;
}

void fsm(void) {
    printf("\n");

    switch (state) {
        case 0:
            system("clear");
            printf("\033[0;31mred\033[0m\n");
            printf("off\n");
            printf("off\n");

            state = 1;
            break;
        case 1:
            system("clear");
            printf("\033[0;31mred\033[0m\n");
            printf("\033[0;33myellow\033[0m\n");
            printf("off\n");

            state = 2;
            break;
        case 2:
            system("clear");
            printf("off\n");
            printf("off\n");
            printf("\033[0;32mgreen\033[0m\n");

            state = 3;
            break;
        case 3:
            system("clear");
            printf("off\n");
            printf("\033[0;33myellow\033[0m\n");
            printf("off\n");

            state = 0;
            break;
    }

    printf("\n");
}

void delay(void) {
    int i;

    for (i = 0; i < INT32_MAX; i++) {
    }
}

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

void usage(char *);
void print_ornament(int);
void print_trunk(void);
void print_top(void);
void print_body(void);

int tree_height = 12, last_n = 0;

int main(int argc, char *argv[]) {
    srand(time(0));

    if (2 == argc) {
        /* Print program usage if first argument reads 'help' */
        if (!strcmp("help", argv[1])) {
            usage(argv[0]);
            return 0;
        }

        tree_height = atoi(argv[1]);
    }

    print_top();
    print_body();
    print_trunk();

    if (4 >= tree_height) {
        printf("\nI highly recommend to choose a height greater than 4.\n\n");
        usage(argv[0]);
    }

    return 0;
}

/* Prints the Christmas tree top */
void print_top(void) {
    int i;

    printf("\n");
    for (i = 0; i < tree_height - 1; i++) {
        printf(" ");
    }

    printf("\033[0;31m()\033[0m");
}

/* Prints the Christmas tree trunk */
void print_trunk(void) {
    int i;

    for (i = 0; i < tree_height - 1; i++) {
        printf(" ");
    }
    printf("||\n");
}

/* Prints the Christmas tree body */
void print_body(void) {
    int row, column;

    /* tree_height - 1 to match the user's height argument */
    for (row = 0; row < tree_height - 1; row++) {
        /* Prints tree_height - row whitespaces */
        for (column = 0; column < tree_height - row; column++) {
            printf(" ");
        }

        /* Every second row will be a row with green leaf only */
        if (row % 2) {
            for (column = 0; column < row; column++) {
                printf("\033[0;32m/");
                printf("\\\033[0m");
            }
            printf("\n");
            continue;
        }

        /* Prints a row with ornaments */
        for (column = 0; column < row; column++) {
            print_ornament(rand());
        }

        printf("\n");
    }
}

/* Prints a segemnts which can contain an ornament */
void print_ornament(int n) {
    n = n % 100;

    /* Set n = 0 to avoid ornaments to be next to each other */
    if (84 <= last_n) {
        n = 0;
    }

    if (0 <= n && n < 84) {
        printf("\033[0;32m/");
        printf("\\\033[0m");
    } else if (84 <= n && n < 88) {
        printf("\033[0;31mo\033[0m");
        printf("\033[0;32m\\\033[0m");
    } else if (88 <= n && n < 92) {
        printf("\033[0;32m/\033[0m");
        printf("\033[0;31mo\033[0m");
    } else if (92 <= n && n < 96) {
        printf("\033[0;33m*\033[0m");
        printf("\033[0;32m\\\033[0m");
    } else /*if (96 <= n && n < 100)*/ {
        printf("\033[0;32m/\033[0m");
        printf("\033[0;33m*\033[0m");
    }

    last_n = n;
}

void usage(char *program_name) {
    printf("Usage:\n");
    printf("\t%s\t\tPrints a Christmas tree with a height of 12\n", program_name);
    printf("\t%s [height]\tPrints a Christmas tree with the given height\n", program_name);
    printf("\t%s help\tPrints this message\n", program_name);
}

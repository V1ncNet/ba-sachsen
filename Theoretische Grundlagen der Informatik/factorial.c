#include <stdio.h>
#include <stdlib.h>

unsigned long factorial_rec(unsigned long);
unsigned long factorial_ite(unsigned long);

int main(int argc, char *argv[]) {
    int i, n;

    if (2 != argc) {
        fprintf(stderr, "Usage: %s n\n", argv[0]);
        return 1;
    }

    n = atoi(argv[1]);

    for (i = 1; i <= n; i++) {
        printf("n = %3d\t\tf(n)=%-20lu\n", i, factorial_rec((unsigned long)i));
    }
}

unsigned long factorial_rec(unsigned long n) {
    if (2 > n) return 1;
    return n * factorial_rec(n - 1);
}

unsigned long factorial_ite(unsigned long n) {
    int i, product = 1;
    for (i = 1; i <= n; i++) product *= i;
    return product;
}

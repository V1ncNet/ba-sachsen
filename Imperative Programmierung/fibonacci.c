#include <stdio.h>
#include <stdlib.h>
#include <time.h>

unsigned long fibonacci_rec(unsigned long);
unsigned long fibonacci_ite(unsigned long);

int main(int argc, char *argv[]) {
    int i, n;
    clock_t begin;
    clock_t end;

    if (2 != argc) {
        fprintf(stderr, "Usage %s n", argv[0]);
    }
    

    n = atoi(argv[1]);

    if (0 > n) {
        fprintf(stderr, "First argument must be greater than 0.\n");
        exit(1);
    }

    printf("Generating Fibonacci-Numbers recursivly\n\n");
    begin = clock();
    for (i = 1; i <= n; i++) {
        printf("n = %3d\t\tf(n)=%-20lu", i, fibonacci_rec((unsigned long) i));
        end = clock();
        printf("after %fs\n", (double)(end - begin) / CLOCKS_PER_SEC);
    }

    printf("\nGenerating Fibonacci-Numbers using iterative algorithm\n\n");
    begin = clock();
    for (i = 1; i <= n; i++) {
        printf("n = %3d\t\tf(n)=%-20lu", i, fibonacci_ite((unsigned long) i));
        end = clock();
        printf("after %fs\n", (double)(end - begin) / CLOCKS_PER_SEC);
    }
    

    return 0;
}

unsigned long fibonacci_rec(unsigned long n) {
    if (0 == n || 1 == n) {
        return n;
    }

    return fibonacci_rec(n - 1) + fibonacci_rec(n - 2);
}

unsigned long fibonacci_ite(unsigned long n) {
    int i;
    unsigned long prev_prev, prev = 1, curr = 1;

    for (i = 2; i < n; i++) {
        prev_prev = prev + curr;
        prev = curr;
        curr = prev_prev;
    }

    return curr;
}

#include <stdio.h>
#include <stdlib.h>

unsigned long faculty_rec(unsigned long);
unsigned long faculty_ite(unsigned long);

int main(int argc, char* argv[]) {
    int i, n;

    if (2 != argc) {
        fprintf(stderr, "Usage: %s n\n", argv[0]);
        return 1;
    }

    n = atoi(argv[1]);

    for (i = 1; i <= n; i++) {
        printf("n = %3d\t\tf(n)=%-20lu\n", i, faculty_rec((unsigned long) i));
    }
}

unsigned long faculty_rec(unsigned long n) {
    if (2 > n) {
        return 1;
    }
    
    return n * faculty_rec(n - 1);
}

unsigned long faculty_ite(unsigned long n) {
    
}

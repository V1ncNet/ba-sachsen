/* ref: Luntovskyy - KI-4 2.4 Ermittlung ggT */
#include <stdio.h>
#include <stdlib.h>

int gcd_ite(int, int);
int gcd_rec(int, int);

int main(void) {
    int a, b;
    printf("Dieses Programm errechent den größten gemeinsamen Teiler eines Zahlenpaares (a, b).\n\n");

    printf("Zahl a = ");
    fflush(stdin);
    scanf("%d", &a);

    printf("Zahl b = ");
    fflush(stdin);
    scanf("%d", &b);

    printf("ggT(%d, %d)=%d (iterativ)\n", a, b, gcd_ite(a, b));
    printf("ggT(%d, %d)=%d (rekursiv)\n", a, b, gcd_rec(a, b));

    return 0;
}

int gcd_ite(int a, int b) {
    while (b != 0) {
        if (a > b) a = a - b;
        else b = b - a;
    }

    return a;
}

int gcd_rec(int a, int b) {
    if (a == b) return a;
    else {
        if (a > b) return gcd_rec(a - b, b);
        else return gcd_rec(b - a, a);
    }
}

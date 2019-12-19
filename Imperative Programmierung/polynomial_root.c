/* ref: Luntovskyy - KI-5 2.5 Quadratische Gleichungenin pq-Form und Wurzelberechnung nach Heron */
#include <stdio.h>
#include <stdlib.h>

#define ITER 256

double sqrt_heron(double);

int main(void) {
    double p, q, x1, x2;
    printf("Dieses Programm ermittelt die Nullstellen eines Polynom zweiten Grades mittels der pq-Formel. Der Koeffizient a_2 sei 1.\n\n");

    printf("x^2+px+q\n");
    printf("Wert von p = ");
    fflush(stdin);
    scanf("%lf", &p);
    printf("Wert von q = ");
    fflush(stdin);
    scanf("%lf", &q);
    printf("\n");

    x1 = -1 * (p / 2) + sqrt_heron(((p * p) / 4) - q);
    x2 = -1 * (p / 2) - sqrt_heron(((p * p) / 4) - q);

    printf("x_1 = %.3lf\n", x1);
    printf("x_2 = %.3lf\n", x2);

    return 0;
}

double sqrt_heron(double radicant) {
    int i = 0;
    double result = 10.;

    if (radicant < 0) {
        fprintf(stderr, "Der Radikant darf nicht kleiner 0 sein.\n");
        exit(1);
    }

    while (i <= ITER) {
        ++i;
        result = .5 * (result + (radicant / result));
    }

    return result;
}

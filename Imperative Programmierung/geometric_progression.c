/* ref: Luntovskyy - KI-8 2.8 Summe der geometrischen Folge */
#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int i, n, factor = -1;
    double sum;
    printf("Dieses Programm errechnet die Ergebnisse von drei Summenformeln und einem frei wählbarem n.\n\n");

    printf("Wert für n = ");
    fflush(stdin);
    scanf("%d", &n);
    printf("\n");

    printf("1. s(n)=1+1/2+1/3+1/4+....+1/n    = ");
    sum = 1.;
    for (i = 2; i <= n; ++i) sum += 1. / (double) i;
    printf("%.3lf\n", sum);

    printf("2. s(n)=1+1/3+1/5+1/7+.... +1/n   = ");
    sum = 1.;
    for (i = 3; i <= n; i += 2) sum += 1. / (double) i;
    printf("%.3lf\n", sum);

    printf("3. s(n)=1-1/2+1/3-1/4+-.... -+1/n = ");
    sum = 1.;
    for (i = 2; i <= n; i++) {
        sum += factor * (1. / (double) i);
        factor *= -1;
    }
    printf("%.3lf\n", sum);
    

    return 0;
}

/* ref: Luntovskyy - KI-10 2.10 Maclaurinsche Reihen */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define PI 3.1415926
#define ITER 128
#define EPS 0.0000001

double expo(double);
double sinu(double);
double cosi(double);
double factorial(double);

int main(void) {
    double x;

    printf("Dieses Programm implementiert Funktionen, die bereits in math.h existieren.\n\nGib eine Zahl x ein: ");
    fflush(stdin);
    scanf("%lf", &x);
    printf("\n");

    printf("expo(%.2lf)=%.2lf, exp(%.2lf)=%.2lf\n\n", x, expo(x), x, exp(x));
    printf("sinu(%.2lf)=%.2lf, sin(%.2lf)=%.2lf\n\n", x, sinu(x), x, sin(x));
    printf("cosi(%.2lf)=%.2lf, cos(%.2lf)=%.2lf\n\n", x, cosi(x), x, cos(x));

    return 0;
}

double expo(double x) {
    int i;
    double sum = 1., quot, dividend, divisor;

    for (i = 1; i < ITER; i++) {
        dividend = pow(x, (double)i);
        divisor = factorial((double) i);
        quot = dividend / divisor;
        if (fabs(quot) <= EPS) break;
        sum += quot;

        printf("%d. Iteration: quot=%.8lf\tsum=%.2lf\n", i, quot, sum);
    }

    return sum;
}

double sinu(double x) {
    int i;
    double sum = 0., seg, dividend, divisor;

    for (i = 0; i < ITER; i++) {
        dividend = pow(x, 2. * (double)i + 1);
        divisor = factorial(2. * (double)i + 1.);
        seg = pow(-1., i) * (dividend / divisor);
        if (fabs(seg) <= EPS) break;
        sum += seg;

        printf("%d. Iteration: seg=%.8lf\tsum=%.2lf\n", i, seg, sum);
    }

    return sum;
}

double cosi(double x) {
    int i;
    double sum = 0., seg, divid, divis;

    for (i = 0; i < ITER; i++) {
        divid = pow(x, 2. * (double)i);
        divis = factorial(2. * (double)i);
        seg = pow(-1., i) * (divid / divis);
        if (fabs(seg) <= EPS) break;
        sum += seg;

        printf("%d. Iteration: seg=%.8lf\tsum=%.2lf\n", i, seg, sum);
    }

    return sum;
}

double factorial(double n) {
    if (n == 0.) return 1.;
    return factorial(n - 1.) * n;
}

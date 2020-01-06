/* ref: Luntovskyy - KI-20 2.19 Erde-, Mond- und Marsschwerkraft */
#include <stdio.h>
#include <stdlib.h>

#define ITERATIONS 500
#define G_EARTH 9.81
#define G_MOON G_EARTH * .17
#define G_MARS 3.69

void g_earth(int);
void g_moon(int);
void g_mars(int);
void print_table(char *, float, void (*)(int));

int main(void) {
    printf("Dieses Programm errechnet die Gewichtskraft von Gegenständen auf unterschiedlichen Himmelskörpern.");

    print_table("der Erde", G_EARTH, g_earth);
    print_table("dem Mond", G_MOON, g_moon);
    print_table("dem Mars", G_MARS, g_mars);
    return 0;
}

void print_table(char *celes, float accel, void (*weight_calc)(int)) {
    int i;
    printf("\n\nGewicht auf %s bei Normalfallbeschleunigung: %.2lfm/s^2\n", celes, accel);
    weight_calc(1);
    for (i = 5; i < ITERATIONS; i += 5) {
        weight_calc(i);
    }
}

void g_earth(int mass) {
    printf("%dkg\t%.2lfN\n", mass, mass * G_EARTH);
}

void g_moon(int mass) {
    printf("%dkg\t%.2lfN\n", mass, mass * G_MOON);
}

void g_mars(int mass) {
    printf("%dkg\t%.2lfN\n", mass, mass * G_MARS);
}

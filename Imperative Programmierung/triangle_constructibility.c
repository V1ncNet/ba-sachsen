/* ref: Luntovskyy - KI-2 2.2 Konstruierbarkeit eines Dreiecks */
#include <stdio.h>
#include <stdlib.h>

#define BOLD "\033[1m"
#define RESET "\033[0m"

void print_res(int);

int main(void) {
    int a, b, c;
    printf("Diese Programm akzeptiert drei Eingaben, die als Länge der drei Seiten eines Dreiecks interpretiert werden.\n");
    printf("Die erste Zahl muss dabei die größte der drei Zahlen sein. Im Anschluss wird das konstuierte Dreieck auf ");
    printf(BOLD "Gleichseitigkeit" RESET ", " BOLD "Gleichschenkligkeit" RESET " und " BOLD "Rechtwinkligkeit" RESET " geprüft.\n\n");

    printf("Wert für Stecke a = ");
    fflush(stdin);
    scanf("%d", &a);
    printf("Wert für Stecke b = ");
    fflush(stdin);
    scanf("%d", &b);
    printf("Wert für Stecke c = ");
    fflush(stdin);
    scanf("%d", &c);

    /* SSS-Satz */
    if (b + c < a) {
        fprintf(stderr, "Das Dreieck ist nicht konstuierbar. a muss kleiner der Summe aus b und c sein.\n");
        return 1;
    }

    printf("\nDas Dreieck ist");
    printf("\n\t%-20s%-4s", "kostruierbar:", "ja");

    printf("\n\t%-20s", "gleichseitig:");
    print_res(a == b && a == c);

    printf("\n\t%-20s", "gleichschenklig:");
    print_res(a == b || a == c || b == c);

    printf("\n\t%-20s", "rechtwinklig:");
    print_res(a * a == b * b + c * c);

    printf("\n");
    return 0;
}

void print_res(int expr) {
    if (expr) {
        printf("%-4s", "ja");
    } else {
        printf("%-4s", "nein");
    }
}

CC = gcc
CFLAGS = -Wall -ansi -pedantic -Wmissing-prototypes -Wstrict-prototypes -Wold-style-definition

BIN = $(wildcard *.out)
OBJ = $(wildcard *.o)

.PHONY: all

all: christmas_tree fibonacci printf branching

christmas_tree: christmas_tree.o
	$(CC) -o $@.out $^

fibonacci: fibonacci.o
	$(CC) -o $@.out $^

printf: printf.o
	$(CC) -o $@.out $^

branching: branching.o
	$(CC) -o $@.out $^

%.o: %.c
	$(CC) $(CFLAGS) -c $^

%.out: %.o
	$(CC) -o $^

clean: $(BIN) $(OBJ)
	rm $^

CC = gcc
CFLAGS = -Wall -ansi -pedantic -Wmissing-prototypes -Wstrict-prototypes -Wold-style-definition

BINS = $(wildcard *.out)
OBJS = $(wildcard *.o)

all: christmas_tree fibonacci printf branching concat

concat: concat.o
	$(CC) -o $@.out $^

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

$(BINS): $(OBJS)
	$(CC) $(OBJS) -o $@

.PHONY: clean
clean:
	$(RM) $(BINS) $(OBJS)

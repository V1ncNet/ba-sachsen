CC = gcc
CFLAGS = -Wall -ansi -pedantic -Wmissing-prototypes -Wstrict-prototypes -Wold-style-definition

BINS = $(wildcard *.out)
OBJS = $(wildcard *.o)

all: \
	christmas_tree \
	fibonacci \
	printf \
	branching \
	concat \
	min_three_numbers \
	triangle_constructibility \
	die_throw \
	gcd \
	polynomial_root \
	dice_throw \
	geometric_progression \
	bubble_sort

bubble_sort: bubble_sort.o
	$(CC) -o $@.out $^

geometric_progression: geometric_progression.o
	$(CC) -o $@.out $^

dice_throw: dice_throw.o
	$(CC) -o $@.out $^

polynomial_root: polynomial_root.o
	$(CC) -o $@.out $^

gcd: gcd.o
	$(CC) -o $@.out $^

die_throw: die_throw.o
	$(CC) -o $@.out $^

triangle_constructibility: triangle_constructibility.o
	$(CC) -o $@.out $^

min_three_numbers: min_three_numbers.o
	$(CC) -o $@.out $^

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

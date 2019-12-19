CC = gcc
CFLAGS = -Wall -ansi -pedantic -Wmissing-prototypes -Wstrict-prototypes -Wold-style-definition

BINS = $(wildcard *.out)
OBJS = $(wildcard *.o)

all: factorial traffic_light

factorial: factorial.o
	$(CC) -o $@.out $^

traffic_light: traffic_light.o
	$(CC) -o $@.out $^

%.o: %.c
	$(CC) $(CFLAGS) -c $^

$(BINS): $(OBJS)
	$(CC) $(OBJS) -o $@

.PHONY: clean
clean:
	$(RM) $(BINS) $(OBJS)

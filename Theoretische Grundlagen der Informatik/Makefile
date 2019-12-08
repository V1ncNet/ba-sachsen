CC = gcc
CFLAGS = -Wall -ansi -pedantic -Wmissing-prototypes -Wstrict-prototypes -Wold-style-definition

BIN = $(wildcard *.out)
OBJ = $(wildcard *.o)

.PHONY: all

all: faculty traffic_light

faculty: faculty.o
	$(CC) -o $@.out $^

traffic_light: traffic_light.o
	$(CC) -o $@.out $^

%.o: %.c
	$(CC) $(CFLAGS) -c $^

%.out: %.o
	$(CC) -o $^

clean: $(BIN) $(OBJ)
	rm $^

package de.vinado.exercises.mvc.observer.adder;

import java.util.Observable;

/**
 * @author Vincent Nadoll
 */
public class Adder extends Observable {

    private int sum = 0;

    public Adder() {
    }

    public Adder(int initial) {
        this.sum = initial;
    }

    public int getSum() {
        return sum;
    }

    public void add(int summand) {
        sum += summand;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return String.valueOf(sum);
    }
}

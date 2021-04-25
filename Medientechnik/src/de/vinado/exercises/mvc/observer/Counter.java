package de.vinado.exercises.mvc.observer;

import java.util.Observable;

/**
 * @author Vincent Nadoll
 */
public class Counter extends Observable {

    private int count = 0;

    public void increment() {
        count++;
        setChanged();
        notifyObservers();
    }

    public void reset() {
        count = 0;
        setChanged();
        notifyObservers();
    }

    public int getCount() {
        return count;
    }

    @Override
    public synchronized String toString() {
        return String.valueOf(count);
    }
}

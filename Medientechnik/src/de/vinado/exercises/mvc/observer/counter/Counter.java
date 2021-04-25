package de.vinado.exercises.mvc.observer.counter;

import java.util.Observable;

/**
 * @author Vincent Nadoll
 */
public class Counter extends Observable {

    private final int max;

    private int count = 0;

    public Counter() {
        this.max = Integer.MAX_VALUE;
    }

    public Counter(int max) {
        this.max = max;
    }

    public void increment() throws Exception {
        try {
            if (max == count) {
                throw new Exception("Counter has reached its maximum");
            }

            count++;
        } finally {
            setChanged();
            notifyObservers();
        }
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

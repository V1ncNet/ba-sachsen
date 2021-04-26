package de.vinado.exercises.mvc.observer;

import java.util.Observable;

/**
 * @author Vincent Nadoll
 */
public class Notification extends Observable {

    private Notification() {
    }

    public void report(String message) {
        setChanged();
        notifyObservers(message);
    }

    public static void error(String message) {
        Notification notification = getInstance();
        notification.report(message);
    }

    public static Notification getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final Notification INSTANCE = new Notification();
    }
}

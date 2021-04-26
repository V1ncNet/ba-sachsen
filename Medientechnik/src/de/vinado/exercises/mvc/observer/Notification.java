package de.vinado.exercises.mvc.observer;

import java.awt.Component;
import java.util.Observable;

/**
 * @author Vincent Nadoll
 */
public class Notification extends Observable {

    private Notification() {
    }

    public void report(String message, Component component) {
        setChanged();
        notifyObservers(new NotificationEvent(component, message));
    }

    public static void error(String message, Component component) {
        Notification notification = getInstance();
        notification.report(message, component);
    }

    public static Notification getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final Notification INSTANCE = new Notification();
    }
}

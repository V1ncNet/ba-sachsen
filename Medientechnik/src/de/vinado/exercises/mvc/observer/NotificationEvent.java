package de.vinado.exercises.mvc.observer;

import java.awt.Component;
import java.util.EventObject;

/**
 * @author Vincent Nadoll
 */
public class NotificationEvent extends EventObject {

    private final String message;

    public NotificationEvent(Component source, String message) {
        super(source);

        this.message = message;
    }

    @Override
    public Component getSource() {
        return (Component) super.getSource();
    }

    public String getMessage() {
        return message;
    }
}

package de.vinado.exercises.mvc.observer.counter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author Vincent Nadoll
 */
public class ActionController implements ActionListener {

    public static final String INCREMENT_COMMAND = "INCREMENT";
    public static final String RESET_COMMAND = "RESET";
    public static final String CLOSE_COMMAND = "CLOSE";

    private final Map<String, Runnable> actions = new HashMap<>();

    public ActionController(Counter counter) {
        actions.put(INCREMENT_COMMAND, increment(counter));
        actions.put(RESET_COMMAND, counter::reset);
        actions.put(CLOSE_COMMAND, () -> System.exit(0));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        actions.keySet()
                .stream()
                .filter(equals(event.getActionCommand()))
                .findFirst()
                .map(actions::get)
                .ifPresent(Runnable::run);
    }

    private static Predicate<String> equals(String command) {
        return id -> Objects.equals(id, command);
    }

    private Runnable increment(Counter counter) {
        return () -> {
            try {
                counter.increment();
            } catch (Exception e) {
                onError(e.getMessage());
            }
        };
    }

    protected void onError(String message) {
    }
}

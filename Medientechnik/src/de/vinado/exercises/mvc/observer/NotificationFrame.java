package de.vinado.exercises.mvc.observer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Vincent Nadoll
 */
public class NotificationFrame extends JFrame implements Observer {

    private final JTextField messageTf = new JTextField();

    public NotificationFrame(Notification notification) throws HeadlessException {
        super("Alarm");

        messageTf.setEditable(false);
        messageTf.setMargin(new Insets(10, 10, 10, 10));
        getContentPane().add(messageTf);

        notification.addObserver(this);
    }

    public void error(String message) {
        messageTf.setText(message);

        pack();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Notification) {
            NotificationEvent event = (NotificationEvent) arg;
            setLocationRelativeTo(event.getSource());
            error(String.valueOf(event.getMessage()));
        }
    }
}

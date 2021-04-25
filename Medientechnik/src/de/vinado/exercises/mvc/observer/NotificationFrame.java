package de.vinado.exercises.mvc.observer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.HeadlessException;
import java.awt.Insets;

/**
 * @author Vincent Nadoll
 */
public class NotificationFrame extends JFrame {

    private final JTextField messageTf = new JTextField();

    public NotificationFrame() throws HeadlessException {
        super("Alarm");

        messageTf.setEditable(false);
        messageTf.setMargin(new Insets(10, 10, 10, 10));
        getContentPane().add(messageTf);
    }

    public void error(String message) {
        messageTf.setText(message);

        pack();
        setVisible(true);
    }
}

package de.vinado.exercises.mvc.observer.adder;

import de.vinado.exercises.mvc.observer.Notification;
import de.vinado.exercises.mvc.observer.NotificationFrame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;

/**
 * @author Vincent Nadoll
 */
public class AdderApplication extends JFrame implements Observer {

    private final JTextField resultTf = new JTextField(10);

    public AdderApplication(Adder adder) throws HeadlessException {
        super("Adder");

        JPanel resultPanel = new JPanel();
        resultPanel.add(new JLabel("Result"));

        resultTf.setEditable(false);
        resultTf.setText(adder.toString());
        resultPanel.add(resultTf);
        add(resultPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Input"));

        JTextField inputTf = new JTextField(5);
        inputPanel.add(inputTf);
        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton incrementBtn = new JButton("Add");
        incrementBtn.addActionListener(addFrom(inputTf, adder::add));
        buttonPanel.add(incrementBtn);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> System.exit(0));
        buttonPanel.add(closeBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        adder.addObserver(this);
        pack();
        setVisible(true);
    }

    private ActionListener addFrom(JTextField inputTf, Consumer<Integer> adder) {
        return event -> {
            try {
                String input = inputTf.getText();
                int summand = Integer.parseInt(input);
                adder.accept(summand);
            } catch (NumberFormatException e) {
                Notification.error("Cannot parse input as integer");
            }
        };
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Adder) {
            Adder adder = (Adder) o;
            resultTf.setText(adder.toString());
        }
    }

    public static void main(String[] args) {
        Adder adder = new Adder();
        new AdderApplication(adder);

        Notification notification = Notification.getInstance();
        new NotificationFrame(notification);
    }
}

package de.vinado.exercises.mvc.observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Vincent Nadoll
 */
public class CounterApplication extends JFrame implements Observer {

    private final JTextField valueDisplay = new JTextField(10);
    private final NotificationFrame notificationFrame = new NotificationFrame();

    public CounterApplication(Counter counter) throws HeadlessException {
        super("Counter");

        JPanel valuePanel = new JPanel();
        valuePanel.add(new JLabel("Counter Value"));

        valuePanel.add(valueDisplay);
        valueDisplay.setEditable(false);
        valueDisplay.setText(counter.toString());
        add(valuePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        ActionController controller = new ActionController(counter) {
            @Override
            public void onError(String message, Throwable e) {
                notificationFrame.setLocationRelativeTo(CounterApplication.this);
                notificationFrame.error(message);
            }
        };

        JButton incrementBtn = new JButton("Increment");
        incrementBtn.setActionCommand(ActionController.INCREMENT_COMMAND);
        incrementBtn.addActionListener(controller);
        buttonPanel.add(incrementBtn);

        JButton resetBtn = new JButton("Reset");
        resetBtn.setActionCommand(ActionController.RESET_COMMAND);
        resetBtn.addActionListener(controller);
        buttonPanel.add(resetBtn);

        JButton closeBtn = new JButton("Close");
        closeBtn.setActionCommand(ActionController.CLOSE_COMMAND);
        closeBtn.addActionListener(controller);
        buttonPanel.add(closeBtn);

        add(buttonPanel, BorderLayout.SOUTH);

        counter.addObserver(this);
        pack();
        setVisible(true);
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Counter) {
            Counter counter = (Counter) o;
            valueDisplay.setText(counter.toString());
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter(2);
        new CounterApplication(counter);
    }
}

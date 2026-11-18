package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("SimpleGUI");
    private final Controller controller = new SimpleController();

    public SimpleGUI() {
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea(10, 40);
        textArea.setEditable(false);
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        final JPanel panel = new JPanel();
        panel.add(print);
        panel.add(showHistory);
        frame.add(textField, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        * handlers
        */
        print.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    controller.setNextString(textField.getText());
                    controller.printCurrentString();
                }
            }
        );
        showHistory.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    textArea.setText("");
                    for (String s : controller.getHistory()) {
                        textArea.append(s + "\n");
                    }
                }
            }
        );
    }

    private void display() {
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main() {
        new SimpleGUI().display();
    }
}

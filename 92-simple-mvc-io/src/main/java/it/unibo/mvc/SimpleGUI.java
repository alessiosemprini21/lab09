package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("SimpleGUI");
    private final Controller controller = new Controller();

    public SimpleGUI() {
        final JTextArea textArea = new JTextArea(10, 40);
        final JPanel container = new JPanel(new BorderLayout());
        final JButton save = new JButton("Save");
        container.add(save, BorderLayout.SOUTH);
        container.add(textArea);
        frame.add(container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        *handlers
        */
       save.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    final String text = textArea.getText();
                    try {
                        controller.saveOnFile(text);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
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

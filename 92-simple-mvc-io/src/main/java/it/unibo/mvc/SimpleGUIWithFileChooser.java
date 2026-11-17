package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("SimpleGUIWithFileChooser");
    private final Controller controller = new Controller();

    public SimpleGUIWithFileChooser() {
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea(10, 40);
        final JPanel container = new JPanel(new BorderLayout());
        final JPanel northPanel = new JPanel(new BorderLayout());
        textField.setEditable(false);
        textField.setText(controller.getFilePath());
        final JButton browse = new JButton("Browse...");
        final JButton save = new JButton("Save");
        northPanel.add(textField, BorderLayout.CENTER);
        northPanel.add(browse, BorderLayout.LINE_END);
        container.add(save, BorderLayout.SOUTH);
        container.add(northPanel, BorderLayout.NORTH);
        container.add(textArea, BorderLayout.CENTER);
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
                    } catch (final IOException e) {
                        JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        );
        browse.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    final JFileChooser fileChooser = new JFileChooser();
                    final int dialog = fileChooser.showSaveDialog(frame);
                    if (JFileChooser.APPROVE_OPTION == dialog) {
                        controller.setFile(fileChooser.getSelectedFile());
                        textField.setText(controller.getFilePath());
                    } else if (JFileChooser.CANCEL_OPTION != dialog) {
                        JOptionPane.showMessageDialog(frame, "ERROR", "Error", JOptionPane.ERROR_MESSAGE);
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
        new SimpleGUIWithFileChooser().display();
    }
}

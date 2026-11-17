package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {
        final JTextField textField = new JTextField();
        final JPanel panel = new JPanel();
        final JButton browse = new JButton("Browse");
        panel.add(browse, BorderLayout.NORTH);
        /*
        *handlers
        */
        browse.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent ignored) {
                    final JFileChooser fileChooser = new JFileChooser();
                    if (fileChooser.showSaveDialog(browse) == (fileChooser.APPROVE_OPTION)) {

                    }
                    if (fileChooser.showSaveDialog(browse) == (fileChooser.APPROVE_OPTION) ||
                        fileChooser.showSaveDialog(browse) == (fileChooser.CANCEL_OPTION)) {
                            JOptionPane.showMessageDialog(frame, "Error");
                        }
                }
            }
        );
    }
}

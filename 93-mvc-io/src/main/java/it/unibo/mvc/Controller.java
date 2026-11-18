package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    /**
     * set the next string to print
     * 
     * @param s represent the string to print next
     * @throws IllegalArgumentException if the string is null
     */
    void setNextString(String s);

    /**
     * get the next string to print
     * 
     * @return the next string to print, or return null if no string has been set yet
     */
    String getNextString();

    /**
     * get the history of the printed strings
     * 
     * @return a list of strings representing the history of what was printed, empty list if nothing has been printed yet
     */
    List<String> getHistory();

    /**
     * print the current string on standard output
     * 
     * @throws IllegalStateException if no string has been set yet
     */
    void printCurrentString();
}

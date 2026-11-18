package it.unibo.mvc;

import java.util.List;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    /**
     * a method for setting the next string to print, 
     * if the string is null @throws IllegalArgumentException
     */
    void setNextString(String s);

    /**
     * a method for getting the next string to print
     * if there is not a next string an exception should be produced
     * @return the next string to print or return null if no string
     * has been set yet
     */
    String getNextString();

    /**
     * a method for getting the history of the printed strings
     * @return a list of strings representing the history of what was printed
     * return an empty list if nothing was printed
     */
    List<String> getHistory();

    /**
     * a method that print the current string
     * if the current string is unset @throws IllegalStateException
     */
    void printCurrentString();
}

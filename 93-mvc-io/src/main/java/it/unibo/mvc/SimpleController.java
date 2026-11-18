package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {
    
    private String next;
    private final List<String> history = new ArrayList<>();

    @Override
    public void setNextString(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("The string to set next is null");
        }
        this.next = s;
    }

    @Override
    public String getNextString() {
        return this.next;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(this.history);
    }

    @Override
    public void printCurrentString() {
        if (this.next == null) {
            throw new IllegalStateException("The string to print is null");
        }
        IO.println(this.next);
        this.history.add(this.next);
    }

}

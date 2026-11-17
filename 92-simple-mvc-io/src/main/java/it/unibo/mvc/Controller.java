package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;


/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File file;

    /**
     * 0-arguments contructor for the Controller class that
     * set by default "output.txt" as current file
     */
    public Controller() {
        final String path = System.getProperty("user.home")
            + File.separator
            + "output.txt";
        this.file = new File(path);
    }

    /**
     * method to change file
     * @param newFile refers to the file we want to use next
     */
    public void setFile(final File newFile){
        this.file = newFile;
    }

    /**
     * getter file to get the current file
     * @return the file we are working with
     */
    public File getFile() {
        return this.file;
    }

    /**
     * getter method for the file absolute path
     * @return the file absolute path
     */
    public String getFilePath() {
        return this.file.getAbsolutePath();
    }

    /**
     * method to write a string on our selected file
     * @param content refers to the string we want to write on the file
     * @throws IOException
     */
    public void saveOnFile(final String content) throws IOException {
        try (PrintStream ps = new PrintStream(this.file, StandardCharsets.UTF_8)) {
            ps.print(content);
        } 
    }
    
}

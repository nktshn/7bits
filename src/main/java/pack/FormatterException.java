package pack;

/**
 * Custom formatter exception.
 */
public class FormatterException extends Exception {
    /**
     * Constructor
     * @param message gives a message
     * @param e gives exception
     */
     FormatterException(final String message, final Exception e) {
         super(message);
         e.printStackTrace();
    }
}

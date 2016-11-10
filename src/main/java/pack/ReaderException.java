package pack;

/**
 * Reader exception
 */
 class ReaderException extends Exception {
    /**
     * Reader constructor
     * @param message gives a message
     * @param e gives exception
     */
     ReaderException(final String message, final Exception e) {
         super(message);
         e.printStackTrace();
    }
}

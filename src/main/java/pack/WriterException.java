package pack;

/**
 * Writer exception
 */
 class WriterException extends Exception {
    /**
     * Writer constructor
     * @param message gives a message
     * @param e gives exception
     */
    WriterException(final String message, final Exception e) {
        super(message);
        e.printStackTrace();
    }
}

package pack;

/**
 * Writing class
 */
 class Writer implements IWriter {
    /**
     * Method to write result
     * @param result  - result string
     */
    @Override
    public void write(final StringBuilder result) throws WriterException {
        try {
            System.out.println(String.valueOf(result));
        } catch (Exception e) {
            throw new WriterException("Can't write a text", e);
        }
    }
}

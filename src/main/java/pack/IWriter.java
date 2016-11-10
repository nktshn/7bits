package pack;

/**
 * Writer interface
 */
 interface IWriter {
    /**
     * Method to write result
     * @param result - result string
     */
     void write(StringBuilder result) throws WriterException;
}

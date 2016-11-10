package pack;

/**
 * Reader interface
 */
 interface IReader {
    /**
     * Reades a file
     * @param path receiving path to a file, ignored;
     * @param filename receiving name of file;
     */
     void read(String path, String filename) throws ReaderException;
    /**
     * Reads a string
     * @param str receiving string
     */
     void read(String str);

}

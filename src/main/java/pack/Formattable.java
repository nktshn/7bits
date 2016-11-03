package pack;

/**.
 * Interface for formatting.
 */
    public interface Formattable {
    /**.
     * Method to format.
     * @param path receiving path to a file, ignored;
     * @param filename receiving name of file;
     */
     void format(String path, String filename);
    }

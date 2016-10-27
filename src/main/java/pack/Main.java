package pack;
/**.
 * Main class
 */

public final class Main {
    /**.
     * constructor
     */
    private Main() {

    }
    /**
     * main method.
     * @param args command line args, ignored;
     */

    public static void main(final String[] args) {
        Formatter.format("src/main/resources/", "not_formatted_text.txt");
    }
}

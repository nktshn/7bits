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

    public static void main(final String[] args) throws Exception {
        try {
            Reader rd = new Reader();
            rd.read("src/main/resources/", "not_formatted_text.txt");
            Formatter f = new Formatter();
            f.format(rd.buff, rd.sb);
            Writer writer = new Writer();
            writer.write(f.result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package tests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pack.Formatter;


/**.
 *  Testing class to test "Formatter"
 */
public class FormatterTest {;
    /**.
     *  Object to testing.
     */
    private Formatter form;

    @Before
    public void setUp() {
        form = new Formatter();
    }
    @Test
    public void testFormat() {
        form.format("src/main/resources/", "not_formatted_text.txt");
         String control = "\uFEFFpackage com.company;\n" +
                 "import java.util.Arrays;\n" +
                 "public class Main {\n" +
                 "    public static void main(String[] args) {\n" +
                 "        System.out.println(\"Zdarova\");\n" +
                 "        writer();\n" +
                 "        }\n" +
                 "    public static void writer(){\n" +
                 "        int a[] = new int[]{1, 2, 3, 4};\n" +
                 "        int k=a[i];\n" +
                 "        a[i]=a[a.length-i];\n" +
                 "        a[a.length-i]=k;\n" +
                 "        }\n" +
                 "    System.out.println(Arrays.toString(a));\n" +
                 "    }\n\n";
        Assert.assertEquals(control, form.result);
    }


}

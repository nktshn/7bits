package tests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pack.Formatter;
import pack.FormatterException;
import pack.Reader;


/**.
 *  Testing class to test "Formatter"
 */
public class FormatterTest {;
    /**.
     *  Object to testing.
     */
    private Formatter form;
    private Reader rd;
    @Before
    public void setUp() {
         form = new Formatter();
         rd = new Reader();
    }
    @Test
    public void testFormat() throws FormatterException {
        String badcode = "int k=a[i];a[i]=a[a.length-i];a[a.length-i]=k;";
        String goodcode =   "int k=a[i];\n" +
                            "a[i]=a[a.length-i];\n" +
                            "a[a.length-i]=k;\n";
        rd.read(badcode);
        form.format(rd.buff, rd.sb);
        Assert.assertEquals(goodcode, String.valueOf(form.result));
    }


}

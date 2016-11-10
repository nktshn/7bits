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
    @Test()
    public void testFormat() throws FormatterException {
        //TEST 1
        String badcode = "int k=a[i];a[i]=a[a.length-i];a[a.length-i]=k;";
        String goodcode =   "int k=a[i];\n" +
                            "a[i]=a[a.length-i];\n" +
                            "a[a.length-i]=k;\n";
        rd.read(badcode);
        form.format(rd.buff, rd.sb);
        Assert.assertEquals(goodcode, String.valueOf(form.result));
        //TEST 2
        String badcode2 = "\"Zdarova,ya - ;\"";
        String goodcode2 = "\"Zdarova,ya - ;\"";
        rd.read(badcode2);
        form.format(rd.buff, rd.sb);
        Assert.assertEquals(goodcode2, String.valueOf(form.result));
        //TEST 3
        String badcode3 = "int k = a[i];//some comment\n" +
                          "a[i] = a[a.length-i];a[a.length - i] = k;";
        String goodcode3 = "int k = a[i];//some comment\n" +
                           "a[i] = a[a.length-i];\n" +
                           "a[a.length - i] = k;\n";
        rd.read(badcode3);
        form.format(rd.buff, rd.sb);
        Assert.assertEquals(goodcode3, String.valueOf(form.result));
        //TEST 4
        String badcode4 = "/*multiline comment with \";\" symbol*/\n";
        String goodcode4 = "/*multiline comment with \";\" symbol*/\n";
        rd.read(badcode4);
        form.format(rd.buff, rd.sb);
        Assert.assertEquals(goodcode4, String.valueOf(form.result));
    }



}

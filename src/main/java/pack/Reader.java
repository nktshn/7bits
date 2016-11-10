package pack;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads file or string
 */
 public final class Reader implements IReader {
    /**
     * string
     */
    public StringBuilder sb;
    /**
     * char array
     */
    public char[] buff;
    /**
     * Reads a file
     * @param path receiving path to a file, ignored;
     * @param filename receiving name of file;
     */
    public void read(final String path, final String filename) throws ReaderException {
        File file = new File(path + filename);  //path and name of text file
        sb = new StringBuilder((int) file.length());
        try (FileReader reader = new FileReader(file)) {
            buff = new char[(int) file.length()]; //char array
                                                //for working with cycles
            reader.read(buff);          //sending text from file to char array
            sb.append(buff);            //adding text from char array to string builder
        } catch (IOException e) {
            throw new ReaderException("Can't read a file", e);
            }
    }
    /**
     * Reads string
     * @param str receiving string
     */
    public void read(final String str) {
        sb = new StringBuilder(str.length());
        buff = new char[str.length()];
        buff = str.toCharArray();
        sb.append(buff);
    }
}

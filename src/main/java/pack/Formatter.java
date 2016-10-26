package pack;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class for formatting some code.
 */

public final class Formatter {
    /**
     * formatting method.
     * @param path receiving path to a file, ignored;
     * @param filename receiving name of file;
     */

    public static void format(final String path,
                              final String filename) { //method receiving
        File file = new File(path + filename);  //path and name of text file
        StringBuilder sb = new StringBuilder((int) file.length());

        try (FileReader reader = new FileReader(file)) {
            char[] buff;
            buff = new char[(int) file.length()]; //char array
                                                  //for working with cycles
            reader.read(buff); //sending text from file to char array
            sb.append(buff); //adding text from char array to string builder
            int count = 0;  //simple counter of ';'
            int tabs = 0;   //counter of current paragraphs

            for (int i = 0; i < sb.length(); i++) {  //counting ';' symbols
                if (buff[i] == ';') {
                    count++;
                }
            }
                                            //MAIN CYCLE:
            for (int i = 0, j = 1; i < buff.length; i++) {
                if (j > count) {   //second limiter of cycle
                    break;
                } else {
                    if (buff[i] == ';') {
                        sb.insert(i + 1, '\n');
                        for (int k = 0; k < tabs; k++) {
                            sb.insert(i + 2, "    "); //inserting paragraphs
                                                      // to each new lines
                        }
                        String s = String.valueOf(sb); //overwriting our
                                                       // char array
                        buff = s.toCharArray();        //
                        j++;
                        count++;
                    }
                    if (buff[i] == '{') {
                        if (buff[i - 1] == ']') {      //protection of
                                                       // initialized arrays
                            continue;
                        }
                        tabs++;
                        sb.insert(i + 1, '\n');
                        for (int k = 0; k < tabs; k++) {
                            sb.insert(i + 2, "    ");
                        }
                        String s = String.valueOf(sb);
                        buff = s.toCharArray();
                        j += 5;
                        count += 5;
                    }
                    if (buff[i] == '}') {
                        if (buff[i + 1] == ';') { //protection of initialized
                                                  // arrays
                            continue;
                        }
                        tabs--;
                        sb.insert(i + 1, '\n');
                        for (int k = 0; k < tabs; k++) {
                            sb.insert(i + 2, "    ");
                        }
                        String s = String.valueOf(sb);
                        buff = s.toCharArray();
                        j++;
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(sb));
    }
}

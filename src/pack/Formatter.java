package pack;


import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.*;

/**
 * Created by nick on 19.10.16.
 */
public class Formatter {
    public static void format(String path, String filename){
        File file = new File(path+filename);
        StringBuilder sb = new StringBuilder((int)file.length());

        try(FileReader reader = new FileReader(file)) {
            char[] buff = new char[(int) file.length()];
            reader.read(buff);
            sb.append(buff);
            int count = 0;

            for (int i = 0; i < (int) file.length(); i++) {
                if (buff[i] == ';') {
                    count++;

                }
            }
            for (int i = 0, j = 1; i < (int) file.length(); i++) {
                if (j > count)
                    break;
                else {
                    if (buff[i] == ';') {
                        sb.insert(i + j, '\n');
                        j++;
                    }
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(sb));
//        try(FileWriter writer = new FileWriter(path+"formatted_text.txt", false))
//        {
//
//            writer.write(String.valueOf(sb));
//            writer.flush();
//            writer.close();
//        }
//        catch(IOException ex){
//        }

    }
}

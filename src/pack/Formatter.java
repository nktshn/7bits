package pack;


import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.*;

/**
 * Created by nick on 19.10.16.
 */
public class Formatter {
    public static void format(String path, String filename){
        String[] keywords = {"for","if","switch","while","[]"};
        File file = new File(path+filename);
        StringBuilder sb = new StringBuilder((int)file.length());

        try(FileReader reader = new FileReader(file)) {
            char[] buff = new char[(int) file.length()];
            reader.read(buff);
            sb.append(buff);
            int count = 0;
            int tabs=0;

            for (int i = 0; i < (int) file.length(); i++) {
                if (buff[i] == ';') {
                    count++;

                }
            }
                                            //MAIN CYCLE:
            for (int i = 0, j = 1; i < (int) file.length(); i++) {
                if (j > count)
                    break;
                else {

                    if (buff[i] == ';') {
                        //sb.insert(i + j, '\n');
                        sb.insert(i+1, '\n');
                        for(int k=0; k < tabs; k++) {
                            sb.insert(i + 2, "    ");
                        }
                        String s = String.valueOf(sb);
                        buff = s.toCharArray();


                        j++;
                        count++;
                    }
                    if(buff[i]=='{'){
                        if(buff[i-1]==']'){
                            continue;
                        }
                        tabs++;
                        sb.insert(i+1, '\n');
                        for(int k=0; k < tabs; k++) {
                            sb.insert(i + 2, "    ");
                        }
                        String s = String.valueOf(sb);
                        buff = s.toCharArray();
                        j+=5;
                        count+=5;

                    }
                    if(buff[i]=='}'){
                        if(buff[i+1]==';'){
                            continue;
                        }
                        tabs--;
                        sb.insert(i + 1, '\n');
                        for(int k=0; k < tabs; k++) {
                            sb.insert(i + 2, "    ");
                        }
                        String s = String.valueOf(sb);
                        buff = s.toCharArray();
                        j++;
                        count++;

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

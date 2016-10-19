package pack;


import java.io.*;

/**
 * Created by nick on 19.10.16.
 */
public class Formatter {
    public static void format(String path, String filename){
        File file = new File(path+filename);
        StringBuilder sb = new StringBuilder((int)file.length());

        try(FileReader reader = new FileReader(file))
        {
            char[] buff = new char[(int)file.length()];
            int index;
            reader.read(buff);
            sb.append(buff);
            for (int i = 0; i <(int)file.length(); i++) {
                if (buff[i]==';') {
                    index = (int)buff[i]; //mb w/o int
                    sb.insert(index, '\n');
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try(FileWriter writer = new FileWriter(path+"formatted_text.txt", false))
        {

            writer.write(String.valueOf(sb));
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
        }

    }
}

package pack;

import java.io.*;

/**
 * Created by nick on 19.10.16.
 */

public class Formatter {
    public static void format(String path, String filename){            //method receiving path and name of text file
        //String[] keywords = {"for","if","switch","while","[]"};
        File file = new File(path+filename);
        StringBuilder sb = new StringBuilder((int)file.length());

        try(FileReader reader = new FileReader(file)) {
            char[] buff = new char[(int) file.length()];                //char array for working with cycles
            reader.read(buff);                                          //sending text from file to char array
            sb.append(buff);                                            //adding text from char array to stringbulider
            int count = 0;                                              //simple counter of ';'
            int tabs=0;                                                 //counter of current paragraphs

            for (int i = 0; i < (int) file.length(); i++) {             //counting ';' symbols
                if (buff[i] == ';') {
                    count++;
                }
            }
                                            //MAIN CYCLE:
            for (int i = 0, j = 1; i < sb.length()-count; i++) {
                if (j > count)                                          //second limiter of cycle
                    break;
                else {
//                    int currentspaces = (tabs*4);
                    if (buff[i] == ';') {
                        sb.insert(i+1, '\n');
                        for(int k = 0; k < tabs; k++) {
                            sb.insert(i + 2, "    ");                   //inserting paragraphs to each new lines
                        }
//                        if (buff[i+currentspaces]=='f' && buff[i+currentspaces+1]=='o' && buff[i+currentspaces+2]=='r'){
//                            int breakcounter=0;
//                           for(; buff[i]!=')'; i++) {
//
//                               if (buff[i] == ';'){
//                                   breakcounter++;
//                                   if (breakcounter==2){
//                                       break;
//                                   }
//                               }
//
//                           }
//                        }
                        String s = String.valueOf(sb);                      //overwriting our char array
                        buff = s.toCharArray();                             //
                        j++;
                        count++;
                    }
                    if(buff[i]=='{'){
                        if(buff[i-1]==']'){                                 //protection of initialized arrays
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
                        if(buff[i+1]==';'){                                 //protection of initialized arrays
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

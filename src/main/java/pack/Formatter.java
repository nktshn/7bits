package pack;

/**
 * Class for formatting some code.
 */

    public final class Formatter implements Formattable {
    /**.
     * constructor
     */
    public Formatter() {

    }
    /**.
     * result string
     */
    public StringBuilder result;
    /**
     * formatting method.
     * @param buff - char array
     * @param sb  - string
     *
     */

       public void format(char[] buff, final StringBuilder sb) throws FormatterException { //method receiving
          final int five = 5;

               try {
                   int count = 0;  //simple counter of ';'
                   int tabs = 0;   //counter of current paragraphs

                   for (int i = 0; i < sb.length(); i++) {  //counting ';' symbols
                       if (buff[i] == ';') {
                           count++;
                       }
                   }
                   //MAIN CYCLE:
                   for (int i = 0, j = 0; i < buff.length; i++) {
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
                               j += five;
                               count += five;
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
               } catch (Exception e) {
                   throw new FormatterException("Formatting failed", e);
               }
        result = sb;
    }
}

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
       public void format(char[] buff, final StringBuilder sb) throws FormatterException {
               try {
                   int tabs = 0;   //counter of current paragraphs
                                //MAIN CYCLE:
                   for (int i = 0; i < buff.length; i++) {
                           if (buff[i] == '"') {    //for ignoring symbols in strings
                               i++;
                               while (buff[i] != '"') {
                                   i++;
                               }
                           }
                           if (buff[i] == '/' && buff[i + 1] == '*') {    //for multiline comments
                               i += 2;
                               while (buff[i] != '*') {
                                   i++;
                               }
                               for (int k = 0; k < tabs; k++) {
                                   sb.insert(i + 3, "    "); //inserting paragraphs
                               }
                               String s = String.valueOf(sb);
                               buff = s.toCharArray();
                           }
                           if (buff[i] == '/' && buff[i + 1] == '/') { //for line comments

                              while (buff[i - 1] != ';') {
                                  i--;
                                  sb.deleteCharAt(i);
                              }
                               String s = String.valueOf(sb);
                               buff = s.toCharArray();
                           }
                           if (buff[i] == '/' && buff[i + 1] == '/') { //for line comments
                               i += 2;
                               while (buff[i] != '\n') {
                                   i++;
                               }
                               for (int k = 0; k < tabs; k++) {
                                   sb.insert(i + 1 , "    "); //inserting paragraphs
                               }
                               String s = String.valueOf(sb);
                               buff = s.toCharArray();
                           }
                           if (buff[i] == ';') {
                               sb.insert(i + 1, '\n');
                               for (int k = 0; k < tabs; k++) {
                                   sb.insert(i + 2, "    "); //inserting paragraphs
                                                            // to each new lines
                               }
                               String s = String.valueOf(sb); //overwriting our
                                                            // char array
                               buff = s.toCharArray();
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
                           }
                           if (buff[i] == '}') {
                               if (buff[i + 1] == ';') {  //protection of initialized
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
                           }
                       }
               } catch (Exception e) {
                   throw new FormatterException("Formatting failed", e);
               }
        result = sb;
    }
}

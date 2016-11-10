package pack;

/**.
 * Interface for formatting.
 */
     interface Formattable {
    /**.
     * Method to format.
     * @param buff - char array
     * @param sb  - string
     */
      void format(char[] buff, StringBuilder sb)
              throws FormatterException;

}

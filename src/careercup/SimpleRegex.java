package careercup;

/**
 * Created by moheet-dev on 3/13/2016.
 */
public class SimpleRegex {

    private boolean isMatch(String str, String pattern, int strIndex, int patIndex) {

        int strLen = str.length();
        int patLen = pattern.length();

        if (strIndex == strLen && patIndex == patLen)
            return true;

        if (strIndex >=strLen || patIndex >= patLen ) {
            return false;
        }
        else {

            if (pattern.charAt(patIndex) == '*') {
                return isMatch(str, pattern, strIndex+1, patIndex) ||
                        isMatch(str, pattern, strIndex+1, patIndex+1);
            }
            else if (pattern.charAt(patIndex) == str.charAt(strIndex))
                return isMatch(str, pattern, strIndex+1, patIndex+1);

            return false;
        }


    }

    public static void main(String[] args) {
        SimpleRegex matcher = new SimpleRegex();

        String str = "caaacaab";
        String pattern = "c*c*b";

        if(matcher.isMatch(str, pattern, 0, 0)){
            System.out.println("Match");
        } else {
            System.out.println("no match");
        }
    }
}

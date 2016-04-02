package careercup;

import java.util.ArrayList;
import java.util.List;

/**
 * 1?0?1
 * ? can be 0 or 1
 * print all combinations
 *
 * Created by moheet-dev on 4/2/2016.
 */
public class ReplaceQuestionMark {

    public void replaceQuestionMarks(String input) {

        List<String> combinations = new ArrayList<String>();

        combinations.add(input);

        while(combinations.get(0).contains("?")) {

            String current = combinations.remove(0);

            char[] chars = current.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '?') {
                    chars[i] = '1';
                    combinations.add(new String(chars));
                    chars[i] = '0';
                    combinations.add(new String(chars));
                    break;
                }
            }
        }
        System.out.println(combinations);
    }

    public static void main(String[] args) {

        ReplaceQuestionMark replacer = new ReplaceQuestionMark();

        replacer.replaceQuestionMarks("1?0?1");
    }
}

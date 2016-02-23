package arrays;

/**
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * 312211
 * 13112221
 *
 * Created by moheet-dev on 2/22/2016.
 */
public class LookAndSay {

    public void lookAndSay(int n) {

        String num = "1";
        while (n >= 0) {
            num = lookAndSay(num);
            n--;
        }
    }

    public String lookAndSay(String num) {

        StringBuffer answer = new StringBuffer();
        char[] chars = num.toCharArray();

        for (int i=0; i<chars.length; i++) {
            int count = 1;

            while (i < chars.length -1 && chars[i] == chars[i+1]) {
                ++i;
                ++count;
            }
            answer.append(count);
            answer.append(chars[i]);
        }
        System.out.println(answer.toString());
        return answer.toString();
    }

    public static void main(String[] args) {

        LookAndSay looker = new LookAndSay();
        looker.lookAndSay(5);
    }
}

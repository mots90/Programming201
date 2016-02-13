package strings;

/**
 * Created by moheetB on 12/10/14.
 */
public class KMP {

    static String text;
    static String pattern;
    static int[] b;

    static void kmpPreprocess(char[] p)
    {
        int i=0, j=-1;
        b[i]=j;
        int m= p.length;
        while (i<m)
        {
            while (j>=0 && p[i]!=p[j]) j=b[j];
            i++; j++;
            b[i]=j;
        }
    }

    static void kmpSearch(char[] t, char[] p)
    {
        int i=0, j=0;
        int n=t.length;
        int m=p.length;
        while (i<n)
        {
            while (j>=0 && t[i]!=p[j]) j=b[j];
            i++; j++;
            if (j==m)
            {
                System.out.println("found " + (i-j) + " to "+ (i-j+m-1) + "  " + new String(t,i-j,m));
                j=b[j];
            }
        }
    }

    public static void main(String[] args){
        text = "bhutemoheetbhute";
        pattern = "moheet";
        b = new int[pattern.length()+1];
        kmpPreprocess(pattern.toCharArray());
        kmpSearch(text.toCharArray(),pattern.toCharArray());
    }
}
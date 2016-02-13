package arrays;

/**
 * Created by mb033889 on 2/12/16.
 */
public class TriColor {

    int [] a = {1,5,2,6,9,3,8,7,4};

    public boolean isMed (int x) {
        if (x > 3 && x <= 6)
            return true;
        return false;
    }
    public boolean isMin (int x) {
        if (x <= 3)
            return true;
        return false;
    }
    public boolean isHigh (int x) {
        if (x > 6 && x <= 9)
            return true;
        return false;
    }

    public void partition(int[] a) {


        int copyto = 0;
        int copyfrom = 0;

        for (copyfrom=0; copyfrom < a.length ; copyfrom++) {

            if (isMin(a[copyfrom])) {
                int temp = a[copyfrom];
                a[copyfrom] = a[copyto];
                a[copyto] = temp;

                copyto++;
            }
        }

        for (copyfrom=copyto; copyfrom < a.length ; copyfrom++) {

            if (isMed(a[copyfrom])) {
                int temp = a[copyfrom];
                a[copyfrom] = a[copyto];
                a[copyto] = temp;

                copyto++;
            }
        }

        for(int i : a)
            System.out.print(i+ " ");
    }

    public static void main(String[] argfs) {

        TriColor test = new TriColor();
        test.partition(test.a);
    }

}

package careercup;

/**
 * Created by moheet-dev on 3/12/2016.
 */
public class SortCharsWithOtherIndices {

    private void reOrder(char[] a, int[] b){

        for (int i=0; i< a.length-1; i++) {
            if (b[i]!=i) {
                swap(a, b[i], i);
                swap(b, b[i], i);
            }
        }

    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void main(String[] args) {

        char[] a = {'c','d','e','f','g'};
        int[] b = {3,0,4,1,2};

        SortCharsWithOtherIndices sorter = new SortCharsWithOtherIndices();
        sorter.reOrder(a,b);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " " +b[i]);
        }
    }
}

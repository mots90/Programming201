package careercup;

/**
 *
 * Given an array of 0s and 1s, and k, Find the longest continuous streak of 1s after flipping k 0s to 1s.

     E.x array is {1,1,0,0,1,1,1,0,1,1}
     k = 1 (which means we can flip ‘k’ one 0 to 1)

     Answer: 6 (if we flip 0 at index 7, we get the longest continuous streak of 1s having length 6)

 * Created by sunny on 3/20/16.
 */
public class LongestContinuousStreakWithKGap {


    int count(int[] a, int k) {

        int runLength = 0;
        int maxRunningLength = 0;
        int tempK = k;
        int start = 0;
        boolean countingStarted = false;

        for (int i = 0; i < a.length; i++) {

            if (a[i] == 1) {
                runLength++;
                countingStarted = true;
            }
            else if (tempK > 0 && tempK < k) {
                tempK--;
                runLength++;

            }
            else if(tempK == k && countingStarted == true) {
                tempK--;
                runLength++;
                start = i;
            }
            else { //tempK == 0
                tempK = k;
                maxRunningLength = Math.max(maxRunningLength, runLength);
                //i = start;
                countingStarted = false;
                runLength = 0;
            }
        }

        maxRunningLength = Math.max(maxRunningLength, runLength);

        return maxRunningLength;
    }




    public static void main(String[] args) {

        int a[] = {1,1,0,0,1,1,1,0,1,1};
        int k = 1;

        LongestContinuousStreakWithKGap counter = new LongestContinuousStreakWithKGap();

        System.out.println(counter.count(a, k));
    }

}

package arrays;

/**
 *
 * in an array A[], find the maximum j-i such that a[j]>a[i]
 *
 * Created by moheet-dev on 2/23/2016.
 */
public class MaxDiffOfIndices {


    int a[] = {34,8,10,3,2,80,30,33,1};

    public void findMaximumDifferenceOfIndices(){

        int[] leftMin = new int[a.length];
        int[] rightMax = new int[a.length];

        leftMin[0] = a[0];
        for (int i=1;i<a.length-1;i++) {
            leftMin[i] = Math.min(a[i],leftMin[i-1]);
        }

        rightMax[a.length-1] = a[a.length-1];
        for (int i=a.length-2;i>=0;i--) {
            rightMax[i] = Math.max(a[i],rightMax[i+1]);
        }

        int i = 0;
        int j = 0;
        int maxDiff = -1;

        while( i< a.length-1 && j<a.length-1) {

            if(leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j-i);
                j++;
            }
            else {
                i++;
            }

        }

        System.out.println("max diff "+ maxDiff);

    }

    public static void main(String[] args) {
        MaxDiffOfIndices finder = new MaxDiffOfIndices();
        finder.findMaximumDifferenceOfIndices();
    }

}

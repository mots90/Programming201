package careercup;

import com.sun.org.apache.regexp.internal.RE;

/**
 *
 * Given a set of numbers {x1, x2, x3, x4, ..., xN} (N>=3) a set of its pairwise sums is {x1+x2, x1+x3, x1+x4, x2+x3,x2+x4,x3+x4, ...,}.
 * (That is s_k = x_i + x_j where i != j)
     Restore a set of numbers given a set of its pairwise sums.
     Note: you don't know given some k, to which i and j it refers, (i.e. input is given in undefined order)

     Example:

     S = {1, 5, 10, 100} (n elements)
     P = {6, 11, 101, 15, 105, 110} (n * (n - 1) / 2 elements)
     Given P you have to restore S.




 LOGIC
 if the array contains x1, x2, x3
 then pairwise will contaion x1+x2,x1+x3,x2+x3 so total 3

 for array of size n, pariwse size would be n-1 + n-2 +...+1

 term 1 is x1 + x2, term 2 is x1 + x3
 involvement of x1 would be n-1 times.
 nth term would involve x2 + x3, so


 Compute term 1 + term 2 - term n -> This will be x1 + x2 + x1 + x3 - (x2 + x3) = 2 * x1
 div by 2 to get x1.
 once you have x1, just subtract that from numbers till terms n - 1 for getting other terms.

 x2 can be computed as x1 + x2 - x1 and so on. You will get all terms in n.


 *
 *
 * Created by moheet-dev on 2/28/2016.
 */
public class RestoreArrayFromPairWiseSum {

    public int[] restore(int[] sums) {

        int sumsLen = sums.length;

        int sum = 0;
        int i;
        for ( i=1;;i++) {
            if (sum == sumsLen)
                break;
            sum += i;
        }
        int n = i;
        int a[] = new int[n];
        a[0] = (sums[0] + sums[1] - sums[n-1])/2;

        for ( i=1;i<n;i++) {
            a[i] = sums[i-1] - a[0];
        }

        return a;
    }

    public static void main(String[] args) {
        RestoreArrayFromPairWiseSum restorer = new RestoreArrayFromPairWiseSum();
        int a[] = restorer.restore(new int[]{6, 11, 101, 15, 105, 110});

        for (int i : a) {
            System.out.print(i+" ");
        }
    }



}

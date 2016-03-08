package careercup;

/**
 * Given two arrays/Lists (choose whatever you want to) with sorted and non intersecting intervals.
 * Merge them to get a new sorted non intersecting array/list.

     Eg:
     Given:
     Arr1 = [3-11, 17-25, 58-73];
     Arr2 = [6-18, 40-47];

     Wanted:
     Arr3 = [3-25, 40-47, 58-73];

 *
 * Created by moheet-dev on 2/28/2016.
 */
public class MergeIntervals {

    private int[] merge(int[] a, int[] b) {

        int[] combined = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {

            int aStart = a[i];
            int aEnd = a[i+1];

            int bStart = b[j];
            int bEnd = b[j+1];

            if ( k==0 && overlaps(aStart,aEnd,bStart,bEnd)) {
                combined[k] = Math.min(aStart,bStart);
                combined[k+1] = Math.max(aEnd,bEnd);
                k+=2;
                i+=2;
                j+=2;
            }
            else if (!overlaps(aStart,aEnd,bStart,bEnd)) {
                if (overlaps(aStart, aEnd, combined[k - 2], combined[k - 1])) {
                    combined[k - 1] = Math.max(aEnd, combined[k - 1]);
                    i += 2;
                } else if (overlaps(bStart, bEnd, combined[k - 2], combined[k - 1])) {
                    combined[k - 1] = Math.max(bEnd, combined[k - 1]);
                    j += 2;
                }
                else {
                    if (aStart > bStart) {
                        combined[k] = bStart;
                        combined[k+1] = bEnd;
                        j+=2;
                        k+=2;
                    }
                    else {
                        combined[k] = aStart;
                        combined[k+1] =aEnd;
                        i+=2;
                        k+=2;
                    }
                }
            }
            else if (overlaps(aStart,aEnd,bStart,bEnd)) {
                if (overlaps(aStart,aEnd,combined[k-2],combined[k-1])
                        || overlaps(bStart,bEnd,combined[k-2],combined[k-1])) {

                    int min = Math.min(aStart,bStart);
                    combined[k-2] = Math.min(min, combined[k-2]);
                    int max = Math.max(aEnd,bEnd);
                    combined[k-1] = Math.max(max, combined[k-1]);
                }

            }
        }

        while (i < a.length) {
            int aStart = a[i];
            int aEnd = a[i+1];

            if (overlaps(aStart,aEnd,combined[k-2],combined[k-1])) {
                combined[k-2] = Math.min(aStart,combined[k-2]);
                combined[k-1] = Math.max(aEnd,combined[k-1]);
            }
            else {
                combined[k] = aStart;
                combined[k+1] = aEnd;
                i+=2;
                k+=2;
            }
        }
        while (j < b.length) {
            int bStart = b[j];
            int bEnd = b[j+1];

            if (overlaps(bStart,bEnd,combined[k-2],combined[k-1])) {
                combined[k-2] = Math.min(bStart,combined[k-2]);
                combined[k-1] = Math.max(bEnd,combined[k-1]);
            }
            else {
                combined[k] = bStart;
                combined[k+1] = bEnd;
                j+=2;
                k+=2;
            }
        }
        return combined;
    }

    private boolean overlaps(int aStart, int aEnd, int bStart, int bEnd) {

        if (aEnd < bStart || bEnd < aStart)
            return false;

        return true;
    }

    private void print (int[] combined) {
        for (int i  : combined) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        MergeIntervals merger = new MergeIntervals();
        int[] a = {3,11,17,25,58,73};
        int[] b = {6,18,40,47};
        int[] combined = merger.merge(a,b);
        merger.print(combined);
    }
}

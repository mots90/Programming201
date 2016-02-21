package arrays;

/**
 *
 * given : 112222333344444
 *
 * input : 3
 * then number of 3s should be returned : 4
 *
 * input: 4
 * then 5 should be returned
 *
 * Created by moheet-dev on 2/16/2016.
 */
public class MaxContinuousElementsInSortedArray {

    int[] array = {1,2,2,3,3,3,3,4,4,4};

    /**
     * returns the number of continuous given numbers
     * @param start
     *          start of the binary search half
     * @param end
     *          end of the binary search half
     * @param num
     *          number to be searched and the counted
     * @return
     *          number of continuous elements
     */
    int find(int start, int end, int num, boolean searchFirst) {

        int mid = 0;
        int result = -1;

        while( start <= end ) {

            mid = (start + end) / 2;

            if ( array[mid] == num) {
                result = mid;

                if (searchFirst) {
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            else if ( array[mid] > num) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxContinuousElementsInSortedArray counter = new MaxContinuousElementsInSortedArray();

        int start = counter.find(0,counter.array.length-1, 2, true);
        if ( start == -1) {
            System.out.println("number not present");
        }
        else {
            int end = counter.find(0,counter.array.length-1, 2, false);
            System.out.println("number present following times " + (end-start+1));
        }
    }
}

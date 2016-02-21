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

    int[] array = {1,2,2,3,3,3,4,4,4};

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
    int countContinousElements(int start, int end, int num) {

        int mid = 0;
        while( start < end ) {

            mid = (start + end) / 2;

            if(array[mid] > num ) {
                start = mid+1;
            }
            else if (array[mid] < num) {
                end = mid-1;
            }
            else {
                System.out.println(String.format("found %d at %dth location",num, mid));
                break;
            }
        }

        int low = array[mid-1] != array[mid] ? mid : findLow(start, mid-1, num);
        int high = array[mid+1] != array[mid] ? mid : findHigh(mid+1, end, num);

        return high-low + 1;
    }

    int findLow(int start, int end, int num) {

        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if ( array[mid] == num) {
                result = mid;
                end = mid - 1;
            }
            else if ( array[mid] < num) {
                start = mid + 1;
            }
        }

        return result;
    }

    int findHigh(int start, int end, int num) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if ( array[mid] == num) {
                result = mid;
                start = mid + 1;
            }
            else if ( array[mid] > num) {
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaxContinuousElementsInSortedArray counter = new MaxContinuousElementsInSortedArray();
        int num = 3;

        int start = 0;
        int end = counter.array.length - 1;
        System.out.println(String.format("the continuous occurrence of %d is %d",num, counter.countContinousElements(start,end,num)));

    }

}

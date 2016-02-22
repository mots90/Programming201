package arrays;

/**
 * sorted array 1,2,3,4,5,6,7 which
 * when rotated by two elements we get
 * 6,7,1,2,3,4,5
 *
 * NO DUPES ALLOWED
 *
 * find this rotation count
 *
 *
 * Created by moheet-dev on 2/21/2016.
 */
public class RotationCount {

    int[] array = {6,7,8,1,2,3,4,5};

    public int findRotationCount(int start, int end) {

        int rotation = 0;
        int N = array.length;

        while (start <= end) {

            //case #1
            //the part of the array under consideration is already sorted, so return start
            if (array[start] < array[end]) {
                return start;
            }

            int mid = (start + end) / 2;
            int prev = (mid + N - 1) % N;
            int next = (mid + 1) % N;

            //case #2
            //array[mid] is smaller than both the previous and next elements
            if (array[mid] < array[prev] && array[mid] < array[next]) {
                return mid;
            }

            //case #3
            //if mid to end is already sorted, we wont find rotation there
            if (array[mid] < array[end]) {
                end = mid - 1;
            }

            //case #4
            //if start to mid is already sorted, we wont find rotation there
            if (array[mid] > array[start]) {
                start = mid + 1;
            }
        }

        return rotation;
    }

    public static void main(String[] args) {

        RotationCount counter = new RotationCount();

        System.out.println("the array's rotation count is " + counter.findRotationCount(0, counter.array.length-1));
    }
}

package sorting;

/**
 * Created by moheet-dev on 1/20/2016.
 */
public class CountingSort {

    public int[] countingSort(int [] array, int k) {

        int inputLength = array.length;
        int i;

        // initialize counts of size with all zeros
        int [] counts = new int[k];

        //initialise the sorted array
        int[] sorted = new int[inputLength];

        // count the occurrences of each of elements and store in counts array
        for(i=0; i<inputLength; i++) {
            counts[array[i]] += 1;
        }

        // now that counts are known, we can modify counts to contain the number of preceding elements before i;
        for (i=1; i < k; i++) {
            counts[i] += counts[i-1];
        }

        // now position each element from array into their corresponding location
        for (i=inputLength-1; i>=0; i--) {
            sorted[--counts[array[i]]] = array[i];
        }
        return sorted;
    }

    public static void main(String[] args) {

        int[] array = {4,2,5,1,3,2,4};
        CountingSort sorter = new CountingSort();
        for (int element : sorter.countingSort(array,6)){
            System.out.print(element + "\t");
        }

    }
}

/*

        int inputLength = array.length;

        int i;
        int[] counts = new int[k];
        int[] sorted = new int[inputLength];

        for (i = 0; i < inputLength; i++) {
            counts[array[i]]++;
        }

        for (i = 1; i < k; i++) {
            counts[i] = counts[i] + counts[i - 1];
        }

        for (i = inputLength - 1; i >= 0; i--){
            sorted[--counts[array[i]]] = array[i];

        }
        return sorted;


 */

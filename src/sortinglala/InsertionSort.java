package sortinglala;

/**
 * Created by moheet-dev on 1/18/2016.
 *
 * inserts the value at the correct location in the already sorted part of the array
 */
public class InsertionSort {

    public void insertionSort(int[] array) {

        for(int i=1;i<array.length;i++) {

            int current = array[i];
            int j = i;

            while( j>0 && array[j-1] > current) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = current;

        }

    }

    public static void main(String[] args) {

        int[] array = {4,2,3,5,1};
        int[] array1 = {1,2,3,4,5};

        InsertionSort sorter = new InsertionSort();
        sorter.insertionSort(array);

        for(int element : array) {
            System.out.print(element + "\t");
        }

    }
}

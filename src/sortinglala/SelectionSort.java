package sortinglala;

/**
 * Created by moheet-dev on 1/18/2016.
 *
 * Selects the minimum element
 * swaps it with the current element
 *
 */
public class SelectionSort {

    public void selectionSort(int[] array) {

        for(int i=0; i<array.length;i++) {

            int min = i;
            int j;

            for( j=i+1; j<array.length;j++) {
                if(array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] array = {4,2,3,5,1};
        int[] array1 = {1,2,3,4,5};

        SelectionSort sorter = new SelectionSort();
        sorter.selectionSort(array1);

        for(int element : array1) {
            System.out.print(element + "\t");
        }

    }

}

package Sorting;

/**
 * Created by moheet-dev on 1/20/2016.
 */
public class QuickSort {

    public static void quickSort(int [] arr, int low, int high) {

        if (low < high) {
            int partition = partition(arr, low, high);
            quickSort(arr,low,partition);
            quickSort(arr,partition+1, high);
        }
    }

    public static int partition(int [] arr, int low, int high) {

        int pivot = arr[low];

        int up = low;
        int down = high;

        while(true) {

            while (up < high && arr[up] < pivot) {
                up++;
            }
            while (down > low && arr[down] > pivot) {
                down--;
            }

            if (up < down) {
                int temp = arr[up];
                arr[up] = arr[down];
                arr[down] = temp;

                up++;
                down--;
            }
            else {
                return down;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,2,6,2,1};
        quickSort(arr, 0, arr.length -1);
        for(int i:arr)  {
            System.out.print("  "+i);
        }
    }

}

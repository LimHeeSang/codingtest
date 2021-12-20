package note.sort;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {

        if(start >= end)
            return;

        int pivot = start;
        int left = start +1;
        int right = end;

        while(left <= right) {

            while(left <= end && arr[left]<=arr[pivot])
                left += 1;

            while(right > start && arr[right] >= arr[pivot])
                right -= 1;

            if(left>right) {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }

        quickSort(arr, start, right-1);
        quickSort(arr, right+1, end);
    }

}

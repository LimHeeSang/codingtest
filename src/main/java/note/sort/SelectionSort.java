package note.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int min_index;
        for(int i=0; i<arr.length; i++) {
            min_index = i;
            for(int j=i; j<arr.length; j++) {
                if(arr[j] < arr[min_index])
                    min_index = j;
            }

            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }

        System.out.println(Arrays.toString(arr));

    }

}

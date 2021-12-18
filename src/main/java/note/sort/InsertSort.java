package note.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=1; i<arr.length; i++) {
            for(int j=i; j>=1; j--) {
                if(arr[j]<arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else
                    break;
            }

        }

        System.out.println(Arrays.toString(arr));

    }

}

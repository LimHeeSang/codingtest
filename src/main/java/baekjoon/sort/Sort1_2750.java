package baekjoon.sort;
import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.OutputStreamWriter;

public class Sort1_2750 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, arr.length-1);


        for(int result:arr) {
            bw.write(result +"\n");
        }
        bw.flush();
        bw.close();

    }

    public static void quickSort(int[] arr, int start, int end) {

        if(start >= end) return;

        int pivot = start;
        int left = start +1;
        int right = end;

        while(left<=right) {

            while(left<=end && arr[pivot] >= arr[left])
                left++;

            while(right>start && arr[pivot] <= arr[right])
                right--;

            if(left<=right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }else {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }
        }

        quickSort(arr, start, right -1);
        quickSort(arr, right +1, end);

    }
}
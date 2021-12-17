package note.sort;

public class CountSort {

    public static void main(String[] args) {

        int arr[] = {7, 5 , 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] count = new int[10];

        for(int i=0; i<arr.length; i++) {
            count[arr[i]] += 1;
        }

        for(int i=0; i<count.length; i++) {
            for(int j=0; j<count[i]; j++)
                System.out.print(i + " ");
        }
    }

}

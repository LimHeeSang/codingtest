package note.binarysearch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 3, 3, 4, 4, 6, 7, 8, 9, 10};
        int target = 3;

        //System.out.println(Arrays.binarySearch(arr, target));
        //System.out.println(Collections.binarySearch(List.of(1, 2, 3, 4, 5), 5));
        System.out.println(lowerBound(arr, target));
        System.out.println(upperBound(arr, target));
    }

    // 이진 탐색은 중복 원소를 체크하지 못하브로 lowerBound 와 UpperBound 적용
    // 어려운 개념이 아니라 중복 타켓이 존재하는 경우를 고려하여 개수를 알기 위해서 적용

    // 배열의 원소 중 target 의 첫번째 원소 인덱스 반환
    static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 배열의 원소 중 target 보다 큰 첫번째 원소를 반환
    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    // 일반적인 이진탐색은 중복 원소가 있으면 그중 바로 찾은 아무 인덱스나 반환함 즉, 첫번째 원소의 인덱스임을 보장하지 않음
    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            // int형 범위가 넘어설 경우 중간 값 계산
            // mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

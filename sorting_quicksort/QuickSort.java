import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    static void quickSort(int[] arr, int start, int end) {
        if (end <= start) {
            return;
        }
        if (end - start == 1) {
            if (arr[start] > arr[end]) {
                int cpy = arr[start];
                arr[start] = arr[end];
                arr[end] = cpy;
            }
            return;
        }

        int pivotIdx = setNewPivot(arr, start, end);
        quickSort(arr, start, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, end);
    }

    static int setNewPivot(int[] arr, int start, int end) {
        int pivotValue = arr[start];
        List<Integer> prefix = new LinkedList();
        List<Integer> sufix = new LinkedList();
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivotValue) {
                prefix.add(arr[i]);
            } else {
                sufix.add(arr[i]);
            }
        }
        int index = start;
        for (Integer i : prefix) {
            arr[index] = i;
            index++;
        }
        arr[index] = pivotValue;
        int pivotIndex = index;
        index++;
        for (Integer i : sufix) {
            arr[index] = i;
            index++;
        }
        return pivotIndex;
    }
}


package hacker_rank;

public class LilysHomework_1 {
    public static void main(String[] args) {
        int[] arr1 = {7, 15, 12, 3};
        System.out.println(lilysHomework(arr1));

        int[] arr2 = {9, 8, 7, 6, 5, 4};
        System.out.println(lilysHomework(arr2));

        int[] arr3 = {1, 2, 4, 3};
        System.out.println(lilysHomework(arr3));

    }

    static int lilysHomework(int[] arr) {
        int swap1 = 0;
        int[] arr1 = arr.clone();

        for (int p = 0; p < arr1.length - 1; p++) {
            int minIndex = findMinIndex(p, arr1);
            if (minIndex != p) {
                swap(arr1, p, minIndex);
                swap1++;
            }
        }

        int swap2 = 0;
        int[] arr2 = arr.clone();
        for (int p = 0; p < arr2.length - 1; p++) {
            int maxIndex = findMaxIndex(p, arr2);
            if (maxIndex != p) {
                swap(arr2, p, maxIndex);
                swap2++;
            }
        }

        System.out.println(swap1);
        System.out.println(swap2);
        return Math.min(swap1, swap2);
    }

    private static void swap(int[] arr, int p, int minIndex) {
        int temp = arr[p];
        arr[p] = arr[minIndex];
        arr[minIndex] = temp;
    }

    private static int findMinIndex(int p, int[] arr) {
        int minIndex = p;
        for (int i = p; i < arr.length; i++) {
            minIndex = (arr[minIndex] < arr[i]) ? minIndex : i;
        }
        return minIndex;
    }

    private static int findMaxIndex(int p, int[] arr) {
        int maxIndex = p;
        for (int i = p; i < arr.length; i++) {
            maxIndex = (arr[maxIndex] > arr[i]) ? maxIndex : i;
        }
        return maxIndex;
    }
}

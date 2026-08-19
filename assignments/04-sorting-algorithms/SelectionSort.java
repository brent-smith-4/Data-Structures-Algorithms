public class SelectionSort {
    private int comparisons;

    public int[] sort(int arr[]) {
        int n = arr.length;
        comparisons = 0;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {

            // Find the minimum element in unsorted array
            int min_idx = i;

            for (int j = i+1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                } // if
            } // for

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        } // for
        return arr;
    } // method

    public int getComparisons() {
        return comparisons;
    } // method

} // class

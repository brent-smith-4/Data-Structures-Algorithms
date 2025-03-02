public class MergeSort {

    private int comparisons;
    private int[] arr;

    public int sort(int[] intArray, int first, int last) {
        int compares = 0;
        if(first < last) {
            int mid = (first + last) / 2;
            compares += sort(intArray, first, mid);
            compares += sort(intArray, mid + 1, last);
            compares += merge(intArray, first, mid, last);

        }

        this.comparisons = compares;
        this.arr = new int[intArray.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = intArray[i];
        } // if
        return compares;
    } // method

    public int merge(int[] intArray, int first, int mid, int last) {
        int comparisons = 0;
        int first1 = first, last1 = mid;
        int first2 = mid + 1, last2 = last;
        int temp[] = new int[intArray.length];
        int index = first1;

        while(first1 <= last1 && first2 <= last2) {
            if(intArray[first1] < intArray[first2]) {
                temp[index] = intArray[first1++];
                comparisons++;
            } else
                temp[index] = intArray[first2++];
            index++;
            comparisons++;
        }

        while(first1 <= last1)
            temp[index++] = intArray[first1++];

        while(first2 <= last2)
            temp[index++] = intArray[first2++];

        for(index = first; index <= last; index++)
            intArray[index] = temp[index];


        return comparisons;
    } // method

    public int[] getArray() {
        return this.arr;
    } // method

    public int getComparisons() {
        return this.comparisons;
    } // method
} // class

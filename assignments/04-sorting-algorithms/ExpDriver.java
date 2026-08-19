import java.util.Random;
import java.util.Scanner;

public class ExpDriver {
    public static void main(String[] args) {
        Random myRandom = new Random();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the size of the list: ");
        int size = keyboard.nextInt();

        int[] arr = new int[size];
        boolean[] check = new boolean[size];
        int amountFilled = 0;
        int trial;
        while (amountFilled < size) {
            trial = myRandom.nextInt(size);
            if (!check[trial]) {
                check[trial] = true;
                arr[amountFilled] = trial;
                amountFilled++;
            }
        } // while

        System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q)");
        System.out.println("quick-sort-rp (r)");
        System.out.print("Enter the algorithm: ");
        char c = keyboard.next().charAt(0);

        if (c == 's') {
            SelectionSort ss = new SelectionSort();
            arr = ss.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length-1)
                    System.out.println(arr[arr.length - 1]);
                else
                    System.out.print(arr[i] + " ");
            } // if
            System.out.println("#Selection-sort comparisons: " + ss.getComparisons());
        } else if (c == 'm') {
            MergeSort ms = new MergeSort();
            ms.sort(arr, 0, arr.length-1);
            arr = ms.getArray();
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length-1)
                    System.out.println(arr[arr.length - 1]);
                else
                    System.out.print(arr[i] + " ");
            } // if
            System.out.println("#Merge-sort comparisons: " + ms.getComparisons());
        } else if (c == 'h') {
            HeapSort hs = new HeapSort();
            arr = hs.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length-1)
                    System.out.println(arr[arr.length - 1]);
                else
                    System.out.print(arr[i] + " ");
            } // if
            System.out.println("#Heap-sort comparisons: " + hs.getComparisons());
        } else if (c == 'q') {
            QuickSort fs = new QuickSort();
            arr = fs.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length-1)
                    System.out.println(arr[arr.length - 1]);
                else
                    System.out.print(arr[i] + " ");
            } // if
            System.out.println("#Quick-sort-fp comparisons: " + fs.getComparisons());
        } else if (c == 'r') {
            RandomQuickSort rs = new RandomQuickSort();
            arr = rs.sort(arr, 0, arr.length-1);
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length-1)
                    System.out.println(arr[arr.length - 1]);
                else
                    System.out.print(arr[i] + " ");
            } // if
            System.out.println("#Quick-sort-rp comparisons: " + rs.getComparisons());
        } else {
            System.out.println("No sort method was selected, exiting...");
        } // if-else
    } // main
}  // class

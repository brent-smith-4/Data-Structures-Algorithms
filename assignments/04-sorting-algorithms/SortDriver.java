import java.util.Scanner;
import java.io.*;
import java.nio.*;
import java.lang.*;

public class SortDriver {

    public static void main(String  args[]) {
        Scanner keyboard = new Scanner(System.in);

        if (args.length != 1) {
            System.err.println("No file was input");
            System.exit(1);
        } else {
            try {
                File file = new File(args[0]);
                byte[] bytes = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(bytes);
                fis.close();

                if (bytes.length == 0) {
                    System.out.println("There is no array to sort, exiting...");
                    System.exit(0);
                } else {
                    String[] valueStr = new String(bytes).trim().split(" ");
                    int[] arr = new int[valueStr.length];
                    for (int i = 0; i < valueStr.length; i++) {
                        arr[i] = Integer.parseInt(valueStr[i]);
                    } // for

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

                } // if-else
            } catch (Exception e) {
                System.err.println();
                System.err.println("ERROR: File not formatted correctly");
                System.exit(2);
            } // try-catch

        } // if

    } // main

} // class

import java.util.*;
import java.io.*;
import java.nio.*;
import java.lang.*;
import java.math.*;

public class BinaryTreeDriver<T extends Comparable<T>> {
    // Declare keyboard, 3 lists, and user inputted data type for use in both main() and run() methods
    private static Scanner keyboard = new Scanner(System.in);
    private static BinaryTree<Integer> il;
    private static BinaryTree<Double> dl;
    private static BinaryTree<String> sl;
    private static char t;

    public static void main(String[] args) {
        // If no file or more than 1 file is given, give error and exit
        if (args.length != 1) {
            System.err.println("ERROR: You must use exactly 1 file");
            System.exit(1);
        } else {
            try {
                // Use FileInputStream to read file into bytes array which can be put into string array
                File file = new File(args[0]);
                byte[] bytes = new byte[(int) file.length()];
                FileInputStream fis = new FileInputStream(file);
                fis.read(bytes);
                fis.close();
                String[] valueStr = new String(bytes).trim().split(" ");
                // Asks for the data type the user wants to use, initializes corresponding list
                System.out.print("Enter list type (i - int, d - double, s - string): ");
                t = keyboard.next().charAt(0);
                if (t == 'i')
                    il = new BinaryTree<Integer>();
                else if (t == 'd')
                    dl = new BinaryTree<Double>();
                else if (t == 's')
                    sl = new BinaryTree<String>();
                else
                    System.out.print("ERROR: Please rerun program and type 1 of the 3 options provided");
                // If file was empty, just starting running program
                if (bytes.length == 0) {
                    if (t == 'i')
                        run(il);
                    else if (t == 'd')
                        run(dl);
                    else if (t == 's')
                        run(sl);
                } else {
                    // Insert file contents into list, dependent on data type, and then run program
                    if (t == 'i') {
                        int[] valueInt = new int[valueStr.length];
                        for (int i = 0; i < valueStr.length; i++) {
                            valueInt[i] = Integer.parseInt(valueStr[i]);
                            il.insert(valueInt[i]);
                        } // for
                        run(il);
			 } else if (t == 'd') {
                        double[] valueDbl = new double[valueStr.length];
                        for (int i = 0; i < valueStr.length; i++) {
                            valueDbl[i] = Double.parseDouble(valueStr[i]);
                            dl.insert(valueDbl[i]);
                        } // for
                        run(dl);
                    } else if (t == 's') {
                        for (int i = 0; i < valueStr.length; i++) {
                            sl.insert(valueStr[i]);
                        } // for
                        run(sl);
                    } // if-else
                    System.out.println();
                } // if-else

               } catch (Exception e) {
                   System.err.println();
                   System.err.println("ERROR: file is not found, file is not formatted correctly, or list and file data type do not match");
                   System.exit(2);
               } // try-catch
           } // if
    } // main

    public static void run(BinaryTree ll) throws IOException {
        /*
          Initialize quit to loop program until user quits,
          BufferedReader is outdated and not used,
          c contains the command input by user each loop
	  */
        boolean quit = false;
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        char c;

        System.out.println("Commands:");
        System.out.println("(i) - Insert Item");
        System.out.println("(d) - Delete Item");
        System.out.println("(p) - Print Tree");
        System.out.println("(r) - Retrieve Item");
        System.out.println("(l) - Count Leaf Nodes");
        System.out.println("(s) - Find Single Parents");
        System.out.println("(c) - Find Cousins");
        System.out.println("(q) - Quit Program");

        while (!quit) {
            System.out.print("\nEnter a command: ");
            c = keyboard.next().charAt(0);

            if (c == 'i') { // Insert Value
                if (t == 'i') {
                    System.out.print("In-Order: ");
                    il.inOrder();
                    System.out.print("\nEnter a number to insert: ");
                    int num = keyboard.nextInt();
                    il.insert(num);
                    System.out.print("In-Order: ");
                    il.inOrder();
                } else if (t == 'd') {
                    System.out.print("In-Order: ");
                    dl.inOrder();
                    System.out.print("\nEnter a number to insert: ");
                    double num = keyboard.nextDouble();
                    dl.insert(num);
                    System.out.print("In-Order: ");
                    dl.inOrder();
                } else if (t == 's') {
                    System.out.print("In-Order: ");
                    sl.inOrder();
                    System.out.print("\nEnter a string to insert: ");
                    String str = keyboard.next();
                    sl.insert(str);
                    System.out.print("In-Order: ");
                    sl.inOrder();
                } // if-else
            } else if (c == 'd') { // Delete Value
                if (t == 'i') {
                    System.out.print("In-Order: ");
                    il.inOrder();
                    System.out.print("\nEnter a number to delete: ");
                    int num = keyboard.nextInt();
                    il.delete(num);
                    System.out.print("In-Order: ");
		    il.inOrder();
                } else if (t == 'd') {
                    System.out.print("In-Order: ");
                    dl.inOrder();
                    System.out.print("\nEnter a number to delete: ");
                    double num = keyboard.nextDouble();
                    dl.delete(num);
                    System.out.print("In-Order: ");
                    dl.inOrder();
                } else if (t == 's') {
                    System.out.print("In-Order: ");
                    sl.inOrder();
                    System.out.print("\nEnter a string to delete: ");
                    String str = keyboard.next();
                    sl.delete(str);
                    System.out.print("In-Order: ");
                    sl.inOrder();
                } // if-else
            } else if (c == 'p') { // Print Tree
                System.out.print("In-Order: ");
                ll.inOrder();
            } else if (c == 'r') { // Retrieve Item
		boolean present = false;
		
		if (t == 'i') {
                    System.out.print("In-Order: ");
                    il.inOrder();
                    System.out.print("\nEnter a number to search: ");
                    int num = keyboard.nextInt();
                    present = il.retrieve(num);
                } else if (t == 'd') {
                    System.out.print("In-Order: ");
                    dl.inOrder();
                    System.out.print("\nEnter a number to search: ");
                    double num = keyboard.nextDouble();
                    present = dl.retrieve(num);
                } else if (t == 's') {
                    System.out.print("In-Order: ");
                    sl.inOrder();
                    System.out.print("\nEnter a string to search: ");
                    String str = keyboard.next();
                    present = sl.retrieve(str);
                } // if-else
		
		if (present == true) {
		    System.out.print("Item is present in the tree");
		} else {
		    System.out.print("Item is not present in the tree");
		} // if-else
            } else if (c == 'l') { // Count Leaf Nodes
		System.out.print("The number of leaf nodes are " + ll.getNumLeafNodes());
            } else if (c == 's') { // Find Single Parents
		System.out.print("Single Parents: ");
		ll.getSingleParent();
            } else if (c == 'c') { // Find Cousins
		if (t == 'i') {
                    System.out.print("In-Order: ");
                    il.inOrder();
                    System.out.print("\nEnter a number: ");
                    int num = keyboard.nextInt();
		    System.out.print(num + " cousins: ");
                    il.getCousins(num);
                } else if (t == 'd') {
                    System.out.print("In-Order: ");
                    dl.inOrder();
                    System.out.print("\nEnter a number: ");
                    double num = keyboard.nextDouble();
                    System.out.print(num + " cousins: ");
                    dl.getCousins(num);
                } else if (t == 's') {
                    System.out.print("In-Order: ");
                    sl.inOrder();
                    System.out.print("\nEnter a string: ");
                    String str = keyboard.next();
                    System.out.print(str + " cousins: ");
                    sl.getCousins(str);
                } // if-else
            } else if (c == 'q') { // Quit Program
                System.out.println("Exiting the program...");
                quit = true;
		System.exit(0);
            } else { // Error Message For Invalid Command
                System.out.println("Invalid command, try again!");
            } // if-else
        } // while
    } // method
} // class


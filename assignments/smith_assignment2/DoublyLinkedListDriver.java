import java.util.*;
import java.io.*;
import java.nio.*;
import java.lang.*;
import java.math.*;

public class DoublyLinkedListDriver<T extends Comparable<T>> {
    // Declare keyboard, 3 lists, and user inputted data type for use in both main() and run() methods
    private static Scanner keyboard = new Scanner(System.in);
    private static DoublyLinkedList<Integer> il;
    private static DoublyLinkedList<Double> dl;
    private static DoublyLinkedList<String> sl;
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
                    il = new DoublyLinkedList<Integer>();
                else if (t == 'd')
                    dl = new DoublyLinkedList<Double>();
                else if (t == 's')
                    sl = new DoublyLinkedList<String>();
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
			    il.insertItem(valueInt[i]);
                        } // for
			run(il);
		    } else if (t == 'd') {
			double[] valueDbl = new double[valueStr.length];
                        for (int i = 0; i < valueStr.length; i++) {
                            valueDbl[i] = Double.parseDouble(valueStr[i]);
                            dl.insertItem(valueDbl[i]);
			} // for
			run(dl);
		    } else if (t == 's') {
			for (int i = 0; i < valueStr.length; i++) {
                            sl.insertItem(valueStr[i]);
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

    public static void run(DoublyLinkedList ll) throws IOException {
	/*
	  Initialize quit to loop program until user quits,
	  BufferedReader is outdated and not used,
	  c contains the command input by user each loop
	*/
	boolean quit = false;
	BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
	char c;

	System.out.println("Commands:");
	System.out.println("(i) - Insert Value");
	System.out.println("(d) - Delete Value");
	System.out.println("(p) - Print List");
	System.out.println("(l) - Length");
	System.out.println("(t) - Print Reverse");
	System.out.println("(r) - Reverse List");
	System.out.println("(b) - Delete Subsection");
	System.out.println("(s) - Swap Alternate");
	System.out.println("(q) - Quit Program");

	while (!quit) {
	    System.out.print("\nEnter a command: ");
	    c = keyboard.next().charAt(0);

	    if (c == 'i') { // Insert Value
		if (t == 'i') {
		    System.out.print("The list is: ");
		    il.print();
		    System.out.print("Enter a number to insert: ");
		    int num = keyboard.nextInt();
		    il.insertItem(num);
		    System.out.print("The list is: ");
		    il.print();
		    System.out.print("The reverse list: ");
		    il.printReverse();
		} else if (t == 'd') {
		    System.out.print("The list is: ");
                    dl.print();
                    System.out.print("Enter a number to insert: ");
                    double num = keyboard.nextDouble();
                    dl.insertItem(num);
                    System.out.print("The list is: ");
                    dl.print();
                    System.out.print("The reverse list: ");
                    dl.printReverse();
		} else if (t == 's') {
		    System.out.print("The list is: ");
                    sl.print();
		    System.out.print("Enter a string to insert: ");
                    String str = keyboard.next();
                    sl.insertItem(str);
		    System.out.print("The list is: ");
                    sl.print();
                    System.out.print("The reverse list: ");
                    sl.printReverse();
		} // if-else
	    } else if (c == 'd') { // Delete Value
		if (t == 'i') {
                    System.out.print("The list is: ");
                    il.print();
                    System.out.print("Enter a number to delete: ");
                    int num = keyboard.nextInt();
                    il.deleteItem(num);
                    System.out.print("The list is: ");
                    il.print();
                    System.out.print("The reverse list: ");
                    il.printReverse();
                } else if (t == 'd') {
                    System.out.print("The list is: ");
                    dl.print();
                    System.out.print("Enter a number to delete: ");
                    double num = keyboard.nextDouble();
                    dl.deleteItem(num);
                    System.out.print("The list is: ");
                    dl.print();
                    System.out.print("The reverse list: ");
                    dl.printReverse();
                } else if (t == 's') {
                    System.out.print("The list is: ");
                    sl.print();
                    System.out.print("Enter a string to delete: ");
                    String str = keyboard.next();
                    sl.deleteItem(str);
                    System.out.print("The list is: ");
                    sl.print();
                    System.out.print("The reverse list: ");
                    sl.printReverse();
                } // if-else
	    } else if (c == 'p') { // Print List
		System.out.print("The list is: ");
		ll.print();
	    } else if (c == 'l') { // Length
		System.out.println("The length of the list is " + ll.getLength());
	    } else if (c == 't') { // Print Reverse
		System.out.print("The reverse list: ");
		ll.printReverse();
	    } else if (c == 'r') { // Reverse list
		System.out.print("The original list: ");
                ll.print();
		ll.reverseList();
		System.out.print("The reverse list: ");
                ll.print();
	    } else if (c == 'b') { // Delete Subsection
		if (t == 'i') {
		    System.out.print("Enter Lower Bound: ");
		    int lb = keyboard.nextInt();
		    System.out.print("Enter Upper Bound: ");
                    int ub = keyboard.nextInt();
		    System.out.print("The original list: ");
		    il.print();
		    il.deleteSubsection(lb, ub);
		    System.out.print("The modified list: ");
		    il.print();
		    System.out.print("The reverse list: ");
		    ll.printReverse();
		} else if (t == 'd') {
		    System.out.print("Enter Lower Bound: ");
                    double lb = keyboard.nextDouble();
                    System.out.print("Enter Upper Bound: ");
                    double ub = keyboard.nextDouble();
                    System.out.print("The original list: ");
                    dl.print();
                    dl.deleteSubsection(lb, ub);
                    System.out.print("The modified list: ");
                    dl.print();
		    System.out.print("The reverse list: ");
		    ll.printReverse();
		} else if (t == 's') {
		    System.out.print("Enter Lower Bound: ");
                    String lb = keyboard.next();
                    System.out.print("Enter Upper Bound: ");
                    String ub = keyboard.next();
                    System.out.print("The original list: ");
                    sl.print();
                    sl.deleteSubsection(lb, ub);
                    System.out.print("The modified list: ");
                    sl.print();
		    System.out.print("The reverse list: ");
		    ll.printReverse();
		} // if-else
	    } else if (c == 's') { // Swap Alternate
		System.out.print("The original list: ");
                ll.print();
                ll.swapAlternate();
                System.out.print("The modified list: ");
                ll.print();
		System.out.print("The reverse list: ");
                ll.printReverse();
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

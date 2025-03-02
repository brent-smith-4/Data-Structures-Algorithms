import java.util.*;
import java.lang.*;

public class DoublyLinkedList<T extends Comparable<T>> {
    private NodeType<T> head;
    private int length;
    
    public DoublyLinkedList() {
	head = null;
	length = 0;
    } // constructor

    public void insertItem(T item) {
	NodeType<T> newNode = new NodeType<T>();
        newNode.next = null;
	newNode.back = null;
        newNode.info = item;
        NodeType<T> iterator = head;
	// Edge case: empty list or inserting item into head
        if (iterator == null) {
            head = newNode;
	    length++;
            return;
        } else if (item.compareTo(head.info) < 0) {
            newNode.next = head;
            head = newNode;
	    newNode.next.back = head;
	    length++;
            return;
        } // if-else
	
	/*
	  If item is greater than previous and less than next,
	  insert into list.

	  If item is equal to list item, state it is duplicate.

	  If item is greater than both items in list, iterate.
	 */
        while (iterator.next != null) {
            int golNext = item.compareTo(iterator.next.info);
            int golCurrent = item.compareTo(iterator.info);
            if (golNext < 0 && golCurrent > 0) {
		/*
		  |iterator|<->|iterator.next|

		  Becomes

                  |iterator|<->|newNode|<->|iterator.next|
		*/
		NodeType<T> temp = iterator.next;
                newNode.next = temp;
		temp.back = newNode;
                iterator.next = newNode;
		newNode.back = iterator;
		length++;
                return;
            } else if (golCurrent == 0) {
                System.out.println("Item already exists");
                return;
            } else {
                iterator = iterator.next;
            } // if-else
        } // while

	/* Edge case: comparing to final item to check if item
	   being inserted is equal; if not, add item at end
	 */
        if (item.compareTo(iterator.info) == 0) {
            System.out.println("Item already exists");
            return;
        } // if
        iterator.next = newNode;
	newNode.back = iterator;
	length++;
        return;
    } // method

    public void deleteItem(T item) {
	// Edge case: empty list
	if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        } // if
        NodeType<T> iterator = head;
        NodeType<T> prev = null;
        while (iterator != null) {
            int gol = item.compareTo(iterator.info);
            if (gol == 0) {
		/* If list only has head, make list empty
		   If length > 1 & deleting head, make head = head.next & head.back = null
		   If deleting end of list, make finalNode.next = null
		*/
		if (length == 1) {
		    head = null;
		    length--;
		    return;
                } else if (prev == null) {
                    head = iterator.next;
		    head.back = null;
		    length--;
                    return;
                } else if (iterator.next == null) {
		    prev.next = iterator.next;
		} else {
		    /*
		      |prev|<->|iterator|<->|iterator.next|

		      Becomes

		      |prev|<->|iterator.next|
		    */
		    NodeType<T> temp = iterator.next;
		    prev.next = iterator.next;
		    temp.back = prev;
		} // if-else
                iterator = null;
		length--;
                return;
            } else {
		/*
		  Keep iterating if match not found
		*/
                prev = iterator;
                iterator = iterator.next;
            } // if-else
        } // while
	// Print not found statement if no match was found and end of list is reached
        System.out.println("The item is not present in the list");
    } // method

    public int getLength() {
	return this.length;
    } // method

    public void print() {
	if (length == 0) {
	    System.out.println();
	    return;
	} // if
	NodeType<T> iterator = head;
        while (iterator != null) {
            System.out.print(iterator.info +  " ");
            iterator = iterator.next;
        }  // while
        System.out.println();
    } // method

    public void printReverse() {
	if (length == 0) {
	    System.out.println();
            return;
        } // if
	NodeType<T> iterator = head;
	while (iterator.next != null) {
	    iterator = iterator.next;
	} // while
        while (iterator != null) {
            System.out.print(iterator.info +  " ");
            iterator = iterator.back;
        }  // while
        System.out.println();
    } // method

    public void deleteSubsection(T lb, T ub) {
	 if (head == null) {
            return;
        } // if
        NodeType<T> iterator = head;
        NodeType<T> prev = null;
	int lbGol;
	int ubGol;
	
        while (iterator != null) {
	    lbGol = iterator.info.compareTo(lb);
	    /*
	      If iterator > lower bound, check if < upper bound:
	      If it is, delete and iterate
	      If not, end method

	      If iterator always < lower bound, don't delete anything
	    */
	    if (lbGol < 0) {
		prev = iterator;
		iterator = iterator.next;
	    } else if (lbGol >= 0) {
		ubGol = iterator.info.compareTo(ub);
		if (ubGol <= 0) {
		    if (length == 1) {
			head = null;
			length--;
			return;
		    } else if (prev == null) {
			head = iterator.next;
			head.back = null;
		    } else if (iterator.next == null) {
			prev.next = iterator.next;
		    } else {
			NodeType<T> temp = iterator.next;
			prev.next = iterator.next;
			temp.back = prev;
		    } // if-else
		    length--;
		    iterator = iterator.next;
		} else {
		    return;
		} // if-else
	    } // if-else
	} // while
    } // method

    public void reverseList() {
	NodeType<T> prev = null;
        NodeType<T> current = head;
        /* Swap next and prev for all nodes
	   in list
        */
        while (current != null) {
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        }
        /*
	  Edge cases: empty list and list with only one node
	*/
        if (prev != null) {
            head = prev.back;
        }
    } // method

    public void swapAlternate() {
	/* Even become true when current is on even number node.
	   For odd-numbered lists, the last number is never
	   checked for a swap as current will be null.
	 */
	if (length == 0 || length == 1) {
	    return;
	} else if (length == 2) {
	    boolean even = true;
	    NodeType<T> prev = head;
	    NodeType<T> current = head.next;
	    head = current;
            head.next = prev;
	    prev.back = head;
	    prev.next = null;
	    head.back = null;
	} else {
	    boolean even = true;
            NodeType<T> prev = head;
            NodeType<T> current = head.next;
	    // n = the next node of current
	    NodeType<T> n = current.next;
	    /* Length > 3 -> swapping the head and
	       the node after head. current is initialized to
	       head.next and prev to head at top of method.

	       |head(prev)|<->|current|<->|n|

	       Becomes

	       |head(current)|<->|prev|<->|n|
	    */
	    head = current;
	    head.next = prev;
	    prev.next = n;
	    n.back = prev;
	    prev.back = head;
	    head.back = null;
	    
	    current = prev.next;
	    even = false;

	    /* Swaps alternating nodes after list,
	       only swaps when current is even node
	       
	      |pp|<->|prev|<->|current|<->|n|

	      Becomes
	      
	      |pp|<->|current|<->|prev|<->|n|

	    */
	    while (current != null) {
		if (even) {
		    // pp = previous node of prev
		    NodeType<T> pp = prev.back;
		    n = current.next;
		    if (pp != null) {
			pp.next = current;
		    }
		    current.back = pp;
		    current.next = prev;
		    prev.back = current;
		    prev.next = n;
		    if (n != null) {
			n.back = prev;
		    }
		    
		    current = prev.next;
		    even = false;
		} else {
		    prev = current;
		    current = current.next;
		    even = true;
		} // if-else
	    } // while
	} // if-else
    } // method

    
} // class

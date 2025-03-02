Name: Brent Smith
Email: bds27724@uga.edu

File compiles & runs with standard command given with assignment, assuming you are in smith_assignment2 directory:
$ javac NodeType.java
$ javac DoublyLinkedList.java
$ javac DoublyLinkedListDriver.java

All of the necessary files are compiled, however, so you can just run with this command w/o compiling anything:
$ java DoublyLinkedListDriver.java <input file name>



BIG O NOTATION EXPLANATIONS:

deleteSubsection(T lb, T ub) {
    while (iterator is not null) {
        if (iterator is greater than lb) {
	    if (iterator is less than ub) {
	        set previous.next to iterator.next
		set iterator.next.back to previous
		delete iterator node
		iterate to next node
	    } else if (iterator >= ub) {
	        return
	    }
	} else {
	    iterate to next node
	}
    }
}

The Big O notation for deleteSubsection is O(n) because it is a single loop iterated through once based on the length of the list, n.

reverseList() {
    while(current is not null) {
        set previous to current.back
	set current.back to current.next
	set current.next to previous
	set current to current.back
    }
}

The Big O notation for reverseList is O(n) because it is a single loop iterated through once based on the length of the list, n.

swapAlternate() {
    while(current is not null) {
        if (current is even node) {
	    swap .back & .next of current and previous node
	    set current to previous
	    set previous to current
	    set boolean even to false
	} else {
	    iterate once
	    set boolean even to true
	}
    }
}

The Big O notation for swapAlternate is O(n) because it is a single loop iterated through once based on the length of the list, n.

import java.io.*;

public class ItemType {
    
    private int value;

    public int compareTo(ItemType item) {
	if (value < item.getValue())
	    return -1;
	else if (value == item.getValue())
	    return 0;
	else
	    return 1;
    } // method

    public int getValue() {
	return value;
    } // method

    public void initialize(int num) {
	this.value = num;
    } // method
    
} // class

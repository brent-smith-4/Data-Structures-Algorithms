Program runs with this command, assuming you are in the 03-binary-trees folder:

$ java BinaryTreeDriver.java <input file name>


getSingleParent(): runs in O(n), it's just inOrder traversal of the tree + printing values with single-child parent nodes
getNumLeafNodes(): runs in O(n), inOrder traversal of the tree + counting the number of nodes that have no children
getCousins(): runs in O(n), search through to find the specific node (logn), then does 3 traversals through the tree

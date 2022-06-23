public class BinarySearchTree {
    //=================================== Methods ====================================

    //--------------------------------- Constructor ----------------------------------
    public BinarySearchTree() {
        root = null;
    }

    //----------------------------------- Insert -------------------------------------
    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            size++;
        }
        else {
            TreeNode currentNode = root;
            while (currentNode != null) {
                if (val == currentNode.value) {
                    currentNode.freqCount++;
                    break;
                }
                else if (val < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new TreeNode(val);
                        break;
                    }
                    else {
                        currentNode = currentNode.left;
                    }
                }
                else if (val > currentNode.value) {
                    if (currentNode.right == null) {
                        currentNode.right = new TreeNode(val);
                        break;
                    }
                    else {
                        currentNode = currentNode.right;
                    }
                }
            }
            size++;
        }
    }

    //------------------------------------ find --------------------------------------
    public boolean find(int val) {
        boolean foundValue = false;
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (val == currentNode.value) {
                foundValue = true;
                break;
            }
            else if (val < currentNode.value) {
                currentNode = currentNode.left;
            }
            else if (val > currentNode.value) {
                currentNode = currentNode.right;
            }
        }
        return foundValue;
    }

    //----------------------------------- remove -------------------------------------
    public boolean remove(int val) {
        boolean removedNode = false;
        if (root != null) {
            TreeNode parent = root;
            TreeNode current = root;
            while (current != null) {
                if (val == current.value) {
                    if (current.freqCount > 1) {
                        current.freqCount--;
                        removedNode = true;
                        break;
                    }

                    TreeNode toDelete = current;
                    // Is leaf
                    if (toDelete.isLeaf()) {
                        if (toDelete.value < parent.value) {
                            parent.left = null;
                        }
                        else if (toDelete.value > parent.value) {
                            parent.right = null;
                        }
                    }

                    // One child to left
                    if (toDelete.left != null && toDelete.right == null) {
                        if (toDelete.value < parent.value) {
                            parent.left = toDelete.left;
                        }
                        else if (toDelete.value > parent.value) {
                            parent.right = toDelete.left;
                        }
                    }
                    // One child to right
                    if (toDelete.right != null && toDelete.left == null) {
                        if (toDelete.value < parent.value) {
                            parent.left = toDelete.right;
                        }
                        else if (toDelete.value > parent.value) {
                            parent.right = toDelete.right;
                        }
                    }

                    // Two children
                    if (toDelete.left != null && toDelete.right != null) {
                        
                    }

                    // Is root
                }
                else if (val < current.value) {
                    parent = current;
                    current = current.left;
                }
                else if (val > current.value) {
                    parent = current;
                    current = current.right;
                }
            }
        }
        return removedNode;
    }


    //---------------------------------- makeEmpty -----------------------------------
    public void makeEmpty() {
        root = null;
        size = 0;
    }

    //----------------------------------- isEmpty ------------------------------------
    public boolean isEmpty() {
        return (root == null);
    }

    //=============================== Internal Structs================================
    private class TreeNode {
        //-------- Methods ---------
        public TreeNode() {
            value = freqCount = 0;
            left = right = null;
        }

        public TreeNode(int val) {
            value = val;
            freqCount = 1;
            left = right = null;
        }

        public boolean isLeaf() {
            return (left == null && right == null);
        }
        //---------- Data ----------
        int value;
        int freqCount;
        TreeNode left;
        TreeNode right;
    }


    //================================= Member Data ==================================
    private TreeNode root;
    private int size;
}


//================================================================================
//--------------------------------------------------------------------------------
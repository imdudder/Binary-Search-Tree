public class BinarySearchTree {
    //=================================== Methods ====================================

    //--------------------------------- Constructor ----------------------------------
    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(BinarySearchTree toCopy) {
        root = null;
        this.setEqualTo(toCopy);
    }

    //----------------------------------- Insert -------------------------------------
    public void insert(int val) {
        insertMany(val, 1);
    }

    public void insertMany(int val, int numTimes) {
        if (root == null) {
            root = new TreeNode(val);
            size += numTimes;
        }
        else {
            TreeNode currentNode = root;
            while (currentNode != null) {
                if (val == currentNode.value) {
                    currentNode.freqCount += numTimes;
                    break;
                }
                else if (val < currentNode.value) {
                    if (currentNode.left == null) {
                        currentNode.left = new TreeNode(val);
                        currentNode.left.freqCount = numTimes;
                        break;
                    }
                    else {
                        currentNode = currentNode.left;
                    }
                }
                else if (val > currentNode.value) {
                    if (currentNode.right == null) {
                        currentNode.right = new TreeNode(val);
                        currentNode.right.freqCount = numTimes;
                        break;
                    }
                    else {
                        currentNode = currentNode.right;
                    }
                }
            }
            size += numTimes;
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
    public boolean remove(int valueToRemove) {
        TreeNode newRoot = removeHelper(valueToRemove, root);
        if (newRoot == null) {
            return false;
        }
        else {
            root = newRoot;
            size--;
            return true;
        }
    }

    private TreeNode removeHelper(int valueToRemove, TreeNode subroot) {
        if (subroot != null) {
            if (valueToRemove == subroot.value) {
                // Frequency is greater than 1
                if (subroot.freqCount > 1) {
                    subroot.freqCount--;
                    return subroot;
                }
                // Leaf
                else if (subroot.left == null && subroot.right == null) {
                    return null;
                }
                // One child (left)
                else if (subroot.left != null && subroot.right == null) {
                    return subroot.left;
                }
                // One child (right)
                else if (subroot.left == null && subroot.right != null) {
                    return subroot.right;
                }
                // Two children
                else if (subroot.left != null && subroot.right != null) {
                    TreeNode leftLink = subroot.right;
                    while (leftLink.left != null) {
                        leftLink = leftLink.left;
                    }
                    leftLink.left = subroot.left;
                    return subroot.right;
                }

            }
            else if (valueToRemove < subroot.value) {
                if (subroot.left == null) {
                    return null; // Value not found
                }
                else {
                    subroot.left = removeHelper(valueToRemove, subroot.left);
                    return subroot;
                }
            }
            else if (valueToRemove > subroot.value) {
                if (subroot.right == null) {
                    return null; // Value not found
                }
                else {
                    subroot.right = removeHelper(valueToRemove, subroot.right);
                    return subroot;
                }
            }
        }
        return null;
    }


    //------------------------------------ print -------------------------------------
    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(TreeNode subroot) {
        if (subroot != null) {
            System.out.print(subroot.value + " (" + subroot.freqCount + "), ");
            printPreOrder(subroot.left);
            printPreOrder(subroot.right);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(TreeNode subroot) {
        if (subroot != null) {
            printInOrder(subroot.left);
            System.out.print(subroot.value + " (" + subroot.freqCount + "), ");
            printInOrder(subroot.right);
        }
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    private void printPostOrder(TreeNode subroot) {
        if (subroot != null) {
            printPostOrder(subroot.left);
            printPostOrder(subroot.right);
            System.out.print(subroot.value + " (" + subroot.freqCount + "), ");
        }
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

    //--------------------------------- getParentOf ----------------------------------
    private TreeNode getParentOf(int val) {
        if (root == null || root.value == val) {
            return null;
        }
        TreeNode currentNode = root;
        while (currentNode != null) {
            if ((currentNode.left != null && currentNode.left.value == val) ||
                (currentNode.right != null && currentNode.right.value == val)) {
                break;  // Found child
            }
            else if (val < currentNode.value) {
                if (currentNode.left == null) {
                    break;  // Correct parent but child does not yet exist
                }
                currentNode = currentNode.left;
            }
            else if (val > currentNode.value) {
                if (currentNode.right == null) {
                    break; // Correct parent but child does not yet exist
                }
                currentNode = currentNode.right;
            }
        }
        return currentNode;
    }

    //=============================== Operator Methods ===============================

    //--------------------------------- isEqualTo ------------------------------------
    public boolean isEqualTo(BinarySearchTree otherTree) {
        boolean result = false;
        if (this.size == otherTree.size) {
            result = isEqualToHelper(this.root, otherTree.root);
        }
        return result;
    }

    private boolean isEqualToHelper(TreeNode thisNode, TreeNode otherNode) {
        if (thisNode == null && otherNode == null) {
            return true;    // Base case
        }
        else if (thisNode != null && otherNode != null && thisNode.value == otherNode.value) {
            if (isEqualToHelper(thisNode.left, otherNode.left)) {
                return isEqualToHelper(thisNode.right, otherNode.right);
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    //-------------------------------- isNotEqualTo ----------------------------------
    public boolean isNotEqualTo(BinarySearchTree otherBst) {
        return !(this.isEqualTo(otherBst));
    }


    //--------------------------------- setEqualTo -----------------------------------
    public void setEqualTo(BinarySearchTree otherTree) {
        this.makeEmpty();
        setEqualToHelper(otherTree.root);
    }

    private void setEqualToHelper(TreeNode nodeToCopy) {
        if (nodeToCopy != null) {
            this.insertMany(nodeToCopy.value, nodeToCopy.freqCount);
            setEqualToHelper(nodeToCopy.left);
            setEqualToHelper(nodeToCopy.right);
        }
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
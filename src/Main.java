public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = makeFullTree();
        boolean result = false;

        // Test Find
        result = bst.find(7);
        result = bst.find(3);
        result = bst.find(100);

        // Test Remove
        testEmptyRemoval();
        testLeafRemoval();
        testLeftChildOnlyCase();
        testRightChildOnlyCase();
        testTwoChildCase();
        testRootRemoval();

        // Test Comparison Operators
    }

    public static BinarySearchTree makeFullTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(5);
        bst.insert(3);
        bst.insert(10);
        bst.insert(9);
        bst.insert(11);
        return bst;
    }

    public static void testEmptyRemoval() {
        BinarySearchTree bst = new BinarySearchTree();
        boolean removedValue = bst.remove(7);
        if (!removedValue) {
            System.out.println("PASS - Empty Removal Test");
        }
        else {
            System.out.println("FAIL - empty removal test");
        }
    }

    public static void testLeafRemoval() {
        BinarySearchTree bst = makeFullTree();
        boolean removedValue = bst.remove(3);
        if (removedValue) {
            System.out.println("PASS - Leaf Removal Test");
        }
        else {
            System.out.println("FAIL - leaf removal");
        }
    }

    public static void testLeftChildOnlyCase() {
        BinarySearchTree bst = makeFullTree();
        bst.remove(5);
        if (bst.remove(4)) {
            System.out.println("PASS - Left Child Only Case");
        }
        else {
            System.out.println("FAIL - left child case");
        }
    }

    public static void testRightChildOnlyCase() {
        BinarySearchTree bst = makeFullTree();
        bst.remove(3);
        if (bst.remove(5)) {
            System.out.println("PASS - Right Child Only Case");
        }
        else {
            System.out.println("FAIL - right child case");
        }
    }

    public static void testTwoChildCase() {
        BinarySearchTree bst = makeFullTree();
        if (bst.remove(10)) {
            System.out.println("PASS - Two Child Case");
        }
        else {
            System.out.println("FAIL - two child case");
        }
    }

    public static void testRootRemoval() {
        BinarySearchTree bst = makeFullTree();
        if (bst.remove(7)) {
            System.out.println("PASS - Root Removal Test");
        }
        else {
            System.out.println("FAIL - root removal case");
        }
    }
}
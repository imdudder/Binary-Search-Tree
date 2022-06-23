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
        testDuplicateRemoval();

        // Test Comparison Operators
    }

    public static void printTestResults(String testName, boolean result, boolean expectedResult) {
        if (result == expectedResult) {
            System.out.println("PASS - " + testName);
        }
        else {
            System.out.println("FAIL - " + testName);
        }
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
        boolean result =  bst.remove(7);
        printTestResults("Empty Removal",result,false);
    }

    public static void testLeafRemoval() {
        BinarySearchTree bst = makeFullTree();
        boolean result = bst.remove(3);
        printTestResults("Leaf Removal", result, true);
    }

    public static void testLeftChildOnlyCase() {
        BinarySearchTree bst = makeFullTree();
        bst.remove(5);
        boolean result = bst.remove(4);
        printTestResults("Left Child Case", result, true);
    }

    public static void testRightChildOnlyCase() {
        BinarySearchTree bst = makeFullTree();
        bst.remove(3);
        boolean result = bst.remove(5);
        printTestResults("Right Child Case", result, true);
    }

    public static void testTwoChildCase() {
        BinarySearchTree bst = makeFullTree();
        boolean result = bst.remove(10);
        printTestResults("Two Child Case", result, true);
    }

    public static void testRootRemoval() {
        BinarySearchTree bst = makeFullTree();
        boolean result = bst.remove(7);
        printTestResults("Root Removal", result, true);
    }

    public static void testDuplicateRemoval() {
        BinarySearchTree bst = makeFullTree();
        bst.insert(7);
        bst.remove(7);
        boolean result = bst.find(7);
        printTestResults("Duplicate Removal", result, true);
    }
}
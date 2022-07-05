public class Main {
    public static void main(String[] args) {
        // Test Instantiation and Insertion
        BinarySearchTree bst = makeFullTree();
        printTestResults("Insert Elements Test", bst.size() == 7, true);

        // Test Find
        printTestResults("Find Root", bst.find(7), true);
        printTestResults("Find Leaf", bst.find(3), true);
        printTestResults("Find Middle Node", bst.find(10), true);
        printTestResults("Search Result Doesn't Exist", bst.find(100), false);

        // Test Print
        System.out.print("In Order: ");
        bst.printInOrder();
        System.out.print("\n");

        System.out.print("Pre Order: ");
        bst.printPreOrder();
        System.out.print("\n");

        System.out.print("Post Order: ");
        bst.printPostOrder();
        System.out.print("\n");

        // Test Remove
        testEmptyRemoval();
        testLeafRemoval();
        testLeftChildOnlyCase();
        testRightChildOnlyCase();
        testTwoChildCase();
        testRootRemoval();
        testDuplicateRemoval();

        // Test Assignment Operator
        testAssignment();

        // Test depth, height, diameter
        testDepthOfNodes();
        testHeight();

        bst.printLevels();
    }


    //================================== Unit Tests ==================================
    public static void printTestResults(String testName, boolean result, boolean expectedResult) {
        if (result == expectedResult) {
            System.out.println("PASS - " + testName);
        }
        else {
            System.out.println("FAIL - " + testName);
        }
    }

    public static void printTestResults(String testName, int result, int expectedResult) {
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

    public static BinarySearchTree makeImperfectTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(3);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(5);
        bst.insert(2);
        bst.insert(0);
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
        boolean result = bst.remove(4);
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

    public static void testAssignment() {
        BinarySearchTree toCopy = makeFullTree();
        BinarySearchTree toOverwrite = new BinarySearchTree();
        toOverwrite.setEqualTo(toCopy);
        printTestResults("Test Assignment", toCopy.isEqualTo(toOverwrite), true);
    }

    public static void testDepthOfNodes() {
        BinarySearchTree empty = new BinarySearchTree();
        printTestResults("Depth of empty Tree", empty.getDepth(0), -1);

        BinarySearchTree bst = makeFullTree();
        int depth = 0;
        depth = bst.getDepth(7);
        printTestResults("Depth of root", depth, 0);

        depth = bst.getDepth(4);
        printTestResults("Depth of level 2", depth, 1);

        depth = bst.getDepth(9);
        printTestResults("Depth of level 3", depth, 2);

        depth = bst.getDepth(999);
        printTestResults("Depth of node that isn't in tree", depth, -1);
    }

    public static void testHeight() {
        BinarySearchTree empty = new BinarySearchTree();
        int height = empty.getTreeHeight();
        printTestResults("Height of empty tree", height, -1);

        BinarySearchTree bst = makeImperfectTree();
        height = bst.getTreeHeight();
        printTestResults("Root Height", height, 3);

        height = bst.getHeight(5);
        printTestResults("Leaf Height", height, 0);

        height = bst.getHeight(4);
        printTestResults("Middle Node Height", height, 2);
    }
}
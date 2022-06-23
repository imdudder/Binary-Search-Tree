public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Test Insert
        bst.insert(7);
        bst.insert(4);
        bst.insert(5);
        bst.insert(3);
        bst.insert(10);
        bst.insert(7);
        bst.insert(3);
        bst.insert(9);
        bst.insert(11);

        // Test Print


        // Test Find
        bst.find(7);
        bst.find(3);
        bst.find(100);

        // Test Remove

        // Test Comparison Operators
    }
}
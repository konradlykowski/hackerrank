public class IsBinarySearchTree {

    static class Node {
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        int data;
        Node left;
        Node right;
    }

    static boolean checkBST(Node root) {
        return checkBinary(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    }

    static boolean checkBinary(int left, Node root, int right) {
        if (root == null) {
            return true;
        }
        if (root.data >= left && root.data <= right) {
            return checkBinary(left, root.left, root.data)
                    && checkBinary(root.data, root.right, right);
        } else {
            return false;
        }
    }
}

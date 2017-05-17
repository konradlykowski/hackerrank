import java.util.*;

public class LowestCommonAncestor {

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

    public static void main(String[] args) {
        Node a3 = new Node(3, null, null);
        Node a2 = new Node(2, null, null);

        Node a1 = new Node(1, a3, a2);
        Node a6 = new Node(6, null, null);

        Node a9 = new Node(9, null, null);
        Node a4 = new Node(4, a1, a6);

        Node a8 = new Node(8, a4, a9);

        System.out.println(lca(a8, 3, 2).data);
    }


    static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> path1 = new LinkedList();
        findPath(root, v1, path1);
        LinkedList<Node> path2 = new LinkedList();
        findPath(root, v2, path2);
        Node result = mergePaths(path1, path2);
        if (result == null) {
            return root;
        }
        return result;
    }

    static boolean findPath(Node root, int v1, LinkedList<Node> path) {
        if (root == null) {
            return false;
        }
        if (root.data == v1) {
            return true;
        }
        boolean res1 = findPath(root.left, v1, path);
        if (res1) {
            path.addLast(root.left);
            return true;
        }
        res1 = findPath(root.right, v1, path);
        if (res1) {
            path.addLast(root.right);
            return true;
        }
        return false;
    }

    static Node mergePaths(LinkedList<Node> path1, LinkedList<Node> path2) {
        Iterator<Node> path1iter = path1.iterator();
        while (path1iter.hasNext()) {
            Node current = path1iter.next();
            if (path2.contains(current)) {// O(n)!
                return current;
            }
        }
        return null;
    }
}

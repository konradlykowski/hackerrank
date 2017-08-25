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


    static Node lca(Node n, int v1, int v2) {
        while(n!=null)
        {
            if(v1>n.data && v2>n.data) n=n.right;
            else if(v1<n.data && v2<n.data) n=n.left;
            else return n;
        }
        return n;
    }
}

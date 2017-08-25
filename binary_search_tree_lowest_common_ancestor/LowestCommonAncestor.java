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

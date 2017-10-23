import java.util.*;

public class TreesJennysSubtrees {

    static Map<Integer, Node> nodes = new HashMap<>();

    static class Node {
        final int data;

        public Node(int data) {
            this.data = data;

        }

        public List<Integer> children = new LinkedList<>();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        for (int a0 = 0; a0 < n - 1; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if (!nodes.containsKey(x)) {
                nodes.put(x, new Node(x));
            }
            if (!nodes.containsKey(y)) {
                nodes.put(y, new Node(y));
            }
            nodes.get(x).children.add(y);
            nodes.get(y).children.add(x);
        }
        System.out.println(findSubtrees(r));
    }

    static int findSubtrees(int r) {
        List<Set<Integer>> ints = new ArrayList();
        for (Integer start : nodes.keySet()) {
            TreeSet visited = new TreeSet();
            LinkedList<Integer> edges = new LinkedList();
            dfs(start, 0, r, visited, edges);
            ints.add(visited);
        }
        return ints.size();
    }


    static void dfs(Integer node, int r, int maxR, Set<Integer> visited, LinkedList<Integer> edges) {
        visited.add(node);
        if (r == maxR) {
            return;
        }
        edges.add(nodes.get(node).children.size());
        for (Integer children : nodes.get(node).children) {
            if (!visited.contains(children)) {
                dfs(children, r + 1, maxR, visited, edges);
            }
        }
    }
}

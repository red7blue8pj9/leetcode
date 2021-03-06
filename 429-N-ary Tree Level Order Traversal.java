import java.util.*;

class NaryTreeLevelOrderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // Recursive
    public List<List<Integer>> levelOrder(Node root) {
        return getLevelOrder(root, 0, new ArrayList<>());
    }

    private List<List<Integer>> getLevelOrder(Node node, int level, List<List<Integer>> orderList) {
        if (node == null) {
            return orderList;
        }
        List<Integer> levelList;
        if (orderList.size() > level) {
            levelList = orderList.get(level);
        } else {
            levelList = new ArrayList<>();
        }
        levelList.add(node.val);
        if (orderList.size() <= level) {
            orderList.add(levelList);
        }
        for (Node n : node.children) {
            getLevelOrder(n, level + 1, orderList);
        }
        return orderList;
    }

    // Iterative
    public List<List<Integer>> levelOrderI(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                for (Node c : curr.children)
                    queue.offer(c);
            }
            ret.add(curLevel);
        }
        return ret;
    }
}
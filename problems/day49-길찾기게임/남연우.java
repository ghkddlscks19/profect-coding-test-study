import java.util.*;

class Solution {
    static class Node {
        int x, y, idx;
        Node left, right;
        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
    
    void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) 
                parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) 
                parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    void preorder(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.idx);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    void postorder(Node node, List<Integer> list) {
        if (node == null) return;
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.idx);
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];
        
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        
        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) 
                return a.x - b.x;
            return b.y - a.y;
        });
        
        Node root = nodes[0];
        for (int i = 1; i < n; i++) insert(root, nodes[i]);
        
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preorder(root, pre);
        postorder(root, post);
        
        int[][] result = new int[2][n];
        for (int i = 0; i < n; i++) 
            result[0][i] = pre.get(i);
        
        for (int i = 0; i < n; i++) 
            result[1][i] = post.get(i);
        
        return result;
    }
}

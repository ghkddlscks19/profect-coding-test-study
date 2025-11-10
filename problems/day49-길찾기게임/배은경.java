import java.util.*;

class Solution {
    static class Node {
        int x, y, num;
        Node left;
        Node right;
        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nodeinfo[i][0];
            arr[i][1] = nodeinfo[i][1];
            arr[i][2] = i + 1;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) 
                return a[0] - b[0];
            return b[1] - a[1];
        });

        Node root = new Node(arr[0][0], arr[0][1], arr[0][2]);
        for (int i = 1; i < n; i++) {
            insert(root, new Node(arr[i][0], arr[i][1], arr[i][2]));
        }

        preorder(root);
        postorder(root);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
    }

    private void insert(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }

    private void preorder(Node node) {
        if (node == null) return;
        pre.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        post.add(node.num);
    }
}

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

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        // y 내림차순, x 오름차순 정렬
        nodes.sort((a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });

        // 첫 번째 노드를 루트로 설정
        Node root = nodes.get(0);

        // 나머지 노드 삽입
        for (int i = 1; i < n; i++) {
            insertNode(root, nodes.get(i));
        }

        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        preorder(root, preorder);
        postorder(root, postorder);

        return new int[][] {
            preorder.stream().mapToInt(Integer::intValue).toArray(),
            postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    private void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    private void preorder(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.idx);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    private void postorder(Node node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.idx);
    }
}

import java.util.*;
class Solution {
    static List<Node> nodes = new ArrayList<>(); // 노드 리스트
    static List<Integer> preOrders = new ArrayList<>(); // 전위 순회 결과 리스트
    static List<Integer> postOrders = new ArrayList<>(); // 후위 순회 결과 리스트
    public int[][] solution(int[][] nodeinfo) {
        int num = 1;
        for(int[] n: nodeinfo) {
            int x = n[0];
            int y = n[1];
            nodes.add(new Node(num++, x, y));
        }
        
        // 정렬
        Collections.sort(nodes, (a, b) -> {
            // y가 같으면 x 오름차순
            if(a.y == b.y) return a.x - b.x;
            return b.y - a.y; // y 내림차순
        });
        
        Node root = nodes.get(0);
        
        for(int i =1; i<nodes.size(); i++) {
            Node child = nodes.get(i);
            insertNode(root, child);
        }
        
        preOrder(root);
        postOrder(root);
        
        int[][] answer = new int[2][];
        answer[0] = preOrders.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrders.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    void insertNode(Node parent, Node child) {
        // 자식이 부모 왼쪽
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    void preOrder(Node node) {
        if(node == null) return;
        
        preOrders.add(node.num);
        preOrder(node.left);
        preOrder(node.right);
    }
    
    void postOrder(Node node) {
        if(node == null) return;
        
        postOrder(node.left);
        postOrder(node.right);
        postOrders.add(node.num);
    }
    
    class Node {
        int num, x, y;
        Node left;
        Node right;
        
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
}
